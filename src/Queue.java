public class Queue<T> {
    private Node last, first;

    private class Node {
        T item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(T item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;  // if isEmpty returns true, first should = last
        } else {
            oldLast.next = last;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            return null; // error catch for when queue is empty -> NullPointerException
        }

        T item = first.item;
        first = first.next;

        // System.out.println(item); //<- was just checking queue
        return item;
    }
}


