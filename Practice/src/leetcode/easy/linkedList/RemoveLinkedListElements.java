package leetcode.easy.linkedList;

public class RemoveLinkedListElements {

	public static ListNode removeElements(ListNode head, int val) {

		ListNode dummy = new ListNode(-1) , prev = dummy , toDelete;
		dummy.next = head;
		while(head != null) {
			if(head.val == val) {
				prev.next = head.next;
			}
			else {
				prev = head;
			}
			head = head.next;
		}
		return dummy.next;

		/*
		 * if(head.val == val) { head = head.next; } ListNode temp = head;
		 * while(head.next != null) { if(head.next.val == val) { head.next =
		 * head.next.next; }else { head = head.next; } }
		 * 
		 * return temp;
		 */
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

		ListNode temp = removeElements(head, 20);
		printList(temp);
	}


	private static void printList(ListNode head) {
		while(head != null) {
			System.out.println("value:" +  head.val);
			head = head.next;
		}

	}
}
