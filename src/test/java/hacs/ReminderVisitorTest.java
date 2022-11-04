package hacs;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ReminderVisitorTest {
    @Test
    void visitAssignment() {
        ReminderVisitor rm = new ReminderVisitor(new Reminder());
        Assignment a = new Assignment();
        a.assName = "Assignment";
        a.setDueDate(new Date());
        rm.visitAssignment(a);
        assertNotNull(rm.mReminder.listUpcoming);
    }
}
