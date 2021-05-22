class MyCircularQueue {
    private final int[] values;
    private int first;
    private int last;
    private int size;
    
    public MyCircularQueue(int k) {
        this.values = new int[k];
        this.first = 0;
        this.last = 0;
        this.size = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        
        final var newLast = (last + 1) % values.length;
        values[last] = value;
        last = newLast;
        size++;
        
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;
        
        first = (first + 1) % values.length;
        size--;
        
        return true;
    }
    
    public int Front() {
        if (isEmpty()) return -1;
        return values[first];
    }
    
    public int Rear() {
        if (isEmpty()) return -1;
        
        int lst = last;
        if (lst-1 < 0) lst = values.length-1;
        else lst--;
        return values[lst];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == values.length;
    }
}
