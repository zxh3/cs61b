public class LinkedListDeque<T> {

    private static class Node<U> {
        public U item;
        public Node<U> next;
        public Node<U> prev;

        public Node(U item, Node<U> prev, Node<U> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private int size;
    private Node<T> sentinel;

    public LinkedListDeque() {
        sentinel = new Node<T>(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(T item) {
        Node<T> oldFirst = sentinel.next;
        Node<T> newNode = new Node<>(item, sentinel, sentinel.next);
        sentinel.next = newNode;
        oldFirst.prev = newNode;
        size += 1;
    }

    public void addLast(T item) {
        Node<T> oldLast = sentinel.prev;
        Node<T> newNode = new Node<>(item, sentinel.prev, sentinel);
        sentinel.prev = newNode;
        oldLast.next = newNode;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        Node<T> p = sentinel;
        for (int i = 0; i < size; i++) {
            p = p.next;
            System.out.print(p.item + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty())
            return null;
        T first = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return first;
    }

    public T removeLast() {
        if (isEmpty())
            return null;
        T last = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return last;
    }

    public T get(int index) {
        Node<T> p = sentinel.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
    }

    private T getRecursive(Node<T> p, int i) {
        if (i == 0)
            return p.item;
        return getRecursive(p.next, i - 1);
    }

    public T getRecursive(int index) {
        return getRecursive(sentinel.next, index);
    }

    public static void main(String[] args) {
        LinkedListDeque<String> l1 = new LinkedListDeque<>();
        l1.addFirst("hello");
        l1.addLast("world");
        System.out.println(l1.size());
        l1.printDeque();
        l1.removeFirst();
        l1.printDeque();
        l1.removeLast();
        l1.printDeque();
        System.out.println(l1.size());
        l1.addFirst("hello");
        l1.addLast("world");
        System.out.println(l1.get(1));
    }
}
