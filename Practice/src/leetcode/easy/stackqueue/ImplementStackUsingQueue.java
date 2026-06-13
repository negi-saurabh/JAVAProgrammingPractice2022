package leetcode.easy.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {

    Queue<Integer> queueOne;
    Queue<Integer> queueTwo;
    public ImplementStackUsingQueue() {
        queueOne = new LinkedList<>();
        queueTwo = new LinkedList<>();
    }

    public void push(int x) {
        queueOne.add(x);
    }

    public int pop() {
        return 1;
    }


    public int top() {
        return 1;
    }

    public boolean empty() {
            return true;
    }
    public static void main(String[] args) {
        ImplementStackUsingQueue  implementStackUsingQueue = new ImplementStackUsingQueue();
        implementStackUsingQueue.push(8);
        int param_2 = implementStackUsingQueue.pop();
        int param_3 = implementStackUsingQueue.top();
        boolean param_4 = implementStackUsingQueue.empty();
    }
}



