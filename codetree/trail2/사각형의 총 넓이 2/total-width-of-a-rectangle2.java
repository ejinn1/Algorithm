import java.util.*;

public class Main {
    static int OFFSET = 100;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int LEN = OFFSET * 2 + 1;
        int[][] arr = new int[LEN][LEN];

        for(int i=0 ; i<N ; i++){
            int x1 = sc.nextInt() + OFFSET;
            int y1 = sc.nextInt() + OFFSET;
            int x2 = sc.nextInt() + OFFSET;
            int y2 = sc.nextInt() + OFFSET;

            for(int t=x1 ; t<x2 ; t++){
                for(int k=y1 ; k<y2 ; k++){
                    arr[t][k] = 1;
                }
            }
        }

        int answer = 0;
        for(int i=0 ; i<LEN ; i++){
            for(int j=0 ; j<LEN ; j++){
                if(arr[i][j] == 1) answer++;
            }
        }

        System.out.println(answer);
    }
}