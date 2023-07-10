import LinkListJava.LinkLists;

import static LinkListJava.LinkLists.head;

public class CycleDetectionAndRemoval {

    LinkLists.Node slow = head;
    LinkLists.Node fast = head;
    public boolean detectCycle(){ // Floyd Cycle Finding Algorithm


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
        LinkLists.Node prev = null;
        if (detectCycle()){
            slow = head;
            while (slow == fast) {
                slow = slow.next;
                prev = fast;
                fast = fast.next;

                if (slow == fast){
                    prev.next = null;
                    return;
                }
            }
        }

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
        head.next = new LinkLists.Node(2);
        head.next.next = new LinkLists.Node(3);
        head.next.next.next = head;
        System.out.println( list.detectCycle());
        list.removeCycle();
        ll.print();
    }
}
