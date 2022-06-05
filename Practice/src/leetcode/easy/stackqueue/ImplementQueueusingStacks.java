package leetcode.easy.stackqueue;

import java.util.Stack;

public class ImplementQueueusingStacks {
	Stack<Integer> str1;
	Stack<Integer> str2;

	public ImplementQueueusingStacks() {
		str1 = new Stack<>();
		str2 = new Stack<>();
	}

	public void push(int x) {
		str1.push(x);
	}

	public int pop() {
		int length = str1.size();
		if(str2.isEmpty()) {
			for (int i = 0; i < length; i++) {
				str2.push(str1.pop());
			}
		}
		return str2.pop();
	}

	public int peek() {
		int length = str1.size();
		if(str2.isEmpty()) {
			for (int i = 0; i < length; i++) {
				str2.push(str1.pop());
			}
		}
		return str2.peek();
	}

	public boolean empty() {
		if(str1.isEmpty() && str2.isEmpty())
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		ImplementQueueusingStacks myQueue = new ImplementQueueusingStacks();
		myQueue.push(1); // queue is: [1]
		myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
		myQueue.peek(); // return 1
		myQueue.pop(); // return 1, queue is [2]
		myQueue.empty(); //
	}

}
