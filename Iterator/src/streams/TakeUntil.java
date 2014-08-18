package streams;

import java.util.Iterator;

final class TakeUntil<T> implements Iterator<T> {
	/**
	 * 
	 */
	private final IPredicate<T> predicate;
	private Iterator<T> sourceIterator;
	T elt = null;

	TakeUntil(Enumerable<T> enumerable, IPredicate<T> predicate) {
		this.sourceIterator = enumerable.iterator();
		this.predicate = predicate;
	}

	@Override
	public boolean hasNext() {
		boolean hasNext = sourceIterator.hasNext();
		if (hasNext) {
			elt = sourceIterator.next();
		}
		return hasNext && predicate.accept(elt);
	}

	@Override
	public T next() {
		T currentValue = elt;
		elt = sourceIterator.next();
		return currentValue;
	}

	@Override
	public void remove() {
		sourceIterator.remove();
	}
}