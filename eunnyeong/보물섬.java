import java.util.*;
import java.io.*;

public class Main {

  static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
  static int n, m, ans;
  static char[][] map;

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    map = new char[n][m];
    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      map[i] = s.toCharArray();
    }

    ans = 0;
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        if (map[i][j] == 'L')
          bfs(i, j);

    System.out.print(ans);
  }

  public static void bfs(int x, int y) {
    boolean[][] visit = new boolean[n][m];
    Queue<Point> q = new ArrayDeque<>();
    q.add(new Point(x, y, 0));
    visit[x][y] = true;

    int max = 0;
    while (!q.isEmpty()) {
      Point p = q.poll();
      max = Math.max(max, p.d);

      for (int k = 0; k < 4; k++) {
        int nx = p.x + dx[k], ny = p.y + dy[k];
        if (range(nx, ny) && !visit[nx][ny] && map[nx][ny] == 'L') {
            q.add(new Point(nx, ny, p.d + 1));
            visit[nx][ny] = true;
        }
      }
    }

    ans = Math.max(ans, max);
  }

  public static boolean range(int nx, int ny) {
    return nx >= 0 && nx < n && ny >= 0 && ny < m;
  }

  public static class Point {
    int x, y, d;

    public Point(int x, int y, int d) {
      this.x = x;
      this.y = y;
      this.d = d;
    }
  }
}
