class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        int[] freqs = new int['z' - 'a' + 1];
        var mismatches = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) mismatches++;
            freqs[A.charAt(i) - 'a']++;
        }
        
        if (mismatches > 2 || mismatches == 1) return false;
        if (mismatches == 0) {
            for (var freq : freqs) if (freq > 1) return true;
            return false;
        }
        
        // mismatches == 2
        for (int i = 0; i < B.length(); i++)
            freqs[B.charAt(i) - 'a']--;
        for (var freq : freqs)
            if (freq != 0) return false;
        
        return true;
    }
}
