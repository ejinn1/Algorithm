import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        sc.nextLine();

        for(int i=0 ; i<num ; i++){
            String str = sc.nextLine();
            char[] arr = str.toCharArray();

            int t = arr.length - 2;
            while(t >= 0 && arr[t] >= arr[t+1]){
                t--;
            }

            if(t == -1){
                System.out.println(str);
                continue;
            }

            int k = arr.length - 1;
            while(arr[k] <= arr[t]){
                k--;
            }

            char temp = arr[t];
            arr[t] = arr[k];
            arr[k] = temp;

            reverse(arr, t + 1, arr.length - 1);

            System.out.println(String.valueOf(arr));
        }
    }

    private static void reverse(char [] arr, int start, int end){
        while(start < end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
