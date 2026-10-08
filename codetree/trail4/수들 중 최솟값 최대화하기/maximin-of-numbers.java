import java.util.Scanner;

public class Main {
    static int n;
    static int[][] grid;
    static boolean[] used;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        grid = new int[n][n];
        used = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        dfs(0, Integer.MAX_VALUE);

        System.out.println(answer);
    }

    static void dfs(int row, int minValue) {
        if (row == n) {
            answer = Math.max(answer, minValue);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (used[col]) continue;

            used[col] = true;
            dfs(row + 1, Math.min(minValue, grid[row][col]));
            used[col] = false;
        }
    }
}