import java.util.*;

class Solution {
    static int[][] arr;
    static int[][] check;
    static int h;
    static int n;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] land, int height) {
        arr = land;
        h = height;
        n = land[0].length;
        check = new int[n][n];
        
        int cnt = 0;
        visited = new boolean[n][n];
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                if(!visited[i][j]){
                    cnt++;
                    bfs(i, j, cnt);
                }
            }
        }
        
        Map<String, Integer> best = new HashMap<>();
        int INF = Integer.MAX_VALUE;
        
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                
                if(j+1 < n){
                    int a = check[i][j];
                    int b = check[i][j + 1];
                    if(a != b){
                        int cost = Math.abs(arr[i][j] - arr[i][j+1]);
                        int u = Math.min(a, b);
                        int v = Math.max(a, b);
                        String key = u + "," + v;
                        best.put(key, Math.min(best.getOrDefault(key, INF), cost));
                    }
                }
                    
                if(i+1 < n){
                    int a = check[i][j];
                    int b = check[i+1][j];
                    if(a != b){
                        int cost = Math.abs(arr[i][j] - arr[i+1][j]);
                        int u = Math.min(a, b);
                        int v = Math.max(a, b);
                        String key = u + "," + v;
                        best.put(key, Math.min(best.getOrDefault(key, INF), cost));
                    }
                }
            }
        }
        
        List<int[]>[] adj = new ArrayList[cnt + 1];
        for (int i = 1; i <= cnt; i++) adj[i] = new ArrayList<>();

        for (Map.Entry<String, Integer> e : best.entrySet()) {
            String key = e.getKey();
            String[] parts = key.split(",");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            int w = e.getValue();

            adj[u].add(new int[]{v, w});
            adj[v].add(new int[]{u, w});
        }
        
        boolean[] used = new boolean[cnt + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // pq 원소: {cost, node}
        pq.add(new int[]{0, 1});

        long ans = 0;
        int picked = 0;

        while (!pq.isEmpty() && picked < cnt) {
            int[] cur = pq.poll();
            int cost = cur[0];
            int node = cur[1];

            if (used[node]) continue;

            used[node] = true;
            ans += cost;
            picked++;

            for (int[] nx : adj[node]) {
                int next = nx[0];
                int w = nx[1];
                if (!used[next]) pq.add(new int[]{w, next});
            }
        }

        return (int) ans;
    }
    
    static void bfs(int x, int y, int num){
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            check[cx][cy] = num;
            visited[cx][cy] = true;
            
            for(int d=0 ; d<4 ; d++){
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(visited[nx][ny]) continue;
                if(Math.abs(arr[cx][cy] - arr[nx][ny]) > h) continue;
                    
                q.add(new int[]{nx, ny});
                visited[nx][ny] = true;
                check[nx][ny] = num;
            }
        }
    }
    
//     static void connect(){
        
//     }
}