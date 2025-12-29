import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int total = Arrays.stream(number).sum();
        
        HashMap<String, Integer> h = new HashMap<String, Integer>();
        for (int i = 0; i < want.length; i++)
            h.put(want[i], 0);

        int answer = 0;
        for (int i = 0; i < total; i++)
            if (h.containsKey(discount[i]))
                h.put(discount[i], h.get(discount[i]) + 1);
        
        if (check(h, want, number)) answer++;
        
        for (int i = total; i < discount.length; i++) {
            if (h.containsKey(discount[i - total]))
                h.put(discount[i - total], h.get(discount[i - total]) - 1);
            
            if (h.containsKey(discount[i]))
                h.put(discount[i], h.get(discount[i]) + 1);
            
            if (check(h, want, number)) answer++;
        }
        
        return answer;
    }
    
    public boolean check (HashMap<String, Integer> h, String[] want, int[] number) {
        for (int i = 0; i < want.length; i++)
            if (h.get(want[i]) != number[i])
                return false;
        
        return true;
    }
}
