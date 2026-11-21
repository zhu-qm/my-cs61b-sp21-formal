package deque;

import java.util.Collections;
import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T>{

    private Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> c) {
        super();
        comparator = c;
    }

    public T max() {
        return getMax(comparator);
    }

    public T max(Comparator<T> c) {
        return getMax(c);
    }

    private T getMax(Comparator<T> c) {
        if (isEmpty()) return null;
        T currmax = get(0);
        for (int i = 1; i < this.size(); i++) {
            if (c.compare(currmax, get(i)) < 0) {
                currmax = get(i);
            }
        }
        return currmax;
    }
}
