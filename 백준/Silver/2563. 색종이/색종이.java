

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[][] board = new int[100][100];
    int sum = 0;

    for (int i = 0; i < N; i++) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      for (int t = x; t < x + 10; t++) {
        for (int k = y; k < y + 10; k++) {
          if (board[t][k] != 1) {
            board[t][k] = 1;
            sum++;
          }
        }
      }
    }

    System.out.println(sum);


  }
}
