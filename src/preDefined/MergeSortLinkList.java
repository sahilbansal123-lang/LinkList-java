package preDefined;
import LinkListJava.LinkLists;
import java.util.LinkedList;

import static LinkListJava.LinkLists.head;

public class MergeSortLinkList {


    private static LinkLists.Node merge(LinkLists.Node head1, LinkLists.Node head2) {
        LinkLists.Node mergell = new LinkLists.Node(-1);
        LinkLists.Node temp = mergell;

        while (head1 != null && head2 != null){
            if (head1.data < head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while (head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergell.next;
    }

    private static LinkLists.Node getMid(LinkLists.Node head) {
        LinkLists.Node slow = head;
        LinkLists.Node fast = head.next;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static LinkLists.Node mergeSort(LinkLists.Node head){

        if (head == null || head.next == null){
            return head;
        }
        // Find mid
        LinkLists.Node mid = getMid(head);

        // Left & Right MergeSort
        LinkLists.Node rightHead = mid.next;
        mid.next = null;
        LinkLists.Node newLeft = mergeSort(head);
        LinkLists.Node newRight = mergeSort(rightHead);
        // merge
        return merge(newLeft, newRight);
    }


    public static void main(String[] args) {
//        LinkedList<Integer> list = new LinkedList<>();
        LinkLists list = new LinkLists();
        list.addFirst(2);
        list.addFirst(5);
        list.addFirst(3);
        list.addFirst(6);
        list.addFirst(1);
        list.print();
        list.head = mergeSort(list.head);
        list.print();
    }
}
