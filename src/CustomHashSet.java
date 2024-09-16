import java.util.LinkedList;

public class CustomHashSet<T> {
    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private LinkedList<T>[] buckets; // Array of buckets (linked lists)
    // We'll use separate chaining with linked lists to handle hash collisions
    private int size = 0;


    public CustomHashSet() {
        buckets = new LinkedList[INITIAL_CAPACITY];
    }

    private int getBucketIndex(T key) {
        int hash = key.hashCode();
        return Math.abs(hash) % buckets.length;
    }

    private void resize() {
        LinkedList<T>[] oldBuckets = buckets;
        buckets = new LinkedList[oldBuckets.length * 2];
        size = 0;
        for (LinkedList<T> bucket : oldBuckets) {
            if (bucket != null) {
                for (T key : bucket) {
                    add(key);
                }
            }
        }
    }

    public void add(T key) {
        if (contains(key)) {
            return;
        }
        if (size + 1 > buckets.length * LOAD_FACTOR) {
            resize();
        }
        int index = getBucketIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        buckets[index].add(key);
        size++;
    }

    public boolean contains(T key) {
        int index = getBucketIndex(key);
        LinkedList<T> bucket = buckets[index];
        return bucket != null && bucket.contains(key);
    }

    public boolean remove(T key) {
        int index = getBucketIndex(key);
        LinkedList<T> bucket = buckets[index];
        if (bucket != null && bucket.remove(key)) {
            size--;
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printElements() {
        for (LinkedList<T> bucket : buckets) {
            if (bucket != null) {
                for (T key : bucket) {
                    System.out.print(key + " ");
                }
            }
        }
        System.out.println();
    }
}
