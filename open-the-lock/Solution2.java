class Solution {
    public int openLock(String[] deadends, String target) {
        final var visited = new HashSet<String>(Arrays.asList(deadends));
        if (visited.contains("0000")) return -1;

        var begin = new HashSet<String>();
        var end = new HashSet<String>();

        begin.add("0000");
        end.add(target);
        var turns = 0;
        while (!begin.isEmpty() && !end.isEmpty()) {
            final var tmp = new HashSet<String>();
            for (var curr : begin) {
                if (end.contains(curr)) return turns;
                if (visited.contains(curr)) continue;
                visited.add(curr);
                for (var digit = 0; digit < 4; ++digit) {
                    final var c = curr.charAt(digit);
                    final var up = curr.substring(0, digit) + (c == '9' ? '0' : (char) (c+1)) + curr.substring(digit+1);
                    final var down = curr.substring(0, digit) + (c == '0' ? '9' : (char) (c-1)) + curr.substring(digit+1);
                    if (!visited.contains(up)) {
                        tmp.add(up);
                    }
                    if (!visited.contains(down)) {
                        tmp.add(down);
                    }
                }
            }
            ++turns;
            begin = end;
            end = tmp;
        }

        return -1;
    }
}
