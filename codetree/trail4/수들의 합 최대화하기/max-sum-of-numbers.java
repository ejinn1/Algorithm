import java.util.*;

public class Main {
    static int n;
    static int[][] grid;
    static boolean[] used;
    static int max = Integer.MIN_VALUE;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        grid = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        
        List<Integer> idxs = new ArrayList<>();
        used = new boolean[n+1];
        
        dfs(idxs);

        System.out.print(max);
    }

    static void dfs(List<Integer> idxs){
        if(idxs.size() == n){
            max = Math.max(max, getSum(idxs));
            return;
        }

        for(int i=1 ; i<=n ; i++){
            if(used[i]) continue;

            idxs.add(i);
            used[i] = true;
            dfs(idxs);

            idxs.remove(idxs.size() - 1);
            used[i] = false;
        }
    }

    static int getSum(List<Integer> idxs){
        int sum = 0;
        for(int i=0 ; i<n ; i++){
            sum += grid[i][idxs.get(i) - 1];
        }

        return sum;
    }
}