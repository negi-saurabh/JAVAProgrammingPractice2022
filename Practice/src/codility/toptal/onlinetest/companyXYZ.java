package codility.toptal.onlinetest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class companyXYZ {

	public static String[] solution(String S, String[] B) {
		double total = 0;
		double supply = Double.parseDouble(S);
		String[] returnDiscount = new String[B.length];
		double[] returnDiscountDouble = new double[B.length];

		for (int i = 0; i < B.length; i++) {
			returnDiscountDouble[i] = Double.parseDouble(B[i]);
			total = total + Double.parseDouble(B[i]);
		}

		Arrays.sort(returnDiscountDouble);

		for (int i = 0; i < returnDiscount.length; i++) {
			double current = Double.parseDouble(B[i])/total;
			returnDiscount[i] = String.valueOf(supply * current);
		}

		return returnDiscount;
	}

	public static void main(String[] args) throws IOException {
		String[] cars = {"300.00", "200.00", "100.00"};
		System.out.println(solution("300.01", cars ));

	}

}
