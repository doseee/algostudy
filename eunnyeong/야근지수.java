import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i = 0; i < works.length; i++)
            q.add(works[i]);
        
        for (int i = 0; i < n; i++) {
            int x = q.poll();
            if (x - 1 < 0) return 0;
            q.add(x - 1);
        }
    
        long answer = 0;
        while(!q.isEmpty()) {
            int x = q.poll();
            answer += Math.pow(x, 2);
        }
    
        return answer;
    }
}
