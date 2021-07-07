public class Queue {
    Node first;
    Node last;

    class Node {
        Node next;
        int data;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void peek() {
        if(this.first == null) {
            System.out.println("The queue is empty");
        } else {
            System.out.println(this.first.data);
        }
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if(this.last == null && this.first == null) {
            this.first = newNode;
            this.last = newNode;
        } else {
            this.last.next = newNode;
            this.last = newNode;
        }
    }

    public void printQueue() {
        if(this.first == null && this.last == null) {
            System.out.println("The queue is empty");
        } else {
            Node currNode = this.first;

            while(currNode != null) {
                System.out.print(currNode.data + " ");
                currNode = currNode.next;
            }

            System.out.println();
        }
    }

    public void dequeue() {
        if(this.first == null) {
            System.out.println("The queue is emtpy");
        } else {
            if(this.first == this.last) {
                this.last = null;
            }
            System.out.println(this.first.data + " removed");
            this.first = this.first.next;
        }
    }

    public void isEmpty() {
        if(this.first == null && this.last == null) {
            System.out.println("The queue is empty");
        } else {
            System.out.println("The queue is not empty");
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(20);
        q.peek();
        q.printQueue();
    }
}
