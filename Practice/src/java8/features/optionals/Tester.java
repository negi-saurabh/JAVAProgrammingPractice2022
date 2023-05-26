package java8.features.optionals;

import java.util.Optional;

public class Tester {

	public static void main(String[] args) {
		Tester 	tester = new Tester();
		Integer value1 = null;
		Integer value2 = Integer.valueOf(10);

		//Optional.ofNullable - allows passed parameter to be null.
		Optional<Integer> a = Optional.ofNullable(value1);

		//Optional.of - throws NullPointerException if passed parameter is null
		// Optional<Integer> c = Optional.of(value1);
		Optional<Integer> b = Optional.of(value2);


		System.out.println(tester.sum(a, b));
	}

	public Integer sum(Optional<Integer> a, Optional<Integer> b) {
		//Optional.isPresent - checks the value is present or not
		System.out.println("First Integer is present: " + a.isPresent());
		System.out.println("Second Integer is present: " + b.isPresent());

		//Optional.orElse - returns the value if present otherwise returns
		//the default value passed.
		Integer value1 = a.orElse(Integer.valueOf(0));
		System.out.println("value of value1: " + value1);
		//Optional.get - gets the value, value should be present
		Integer value2 = b.get();
		return value1 + value2;
	}
}
