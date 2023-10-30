import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    HashMap<Integer, Integer> h = new HashMap<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int x = Integer.parseInt(st.nextToken());
      h.put(x, h.getOrDefault(x, 0) + 1);
    }

    StringBuilder sb = new StringBuilder();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      int x = Integer.parseInt(st.nextToken());
      if (h.containsKey(x))
        sb.append(h.get(x) + " ");
      else
        sb.append("0 ");
    }

    bw.write(sb.toString());
    bw.close(); br.close();
  }
}
