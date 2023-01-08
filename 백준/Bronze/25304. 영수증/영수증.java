import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger x = scanner.nextBigInteger();
        int n = scanner.nextInt();
        BigInteger sum = new BigInteger("0");

        for (int i=0;i<n;i++){
            BigInteger a = scanner.nextBigInteger();
            BigInteger b = scanner.nextBigInteger();

            sum = sum.add((a.multiply(b)));
        }

        if(x.equals(sum)){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}
