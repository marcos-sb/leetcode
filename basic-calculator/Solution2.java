class Solution {
    // The key to understanding this solution is to realise
    // that when the execution flow reaches the `else` branch
    // we already have everything we need to perform the
    // calculation.
    //
    // - We're only actually adding integers
    // - We 'encode' subtractions using the addition of negative
    // integers and `sign`
    // - What's accumulated in `res` in line 38 is the value of
    // previously read operand, which includes the `sign` that
    // has been read before the operand.
    //
    // Expressions within parentheses are isolated from the rest
    // using recursion. What has been mentioned remains the same
    // for these 'nested' expressions, and we simply greedily
    // substitute the whole expression for its reduced integer
    // value before continuing the calculation.
    private int i;

    public Solution() {
        i = 0;
    }

    public int calculate(String s) {
        final var S = s.length();
        var operand = 0;
        var sign = 1;
        var res = 0;
        while (i < S) {
            final var c = s.charAt(i++);
            if (Character.isWhitespace(c)) continue;
            if (Character.isDigit(c)) {
                operand = 10 * operand + (c - '0');
            } else if (c == '(') operand = calculate(s);
            else if (c == ')') break;
            else { // c is '+' or '-'
                res += sign * operand;
                sign = c == '-' ? -1 : 1;
                operand = 0;
            }
        }
        return res + sign * operand;
    }
}
