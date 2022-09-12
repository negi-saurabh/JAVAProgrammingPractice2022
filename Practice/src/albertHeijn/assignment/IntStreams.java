package albertHeijn.assignment;

import java.util.stream.IntStream;

public class IntStreams {
	public static int streams(Integer number) {
		if(number == null) {
			return 0;
		}
		return IntStream.range(1, number).filter(i -> i%3==0).sum();
	}
}
