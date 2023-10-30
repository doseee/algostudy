import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    HashMap<Integer, Integer> h = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String s = st.nextToken();
      int k = Integer.parseInt(st.nextToken());

      if (s.equals("add")) {
        int v = Integer.parseInt(st.nextToken());
        h.put(k, v);
      }
      else if (s.equals("find")) {
        if (h.containsKey(k))
          sb.append(h.get(k) + "\n");
        else
          sb.append("None\n");
      }
      else
        h.remove(k);
    }

    bw.write(sb.toString());
    bw.close(); br.close();
  }
}
