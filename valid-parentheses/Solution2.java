public class Solution {
    public boolean isValidParentheses(String s) {
        final Map<Character, Character> open = new HashMap<>();
        open.put(')', '(');
        open.put(']', '[');
        open.put('}', '{');

        final Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.offerLast(c);
                    break;
                case ')':
                case '}':
                case ']':
                    if (stack.isEmpty()) return false;
                    final char poppedChar = stack.pollLast();
                    if (open.get(c) != poppedChar) return false;
            }
        }
        return stack.isEmpty();
    }
}
