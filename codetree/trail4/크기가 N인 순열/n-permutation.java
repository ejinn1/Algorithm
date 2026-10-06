import java.util.*;

public class Main {
    static int n;
    static boolean[] used;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        List<Integer> nums = new ArrayList<>();
        used = new boolean[n+1];
        dfs(nums);
        

    }

    static void dfs(List<Integer> nums){
        if(nums.size() == n){
            for(int n : nums){
                System.out.print(n + " ");
            }
            System.out.println();
            return;
        }

        for(int num = 1 ; num<=n ; num++){
            if(used[num]) continue;

            nums.add(num);
            used[num] = true;
            dfs(nums);

            nums.remove(nums.size() - 1);
            used[num] = false;
        }
    }
}