class Solution {
    public int longestPalindrome(String s) {
        final var counts = new int[128];
        for (char c : s.toCharArray())
            counts[c]++;
        
        var one = 0;
        var maxLen = 0;
        for (var f : counts)
            if (f % 2 == 0) maxLen += f;
            else {
                maxLen += f-1;
                one = 1;
            }
        
        return maxLen + one;
    }
}
