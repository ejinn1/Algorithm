import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Integer> A = new ArrayList<>();
        A.add(0);

        for(int i=0 ; i<N ; i++){
            char dir = sc.next().charAt(0);
            int c = sc.nextInt();

            for(int j=0 ; j<c ; j++){
                if(dir == 'R'){
                    A.add(A.get(A.size() - 1) + 1);
                } else if(dir == 'L'){
                    A.add(A.get(A.size() - 1) - 1);
                }
            }
        }

        List<Integer> B = new ArrayList<>();
        B.add(0);

        for(int i=0 ; i<M ; i++){
            char dir = sc.next().charAt(0);
            int c = sc.nextInt();

            for(int j=0 ; j<c ; j++){
                if(dir == 'R'){
                    B.add(B.get(B.size() - 1) + 1);
                } else if(dir == 'L'){
                    B.add(B.get(B.size() - 1) - 1);
                }
            }
        }

        int len = Math.min(A.size(), B.size());

        int result = -1;
        for(int t=1 ; t<len ; t++){
            int a = A.get(t);
            int b = B.get(t);

            if(a == b){
                result = t;
                break;
            }
        }

        System.out.println(result);
    }
}