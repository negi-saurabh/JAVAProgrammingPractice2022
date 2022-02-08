package hackerRank.WarmupChallenges;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TypesofIntegerinArray {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bufferedReader.readLine().trim());
		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt)
				.collect(toList());

		TypesofIntegerinArray.plusMinus(arr);

		bufferedReader.close();
		}
	
	

	public static void plusMinus(List<Integer> arr) {
		// Write your code here
		int length = arr.size();
		double posi=0, neg=0, zer = 0;
		for(int i=0;i < length; i++)
		{
			if(arr.get(i)>0){
				posi++;
			}else if(arr.get(i)<0){
				neg++;
			}else {
				zer++;
			}
		}
		double p =  posi/length;
		double n = neg/length;
		double z = zer/length;

		System.out.println(p);
		System.out.println(n);
		System.out.println(z);

	}
}

