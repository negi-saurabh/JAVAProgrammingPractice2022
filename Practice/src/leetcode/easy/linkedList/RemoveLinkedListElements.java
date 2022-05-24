package leetcode.easy.linkedList;

public class RemoveLinkedListElements {

	public static ListNode removeElements(ListNode head, int val) {
		
		while(head.next != null) {
			if(head.next.val == val) {
				head = head.next.next;
			}
			head = head.next;
		}

		return head;
	}


	public static void main(String[] args) {
		ListNode head = new ListNode(20);

		head.next = new ListNode(4);
		head.next.next = new ListNode(5);
		head.next.next.next  = new ListNode(6);
		head.next.next.next.next  = new ListNode(10);
		head.next.next.next.next.next  = new ListNode(6);

		removeElements(head, 6);
		printList(head);
	}


	private static void printList(ListNode head) {
		while(head != null) {
			System.out.println("value:" +  head.val);
			head = head.next;
		}
		
	}
}
