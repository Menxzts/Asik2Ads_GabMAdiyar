import java.util.Iterator;

public class MyLinkedList <T> implements MyList <T> {

    private class Node {
        T data;
        Node next;
        Node prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    private void checkindexvalid(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private Node getNode(int index) {
        checkindexvalid(index);
        return getNode(index, head, 0);
    }

    private Node getNode(int index, Node current, int currentIndex) {
        if (currentIndex == index) {
            return current;
        }
        return getNode(index, current.next, currentIndex + 1);
    }

    @Override
    public void add(T data) {
        addLast(data);
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(item);
            return;
        }
        if (index == size) {
            addLast(item);
            return;
        }
        Node nextNode = getNode(index);
        Node prevNode = nextNode.prev;
        Node newNode = new Node(item);
        newNode.prev = prevNode;
        newNode.next = nextNode;
        prevNode.next = newNode;
        nextNode.prev = newNode;
        size++;
    }

    @Override
    public T getFirst() {
        return head.data;
    }
    @Override
    public T getLast() {
        return tail.data;
    }

    @Override
    public T get(int index) {
        return getNode(index).data;
    }

    public void set(int index, T item) {
        getNode(index).data = item;
    }


    @Override
    public void remove(int index) {
        checkindexvalid(index);
        Node nodetoremove = getNode(index);
        if (nodetoremove == head) {
            removeFirst();
            return;
        }
        if (nodetoremove == tail) {
            removeLast();
            return;
        }
        nodetoremove.prev.next = nodetoremove.next;
        nodetoremove.next.prev = nodetoremove.prev;
        size--;
    }

    @Override
    public void removeFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
    }

    @Override
    public void removeLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        }
        else{
            head = null;
        }
        size--;
    }

    @Override
    public void addFirst(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T data) {
        Node newNode = new Node(data);
        if (head == null){
            head = tail = newNode;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public int indexOf(Object object) {
        return indexrecursive(object, head, 0);
    }
    private int indexrecursive(Object object, Node current, int index) {
        if (current == null) {
            return -1;
        }
        if (current.data.equals(object)) {
            return index;
        }
        return indexrecursive(object, current.next, index + 1);
    }

    @Override
    public int lastIndexOf(Object object) {
        return lastIndexOf(object, tail, -1);
    }

    private int lastIndexOf(Object object, Node current, int index) {
        if (current == null) {
            return index;
        }
        if (current.data.equals(object)) {
            return index;
        }
        return lastIndexOf(object, current.prev, index - 1);
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        toarrayrecursive(array, head, 0);
        return array;
    }

    private void toarrayrecursive(Object[] array, Node current, int index) {
        if (current == null) {
            return;
        }
        array[index] = current.data;
        toarrayrecursive(array, current.next, index + 1);
    }

    @Override
    public void sort() {
        if (size < 2) {
            return;
        }
        bubblesort(head, null);
    }
    private void bubblesort(Node current, Node end) {
        if (current.next == end) {
            if (end != head.next) {
                bubblesort(head, current);
            }
            return;
        }

        Comparable<T> data1 = (Comparable<T>) current.data;
        if (data1.compareTo(current.next.data) > 0) {
            T temp = current.data;
            current.data = current.next.data;
            current.next.data = temp;
        }
        bubblesort(current.next, end);
    }

    @Override
    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }



}
