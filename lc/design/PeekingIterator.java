package lc.design;

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
    private final Iterator<Integer> iterator;
    private boolean hasPeeked;
    private Integer peekedElement;
	public PeekingIterator(Iterator<Integer> iterator) {
	    this.iterator = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(!hasPeeked) {
            peekedElement = iterator.next();
            hasPeeked = true;
        }
        return peekedElement;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	@Override
	public Integer next() {
	    if(!hasPeeked) {
	        return iterator.next();
	    }
	    hasPeeked = false;
	    Integer result = peekedElement;
	    peekedElement = null;
	    return result;
	}

	@Override
	public boolean hasNext() {
	    return hasPeeked || iterator.hasNext();
	}
}
