class Solution {
    static class Pair {
        int score;
        char paren;
        Pair(int score, char paren) {
            this.score = score;
            this.paren = paren;
        }
    }
    public int scoreOfParentheses(String S) {
        final var st = new ArrayDeque<Pair>(S.length()/2);
        var tmp = 0;
        for (int i = 0; i < S.length(); i++) {
            final var c = S.charAt(i);
            if (c == '(') {
                st.offerLast(new Pair(0, c));
            } else {
                final var top = st.pollLast();
                if (top.score == 0) top.score = 1;
                else top.score *= 2;
                if (!st.isEmpty()) st.peekLast().score += top.score;
                else tmp += top.score;
            }
        }
        return tmp;
    }
}
