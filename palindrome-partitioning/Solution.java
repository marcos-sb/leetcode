class Solution {
    public List<List<String>> partition(String s) {
        final List<List<String>> res = new ArrayList<>();
        bt(s, 0, new ArrayList<>(), res);
        return res;
    }

    private static void bt(String str, int start, List<String> partial, List<List<String>> res) {
        if (start == str.length()) {
            res.add(new ArrayList<>(partial));
            return;
        }

        for (var end = start; end < str.length(); ++end) {
            final var substr = str.substring(start, end+1);
            if (isPalindrome(substr)) {
                partial.add(substr);
                bt(str, end+1, partial, res);
                partial.remove(partial.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String str) {
        final var chars = str.toCharArray();
        var left = 0;
        var right = str.length()-1;
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}
