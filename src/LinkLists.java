
//               Linked List: is a linear data structure in which elements are stored in nodes, and each node points to
//                            the next node in the list. In a linked list, each node consists of two parts: a data part
//                            that stores the value of the element, and a reference part that points to the next node in the list.

//                            The first node of a linked list is called the head, and the last node is called the tail.
//                            Linked lists can be singly linked (each node only has a reference to the next node),
//                            doubly linked (each node has references to the next and previous nodes), or
//                            circular (the last node points back to the head node).

public class LinkLists {

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

    public void addFirst(int data){   // Time Complexity = O(1)
        // Create New Node
        Node newNode = new Node(data);
        if (head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head; // link
        head = newNode; // updating head
    }

    public void addLast(int data) {  // Time Complexity = O(1)
        Node newNode = new Node(data);
        if (head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
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


    public static void main(String[] args) {

        LinkLists list = new LinkLists();
//        list.addFirst(1);
//        list.addFirst(2);
//        print();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addFirst(4);
        print();
//        list.head.next = new Node(2);
//        list.addFirst("1");
//        list.addFirst("2");
//        list.addFirst("3");
//        list.addLast("5");
//        list.addLast("6");
//        list.printLL();
//        list.deleteFirst();
//        list.printLL();
//        list.deleteLast();
//        list.printLL();
    }
}