import java.util.*;

class Solution {
    public int solution(String[][] book_time) {        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        
        for (String[] times : book_time) {
            int start = toMinute(times[0]);
            int end = toMinute(times[1]) + 10;

            // start, end 사용
            pq.add(new int[]{start, end});
        }
        
        
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        int max = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            
            if(rooms.isEmpty()){
                rooms.add(cur[1]);
                continue;
            }
            
            int prev = rooms.poll();
            
            if(prev <= cur[0]){
                rooms.add(cur[1]);
            } else {
                rooms.add(prev);
                rooms.add(cur[1]);
            }
            
            if(rooms.size() > max){
                max = rooms.size();
            }
            
        }
        
        return max == 0 ? 1 : max;
        
    }
    
    static int toMinute(String time) {
        String[] t = time.split(":");
        int hour = Integer.parseInt(t[0]);
        int minute = Integer.parseInt(t[1]);
        
        return hour * 60 + minute;
    }

}