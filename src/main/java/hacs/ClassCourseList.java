package hacs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * @version 1.0
 * @author mjfindler
 * @version 2.0
 * Update to Java 8
 * @author Swetha Ganapathy
 * @version 3.0 update to Java 11
 */

@SuppressWarnings("ALL")
public class ClassCourseList extends ArrayList<Course> {
    public ClassCourseList() {
    }

    //// initialize the list by reading from the file.
    void initializeFromFile(String theFileName) {
        try {
            String strCourseName;
            BufferedReader file = new BufferedReader(new FileReader(theFileName));
            while ((strCourseName = file.readLine()) != null) {
                Course theCourse;
                theCourse = new Course(strCourseName, 0);
                add(theCourse);
            }
        } catch (IOException ee) {
            System.out.println(ee);
        }
    }

    Course findCourseByCourseName(String courseName) {
        int nCourseCount = size();
        for (int i = 0; i < nCourseCount; i++) {
            Course theCourse;
            theCourse = (Course) get(i);
            if (theCourse.courseName.compareTo(courseName) == 0) {
                return theCourse;
            }
        }
        return null;
    }
}
