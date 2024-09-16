import java.util.Arrays;

public class CustomArraylist<T> {
    private Object[] elements; // to store elements
    private int size;      // number of elements
    private static final int DEFAULT_CAPACITY = 10;

    public CustomArraylist() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(T element) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = element;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        validateIndex(index);
        return (T) elements[index];
    }

    public T remove(int index) {
        validateIndex(index);

        @SuppressWarnings("unchecked")
        T removedElement = (T) elements[index];

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        elements[--size] = null; // Clear the last element and reduce the size
        return removedElement;
    }

    public int size() {
        return size;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }

    private void resize() {
        int newCapacity = elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    private void validateIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}
