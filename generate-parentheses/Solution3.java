class Solution {
    public List<String> generateParenthesis(int n) {
        final var res = new ArrayList<String>();
        bt(n, n, new StringBuilder(), res);
        return res;
    }

    private static void bt(int open, int closed, StringBuilder aux, List<String> result) {
        if (open == 0 && closed == 0) {
            result.add(aux.toString());
            return;
        }
        if (0 < open) {
            aux.append('(');
            bt(open-1, closed, aux, result);
            aux.setLength(aux.length()-1);
        }
        if (open < closed && 0 < closed) {
            aux.append(')');
            bt(open, closed-1, aux, result);
            aux.setLength(aux.length()-1);
        }
    }
}
