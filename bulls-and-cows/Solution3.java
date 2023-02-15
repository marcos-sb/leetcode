class Solution {
    public String getHint(String secret, String guess) {
        final var sArr = secret.toCharArray();
        final var gArr = guess.toCharArray();
        final var len = sArr.length;
        final var sCounts = new int[10];
        var bulls = 0;
        var cows = 0;
        for (var i = 0; i < len; i++) {
            if (sArr[i] == gArr[i]) {
                bulls++;
                gArr[i] = 'x';
            }
            else sCounts[sArr[i]-'0']++;
        }

        for (var gc : gArr) {
            if (gc == 'x') continue;
            if (0 < sCounts[gc-'0']) {
                cows++;
                sCounts[gc-'0']--;
            }
        }

        final var res = new StringBuilder();
        return res.append(bulls).append("A").append(cows).append("B").toString();
    }
}
