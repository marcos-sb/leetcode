class MyQueue {
    final List<Integer> input;
    final List<Integer> output;

    public MyQueue() {
        input = new ArrayList<>();
        output = new ArrayList<>();
    }

    public void push(int x) {
        input.add(x);
    }
    
    public int pop() {
        if (output.isEmpty())
            while (!input.isEmpty())
                output.add(input.remove(input.size()-1));
        return output.remove(output.size()-1);
    }
    
    public int peek() {
        if (output.isEmpty())
            while (!input.isEmpty())
                output.add(input.remove(input.size()-1));
        return output.get(output.size()-1);
    }
    
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}
