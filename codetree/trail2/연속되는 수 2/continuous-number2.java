import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] nums = new int[N];
        for(int i=0 ; i<N ; i++) nums[i] = sc.nextInt();

        int prev = nums[0];
        int cnt = 1;
        int max = 0;
        for(int i=1 ; i<N ; i++){
            if(prev != nums[i]){
                max = Math.max(max, cnt);
                cnt = 1;
                prev = nums[i];
            } else {
                cnt++;
            }
        }

        max = Math.max(max, cnt);

        System.out.println(max);
    }
}