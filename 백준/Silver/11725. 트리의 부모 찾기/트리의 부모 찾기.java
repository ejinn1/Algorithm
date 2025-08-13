

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
            graph[a].add(b);
        }

        int[] parent = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        visited[1] = true;

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(1);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    parent[next] = cur;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=2 ; i<=N ; i++){
            sb.append(parent[i]).append('\n');
        }
        System.out.println(sb);

    }
}
