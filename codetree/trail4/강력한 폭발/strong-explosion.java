import java.util.*;

public class Main {
    static int N;
    static int[][][] bombs;
    static int[][] arr;
    static int[][] sum;
    static List<int[]> check;
    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        arr = new int[N][N];
        sum = new int[N][N];
        check = new ArrayList<>();

        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                int num = sc.nextInt();
                arr[i][j] = num;
                if(num == 1){
                    check.add(new int[]{i, j});
                }
            }
        }

        bombs = new int[4][4][2];
        bombs[1] = new int[][]{{-1, 0}, {-2, 0}, {1, 0}, {2, 0}};
        bombs[2] = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        bombs[3] = new int[][]{{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        dfs(0);

        System.out.print(max);
    }

    static void dfs(int idx) {
        if (idx == check.size()) {
            max = Math.max(max, countBombed());
            return;
        }

        int[] c = check.get(idx);
        int x = c[0];
        int y = c[1];

        for (int b = 1; b <= 3; b++) {
            setBomb(x, y, b, 1);
            dfs(idx + 1);
            setBomb(x, y, b, -1);
        }
    }

    static void setBomb(int x, int y, int b, int value) {
        // 폭탄이 놓인 중심 칸
        sum[x][y] += value;

        // 폭탄 범위
        for (int[] d : bombs[b]) {
            int nx = x + d[0];
            int ny = y + d[1];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

            sum[nx][ny] += value;
        }
    }

    static int countBombed() {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (sum[i][j] > 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}