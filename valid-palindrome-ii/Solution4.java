class Solution {
    public boolean validPalindrome(String s) {
        final var chars = s.toCharArray();
        return validAux(chars, 0, chars.length-1, false);
    }

    private static boolean validAux(char[] chars, int left, int right, boolean removed) {
        final var n = chars.length;

        while (left < right) {
            if (chars[left] != chars[right]) {
                if (removed)
                    return false;
                else
                    return validAux(chars, left+1, right, true) || validAux(chars, left, right-1, true);
            }
            left++; --right;
        }

        return true;
    }
}
