public class LinkedLIstQues {

    Node head;
    static class Node {
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


//    Q3: detecting the cycle in the linked list
//        we can solve it by using Floyd Warshall algorithm

    public boolean hasCycle(Node head){
        if (head == null){
            return false;
        }
        Node hare = head;
        Node turtle = head;
        while(hare != null && hare.next != null){
            hare = hare.next.next;
            turtle = turtle.next;
            if(hare == turtle){
                return true;
            }
        }
        return true;
    }

    public Node intersectionOf2LL(Node head1, Node head2){
        while(head2 != null){
            Node temp = head1;
            while (temp != null){
                if (temp == head2){
                    return head2;
                }
                temp = temp.next;
            }
            head2 = head2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedLIstQues ll = new LinkedLIstQues();
//        ll.addFirst(1);
//        ll.addFirst(2);
//        ll.addFirst(2);
//        ll.addFirst(1);
//        ll.printLL();
////        ll.RemoveFromLast(ll.head, 2);
//        ll.printLL();
//        System.out.println(ll.isPalindrome(ll.head));

        Node head1, head2;
        head1 = new Node(10);

        head2 = new Node(3);
        head2.next = new Node(1);
        head2.next.next = new Node(2);

        head1.next = new Node(4);
        head1.next.next = new Node(5);
        Node newNode = new Node(15);
        head1.next.next.next = newNode;
        head2.next.next.next = newNode;

        head1.next.next.next.next = new Node(20);
        head1.next.next.next.next.next = null;

        Node intersectionPoint = ll.intersectionOf2LL(head1, head2);
        System.out.println(intersectionPoint.data);
//        head2.next = new Node(1);
    }
}
