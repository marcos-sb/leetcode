class MinStack {
    private Deque<Pair<Integer,Integer>> stack;
    
    public MinStack() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        final var min =
            stack.isEmpty() ? Integer.MAX_VALUE : stack.peek().getValue();
        stack.push(new Pair<>(val, Math.min(min, val)));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().getKey();
    }
    
    public int getMin() {
        return stack.peek().getValue();
    }
}
