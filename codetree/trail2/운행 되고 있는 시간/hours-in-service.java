import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] dev = new int[N][2];
        for(int i=0 ; i<N ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            dev[i] = new int[]{a, b};
        }

        int max = 0;
        for(int i=0 ; i<N ; i++){
            boolean[] work = new boolean[1001];
            for(int t=0 ; t<N ; t++){
                if(i == t) continue;
                
                for(int k=dev[t][0] ; k<dev[t][1] ; k++){
                    work[k] = true;
                }
            }
            int cnt = 0;
            for(int t=1 ; t<=1000 ; t++){
                if(work[t]) cnt++;
            }
            max = Math.max(max, cnt);
        }

        System.out.print(max);
    }
}