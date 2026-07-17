import java.util.*;

public class Main {
    static class Node{
        int x, y;
        int dist;

        Node(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.dist = d;
        }
    }

    static int N, H, M;
    static int[][] arr, result;

    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        H = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N][N];
        result = new int[N][N];

        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                if(arr[i][j] == 2){
                    result[i][j] = search(i, j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int search(int x, int y){
        boolean[][] visited = new boolean[N][N];
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(x, y, 0));
        visited[x][y] = true;

        int dist = -1;

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(arr[cur.x][cur.y] == 3){
                dist = cur.dist;
                break;
            }

            for(int d=0 ; d<4 ; d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(visited[nx][ny]) continue;
                if(arr[nx][ny] == 1) continue;

                visited[nx][ny] = true;
                q.offer(new Node(nx, ny, cur.dist + 1));
            }
        }

        return dist;
    }
}