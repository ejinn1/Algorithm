import java.util.*;

public class Main {
    static int n, m;
    static ArrayList<Integer> ans = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        choose(1, 0);
    }

    static void choose(int cur, int cnt) {
        // m개를 모두 골랐으면 출력하고 종료
        if (cnt == m) {
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        // n까지 확인했는데 m개를 못 골랐으면 종료
        if (cur > n) {
            return;
        }

        // 1. 현재 숫자를 선택
        ans.add(cur);
        choose(cur + 1, cnt + 1);

        // 선택하기 전 상태로 복구
        ans.remove(ans.size() - 1);

        // 2. 현재 숫자를 선택하지 않음
        choose(cur + 1, cnt);
    }
}