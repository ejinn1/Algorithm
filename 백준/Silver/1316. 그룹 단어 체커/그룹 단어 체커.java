

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int result = 0;
    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      boolean[] check = new boolean[26];

      if(str.length() == 1){
        result++;
        continue;
      }

      boolean flag = true;

      check[str.charAt(0) - 'a'] = true;

      for (int j = 1; j < str.length(); j++) {
        char prev = str.charAt(j - 1);
        char cur = str.charAt(j);
        if (prev != cur) {
          if (check[cur - 'a']) {
            flag = false;
            break;
          } else{
            check[cur - 'a'] = true;
          }
        }
      }

      if(flag) result++;
    }
    System.out.println(result);
  }
}
