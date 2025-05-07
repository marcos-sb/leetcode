class Solution {
    public int repeatedStringMatch(String a, String b) {
        var count = 0;
        final var sb = new StringBuilder();

        while (sb.length() < b.length()) {
            ++count;
            sb.append(a);
        }

        if (0 <= sb.indexOf(b)) {
            return count;
        }

        ++count;
        sb.append(a);
        if (0 <= sb.indexOf(b)) {
            return count;
        }

        return -1;
    }
}
