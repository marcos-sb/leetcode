class MinStack {
    class Node {
        int val;
        int min;
        Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    private final List<Node> value;

    public MinStack() {
        value = new ArrayList<>();
    }
    
    public void push(int val) {
        var min = val;
        if (!value.isEmpty())
            min = Math.min(value.get(value.size()-1).min, val);
        value.add(new Node(val, min));
    }
    
    public void pop() {
        value.remove(value.size()-1);
    }
    
    public int top() {
        return value.get(value.size()-1).val;
    }
    
    public int getMin() {
        return value.get(value.size()-1).min;
    }
}
