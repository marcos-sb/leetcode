class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        final var S = s.length();
        final var ws = new HashSet<>(wordDict);
        final List<List<StringBuilder>> dp = new ArrayList<>(S+1);
        dp.add(new ArrayList<>(){{add(new StringBuilder());}});
        for (var r = 1; r <= S; r++) { // O(S^2) * (O(ss + 2^n)
            dp.add(new ArrayList<>());
            final var curr = dp.get(r);
            for (var l = 0; l < r; l++) {
                final var ss = s.substring(l, r);
                if (ws.contains(ss)) { // O(ss), linearly proportional to ss.length()
                    for (var sb : dp.get(l)) { // 2^S possible lists of strings in the worst case; O(2^S) dominates O(S)
                        final var newSB = new StringBuilder(sb); // O(S)
                        newSB.append(ss).append(' ');
                        curr.add(newSB);
                    }
                }
            }
        }

        final var res = new ArrayList<String>();
        for (var sb : dp.get(S)) {
            sb.setLength(sb.length()-1);
            res.add(sb.toString());
        }

        return res;
    }
}
