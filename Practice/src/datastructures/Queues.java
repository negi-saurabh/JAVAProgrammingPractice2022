package datastructures;

import java.util.*;

//FIFO
public class Queues {

	LinkedList queue ;

	//making a queue
	public Queues() {
		queue = new LinkedList();
	}

	// checking empty queue
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	// returning size
	public int size() {
		return queue.size();
	}

	// adding a node
	public void enqueue(int n){
		queue.addLast(n);
	}

	// removing a node
	public int dequeue() {
		return (int)queue.remove(0);
	}

	//peek at the first item
	public int peek() {
		return (int) queue.get(0);
	}

	public static void main(String[] args) {
		Queues numberQueue = new Queues();
		numberQueue.enqueue(5);
		numberQueue.enqueue(6);
		numberQueue.enqueue(7);
		numberQueue.enqueue(59);
		System.out.println("First Out: "+ numberQueue.dequeue());
		System.out.println("Second Out: "+ numberQueue.dequeue());
		System.out.println("Third Out: "+ numberQueue.dequeue());
		System.out.println("Fourth Out: "+ numberQueue.dequeue());
	}

}