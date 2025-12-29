import java.util.*;

class Solution {
    public int[] solution(String s) {
        int cnt = 0, num = 0;
        while (true) {
            cnt++;
            long tmp = s.chars().filter(c -> c == '0').count();
            num += tmp;
            
            s = s.replace("0", "");
            int x = s.length();
            s = Integer.toBinaryString(x);
            
            if (s.equals("1"))
                break;
        }
        
        return new int[] {cnt, num};
    }
}
