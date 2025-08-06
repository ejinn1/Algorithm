import java.util.Scanner;

public class Main {
    static boolean[][] visited;
    static int N;
    static int[][] ground;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static void dfs(int x, int y, int h){
        visited[x][y] = true;

        for(int dir=0 ; dir<4 ; dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                if(!visited[nx][ny] && ground[nx][ny] > h){
                    dfs(nx, ny, h);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        ground = new int[N][N];
        int maxH = 0;
        int result = 0;

        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                ground[i][j] = sc.nextInt();
                if(ground[i][j] > maxH) maxH = ground[i][j];
            }
        }

        for(int h=0 ; h<=maxH ; h++){
            visited = new boolean[N][N];
            int count = 0;

            for(int i=0 ; i<N ; i++){
                for(int j=0 ; j<N ; j++){
                    if(!visited[i][j] && ground[i][j] > h){
                        dfs(i, j, h);
                        count++;
                    }
                }
            }

            if(count > result) result = count;
        }

        System.out.println(result);
    }
}