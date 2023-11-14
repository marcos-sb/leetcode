class Solution {
    public List<String> restoreIpAddresses(String s) {
        final var parts = new int[4];
        Arrays.fill(parts, -1);
        final var res = new ArrayList<String>();
        bt(0, s.toCharArray(), 0, parts, res);
        return res;
    }

    private static void bt(int i, char[] s, int p, int[] parts, List<String> res) { // O(bf ^ rec-depth) => O(3^4) => O(1)
        if (p == parts.length ^ i == s.length) return; // parts.length == 4
        if (p == parts.length) { // i == s.length
            res.add(restore(parts));
            return;
        }

        var octet = 0;
        for (var j = 0; j < 3 && i+j < s.length; j++) {
            // We find parts[p] == 0 when backtracking and when the previous digit
            // in this backtracking function call was a '0'. In this case we cannot
            // append any other digit to this '0' as that'd not be a valid octet.
            // So we `break`. And by doing so we force this '0' we had found to be
            // appended to the octet -- if that's valid, as the previous digit may
            // also be a '0', and '00' is not a valid octet.
            if (parts[p] == 0) break;
            octet *= 10;
            octet += s[i + j] - '0';
            if (255 < octet) break;
            parts[p] = octet;
            bt(i+j+1, s, p+1, parts, res); // max 3 times per call
        }
        parts[p] = -1;
    }

    private static String restore(int[] parts) {
        final var res = new StringBuilder();
        for (var p : parts) res.append(p).append('.');
        res.setLength(res.length()-1);
        return res.toString();
    }
}
