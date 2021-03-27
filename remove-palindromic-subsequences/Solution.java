class Solution {
    public int removePalindromeSub(String s) {
        var i = 0;
        var j = s.length()-1;
        
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return 2;
            i++;
            j--;
        }
        
        return 1;
    }
}
