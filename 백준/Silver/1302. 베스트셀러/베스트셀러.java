import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    sc.nextLine();

    Map<String, Integer> map = new TreeMap<>();
    for (int i = 0; i < N; i++) {
      String str = sc.nextLine();
      map.put(str, map.getOrDefault(str, 0) + 1);
    }

    int max = 0;
    String result = "";

    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      if (entry.getValue() > max) {
        max = entry.getValue();
        result = entry.getKey();
      }
    }

    System.out.println(result);
  }
}