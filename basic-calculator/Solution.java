import java.util.*;

class Solution {
    private int i;

    public Solution() {
        i = 0;
    }

    public int calculate(String s) {
        final var S = s.length();
        final var operands = new ArrayDeque<Integer>();
        final var operators = new ArrayDeque<Character>();
        while (i < S) {
            final var c = s.charAt(i++);
            if (Character.isWhitespace(c)) continue;

            if (Character.isDigit(c)) {
                i--;
                operands.addFirst(readNumber(s));
            } else if (c == '(') operands.addFirst(calculate(s));
            else if (c == ')') return compute(operands, operators);
            else {
                if (!operators.isEmpty()) {
                    final var prevOp = operators.peekFirst();
                    if (prevOp == '*' || prevOp == '/' ||
                            (prevOp == '-' && (c == '+' || c == '-')))
                        step(operands, operators);
                }
                operators.addFirst(c);
            }
        }

        return compute(operands, operators);
    }

    private int readNumber(String s) {
        var n = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            n *= 10;
            n += s.charAt(i) - '0';
            i++;
        }
        return n;
    }

    private int compute(Deque<Integer> operands, Deque<Character> operators) {
        while (1 < operands.size()) step(operands, operators);
        return step(operands, operators);
    }

    private int step(Deque<Integer> operands, Deque<Character> operators) {
        final var m = operands.pollFirst();

        if (operands.isEmpty()) {
            final var sign = !operators.isEmpty() && operators.pollFirst() == '-' ? -1 : 1;
            final var res = sign * m;
            operands.addFirst(res);
            return res;
        }

        // return `n <op> m`
        final var op = operators.pollFirst();
        final var n = operands.pollFirst();
        final var res = switch (op) {
            case '+' -> n + m;
            case '-' -> n - m;
            case '*' -> n * m;
            case '/' -> n / m;
            default -> n + m;
        };

        operands.addFirst(res);
        return res;
    }
}
