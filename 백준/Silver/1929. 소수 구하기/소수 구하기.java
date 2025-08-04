import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        boolean[] isNotPrime = new boolean[M + 1];
        isNotPrime[0] = isNotPrime[1] = true;

        for(int i=2 ; i*i <= M ; i++){
            if(!isNotPrime[i]){
                for(int j=i*i ; j<=M ; j+=i){
                    isNotPrime[j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=N ; i<=M ; i++){
            if(!isNotPrime[i]){
                sb.append(i).append('\n');
            }
        }

        System.out.println(sb.toString());
    }
}
