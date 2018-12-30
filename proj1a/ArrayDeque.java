public class ArrayDeque<T> {

    private static final int RFactor = 2; // resizing factor
    private static final double R = 0.25;    // usage ratio
    private static final int initialCapacity = 8;

    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[initialCapacity];
        size = 0;
        nextFirst = initialCapacity - 1;
        nextLast = 0;
    }

    public int size() {
        return size;
    }

    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        int j = (nextFirst + 1) % items.length;
        for (int i = 0; i < size; i++) {
            newItems[i] = items[j];
            j = (j + 1) % items.length;
        }
        nextFirst = capacity - 1;
        nextLast = size;
        items = newItems;
    }

    public void addFirst(T item) {
        if (size == items.length)
            resize(size * RFactor);

        items[nextFirst] = item;
        nextFirst -= 1;
        if (nextFirst == -1)
            nextFirst = items.length - 1;
        size += 1;
    }

    public void addLast(T item) {
        if (size == items.length)
            resize(size * RFactor);

        items[nextLast] = item;
        nextLast += 1;
        if (nextLast == items.length)
            nextLast = 0;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        for (int i = nextFirst + 1; i != nextLast; i = (i + 1) % items.length)
            System.out.println(items[i] + " ");
        System.out.println();
    }

    public T get(int index) {
        return items[(nextFirst + 1 + index) % items.length];
    }

    public T removeFirst() {
        if (items.length > initialCapacity && (double) (size - 1) / items.length < R)
            resize(items.length / 2);
        size -= 1;

        int firstIndex = (nextFirst + 1) % items.length;
        T first = items[firstIndex];
        items[firstIndex] = null;
        nextFirst = firstIndex;
        return first;
    }

    public T removeLast() {
        if (items.length > initialCapacity && (double) (size - 1) / items.length < R)
            resize(items.length / 2);
        size -= 1;

        int lastIndex = nextLast - 1;
        if (lastIndex == -1)
            lastIndex = items.length - 1;
        T last = items[lastIndex];
        items[lastIndex] = null;
        nextLast = lastIndex;
        return last;
    }

    public static void main(String[] args) {
        ArrayDeque<String> l1 = new ArrayDeque<>();
        l1.addFirst("hello");
        l1.addLast("world");
        l1.addFirst("a");
        l1.addFirst("b");
        l1.addFirst("c");
        l1.addFirst("d");
        l1.addFirst("e");
        l1.addFirst("f");
        l1.addFirst("g");

        System.out.println(l1.removeLast());
        System.out.println(l1.removeFirst());
        System.out.println(l1.removeLast());
        System.out.println(l1.removeFirst());
        System.out.println(l1.removeFirst());
        System.out.println(l1.removeLast());
    }
}