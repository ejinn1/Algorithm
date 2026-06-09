import java.util.*;
import java.time.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> days = Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");

        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        LocalDate start = LocalDate.of(2011, m1, d1);
        LocalDate end = LocalDate.of(2011, m2, d2);

        int k = start.getDayOfWeek().getValue();
        int result = end.getDayOfWeek().getValue();

        int t = result - k;

        int idx = (int) (t % 7);
        if(idx < 0){
            idx += 7;
        }

        System.out.println(days.get(idx));
    }
}