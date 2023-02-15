class Solution {
    public String getHint(String secret, String guess) {
        final var sArr = secret.toCharArray();
        final var gArr = guess.toCharArray();
        final var len = sArr.length;
        final var sCounts = new int[10];
        for (var c : sArr) sCounts[c-'0']++;
        var bulls = 0;
        var cows = 0;
        final var potentialCowIndices = new ArrayList<Integer>();
        for (var i = 0; i < len; i++)
            if (sArr[i] == gArr[i]) {
                bulls++;
                sCounts[gArr[i]-'0']--;
            } else potentialCowIndices.add(i);
        for (var i : potentialCowIndices)
            if (0 < sCounts[gArr[i]-'0']) {
                cows++;
                sCounts[gArr[i]-'0']--;
            }

        return String.format("%dA%dB", bulls, cows);
    }
}
