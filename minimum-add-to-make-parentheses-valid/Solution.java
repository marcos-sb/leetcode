class Solution {
    public int minAddToMakeValid(String s) {
        final var S = s.length();
        var open = 0;
        var close = 0;
        for (var c : s.toCharArray()) {
            if (c == '(') ++open;
            else if (0 < open) {
                --open;
            } else {
                ++close;
            }
        }
        return Math.abs(open + close);
    }
}
