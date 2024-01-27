import java.util.*;
import java.io.*;

public class Main {

  static int n, m, q;
  static int[][] a;
  static Point[] o;
  static boolean[] visit;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    q = Integer.parseInt(st.nextToken());

    a = new int[n + 1][m + 1];
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= m; j++)
        a[i][j] = Integer.parseInt(st.nextToken());
    }

    o = new Point[q];
    for (int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      char c = st.nextToken().charAt(0);
      int y = c == 'L' ? 0 : 1; //L = 0, R = 1
      o[i] = new Point(x, y);
    }

    for (int i = 0; i < q; i++) {
      visit = new boolean[n + 1];
      Point p = o[i];
      visit[p.x] = true;

      if (p.y == 0)
        left(p.x);
      else
        right(p.x);

      check(p.x, p.y);
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++)
        System.out.print(a[i][j] + " ");
      System.out.println();
    }

  }

  // 바람이 불었을때 왼쪽으로 미는 함수
  public static void left(int idx) {
    int[] t = new int[m + 1];

    for (int i = 1; i < m; i++)
      t[i + 1] = a[idx][i];
    t[1] = a[idx][m];

    for (int i = 1; i <= m; i++)
      a[idx][i] = t[i];
  }

  //바람이 불었을때 오른쪽으로 미는 함수
  public static void right(int idx) {
    int[] t = new int[m + 1];

    for (int i = 1; i < m; i++)
      t[i] = a[idx][i + 1];
    t[m] = a[idx][1];

    for (int i = 1; i <= m; i++)
      a[idx][i] = t[i];
  }

  // 위 아래 전파 가능한지 체크하는 함수
  public static void check(int idx, int d) {
    //위
    if (idx - 1 > 0) {
      for (int i = 1; i <= m; i++) {
        if (!visit[idx -1] && a[idx][i] == a[idx - 1][i]) {
          visit[idx - 1] = true;
          if (d == 1) {
            left(idx - 1);
            check(idx - 1, 0);
          }
          else {
            right(idx - 1);
            check(idx - 1, 1);
          }
          break;
        }
      }
    }

    //아래
    if (idx + 1 <= n) {
      for (int i = 1; i <= m; i++) {
        if (!visit[idx + 1] && a[idx][i] == a[idx + 1][i]) {
          visit[idx + 1] = true;
          if (d == 1) {
            left(idx + 1);
            check(idx + 1, 0);
          }
          else {
            right(idx + 1);
            check(idx + 1, 1);
          }
          break;
        }
      }
    }
  }

}
