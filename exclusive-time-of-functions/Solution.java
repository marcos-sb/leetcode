class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        final var stack = new LinkedList<int[]>();
        final var res = new int[n];
        
        for (var s : logs) {
            final var leftColon = s.indexOf(':');
            final var rightColon = s.lastIndexOf(':');
            final var id = Integer.parseInt(s.substring(0,leftColon));
            final var t = Integer.parseInt(s.substring(rightColon+1));
            final var isStart = s.charAt(leftColon+1) == 's';
            
            if (stack.isEmpty()) {
                stack.push(new int[]{id, t});
            } else {
                if (isStart) {
                    final var last = stack.peek();
                    res[last[0]] += t - last[1];
                    stack.push(new int[]{id,t});
                } else {
                    var last = stack.pop();
                    res[last[0]] += t - last[1] + 1;
                    if (stack.isEmpty()) continue;
                    last = stack.peek();
                    last[1] = t+1;
                }
            }
        }
        
        return res;
    }
}
