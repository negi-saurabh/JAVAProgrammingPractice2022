package albertHeijn.assignment;

public class DNAComplement {

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
