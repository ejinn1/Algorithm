import java.util.*;

public class Main {
    static int OFFSET = 100;
    static int MAX_R = 200;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] arr = new int[MAX_R + 1][MAX_R + 1];

        int color = 1;
        for(int i=0 ; i<N ; i++){
            int x1 = sc.nextInt() + OFFSET;
            int y1 = sc.nextInt() + OFFSET;
            int x2 = sc.nextInt() + OFFSET;
            int y2 = sc.nextInt() + OFFSET;
            
            for(int x=x1 ; x<x2 ; x++){
                for(int y=y1 ; y<y2 ; y++){
                    arr[x][y] = color;
                }
            }

            if(color == 1) color = 2;
            else color = 1;
        }

        int answer = 0;
        for(int i=0 ; i<MAX_R ; i++){
            for(int j=0 ; j<MAX_R ; j++){
                if(arr[i][j] == 2) answer++;
            }
        }

        System.out.print(answer);
    }
}