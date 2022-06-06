package min_stack;

import java.util.ArrayList;
import java.util.List;

class MinStack {
    private final List<Integer> stack;
    private final List<Integer> minimums;
    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new ArrayList<>();
        this.minimums = new ArrayList<>();
    }

    public void push(int x) {
        stack.add(x);
        final var min = minimums.isEmpty() ? x : Math.min(x,minimums.get(minimums.size()-1));
        minimums.add(min);
    }

    public void pop() {
        stack.remove(stack.size()-1);
        minimums.remove(minimums.size()-1);
    }

    public int top() {
        return stack.get(stack.size()-1);
    }

    public int getMin() {
        return minimums.get(minimums.size()-1);
    }
}
