class Solution {
    public boolean detectCapitalUse(String word) {
        int capitals = 0;
        for (int i = 0; i < word.length(); i++) {
            if (isCapital(word.charAt(i))) capitals++;
        }
        return capitals == word.length() ||
            (capitals == 1 && isCapital(word.charAt(0))) ||
            capitals == 0;
    }
    private static boolean isCapital(char c) {
        return 'A' <= c && c <= 'Z';
    }
}
