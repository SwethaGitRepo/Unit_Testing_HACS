package hacs;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class AssignmentTest {
    final int year1 = 2022;
    final int year2 = 2026;
    final int date = 3;
    Assignment ass = new Assignment();
    Solution sol = new Solution();
    @Test
    void setDueDate() {
        Date due = new GregorianCalendar(year1, Calendar.OCTOBER, date).getTime();
        ass.setDueDate(due);
        assertEquals(ass.dueDate, due);
    }

    @Test
    void setAssSpec() {
        String s = "Test";
        ass.setAssSpec(s);
        assertEquals(ass.assSpec, s);
    }

    @Test
    void isOverDue() {
        Date dueDate = new GregorianCalendar(year1, Calendar.OCTOBER, date).getTime();
        ass.setDueDate(dueDate);
        assertTrue(ass.isOverDue());
        dueDate = new GregorianCalendar(year2, Calendar.NOVEMBER, date).getTime();
        ass.setDueDate(dueDate);
        assertFalse(ass.isOverDue());
    }

    @Test
    void addSolution() {
        int count = 1;
        ass.addSolution(sol);
        assertEquals(count, ass.theSolutionList.size());
    }

    @Test
    void testAddSolution() {
        ass.addSolution(sol);
        assertTrue(ass.theSolutionList.contains(sol));
    }

    @Test
    void submitSolution() {
        ass.submitSolution();
        assertTrue(ass.isSolnSubmitted);
    }

    @Test
    void getSolutionList() {
        SolutionList solList = new SolutionList();
        assertEquals(solList, ass.getSolutionList());
    }

    @Test
    void getSolution() {
        sol.theAuthor = "Swetha";
        ass.addSolution(sol);
        assertEquals(sol, ass.getSolution("Swetha"));
    }

    @Test
    void getSugSolution() {
        sol.theAuthor = "Swetha";
        ass.suggestSolution = sol;
        assertEquals(ass.getSugSolution(), sol);
    }

    @Test
    void getSolutionIterator() {
        assertTrue(ass.getSolutionIterator() != null);
    }

    @Test
    void getDueDateString() {
        Date dt = new Date();
        ass.setDueDate(dt);
        DateFormat dForm = DateFormat.getDateInstance(DateFormat.SHORT);
        assertEquals(ass.getDueDateString(), dForm.format(dt));
    }

    @Test
    void accept() {
    }
}
