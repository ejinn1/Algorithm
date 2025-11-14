import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    sc.nextLine();
    char[] colors = sc.nextLine()
            .toCharArray();

    char startColor = colors[0];
    char nextColor = startColor == 'R' ? 'B' : 'R';
    int result = 1;
    for (int i = 0; i < N - 1; i++) {
      if (colors[i] == startColor && colors[i+1] == nextColor) result++; 
    }

    System.out.println(result);

  }
}