package hacs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ListIteratorTest {

    final int n1 = 5;
    final int n2 = 7;
    @Test
    void hasNext() {
        ArrayList<Object> lst = new ArrayList<>();
        lst.add(n2);
        ListIterator it = new ListIterator(lst);
        assertTrue(it.hasNext());
        lst.remove(it.next());
        assertFalse(it.hasNext());
    }

    @Test
    void remove() {
        final int count = 1;
        ArrayList<Object> testList = new ArrayList<>();
        testList.add(n1);
        testList.add(n2);
        ListIterator lst = new ListIterator(testList);
        lst.next();
        lst.remove();
        assertEquals(count, lst.theList.size());
    }
}
