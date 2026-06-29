import java.util.*;

public class Main {
    static int N;
    static int[][] lines;
    static int max = 0;
    static int[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        check = new int[N+1];
        lines = new int[N][2];

        for(int i=0 ; i<N ; i++){
            int l = sc.nextInt();
            int r = sc.nextInt();

            lines[i] = new int[]{l, r};
        }

        dfs(0);

        System.out.print(max);
    }

    static void dfs(int idx){
        if(idx == N){
            max = Math.max(max, countLine());
            return;
        }

        check[idx] = 1;
        dfs(idx + 1);

        check[idx] = 0;
        dfs(idx + 1);
    }

    static int countLine(){
        int cnt = 0;
        for(int i=0 ; i<N ; i++){
            if(check[i] == 0) continue;
            boolean possible = true;

            for(int j=0 ; j<N ; j++){
                if(i == j) continue;
                if(check[j] == 0) continue;

                int[] prev = lines[i];
                int[] next = lines[j];

                if (prev[1] >= next[0] && next[1] >= prev[0]) {
                    possible = false;
                    break;
                }
            }

            if(possible) cnt++;
        }

        return cnt;
    }
}