

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static int N, M;
    static int[] cows;
    static Set<Integer> result = new TreeSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        cows = new int[N];

        for(int i=0 ; i<N ; i++){
            cows[i] = sc.nextInt();
        }

        dfs(0, 0, 0);

        if(result.isEmpty()){
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for(int x : result) sb.append(x).append(' ');
            System.out.println(sb);
        }

    }

    static void dfs(int idx, int picked, int sum){
        if(picked == M && isPrime(sum)) {
            result.add(sum);
            return;
        }

        if (idx == N)    return;
        if(picked + (N - idx) < M) return;


        for (int i = idx; i < N; i++) {
            dfs(i + 1, picked + 1, sum + cows[i]);
        }
    }

    static boolean isPrime(int num){
        if(num < 2) return false;
        for(int i=2 ; i*i <= num ; i++){
            if(num % i == 0){
                return false;
            }
        }

        return true;
    }


}
