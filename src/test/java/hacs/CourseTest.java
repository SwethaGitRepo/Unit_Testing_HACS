package hacs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    String course = "Course1";
    int level = 1;
    Course c = new Course(course, level);
    @Test
    void addAssignment() {
        Assignment a1 = new Assignment();
        Assignment a2 = new Assignment();
        c.addAssignment(a1);
        c.addAssignment(a2);
        assertEquals(2, c.assignmentList.size());
    }

    @Test
    void testToString() {
        assertEquals(course, "Course1");
    }
}
