package Lists.LinkedList;

import java.util.Scanner;

public class SinglyLinkedList<T> implements ILinkedList<T> {
    Scanner sc;

    static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

    }

    private Node<T> head;
    private int nodesCount;

    public SinglyLinkedList() {
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
            nodesCount++;
        } else {
            Node<T> trav = head;

            while (trav.next != null) {
                trav = trav.next;
            }
            trav.next = newNode;
            nodesCount++;

        }

    }

    @Override
    public void addElementAtFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (isListEmpty()) {
            head = newNode;
            nodesCount++;
        } else {
            newNode.next = head;
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
            trav.next = newNode;
            nodesCount++;
        }

    }

    @Override
    public void deleteElementAtLast() {
        if (isListEmpty()) {
            System.out.println("List is Empty...!!");
        } else {
            Node<T> trav = head;

            while (trav.next.next != null) {
                trav = trav.next;

            }
            trav.next = null;
            nodesCount--;

        }
    }

    @Override
    public void deleteElementAtFirst() {
        if (isListEmpty()) {
            System.out.println("List is Empty...!!");
        } else {
            head = head.next;
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
                nodesCount--;
            }

        }
    }

    @Override
    public void displayList() {
        if (isListEmpty()) {
            System.out.println("List is Empty...!!");
        } else {
            int i = 1;
            Node<T> trav = head;
            System.out.print("Head->" + head.data + ", ");
            while (i < getNodesCount()) {
                System.out.print(trav.next.data + ", ");
                trav = trav.next;
                i++;
            }
        }
        System.out.println();
    }

    @Override
    public void reverseList() {
        if (!isListEmpty()) {
            Node<T> t1 = head;
            Node<T> t2 = t1.next;
            t1.next = null;
            while (t2 != null) {
                Node<T> t3 = t2.next;
                t2.next = t1;
                t1 = t2;
                t2 = t3;

            }
            head = t1;
        }
    }

    public boolean searchAndDelete(T data) {
        
        if(!isListEmpty()){
            Node<T> trav = head;
            if(trav.data.equals(data))
                {
                    head = trav.next;
                    nodesCount--;
                    return true;
                }
            while(trav.next!=null){
                if(trav.next.data.equals(data) ){
                    break;
                }
                trav = trav.next;
            }
            if(trav.next==null && trav.data!=data)
                return false;
            trav.next = trav.next.next;
            nodesCount--;
            return true;
        }

        return false;
    }


}
