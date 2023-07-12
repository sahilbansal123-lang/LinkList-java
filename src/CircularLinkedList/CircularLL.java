package CircularLinkedList;

public class CircularLL {

    public class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public Node head;
    public Node tail;

    public void addFirst(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.next = head;
        tail = newNode;
    }

    public void delete(int data){
        Node node = head; // Initialize a variable 'node' with the 'head' of the data structure.

        if (head == null){ // If the data structure is empty (head is null), there is nothing to delete.
            return;
        }

        if (node.data == data){ // If the 'head' node contains the data to be deleted.
            head = head.next; // Update the 'head' to the next node.
            tail.next = head; // Update the 'next' reference of 'tail' to the new 'head'.
            return; // Exit the method after the deletion.
        }

        // Traverse the data structure to find the node with the given data.
        while(node != null){
            Node n = node.next; // Get the next node.
            if (n.data == data){ // If the next node contains the data to be deleted.
                node.next = n.next; // Update the 'next' reference of the current node to skip the next node.
                break; // Exit the loop after the deletion.
            }
            node = node.next; // Move to the next node in the data structure.
        }
    }


    public void print(){
        Node node = head;
        if (head != null){
            do {
                System.out.print(node.data + "->");
                node = node.next;
            } while (node != head);
        }
        System.out.println("Head");
    }


    public static void main(String[] args) {
        CircularLL list = new CircularLL();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);
        list.print();
        list.delete(5);
        list.print();
    }
}
