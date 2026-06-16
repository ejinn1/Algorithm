import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int T = sc.nextInt();

        int[] arr = new int[N];
        for(int i=0 ; i<N ; i++) arr[i] = sc.nextInt();
        
        int cnt = 0;
        int max = 0;
        for(int i=0 ; i<N ; i++){
            if(arr[i] > T) cnt++;
            else {
                max = Math.max(max, cnt);
                cnt = 0;
            }
        }

        max = Math.max(max, cnt);

        System.out.println(max);
    }
}