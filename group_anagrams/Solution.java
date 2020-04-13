package group_anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final Map<Map<Character, Integer>, List<String>> groups = new HashMap<>();
        for (String s : strs) {
            final Map<Character, Integer> anagramHash = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (!anagramHash.containsKey(s.charAt(i))) {
                    anagramHash.put(s.charAt(i), 0);
                }
                anagramHash.put(s.charAt(i), anagramHash.get(s.charAt(i)) + 1);
            }
            groups.computeIfAbsent(anagramHash, (__) -> new ArrayList<>());
            groups.get(anagramHash).add(s);
        }
        return
            groups.values().stream().collect(Collectors.toList());
    }
}
