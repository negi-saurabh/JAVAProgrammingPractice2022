package prepforBoo;

public class DayTwo {

    public static void main(String[] args) {

        System.out.println(isPalindrome("NAMAN"));
    }

    public static boolean isPalindrome(String s) {
        // your code
        char[] charArray =s.toCharArray();
        int j= charArray.length-1;
        for(int i = 0; i > j;i++ ){
            if(charArray[i] != charArray[j]){
                return false;
            }
            j--;
        }
        return true;
    }
}
