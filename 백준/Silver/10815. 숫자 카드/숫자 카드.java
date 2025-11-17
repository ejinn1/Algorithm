import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    int[] cards = new int[N];
    for (int i = 0; i < N; i++) {
      cards[i] = sc.nextInt();
    }

    Arrays.sort(cards);

    int M = sc.nextInt();

    int[] targets = new int[M];

    for (int i = 0; i < M; i++) {
      targets[i] = sc.nextInt();
    }

    int[] result = new int[M];
    int i = 0;
    for (int target : targets) {
      int left = 0;
      int right = cards.length - 1;
      boolean isFounded = false;
      while (left <= right) {
        int mid = (right + left) / 2;

        if (cards[mid] == target) {
          isFounded = true;
          break;
        } else if (cards[mid] > target) {
          right = mid - 1;
        } else if (cards[mid] < target) {
          left = mid + 1;
        }
      }

      if(isFounded) result[i] = 1;
      else result[i] = 0;

      i++;
    }

    StringBuilder sb = new StringBuilder();
    for (int k = 0; k < result.length; k++) {
      sb.append(result[k])
              .append(" ");
    }

    System.out.println(sb);
  }
}