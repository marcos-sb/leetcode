class Solution {
    private static final char[][] num2letter = new char[][]{
        {'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},
        {'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}
    };
    
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return List.of();
        final List<String> res = new ArrayList<>();
        dfs(digits, 0, new StringBuilder(), res);
        return res;
    }
    
    private static void dfs(String digits, int i, StringBuilder sb, List<String> res) {
        if (i == digits.length()) {
            res.add(sb.toString());
            return;
        }
        
        final char c = digits.charAt(i);
        final char[] lettersForDigit = num2letter[c - '2'];
        for (char l : lettersForDigit) {
            sb.append(l);
            dfs(digits, i+1, sb, res);
            sb.setLength(sb.length()-1);
        }
    }
}
