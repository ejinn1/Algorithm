import java.util.*;

public class Main {
    static int k;
    static int n;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();
        n = sc.nextInt();
        
        arr = new int[n];

        choose(0);
    }

    static void choose(int cnt){
        if(cnt == n){
            for(int i=0 ; i<n ; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=1 ; i<=k ; i++){
            arr[cnt] = i;
            choose(cnt + 1);
        }
    }
}