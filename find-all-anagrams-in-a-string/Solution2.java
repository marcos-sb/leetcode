class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) return List.of();
        
        final var S = s.length();
        final var P = p.length();
        final var res = new ArrayList<Integer>(S-P+1);
        final var fs = calculateFrequencies(s, P);
        final var fp = calculateFrequencies(p, P);
        if (fs.equals(fp)) res.add(0);

        for (var i = P; i < S; i++) {
            final var j = i-P;
            final var cj = s.charAt(j);
            final var ci = s.charAt(i);
            if (ci != cj) {
                fs.put(cj, fs.getOrDefault(cj, 0)-1);
                fs.put(ci, fs.getOrDefault(ci, 0)+1);
                if (fs.get(ci) == 0) fs.remove(ci);
                if (fs.get(cj) == 0) fs.remove(cj);
            }
            
            if (fs.equals(fp)) res.add(j+1);
        }
        
        return res;
    }
    
    private static Map<Character, Integer> calculateFrequencies(String s, int len) {
        final var res = new HashMap<Character, Integer>(2*len);
        for (var i = 0; i < len; i++) {
            final var c = s.charAt(i);
            res.put(c, res.getOrDefault(c, 0)+1);
        }
        return res;
    }
}
