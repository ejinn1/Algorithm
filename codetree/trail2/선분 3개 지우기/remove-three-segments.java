import java.util.*;

public class Main {
    static int MAX_X = 100;

    static class Line{
        int a;
        int b;

        Line(int a, int b){
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        List<Line> line = new ArrayList<>();

        for(int i=0 ; i<N ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            line.add(new Line(a, b));
        }
        
        int cnt = 0;
        for(int k=0 ; k<N-2 ; k++){
            for(int p=k+1 ; p<N-1 ; p++){
                for(int t=p+1 ; t<N ; t++){
                    boolean possible = true;
                    int[] X = new int[MAX_X+1];

                    for(int i=0 ; i<N ; i++){
                        if(i == k || i == p || i == t) continue;

                        int a = line.get(i).a;
                        int b = line.get(i).b;

                        for(int x=a ; x<=b ; x++){
                            X[x]++;
                            if(X[x] > 1){
                                possible = false;
                                break;
                            }
                        }

                        if(!possible) break;
                    }

                    if(possible) {
                        cnt++;
                    }
                }
            }
        }

        System.out.print(cnt);
    }
}