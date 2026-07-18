import java.util.*;

public class Main {
    static class Pair {
        int x, cnt;

        Pair(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Queue<Pair> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 2];

        q.offer(new Pair(N, 0));
        visited[N] = true;

        int ans = 0;

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            if (cur.x == 1) {
                ans = cur.cnt;
                break;
            }

            if (cur.x - 1 >= 1 && !visited[cur.x - 1]) {
                visited[cur.x - 1] = true;
                q.offer(new Pair(cur.x - 1, cur.cnt + 1));
            }

            if (cur.x + 1 <= N+1 && !visited[cur.x + 1]) {
                visited[cur.x + 1] = true;
                q.offer(new Pair(cur.x + 1, cur.cnt + 1));
            }

            if (cur.x % 2 == 0 && !visited[cur.x / 2]) {
                visited[cur.x / 2] = true;
                q.offer(new Pair(cur.x / 2, cur.cnt + 1));
            }

            if (cur.x % 3 == 0 && !visited[cur.x / 3]) {
                visited[cur.x / 3] = true;
                q.offer(new Pair(cur.x / 3, cur.cnt + 1));
            }
        }

        System.out.print(ans);
    }
}