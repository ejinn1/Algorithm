import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i=0 ; i<N ; i++) arr[i] = sc.nextInt();

        int cnt = 1;
        int max = 0;
        for(int i=0 ; i<N-1 ; i++){
            if(arr[i] < arr[i+1]){
                cnt++;
            } else {
                max = Math.max(max, cnt);
                cnt = 1;
            }
        }

        max = Math.max(max, cnt);

        System.out.print(max);
    }
}