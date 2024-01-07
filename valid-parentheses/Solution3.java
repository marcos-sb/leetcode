class Solution {
    public boolean isValid(String s) {
        final var S = s.length();
        final var stack = new ArrayDeque<Character>();
        for (var i = 0; i < S; i++) {
            final var c = s.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                case ']':
                case '}':
                    if (stack.isEmpty()) return false;
                    final var top = stack.pop();
                    if ((top == '(' && c != ')') || (top == '[' && c != ']')
                            || (top == '{') && c != '}')
                        return false;
                    break;
                default:
                    return false;
            }
        }

        return stack.isEmpty();
    }
}
