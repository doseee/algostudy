import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int max = 0;
    HashMap<String, Integer> h = new HashMap<>();
    for (int i = 0; i < n; i++) {
      String x = br.readLine();
      h.put(x, h.getOrDefault(x, 0) + 1);
      max = Math.max(max, h.get(x));
    }

    System.out.print(max);
  }
}
