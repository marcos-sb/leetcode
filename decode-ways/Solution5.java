class Solution {
    public int numDecodings(String s) {
        final var count = new int[1];
        bt(s.toCharArray(), 0, count);
        return count[0];
    }

    private static void bt(char[] s, int i, int[] count) {
        if (i == s.length) {
            ++count[0];
            return;
        }

        final var num1 = s[i]-'0';
        if (invalid(num1)) {
            return;
        }
        bt(s, i+1, count);

        if (i == s.length-1) {
            return;
        }

        final var num2 = (s[i]-'0')*10 + s[i+1]-'0';
        if (invalid(num2)) {
            return;
        }
        bt(s, i+2, count);
    }

    private static boolean invalid(int num) {
        return num < 1 || 26 < num;
    }
}
