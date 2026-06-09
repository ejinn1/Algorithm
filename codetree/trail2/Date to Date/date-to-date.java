import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        int sum = 0;
        for(int i=m1 ; i<=m2 ; i++){
            sum += days[i];
        }

        sum -= d1;
        sum -= (days[m2]-d2-1);

        System.out.println(sum);

    }
}