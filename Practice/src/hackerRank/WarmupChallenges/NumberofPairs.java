package hackerRank.WarmupChallenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberofPairs {
	public static void main(String[] args)
	{
		int n = 9;
		
		List<Integer> ar = new ArrayList<>(Arrays.asList(10, 20, 20, 10, 10, 30, 50, 10, 20));
		int result = sockMerchant(n, ar);
		System.out.println("The number of total pair of socks is :: " + result);
	}
	public static int sockMerchant(int n, List<Integer> ar) {
		// Write your code here
		List<Integer> listOfColor = new ArrayList<Integer>();
		int result = 0;
		for(int i=0; i< n; i++ )
		{
			int colour = ar.get(i);
			int sameColour = 0;
			for(int j=i ; j < n ; j++)
			{
				int more = ar.get(j);
				if(listOfColor.contains(more))
					continue;
				if(colour == more)
				{
					sameColour = sameColour +1;
				}
			}
			result = result + sameColour/2;
			listOfColor.add(colour);
		}
		return result;
	}
}
