package com.saurabh.practice.datastructures;

import java.util.*;

public class StackQueueUsage {

//    Operation	                   ArrayDeque as Stack
//   ===========                   =======
//   push, pop, peek	            O(1)


//    When to use:
//    anything with "undo", nested structure matching (parentheses, brackets), backtracking, DFS (iterative), expression evaluation,
//    your "Implement Backspacing" example ("abc#def##" → "abd" is a classic stack problem: push chars, pop on #).

//    When to avoid:
//    you need to access anything other than the top element.

    public static void main(String[] args) {
        // 1) Stack - last in first out
        //    Don't use the old java.util.Stack class — it's legacy and synchronized (slower). Use ArrayDeque for stack behavior.
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.pop();
        stack.peek();

        // 2) Queue - First in first out

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        stack.poll();
//    When to use:
//    BFS, task scheduling, sliding window (as a Deque, not just queue — see below), producer/consumer patterns.

//    Deque (double-ended queue) specifically is the workhorse for sliding window maximum/minimum problems
//    — you maintain a monotonic deque of indices. This is a very likely pattern for a Booking-style "reservations" problem.
    }
}
