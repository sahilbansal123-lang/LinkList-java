import LinkListJava.LinkLists;

public class DoubleLL {

    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int  size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null){
            head = tail = newNode ;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null){
            head = tail = newNode ;
            return;
        }
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
        newNode.next = null;
        size++;
    }

    public void addmid(int data, int idx) {
        Node newNode = new Node(data);
        size++;
        if (head == null){
            head = tail = newNode ;
            return;
        }
        Node temp = head;
        int i = 0;
        while (i < idx-1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        newNode.prev = temp;

    }
    public int removeFirst() {
        if (size == 0){
            System.out.println("list is empty");
            return Integer.MAX_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    public void reverseDLL(){
//        if (size == 0){
//            System.out.println("list is empty");
//        }
        Node previous = null;
        Node curr = head;
        Node nxt;
        while (curr != null){
            nxt = curr.next;
            curr.next = previous;
            curr.prev = nxt;
            previous = curr;
            curr = nxt;
        }
        head = previous;
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

    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();
        dll.addLast(1);
        dll.addLast(2);
        dll.addLast(3);
        dll.addLast(4);
        dll.addLast(5);
        dll.addFirst(0);
        dll.addmid(7, 3);
        dll.print();
        System.out.println(dll.size);
        dll.removeFirst();
        dll.print();
        System.out.println(dll.size);
        dll.reverseDLL();
        dll.print();
    }
}
