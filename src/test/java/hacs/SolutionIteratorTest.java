package hacs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionIteratorTest {

    SolutionIterator i;
    SolutionList sList;
    Solution sol;

    @BeforeEach
    void start() {
        sol = new Solution();
        sList = new SolutionList();

        sol.theAuthor = "Swetha";
        sol.solutionFileName = "sol.txt";
        sol.theGrade = 1;
        sol.reported = true;

        sList.add(sol);
        sList.add(sol);
        i = new SolutionIterator(sList);
    }

    @Test
    void hasNext() {
        assertTrue(i.hasNext());
    }

    @Test
    void testNext() {
        assertEquals(((Solution) i.next()).theAuthor, "Swetha");
    }

    @Test
    void remove() {
        i.next();
        int length = i.solutionList.size();
        i.remove();
        assertEquals(i.solutionList.size(), length - 1);
    }
}
