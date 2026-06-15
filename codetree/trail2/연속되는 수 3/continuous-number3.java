import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int cnt = 1;
        int max = 0;
        int prev = sc.nextInt();
        boolean plus = prev > 0;
        for(int i=1 ; i<N ; i++){
            int num = sc.nextInt();

            if(plus && num > 0 || !plus && num < 0){
                cnt++;
            } else if(plus && num < 0 || !plus && num > 0){
                plus = !plus;
                max = Math.max(cnt, max);
                cnt = 1;
            }
        }

        max = Math.max(max, cnt);

        System.out.println(max);
    }
}