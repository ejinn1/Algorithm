import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    ArrayList<Integer> top = new ArrayList<>();
    ArrayList<Integer> bottom = new ArrayList<>();

    for (int i = 1; i <= N; i++) {
      if (i % 2 == 0) {
        top.add(sc.nextInt());
      } else {
        bottom.add(sc.nextInt());
      }
    }

    Collections.sort(top);
    Collections.sort(bottom);

    int cnt = 0;
    int min = Integer.MAX_VALUE;
    for (int i = 1; i <= M; i++) {
      int sum = N - lowerBound(bottom, i) - lowerBound(top, M - i + 1);
      if (sum < min) {
        min = sum;
        cnt = 1;
      } else if (sum == min) {
        cnt++;
      }
    }

    System.out.println(min + " " + cnt);

  }

  static int lowerBound(ArrayList<Integer> arr, int k) {
    int left = 0;
    int right = arr.size();

    while (left < right) {
      int mid = (left + right) / 2;
      if (arr.get(mid) >= k) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }

    return left;
  }
}