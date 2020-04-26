package backspace_string_compare;

class Solution {
    public boolean backspaceCompare(String S, String T) {
        final var sarr = S.toCharArray();
        final var tarr = T.toCharArray();
        inPlace(sarr);
        inPlace(tarr);
        return equals(sarr,tarr);
    }
    private static void inPlace(char[] str) {
        int toDelete = 0;
        for (int i = str.length-1; i >= 0; i--) {
            if (str[i] == '#') toDelete++;
            else if (0 < toDelete) {
                toDelete--;
                str[i] = '0';
            }
        }
    }
    private static boolean equals(char[] a, char[] b) {
        int i = 0;
        int j = 0;
        while (i < a.length || j < b.length) {
            while (i < a.length && (a[i] == '#' || a[i] == '0')) i++;
            while (j < b.length && (b[j] == '#' || b[j] == '0')) j++;
            if (i == a.length && j == b.length) return true;
            if (i == a.length || j == b.length) return false;
            if (a[i] != b[j]) return false;
            i++; j++;
        }
        return i == a.length && j == b.length;
    }
}
