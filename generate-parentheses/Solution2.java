class Solution {
    public List<String> generateParenthesis(int n) {
        final var res = new ArrayList<String>();
        bt(0, 0, n, new StringBuilder(2*n), res); // O(2^2n), branching-factor ^ max call depth
        return res;
    }

    private static void bt(int open, int close, int n, StringBuilder curr, List<String> res) {
        if (curr.length() == 2*n) {
            res.add(curr.toString());
            return;
        }
        if (open < n) {
            curr.append('(');
            bt(open+1, close, n, curr, res);
            curr.setLength(curr.length()-1);
        }
        if (close < open) {
            curr.append(')');
            bt(open, close+1, n, curr, res);
            curr.setLength(curr.length()-1);
        }
    }
}
