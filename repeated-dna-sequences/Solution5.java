class Solution {
    private static final int[] indx = new int['Z'-'A'+1];

    public List<String> findRepeatedDnaSequences(String s) {
        final var N = s.length();
        if (N < 10) return List.of();
        
        populateMapping();
        final var seen = new HashSet<Integer>();
        final var res = new HashSet<String>();
        var winHash = 0;
        var l = 0;
        var r = 0;
        while (r < 10) {
            final var c = s.charAt(r);
            winHash *= 4;
            winHash += indx[c-'A'];
            r++;
        }
        if(!seen.add(winHash)) res.add(s.substring(l,r));

        final var maxFactor = 2 << 17; // 4^9 = 2^2^9 = 2^18 = 2<<17
        while (r < N) {
            final var cl = s.charAt(l);
            winHash -= indx[cl-'A'] * maxFactor;
            l++;
            final var cr = s.charAt(r);
            winHash *= 4;
            winHash += indx[cr-'A'];
            r++;
            if(!seen.add(winHash)) res.add(s.substring(l,r));
        }

        return new ArrayList<>(res);
    }

    private void populateMapping() {
        indx['C'-'A'] = 1;
        indx['G'-'A'] = 2;
        indx['T'-'A'] = 3;
    }
}
