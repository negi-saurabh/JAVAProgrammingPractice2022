package com.saurabh.practice.prepforboo.hashasbackspacedelete;

public class HashAsBackspaceDelete {

    public String deleteAsBackspace(String input){
        StringBuilder builder = new StringBuilder();

        for (int i =0; i < input.length(); i++){
            if(input.charAt(i) == '#'){
                if(!builder.isEmpty()){
                    builder.deleteCharAt(builder.length()-1);
                }
            } else{
                builder.append(input.charAt(i));
            }
        }

        return builder.toString();
    }
    public static void main(String[] args) {

        String string1 = new HashAsBackspaceDelete().deleteAsBackspace("abc#def##");
        String string2 = new HashAsBackspaceDelete().deleteAsBackspace("#abc");
        String string3 = new HashAsBackspaceDelete().deleteAsBackspace("ab####");
        String string4 = new HashAsBackspaceDelete().deleteAsBackspace("");

        System.out.println("string1 "+string1);
        System.out.println("string2 "+string2);
        System.out.println("string3 "+string3);
        System.out.println("string4 "+string4);



    }
}
