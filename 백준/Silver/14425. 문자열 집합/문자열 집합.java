import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    sc.nextLine();

    Set<String> set = new HashSet<>();
    for (int i = 0; i < N; i++) {
      set.add(sc.nextLine());
    }

    int result = 0;
    for (int i = 0; i < M; i++) {
      String check = sc.nextLine();
      if (set.contains(check)) {
        result++;
      }
    }

    System.out.println(result);
  }
}