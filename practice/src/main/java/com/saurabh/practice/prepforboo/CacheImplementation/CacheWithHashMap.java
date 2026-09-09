package com.saurabh.practice.prepforboo.CacheImplementation;

import java.util.HashMap;
import java.util.Map;

public class CacheWithHashMap<K, V> {
    private Node head;
    private Node tail;
    private class Node{
        K key;
        V value;
        Node prev;
        Node next;

        Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<K, Node> cache;

    public CacheWithHashMap(int capacity){
        this.cache = new HashMap<>();
        this.capacity = capacity;
    }

    public V get(K key){
        Node node =  cache.get(key);
        if (node == null){
            return null;
        }

        // This key was recently used
        // moveToEnd(node);
        return node.value;
    }

    public void put(K key, V value){
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;
            // This key was recently used
            moveToEnd(node);
            return;
        }

        Node node = new Node(key,value);
        cache.put(key, node);

        addToEnd(node);

        if (cache.size()>capacity){
            Node temp = head;

           //removeNode(temp)
            cache.remove(temp.key);
        }
    }

    private void addToEnd(Node newNode){
            if(tail == null){
                head = tail = newNode;
                return;
            }
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
    }

    private void moveToEnd(Node node){
            // Already MRU
            if (node == tail) {
                return;
            }
            removeNode(node);
            addToEnd(node);

    }

    private void removeNode(Node node){
        if(node.prev != null){
            node.prev.next = node.next;
        }else{
            head = node.next;
        }
        if(node.next != null){
            node.next.prev = node.prev;
        }else{
            tail = node.prev;
        }

        node.prev = null;
        node.next = null;
    }
}
