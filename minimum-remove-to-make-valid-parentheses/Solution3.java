class Solution {

    public String minRemoveToMakeValid(String s) {
        final var chars = s.toCharArray();
        final var n = chars.length;
        final var stack = new ArrayDeque<Integer>();
        for (var i = 0; i < n; ++i) {
            final var c = chars[i];
            if (Character.isLowerCase(c)) continue;
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    chars[i] = '|';
                }
            }
        }

        for (var i : stack) {
            chars[i] = '|';
        }

        final var sb = new StringBuilder(s.length());
        for (var c : chars) {
            if (c == '|') continue;
            sb.append(c);
        }

        return sb.toString();
    }
}
