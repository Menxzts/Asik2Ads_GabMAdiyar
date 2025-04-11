import java.util.Iterator;
public class MyArrayList <T> implements MyList <T> {
    private Object[] array;
    private int size;

    public MyArrayList() {
        array = new Object[10];
        size = 0;
    }

    private void grow(){
        Object[] newArray = new Object[array.length*2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    @Override
    public void add(T item) {
        if(size == array.length){grow();}
        array[size++] = item;
    }
    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {return;}
        if(size == array.length){grow();}
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = item;
        size++;
    }

    @Override
    public void set(int index, T item) {
        if (index < 0 || index >= size) return;
        array[index] = item;
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(size, item);
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) return null;
        return (T) array[index];
    }

    @Override
    public T getFirst() {
        if (size == 0) return null;
        return (T) array[0];
    }

    @Override
    public T getLast() {
        if (size == 0) return null;
        return (T) array[size - 1];
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) return;
        array[index] = null;
    }
    @Override
    public void removeFirst(){
        if (size == 0) return;
        size--;
        array[0] = null;
    }

    @Override
    public void removeLast(){
        if (size == 0) return;
        size--;
        array[size - 1] = null;
    }

    @Override
    public void sort() {
        if (size < 2) return;
        bubblesort(size);
    }

    private void bubblesort(int n) {
        if (n == 1) return;
        bubblego(0, n);
        bubblesort(n - 1);
    }

    private void bubblego(int j, int n) {
        if (j >= n - 1) return;
        Comparable<T> current = (Comparable<T>) array[j];
        T next = (T) array[j + 1];
        if (current.compareTo(next) > 0) {
            T temp = (T) array[j];
            array[j] = array[j + 1];
            array[j + 1] = temp;
        }
        bubblego(j + 1, n);
    }

    @Override
    public int indexOf(Object object) {
        return indexOfRecursive(object, 0);
    }

    private int indexOfRecursive(Object object, int index) {
        if (index >= size) return -1;
        if (object.equals(array[index])) return index;
        return indexOfRecursive(object, index + 1);
    }

    @Override
    public int lastIndexOf(Object object) {
        return lastIndexOfRecursive(object, size - 1);
    }

    private int lastIndexOfRecursive(Object object, int index) {
        if (index < 0) return -1;
        if (object.equals(array[index])) return index;
        return lastIndexOfRecursive(object, index - 1);
    }

    @Override
    public boolean exists(Object object) {
        return existsRecursive(object, 0);
    }

    private boolean existsRecursive(Object object, int index) {
        if (index >= size) return false;
        if (object.equals(array[index])) return true;
        return existsRecursive(object, index + 1);
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        fillArrayRecursive(result, 0);
        return result;
    }

    private void fillArrayRecursive(Object[] result, int index) {
        if (index >= size) return;
        result[index] = array[index];
        fillArrayRecursive(result, index + 1);
    }
    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int current = 0;

            @Override
            public boolean hasNext() {
                return current < size;
            }

            @Override
            public T next() {
                return (T) array[current++];
            }
        };
    }

}
