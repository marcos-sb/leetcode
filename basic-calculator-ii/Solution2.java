import java.util.Optional;

class Solution {
    private int i;
    private Deque<Integer> q;
    private Deque<Character> opQ;

    public Solution() {
        i = 0;
        q = new LinkedList<>();
        opQ = new LinkedList<>();
    }

    public int calculate(String s) {
        q.offerLast(readInt(s));
        while (i < s.length()) {
            final var op = readOp(s);
            if (op.isEmpty()) break;
            opQ.offerLast(op.get());
            q.offerLast(readInt(s));
            final var topOp = opQ.peekLast();
            if (topOp == '/' || topOp == '*')
                doOp(false);
        }

        while (!opQ.isEmpty()) doOp(true);

        return q.poll();
    }

    private int readInt(String s) {
        final var len = s.length();
        while (i < len && s.charAt(i) == ' ') i++;
        var n = 0;
        while (i < len && Character.isDigit(s.charAt(i))) {
            n *= 10;
            n += s.charAt(i++)-'0';
        }
        return n;
    }

    private Optional<Character> readOp(String s) {
        final var len = s.length();
        while (i < len && s.charAt(i) == ' ') i++;
        if (len <= i) return Optional.empty();
        return Optional.of(s.charAt(i++));
    }

    private void doOp(boolean leftToRight) {
        var r = 0;
        var l = 0;
        var op = ' ';
        if (leftToRight) {
            l = q.poll();
            r = q.poll();
            op = opQ.poll();
        } else {
            r = q.pollLast();
            l = q.pollLast();
            op = opQ.pollLast();
        }
        var res = 0;
        switch (op) {
            case '+':
                res = l+r;
                break;
            case '-':
                res = l-r;
                break;
            case '*':
                res = l*r;
                break;
            case '/':
                res = l/r;
        }
        if (leftToRight) q.offerFirst(res);
        else q.offerLast(res);
    }
}
