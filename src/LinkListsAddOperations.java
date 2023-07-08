
//               Linked List: is a linear data structure in which elements are stored in nodes, and each node points to
//                            the next node in the list. In a linked list, each node consists of two parts: a data part
//                            that stores the value of the element, and a reference part that points to the next node in the list.

//                            The first node of a linked list is called the head, and the last node is called the tail.
//                            Linked lists can be singly linked (each node only has a reference to the next node),
//                            doubly linked (each node has references to the next and previous nodes), or
//                            circular (the last node points back to the head node).

public class LinkListsAddOperations {

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

    public void addFirst(int data){   // Time Complexity = O(1)
        // Create New Node
        Node newNode = new Node(data);
        size++;
        if (head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head; // link
        head = newNode; // updating head
    }

    public void addLast(int data) {  // Time Complexity = O(1)
        Node newNode = new Node(data);
        size++;
        if (head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void addMiddle(int data, int index) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        int i = 0;
        Node temp = head;
        while (i < index - 1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public static void print(){
        if (head == null){
            System.out.println("list is empty");
        }
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }
//   public static void Size(){
//        int size = 0;
//        if (head == null){
//            System.out.println("Size of list is: " + size);
//        }
//        Node temp = head;
//        while (temp != null){
//            temp = temp.next;
//            size++;
//        }
//        System.out.println(size);
//    }


    public static void main(String[] args) {

        LinkListsAddOperations list = new LinkListsAddOperations();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addFirst(4);
        list.addMiddle(5, 2);
        print();
        System.out.println(list.size);
    }
}