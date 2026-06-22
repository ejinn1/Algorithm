import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int N = sc.nextInt();

        List<List<Integer>> rank = new ArrayList<>();

        for(int i=0 ; i<K ; i++){
            List<Integer> row = new ArrayList<>();

            for(int j=0 ; j<N ; j++){
                row.add(sc.nextInt());
            }

            rank.add(row);
        }

        int ans = 0;
        for(int a=1 ; a<=N ; a++){
            for(int b=1 ; b<=N ; b++){
                if(a == b) continue;

                boolean check = true;

                for(int i=0 ; i<K ; i++){
                    int idxA = rank.get(i).indexOf(a);
                    int idxB = rank.get(i).indexOf(b);

                    if(idxA >= idxB) {
                        check = false;
                        break;
                    }
                }

                if(check) {
                    ans++;
                }
            }
        }

        System.out.print(ans);
    }
}