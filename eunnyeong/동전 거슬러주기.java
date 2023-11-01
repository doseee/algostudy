import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[] a = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(st.nextToken());

    int[] dp = new int[10001];
    for (int i = 0; i < n; i++)
      dp[a[i]] = 1;

    for (int i = 1; i <= m; i++) {
      if (dp[i] == 1) continue;
      for (int j = 0; j < n; j++) {
        if (i - a[j] > 0 && dp[i -a[j]] > 0) {
          if (dp[i] == 0)
            dp[i] = dp[i - a[j]] + 1;
          else
            dp[i] = Math.min(dp[i - a[j]] + 1, dp[i]);
        }
      }
    }
    if (dp[m] == 0)
        dp[m] = -1;
    System.out.println(dp[m]);
  }
}
