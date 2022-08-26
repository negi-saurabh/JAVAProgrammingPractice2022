package leetcode.medium.array;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

public class GasStation {
	
	 public static int canCompleteCircuit(Integer[] gas, int[] cost) {
	        int[] combinedArray = new int[gas.length];
	        int[] finalArray = new int[gas.length];
	        int temp1=0;
	        int temp2=0;
	        
	        for(int i=0; i < gas.length - 1 ; i++){
	            combinedArray[i] = gas[i] - cost[i];
	        }
	        
	        for(int i=0; i < combinedArray.length - 1 ; i++){
	           if(combinedArray[i] > 0){
	               temp1 = i;
	           }
	        }
	        
	        for(int i=0; i < combinedArray.length - temp1 ; i++){
	          finalArray[i] = combinedArray[i+temp1];
	            temp2 = i;
	        }
	        
	        for(int i=temp2; i < finalArray.length - 1 ; i++){
	          finalArray[i] = combinedArray[i];
	        }
			return temp2;
	        
	    }
	 
	 public static void main(String[] args) throws IOException {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String[] inputArray = reader.readLine().replaceAll("\\s+$", "").split(",");
			List<Integer> a = Stream.of(inputArray).map(Integer::parseInt).collect(toList());
			System.out.print(canCompleteCircuit(a.toArray(new Integer[a.size()]), null));
		}

}
