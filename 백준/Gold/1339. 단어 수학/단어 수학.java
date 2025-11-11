import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    sc.nextLine();

    long[] weight = new long[26];

    for (int i = 0; i < N; i++) {
      char[] word = sc.nextLine()
              .toCharArray();
      int mul = 1;
      for (int j = word.length - 1; j >= 0; j--) {
        weight[word[j] - 'A'] += mul;
        mul *= 10;
      }
    }

    List<Long> w = new ArrayList<>();
    for (long v : weight) {
      if(v > 0) w.add(v);
    }
    w.sort(Collections.reverseOrder());

    long digit = 9;
    long result = 0;
    for (long v : w) {
      result += digit * v;
      digit--;
      if(digit < 0) break;
    }

    System.out.println(result);
  }
}