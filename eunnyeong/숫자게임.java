import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int a = 0, b = 0;
        while (true) {
            if (A[a] < B[b]) {
                answer++;
                a++; b++;
            }
            else
                b++;
            
            if (b >= B.length) break;
        }
        
        return answer;
    }
}
