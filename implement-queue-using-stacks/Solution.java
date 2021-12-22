class MyQueue {
    private final Deque<Integer> in;
    private final Deque<Integer> out;
    
    public MyQueue() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        if (out.isEmpty()) fillOut();
        return out.pop();
    }
    
    public int peek() {
        if (out.isEmpty()) fillOut();
        return out.peek();
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
    
    private void fillOut() {
        while (!in.isEmpty()) out.push(in.pop());
    }
}

