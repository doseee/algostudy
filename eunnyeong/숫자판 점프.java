import java.util.*;
import java.io.*;

public class Main {

  static int[][] a;
  static HashSet<String> h;
  static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    a = new int[5][5];
    for (int i = 0; i < 5; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 5; j++)
        a[i][j] = Integer.parseInt(st.nextToken());
    }

    h = new HashSet<>();
    for (int i = 0; i < 5; i++)
      for (int j = 0; j < 5; j++)
        dfs(i, j, String.valueOf(a[i][j]), 0);

    System.out.print(h.size());
  }

  public static void dfs(int x, int y, String s, int d) {
    if (d == 5) {
      if (h.contains(s))
        return;
      h.add(s);
      return;
    }

    for (int k = 0; k < 4; k++) {
      int nx = x + dx[k], ny = y + dy[k];
      if (range(nx, ny))
        dfs(nx, ny, s + String.valueOf(a[nx][ny]), d + 1);
    }
  }

  public static boolean range(int nx, int ny) {
    return nx >= 0 && nx < 5 && ny >= 0 && ny < 5;
  }
}
