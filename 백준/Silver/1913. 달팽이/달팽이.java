

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int target = sc.nextInt();

        int[][] arr = new int[N][N];

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int x = N / 2;
        int y = N / 2;
        int value = 1;
        arr[x][y] = value;

        int len = 1;
        int targetX = x;
        int targetY = y;

        while (value < N * N) {
            for (int d = 0; d < 4; d++) {
                for (int i = 0; i < len; i++) {
                    if (value >= N * N) {
                        break;
                    }

                    x += dx[d];
                    y += dy[d];
                    value++;
                    arr[x][y] = value;

                    if (value == target) {
                        targetX = x;
                        targetY = y;
                    }
                }
                if (d % 2 == 1) {
                    len++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println((targetX + 1) + " " + (targetY + 1));
    }

}
