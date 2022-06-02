class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        final var S = s.length();
        final var mapper = Map.of('A',0,'C',1,'G',2,'T',3);
        
        final var res = new HashSet<String>();
        final var seen = new HashSet<Integer>();
        final var mask20b = (1 << 20) - 1;
        var windowMask = 0;
        for (var i = 0; i < S-10+1; i++) {
            if (i == 0) windowMask = calculateMask(s, mapper, 10);
            else {
                windowMask <<= 2;
                windowMask |= mapper.get(s.charAt(i+10-1));
                windowMask &= mask20b;
            }
            if (seen.contains(windowMask))
                res.add(s.substring(i,i+10));
            seen.add(windowMask);
        }

        return new ArrayList<>(res);
    }
    
    private static int calculateMask(String s, Map<Character, Integer> mapper, int len) {
        var mask = 0;
        for (var i = 0; i < len; i++) {
            mask <<= 2;
            mask |= mapper.get(s.charAt(i));
        }
        return mask;
    }
}
