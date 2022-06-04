class Solution {
    public String longestPalindrome(String s) {
        if (s == null) return null;
        
        var longest = 0;
        var longestStr = "";
        for (var i = 0; i < s.length(); i++) {
            for (var j = i+longest; j < s.length(); j++) {
                if (isPalindrome(s, i, j) && longest < j-i+1) {
                    longest = j-i+1;
                    longestStr = s.substring(i, j+1);
                }
            }
        }
        
        return longestStr;
    }
    
    private static boolean isPalindrome(String s, int from, int to) {
        var i = from;
        var j = to;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
