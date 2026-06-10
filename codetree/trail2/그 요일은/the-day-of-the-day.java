import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dates = new int[]{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        List<String> days = Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");

        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        String day = sc.next();

        int start = getDateCount(m1, d1, dates);
        int end = getDateCount(m2, d2, dates);

        int totalDays = end - start + 1;

        int target = 0;
        for(int i=0 ; i<7 ; i++){
            if(day.equals(days.get(i))){
                target = i;
                break;
            }
        }
        
        int answer = 0;

        for (int i = 0; i < totalDays; i++) {
            if (i % 7 == target) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    static int getDateCount(int month, int day, int[] dates) {
        int count = 0;

        for (int i = 1; i < month; i++) {
            count += dates[i];
        }

        count += day;

        return count;
    }
}