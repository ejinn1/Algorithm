import java.util.*;

public class Main {
    public static final int MAX_R = 2_000;
    public static final int OFFSET = 1_000;

    public static int[][] checked = new int[MAX_R + 1][MAX_R + 1];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // int[] A = Arrays.stream(sc.nextLine().split(" "))
        //         .mapToInt(Integer::parseInt)
        //         .toArray();

        // int[] B = Arrays.stream(sc.nextLine().split(" "))
        //         .mapToInt(Integer::parseInt)
        //         .toArray();

        // int[] M = Arrays.stream(sc.nextLine().split(" "))
        //         .mapToInt(Integer::parseInt)
        //         .toArray();

        for(int i=0 ; i<2 ; i++){
            int x1 = sc.nextInt() + OFFSET;
            int y1 = sc.nextInt() + OFFSET;
            int x2 = sc.nextInt() + OFFSET;
            int y2 = sc.nextInt() + OFFSET;

            for(int x=x1 ; x<x2 ; x++){
                for(int y=y1 ; y<y2 ; y++){
                    checked[x][y] = 1;
                }
            }
        }

        int x1 = sc.nextInt() + OFFSET;
        int y1 = sc.nextInt() + OFFSET;
        int x2 = sc.nextInt() + OFFSET;
        int y2 = sc.nextInt() + OFFSET;

        for(int x=x1 ; x<x2 ; x++){
            for(int y=y1 ; y<y2 ; y++){
                checked[x][y] = 0;
            }
        }

        int answer = 0;
        for(int i=0 ; i<MAX_R ; i++){
            for(int j=0 ; j<MAX_R ; j++){
                if(checked[i][j] == 1) answer++;
            }
        }

        System.out.println(answer);
        
    }
}