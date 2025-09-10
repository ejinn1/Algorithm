

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    LinkedList<Integer> cups = new LinkedList<>();

    for (int i = 0; i < N; i++) {
      cups.add(sc.nextInt());
    }

    int max = 0;
    int left = 0;
    int right = 0;
    for (int i = 0; i < N; i++) {
      if(cups.get(i) > max){
        left++;
        max = cups.get(i);
      }
    }
    max = 0;
    for (int i = N - 1; i >= 0; i--) {
      if (cups.get(i) > max) {
        right++;
        max = cups.get(i);
      }
    }

    System.out.println(left);
    System.out.println(right);
  }
}
