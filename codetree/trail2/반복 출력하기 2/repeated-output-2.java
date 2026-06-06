import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        printHello(n);
    }

    static void printHello(int n){
        if(n == 0) return;

        printHello(n - 1);

        System.out.println("HelloWorld");
    }
}