import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        printNumAsc(n);
        System.out.println("");
        printNumDesc(n);
    }

    static void printNumAsc(int n){
        if(n == 0) return;

        printNumAsc(n-1);

        System.out.print(n + " ");
    }
    static void printNumDesc(int n){
        if(n == 0) return;

        System.out.print(n + " ");
        
        printNumDesc(n-1);
    }
}