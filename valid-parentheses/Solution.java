class Solution {
    public boolean isValid(String s) {
        final Deque<Character> st = new ArrayDeque<>(s.length()/2);
        for (int i = 0; i < s.length(); i++) {
            final var c = s.charAt(i);
            switch (c) {
                case '[':
                case '{':
                case '(':
                    st.offerFirst(c);
                    break;
                default:
                    final var front = st.poll();
                    if (front == null) return false;
                    switch (front) {
                        case '[':
                            if (c != ']') return false;
                            break;
                        case '{':
                            if (c != '}') return false;
                            break;
                        case '(':
                            if (c != ')') return false;
                            break;
                        default:
                            return false;
                    }
            }
        }
        return st.size() == 0;
    }
}
