import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    List<int[]> towns = new ArrayList<>();
    long sumA = 0;

    for (int i = 0; i < N; i++) {
      int x = sc.nextInt();
      int a = sc.nextInt();

      towns.add(new int[]{x, a});
      sumA += a;
    }

    towns.sort((a, b) -> a[0] - b[0]);

    long curA = 0;
    int result = 0;
    for (int i = 0; i < N; i++) {
      curA += towns.get(i)[1];
      if (curA >= (sumA + 1) / 2) {
        result = i;
        break;
      }
    }

    System.out.println(towns.get(result)[0]);

  }
}