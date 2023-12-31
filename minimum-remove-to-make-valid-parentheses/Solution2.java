class Solution {
    // Use a stack to keep track of unclosed '('.
    // Use a `char[]` to mark the positions in the original string
    // where we'll have to remove a parenthesis
    public String minRemoveToMakeValid(String s) {
        final var S = s.length();
        final var arrS = s.toCharArray();
        final var stack = new ArrayDeque<Integer>(S);
        for (var i = 0; i < S; i++) {
            final var c = arrS[i];
            if (!(c < 'a' || 'z' < c)) continue;
            if (c == '(') stack.push(i);
            else if (c == ')') {
                if (stack.isEmpty()) arrS[i] = '|';
                else stack.pop();
            }
        }

        while (!stack.isEmpty()) arrS[stack.pop()] = '|';

        final var res = new StringBuilder();
        for (var c : arrS) if (c != '|') res.append(c);
        
        return res.toString();
    }
}
