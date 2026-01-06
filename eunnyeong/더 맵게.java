import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for (int i = 0; i < scoville.length; i++)
            q.add(scoville[i]);

        while (true) {
            if (q.peek() >= K) 
                return answer;  
            if (q.size() < 2)
                return -1;
            
            int x = q.poll();
            int y = q.poll();
        
            int sum = x + y * 2;
            q.add(sum);
            
            answer++;      
        }
    }
}
