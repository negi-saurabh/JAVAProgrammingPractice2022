package datastructures;


import java.util.LinkedList;


//    Operation	                                LinkedList
//   ===========                                =======
//    Access by index	                            O(n)
//    Search (unsorted)	                            O(n)
//    Insert/remove at head or tail 		        O(1)
//    Insert/remove at middle with ref to node      O(1)

//  When to use:
//  frequent insert/delete at both ends, or you're implementing a Deque/Queue/Stack under the hood
//  Rare to use LinkedList directly in modern Java — usually ArrayDeque beats it (better cache locality, less memory overhead per node).

//  When to avoid:
//  if you need random access by index — that's O(n), much worse than ArrayList.

//  Interview tell:
//  rare as the answer these days. Mostly relevant to explain trade-offs, or when building your own structure (e.g. LRU cache doubly-linked list + hashmap).
public class LinkedListUsage {

    public static void main(String[] args) {
        // nodes connected via pointers (singly or doubly linked). Java's LinkedList is doubly linked.
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addFirst(1);
        ll.addLast(1);
        ll.add(0, 1);
        ll.clear();
        ll.get(2);
    }
}
