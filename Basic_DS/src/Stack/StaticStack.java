package Stack;

import java.util.ArrayList;
import java.util.List;

public class StaticStack<T> implements IStack<T> {

    List<T> arr;
    int top;
    int size;

    public StaticStack() {
        this.arr = new ArrayList<>();
        this.top = -1;
        this.size = 5;

    }

    public StaticStack(int size) {
        this.arr = new ArrayList<>();
        this.top = -1;
        this.size = size;

    }

    public boolean isStackEmpty() {
        return (top==-1);
    }

    public boolean isStackFull() {
        return (top == (size - 1));
    }

    @Override
    public void push(T data) {
        if (isStackFull()) {
            System.out.println("Stack is Full");

        } else if (isStackEmpty()) {
            top = 0;
            arr.add(top, data);

        } else {
            top++;
            arr.add(top, data);
        }

    }

    @Override
    public T pop() {
        if (isStackEmpty()) {
            System.out.println("Stack is Empty..!");
            return null;
        } else {

            return (arr.get(top--));

        }
    }

    @Override
    public T peek() {
        if (isStackEmpty()) {
            System.out.println("Stack is Empty..!");
            return null;
        } else {

            return (arr.get(top));

        }
    }

}
