import java.util.*;

public class Main {
    static List<Character> characters = new ArrayList<>();
    static int[] value = new int[6];

    static String expression;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        expression = sc.next();

        // 식에 등장하는 알파벳을 중복 없이 저장
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch >= 'a' && ch <= 'f' && !characters.contains(ch)) {
                characters.add(ch);
            }
        }

        dfs(0);

        System.out.println(answer);
    }

    static void dfs(int depth) {
        // 모든 알파벳에 숫자를 배정한 경우
        if (depth == characters.size()) {
            answer = Math.max(answer, calculate());
            return;
        }

        char ch = characters.get(depth);
        int index = ch - 'a';

        // 현재 알파벳에 1~4 중 하나를 배정
        for (int number = 1; number <= 4; number++) {
            value[index] = number;
            dfs(depth + 1);
        }
    }

    static int calculate() {
        // 식의 첫 번째 알파벳 값
        int result = value[expression.charAt(0) - 'a'];

        // 연산자와 다음 알파벳을 하나씩 처리
        for (int i = 1; i < expression.length(); i += 2) {
            char operator = expression.charAt(i);
            char nextCharacter = expression.charAt(i + 1);

            int nextValue = value[nextCharacter - 'a'];

            if (operator == '+') {
                result += nextValue;
            } else if (operator == '-') {
                result -= nextValue;
            } else if (operator == '*') {
                result *= nextValue;
            }
        }

        return result;
    }
}