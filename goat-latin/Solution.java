
import java.util.regex.Pattern;

class Solution {
    private static final Pattern vocals;
    
    static {
        vocals = Pattern.compile("^[aeiouAEIOU].*$");
    }
    
    public String toGoatLatin(String S) {
        final var sb = new StringBuilder(S.length());
        
        final var words = S.split("\\s");
        for (int i = 0; i < words.length; i++) {
            sb.append(toGoatLatinWord(words[i], i)).append(' ');
        }
        sb.setLength(sb.length()-1);
        
        return sb.toString();
    }
    
    private static String toGoatLatinWord(String s, int wIdx) {
        final var sb = new StringBuilder();
        
        if (vocals.matcher(s).matches()) {
            sb.append(s);
        } else {
            for (int i = 1; i < s.length(); i++) sb.append(s.charAt(i));
            sb.append(s.charAt(0));
        }
        
        sb.append("ma");
        for (int i = 0; i <= wIdx; i++) sb.append('a');
        
        return sb.toString();
    }
}
