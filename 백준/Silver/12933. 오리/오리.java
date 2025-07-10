import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] str = sc.nextLine().split("");
//        int[] step = new int[5];
        List<Integer> ducks = new ArrayList<>();

        int max = 0;
        for(int i=0 ; i<str.length ; i++){
            int step = getStep(str[i]);
            boolean matched = false;

            for(int j=0 ; j<ducks.size() ; j++){
                if (ducks.get(j) == step - 1) {
                    ducks.set(j, step);
                    matched = true;
                    break;
                }
            }

            if(!matched){
                if(step == 0){
                    ducks.add(0);
                    matched = true;
                } else {
                    System.out.println(-1);
                    return;
                }
            }

            ducks.removeIf(d -> d == 4);

            max = Math.max(max, ducks.size());
        }

        if (!ducks.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(max);
        }
    }

    static int getStep(String ch){
        return "quack".indexOf(ch);
    }
}
