

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    sc.nextLine();

    Set<String> nameSet = new HashSet<>();

    for (int i = 0; i < N; i++) {
      nameSet.add(sc.nextLine());
    }

    List<String> names = new ArrayList<>(nameSet);
    names.sort((a, b) -> {
      if(a.length() != b.length()) return a.length() - b.length();
      return a.compareTo(b);
    });

    for (String s : names) {
      System.out.println(s);
    }
  }
}
