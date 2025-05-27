class Solution {
    public int evalRPN(String[] tokens) {
        final var stack = new ArrayDeque<Integer>();
        for (var token : tokens) {
            if (1 < token.length() || Character.isDigit(token.charAt(0))) {
                final var num = Integer.parseInt(token);
                stack.offer(num);
            } else {
                final var op2 = stack.pollLast();
                final var op1 = stack.pollLast();
                final var res = switch (token) {
                    case "+" -> op1 + op2;
                    case "-" -> op1 - op2;
                    case "*" -> op1 * op2;
                    case "/" -> op1 / op2;
                    default -> throw new UnsupportedOperationException();
                };
                stack.offer(res);
            }
        }

        return stack.poll();
    }
}
