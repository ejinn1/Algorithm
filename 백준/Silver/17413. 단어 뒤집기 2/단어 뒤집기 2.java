

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.nextLine();

        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        boolean inTag = false;

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            if (ch == '<') {
                result.append(temp.reverse());
                temp.setLength(0);
                result.append(ch);
                inTag = true;
            } else if (ch == '>') {
                result.append(ch);
                inTag = false;
            } else if (inTag) {
                result.append(ch);
            } else {
                if(ch == ' '){
                    result.append(temp.reverse());
                    result.append(' ');
                    temp.setLength(0);
                } else {
                    temp.append(ch);
                }
            }
        }

        result.append(temp.reverse());
        System.out.println(result);

    }
}
