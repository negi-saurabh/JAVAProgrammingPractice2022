package leetcode.easy.linkedList;

public class MergeTwoSortedList {

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode mergedList  = new ListNode();
		while(list1 != null && list2 != null) {
			if(list1.val < list2.val) {
				mergedList.val = list1.val;
				list1 = list1.next;
			}else {
				mergedList.val = list2.val;
				list2 = list2.next;
			}
			mergedList = mergedList.next;
		}

		while(list1 != null) {
			mergedList.val = list1.val;
			list1 = list1.next;
			mergedList = mergedList.next;
		}
		while(list2 != null) {
			mergedList.val = list2.val;
			list2 = list2.next;
			mergedList = mergedList.next;
		}
		return mergedList;
	}
}

class ListNode { 
	int val; 
	ListNode next; 
	ListNode() {} 
	ListNode(int val) { 
		this.val = val; 
	} 
	ListNode(int val, ListNode next) {
		this.val = val; this.next = next; 
	} 
}

