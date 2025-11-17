import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();

    int[] tems = new int[N];

    for (int i = 0; i < N; i++) {
      tems[i] = sc.nextInt();
    }


    int t = 0;
    int cur = 0;
    for (int i = 0; i < K; i++) {
      cur += tems[i];
    }
    int sum = cur;
    while (t < N - K) {
      cur -= tems[t];
      cur += tems[t + K];
      if(cur > sum) sum = cur;
      t++;
    }

    System.out.println(sum);

  }
}