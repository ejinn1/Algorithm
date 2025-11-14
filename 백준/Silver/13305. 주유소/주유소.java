import java.util.Scanner;

public class Main {
  static class Edge {
    int v, w;

    public Edge(int v, int w) {
      this.v = v;
      this.w = w;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] dist = new int[N - 1];
    int[] costs = new int[N];

    for (int i = 0; i < N - 1; i++) {
      dist[i] = sc.nextInt();
    }
    for (int i = 0; i < N; i++) {
      costs[i] = sc.nextInt();
    }

    int minPrice = Integer.MAX_VALUE;
    int total = 0;
    for (int i = 0; i < N - 1; i++) {
      minPrice = Math.min(minPrice, costs[i]);
      total += minPrice * dist[i];
    }

    System.out.println(total);
  }
}