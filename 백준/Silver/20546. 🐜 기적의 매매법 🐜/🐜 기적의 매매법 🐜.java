import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int seed = sc.nextInt();
    int N = 14;

    int[] prices = new int[N];
    for (int i = 0; i < N; i++) {
      prices[i] = sc.nextInt();
    }

    int junSeed = seed;
    Map<Integer, Integer> junBankBook = new HashMap<>();
    for (int i = 0; i < N; i++) {
      int price = prices[i];
      if (junSeed >= price) {
        int cnt = junSeed / price;
        junBankBook.put(price, cnt);
        junSeed -= cnt * price;
      }
    }

    int junResult = junSeed;
    for (int price : junBankBook.keySet()) {
      junResult += prices[N - 1] * junBankBook.get(price);
    }


    int sungSeed = seed;
    int downCnt = 0;
    int upCnt = 0;
    int prev = prices[0];
    Map<Integer, Integer> sungBankBook = new HashMap<>();
    for (int i = 1; i < N; i++) {
      int price = prices[i];
      if(prev > price){
        downCnt++;
        upCnt = 0;
      } else if (prev < price) {
        upCnt++;
        downCnt = 0;
      } else {
        upCnt = 0;
        downCnt = 0;
      }

      if (downCnt >= 3) {
        int cnt = sungSeed / price;
        sungBankBook.put(price, cnt);
        sungSeed -= cnt * price;
      } else if (upCnt >= 3) {
        for (int p : sungBankBook.keySet()) {
          sungSeed += price * sungBankBook.get(p);
        }
        sungBankBook.clear();
      }
      prev = price;
    }

    int sungResult = sungSeed;
    for (int price : sungBankBook.keySet()) {
      sungResult += prices[N - 1] * sungBankBook.get(price);
    }

    System.out.println(junResult > sungResult ? "BNP" : junResult == sungResult ? "SAMESAME" : "TIMING");

  }
}