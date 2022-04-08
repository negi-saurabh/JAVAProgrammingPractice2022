package hackerRank.linkedlist;

public class DetectACycle {
    boolean hasCycle(Node head) {
        if(head==null)
            return false;

        Node fast = head;
        Node slow = head;

        while(fast.next!=null  && fast.next.next != null){
            if(slow == fast)
            {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}

class Node {
    int data;
    Node next;
}
