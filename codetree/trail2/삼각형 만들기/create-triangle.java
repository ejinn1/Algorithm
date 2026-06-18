import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] x = new int[N];
        int[] y = new int[N];

        for(int i=0 ; i<N ; i++){
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int max = 0;
        for(int t=0 ; t<N-2 ; t++){
            for(int k=t+1 ; k<N-1 ; k++){
                for(int l=k+1 ; l<N ; l++){
                    boolean sameX = (x[t] == x[k]) || (x[t] == x[l]) || (x[k] == x[l]);
                    boolean sameY = (y[t] == y[k]) || (y[t] == y[l]) || (y[k] == y[l]);

                    if (!sameX || !sameY) continue;

                    int s = Math.abs((x[t]*y[k] + x[k]*y[l] + x[l]*y[t]) - (x[k]*y[t] + x[l]*y[k] + x[t]*y[l]));
                    max = Math.max(max, s);
                }
            }
        }

        System.out.print(max);
    }
}