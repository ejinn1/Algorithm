import java.util.Scanner;

public class Main {
  static int[] arr;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    arr = new int[N+1];

    for (int i = 1; i <= N; i++) arr[i] = sc.nextInt();

    int K = sc.nextInt();

    for (int i = 0; i < K; i++) {
      int std = sc.nextInt();
      int num = sc.nextInt();

      if(std == 1){
        for (int j = 1; j <= N; j++) {
          if (j % num == 0) {
            change(j);
          }
        }
      } else if (std == 2) {
        change(num);
        for (int j = 1; j < N / 2; j++) {
          if(num + j > N || num - j <= 0) break;
          if(arr[num + j] != arr[num - j]) break;
          change(num + j);
          change(num - j);
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= N; i++) {
      sb.append(arr[i])
              .append(" ");
      if(i % 20 == 0) sb.append("\n");
    }

    System.out.println(sb);
  }

  static void change(int idx) {
    arr[idx] = arr[idx] == 1 ? 0 : 1;
  }
}