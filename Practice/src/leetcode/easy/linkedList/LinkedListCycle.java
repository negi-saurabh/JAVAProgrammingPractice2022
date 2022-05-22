package leetcode.easy.linkedList;

public class LinkedListCycle {
	
	public boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while(slow != null && fast != null  && fast.next != null) {
			if(slow == fast) {
				return true;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(20);
		
		head.next = new ListNode(4);
		head.next.next = new ListNode(5);
		head.next.next.next  = new ListNode(10);
		
		 // Just to make a cycle
	    head.next.next.next.next = head;
	}
}

