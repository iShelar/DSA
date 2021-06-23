public class ListNode {
    Node head;

    class Node {
        int data;
        Node next;
        Node(int d) {
            this.data = d;
            this.next = null;
        }
    }

    public void append(int data) {
        Node node = new Node(data);

        if(this.head == null) {
            this.head = node;
        } else {

            Node currNode = this.head;
            while(currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = node;
        }
    }

    public void insert(int index, int data) {
        if(index == 0) {
            append(data);
        } else {
            Node currNode = this.traverseToIndex(index - 1);
            Node holdingNode = currNode.next;

            Node newNode = new Node(data);

            currNode.next = newNode;
            newNode.next = holdingNode;
        }
    }

    public void remove(int index) {
        if(index == 0) {
            this.head = this.head.next;
        } else {

            Node currNode = this.traverseToIndex(index - 1);   
            currNode.next = currNode.next.next;
        }
    }

    public Node traverseToIndex(int index) {
        int count = 0;
        Node currNode = this.head;
        while(count != index) {
            currNode = currNode.next;
            count++;
        }

        return currNode;
    }

    public void printList() {
        if(this.head == null) {
            System.out.println("Linked list is empty");
        } else {

            Node iteratorNode = this.head;
            while(iteratorNode != null) {
                System.out.print(iteratorNode.data + " ");
                iteratorNode = iteratorNode.next;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws Exception {
        ListNode ln = new ListNode();
        ln.append(10);
        ln.append(20);
        ln.insert(2,5);
        ln.printList();
        ln.remove(2);
        ln.printList();
    }
}
