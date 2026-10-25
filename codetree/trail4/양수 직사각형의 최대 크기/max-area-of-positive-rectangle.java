import java.util.*;

public class Main {
    static int n, m;
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int ans = -1;

        // 직사각형의 위쪽, 아래쪽, 왼쪽, 오른쪽 경계를 정한다.
        for (int top = 0; top < n; top++) {
            for (int bottom = top; bottom < n; bottom++) {
                for (int left = 0; left < m; left++) {
                    for (int right = left; right < m; right++) {
                        if(isAllPositive(top, bottom, left, right)){
                            int h = bottom - top + 1;
                            int w = right - left + 1;
                            ans = Math.max(ans, h * w);
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }

    static boolean isAllPositive(int top, int bottom, int left, int right){
        for(int i=top ; i<=bottom ; i++){
            for(int j=left ; j<=right ; j++){
                if(grid[i][j] <= 0){
                    return false;
                }
            }
        }

        return true;
    }
}