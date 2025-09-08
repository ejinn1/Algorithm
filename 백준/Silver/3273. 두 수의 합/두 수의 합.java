

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] nums = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < nums.length; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(nums);

    int X = Integer.parseInt(br.readLine());
    int result = 0;
    int l = 0;
    int r = N - 1;

    while(l < r){
      int sum = nums[l] + nums[r];
      if(sum == X){
        l++;
        r--;
        result++;
      } else if(sum < X) l++;
      else r--;
    }

    System.out.println(result);
  }

}
