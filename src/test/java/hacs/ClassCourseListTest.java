package hacs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassCourseListTest {
    ClassCourseList courseList = new ClassCourseList();
    @Test
    void initializeFromFile() {
        final int count = 3;
        courseList.initializeFromFile("CourseInfo.txt");
        assertEquals(count, courseList.size());
    }

    @Test
    void findCourseByCourseName() {
        String course = "CSE890";
        assertNull(courseList.findCourseByCourseName("CSE890"));
        courseList.initializeFromFile("CourseInfo.txt");
        assertEquals(courseList.findCourseByCourseName(course).toString(), course);
    }
}
