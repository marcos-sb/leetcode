class Solution {
    private static final Map<Character, List<Character>> d2l = Map.of(
        '2', List.of('a','b','c'),
        '3', List.of('d','e','f'),
        '4', List.of('g','h','i'),
        '5', List.of('j','k','l'),
        '6', List.of('m','n','o'),
        '7', List.of('p','q','r','s'),
        '8', List.of('t','u','v'),
        '9', List.of('w','x','y','z')
    );
    
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return List.of();
        
        final var res = new ArrayList<String>();
        final var comb = new StringBuilder(8);
        bt(digits, 0, comb, res);
        
        return res;
    }
    
    private static void bt(String s, int i, StringBuilder comb, List<String> res) {
        if (i == s.length()) {
            res.add(comb.toString());
            return;
        }
        
        final var d = s.charAt(i);
        for (var c : d2l.get(d)) {
            comb.append(c);
            bt(s, i+1, comb, res);
            comb.setLength(comb.length()-1);
        }
    }
}
