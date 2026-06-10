import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        String n = sc.next();

        int num = 0;
        for(int i=0 ; i<n.length() ; i++){
            num = num * a + (n.charAt(i) - '0');
        }

        StringBuffer sb = new StringBuffer();

        while(true){
            if(num < b){
                sb.append(num);
                break;
            }

            sb.append(num % b);
            num /= b;
        }

        System.out.println(sb.reverse());
    }
}