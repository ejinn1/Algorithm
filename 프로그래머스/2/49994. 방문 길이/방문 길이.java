import java.util.*;

class Solution {
    public int solution(String dirs) {
        int x = 0;
        int y = 0;
        
        Set<String> visited = new HashSet<>();
        
        int cnt = 0;
        
        for(char dir : dirs.toCharArray()){
            int nx = x;
            int ny = y;
            
            if(dir == 'U') ny++;
            else if(dir == 'D') ny--;
            else if(dir == 'R') nx++;
            else if(dir == 'L') nx--;
            
            if(nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;
            
            String key1 = x + "," + y + ":" + nx + "," + ny;
            String key2 = nx + "," + ny + ":" + x + "," + y;
            if(!visited.contains(key1)){
                visited.add(key1);
                visited.add(key2);
                cnt++;
            }
            
            x = nx;
            y = ny;
        }
        
        return cnt;
    }
}