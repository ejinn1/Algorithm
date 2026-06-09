import java.util.*;
import java.time.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        LocalDateTime start = LocalDateTime.of(2024, 11, 11, 11, 11);
        LocalDateTime end = LocalDateTime.of(2024, 11, A, B, C);

        long diff = Duration.between(start, end).toMinutes();

        if (diff < 0) {
            System.out.println(-1);
        } else {
            System.out.println(diff);
        }
    }
}