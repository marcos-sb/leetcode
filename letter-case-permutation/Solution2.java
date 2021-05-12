public class Solution2 {
    public List<String> letterCasePermutation(String S) {
        return dfs(0, S.toCharArray(), new ArrayList<>());
    }

    private static List<String> dfs(int i, char[] s, List<String> res) {
        if (i == s.length) {
            res.add(new String(s));
            return res;
        }
        if (Character.isDigit(s[i])) return dfs(i+1, s, res);
        s[i] = Character.toLowerCase(s[i]);
        dfs(i+1, s, res);
        s[i] = Character.toUpperCase(s[i]);
        return dfs(i+1, s, res);
    }
}
