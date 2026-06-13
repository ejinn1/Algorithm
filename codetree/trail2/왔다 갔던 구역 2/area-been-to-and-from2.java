import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[201];

        int cur = 100;
        for(int i=0 ; i<N ; i++){
            int a = sc.nextInt();
            char dir = sc.next().charAt(0);

            for(int j=0 ; j<a ; j++){
                if(dir == 'L'){
                    cur--;
                    arr[cur]++;
                } else if(dir == 'R'){
                    arr[cur]++;
                    cur++;
                }
            }
        }

        int cnt = 0;
        for(int i=0 ; i<201 ; i++){
            if(arr[i] > 1) cnt++;
        }

        System.out.println(cnt);
    }
}