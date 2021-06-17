class Solution {
    public int countBinarySubstrings(String s) {
        if (s == null || s.length() < 2) return 0;
        
        final var stacks = new ArrayList<ArrayDeque<Character>>(2);
        stacks.add(new ArrayDeque<>());
        stacks.add(new ArrayDeque<>());
        var prev = s.charAt(0);
        stacks.get(prev-'0').offerLast(prev);
        var count = 0;
        for (var i = 1; i < s.length(); i++) {
            final var c = s.charAt(i);
            final var idx = c-'0';
            final var stackC = stacks.get(idx);
            final var stackOther = stacks.get((idx+1) % 2);
            if (prev != c) stackC.clear();
            if (!stackOther.isEmpty()) {
                stackOther.pollLast();
                count++;
            }
            stackC.offerLast(c);
            
            prev = c;
        }
        
        return count;
    }
}
