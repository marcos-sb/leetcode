class Solution {
    public String reverseWords(String s) {
        final List<String> words = Arrays.asList(s.split("\\s+"));
        Collections.reverse(words);
        return String.join(" ", words).trim();
    }
}
