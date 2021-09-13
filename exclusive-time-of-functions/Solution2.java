class Solution2 {
    public int[] exclusiveTime(int n, List<String> logs) {
        final var stack = new LinkedList<Integer>();
        final var res = new int[n];
        
        var lastStart = 0;
        for (var s : logs) {
            final var leftColon = s.indexOf(':');
            final var rightColon = s.lastIndexOf(':');
            final var id = Integer.parseInt(s.substring(0,leftColon));
            final var t = Integer.parseInt(s.substring(rightColon+1));
            final var isStart = s.charAt(leftColon+1) == 's';
            
            if (stack.isEmpty()) {
                stack.push(id);
                lastStart = t;
            } else {
                if (isStart) {
                    res[stack.peek()] += t - lastStart;
                    stack.push(id);
                    lastStart = t;
                } else {
                    res[stack.pop()] += t - lastStart + 1;
                    lastStart = t+1;
                }
                
            }
        }
        
        return res;
    }
}
