class Solution {
    private static final char[] BALLOON = "balloon".toCharArray();
    public int maxNumberOfBalloons(String text) {
        final var counts = new int[26];
        for (var i = 0; i < text.length(); i++) {
            final var c = text.charAt(i);
            counts[c-'a']++;
        }
        var min = Integer.MAX_VALUE;
        for (var l : BALLOON) {
            switch (l) {
                case 'b','a','n':
                    min = Math.min(min, counts[l-'a']);
                    break;
                case 'l','o':
                    min = Math.min(min, counts[l-'a']/2);
            }
        }
        return min;
    }
}
