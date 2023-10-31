import java.util.*;
import java.io.*;
import java.util.Map.Entry;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    HashMap<String, Integer> h = new HashMap<>();
    for (int i = 1; i <= n; i++) {
      String x = br.readLine();
      h.put(x, i);
    }

    HashMap<Integer, String> h2 = new HashMap<>();
    for (Entry<String, Integer> e : h.entrySet())
      h2.put(e.getValue(), e.getKey());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      String s = br.readLine();
      if (Character.isDigit(s.charAt(0))) {
        int x = Integer.parseInt(s);
        sb.append(h2.get(x) + "\n");
      }
      else
        sb.append(h.get(s) + "\n");
    }

    bw.write(sb.toString());
    bw.close(); br.close();
  }
}
