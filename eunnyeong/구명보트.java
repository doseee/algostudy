import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        int n = people.length;
        Arrays.sort(people);
        
        int s = 0, e = n - 1;
        while(s <= e) {
            if (people[s] + people[e] > limit) {
                e--;
                answer++;
            }
            else {
                s++;
                e--;
                answer++;
            }      
        }
        
        return answer;
    }
}
