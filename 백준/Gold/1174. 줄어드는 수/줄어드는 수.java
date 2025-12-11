import java.util.*;

public class Main {
  static List<Long> list = new ArrayList<>();

  public static void main(String[] args) throws Exception{
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    for (int i = 0; i <= 9; i++) {
      dfs(i, i);
    }

    Collections.sort(list);

    if (N > list.size()) {
      System.out.println(-1);
    } else {
      System.out.println(list.get(N-1));
    }
  }

  static void dfs(long num, int lastDigit) {
    list.add(num);

    for (int next = 0; next < lastDigit; next++) {
      long nextNum = num * 10 + next;
      dfs(nextNum, next);
    }
  }
}
