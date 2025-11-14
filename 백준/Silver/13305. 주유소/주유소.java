import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    long[] dist = new long[N - 1];
    long[] costs = new long[N];

    for (int i = 0; i < N - 1; i++) {
      dist[i] = sc.nextInt();
    }
    for (int i = 0; i < N; i++) {
      costs[i] = sc.nextInt();
    }

    long minPrice = Integer.MAX_VALUE;
    long total = 0;
    for (int i = 0; i < N - 1; i++) {
      minPrice = Math.min(minPrice, costs[i]);
      total += minPrice * dist[i];
    }

    System.out.println(total);
  }
}