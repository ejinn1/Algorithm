import java.util.*;

public class Main {
    static int n, total;
    static int[] arr;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[2 * n];
        total = 0;

        for (int i = 0; i < 2 * n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        
        dfs(0, 0, 0);

        System.out.print(min);
    }

    static void dfs(int idx, int cnt, int sum){
        if(cnt == n){
            min = Math.min(min, Math.abs(total - 2*sum));
            return;
        }

        if(idx >= 2*n) return;

        dfs(idx + 1, cnt + 1, sum + arr[idx]);
        dfs(idx + 1, cnt, sum);
    }
}