import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();

    int[] censors = new int[N];
    for (int i = 0; i < N; i++) {
      censors[i] = sc.nextInt();
    }

    Arrays.sort(censors);
    int[] dist = new int[N - 1];
    for (int i = 0; i < N - 1; i++) {
      dist[i] = censors[i + 1] - censors[i];
    }

    Arrays.sort(dist);
    int sum = 0;
    for (int i = 0; i < N - K; i++) {
      sum += dist[i];
    }

    System.out.println(K >= N ? 0 : sum);
  }
}