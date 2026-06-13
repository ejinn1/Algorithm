import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] check = new int[N+1];

        for(int i=0 ; i<K ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            for(int j=a ; j<=b ; j++){
                check[j]++;
            }
        }

        int max = 0;
        for(int i=1 ; i<=N ; i++){
            max = Math.max(max, check[i]);
        }

        System.out.println(max);
    }
}