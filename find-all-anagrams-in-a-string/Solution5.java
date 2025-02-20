class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        final var S = s.length();
        final var P = p.length();
        if (S < P) return List.of();
        var l = 0;
        var r = 0;
        final var freqP = new HashMap<Character, Integer>();
        for (var c : p.toCharArray()) {
            freqP.put(c, freqP.getOrDefault(c, 0) + 1);
        }
        final var freqS = new HashMap<Character, Integer>();
        while (r < P) {
            final var cr = s.charAt(r++);
            freqS.put(cr, freqS.getOrDefault(cr, 0) + 1);
        }
        final var res = new ArrayList<Integer>();
        if (freqP.equals(freqS)) res.add(l);

        // r == P
        while (r < S) {
            final var cl = s.charAt(l++);
            final var clFreq = freqS.get(cl);
            if (clFreq == 1) freqS.remove(cl);
            else freqS.put(cl, freqS.get(cl) - 1);
            final var cr = s.charAt(r++);
            freqS.put(cr, freqS.getOrDefault(cr, 0) + 1);
            if (freqP.equals(freqS)) res.add(l);
        }

        return res;
    }
}
