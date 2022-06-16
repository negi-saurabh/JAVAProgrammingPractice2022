package leetcode.easy.linkedList;

import datastructures.ListNode;

public class RemovesDuplicatesFromSortedList {
	
	 public static ListNode deleteDuplicates(ListNode head) {
		return head;
	        
	    }

	public static void main(String[] args) {
		ListNode head = new ListNode(20);

		head.next = new ListNode(20);
		head.next.next = new ListNode(5);
		head.next.next.next  = new ListNode(6);
		head.next.next.next.next  = new ListNode(10);
		head.next.next.next.next.next  = new ListNode(6);
		head.next.next.next.next.next.next  = new ListNode(20);
		head.next.next.next.next.next.next.next  = new ListNode(20);

		ListNode temp = deleteDuplicates(head);
		RemoveLinkedListElements.printList(temp);
	}

}
