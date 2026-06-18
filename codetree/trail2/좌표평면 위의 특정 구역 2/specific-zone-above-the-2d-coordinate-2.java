import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] x = new int[N];
        int[] y = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        
        int minA = Integer.MAX_VALUE;
        for(int i=0 ; i<N ; i++){
            int maxX = 0;
            int minX = Integer.MAX_VALUE;
            int maxY = 0;
            int minY = Integer.MAX_VALUE;

            for(int t=0 ; t<N ; t++){
                if(t == i) continue;

                maxX = Math.max(maxX, x[t]);
                minX = Math.min(minX, x[t]);
                maxY = Math.max(maxY, y[t]);
                minY = Math.min(minY, y[t]);
            }

            int A = (maxX - minX) * (maxY - minY);
            minA = Math.min(minA, A);
        }

        System.out.print(minA);
    }
}