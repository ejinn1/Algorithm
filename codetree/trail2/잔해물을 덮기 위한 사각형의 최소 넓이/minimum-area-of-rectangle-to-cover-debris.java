import java.util.*;

public class Main {
    static int OFFSET = 1_000;
    static int MAX_R = 2_000;

    static int[][] arr = new int[MAX_R + 1][MAX_R + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        paint(sc, 1);
        paint(sc, 0);

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        int cnt = 0;
        
        for(int i=0 ; i<MAX_R ; i++){
            for(int j=0 ; j<MAX_R ; j++){
                if(arr[i][j] != 1) continue;
                maxX = Math.max(maxX, i);
                minX = Math.min(minX, i);

                maxY = Math.max(maxY, j);
                minY = Math.min(minY, j);

                cnt++;
            }
        }

        if(cnt == 0) System.out.println(0);
        else {
            int area = (maxX - minX + 1) * (maxY - minY + 1);
            System.out.print(area);
        }
    }

    static void paint(Scanner sc, int k){
        int x1 = sc.nextInt() + OFFSET;
        int y1 = sc.nextInt() + OFFSET;
        int x2 = sc.nextInt() + OFFSET;
        int y2 = sc.nextInt() + OFFSET;

        for(int x=x1 ; x<x2 ; x++){
            for(int y=y1 ; y<y2 ; y++){
                arr[x][y] = k;
            }
        }
    }
}