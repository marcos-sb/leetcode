class Solution {
    public String reverseParentheses(String s) {
        final var n = s.length();
        final var sb = new StringBuilder();
        final var chars = s.toCharArray();

        for (var c : chars) {
            if (c == ')') {
                final var auxSb = new StringBuilder();
                var i = sb.length()-1;
                var _c = sb.charAt(i);
                while (0 <= i && _c != '(') {
                    auxSb.append(sb.charAt(i));
                    --i;
                    _c = sb.charAt(i);
                }
                sb.setLength(i);
                sb.append(auxSb);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}

// (u(love)i)
// (uevoli)
