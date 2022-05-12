package leetcode.medium.array;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

public class ContainerWithMostWater {

	public static int maxArea(Integer[] height) {
		/* BRUTE FORCE
		 * int max = Integer.MIN_VALUE; int area = Integer.MIN_VALUE; for (int i = 0; i
		 * < height.length; i++) { for(int j = i+1; j < height.length; j++) { area =
		 * Math.min(height[i],height[j])*(j-i); if(max<area) max = area; } }
		 */
		int max = Integer.MIN_VALUE;
		int area = Integer.MIN_VALUE;
		int secondIndex = height.length-1;
		for (int i = 0; i < height.length; i++) {
			area = Math.min(height[i],height[secondIndex])* Math.abs(secondIndex-i);
			if(height[i]>height[secondIndex]) {
				secondIndex--;
				i--;
			}
			if(max<area) 
				max = area;
		}
		return max;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String[] inputArray = bufferedReader.readLine().replaceAll("\\s+$", "").split(",");
		List<Integer> a = Stream.of(inputArray).map(Integer::parseInt).collect(toList());
		try {
			System.out.print(maxArea(a.toArray(new Integer[a.size()])));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bufferedReader.close();
	}

}
