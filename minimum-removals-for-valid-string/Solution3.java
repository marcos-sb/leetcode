class Solution {
    public String minRemoveToMakeValid(String s) {
        final var dq = new ArrayDeque<Pair<Character,Integer>>();
        final var emptyTop = new Pair<>('*',-1);
        
        for (var i = 0; i < s.length(); i++) {
            final var c = s.charAt(i);
            if (c == '(') dq.offerLast(new Pair<>(c, i));
            else if (c == ')') {
                final var top = dq.isEmpty() ? emptyTop : dq.peekLast();
                if (top.getKey() == '(') dq.pollLast();
                else dq.offerLast(new Pair<>(')', i));
            }
        }
        
        if (dq.isEmpty()) return s;
        
        final var sb = new StringBuilder(s.length());
        var next = dq.pollFirst().getValue();
        var i = 0;
        while (i < s.length()) {
            while (i < next) sb.append(s.charAt(i++));
            i++;
            if (!dq.isEmpty()) next = dq.pollFirst().getValue();
            else next = s.length();
        }
        
        return sb.toString();
    }
}
