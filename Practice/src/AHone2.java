import java.util.stream.IntStream;
import java.util.*;

public class AHone2 {

	public static List<String> getAllNames(List<Customer> customers, int minAge) {
		List<String> nameList = new ArrayList();
		for (int i = 0; i < customers.size(); i++) {
			int age = customers.get(i).getAge();
			if(age >= minAge )
			{
				String fullname  = customers.get(i).getLastName()+", "+customers.get(i).getFirstName()+ " ";
				nameList.add(fullname);
			}
		}
		Collections.sort(nameList);
		return nameList;
	}

	public static List<String> getAllNames2(List<Customer> customers, int minAge) {
		SortedSet<String> namesSet = new TreeSet<String>();
		for (int i = 0; i < customers.size(); i++) {
			int age = customers.get(i).getAge();
			if(age >= minAge )
			{
				String fullname  = customers.get(i).getLastName()+", "+customers.get(i).getFirstName();
				namesSet.add(fullname);
				System.out.println(fullname);
			}
		}
		
		List<String> namesList = new ArrayList<>();
		Iterator<String> namesIterator = namesSet.iterator();
		while(namesIterator.hasNext()) {
			namesList.add(namesIterator.next().trim());
		}
		
		return namesList;
	}

	public static int streams(Integer number) {
		if(number == null) {
			return 0;
		}
		return IntStream.range(1, number).filter(i -> i%3==0).sum();
	}



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


	

	class Customer {

		int age;
		String firstName;
		String lastName;

		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

	}
}
