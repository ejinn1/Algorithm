

import java.util.Scanner;

public class Main {
    static char[][] table = new char[4][4];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder(str);

        initTable();

        while(sb.length() != 1){
            int len = sb.length();
            char a = sb.charAt(len - 2);
            char b = sb.charAt(len - 1);
            char r = table[idx(a)][idx(b)];

            sb.setLength(len-2);
            sb.append(r);
        }

        System.out.println(sb);
    }

    static int idx(char ch) {
        switch (ch) {
            case 'A': return 0;
            case 'G': return 1;
            case 'C': return 2;
            case 'T': return 3;
        }
        return -1;
    }

    static void initTable() {
        // A
        table[idx('A')][idx('A')] = 'A';
        table[idx('A')][idx('G')] = 'C';
        table[idx('A')][idx('C')] = 'A';
        table[idx('A')][idx('T')] = 'G';
        // G행
        table[idx('G')][idx('A')] = 'C';
        table[idx('G')][idx('G')] = 'G';
        table[idx('G')][idx('C')] = 'T';
        table[idx('G')][idx('T')] = 'A';
        // C행
        table[idx('C')][idx('A')] = 'A';
        table[idx('C')][idx('G')] = 'T';
        table[idx('C')][idx('C')] = 'C';
        table[idx('C')][idx('T')] = 'G';
        // T행
        table[idx('T')][idx('A')] = 'G';
        table[idx('T')][idx('G')] = 'A';
        table[idx('T')][idx('C')] = 'G';
        table[idx('T')][idx('T')] = 'T';
    }
}
