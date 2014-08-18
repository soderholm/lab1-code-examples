package streams;

import java.util.Iterator;

public class Enumerable<T> implements IEnumerable<T> {

	private Iterable<T> iterable;

	public Enumerable(Iterable<T> iterable) {
		this.iterable = iterable;
	}

	@Override
	public <U> IEnumerable<U> select(final ISelector<T, U> selector) {
		return new Enumerable<U>(new Iterable<U>(){

			@Override
			public Iterator<U> iterator() {
				return new SelectIterator<U, T>(Enumerable.this, selector);
			}
			
		});
	}

	@Override
	public IEnumerable<T> where(final IPredicate<T> predicate) {
		return new Enumerable<T>(this) {
			
			@Override
			public Iterator<T> iterator() {
				return new WhereIterator<T>(Enumerable.this, predicate);
			}
		};
	}

	@Override
	public IEnumerable<T> takeUntil(final IPredicate<T> predicate) {
		return new Enumerable<T>(this) {

			@Override
			public Iterator<T> iterator() {
				return new TakeUntil<T>(Enumerable.this, predicate);
			}

		};
	}

	@Override
	public IEnumerable<T> skipUntil(final IPredicate<T> predicate) {
		return new Enumerable<T>(this) {

			@Override
			public Iterator<T> iterator() {
				return new SkipUntil<T>(Enumerable.this, predicate);
			}
		};
	}

	@Override
	public IEnumerable<T> take(final int numToTake) {
		return new Enumerable<T>(this) {

			@Override
			public Iterator<T> iterator() {
				return new TakeN<T>(Enumerable.this, numToTake);
			}
		};
	}

	@Override
	public IEnumerable<T> skip(final int numToSkip) {
		return new Enumerable<T>(this) {
			
			@Override
			public Iterator<T> iterator() {
				return new SkipN<T>(Enumerable.this, numToSkip);
			}
			
		};
	}

	@Override
	public Iterator<T> iterator() {
		return iterable.iterator();
	}

	@Override
	public void forEach(IAction<T> action) {
		for (T t : this) {
			action.perform(t);
		}
	}

}
