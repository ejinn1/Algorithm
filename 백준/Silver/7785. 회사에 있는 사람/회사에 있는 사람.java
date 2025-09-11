

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    HashSet<String> company = new HashSet<>();
    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      String name = st.nextToken();
      String option = st.nextToken();
      if (option.equals("enter")) {
        company.add(name);
      } else if (option.equals("leave")) {
        company.remove(name);
      }
    }

    List<String> list = new ArrayList<>(company);
    Collections.sort(list, Collections.reverseOrder());
    for (String name : list) {
      System.out.println(name);
    }
  }

}
