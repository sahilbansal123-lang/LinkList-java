package LinkListJava;
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
        public Node next;

        public Node(int data){
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

    public void print(){
        if (head == null){
            System.out.println("list is empty");
        }
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }


    public int deleteFirst() {
        if (size == 0) {
            System.out.println("List is empty");
            return Integer.MAX_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }
    public int deleteLast() {
        if (size == 0) {
            System.out.println("List is empty");
            return Integer.MAX_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node temp = head;
        for (int i = 0; i < size - 2; i++) {
            temp = temp.next;
        }
        int val = tail.data;
        temp.next = null;
        tail = temp;
        size--;
        return val;
    }

    public void searchIteratively(int key) {
        Node temp = head;
        int pos = 0;
        while (temp != null){
            if (temp.data == key){
                System.out.println("Key found at position: " + pos);
                return;
            }
            temp = temp.next;
            pos++;
        }
        System.out.println("key not found");
    }


    public int helper(Node head, int key) {
        if (head == null){
            return -1;
        }
        if (head.data == key){
            return 0;
        }

        int idx = helper(head.next, key);
        if (idx == -1){
            return -1;
        }
        return idx+1;
    }
    public int searchRecursively(int key) {
        return helper(head, key);
    }

    public void reversingList(){
        Node prev = null;
        Node curr = tail = head;
        Node Next;
        while (curr != null){
            Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }
        head = prev;
    }

    public void deleteFromEnd(int n){
        int i = 1;
        Node prev = head;
        if (size == n){
            head = head.next;
            return;
        }
        while (i < size - n){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    public Node midNode(Node head){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Boolean checkPalindrome(){

        // find mid
        Node mid = midNode(head);

        // reverse second half
        Node prev = null;
        Node curr = mid;
        Node Next;

        while (curr != null) {
            Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }
        // check for same
        Node left = head;
        Node right = prev;

        while (right != null){
            if (left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }



        public static void main(String[] args) {

        LinkLists list = new LinkLists();
        list.addLast(1);
        list.addLast(2);
        list.addLast(2);
//        list.addFirst(4);
        list.addLast(1);
//        list.addLast(7);
//        list.addMiddle(8,5);
        list.print();
//        list.searchIteratively(8);
//        System.out.println(list.searchRecursively(8));
//        System.out.println(list.searchRecursively(10));
//        System.out.println(list.size);
//        list.reversingList();
//        list.deleteFromEnd(3);
//        print();

        System.out.println(list.checkPalindrome());
    }
}