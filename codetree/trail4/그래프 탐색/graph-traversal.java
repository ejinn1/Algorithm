import java.util.*;

public class Main {
    static int n, m;
    static int[] u, v;
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        u = new int[m];
        v = new int[m];
        for (int i = 0; i < m; i++) {
            u[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        
        visited = new boolean[n+1];
        dfs(1);

        System.out.print(cnt - 1);

    }

    static void dfs(int cur){
        visited[cur] = true;
        cnt++;

        for(int i=0 ; i<m ; i++){
            if(u[i] == cur && !visited[v[i]]){
                dfs(v[i]);
            } else if(v[i] == cur && !visited[u[i]]){
                dfs(u[i]);
            }
        }
    }
}