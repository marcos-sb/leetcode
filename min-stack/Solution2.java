class MinStack {
    private final List<Integer> stack;
    private final List<Integer> minStack;

    public MinStack() {
        stack = new ArrayList<>();
        minStack = new ArrayList<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) minStack.add(val);
        else minStack.add(val < getMin() ? val : getMin());
        stack.add(val);
    }

    public void pop() {
        if (stack.isEmpty()) return;
        minStack.removeLast();
        stack.removeLast();
    }

    public int top() {
        return stack.getLast();
    }

    public int getMin() {
        return minStack.getLast();
    }
}
