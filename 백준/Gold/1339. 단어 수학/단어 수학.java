import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    sc.nextLine();

    long[] weight = new long[26];

    String[] words = new String[N];
    for (int i = 0; i < N; i++) {
      words[i] = sc.nextLine();
      int mul = 1;
      char[] sub = words[i].toCharArray();
      for (int j = sub.length - 1; j >= 0; j--) {
        weight[sub[j] - 'A'] += mul;
        mul *= 10;
      }
    }
    
    List<Long> w = new ArrayList<>();
    for (long v : weight) if (v > 0) w.add(v);
    w.sort(Comparator.reverseOrder());
    int digit = 9;
    int result = 0;
    for (long v : w) {
      result += v * digit;
      digit--;
      if (digit < 0) break;
    }

    System.out.println(result);
    
  }
}