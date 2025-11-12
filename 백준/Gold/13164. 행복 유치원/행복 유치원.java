import java.util.*;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);


    int N = sc.nextInt();
    int K = sc.nextInt();

    int[] h = new int[N];
    for (int i = 0; i < N; i++) {
      h[i] = sc.nextInt();
    }

    List<Integer> diffs = new ArrayList<>();
    for (int i = 0; i < N - 1; i++) {
      diffs.add(h[i + 1] - h[i]);
    }

//      2 2 1 4

    diffs.sort(Comparator.reverseOrder());

    int sum = 0;
    for (int i = K - 1; i < N - 1; i++) {
      sum += diffs.get(i);
    }
    System.out.println(sum);


  }
}