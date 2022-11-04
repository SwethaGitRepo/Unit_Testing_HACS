package hacs;

import java.util.Iterator;

/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

@SuppressWarnings("ALL")
public class CourseIterator implements Iterator {
    ClassCourseList theCourseList;
    int currentCourseNumber = -1;

    public CourseIterator() {
    }

    public CourseIterator(ClassCourseList courseList) {
        theCourseList = courseList;
    }

    public boolean hasNext() {
        //System.out.println("Current course nmbr : "+currentCourseNumber+" course list size :"+ theCourseList.size());
        return (currentCourseNumber < theCourseList.size() - 1);
    }

    public Object next() {
        //System.out.println("Has next ? "+hasNext());
        if (hasNext()) {
            currentCourseNumber++;
            return theCourseList.get(currentCourseNumber);    
        } else {
            return null;
        }
    }
    public void remove() {
        theCourseList.remove(currentCourseNumber);
    }

    // the next Course that fits the given courseName
    public Object next(String courseName) {
        //System.out.println("4 - entered here");
        Course theCourse;
        theCourse = (Course) next();
        while (theCourse != null) {
            //System.out.println("5 - the course name - "+ theCourse.toString());
            if (courseName.compareTo(theCourse.toString()) == 0) {
                return theCourse;
            }
            theCourse = (Course) next();
        }
        return null;
    }
}
