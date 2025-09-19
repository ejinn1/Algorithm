

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    // 플루이드-워셜
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());

    int[][] dist = new int[V + 1][V + 1];
    for (int i = 1; i <= V; i++) {
      Arrays.fill(dist[i], Integer.MAX_VALUE);
      dist[i][i] = 0;
    }

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      if(w < dist[u][v]) dist[u][v] = w;
    }

    for (int k = 1; k <= V; k++) {
      for (int i = 1; i <= V; i++) {
        if(dist[i][k] == Integer.MAX_VALUE) continue;
        for (int j = 1; j <= V; j++) {
          if(dist[k][j] == Integer.MAX_VALUE) continue;
          int nd = dist[i][k] + dist[k][j];
          if(nd < dist[i][j]) dist[i][j] = nd;
        }
      }
    }

    int ans = Integer.MAX_VALUE;
    for (int i = 1; i <= V; i++) {
      for (int j = i + 1; j <= V; j++) {
        if (dist[i][j] != Integer.MAX_VALUE && dist[j][i] != Integer.MAX_VALUE) {
          int sum = dist[i][j] + dist[j][i];
          if (sum < ans) ans = sum;
        }
      }
    }

    System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

  }
}
