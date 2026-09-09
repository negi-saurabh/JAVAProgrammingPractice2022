package com.saurabh.practice.prepforboo;

public class HashTable {
    class Node{
        private String key;
        private int value;
        Node next;

        public Node(String key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private int size = 7;
    private Node[] dataMap;

    public HashTable(){
        dataMap = new Node[size];
    }


}
