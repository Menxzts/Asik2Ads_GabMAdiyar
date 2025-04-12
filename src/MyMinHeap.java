public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap;

    // Конструктор
    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    //Returns whether the heap is empty
    public boolean empty() {
        return heap.size() == 0;
    }

    //Returns the size of the heap
    public int size() {
        return heap.size();
    }

    //Returns a reference to the root element of the heap
    public T getMin() {
        if (empty()) {
            return null;
        }
        return heap.get(0);
    }

    //Retrieves and deletes the root element of the heap
    public T extractMin() {
        if (empty()) {
            return null;
        }
        T min = heap.get(0);
        T last = heap.getLast();
        heap.set(0, last);
        heap.removeLast();
        heapify(0);
        return min;
    }

    //Adds the element to the heap
    public void insert(T item) {
        heap.add(item);
        traverseUp(heap.size() - 1);
    }

    // can perform heapify actions starting from position 'index'
    private void heapify(int index) {
        int leftChild = leftChildOf(index);
        int rightChild = rightChildOf(index);
        int smallest = index;

        if (leftChild < heap.size() && heap.get(leftChild).compareTo(heap.get(smallest)) < 0) {
            smallest = leftChild;
        }

        if (rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(smallest)) < 0) {
            smallest = rightChild;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }
    }

    //can perform traverseUp actions starting from position 'index'
    private void traverseUp(int index) {
        while (index > 0 && heap.get(index).compareTo(heap.get(parentOf(index))) < 0) {
            swap(index, parentOf(index));
            index = parentOf(index);
        }
    }

    //returns the index of the left child item
    private int leftChildOf(int index) {
        return 2 * index + 1;
    }

    // returns the index of the right child item
    private int rightChildOf(int index) {
        return 2 * index + 2;
    }

    //returns the index of the parent item
    private int parentOf(int index) {
        return (index - 1) / 2;
    }

    //exchanges two elements by their positions
    private void swap(int index1, int index2) {
        T temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }
}