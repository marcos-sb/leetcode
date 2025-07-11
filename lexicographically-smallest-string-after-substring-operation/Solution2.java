class Solution {
    public String smallestString(String s) {
        final var len = s.length();
        final var chars = s.toCharArray();

        var changed = false;
        for (var i = 0; i < len; ++i) {
            final var c = chars[i];
            if (c != 'a') {
                chars[i] = (char)(c-1);
                changed = true;
            } else if (changed) {
                break;
            }
        }

        if (!changed)
            chars[len-1] = 'z';

        return new String(chars);
    }
}
