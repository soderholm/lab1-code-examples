package streams;

import java.util.Iterator;

public class EvenNumbers extends Enumerable<Integer> {

	public EvenNumbers() {
		super(new Iterable<Integer>() {

			@Override
			public Iterator<Integer> iterator() {
				return new Iterator<Integer>() {

					int num = 0;
					
					@Override
					public void remove() {

					}
					
					@Override
					public Integer next() {
						int currentValue = num;
						num+=2;
						return currentValue;
					}
					
					@Override
					public boolean hasNext() {
						return true;
					}
				};
			}
		});
		
	}

}
