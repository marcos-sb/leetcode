import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        final Map<Character,Integer> chars = new HashMap<>();
        int longest = 0;
        int count = 0;
        int rep = 0;
        for(int i = 0; i<s.length(); i++) {
            if(chars.containsKey(s.charAt(i))) {
                longest = Math.max(longest,count);
                rep = Math.max(chars.get(s.charAt(i)),rep);
                count = i - rep;
            } else {
                count++;
            }
            chars.put(s.charAt(i),i);
        }
        return Math.max(longest, count);
    }
}
