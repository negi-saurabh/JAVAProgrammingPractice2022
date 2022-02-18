package hackerRank.ThirtyDaysofCode;

public class Inheritance {

	class Person {
		protected String firstName;
		protected String lastName;
		protected int idNumber;
		
		// Constructor
		Person(String firstName, String lastName, int identification){
			this.firstName = firstName;
			this.lastName = lastName;
			this.idNumber = identification;
		}
		
		// Print person data
		public void printPerson(){
			 System.out.println(
					"Name: " + lastName + ", " + firstName 
				+ 	"\nID: " + idNumber); 
		}
		 
	}

	class Student extends Person{
		private int[] testScores;

	    /*	
	    *   Class Constructor
	    *   
	    *   @param firstName - A string denoting the Person's first name.
	    *   @param lastName - A string denoting the Person's last name.
	    *   @param id - An integer denoting the Person's ID number.
	    *   @param scores - An array of integers denoting the Person's test scores.
	    */
	    // Write your constructor here
		public Student(String firstName, String lastName, int idNumber, int[] scores)
		{
			super(firstName, lastName, idNumber);
			testScores = scores;
		}

	    /*	
	    *   Method Name: calculate
	    *   @return A character denoting the grade.
	    */
	    // Write your method here
		
		public char calculate() {
			float total = 0;
			float length = testScores.length;
			for (int i = 0; i < length; i++) {
					total = total + testScores[i];
			}
			float avg = total/length;
			if(90 <= avg && avg <=100)
			{
				return 'O';
			}else if(80 <= avg && avg < 90)
			{
				return 'E';
			}
			else if(70 <= avg && avg < 80)
			{
				return 'A';
			}else if(55 <= avg && avg < 70)
			{
				return 'P';
			}else if(40 <= avg && avg < 55)
			{
				return 'D';
			}else {
				return 'T';
			}
		}
	}

	class Solution {
	}
	}