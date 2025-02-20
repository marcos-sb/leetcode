class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        final var S = s.length();
        final var P = p.length();
        if (S < P) return List.of();
        var l = 0;
        var r = 0;
        var charsLeft = 0;
        final var countsP = new int[26];
        for (var c : p.toCharArray()) {
            if (countsP[c-'a'] == 0) charsLeft++;
            countsP[c-'a']++;
        }

        final var res = new ArrayList<Integer>();
        while (r < P) {
            final var cr = s.charAt(r++);
            if (countsP[cr-'a'] == 1) charsLeft--;
            countsP[cr-'a']--;
        }
        if (charsLeft == 0) res.add(l);
        while (r < S) {
            final var cl = s.charAt(l++);
            countsP[cl-'a']++;
            if (countsP[cl-'a'] == 1) charsLeft++;
            final var cr = s.charAt(r++);
            if (countsP[cr-'a'] == 1) charsLeft--;
            countsP[cr-'a']--;
            if (charsLeft == 0) res.add(l);
        }
        return res;
    }
}
