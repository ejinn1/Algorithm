import java.util.*;

public class Main {
    static int MAX_T = 1_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int[] A = new int[MAX_T];
        int time=1;
        for(int i=0 ; i<N ; i++){
            int v = sc.nextInt();
            int t = sc.nextInt();

            while(t-- > 0){
                A[time] = A[time - 1] + v;
                time++;
            }
        }

        int[] B = new int[MAX_T];
        time=1;
        for(int i=0 ; i<M ; i++){
            int v = sc.nextInt();
            int t = sc.nextInt();

            while(t-- > 0){
                B[time] = B[time - 1] + v;
                time++;
            }
        }

        int cnt = 0;
        boolean firstA = A[1] >= B[1];
        for(int i=2 ; i<time ; i++){
            if(firstA && A[i] < B[i]){
                cnt++;
                firstA = false;
            } else if(!firstA && A[i] > B[i]){
                cnt++;
                firstA = true;
            }
        }

        System.out.print(cnt);
    }
}