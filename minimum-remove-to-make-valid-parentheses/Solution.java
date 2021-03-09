class Solution {
    public String minRemoveToMakeValid(String s) {
        final Deque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            final var c = s.charAt(i);
            switch (c) {
                case '(':
                    stack.offerLast(new int[]{(int)c, i});
                    break;
                case ')':
                    if (!stack.isEmpty() && ((char)stack.peekLast()[0]) == '(')
                        stack.pollLast();
                    else
                        stack.offerLast(new int[]{(int)c, i});
                    break;
                default:
            }
        }
        
        if (stack.isEmpty()) return s;
        
        final var sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            final var c = s.charAt(i);
            switch (c) {
                case '(':
                case ')':
                    final var front = stack.peekFirst();
                    if (!stack.isEmpty() && ((char) front[0]) == c && front[1] == i)
                        stack.pollFirst();
                    else
                        sb.append(c);
                    break;
                default:
                    sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
