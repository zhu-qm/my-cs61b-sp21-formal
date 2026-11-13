package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import timingtest.AList;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> a = new AListNoResizing<>();
        BuggyAList<Integer> b = new BuggyAList<>();
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);

        b.addLast(1);
        b.addLast(2);
        b.addLast(3);

        assertEquals(a.size(), b.size());
        assertEquals(a.removeLast(), b.removeLast());
        assertEquals(a.removeLast(), b.removeLast());
        assertEquals(a.removeLast(), b.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> b = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                b.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int bsize = b.size();
                assertEquals(bsize, L.size());
                System.out.println("size: " + size);
            } else if (operationNumber == 2) {
                if(L.size() > 0) {
                    int last = L.getLast();
                    int blast = b.getLast();
                    assertEquals(last, blast);
                    System.out.println("getLast(" + blast + ")");
                }
            }else if (operationNumber == 3) {
                if(L.size() > 0) {
                    int last = L.removeLast();
                    int blast = b.removeLast();
                    assertEquals(last, blast);
                    assertEquals(L.size(), b.size());
                    System.out.println("removeLast(" + blast + ")");
                }
            }
        }
    }
}
