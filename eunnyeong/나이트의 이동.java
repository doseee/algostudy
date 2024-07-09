import java.util.*;
import java.io.*;

public class Main {

  static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2}, dy = {-1, 1, -2, 2, -2, 2, -1, 1};
  static int n, x, y, s, e;

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    for (int k = 0; k < t; k++) {
      n = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      x = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      s = Integer.parseInt(st.nextToken());
      e = Integer.parseInt(st.nextToken());

      System.out.println(bfs());
    }
  }

  public static int bfs() {
    boolean[][] visit = new boolean[n][n];
    Queue<Point> q = new ArrayDeque<>();
    q.add(new Point(x, y, 0));
    visit[x][y] = true;

    while (!q.isEmpty()) {
      Point p = q.poll();

      if (p.x == s && p.y == e)
        return p.d;

      for (int k = 0; k < 8; k++) {
        int nx = p.x + dx[k], ny = p.y + dy[k];
        if (range(nx, ny) && !visit[nx][ny]) {
          q.add(new Point(nx, ny, p.d + 1));
          visit[nx][ny] = true;
        }
      }
    }

    return 0;
  }

  public static boolean range(int nx, int ny) {
    return nx >= 0 && nx < n && ny >= 0 && ny < n;
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
