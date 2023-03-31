public class LinkedLIstQues {

    Node head;
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
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

        public Node RemoveFromLast(Node node, int n){
            if(head.next == null){
                return null;
            }
            // Calculates size
            int size = 0;
            Node curr = head;
            while(curr != null){
                curr = curr.next;
                size++;
            }
            if(n == size){
                return head.next;
            }

            int indexToFind = size-n;
            int i = 1;
            Node prev = head;
            while(i != indexToFind){
                prev = prev.next;
                i++;

            }
            prev.next = prev.next.next;
            return head;
        }

    public static void main(String[] args) {
        LinkedLIstQues ll = new LinkedLIstQues();
        ll.addFirst(0);
        ll.addFirst(9);
        ll.addFirst(7);
        ll.addFirst(4);
        ll.printLL();
        ll.RemoveFromLast(ll.head, 2);
        ll.printLL();
    }
}
