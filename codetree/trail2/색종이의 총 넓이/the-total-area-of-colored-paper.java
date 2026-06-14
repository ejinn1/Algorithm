import java.util.*;

public class Main {
    static int OFFSET = 100;
    static int MAX_R = 200;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] arr = new int[MAX_R+1][MAX_R+1];

        for(int i=0 ; i<N ; i++){
            int x = sc.nextInt() + OFFSET;
            int y = sc.nextInt() + OFFSET;
            
            for(int t=x ; t<x+8 ; t++){
                for(int k=y ; k<y+8 ; k++){
                    arr[t][k] = 1;
                }
            }
        }

        int answer = 0;
        for(int i=0 ; i<MAX_R ; i++){
            for(int j=0 ; j<MAX_R ; j++){
                if(arr[i][j] == 1) answer++;
            }
        }

        System.out.print(answer);
    }
}