import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int W = sc.nextInt();

    int[][] arr = new int[H][W];

    for (int j = 0; j < W; j++) {
      int h = sc.nextInt();
      for (int i = 0; i < h; i++) {
        arr[i][j] = 1;
      }
    }

    int result = 0;
    for (int i = 0; i < H; i++) {
      int j = 0;
      boolean isStart = false;
      List<Integer> waters = new ArrayList<>();
      List<Integer> temp = new ArrayList<>();
      while (j < W) {
        if (arr[i][j] == 1 && !isStart) {
          isStart = true;
          temp = new ArrayList<>();
          j++;
        } else if (arr[i][j] == 0 && isStart) {
          temp.add(j);
          j++;
        } else if (arr[i][j] == 1 && isStart) {
          waters.addAll(temp);
          isStart = false;
        } else {
          j++;
        }
      }

      result += waters.size();
    }

    System.out.println(result);
  }
}