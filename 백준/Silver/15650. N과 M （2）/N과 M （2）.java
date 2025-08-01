import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] path;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int depth, int start){
        if(depth == M){
            for(int i=0 ; i<M ; i++){
                sb.append(path[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i=start ; i<=N ; i++){
            path[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        
        path = new int[M];

        dfs(0, 1);
        System.out.print(sb.toString());
    }
}
