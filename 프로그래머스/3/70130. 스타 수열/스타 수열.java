import java.util.*;

class Solution {
    public int solution(int[] a) {
        int n = a.length;
        if(n <= 1) return 0;
        
        Map<Integer, Integer> counts = new HashMap<>();
        
        for(int x : a){
            counts.put(x, counts.getOrDefault(x, 0) + 1);
        }
        
        List<Integer> keys = new ArrayList<>(counts.keySet());
        keys.sort((t, k) -> counts.get(k) - counts.get(t));
        
        
        int max = 0;
        for(int x : keys){
            int i = 0;
            int cnt = 0;
            
            if(counts.get(x) * 2 <= max) continue;
            
            while(i < n-1){
                if(a[i] != a[i+1] && (a[i] == x || a[i+1] == x)){
                    i += 2;
                    cnt++;
                } else {
                    i += 1;
                }   
            }
            max = Math.max(max, cnt*2);
        }
        
        return max;
    }
}

// int[] a = {1,1,1,1,2,3,2,3,2,3};