import java.util.*;

public class Main {
  static boolean[] broken = new boolean[10];

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    for (int i = 0; i < M; i++) {
      broken[sc.nextInt()] = true;
    }

    int answer = Math.abs(N - 100);

    for (int i = 0; i <= 1_000_000; i++) {
      if (canPress(i)) {
        int press = digitCount(i) + Math.abs(N - i);
        answer = Math.min(answer, press);
      }
    }

    System.out.println(answer);
  }

  static boolean canPress(int x) {
    if (x == 0) return !broken[0];

    while (x > 0) {
      if (broken[x % 10]) return false;
      x /= 10;
    }
    return true;
  }

  static int digitCount(int x) {
    if (x == 0) return 1;
    return (int) Math.log10(x) + 1;
  }
}
