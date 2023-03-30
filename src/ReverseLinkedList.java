// RECURSIVE METHOD

public class ReverseLinkedList {

    Node head;
    class Node{

        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public Node reverseList(Node head){

        if(head == null || head.next == null){
            return head;
        }

        Node newNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
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
        ReverseLinkedList list = new ReverseLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.printLL();
        list.head = list.reverseList(list.head);
        list.printLL();
    }
}
