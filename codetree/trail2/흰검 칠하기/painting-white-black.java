import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int LEN = 200_001;
        int MID = 100_000;

        int[] cntW = new int[LEN];
        int[] cntB = new int[LEN];
        int[] arr = new int[LEN];
        

        int cur = MID;
        for(int i=0 ; i<N ; i++){
            int a = sc.nextInt();
            char dir = sc.next().charAt(0);

            if(dir == 'L'){
                arr[cur] = 1;
                cntW[cur]++;
            } else if(dir == 'R'){
                arr[cur] = 2;
                cntB[cur]++;
            }
            
            for(int j=0 ; j<a-1 ; j++){
                if(dir == 'L'){
                    cur--;
                    arr[cur] = 1;
                    cntW[cur]++;
                } else if(dir == 'R'){
                    cur++;
                    arr[cur] = 2;
                    cntB[cur]++;
                }
            }    
        }

        int[] result = new int[3];

        for (int i = 0; i < LEN; i++) {
            if (cntW[i] >= 2 && cntB[i] >= 2) {
                result[2]++;
            } else if (arr[i] == 1) {
                result[0]++;
            } else if (arr[i] == 2) {
                result[1]++;
            }
        }

        System.out.println(result[0] + " " + result[1] + " " + result[2]);

    }
}