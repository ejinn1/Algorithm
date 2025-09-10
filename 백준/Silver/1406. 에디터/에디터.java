

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input = br.readLine();
    int N = Integer.parseInt(br.readLine());

    LinkedList<Character> editor = new LinkedList<>();

    for (int i = 0; i < input.length(); i++) {
      editor.addLast(input.charAt(i));
    }

    StringTokenizer st;
    ListIterator<Character> cursor = editor.listIterator(editor.size());
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      String option = st.nextToken();

      switch (option) {
        case "P": {
          char s = st.nextToken()
                  .charAt(0);
          cursor.add(s);
          break;
        }
        case "L": {
          if(cursor.hasPrevious()) cursor.previous();
          break;
        }
        case "D": {
          if(cursor.hasNext()) cursor.next();
          break;
        }
        case "B": {
          if (cursor.hasPrevious()) {
            cursor.previous();
            cursor.remove();
          }
          break;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (char c : editor) sb.append(c);
    System.out.println(sb);

  }

}
