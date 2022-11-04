package hacs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructorTest {
    Instructor inst = new Instructor();
    @Test
    void createCourseMenu() {
        CourseMenu menu = inst.createCourseMenu(new Course("Course", 1), 1);
        assertTrue(menu instanceof LowLevelCourseMenu);
    }
}
