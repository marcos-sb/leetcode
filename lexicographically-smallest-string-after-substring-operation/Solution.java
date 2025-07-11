class Solution {
    public String smallestString(String s) {
        final var len = s.length();
        final var chars = s.toCharArray();
        final var sb = new StringBuilder();

        var changed = false;
        for (var i = 0; i < len; ++i) {
            final var c = chars[i];
            if (c != 'a') {
                sb.append((char)(c-1));
                changed = true;
            } else if (changed) {
                for (var j = i; j < len; ++j) {
                    sb.append(chars[j]);
                }
                break;
            } else {
                sb.append(c);
            }
        }

        if (!changed)
            sb.setCharAt(sb.length()-1, 'z');

        return sb.toString();
    }
}
