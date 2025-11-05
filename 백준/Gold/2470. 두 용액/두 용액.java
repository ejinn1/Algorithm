import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] woters = new int[N];
    for (int i = 0; i < N; i++) {
      woters[i] = sc.nextInt();
    }

    int min = Integer.MAX_VALUE;
    int i = 0;
    int j = woters.length - 1;
    Arrays.sort(woters);
    List<Integer> result = new ArrayList<>();
    while (i < j) {
      int sum = woters[i] + woters[j];
      int sumAbs = Math.abs(sum);
      if(min > sumAbs){
        min = sumAbs;
        result = new ArrayList<>();
        result.add(woters[i]);
        result.add(woters[j]);
      }

      if(sum == 0){
        i++;
        j--;
      } else if (sum < 0) {
        i++;
      } else {
        j--;
      }
    }

    result.sort((a, b) -> a - b);
    StringBuilder sb = new StringBuilder();
    for (int t = 0; t < result.size(); t++) {
      sb.append(result.get(t))
              .append(" ");
    }

    System.out.println(sb);
  }
}