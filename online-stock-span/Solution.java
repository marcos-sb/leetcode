class StockSpanner {
    private final Deque<int[]> stack;

    public StockSpanner() {
        stack = new ArrayDeque<int[]>();
    }

    public int next(int price) {
        var span = 1;

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        stack.push(new int[]{price, span});

        return span;
    }
}
