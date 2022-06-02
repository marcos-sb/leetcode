class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        final var S = s.length();
        final var seen = new HashSet<String>();
        final var res = new HashSet<String>();
        for (var i = 0; i < S-10+1; i++) {
            final var substr = s.substring(i, i+10);
            if (seen.contains(substr)) res.add(substr);
            seen.add(substr);
        }
        return new ArrayList<>(res);
    }
}
