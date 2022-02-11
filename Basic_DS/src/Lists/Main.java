package Lists;

import java.util.Scanner;

import Lists.LinkedList.DoublyCircularLinkedList;
import Lists.LinkedList.DoublyLinkedList;
import Lists.LinkedList.SinglyCircularLinkedList;
import Lists.LinkedList.SinglyLinkedList;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Linked list created..!!");
        // SinglyLinkedList<Integer> sL1 = new SinglyLinkedList<>();
        // SinglyCircularLinkedList<Integer> sL1 = new SinglyCircularLinkedList<>();
        // DoublyLinkedList<Integer> DL1 = new DoublyLinkedList<>();
        DoublyCircularLinkedList<Integer> DL1 = new DoublyCircularLinkedList<>();
        boolean flag = true;
        while (flag) {
            System.out.println("Enter Your Choice: "

                    + " \n2.Add Element to signly linked List"
                    + "\n3.Add element at Head\n4.Add Element at End\n5.Delete Element\n6."
                    + "Display List\n7.Check Size of list\n8.Reverse List\n9.Search and Delete element in List\n0.Exit");
            switch (sc.nextInt()) {
                case 2:
                    System.out.println("Enter Integer value and position at which you want to insert : ");
                    // sL1.addElement(sc.nextInt(), sc.nextInt());
                    DL1.addElement(sc.nextInt(), sc.nextInt());
                    break;
                case 3:
                    System.out.println("Enter Integer value : ");
                    // sL1.addElementAtFirst(sc.nextInt());
                    DL1.addElementAtFirst(sc.nextInt());
                    break;
                case 4:
                    System.out.println("Enter Integer value : ");
                    // sL1.addElementAtLast(sc.nextInt());
                    DL1.addElementAtLast(sc.nextInt());

                    break;
                case 5:
                    System.out.println("Enter Position value to delete : ");
                    // sL1.deleteElement(sc.nextInt());
                    DL1.deleteElement(sc.nextInt());

                    break;
                case 6:
                    // sL1.displayList();
                    DL1.displayList();

                    break;
                case 7:
                    // System.out.println("Size of Linked list is: " + sL1.getNodesCount());
                    System.out.println("Size of Linked list is:  " + DL1.getNodesCount());

                    break;
                case 8:
                    // sL1.reverseList();
                    DL1.reverseList();
                    break;
                case 9:
                    System.out.println("Enter value to be Searched..:");
                    int data = sc.nextInt();
                    // if (sL1.searchAndDelete(data))
                    if (DL1.searchAndDelete(data))
                        System.out.println("Values deleted...!!");
                    else
                        System.out.println("Value not Found..!!");
                    break;
                default:
                    flag = false;
                    break;
            }
            // sc.nextLine();

        }
        sc.close();

    }
}
