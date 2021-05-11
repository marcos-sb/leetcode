public class Solution {
    public int wordBreak3(String s, Set<String> dict) {
        final Set<String> dictLower = new HashSet<>();
        final Set<Integer> lengths = new HashSet<>();
        for (String w : dict) {
            if (w.isEmpty()) continue;
            dictLower.add(w.toLowerCase());
            lengths.add(w.length());
        }

        final int[] cache = new int[s.length()];
        for (int i = 0; i < cache.length; i++) cache[i] = -1;
        return dfs(s.toLowerCase(), 0, lengths, dictLower, cache);
    }

    private static int dfs(String s, int i, Set<Integer> lens, Set<String> d, int[] cache) {
        if (i == s.length()) return 1;
        
        if (cache[i] != -1) return cache[i];

        int sentences = 0;
        for (Integer len : lens) {
            if (i+len > s.length() || !d.contains(s.substring(i, i+len))) continue;
            sentences += dfs(s, i+len, lens, d, cache);
        }

        cache[i] = sentences;
        return sentences;
    } 
}
