import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
      if(a[1] == b[1]) return a[0] - b[0];
      return a[1] - b[1];
    });

    for (int i = 0; i < N; i++) {
      int start = sc.nextInt();
      int end = sc.nextInt();
      pq.offer(new int[]{start, end});
    }


    int endTime = 0;
    int cnt = 0;
    while (!pq.isEmpty()) {
      int[] cur = pq.poll();
      int start = cur[0];
      int end = cur[1];

      if (endTime <= start) {
        cnt++;
        endTime = end;
      }
    }

    System.out.println(cnt);



  }
}