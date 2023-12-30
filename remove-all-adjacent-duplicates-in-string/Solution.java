class Solution {
    public String removeDuplicates(String s) {
        final var S = s.length();
        final var sb = new StringBuilder(S);
        var i = 0;
        while (i < S) {
            var c = s.charAt(i++);
            if (!sb.isEmpty() && sb.charAt(sb.length()-1) == c)
                sb.setLength(sb.length()-1);
            else
                sb.append(c);
        }
        return sb.toString();
    }
}
