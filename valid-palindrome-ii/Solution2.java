import java.util.*;

public class Main{
    public static boolean isPalindrome(String s) {
        final var N = s.length();
        return isPalindrome(s, 0, N-1, 0);
    }
    
    private static boolean isPalindrome(String s, int l, int r, int mismatches) {
        if (mismatches > 1) return false;
        if (l == r) return true;
        if (s.charAt(l) != s.charAt(r)) {
            return isPalindrome(s, l+1, r, mismatches+1) || isPalindrome(s, l, r-1, mismatches+1);
        }
        return isPalindrome(s, l+1, r-1, mismatches);
    }
}
