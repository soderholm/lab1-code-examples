package streams;

import java.text.MessageFormat;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Iterable<Integer> evenNumbers = new EvenNumbers();
		
		IEnumerable<Integer> stream = new Enumerable<Integer>(evenNumbers);
		ISelector<Integer, String> stringRepresentation = new ISelector<Integer, String>() {

			@Override
			public String select(Integer element) {
				return MessageFormat.format("num: {0}", element);
			}
		};
		IAction<String> print = new IAction<String>() {

			@Override
			public void perform(String t) {
				System.out.println(t);
			}
		};
		IPredicate<Integer> divisibleByFour = new IPredicate<Integer>() {
			
			@Override
			public boolean accept(Integer element) {
				return element % 4 == 0;
			}
		};
		
		stream.skip(3).take(10).where(divisibleByFour).select(stringRepresentation).forEach(print);

	}

}
