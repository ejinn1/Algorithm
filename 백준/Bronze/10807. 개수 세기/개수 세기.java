

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuffer sb = new StringBuffer();

    int N = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int V = Integer.parseInt(br.readLine());
    int cnt = 0;
    for (int i = 0; i < N; i++) {
      if(arr[i] == V) cnt++;
    }

    System.out.println(cnt);
  }
}
