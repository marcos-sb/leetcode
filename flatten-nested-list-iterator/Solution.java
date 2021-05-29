public class NestedIterator implements Iterator<Integer> {
    private final Deque<Iterator<NestedInteger>> st;
    private Integer next;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.st = new LinkedList<>();
        this.st.offerLast(nestedList.iterator());
        this.next = null;
    }

    @Override
    public Integer next() {
        if (!hasNext()) return null;
        final var ret = next;
        next = null;
        return ret;
    }

    @Override
    public boolean hasNext() {
        if (next != null) return true;
        
        while (!st.isEmpty()) {
            var top = st.peekLast();
            if (top.hasNext()) {
                var nextNested = top.next();
                if (nextNested.isInteger()) {
                    next = nextNested.getInteger();
                    return true;
                }
                st.offerLast(nextNested.getList().iterator());
            } else st.pollLast();
        }
        
        return false;
    }
}
