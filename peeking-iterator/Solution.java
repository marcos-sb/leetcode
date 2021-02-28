class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> wrappedIt;
    private Integer current;

	public PeekingIterator(Iterator<Integer> iterator) {
	    this.wrappedIt = iterator;
        this.current = null;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (current == null) current = next();
        return current;
	}
    
	@Override
	public Integer next() {
        if (current != null) {
            final var _current = current;
            current = null;
            return _current;
        }
	    return wrappedIt.next();
	}
	
	@Override
	public boolean hasNext() {
        if (current != null) return true;
	    return wrappedIt.hasNext();
	}
}
