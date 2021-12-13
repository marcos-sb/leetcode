class Solution {
    public void reverseString(char[] s) {
        var i = 0;
        var j = s.length-1;
        while (i < j) {
            final var tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++; j--;
        }
    }
}
