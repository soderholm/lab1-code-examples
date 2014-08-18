package streams;

import java.util.Iterator;

final class TakeN<T> implements Iterator<T> {
	/**
	 * 
	 */
	private final int numToTake;
	private Iterator<T> srcIterator;
	int num = 0;

	TakeN(Iterable<T> iterable, int numToTake) {
		this.srcIterator = iterable.iterator();
		this.numToTake = numToTake;
	}

	@Override
	public boolean hasNext() {
		return num < numToTake && srcIterator.hasNext();
	}

	@Override
	public T next() {
		num++;
		return srcIterator.next();
	}

	@Override
	public void remove() {

	}
}