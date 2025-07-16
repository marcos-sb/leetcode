class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        final var m = word.length();
        final var n = abbr.length();
        final var wchars = word.toCharArray();
        final var achars = abbr.toCharArray();

        var i = 0;
        var j = 0;
        while (i < m && j < n) {
            if (Character.isLowerCase(achars[j])) {
                if (wchars[i] != achars[j]) return false;
                ++i; ++j;
            } else if (Character.isDigit(achars[j])) {
                if (achars[j] == '0') return false;

                var start = j++;
                while (j < n && Character.isDigit(achars[j])) {
                    ++j;
                }
                final var count = Integer.parseInt(abbr.substring(start, j));
                i += count;
            }
        }

        return i == m && j == n;
    }
}
