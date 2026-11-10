package com.saurabh.practice.leetcode2026.medium.linkedlist;

public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // loop through l1 and construct the number  and reverse
        // same for l2
        // add numbers
        // create one empty linked list and set each digit at each node

        StringBuilder builder = new StringBuilder();

        while (l1 != null) {
            builder.append(l1.val);
            l1 = l1.next;
        }

        int val1 = Integer.parseInt(builder.reverse().toString());
        builder.setLength(0);


        while (l2 != null) {
            builder.append(l2.val);
            l2 = l2.next;
        }

        int val2 = Integer.parseInt(builder.reverse().toString());

        String finalVal = String.valueOf(val1 + val2);

        int finalIntVal = Integer.parseInt(finalVal);

        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while (finalIntVal != 0) {
            current.next = new ListNode(finalIntVal % 10);
            current = current.next;
            finalIntVal = finalIntVal / 10;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);


        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);


        new AddTwoNumbers().addTwoNumbers(node1, node2);
    }
}
