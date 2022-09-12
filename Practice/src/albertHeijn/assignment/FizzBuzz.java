package albertHeijn.assignment;

public class FizzBuzz {
	public static String fizzBuzz(int n) {
		StringBuffer finalString = new StringBuffer();
		if(n<1)
		{
			return "";
		}
		for (int i = 1; i <= n; i++) {
			if (i%3==0 && i%5==0)   
			{   
				finalString.append("FizzBuzz") ;  
			} 
			else if (i%3==0)   
			{  
				finalString.append("Fizz");  
			}   
			else if (i%5==0)   
			{   
				finalString.append("Buzz");  
			}  
			else   
			{  
				finalString.append(i);  
			} 
			if(i!=n)
				finalString.append("\n");  
		}  
		return finalString.toString();
	}
}
