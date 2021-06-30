public class Stack {
    Node top;
    Node bottom;
    
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public void push(int data) {
        Node newNode = new Node(data);
        if(this.top == null && this.bottom == null) {
            this.top = newNode;
            this.bottom = newNode;
        } else {
            this.top.next = newNode;
            this.top = newNode;
        }
    }

    public int pop() {
        if(this.bottom == null) {
            System.out.println("Stack is empty");
        } else {
            int data = this.bottom.data;
            this.bottom = this.bottom.next;
            return data;
        }
        return 0;
    }

    public void peek() {
        if(this.bottom == null) {
            System.out.println("The stack is empty");
        } else { 
            System.out.println("Peek of the stack is : " + this.top.data);
        }
    }

    public void printStack() {
        if(this.top == null) {
            System.out.println("The stack is empty");
        } else {
            Node currNode = this.bottom;
            while(currNode != null) {
                System.out.print(currNode.data + " ");
                currNode = currNode.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        s.printStack();
        s.peek();
        System.out.println("Data poped " + s.pop());
        s.printStack();
        s.peek();
    }
}
