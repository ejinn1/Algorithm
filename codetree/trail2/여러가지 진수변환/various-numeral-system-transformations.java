import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        int n = sc.nextInt();
        int b = sc.nextInt();

        StringBuffer sb = new StringBuffer();

        while(true){
            if(n < b){
                sb.append(n);
                break;
            }

            sb.append(n % b);
            n /= b;
        }

        System.out.println(sb.reverse());
    }
}