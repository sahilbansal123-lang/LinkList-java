public class LinkListDeleteOperations extends LinkListsAddOperations {

    public static class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public int deleteFirst() {
        int val = head.data;
        head = head.next;
//        size--;
        return val;
    }

    public static void main(String[] args) {
        LinkListsAddOperations list = new LinkListsAddOperations();
        LinkListDeleteOperations lists = new LinkListDeleteOperations();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);
        print();
        list.deleteFirst();
        print();
    }
}
