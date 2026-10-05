import java.util.*;

public class Main {
    static int n, m;
    static int[][] points;
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        points = new int[n][2];

        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }
        
        List<int[]> picks = new ArrayList<>();
        
        dfs(0, picks);

        System.out.print(res);
    }

    static void dfs(int idx, List<int[]> picks) {
        if (picks.size() == m) {
            int len = getFarDistance(picks);
            res = Math.min(len, res);
            return;
        }

        if (idx >= n) return;

        // 선택하지 않음
        dfs(idx + 1, picks);

        // 선택
        picks.add(points[idx]);
        dfs(idx + 1, picks);
        picks.remove(picks.size() - 1); // 선택 이전 상태로 복구
    }

    static int getFarDistance(List<int[]> ps) {
        int max = 0;

        for (int i = 0; i < ps.size() - 1; i++) {
            for (int j = i + 1; j < ps.size(); j++) {
                int[] a = ps.get(i);
                int[] b = ps.get(j);

                int dx = a[0] - b[0];
                int dy = a[1] - b[1];
                int len = dx * dx + dy * dy;

                max = Math.max(max, len);
            }
        }

        return max;
    }
}