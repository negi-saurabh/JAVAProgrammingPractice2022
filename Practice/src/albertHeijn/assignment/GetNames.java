package albertHeijn.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetNames {

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
