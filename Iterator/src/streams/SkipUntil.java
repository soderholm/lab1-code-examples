package streams;

import java.util.Iterator;

final class SkipUntil<T> implements Iterator<T> {
	/**
	 * 
	 */
	private final IPredicate<T> predicate;
	private Iterator<T> sourceIterator;
	T elt = null;

	SkipUntil(Enumerable<T> enumerable, IPredicate<T> predicate) {
		this.sourceIterator = enumerable.iterator();
		this.predicate = predicate;
	}

	@Override
	public boolean hasNext() {
		boolean hasNext = sourceIterator.hasNext();
		T nextElement = null;
		if (hasNext) {
			nextElement = sourceIterator.next();
			while (sourceIterator.hasNext()
					&& !predicate.accept(elt)) {
				nextElement = sourceIterator.next();
			}
		}
		elt = nextElement;
		return nextElement != null;
	}

	@Override
	public T next() {
		return elt;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
	}
}