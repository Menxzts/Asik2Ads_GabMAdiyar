public class Mystack<T> {
    private MyArrayList<T> stack;

    //Конструктор
    public Mystack() {
        stack = new MyArrayList<>();
    }

    //Adds the element at the top of the stack
    public void push(T item) {
        stack.addLast(item);
    }

    //Retrieves and deletes the topmost element of the stack
    public T pop() {
        if (Empty()) {
            return null;
        }
        T top = stack.getLast();
        stack.removeLast();
        return top;
    }

    //Returns a reference to the topmost element of the stack
    public T peek() {
        if (Empty()) {
            return null;
        }
        return stack.getLast();
    }

    //Returns whether the stack is empty
    public boolean Empty() {
        return stack.size() == 0;
    }

    //Returns the size of the stack
    public int size() {
        return stack.size();
    }

    public void clear() {
        stack.clear();
    }
}