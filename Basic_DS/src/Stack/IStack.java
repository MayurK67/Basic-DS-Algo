package Stack;

public interface IStack<T> {
    void push(T data);
    T pop();
    T peek();
     boolean isStackEmpty();
     }
