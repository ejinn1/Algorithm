
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine().toUpperCase();

    int[] cnt = new int[26];
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if ('A' <= c && c <= 'Z') cnt[c - 'A']++;
    }

    int max = -1;
    int maxIdx = -1;
    boolean tie = false;

    for (int i = 0; i < 26; i++) {
      if (cnt[i] > max) {
        max = cnt[i];
        maxIdx = i;
        tie = false;
      } else if (cnt[i] == max) {
        tie = true;
      }
    }

    if (tie) {
      System.out.println("?");
    } else {
      System.out.println((char) ('A' + maxIdx));
    }
  }
}
