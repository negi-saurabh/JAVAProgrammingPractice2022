package randomalgoproblems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GetLongestNumberFromString {

    // convert it to character array
    // check if its a digit
    // add untill you reach an character
    // add it to the list
    // find biggest length from the list

    private String getLongest(String input) {
        List<String> listOfStrings = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
        boolean flag = false;
        for (char c : input.toCharArray()) {

            if (Character.isDigit(c)) {
                buffer.append(c);
                flag = true;
            } else if (flag) {
                listOfStrings.add(buffer.toString());
                buffer.setLength(0);
                flag = false;
            }

        }
        if (buffer.length() > 0)
            listOfStrings.add(buffer.toString());

        return listOfStrings.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList())
                .getLast();

    }

    public static void main(String[] args) {
        GetLongestNumberFromString checking = new GetLongestNumberFromString();
        String longest = checking.getLongest("Invoice INV-2024 has 3 items: SKU48291 x2, SKU10342 x1, total EUR 1599");
        System.out.println("longest. " + longest);
    }

}
