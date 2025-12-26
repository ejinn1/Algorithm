import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();


    int max = 0;
    ArrayList<int[]> arr = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      int L = sc.nextInt();
      int H = sc.nextInt();

      arr.add(new int[]{L, H});
      max = Math.max(max, H);
    }

    arr.sort(Comparator.comparingInt(a -> a[0]));

    int leftMax = -1;
    int rightMax = -1;
    for (int i = 0; i < N; i++) {
      if (arr.get(i)[1] == max) {
        if(leftMax == -1) leftMax = i;
        rightMax = i;
      }
    }

    int result = 0;
    int curMax = 0;
    for (int i = 0; i < leftMax; i++) {
      curMax = Math.max(curMax, arr.get(i)[1]);
      int w = arr.get(i + 1)[0] - arr.get(i)[0];
      result += curMax * w;
    }

    curMax = 0;
    for (int i = N - 1; i > rightMax; i--) {
      curMax = Math.max(curMax, arr.get(i)[1]);
      int w = arr.get(i)[0] - arr.get(i - 1)[0];
      result += curMax * w;
    }

    result += (arr.get(rightMax)[0] - arr.get(leftMax)[0] + 1) * max;


    System.out.println(result);
  }
}