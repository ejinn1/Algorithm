import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        printStar(n);

    }

    static void printStar(int n){
        if(n == 0) return;

        for(int i=0 ; i<n ; i++){
            System.out.print("*" + " ");
        }
        System.out.println();
        printStar(n-1);
        for(int i=0 ; i<n ; i++){
            System.out.print("*" + " ");
        }
        System.out.println();
    }
}