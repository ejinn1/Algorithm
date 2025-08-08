

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

        for(int i=0 ; i<N-1 ; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();

            graph[A].add(new long[]{B, C});
            graph[B].add(new long[]{A, C});
        }

        boolean[] visited = new boolean[N + 1];
        Deque<long[]> queue = new ArrayDeque<>();
        queue.add(new long[]{1, 0});
        visited[1] = true;

        long maxDist = 0;
        while (!queue.isEmpty()) {
            long[] cur = queue.poll();
            int u = (int) cur[0];
            long d = cur[1];
            if(d > maxDist) maxDist = d;

            for (long[] nx : graph[u]) {
                int v = (int) nx[0];
                long w = nx[1];
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(new long[]{v, d + w});
                }
            }
        }

        System.out.println(maxDist);

    }
}
