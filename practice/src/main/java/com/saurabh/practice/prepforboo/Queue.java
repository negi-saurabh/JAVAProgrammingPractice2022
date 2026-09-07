package com.saurabh.practice.prepforboo;

public class Queue {

    private Node first;
    private Node last;
    private int length;
    class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }
    public  Queue(int value){
        Node node = new Node(value);
        first = node;
        last = node;
        length = 1;
    }



}
