import java.io.*;
import java.util.*;

public class Main {

  static int[] dp;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      int x = Integer.parseInt(br.readLine());
      dp = new int[11];

      dp[1] = 1;
      dp[2] = 2;
      dp[3] = 4;

      System.out.println(calc(x));
    }
  }

  public static int calc(int x) {
    if (x == 1 || x == 2 || x == 3) return dp[x];

    return dp[x] = calc(x - 1) + calc(x - 2) + calc(x - 3);
  }
}
