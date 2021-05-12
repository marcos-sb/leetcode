public class Solution {
    public String convertToTitle(int n) {
        final StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char)((n % 26) + 'A'));
            n /= 26;
        }
        return sb.reverse().toString();
    }
}
