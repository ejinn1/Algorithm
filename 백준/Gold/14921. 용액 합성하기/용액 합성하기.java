import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    int[] woters = new int[N];

    for (int i = 0; i < N; i++) {
      woters[i] = sc.nextInt();
    }

    int i = 0, j = woters.length - 1;

    int result = Integer.MAX_VALUE;
    while (i < j) {
      int sum = woters[i] + woters[j];
      if(sum == 0){
        result = 0;
        break;
      } else if (sum < 0) {
        i++;
      } else {
        j--;
      }

      if (Math.abs(result) > Math.abs(sum)) {
        result = sum;
      }
    }

    System.out.println(result);
  }
}