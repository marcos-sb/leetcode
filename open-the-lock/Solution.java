class Solution {
    public int openLock(String[] deadends, String target) {
        final var visited = new HashSet<String>();
        for (var s : deadends) {
            visited.add(s);
        }

        if (visited.contains("0000")) return -1;

        final var q = new ArrayDeque<String>();
        var turns = 0;

        q.offer("0000");
        visited.add("0000");
        while (!q.isEmpty()) {
            var size = q.size();
            while (0 < size--) {
                final var curr = q.poll();
                if (curr.equals(target)) return turns;
                for (var digit = 0; digit < 4; ++digit) {
                    final var c = curr.charAt(digit);
                    final var up = curr.substring(0, digit) + (c == '9' ? '0' : (char) (c+1)) + curr.substring(digit+1);
                    final var down = curr.substring(0, digit) + (c == '0' ? '9' : (char) (c-1)) + curr.substring(digit+1);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            ++turns;
        }

        return -1;
    }
}
