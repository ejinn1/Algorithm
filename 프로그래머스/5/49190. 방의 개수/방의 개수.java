import java.util.*;

class Solution {
    public int solution(int[] arrows) {
        int answer = 0;
        
        Set<String> nodes = new HashSet<>();
        Set<String> edges = new HashSet<>();
        
        nodes.add("0,0");
        
        int x = 0;
        int y = 0;
        
        int[] dx = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
        
        for(int arrow : arrows){
            for(int step=0 ; step<2 ; step++){
                int nx = x + dx[arrow];
                int ny = y + dy[arrow];

                String nextNode = nx + "," + ny;
                String edge = x + "," + y + "->" + nx + "," + ny;
                String reversedEdge = nx + "," + ny + "->" + x + "," + y;

                if(nodes.contains(nextNode) && !edges.contains(edge)){
                    answer++;
                }

                nodes.add(nextNode);
                edges.add(edge);
                edges.add(reversedEdge);

                x = nx;
                y = ny;   
            }
        }
        
        return answer;
    }
}