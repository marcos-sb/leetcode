class Solution {
    public int strStr(String haystack, String needle) {
        final var lenH = haystack.length();
        final var lenN = needle.length();
        var i = 0;
        while (i + lenN-1 < lenH) {
            var j = 0;
            while (i < lenH && haystack.charAt(i) != needle.charAt(j)) i++;
            var k = i;
            while (k < lenH && j < lenN && haystack.charAt(k) == needle.charAt(j)) {
                k++; j++;
            }
            if (j == lenN) return k-j;
            i++;
        }
        return -1;
    }
}
