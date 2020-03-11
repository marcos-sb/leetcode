package increasing_decreasing_string;

import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public String sortString(String s) {
        final var pq = new PriorityQueue<Character>();
        final var counts = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (!counts.containsKey(s.charAt(i))) {
                counts.put(s.charAt(i),0);
                pq.add(s.charAt(i));
            }
            counts.put(s.charAt(i), counts.get(s.charAt(i))+1);
        }
        final var sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll());
        }
        final var str = sb.toString();
        final var res = new StringBuilder();
        while (true) {
            for (int i = 0; i < str.length(); i++) {
                if (counts.get(str.charAt(i)) > 0) {
                    counts.put(str.charAt(i), counts.get(str.charAt(i))-1);
                    res.append(str.charAt(i));
                    if (res.length() == s.length()) return res.toString();
                }
            }
            for (int i = str.length()-1; i >= 0; i--) {
                if (counts.get(str.charAt(i)) > 0) {
                    counts.put(str.charAt(i), counts.get(str.charAt(i))-1);
                    res.append(str.charAt(i));
                    if (res.length() == s.length()) return res.toString();
                }
            }
        }
    }
}
