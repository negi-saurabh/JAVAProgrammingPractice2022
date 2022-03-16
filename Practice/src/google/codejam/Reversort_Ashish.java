package google.codejam;

import java.util.*;

public class Reversort_Ashish {
	public static int reversesort(Integer[] arr, int len){
		int count=0;
		for(int i=0 ; i<len-1 ; i++) {
			int l=i;
			Integer[] copyArr = Arrays.copyOfRange(arr,i,len);
			// System.out.println(copyArr[0]);
			Arrays.sort(copyArr);
			// System.out.println("min value"+copyArr[0]);
			int j = Arrays.asList(arr).indexOf(copyArr[0]);
			// System.out.println("i = "+i+" j= "+j);
			Integer[] copyArr1 = Arrays.copyOfRange(arr,i,j+1);
			Collections.reverse(Arrays.asList(copyArr1));
			// System.out.println(Arrays.asList(copyArr1));
			for(int k=0 ;k<copyArr1.length;k++){
				arr[l]=copyArr1[k];
				l++;
			}
			//System.out.println(Arrays.asList(arr));
			count =count + (j-i+1);
			// System.out.println(count);

		}
		// System.out.println(count);
		return count;
	}

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int T = in.nextInt();



			for (int t = 1; t <= T; ++t) {
				int length = in.nextInt();
				Integer[] numbers = new Integer[length];
				for (int p = 0; p < length; ++p) {
					numbers[p] = in.nextInt();
				}
				System.out.println("Case #" + t + ": " +reversesort(numbers,length));
			}
		}
	}
}