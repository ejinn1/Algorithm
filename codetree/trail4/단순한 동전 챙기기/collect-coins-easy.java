import java.util.*;

public class Main {
    static char[][] grid;
    static int[][] coins;
    static boolean[] exist;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static int min = Integer.MAX_VALUE;
    static int[] E;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        grid = new char[N][N];
        coins = new int[10][2];
        exist = new boolean[10];
        int[] S = new int[2];
        E = new int[2];

        for(int i=0 ; i<N ; i++){
            String row = sc.next();
            for(int j=0 ; j<N ; j++){
                char c = row.charAt(j);
                grid[i][j] = c;

                if(c >= '1' && c <= '9'){
                    int num = c - '0';
                    coins[num][0] = i;
                    coins[num][1] = j;
                    exist[num] = true;
                } else if(c == 'E') {
                    E = new int[]{i, j};
                } else if(c == 'S'){
                    S = new int[]{i, j};
                }
            }
        }
        
        dfs(S[0], S[1], 0, 0, 0);

        System.out.print(min == Integer.MAX_VALUE ? -1 : min);
        
    }

    static void dfs(int x, int y, int cnt, int prevN, int sum){
        if(cnt == 3){
            int len = Math.abs(x - E[0]) + Math.abs(y - E[1]);
            min = Math.min(min, sum+len);
            return;
        }
        for(int c = prevN + 1 ; c<10 ; c++){
            if(!exist[c]) continue;

            int len = Math.abs(x - coins[c][0]) + Math.abs(y - coins[c][1]);
            dfs(coins[c][0], coins[c][1], cnt+1, c, sum+len);
        }
    }
}