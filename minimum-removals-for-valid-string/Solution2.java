class Solution {
    public String minRemoveToMakeValid(String s) {
        final var stack = new ArrayList<Pair<Character,Integer>>();
        final var emptyTop = new Pair<>('*',-1);
        
        for (var i = 0; i < s.length(); i++) {
            final var c = s.charAt(i);
            if (c == '(') stack.add(new Pair<>(c, i));
            else if (c == ')') {
                final var top =
                    stack.isEmpty() ? emptyTop : stack.get(stack.size()-1);
                if (top.getKey() == '(') stack.remove(stack.size()-1);
                else stack.add(new Pair<>(')', i));
            }
        }
        
        final var remove = new ArrayList<Integer>(stack.size());
        while (!stack.isEmpty())
            remove.add(stack.remove(stack.size()-1).getValue());
        
        if (remove.isEmpty()) return s;
        
        final var sb = new StringBuilder(s.length());
        var next = remove.remove(remove.size()-1);
        var i = 0;
        while (i < s.length()) {
            while (i < next) sb.append(s.charAt(i++));
            i++;
            if (!remove.isEmpty())
                next = remove.remove(remove.size()-1);
            else next = s.length();
        }
        
        return sb.toString();
    }
}
