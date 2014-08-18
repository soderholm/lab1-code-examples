package streams;

public interface IEnumerable<T> extends Iterable<T> {

	public IEnumerable<T> where(IPredicate<T> predicate);

	public IEnumerable<T> takeUntil(IPredicate<T> predicate);

	public IEnumerable<T> skipUntil(IPredicate<T> predicate);

	public IEnumerable<T> take(int numToTake);

	public IEnumerable<T> skip(int numToSkip);

	public <U> IEnumerable<U> select(ISelector<T, U> selector);

	public void forEach(IAction<T> action);

}
