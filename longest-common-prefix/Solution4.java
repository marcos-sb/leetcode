class Solution {

    public String longestCommonPrefix(String[] strs) {
        var prefix = strs[0];
        for (var word : strs) {
            while (!word.startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}
