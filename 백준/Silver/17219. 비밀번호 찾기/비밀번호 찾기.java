import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    sc.nextLine();

    Map<String, String> password = new HashMap<>();

    for (int i = 0; i < N; i++) {
      String[] inputs = sc.nextLine().split(" ");
      password.put(inputs[0], inputs[1]);
    }

    for (int i = 0; i < M; i++) {
      String key = sc.nextLine();
      System.out.println(password.get(key));
    }
  }
}