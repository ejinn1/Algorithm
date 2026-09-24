import java.util.*;

public class Main {
    static int n, m;
    static int[] A;
    static ArrayList<Integer> ans = new ArrayList<>();
    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        choose(0, 0);

        System.out.print(max);
    }

    static void choose(int idx, int cnt){
        if(cnt == m){
            int tmp = 0;
            for(int num : ans){
                tmp ^= num;
            }
            max = Math.max(max, tmp);
            return;
        }

        if(idx >= n){
            return;
        }

        ans.add(A[idx]);
        choose(idx + 1, cnt + 1);

        ans.remove(ans.size() - 1);

        choose(idx + 1, cnt);
    }
}