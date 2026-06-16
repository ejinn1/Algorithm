import java.util.*;

public class Main {
    static int MAX_LEN = 2_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] A = new int[MAX_LEN];
        int[] B = new int[MAX_LEN];

        int timeA = 1;
        for(int i=0 ; i<N ; i++){
            int t = sc.nextInt();
            char dir = sc.next().charAt(0);

            while(t-- > 0){
                if(dir == 'R'){
                    A[timeA] = A[timeA - 1] + 1;
                } else {
                    A[timeA] = A[timeA - 1] - 1;
                }
                timeA++;
            }
        }

        int timeB = 1;
        for(int i=0 ; i<M ; i++){
            int t = sc.nextInt();
            char dir = sc.next().charAt(0);

            while(t-- > 0){
                if(dir == 'R'){
                    B[timeB] = B[timeB - 1] + 1;
                } else {
                    B[timeB] = B[timeB - 1] - 1;
                }
                timeB++;
            }
        }

        int answer = 0;
        int maxT = timeA;
        if(timeA > timeB){
            maxT = timeA;
            for(int i=timeB ; i<maxT ; i++){
                B[i] = B[i-1];
            }
        } else {
            maxT = timeB;
            for(int i=timeA ; i<maxT ; i++){
                A[i] = A[i-1];
            }
        }

        for(int i=1 ; i<maxT ; i++){
            if(A[i] == B[i] && A[i-1] != B[i-1]){
                answer++;
            }
        }

        System.out.print(answer);
    }
}