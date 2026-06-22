import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] bomb = new int[N+1];

        for(int i=1 ; i<=N ; i++){
            bomb[i] = sc.nextInt();
        }

        int max = -1;
        for(int i=1 ; i<=N ; i++){
            int num = bomb[i];
            for(int j=i-K ; j<=i+K ; j++){
                if(j < 0 || j > N || i == j) continue;
                if(num == bomb[j]) {
                    max = Math.max(max, num);
                }
            }
        }

        System.out.print(max);
    }
}