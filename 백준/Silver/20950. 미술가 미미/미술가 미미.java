

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int best = Integer.MAX_VALUE;
    static int Rt, Gt, Bt;
    static int[][] colors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        colors = new int[N][3];
        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());
            colors[i][0] = Integer.parseInt(st.nextToken());
            colors[i][1] = Integer.parseInt(st.nextToken());
            colors[i][2] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        Rt = Integer.parseInt(st.nextToken());
        Gt = Integer.parseInt(st.nextToken());
        Bt = Integer.parseInt(st.nextToken());

        dfs(0, 0, 0, 0, 0);
        System.out.println(best);
    }

    static void dfs(int idx, int cnt, int sumR, int sumG, int sumB) {
        if (cnt >= 2) {
            int r = roundAvg(sumR, cnt);
            int g = roundAvg(sumG, cnt);
            int b = roundAvg(sumB, cnt);
            int dist = Math.abs(r - Rt) + Math.abs(g - Gt) + Math.abs(b - Bt);
            if(dist < best) best = dist;
        }

        if(idx == N) return;

        int remain = N - idx;
        if((cnt == 0) && remain < 2 || (cnt == 1) && remain < 1) return;

        if(cnt == 7){
            dfs(idx + 1, cnt, sumR, sumG, sumB);
            return;
        }
        
        dfs(idx + 1, cnt + 1, sumR + colors[idx][0], sumG + colors[idx][1], sumB + colors[idx][2]);

        dfs(idx + 1, cnt, sumR, sumG, sumB);
    }

    static int roundAvg(int sum, int cnt) {
        return sum / cnt;
    }
}
