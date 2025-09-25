

import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String str = sc.nextLine();
    int len = str.length();
    // c= s= z=
    // dz=
    // lj nj
    // c- d-

    int cnt = 0;
    int i = 0;

    while (i < len) {
      char ch = str.charAt(i);

      if (i + 2 < len && ch == 'd' && str.charAt(i + 1) == 'z' && str.charAt(i + 2) == '=') {
        i += 2;
      } else if (i + 1 < len && (ch == 'l' || ch == 'n') && str.charAt(i + 1) == 'j') {
        i++;
      } else if (i + 1 < len && (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-')) {
        i++;
      }

      cnt++;
      i++;
    }

    System.out.println(cnt);





  }
}
