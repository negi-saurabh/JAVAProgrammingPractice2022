package com.saurabh.practice.prepforboo.FirstNonRepeatingCharacter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class FirstNonRepeatingCharacter {

    public static Optional<Character> firstNonRepeatingCharacter(String input){
        Map<Character, Integer> frequenceyMap = new LinkedHashMap<>();

        for(int i=0; i < input.length();i++){
            frequenceyMap.merge(input.charAt(i), 1, Integer::sum);
        }

        return frequenceyMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();

    }
    public static void main(String[] args) {
        String test1 = "swiss";
        Optional<Character> returnedVal = firstNonRepeatingCharacter(test1);
        if(returnedVal.isPresent()) {
            System.out.println(returnedVal.get());
        }

        String test2 = "";
        Optional<Character> returnedVal2 = firstNonRepeatingCharacter(test2);
        if(returnedVal2.isPresent()) {
            System.out.println(returnedVal2.get());
        }else{
            System.out.println("No character with only one occurrence");
        }

        String test3 = "aabbcc";
        Optional<Character> returnedVal3 = firstNonRepeatingCharacter(test3);
        if(returnedVal3.isPresent()) {
            System.out.println(returnedVal3.get());
        }else{
            System.out.println("No character with only one occurrence");
        }

        String test4 = "aAabbcc";
        Optional<Character> returnedVal4 = firstNonRepeatingCharacter(test4);
        if(returnedVal4.isPresent()) {
            System.out.println(returnedVal4.get());
        }else{
            System.out.println("No character with only one occurrence");
        }
    }
}
