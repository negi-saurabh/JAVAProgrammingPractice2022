package com.saurabh.practice.prepforboo;

public class Stack {
    private Node top;
    private int height;

    public Stack(int value){
        Node node = new Node(value);
        top = node;
        height = 1;
    }

    class Node{
        int value;
        Node next;

        public Node (int value){
            this.value = value;
        }
    }


    public void printStack(){
        Node temp = top;
        while(temp != null){
            System.out.println("Top: "+ temp.value);
            temp = temp.next;
        }

    }

    public void getTop(){
        System.out.println("Top: "+ top.value);
    }

    public void getHeight(){
        System.out.println("height: "+ height);
    }

    public void push(int value){
        Node newnode = new Node(value);
        if (height != 0) {
            newnode.next = top;
        }
        top = newnode;
        height++;
    }

    public Node pop(){
        if (height == 0) {
           return null;
        }

        Node temp = top;
        top = top.next;
        temp.next = null;
        height--;
        return temp;
    }



}
