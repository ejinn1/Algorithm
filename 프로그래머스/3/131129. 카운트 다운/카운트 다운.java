import java.util.*;

class Solution {
    public int[] solution(int target) {
        int[] dpD = new int[target + 1];
        int[] dpS = new int[target + 1];
        
        Arrays.fill(dpD, Integer.MAX_VALUE / 4);

        dpD[0] = 0;
        dpS[0] = 0;
        
        List<int[]> shots = new ArrayList<>();
        
        for(int i=1 ; i<=20 ; i++) shots.add(new int[]{i, 1});
        shots.add(new int[]{50, 1});
        for(int i=1 ; i<=20 ; i++) shots.add(new int[]{i*2, 0});
        for(int i=1 ; i<=20 ; i++) shots.add(new int[]{i*3, 0});
        
        for(int i=1 ; i<=target ; i++){
            for(int[] shot : shots){
                int score = shot[0];
                int cnt = shot[1];
                
                if(i - score < 0) continue;
                
                int canD = dpD[i - score] + 1;
                int canS = dpS[i - score] + cnt;
                
                if(canD < dpD[i]){
                    dpD[i] = canD;
                    dpS[i] = canS;
                } else if(canD == dpD[i] && canS > dpS[i]){
                    dpS[i] = canS;
                }
            }
        }
        
        return new int[]{dpD[target], dpS[target]};
    }
}