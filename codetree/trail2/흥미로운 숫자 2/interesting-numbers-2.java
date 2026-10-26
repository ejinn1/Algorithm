import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        int cnt = 0;
        for (int k = x; k <= y; k++) {
            String str = String.valueOf(k);
            int[] nums = new int[10];

            for (int i = 0; i < str.length(); i++) {
                nums[str.charAt(i) - '0']++;
            }

            int differentDigits = 0;
            int oneDigitCount = 0;

            for (int i = 0; i < 10; i++) {
                if (nums[i] > 0) {
                    differentDigits++;
                    if (nums[i] == 1) {
                        oneDigitCount++;
                    }
                }
            }

            if (differentDigits == 2 && oneDigitCount == 1) {
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}