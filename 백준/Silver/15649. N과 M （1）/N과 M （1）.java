import java.util.Scanner;

public class Main {
    static int N, M;
    static boolean[] used;
    static int[] path;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int depth){
        if(depth == M){
            for(int i=0 ; i<M ; i++){
                sb.append(path[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i=1 ; i<=N ; i++){
            if(!used[i]){
                used[i] = true;
                path[depth] = i;
                dfs(depth + 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        used = new boolean[N + 1];
        path = new int[M];

        dfs(0);
        System.out.print(sb.toString());
    }
}
