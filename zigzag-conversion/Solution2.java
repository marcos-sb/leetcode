class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        final var lenS = s.length();
        var shift = (numRows - 1) * 2;
        final var chars = s.toCharArray();

        final var res = new char[lenS];
        var k = 0;
        for (var i = 0; i < numRows; ++i) {
            for (var j = 0; i + j < lenS; j += shift) {
                res[k++] = chars[i+j];
                if (i != 0 && i != numRows-1 && j + shift - i < lenS) {
                    res[k++] = chars[j + shift - i];
                }
            }
        }

        return new String(res);
    }
}
