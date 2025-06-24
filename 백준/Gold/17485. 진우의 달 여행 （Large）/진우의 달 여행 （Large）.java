import java.util.*;

public class Main {
    static final int INF = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 행
        int M = sc.nextInt(); // 열

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) { // 연료 소비량 입력
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // dp[y][x][dir]: y행 x열에 dir 방향(0:왼, 1:직진, 2:오른)으로 도착한 최소 연료
        int[][][] dp = new int[N][M][3];
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                Arrays.fill(dp[y][x], INF); // 큰 값으로 초기화
            }
        }

        // 첫 번째 줄 초기화
        for (int x = 0; x < M; x++) {
            for (int dir = 0; dir < 3; dir++) {
                dp[0][x][dir] = map[0][x];
            }
        }

        // 방향 벡터: 왼쪽 아래(-1), 아래(0), 오른쪽 아래(+1)
        int[] dx = {-1, 0, 1};

        // DP 전이
        for (int y = 1; y < N; y++) {
            for (int x = 0; x < M; x++) {
                for (int dir = 0; dir < 3; dir++) {
                    int prevX = x - dx[dir]; // 이전 x좌표

                    if (prevX < 0 || prevX >= M) continue;

                    for (int prevDir = 0; prevDir < 3; prevDir++) {
                        if (prevDir == dir) continue; // 같은 방향 연속 금지

                        dp[y][x][dir] = Math.min(dp[y][x][dir], dp[y-1][prevX][prevDir] + map[y][x]);
                    }
                }
            }
        }

        // 마지막 줄에서 최소 연료값 찾기
        int answer = INF;
        for (int x = 0; x < M; x++) {
            for (int dir = 0; dir < 3; dir++) {
                answer = Math.min(answer, dp[N-1][x][dir]);
            }
        }

        System.out.println(answer);
    }
}
