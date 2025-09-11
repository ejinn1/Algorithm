

import java.util.HashMap;
import java.util.Scanner;

public class Main {
  static HashMap<Long, Long> A = new HashMap<>();
  static  long P, Q;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long N = sc.nextLong();
    P = sc.nextLong();
    Q = sc.nextLong();

    A.put(0L, 1L);

    System.out.println(solve(N));
  }

  static long solve(long n) {
    if (A.containsKey(n)) {
      return A.get(n);
    }

    long val = solve(n / P) + solve(n / Q);
    A.put(n, val);
    return val;
  }
}
