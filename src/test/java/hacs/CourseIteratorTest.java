package hacs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseIteratorTest {

    CourseIterator itr;
    ClassCourseList courseList;
    @BeforeEach
    void start() {
        courseList = new ClassCourseList();
        courseList.initializeFromFile("CourseInfo.txt");
        itr = new CourseIterator(courseList);
    }

    @Test
    void hasNext() {
        assertTrue(itr.hasNext());
    }

    @Test
    void next() {
        assertNotNull(itr.next());
    }

    @Test
    void remove() {
        int length = itr.theCourseList.size();
        itr.next();
        itr.remove();
        assertEquals(itr.theCourseList.size(), length - 1);
    }

    @Test
    void testNext() {
        assertEquals(itr.next("CSE890").toString(), "CSE890");
        assertNull(itr.next("CSE100"));
    }
}
