class Solution {
    private static final String[] d2l = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        final var N = digits.length();
        if (N == 0) return List.of();

        final var letters = new String[N];
        for (var i = 0; i < N; i++) {
            final var d = digits.charAt(i);
            letters[i] = d2l[d-'0'];
        }

        final var res = new ArrayList<String>();
        bt(0, letters, new StringBuilder(N), res); // O(N*3^N)
        return res;
    }

    private static void bt(int i, String[] letters, StringBuilder comb, List<String> res) {
        final var N = letters.length;
        if (i == N) { // true ~3^N
            res.add(comb.toString()); // O(N)
            return;
        }
        final var s = letters[i];
        for (var li = 0; li < s.length(); li++) {
            comb.append(s.charAt(li));
            bt(i+1, letters, comb, res);
            comb.setLength(comb.length()-1);
        }
    }
}
