public class Mystack<T> {
    private MyArrayList<T> stack;

    public Mystack() {
        stack = new MyArrayList<>();
    }

    public void push(T item) {
        stack.addLast(item);
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T top = stack.getLast();
        stack.removeLast();
        return top;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return stack.getLast();
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }

    public int size() {
        return stack.size();
    }

    public void clear() {
        stack.clear();
    }
}