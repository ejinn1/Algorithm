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

        int min = Integer.MAX_VALUE;
        for(int i=0 ; i<N-1 ; i++){
            for(int j=i+1 ; j<N ; j++){
                int d = (int) Math.pow(Math.abs(x[i] - x[j]), 2) + (int) Math.pow(Math.abs(y[i] - y[j]), 2);
                min = Math.min(min, d);
            }
        }

        System.out.print(min);
    }
}