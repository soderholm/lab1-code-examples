package streams;

public interface ISelector<T1, T2> {

	T2 select(T1 element);
	
}
