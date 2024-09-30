public class Stack<T> {
    private Node first = null;

    private class Node {
        T item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public T pop() {
        if (isEmpty()) {
            return null; // error catch for when queue is empty -> NullPointerException
        }
        T item = first.item; // assign var to popped item, for returning purposes
        first = first.next;
        return item;
    }
}
