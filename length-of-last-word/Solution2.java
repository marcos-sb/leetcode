class Solution {
    public int lengthOfLastWord(String s) {
        final var N = s.length();
        var res = 0;
        var i = N-1;
        while (0 <= i && s.charAt(i) == ' ') i--;
        while (0 <= i && s.charAt(i--) != ' ') res++;
        return res;
    }
}
