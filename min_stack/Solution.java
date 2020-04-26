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
        minimums.add(Math.min(x,minimums.get(minimums.size()-1)));
    }

    public void pop() {
        minimums.remove(minimums.size()-1);
    }

    public int top() {
        return stack.get(stack.size()-1);
    }

    public int getMin() {
        return minimums.get(minimums.size()-1);
    }
    public static void main(String... args) {
        final var s = new MinStack();
        s.push(0);
        s.pop();
        s.push(1);
        System.out.println(s.getMin());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
