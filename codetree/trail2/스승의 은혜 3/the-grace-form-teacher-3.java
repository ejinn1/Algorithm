import java.util.*;

public class Main {
    static class Std{
        int p;
        int s;

        Std(int p, int s){
            this.p = p;
            this.s = s;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int B = sc.nextInt();

        List<Std> stds = new ArrayList<>();

        for(int i=0 ; i<N ; i++){
            int p = sc.nextInt();
            int s = sc.nextInt();

            stds.add(new Std(p, s));
        }

        stds.sort((a, b) -> (a.p + a.s) - (b.p + b.s));

        int max = 0;
        for(int i=0 ; i<N ; i++){
            int cnt = 0;
            int budget = B;

            for(int j=0 ; j<N ; j++){
                int p = (i == j) ? (int) stds.get(j).p / 2 :stds.get(j).p;
                int s = stds.get(j).s;

                int sum = p + s;

                if(budget - sum >= 0){
                    budget -= sum;
                    cnt++;
                }
            }

            max = Math.max(max, cnt);
        }

        System.out.print(max);
    }
}