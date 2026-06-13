import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[201];

        for(int i=0 ; i<N ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            for(int j=a ; j<=b ; j++){
                arr[j + 100]++;
            }
        }

        int max = 0;
        for(int i=0 ; i<200 ; i++){
            max = Math.max(max, arr[i]);
        }

        System.out.println(max);
    }
}