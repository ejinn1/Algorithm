class Solution {
    static final int MOD = 20170805;
    static final int DOWN = 0;
    static final int RIGHT = 1;

    public int solution(int m, int n, int[][] cityMap) {
        int[][][] dp = new int[m][n][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cityMap[i][j] == 1) continue;

                if (i == 0 && j == 0) {
                    if (i + 1 < m && cityMap[i + 1][j] != 1) {
                        dp[i + 1][j][DOWN] = 1;
                    }

                    if (j + 1 < n && cityMap[i][j + 1] != 1) {
                        dp[i][j + 1][RIGHT] = 1;
                    }

                    continue;
                }

                // 아래로 이동
                if (i + 1 < m && cityMap[i + 1][j] != 1) {
                    if (cityMap[i][j] == 2) {
                        dp[i + 1][j][DOWN] += dp[i][j][DOWN];
                    } else {
                        dp[i + 1][j][DOWN] += dp[i][j][DOWN] + dp[i][j][RIGHT];
                    }

                    dp[i + 1][j][DOWN] %= MOD;
                }

                // 오른쪽으로 이동
                if (j + 1 < n && cityMap[i][j + 1] != 1) {
                    if (cityMap[i][j] == 2) {
                        dp[i][j + 1][RIGHT] += dp[i][j][RIGHT];
                    } else {
                        dp[i][j + 1][RIGHT] += dp[i][j][DOWN] + dp[i][j][RIGHT];
                    }

                    dp[i][j + 1][RIGHT] %= MOD;
                }
            }
        }

        return (dp[m - 1][n - 1][DOWN] + dp[m - 1][n - 1][RIGHT]) % MOD;
    }
}