import java.util.*;

class Solution {
    boolean[] visit;
    int n;
    int flag;
    
    public int solution(int[][] routes) {
        int answer = 0;
        
        n = routes.length;
        visit = new boolean[n];
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        
        for (int i = 0; i < n; i++) {
            if (visit[i]) continue;
            
            flag = 0;
            check(routes[i][1], routes);
            if (flag != 0)
                answer++;
               
            if (count()) break;
            
        }
        
        if (answer == 0)
            answer = n;
        
        return answer;
    }
    
    public boolean count() {
        for (int i = 0; i < visit.length; i++)
            if (!visit[i])
                return false;
        return true;
    }
    
    public void check(int num, int[][] routes) {
        for (int i = 0; i < n; i++) {
            int x = routes[i][0], y = routes[i][1];
            if (num >= x && num <= y && !visit[i]) {
                visit[i] = true;
                flag++;
            }
        }
    }
}
