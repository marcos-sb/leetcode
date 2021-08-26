class Solution {
    public int longestStrChain(String[] words) {
        final Comparator<String> cmp = (a,b) -> {
            final var lenCmp = Integer.compare(a.length(), b.length());
            if (lenCmp != 0) return lenCmp;
            return a.compareTo(b);
        };
        
        Arrays.sort(words, cmp);
        
        final var dp = new int[words.length];
        var maxLen = 0;
        for (var i = words.length-1; i >= 0; i--) {
            var longestI = 1;
            for (var j = i+1; j < words.length; j++) {
                if (!isPred(words[i], words[j])) continue;
                longestI = Math.max(longestI, 1 + dp[j]);
            }
            dp[i] = longestI;
            maxLen = Math.max(maxLen, longestI);
        }
        
        return maxLen;
    }
    
    private static boolean isPred(String a, String b) {
        if (a.length() != b.length() - 1) return false;
        
        int i = 0, j = 0;
        var diff = 0;
        while (i < a.length() && diff < 2) {
            if (a.charAt(i) != b.charAt(j)) diff++;
            else i++;
            j++;
        }
        
        return diff < 2;
    }
}
