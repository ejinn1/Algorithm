

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    LinkedList<Integer> doDeck = new LinkedList<>();
    LinkedList<Integer> suDeck = new LinkedList<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      doDeck.addFirst(Integer.parseInt(st.nextToken()));
      suDeck.addFirst(Integer.parseInt(st.nextToken()));
    }

    LinkedList<Integer> doGround = new LinkedList<>();
    LinkedList<Integer> suGround = new LinkedList<>();

    for (int i = 0; i < M; i++) {
      if (i % 2 == 0) {
        doGround.addFirst(doDeck.removeFirst());
      } else {
        suGround.addFirst(suDeck.removeFirst());
      }

      if (doDeck.isEmpty()) {
        System.out.println("su");
        return;
      } else if (suDeck.isEmpty()) {
        System.out.println("do");
        return;
      }

      Integer doCard = doGround.peekFirst();
      Integer suCard = suGround.peekFirst();

      if (doCard != null && suCard != null && doCard + suCard == 5) {
        // 수연이가 다 가져감
        while(!doGround.isEmpty()){
          suDeck.addLast(doGround.removeLast());
        }
        while (!suGround.isEmpty()) {
          suDeck.addLast(suGround.removeLast());
        }
      } else if ((doCard != null && doCard == 5) || (suCard != null && suCard == 5)) {
        // 도도가 가져감
        while(!suGround.isEmpty()){
          doDeck.addLast(suGround.removeLast());
        }
        while (!doGround.isEmpty()) {
          doDeck.addLast(doGround.removeLast());
        }
      }
    }

    System.out.println(doDeck.size() > suDeck.size() ? "do" : doDeck.size() < suDeck.size() ? "su" : "dosu");

  }
}
