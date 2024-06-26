package hacs;

import java.util.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author mjfindler
 * @version 2.0 use <e> notation
 * @author Swetha Ganapathy
 * @version 3.0 update to Java 11
 */

public class ListIterator implements Iterator<Object> {
    ArrayList<Object> theList;
    int currentNumber = -1;

    public ListIterator(ArrayList<Object> list) {
        theList = list;
    }

    public boolean hasNext() {
        boolean cond = currentNumber >= theList.size() - 1;
        return !cond;
    }

    public Object next() {
        boolean b = hasNext();
        if (b) {
            currentNumber++;
            return theList.get(currentNumber);
        } else {
            return null;
        }
    }

    public void remove() {
        theList.remove(currentNumber);
    }
}
