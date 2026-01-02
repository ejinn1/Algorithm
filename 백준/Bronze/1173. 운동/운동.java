import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int m = sc.nextInt();
    int M = sc.nextInt();
    int T = sc.nextInt();
    int R = sc.nextInt();

    int X = m;
    int t = 0;
    int wt = 0;
    
    if(X + T > M) {
      System.out.println(-1);
      return;
    }
    
    while (wt < N) {
      if (X + T <= M) {
        X += T;
        wt++;
      } else if (X - R >= m) {
        X -= R;
      } else {
        X = m;
      }
      t++;
    }

    System.out.println(t);
  }
}