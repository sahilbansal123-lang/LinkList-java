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
    public void zigzagList(LinkLists.Node head) {

        // Calculate MID
        LinkLists.Node mid = getMid(head);

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
            right.next = left;

            right = nextR;
            left = nextL;
        }
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
