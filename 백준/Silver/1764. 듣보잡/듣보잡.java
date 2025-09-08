

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());


    Map<String, Integer> m = new HashMap<>();
    for (int i = 0; i < N; i++) {
      String name = br.readLine();
      m.put(name, 1);
    }

    int result = 0;
    ArrayList<String> arr = new ArrayList<>();
    for (int i = 0; i < M; i++) {
      String name = br.readLine();
      if(m.containsKey(name)){
        arr.add(name);
        result++;
      }
    }

    System.out.println(result);

    Collections.sort(arr);
    for (int i = 0; i < arr.size(); i++) {
      System.out.println(arr.get(i));
    }


  }

}
