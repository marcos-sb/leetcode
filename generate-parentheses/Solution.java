class Solution {
    public List<String> generateParenthesis(int n) {
        final var res = new ArrayList<String>();
        final var cur = new StringBuilder(2*n);
        bt(n, 0, 0, cur, res);
        return res;
    }
    
    private static void bt(int n, int open, int close, StringBuilder cur, List<String> res) {
        if (open + close == 2*n) {
            res.add(cur.toString());
            return;
        }
        
        if (open < n) {
            cur.append('(');
            bt(n, open+1, close, cur, res);
            cur.setLength(cur.length()-1);
        }
        
        if (close < open) {
            cur.append(')');
            bt(n, open, close+1, cur, res);
            cur.setLength(cur.length()-1);
        }
    }
}
