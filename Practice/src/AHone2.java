
public class AHone2 {

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


	public static String dnaComplement(String dna) {
		StringBuffer finalString = new StringBuffer();
		for (int i = 0; i < dna.length(); i++) {
			finalString.append(dnaHelper(dna.charAt(i)));
		}
		return finalString.toString();
	}

	private static char dnaHelper(char dna) {
		switch(dna){
		case('A'): return 'T';
		case('T'): return 'A';  
		case('C'): return 'G';
		case('G'): return 'C';           
		}
		return dna;
	}
}
