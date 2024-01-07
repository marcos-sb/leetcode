class MyQueue {
    private final Deque<Integer> in;
    private final Deque<Integer> out;

    public MyQueue() { // O(1)
        in = new ArrayDeque<>();
        out = new ArrayDeque<>();        
    }

    public void push(int x) { // O(1)
        in.push(x);
    }

    public int pop() { // O(1) amortised time
        lazyPrepareOut();
        return out.pop();
    }

    public int peek() { // O(1) amortised time
        lazyPrepareOut();
        return out.peek();
    }
    
    public boolean empty() { // O(1)
        return in.isEmpty() && out.isEmpty();
    }

    private void lazyPrepareOut() { // O(1) amortised time
        if (out.isEmpty())
            while (!in.isEmpty()) out.push(in.pop());
    }
}
