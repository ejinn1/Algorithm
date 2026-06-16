import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int[] cnt = new int[N + 1];
        int answer = -1;
        for(int i=0 ; i<M ; i++){
            int num = sc.nextInt();

            cnt[num]++;
            if(cnt[num] >= K){
                answer = num;
                break;
            }
        }

        System.out.print(answer);
    }
}