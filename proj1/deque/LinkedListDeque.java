package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private Node sentinel;
    private int size;

    private class Node {
        private Node prev;
        private Node next;
        private T elem;
    }

    public LinkedListDeque() {
        sentinel = new Node();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        sentinel.elem = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addFirst(T item) {
        Node p = new Node();
        p.elem = item;
        p.prev = sentinel;
        p.next = sentinel.next;
        sentinel.next = p;
        size += 1;
    }

    @Override
    public void addLast(T item) {
        Node p = new Node();
        p.elem = item;
        p.next = sentinel;
        p.prev = sentinel.prev;
        sentinel.prev = p;
        size += 1;
    }

    @Override
    public T removeFirst() {
        Node p = sentinel.next;
        sentinel.next = p.next;
        size -= 1;
        return p.elem;
    }

    @Override
    public T removeLast() {
        Node p = sentinel.prev;
        sentinel.prev = p.prev;
        size -= 1;
        return p.elem;
    }

    @Override
    public T get(int index) {
        Node p = sentinel.next;
        while (index > 0 && p != sentinel) {
            p = p.next;
            index--;
        }
        if (index == 0) {
            return p.elem;
        }
        return null;
    }

    public T getRecursive(int index) {
        Node p = sentinel.next;
        if (index != 0 && p == sentinel) {
            return null;
        }
        if (index == 0) {
            return p.elem;
        }
        LinkedListDeque<T> x = new LinkedListDeque();
        x.sentinel.next = p.next;
        return x.getRecursive(index - 1);
    }

    @Override
    public void printDeque() {
        Node p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.elem + " ");
            p = p.next;
        }
        System.out.println();
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node p;

        public LinkedListIterator() {
            p = sentinel.next;
        }

        public boolean hasNext() {
            return p != sentinel;
        }

        public T next() {
            T return_value = p.elem;
            p = p.next;
            return return_value;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof LinkedListDeque other_linked) {
            if (other_linked == this) {
                return true;
            }
            if (other_linked.size() != size) {
                return false;
            }
            int a = this.size();
            while(--a >= 0){
                if(other_linked.get(a) != this.get(a)){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
