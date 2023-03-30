
//               Linked List: is a linear data structure in which elements are stored in nodes, and each node points to
//                            the next node in the list. In a linked list, each node consists of two parts: a data part
//                            that stores the value of the element, and a reference part that points to the next node in the list.

//                            The first node of a linked list is called the head, and the last node is called the tail.
//                            Linked lists can be singly linked (each node only has a reference to the next node),
//                            doubly linked (each node has references to the next and previous nodes), or
//                            circular (the last node points back to the head node).

public class LinkLists {

    Node head;
    private int size;
    LinkLists(){
        this.size = 0;
    }
    class Node{

    String data;
    Node next;

    Node(String data){
        this.data = data;
        this.next = null;
        size++;
    }
}

    public void addFirst(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    public void deleteFirst(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        head = head.next;
        size--;
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        size--;
        if (head.next == null) {
            head = null;
            return;
        }

        Node secondLastNode = null;
        Node lastNode = head;

        while (lastNode.next != null) {
            secondLastNode = lastNode;
            lastNode = lastNode.next;
        }

        secondLastNode.next = null;
    }


    // print the linked list

    public void printLL(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        LinkLists list = new LinkLists();
        list.addFirst("1");
        list.addFirst("2");
        list.addFirst("3");
        list.addLast("5");
        list.addLast("6");
        list.printLL();
        list.deleteFirst();
        list.printLL();
        list.deleteLast();
        list.printLL();
    }
}