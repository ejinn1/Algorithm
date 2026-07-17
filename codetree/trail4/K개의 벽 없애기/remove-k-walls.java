import java.util.*;

public class Main {
    static class Node{
        int x, y, k, dist;

        Node(int x, int y, int k, int d){
            this.x = x;
            this.y = y;
            this.k = k;
            this.dist = d;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] arr = new int[N][N];

        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int r1 = sc.nextInt() - 1;
        int c1 = sc.nextInt() - 1;
        int r2 = sc.nextInt() - 1;
        int c2 = sc.nextInt() - 1;

        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(r1, c1, 0, 0));

        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        int min = Integer.MAX_VALUE;

        boolean[][][] visited = new boolean[N][N][K + 1];
        visited[r1][c1][0] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(cur.k > K) continue;
            
            if(cur.x == r2 && cur.y == c2 && cur.k <= K){
                min = cur.dist;
                break;
            }

            for(int d=0 ; d<4 ; d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(visited[nx][ny][cur.k]) continue;

                visited[nx][ny][cur.k] = true;

                if(arr[nx][ny] == 1){
                    q.offer(new Node(nx, ny, cur.k + 1, cur.dist + 1));
                } else {
                    q.offer(new Node(nx, ny, cur.k, cur.dist + 1));
                }
            }
        }

        System.out.print(min == Integer.MAX_VALUE ? -1 : min);

    }
}