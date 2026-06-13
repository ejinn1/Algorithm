import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int LEN = 200_000;
        int MID = 100_000;

        int[] arr = new int[LEN];

        int cur = MID;
        for(int i=0 ; i<N ; i++){
            int a = sc.nextInt();
            char dir = sc.next().charAt(0);

            if(dir == 'R'){
                arr[cur] = 2;
            } else if(dir == 'L'){
                arr[cur] = 1;
            }

            for(int j=0 ; j<a-1 ; j++){
                if(dir == 'R'){
                    cur++;
                    arr[cur] = 2;
                } else if(dir == 'L'){
                    cur--;
                    arr[cur] = 1;
                }
            }
        }

        int w = 0;
        int b = 0;
        for(int i=0 ; i<LEN ; i++){
            if(arr[i] == 2) b++;
            else if(arr[i] == 1) w++;
        }

        System.out.println(w + " " + b);
    }
}