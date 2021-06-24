public class DoublyLinkedList {
    Node head = null, tail = null;
    int length = 0;

    class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    public void append(int data) {
        Node newNode = new Node(data);

        if(this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            Node currNode = this.head;

            while(currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = newNode;
            newNode.prev = currNode;
            this.tail = newNode;
        }
        this.length++;
    }

    public void insert(int index, int data) {
        Node newNode = new Node(data);
        if(index == 0) {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        } else if(index == this.length - 1) {
            this.append(data);
        } else {
            Node leader = this.traverseToIndex(index - 1);
            Node follower = leader.next;

            leader.next = newNode;
            newNode.prev = leader;
            newNode.next = follower;
            follower.prev = newNode;
        }
    }

    public void remove(int index) {
        if(index == 0) {
            this.head = this.head.next;
            this.head.prev = null;
        } else {
            Node leader = this.traverseToIndex(index - 1);
            leader.next = leader.next.next;
            leader.next.prev = leader;
        }

    }

    public Node traverseToIndex(int index) {
        Node currNode = this.head;
        int count = 0;
        while(count != index) {
            currNode = currNode.next;
            count++;
        }

        return currNode;
    }

    public void printList() {
        if(this. head == null) {
            System.out.println("Linked list is empty");
        } else {
            Node currNode = this.head;
            while(currNode != null) {
                System.out.print(currNode.data + " ");
                currNode = currNode.next;
            }
            System.out.println();
        }
    }

    public void reversePrintList() {
        if(this.tail == null) {
            System.out.println("The Linked list is empty");
        } else {
            Node last = this.tail;
            while(last != null) {
                System.out.print(last.data + " ");
                last = last.prev;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);
        list.insert(3, 25);
        list.printList();
        list.reversePrintList();
    }
}
