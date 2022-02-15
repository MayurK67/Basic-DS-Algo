package Stack;

import java.util.LinkedList;
import java.util.List;

public class DynamicStack<T> implements IStack<T> {

    private List<T> list;
    private int top;
    
   

    public DynamicStack() {
        this.list = new LinkedList<>();
        top = -1;
    }
  
    @Override
    public void push(T data) {
        
            list.add(++top, data);
                
    }

    @Override
    public T pop() {
        
        return list.remove(top--);
    }

    @Override
    public T peek() {
        
        return list.get(top);
    }

    @Override
    public boolean isStackEmpty() {
       
        return (top == -1);
    }

  
    
}
