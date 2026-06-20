package randomalgoproblems;

public class SumOfNumbersInAnArray {
    public int sumOfNumbers(String input) {
        int sum = 0;
        StringBuffer sb = new StringBuffer();

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                sum += Integer.parseInt(input.toString());
                sb.setLength(0);
            }
        }

        if (sb.length() > 0)
            sum = +Integer.parseInt(input.toString());
        return sum;
    }

    public static void main(String[] args) {

        System.out.println("Hello, World!");

    }

}
