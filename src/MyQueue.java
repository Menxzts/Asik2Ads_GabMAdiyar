public class MyQueue<T> {
    private MyLinkedList<T> queue;

    //конструктор
    public MyQueue() {
        queue = new MyLinkedList();
    }

    //Returns whether the queue is empty
    public boolean Empty() {
        return queue.size()==0;
    }

    //Adds the element at the end of the queue
    public void enqueue(T item) {
        queue.addLast(item);
    }

    //Retrieves and deletes the front element of the queue
    public T dequeue() {
        if (Empty()) {
            return null;
        }
        T item = queue.getFirst();
        queue.removeFirst();
        return item;
    }

    //Returns a reference to the front element of the queue
    public T peek() {
        if (Empty()) {
            return null;
        }
        return queue.getFirst();
    }

    //Returns size
    public int size() {
        return queue.size();
    }

    public void clear() {
        queue.clear();
    }
}
