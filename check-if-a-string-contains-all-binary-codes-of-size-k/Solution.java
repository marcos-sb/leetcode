class Solution {
    public boolean hasAllCodes(String s, int k) {
        final var set = new HashSet<String>();
        for (int i = 0; i <= s.length()-k; i++) {
            set.add(s.substring(i, i+k));
        }
        return set.size() == (1 << k);
    }
}
