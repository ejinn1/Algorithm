

import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<long[]>[] graph = new ArrayList[N + 1];
        for(int i=1 ; i<=N ; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph[a].add(new long[]{b, c});
            graph[b].add(new long[]{a, c});
        }

        boolean[] visited = new boolean[N + 1];
        Deque<long[]> deque = new ArrayDeque<>();
        deque.add(new long[]{1, 0});
        visited[1] = true;

        long maxDist = 0;
        while (!deque.isEmpty()) {
            long[] cur = deque.poll();
            int u = (int) cur[0];
            long d = cur[1];
            if(d > maxDist) maxDist = d;

            for (long[] nx : graph[u]) {
                int v = (int) nx[0];
                long w = nx[1];
                if (!visited[v]) {
                    visited[v] = true;
                    deque.add(new long[]{v, d + w});
                }
            }

        }

        System.out.println(maxDist);

    }
}
