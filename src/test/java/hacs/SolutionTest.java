package hacs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution sol = new Solution();
    @Test
    void testToString() {
        sol.theAuthor = "Swetha";
        sol.solutionFileName = "515_hacs";
        assertEquals(sol.toString(), "Swetha  515_hacs Grade=0  not reported");
    }

    @Test
    void getGradeString() {
        assertEquals("-1", sol.getGradeString());
    }

    @Test
    void getGradeInt() {
        assertEquals(0, sol.getGradeInt());
    }

    @Test
    void setReported() {
        sol.setReported(false);
        assertFalse(sol.isReported());
    }

    @Test
    void isReported() {
        sol.setReported(false);
        assertFalse(sol.isReported());
    }
}
