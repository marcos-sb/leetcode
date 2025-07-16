class Solution {
    public String countOfAtoms(String formula) {
        final var stack = new ArrayDeque<Map<String, Integer>>();
        stack.push(new HashMap<>());

        final var chars = formula.toCharArray();
        final var n = chars.length;
        var i = 0;
        while (i < n) {
            final var c = chars[i];

            if (c == '(') {
                stack.push(new HashMap<>());
                ++i;
            } else if (c == ')') {
                final var top = stack.pop();
                ++i;

                var start = i;
                while (i < n && Character.isDigit(chars[i])) {
                    ++i;
                }
                final var multiplier = start == i ? 1 : Integer.parseInt(formula.substring(start, i));

                final var prev = stack.peek();
                for (var symbol : top.keySet()) {
                    final var count = top.get(symbol) * multiplier;
                    prev.put(symbol, prev.getOrDefault(symbol, 0) + count);
                }
            } else {
                var start = i++;
                while (i < n && Character.isLowerCase(chars[i])) {
                    ++i;
                }
                final var symbol = formula.substring(start, i);

                start = i;
                while (i < n && Character.isDigit(chars[i])) {
                    ++i;
                }
                final var count = start == i ? 1 : Integer.parseInt(formula.substring(start, i));
                stack.peek().put(symbol, stack.peek().getOrDefault(symbol, 0) + count);
            }
        }

        final var res = stack.peek();
        final var symbols = new ArrayList<String>(res.keySet());

        Collections.sort(symbols);

        final var sb = new StringBuilder();
        for (var symbol : symbols) {
            sb.append(symbol);
            var count = res.get(symbol);
            if (1 < count) {
                sb.append(count);
            }
        }

        return sb.toString();
    }
}
