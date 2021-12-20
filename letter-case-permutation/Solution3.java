class Solution3 {
    public List<String> letterCasePermutation(String s) {
        final var ret = new ArrayList<String>();
        bt(s.toCharArray(), 0, ret);
        return ret;
    }
    
    private static void bt(char[] s, int i, List<String> res) {
        if (i == s.length) {
            res.add(new String(s));
            return;
        }
        if (Character.isLetter(s[i])) {
            s[i] = Character.toLowerCase(s[i]);
            bt(s, i+1, res);
            s[i] = Character.toUpperCase(s[i]);
            bt(s, i+1, res);
        } else
            bt(s, i+1, res);
    }
}
