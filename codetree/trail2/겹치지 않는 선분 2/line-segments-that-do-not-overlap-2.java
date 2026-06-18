import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] line = new int[N][2];

        for(int i=0 ; i<N ; i++){
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();

            line[i] = new int[]{x1, x2};
        }

        Arrays.sort(line, (a, b) -> a[0] - b[0]);

        boolean[] result = new boolean[N];
        for(int i=0 ; i<N ; i++) result[i] = true;
        for(int i=0 ; i<N-1 ; i++){
            for(int j=i+1 ; j<N ; j++){
                int a = line[i][1];
                int b = line[j][1];

                if(a >= b){
                    result[i] = false;
                    result[j] = false;
                }
            }
        }

        int cnt = 0;
        for(int i=0 ; i<N ; i++){
            if(result[i]) cnt++;
        }

        System.out.print(cnt);
    }
}