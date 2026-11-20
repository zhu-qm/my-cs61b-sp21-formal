package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private int length;
    private int size;
    private T[] array;
    private int first;
    private int last;

    public ArrayDeque() {
        array = (T[]) new Object[8];
        size = 8;
        length = 0;
        first = 0;
        last = 0;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public void addFirst(T item) {
        if (length == size) {
            resize(2*size);
        }
        if (isEmpty()) {
            array[first] = item;
        } else {
            if (first == 0) {
                array[size - 1] = item;
                first = size - 1;
            } else {
                array[first - 1] = item;
                first -= 1;
            }
        }
        length += 1;
    }

    @Override
    public void addLast(T item) {
        if (length == size) {
            resize(2*size);
        }
        if(isEmpty()) {
            array[last] = item;
        } else {
            if (last == size - 1) {
                array[0] = item;
                last = 0;
            } else {
                array[last + 1] = item;
                last += 1;
            }
        }
        length += 1;
    }

    @Override
    public T removeFirst() {
        if(isEmpty()) {
            return null;
        }
        T temp = array[first];
        if(first == size - 1){
            first = 0;
        }else{
            first -= 1;
        }
        length -= 1;
        if(4 * length < size){
            resize(size / 2);
        }
        return temp;
    }

    @Override
    public T removeLast(){
        if(isEmpty()) {
            return null;
        }
        T temp = array[last];
        if(last ==0){
            last = size - 1;
        }else{
            last -= 1;
        }
        length -= 1;
        if(4 * length < size){
            resize(size / 2);
        }
        return temp;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= length) {
            return null;
        }
        int position = (first + index) % size;
        return array[position];
    }

    @Override
    public void printDeque() {
        if(first <= last) {
            for(int i = first; i <= last; i++){
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }else{
            for(int i = first; i < size; i++){
                System.out.print(array[i] + " ");
            }
            for(int i = 0; i <= last; i++){
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }

    private void resize(int newSize) {
        T[] newArray = (T[]) new Object[newSize];
        if(first <= last) {
            for(int i = first, j = 0; i <= last; i++, j++) {
                newArray[j] = array[i];
            }
        }else{
            int j = 0;
            for(int i = first; i < size; i++, j++){
                newArray[j] = array[i];
            }
            for(int i = 0; i <= last; i++, j++){
                newArray[j] = array[i];
            }
        }
        array = newArray;
    }
}
