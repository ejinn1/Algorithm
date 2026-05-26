import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        int max = 0;
        for(int t : times){
            max = Math.max(max, t);
        }
        
        long left = 0;
        long right = (long) max * n;
        answer = right;
        
        while(left <= right){
            long mid = (long) (left + right) / 2;
            
            // mid 시간 내에 처리 가능한 총 인원수 계산
            long count = 0;
            
            for(int t : times){
                count += mid / t;
                
                if(count >= n){
                    break;
                }
            }
            
            // long count = Arrays.stream(times).mapToLong(i -> mid / i).sum();
            
            if(count < n){
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }
        
        
        return answer;
    }
}