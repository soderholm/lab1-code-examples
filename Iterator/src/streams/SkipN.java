package streams;

import java.util.Iterator;

public class SkipN<T> implements Iterator<T> {

	private Iterator<T> srcIterator;
	private T elt = null;

	public SkipN(Enumerable<T> enumerable, int numToSkip) {
		this.srcIterator = enumerable.iterator();
		while (numToSkip-- >= 0 && srcIterator.hasNext()) {
			elt = srcIterator.next();
		}
	}

	@Override
	public boolean hasNext() {
		return elt != null || srcIterator.hasNext();
	}

	@Override
	public T next() {
		T currentValue = elt;
		elt = srcIterator.hasNext() ? srcIterator.next() : null;
		return currentValue;
	}

	@Override
	public void remove() {
		srcIterator.remove();
	}

}
