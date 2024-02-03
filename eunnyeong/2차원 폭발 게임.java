import java.util.*;
import java.io.*;

public class Main {

  static int n, m, k;
  static int[][] a;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    a = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++)
        a[i][j] = Integer.parseInt(st.nextToken());
    }

    for (int t = 0; t < k; t++) {
      bomb();
      rotate();
    }
    bomb();
    
    int ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++)
        if (a[i][j] != 0)
          ans++;
    }

    System.out.println(ans);
  }

  public static void bomb() {
    for (int i = 0; i < n; i++)
      calc(i);
    move();
    if (check())
      bomb();
  }

  //폭탄 터트리기
  public static void calc(int idx) {
    int t = a[0][idx], cnt = 1, tx = 0;

    for (int i = 1; i < n; i++) {
      if (t == a[i][idx])
        cnt++;
      else {
        if (cnt >= m && t!= 0) {
          for (int j = tx; j < i; j++)
            if (a[j][idx] != 0)
              a[j][idx] = 0;
        }
        t = a[i][idx];
        cnt = 1;
        tx = i;
      }
    }

    if (cnt >= m && t != 0)
      for (int j = tx; j < n; j++)
        a[j][idx] = 0;
  }

  //터질게 없는지 체크
  public static boolean check() {
    int cnt = 1, t = a[0][0];
    for (int i = 0; i < n; i++) {
      t = a[0][i]; cnt = 1;
      for (int j = 1; j < n; j++) {
        if (t == a[j][i])
          cnt++;
        else {
          if (cnt >= m && t != 0)
            return true;
          cnt = 1;
          t = a[j][i];
        }
      }
      if (cnt >= m && t != 0)
        return true;
    }

    return false;
  }

  //폭탄 내리기
  public static void move(){
    for (int i = 0; i < n; i++) {
      Stack<Integer> s = new Stack<>();
      for (int j = 0; j < n; j++) {
        if (a[j][i] != 0) {
          s.add(a[j][i]);
          a[j][i] = 0;
        }
      }

      int idx = 0;
      while (!s.empty()) {
        a[n - idx - 1][i] = s.pop();
        idx++;
      }
    }
  }

  //배열 90도 회전
  public static void rotate() {
    int[][] tmp = new int[n][n];

    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        tmp[j][i] = a[n - i - 1][j];

    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        a[i][j] = tmp[i][j];

    move();
  }
}
