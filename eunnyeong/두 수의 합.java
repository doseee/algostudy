import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    long[] a = new long[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++)
      a[i] = Long.parseLong(st.nextToken());

    HashMap<Long, Long> hm = new HashMap<>();
    int ans = 0;
    for (int i = 0; i < n; i++) {
      long t = m - a[i];

      if (hm.containsKey(t))
        ans += hm.get(t);

      hm.put(a[i], hm.getOrDefault(a[i], Long.valueOf(0)) + 1);
    }

    System.out.print(ans);
  }
}
