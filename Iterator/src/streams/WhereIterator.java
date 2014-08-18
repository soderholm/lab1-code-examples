package streams;

import java.util.Iterator;

public class WhereIterator<T> implements Iterator<T> {

	private Iterator<T> iterator;
	private IPredicate<T> predicate;

	public WhereIterator(Iterable<T> iterable, IPredicate<T> predicate) {
		this.iterator = iterable.iterator();
		this.predicate = predicate;
	}

	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}

	@Override
	public T next() {
		T item = iterator.hasNext() ? iterator.next() : null;
		while (iterator.hasNext() && !predicate.accept(item)) {
			item = iterator.next();
		}
		return item;
	}

	@Override
	public void remove() {
		iterator.remove();
	}

}
