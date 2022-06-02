class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        final var S = s.length();
        final var freqs = new HashMap<String, Integer>();
        final var sb = new StringBuilder(10);
        for (var i = 0; i < S-9; i++) {
            for (var j = 0; j < 10; j++)
                sb.append(s.charAt(i+j));
            final var si_10 = sb.toString();
            sb.setLength(0);
            freqs.put(si_10, freqs.getOrDefault(si_10, 0) + 1);
        }
        
        final var res = new ArrayList<String>(freqs.size());
        for (var entry : freqs.entrySet())
            if (entry.getValue() > 1) res.add(entry.getKey());
        
        return res;
    }
}
