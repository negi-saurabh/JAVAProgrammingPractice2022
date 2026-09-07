package com.saurabh.practice.prepforboo;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

//        LinkedList myLinkedList = new LinkedList(1);
//
//        myLinkedList.getHead();
//        myLinkedList.getTail();
//        myLinkedList.getLength();
//
//        System.out.println("\nLinked List:");
//        myLinkedList.printList();
//
//        myLinkedList.append(2);
//        myLinkedList.printList();

//        Stack mStack = new Stack(4);
//
//        mStack.printStack();
//
//        mStack.push(3);
//        mStack.printStack();
//        mStack.pop();
//
//        mStack.printStack();

        String temp = "Saurabh";
        char[] charArray = temp.toCharArray();
        Arrays.asList(charArray).stream().forEach(i->System.out.print(i));
        java.util.Stack stack = new java.util.Stack();

        for(int i=0; i < charArray.length; i++)
        {
            stack.push(charArray[i]);
        }


        StringBuffer buffer = new StringBuffer();
        while (!stack.empty()) {
            buffer.append(stack.pop());
        }

        System.out.println(buffer.toString());
    }

}
