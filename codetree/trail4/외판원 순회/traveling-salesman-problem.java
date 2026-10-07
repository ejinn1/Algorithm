import java.util.*;

public class Main {
    static int n;
    static int[][] cost;
    static boolean[] used;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        
        List<Integer> idxs = new ArrayList<>();
        used = new boolean[n+1];

        idxs.add(1);
        used[1] = true;

        dfs(idxs);

        System.out.print(min);
    }

    static void dfs(List<Integer> idxs){
        if(idxs.size() == n){
            if (idxs.size() == n) {
                int sum = getSum(idxs);
                min = Math.min(min, sum);
                return;
            }
        }

        for(int num=1 ; num<=n ; num++){
            if(used[num]) continue;

            idxs.add(num);
            used[num] = true;
            dfs(idxs);

            idxs.remove(idxs.size() - 1);
            used[num] = false;
        }
    }

    static int getSum(List<Integer> idxs) {
        int sum = 0;

        for (int i = 0; i < n - 1; i++) {
            int from = idxs.get(i) - 1;
            int to = idxs.get(i + 1) - 1;

            if (cost[from][to] == 0) {
                return Integer.MAX_VALUE;
            }

            sum += cost[from][to];
        }

        int last = idxs.get(n - 1) - 1;
        int first = idxs.get(0) - 1;

        if (cost[last][first] == 0) {
            return Integer.MAX_VALUE;
        }

        sum += cost[last][first];
        
        return sum;
    }   
}