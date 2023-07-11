package preDefined;
import LinkListJava.LinkLists;

public class ZigZagLinkList {
    private LinkLists.Node getMid(LinkLists.Node head) {
        LinkLists.Node slow = head;
        LinkLists.Node fast = head.next;

        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public LinkLists.Node zigzagList(LinkLists.Node head) {

        // Calculate MID
        LinkLists.Node mid = getMid(head);
        // Reverse Second Half
        LinkLists.Node rightHead = mid.next;
        mid.next = null;
        LinkLists.Node nextRig = zigzagList(rightHead);
        LinkLists.Node nextLef = zigzagList(head);



        return mid;
    }



    public static void main(String[] args) {
        LinkLists list = new LinkLists();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);
        list.addFirst(6);
    }
}
