import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N][M];
        int iceCnt = 0;

        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                arr[i][j] = sc.nextInt();

                if(arr[i][j] == 1) iceCnt++;
            }
        }

        int time = 0;
        int ans = 0;

        while(iceCnt > 0){
            ans = iceCnt;

            Queue<int[]> waterQ = new ArrayDeque<>();
            Queue<int[]> iceQ = new ArrayDeque<>();

            boolean[][] visited = new boolean[N][M];

            waterQ.offer(new int[]{0, 0});
            visited[0][0] = true;

            while(!waterQ.isEmpty()){
                int[] cur = waterQ.poll();
                int x = cur[0];
                int y = cur[1];

                for(int d=0 ; d<4 ; d++){
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if(visited[nx][ny]) continue;

                    visited[nx][ny] = true;

                    if(arr[nx][ny] == 0){
                        waterQ.offer(new int[]{nx, ny});
                    } else {
                        iceQ.offer(new int[]{nx, ny});
                    }
                }
            }

            while(!iceQ.isEmpty()){
                int[] cur = iceQ.poll();
                int x = cur[0];
                int y = cur[1];

                arr[x][y] = 0;
                iceCnt--;
            }

            time++;
        }

        System.out.print(time + " " + ans);
        
    }
}