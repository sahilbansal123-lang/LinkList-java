package preDefined;

import LinkListJava.LinkLists;

public class ZigZagLinkList extends LinkLists{

    public void zigzagList() {

        // Calculate MID
        LinkLists.Node slow = head;
        LinkLists.Node fast = head.next;

        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        LinkLists.Node mid = slow;
        // Reverse Second Half
        LinkLists.Node curr = mid.next;
        mid.next = null;
        LinkLists.Node prev = null;
        LinkLists.Node nxt;

        while (curr != null){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        LinkLists.Node left = head;
        LinkLists.Node right = prev;
        LinkLists.Node nextL, nextR;

        // Alternate ZigZag Merging
        while (left != null && right != null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }



    public static void main(String[] args) {
//        LinkLists list = new LinkLists();
        ZigZagLinkList ll = new ZigZagLinkList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
//        ll.addFirst(6);
        ll.print();
        ll.zigzagList();
        ll.print();
    }
}
