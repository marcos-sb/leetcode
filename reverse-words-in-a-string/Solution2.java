public class Main{
    public static String reverseWords(String sentence) {
        final var N = sentence.length();
        final var sb = new StringBuilder();
        var l = N;
        while (0 < l) {
            var r = l-1;
            while (0 <= r && sentence.charAt(r) == ' ') r--;
            if (r < 0) return sb.toString();
            l = r-1;
            while (0 <= l && sentence.charAt(l) != ' ') l--;
            sb.append(sentence.substring(++l, r+1)).append(' ');
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }
}
