import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] trains = new int[N][20];

        for(int o=0 ; o<M ; o++){
            int option = sc.nextInt();
            int i = sc.nextInt() - 1;

            if(option == 1){
                int x = sc.nextInt() - 1;
                trains[i][x] = 1;
            } else if(option == 2){
                int x = sc.nextInt() - 1;
                trains[i][x] = 0;
            } else if(option == 3){
                for(int k=19 ; k>0 ; k--){
                    trains[i][k] = trains[i][k - 1];
                }
                trains[i][0] = 0;
            } else if(option == 4){
                for(int k=1 ; k<20 ; k++){
                    trains[i][k - 1] = trains[i][k];
                }
                trains[i][19] = 0;
            }
        }

        Set<String> stateSet = new HashSet<>();

        for(int i=0 ; i<N ; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0 ; j<20 ; j++){
                sb.append(trains[i][j]);
            }
            stateSet.add(sb.toString());
        }

        System.out.println(stateSet.size());
    }
}