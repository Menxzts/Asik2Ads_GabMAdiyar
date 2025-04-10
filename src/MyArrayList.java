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
        if (size == 0) return;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                Comparable<T> current = (Comparable<T>) array[j];
                T next = (T) array[j + 1];
                if (current.compareTo(next) > 0) {
                    T temp = (T) array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }


    @Override
    public int index0f(Object object){
        for (int i = 0; i < size; i++) {
            if (object.equals(array[i])) return i ;
        }
        return -1;
    }

    @Override
    public int lastIndex0f(Object object){
        for (int i=size-1; i>=0;i--){
            if (object.equals(array[i])) return i;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object){
        for (int i=0; i<size;i++){
            if (object.equals(array[i])) return true;
        }
        return false;
    }

    @Override
    public Object[] toArray(){
        Object[] ExactArray = new Object[size];
        for (int i=0;i<size;i++){
            ExactArray[i] = array[i];
        }
        return ExactArray;
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
