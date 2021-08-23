class Solution {
    public String decodeString(String s) {
        final var res = new StringBuilder();
        final var qs = new ArrayDeque<Character>(s.length());
        for (int i = 0; i < s.length(); i++) qs.offer(s.charAt(i));

        while (!qs.isEmpty()) decode(qs, res);

        return res.toString();
    }

    private static void decode(Queue<Character> qs, StringBuilder sb) {
        while (!qs.isEmpty() && Character.isLetter(qs.peek()))
            sb.append(qs.poll());

        if (qs.isEmpty()) return;

        var count = extractCount(qs);
        final var group = extractGroup(qs);

        while (count-- > 0) sb.append(group);
    }

    private static int extractCount(Queue<Character> qs) {
        var count = 0;
        while (!qs.isEmpty() && qs.peek() != '[') {
            count *= 10;
            count += qs.poll() - '0';
        }
        return count;
    }

    private static String extractGroup(Queue<Character> qs) {
        final var sb = new StringBuilder();
        qs.poll(); // start with a '[', so we remove it from the queue
        while (!qs.isEmpty() && qs.peek() != ']') {
            final var top = qs.peek();
            if (Character.isDigit(top)) {
                final var subGroup = new StringBuilder();
                decode(qs, subGroup);
                sb.append(subGroup);
            } else if (Character.isLetter(top)) {
                sb.append(qs.poll());
            }
        }
        if (!qs.isEmpty()) qs.poll(); // end with a ']'

        return sb.toString();
    }
}
