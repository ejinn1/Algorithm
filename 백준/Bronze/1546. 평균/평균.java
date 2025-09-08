

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    int[] scores = new int[N];
    int max = 0;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int c =  Integer.parseInt(st.nextToken());
      scores[i] = c;
      if(max < c) max = c;
    }

    double sum = 0;
    for (int i = 0; i < N; i++) {
      sum += (double) scores[i] / max * 100;
    }

    System.out.println(sum / N);
  }
}
