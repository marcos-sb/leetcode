class Solution {
    public String reverseParentheses(String s) {
        final var n = s.length();
        final var match = new int[2000];
        final var stack = new ArrayDeque<Integer>();
        final var chars = s.toCharArray();
        var i = 0;
        for (var c : chars) {
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                final var j = stack.pop();
                match[i] = j;
                match[j] = i;
            }
            ++i;
        }

        i = 0;
        var direction = 1;
        final var sb = new StringBuilder(n);
        while (i < n) {
            final var c = chars[i];
            if (c == '(' || c == ')') {
                i = match[i];
                direction = -direction;
            } else {
                sb.append(c);
            }
            i += direction;
        }

        return sb.toString();
    }
}
