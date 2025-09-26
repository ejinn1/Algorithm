

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    Map<String, Integer> fileMap = new TreeMap<>();

    for (int i = 0; i < N; i++) {
      String name = br.readLine();
      int idx = name.indexOf(".");
      name = name.substring(idx+1);
      fileMap.merge(name, 1, Integer::sum);
    }


    for (Map.Entry<String, Integer> e : fileMap.entrySet()) {
      System.out.println(e.getKey() + " " + e.getValue());
    }

  }

}
