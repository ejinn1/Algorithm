

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();
    String bomb = br.readLine();

    char[] s = str.toCharArray();
    char[] b = bomb.toCharArray();
    int n = s.length;
    int m = b.length;

    char[] stack = new char[n];
    int top = 0;

    for (int i = 0; i < str.length(); i++) {
      stack[top++] = s[i];

      if (stack[top - 1] == b[m - 1] && top >= m) {
        boolean ok = true;
        for (int k = 0; k < m; k++) {
          if (stack[top - m + k] != b[k]) {
            ok = false;
            break;
          }
        }

        if(ok) top -= m;
      }
    }

    if (top == 0) {
      System.out.println("FRULA");
    } else {
      System.out.println(new String(stack, 0, top));
    }
  }
}
