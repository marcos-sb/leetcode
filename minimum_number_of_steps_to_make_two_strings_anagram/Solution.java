package minimum_number_of_steps_to_make_two_strings_anagram;

import java.util.HashMap;
import java.util.Map;

class Solution {
    class Solution {
        public int minSteps(String s, String t) {
            int steps = 0;
            final var sMap = counts(s);
            final var tMap = counts(t);
            for (var sCharCount : sMap.entrySet()) {
                var diff = sCharCount.getValue() - tMap.getOrDefault(sCharCount.getKey(), 0);
                if (diff > 0) steps += diff;
            }
            return steps;
        }
        private Map<Character,Integer> counts(String s) {
            final var map = new HashMap<Character,Integer>();
            for (int i = 0; i < s.length(); i++) {
                if (!map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), 0);
                }
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
            return map;
        }
    }
}


