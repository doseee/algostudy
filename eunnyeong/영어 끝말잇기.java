import java.util.*;

class Solution {
    HashSet<String> h;
    
    public int[] solution(int n, String[] words) {
        h = new HashSet<>();
        String word = words[0];
        h.add(word);
        
        int round = 1, idx = 1, flag = 0;
        for (int i = 1; i < words.length; i++) {
            String s = words[i];
            round++;
            idx++;
            
            if (idx > n)
                idx = 1;
            
            if (check(s, word))
                word = s;
            else {
                flag = 1;
                break;
            }
        }
    
        
        if (flag == 0)
            round = idx = 0;
        
        if (round % n != 0) {
            round /= n;
            round++;
        }
        else
            round /= n;
    

        return new int[] {idx, round};
    }
    
    public boolean check(String s, String w) {
        if (!h.contains(s) && s.length() > 1 && w.charAt(w.length() - 1) == s.charAt(0)) {
            h.add(s);
            return true;
        }
        
        return false;
    } 
}
