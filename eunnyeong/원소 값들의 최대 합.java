import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[] a = new int[n + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++)
      a[i] = Integer.parseInt(st.nextToken());

    int ans = 0;
    for (int i = 1; i <= n; i++) {
      int sum = 0, x = a[i];
      for (int j = 0; j < m; j++) {
        sum += x;
        x = a[x];
      }
      ans = Math.max(sum, ans);
    }

    System.out.print(ans);
  }
}
