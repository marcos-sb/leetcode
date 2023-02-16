class Solution {
    public boolean backspaceCompare(String s, String t) {
        return process(s).equals(process(t));
    }
    
    private static List<Character> process(String s) {
        final var arr = s.toCharArray();
        final var res = new LinkedList<Character>();
        for (var c : arr) {
            if (c == '#') {
                if (!res.isEmpty()) res.pop();
            } else res.push(c);
        }
        return res;
    }
}
