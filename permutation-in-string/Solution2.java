class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;

        final var counts = new int[26];
        var diffChars = 0;
        for (var c : s1.toCharArray()) {
            counts[c-'a']++;
            if (counts[c-'a'] == 1) diffChars++;
        }

        var l = 0;
        var r = 0;
        final var s2c = s2.toCharArray();
        while (r < s1.length()) {
            final var c = s2c[r++];
            if (counts[c-'a'] == 1) diffChars--;
            counts[c-'a']--;
        }

        if (diffChars == 0) return true;

        while (r < s2c.length) {
            final var c = s2c[l++];
            if (counts[c-'a'] == 0) diffChars++;
            counts[c-'a']++;
            final var cr = s2c[r++];
            if (counts[cr-'a'] == 1) diffChars--;
            counts[cr-'a']--;
            if (diffChars == 0) return true;
        }

        return false;
    }
}
