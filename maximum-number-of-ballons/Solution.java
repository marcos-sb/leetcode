class Solution {
    private static final char[] BALLOON = "balloon".toCharArray();
    private static final char[] BAN = "ban".toCharArray();
    private static final char[] LO = "lo".toCharArray();

    public int maxNumberOfBalloons(String text) {
        final var letterFrequencies = new HashMap<Character, Integer>();
        for (var letter : BALLOON) {
            letterFrequencies.put(letter, 0);
        }
        final var letters = text.toCharArray();
        for (var letter : letters) {
            letterFrequencies.computeIfPresent(letter, (l, count) -> count+1);
        }
        var min = Integer.MAX_VALUE;
        for (var letter : BAN) {
            min = Math.min(min, letterFrequencies.get(letter));
        }
        for (var letter : LO) {
            min = Math.min(min, letterFrequencies.get(letter) / 2);
        }
        return min;
    }
}
