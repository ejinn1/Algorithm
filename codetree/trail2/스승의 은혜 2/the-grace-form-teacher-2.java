import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int B = sc.nextInt();
        int[] P = new int[N];

        for(int i=0 ; i<N ; i++){
            P[i] = sc.nextInt();
        }

        Arrays.sort(P);

        int max = 0;
        for(int i=0 ; i<N ; i++){
            int b = B;
            int cnt = 0;
            for(int j=0 ; j<N ; j++){
                int p = (i == j) ? P[j] / 2 : P[j];

                if(b - p >= 0){
                    b -= p;
                    cnt++;
                }
            }

            max = Math.max(max, cnt);
        }

        System.out.print(max);

    }
}