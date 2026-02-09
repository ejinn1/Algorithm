import java.util.*;

class Solution {
    public int solution(int[] cookie) {
        int n = cookie.length;
        int res = 0;
        
        for(int mid=0 ; mid<n-1 ; mid++){
            int L = mid;
            int R = mid + 1;
            
            int leftSum = cookie[L];
            int rightSum = cookie[R];
            
            while(true){
                if(leftSum == rightSum){
                    res = Math.max(res, leftSum);

                    if(L == 0 || R == n-1) break;
                    L--;
                    R++;
                    leftSum += cookie[L];
                    rightSum += cookie[R];
                } else if(leftSum < rightSum){
                    if(L == 0) break;
                    L--;
                    leftSum += cookie[L];
                } else {
                    if(R == n-1) break;
                    R++;
                    rightSum += cookie[R];
                }   
            }
        }
        
        return res;
    }
}