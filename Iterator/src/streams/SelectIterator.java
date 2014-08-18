/**
 * 
 */
package streams;

import java.util.Iterator;

final class SelectIterator<U, T> implements Iterator<U> {
	private final ISelector<T, U> selector;
	Iterator<T> sourceIterator;

	SelectIterator(Iterable<T> collection, ISelector<T, U> selector) {
		this.selector = selector;
		sourceIterator = collection.iterator();
	}

	@Override
	public boolean hasNext() {
		return sourceIterator.hasNext();
	}

	@Override
	public U next() {
		return selector.select(sourceIterator.next());
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}