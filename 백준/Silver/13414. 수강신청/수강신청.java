

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int K = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());

    String[] wait = new String[L];
    HashMap<String, Integer> idx = new HashMap<>();

    for (int i = 0; i < L; i++) {
      String id = br.readLine();
      idx.put(id, i);
      wait[i] = id;
    }

    int i = 0;
    int k = 0;
    while (i < L && k < K) {
      String id = wait[i];
      if (i == idx.get(id)) {
        System.out.println(id);
        k++;
      }
      i++;
    }
  }

}
