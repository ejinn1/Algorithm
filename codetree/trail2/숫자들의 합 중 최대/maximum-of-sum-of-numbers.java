import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        int max = 0;

        for (int num = x; num <= y; num++) {
            String str = String.valueOf(num);
            int sum = 0;

            for (int i = 0; i < str.length(); i++) {
                sum += str.charAt(i) - '0';
            }

            max = Math.max(max, sum);
        }

        System.out.println(max);

        
    }
}