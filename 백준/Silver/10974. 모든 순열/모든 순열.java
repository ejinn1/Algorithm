

import java.util.Scanner;

public class Main {
    static int N;
    static boolean[] used;
    static int[] path;

    static void dfs(int depth){
        if(depth == N){
            for(int i=0 ; i<N ; i++){
                System.out.print(path[i] + " ");
            }
            System.out.println();
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
        used = new boolean[N + 1];
        path = new int[N];

        dfs(0);
    }
}
