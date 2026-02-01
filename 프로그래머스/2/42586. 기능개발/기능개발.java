import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int N = progresses.length;
        int[] days = new int[N];
        
        for(int i=0 ; i<N ; i++){
            int rest = 100 - progresses[i];
            int day = (rest + speeds[i] - 1) / speeds[i];
            days[i] = day;
        }
        
        List<Integer> result = new ArrayList<>();
        
        int max = days[0];
        int cnt = 1;
        for(int i=1 ; i<N ; i++){
            if(days[i] > max){
                result.add(cnt);
                max = days[i];
                cnt = 1;
            } else {
                cnt++;
            }
        }
        result.add(cnt);
        
        int[] ans = new int[result.size()];
        for(int i=0 ; i<result.size() ; i++){
            ans[i] = result.get(i);
        }
        
        return ans;
    }
}