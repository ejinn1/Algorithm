import java.util.*;

public class Main {
    static int N;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        dfs(0);

        System.out.print(cnt);
    }

    static void dfs(int len){
        if(len == N){
            cnt++;
            return;
        } else if(len > N){
            return;
        }

        for(int i=1 ; i<=4 ; i++){
            dfs(len + i);
        }
    }
}