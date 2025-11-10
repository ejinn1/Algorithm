import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    int[][] lec = new int[N][2];

    for (int i = 0; i < N; i++) {
      int s = sc.nextInt();
      int e = sc.nextInt();

      lec[i][0] = s;
      lec[i][1] = e;
    }

    Arrays.sort(lec, (a, b) -> {
      if (a[0] == b[0]) return a[1] - b[1];
      return a[0] - b[0];
    });

    PriorityQueue<Integer> rooms = new PriorityQueue<>();

    for (int i = 0; i < N; i++) {
      int start = lec[i][0];
      int end = lec[i][1];

      if (!rooms.isEmpty() && rooms.peek() <= start) {
        rooms.poll();
      }
      rooms.offer(end);
    }

    System.out.println(rooms.size());
  }
}