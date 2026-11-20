package deque;

import org.junit.Test;
import static org.junit.Assert.*;


public class ArrayDequeTest {
    @Test
    public void addIsEmptySizeFirstTest() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        assertTrue(deque.isEmpty());

        deque.addFirst(2);
        assertEquals(1, deque.size());

        deque.addFirst(3);
        assertEquals(2, deque.size());

        deque.printDeque();
    }

    @Test
    public void addIsEmptySizeLastTest() {
        ArrayDeque<String> q = new ArrayDeque<>();
        assertTrue(q.isEmpty());

        q.addLast("1");
        assertEquals(1, q.size());
        q.addLast("hello");
        assertEquals(2, q.size());
    }

    @Test
    public void mixedAddIsEmptySizeTest(){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        assertTrue(q.isEmpty());

        q.addLast(1);
        q.addFirst(2);
        q.addLast(3);
        assertEquals(3, q.size());
        int a = q.get(1);
        int b = q.get(2);
        assertEquals(1, a);
        assertEquals(3, b);
    }

    @Test
    public void removeIsEmptySizeTest() {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        assertNull(q.removeFirst());
        assertNull(q.removeLast());

        q.addLast(1);
        q.addLast(2);
        q.addFirst(3);
        assertEquals(3, q.size());
        q.removeFirst();
        assertEquals(2, q.size());
        q.removeLast();
        assertEquals(1, q.size());
        int a = q.get(0);
        assertEquals(1, a);
    }

    @Test
    public void longListTest(){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < 100; i++){
            q.addLast(i);
        }
        assertEquals(100, q.size());

        for(int i = 0; i < 100; i++){
            int a = q.removeFirst();
            assertEquals(i, a);
        }
    }
}
