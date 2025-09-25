

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String name = "";
    Map<String, Integer> treeMap = new TreeMap<>();
    int total = 0;

    while ((name = br.readLine()) != null) {
      if(name.isEmpty()) break;
      treeMap.merge(name, 1, Integer::sum);
      total++;
    }

    StringBuilder sb = new StringBuilder();
    for (Map.Entry<String, Integer> e : treeMap.entrySet()) {
      double pct = e.getValue() * 100.0 / total;
      sb.append(e.getKey())
              .append(" ")
              .append(String.format(Locale.US, "%.4f", pct)).append("\n");
    }
    System.out.println(sb);
  }
}
