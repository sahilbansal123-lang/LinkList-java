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

//    Q1: remove element from the last
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

//    Q2: Check whether the linked list is Palindrome or not
    private Node calcMiddle(Node head) {

        Node hare = head;
        Node turtle = head;
        while(hare.next != null && hare.next.next != null){
            hare = hare.next.next;
            turtle = turtle.next;
        }
        return turtle;
    }

    private Node reverseScnd(Node head) {
        Node prev = null;
        Node curr = head;
        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public boolean isPalindrome(Node node){
        if(head == null || head.next == null){
            return true;
        }

        Node middle = calcMiddle(head);
        Node secondHalfStrt = reverseScnd(middle.next);

        Node firstHalfStart = head;
        while(secondHalfStrt != null){
            if(firstHalfStart.data != secondHalfStrt.data){
                return false;
            }
            firstHalfStart = firstHalfStart.next;
            secondHalfStrt = secondHalfStrt.next;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedLIstQues ll = new LinkedLIstQues();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.printLL();
//        ll.RemoveFromLast(ll.head, 2);
        ll.printLL();
        System.out.println(ll.isPalindrome(ll.head));
    }
}
