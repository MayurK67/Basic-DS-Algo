package Lists.LinkedList;

public interface ILinkedList<T> {
    public boolean isListEmpty();
    void addElementAtLast(T data);
    void addElementAtFirst(T data);
    void addElement(T data,int pos);
    void deleteElementAtLast();
    void deleteElementAtFirst();
    void deleteElement(int pos);
    void displayList();
    void reverseList();
}
