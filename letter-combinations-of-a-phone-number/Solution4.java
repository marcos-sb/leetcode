class Solution {
    private static Map<Character, List<Character>> mapping;
    static {
        mapping = Map.of(
            '2', List.of('a', 'b', 'c'),
            '3', List.of('d', 'e', 'f'),
            '4', List.of('g', 'h', 'i'),
            '5', List.of('j', 'k', 'l'),
            '6', List.of('m', 'n', 'o'),
            '7', List.of('p', 'q', 'r', 's'),
            '8', List.of('t', 'u', 'v'),
            '9', List.of('w', 'x', 'y', 'z')
        );
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return List.of();
        final var res = new ArrayList<String>();
        bt(digits.toCharArray(), 0, new StringBuilder(), res);
        return res;
    }

    private static void bt(char[] digits, int i, StringBuilder partial, List<String> res) {
        if (i == digits.length) {
            res.add(partial.toString());
            return;
        }

        for (var c : mapping.get(digits[i])) {
            partial.append(c);
            bt(digits, i+1, partial, res);
            partial.setLength(partial.length()-1);
        }
    }
}
