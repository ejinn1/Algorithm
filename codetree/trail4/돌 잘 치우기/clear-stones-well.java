import java.util.*;

public class Main {
    static int N, K, M;
    static List<int[]> stones;
    static int[][] arr;
    static int[][] starts;
    static int max = 0;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N][N];
        stones = new ArrayList<int[]>();
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                int c = sc.nextInt();
                if(c == 1){
                    stones.add(new int[]{i, j});
                }
                arr[i][j] = c;
            }
        }

        starts = new int[K][2];
        for(int i=0 ; i<K ; i++){
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            starts[i] = new int[]{r, c};
        }

        choose(0, 0);

        System.out.print(max);
    }

    static void choose(int start, int cnt) {
        if (cnt == M) {
            bfs();
            return;
        }

        for (int i = start; i < stones.size(); i++) {
            int x = stones.get(i)[0];
            int y = stones.get(i)[1];
            arr[x][y] = 0;
            choose(i + 1, cnt + 1);
            arr[x][y] = 1;
        }
    }

    static void bfs(){
        int cnt = 0;
        boolean[][] visited = new boolean[N][N];

        Queue<int[]> q = new ArrayDeque<>();
        for(int[] start : starts){
            int x = start[0];
            int y = start[1];
            visited[x][y] = true;
            q.add(new int[]{x, y});
            cnt++;
        }

        while(!q.isEmpty()){
            int cur[] = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int d=0 ; d<4 ; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(visited[nx][ny]) continue;
                if(arr[nx][ny] == 1) continue;

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
                cnt++;
            }
        }

        max = Math.max(max, cnt);
    }
}