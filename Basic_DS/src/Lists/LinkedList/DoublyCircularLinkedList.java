package Lists.LinkedList;

import java.util.Scanner;

public class DoublyCircularLinkedList<T> implements ILinkedList<T> {
    Scanner sc;

    static class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

    }

    private Node<T> head;
    private int nodesCount;

    public DoublyCircularLinkedList() {
        sc = new Scanner(System.in);
        head = null;
        nodesCount = 0;
    }

    @Override
    public boolean isListEmpty() {
        return (head == null);
    }

    public int getNodesCount() {
        return nodesCount;
    }

    @Override
    public void addElementAtLast(T data) {
        Node<T> newNode = new Node<T>(data);
        if (isListEmpty()) {
            head = newNode;
            newNode.next = head;
            head.prev = newNode;
            nodesCount++;
        } else {
            Node<T> trav = head.prev; //No need to traverse list 
            trav.next = newNode;
            newNode.prev = trav;
            newNode.next = head;
            head.prev = newNode;
            nodesCount++;

        }

    }

    @Override
    public void addElementAtFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (isListEmpty()) {
            head = newNode;
            newNode.next = head;
            head.prev = newNode;
            nodesCount++;
        } else {
            newNode.next = head;
            Node<T> trav = head.prev;// first save the head.prev node and then change the head.prev 
            head.prev = newNode;
            trav.next = newNode;
            newNode.prev = trav;
            head = newNode;
            nodesCount++;

        }

    }

    @Override
    public void addElement(T data, int pos) {
        if (pos == 1) {
            addElementAtFirst(data);
        } else if (pos == getNodesCount() + 1) {
            addElementAtLast(data);
        } else {
            Node<T> newNode = new Node<T>(data);
            Node<T> trav = head;
            int i = 1;
            while (i < pos - 1) {
                trav = trav.next;
                i++;
            }
            newNode.next = trav.next;
            trav.next.prev = newNode;// change the prev of node next to deleted node 
            newNode.prev = trav; 
            trav.next = newNode;
            nodesCount++;
        }

    }

    @Override
    public void deleteElementAtLast() {
        if (isListEmpty()) {
            System.out.println("List is Empty...!!");
        } else {
            Node<T> trav = head.prev;
            trav.prev.next = head;
            head.prev = trav.prev;
            nodesCount--;

        }
    }

    @Override
    public void deleteElementAtFirst() {
        if (isListEmpty()) {
            System.out.println("List is Empty...!!");
        } else {
            head = head.next;
            Node<T> trav = head.prev;
            trav.next = head;
            head.prev = trav;
            nodesCount--;
        }

    }

    @Override
    public void deleteElement(int pos) {
        while (true) {

            if (pos < 1 && pos > getNodesCount()) {
                System.out.println("Enter Valid Position: ");
                pos = sc.nextInt();
            } else
                break;
        }
        if (!isListEmpty()) {

            if (pos == 1) {
                deleteElementAtFirst();

            } else if (pos == getNodesCount()) {
                deleteElementAtLast();

            } else {
                Node<T> trav = head;
                int i = 1;
                while (i < pos - 1) {
                    trav = trav.next;
                    i++;
                }
                trav.next = trav.next.next;
                trav.next.prev = trav;
                nodesCount--;
            }

        }
    }

    @Override
    public void displayList() {
        Node<T> trav = head;
        System.out.println("List in Forward direction is: ");
        if (isListEmpty()) {
            System.out.println("List is Empty...!!");
        } else {
            int i = 1;
            // Node<T> trav = head;
            System.out.print("Head->" + head.data + ", ");
            while (i < getNodesCount()) {
                System.out.print(trav.next.data + ", ");
                trav = trav.next;
                i++;
            }
        }
        System.out.println();

        System.out.println("List in Reverse direction is: ");

        int i2 = 1;
        while (i2 < getNodesCount()) {
            System.out.print(trav.data + ", ");
            trav = trav.prev;
            i2++;
        }
        System.out.print(head.data + " <<-Head");
        System.out.println();

    }

    @Override
    public void reverseList() {
        if (!isListEmpty()) {
            Node<T> t1 = head;
            // Node<T> t4 = head;
            Node<T> t2 = t1.next;

            while (t2 != head) {
                Node<T> t3 = t2.next;// store t2.next temporarily in t3
                t2.next = t1; // change next of t2 to t1 ...earlier t2 is ahead of t1.
                t1.prev = t2; // change prev of t1 to t2;
                t1 = t2;
                t2 = t3;
            }
            t1.prev = head;
            head.next = t1;
            head = t1;

        }
    }

    @Override
    public boolean searchAndDelete(T data) {

        if (!isListEmpty()) {
            Node<T> trav = head;
            if (trav.data.equals(data)) {
                head = trav.next;
                head.prev = head;
                nodesCount--;
                return true;
            }
            while (trav.next != head) {
                if (trav.next.data.equals(data)) {
                    break;
                }
                trav = trav.next;
            }
            if (trav.next == head && trav.data != data)
                return false;
            trav.next = trav.next.next;
            trav.next.prev = trav;
            nodesCount--;
            return true;
        }

        return false;
    }

}
