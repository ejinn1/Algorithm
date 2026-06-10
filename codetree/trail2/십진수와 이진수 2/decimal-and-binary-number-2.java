import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String binary = sc.nextLine();

        int n = 0;

        for(int i=0 ; i<binary.length() ; i++){
            n = n * 2 + (binary.charAt(i) - '0');
        }

        StringBuffer sb = new StringBuffer();

        n *= 17;
        
        while(true){
            if(n < 2){
                sb.append(n);
                break;
            }

            sb.append(n % 2);
            n /= 2;
        }

        System.out.println(sb.reverse());
    }
}