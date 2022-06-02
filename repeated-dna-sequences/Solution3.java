class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        final var S = s.length();
        final var mapper = Map.of('A',0,'C',1,'G',2,'T',3);
        final var sx = new int[s.length()];
        for (var i = 0; i < S; i++)
            sx[i] = mapper.get(s.charAt(i));
        
        final var res = new HashSet<String>();
        final var hashSet = new HashSet<Integer>();
        final var lfactor = (int)Math.pow(4,10-1);
        var hash = 0;
        for (var i = 0; i < S-10+1; i++) {
            if (i == 0) hash = calculateHash(sx, i, 10);
            else hash = (hash - sx[i-1]*lfactor) * 4 + sx[i+10-1];
            if (hashSet.contains(hash))
                res.add(s.substring(i,i+10));
            hashSet.add(hash);
        }
        
        return new ArrayList<>(res);
    }
    
    private static int calculateHash(int[] sx, int lo, int len) {
        var hash = 0;
        for (var i = lo; i < len; i++) {
            hash *= 4;
            hash += sx[i];
        }
        return hash;
    }
}

// 23 -> 2*4 + 3 = 11 -> 4*2
// 3  -> 2*4 + 3 - 2*4 = 3
// 32 -> 3*4 + 2 = 14
