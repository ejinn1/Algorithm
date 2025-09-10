

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      LinkedList<Character> str = new LinkedList<>();
      ListIterator<Character> cursor = str.listIterator();

      for (char ch : s.toCharArray()) {
        if (ch == '<') {
          if(cursor.hasPrevious()) cursor.previous();
        } else if (ch == '>') {
          if(cursor.hasNext()) cursor.next();
        } else if (ch == '-') {
          if(cursor.hasPrevious()) {
            cursor.previous();
            cursor.remove();
          }
        } else {
          cursor.add(ch);
        }
      }

      StringBuilder sb = new StringBuilder();
      for (char ch : str) {
        sb.append(ch);
      }
      System.out.println(sb);
      
    }


  }

}
