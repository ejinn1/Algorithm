

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    HashMap<String, String> nameToNumber = new HashMap<>();
    HashMap<String, String> numberToName = new HashMap<>();
    for (int i = 1; i <= N; i++) {
      String name = br.readLine();
      nameToNumber.put(name, i + "");
      numberToName.put(i + "", name);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < M; i++) {
      String key = br.readLine();
      if (Character.isDigit(key.charAt(0))) {
        sb.append(numberToName.get(key))
                .append("\n");
      } else {
        sb.append(nameToNumber.get(key))
                .append("\n");
      }
    }

    System.out.println(sb);

  }

}
