package it.sevenbits.workshop.queue;

import it.sevenbits.workshop.matrix.Matrix;

public class DoubleEndedQueue {

    private Node first;
    private Node last;

    public DoubleEndedQueue() {
        first = null;
        last = null;
    }

    public void addFirst(Matrix matrix) {
        Node currElem = new Node(matrix);
        if (first == null) {
            first = currElem;
            last = first;
        } else {
            Node currFirst = first;
            first = currElem;
            first.next = currFirst;
            first.next.prev = first;
        }
    }

    public void addLast(Matrix matrix) {
        Node currElem = new Node(matrix);
        if (last == null) {
            first = currElem;
            last = first;
        } else {
            Node currLast = last;
            last = currElem;
            currLast.next = last;
            last.prev = currLast;

        }
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    @Override
    public String toString() {
        Node current = first;
        StringBuilder sb = new StringBuilder();
        while (current.next != null) {
            sb.append(current.val);
            sb.append("\n");

            current = current.next;
        }
        sb.append(current.val);
        return sb.toString();
    }
}
