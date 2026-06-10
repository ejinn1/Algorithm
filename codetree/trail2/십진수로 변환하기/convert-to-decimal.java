import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String binary = sc.nextLine();

        int n = 0;
        for(int i=0 ; i<binary.length() ; i++){
            n += Math.pow(2, (binary.length() - i - 1)) * (binary.charAt(i) - '0');
        }

        System.out.println(n);
    }
}