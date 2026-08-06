package prepforBoo;

public class DayTwo {

    public static void main(String[] args) {

        System.out.println(isPalindrome("NAMAN"));
    }

    public static boolean isPalindrome(String s) {
        // your code
        char[] charArray =s.toLowerCase().toCharArray();
        StringBuffer  buffer = new StringBuffer();
        for(int i = 0; i < charArray.length;i++ ) {
                if(Character.isLetterOrDigit(charArray[i])){
                    buffer.append(charArray[i]);
            }
        }
        String cleanedString = buffer.toString();
        int j= cleanedString.length()-1;
        for(int i = 0; i < j;i++ ){
            if(cleanedString.toCharArray()[i] != cleanedString.toCharArray()[j]){
                return false;
            }
            j--;
        }
        return true;
    }
}
