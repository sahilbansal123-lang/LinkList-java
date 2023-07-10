import LinkListJava.LinkLists;

import static LinkListJava.LinkLists.head;

public class CycleDetectionAndRemoval {

    public boolean detectCycle(){ // Floyd Cycle Finding Algorithm
        LinkLists.Node slow = head;
        LinkLists.Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                return true;
            }
        }
        return false;
    }

    public void removeCycle(){
        LinkLists.Node slow = head;
        LinkLists.Node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                cycle = true;
                break;
            }
        }
        if (!cycle) {
            return;
        }
        slow = head;
        LinkLists.Node prev = null;
            while (slow != fast) {
                prev = fast;
                slow = slow.next;
                fast = fast.next;
            }
            prev.next = null;
    }


        public static void main(String[] args) {
        LinkLists ll = new LinkLists();
        CycleDetectionAndRemoval list = new CycleDetectionAndRemoval();
//        ll.addFirst(10);
//        ll.addFirst(5);
//        ll.addFirst(6);
//        ll.addFirst(7);
//        ll.addFirst(8);
//        ll.addFirst(9);
//
//        ll.print();
//        System.out.println(ll.checkPalindrome());
        head = new LinkLists.Node(1);
        LinkLists.Node temp = new LinkLists.Node(2);
        head.next = temp;
        head.next.next = new LinkLists.Node(3);
        head.next.next.next = new LinkLists.Node(4);
        head.next.next.next.next = temp;
        System.out.println( list.detectCycle());
        list.removeCycle();
        System.out.println( list.detectCycle());

    }
}
