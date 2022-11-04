package hacs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void createCourseMenu() {
        Course course = new Course("SER515", 1);
        Student student = new Student();
        assertTrue(student.createCourseMenu(course, 1) instanceof LowLevelCourseMenu);
    }
}
