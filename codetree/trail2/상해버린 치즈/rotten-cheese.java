import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int D = sc.nextInt();
        int S = sc.nextInt();
        
        int[][] eat = new int[D][3];
        int[][] sick = new int[S][2];

        for(int i=0 ; i<D ; i++){
            int p = sc.nextInt();
            int m = sc.nextInt();
            int t = sc.nextInt();

            eat[i] = new int[]{p, m, t};
        }

        for(int i=0 ; i<S ; i++){
            int p = sc.nextInt();
            int t = sc.nextInt();

            sick[i] = new int[]{p, t};
        }

        int max = 0;
        for(int c=1 ; c<=M ; c++){
            boolean possible = true;

            for(int[] s : sick){
                int sp = s[0];
                int st = s[1];

                boolean ateBeforeSick = false;

                for(int[] e : eat){
                    int ep = e[0];
                    int em = e[1];
                    int et = e[2];

                    if(ep == sp && c == em && et < st){
                        ateBeforeSick = true;
                        break;
                    }
                }

                if(!ateBeforeSick){
                    possible = false;
                    break;
                }
            }

            if(!possible) continue;

            boolean[] P = new boolean[N+1];
            for(int[] e : eat){
                int p = e[0];
                int m = e[1];

                if(m == c){
                    P[p] = true;
                }
            }
            int cnt = 0;
            for(int i=1 ; i<=N ; i++) if(P[i]) cnt++;

            max = Math.max(max, cnt);
        }

        System.out.print(max);
    }
}