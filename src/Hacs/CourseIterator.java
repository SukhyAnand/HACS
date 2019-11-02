package Hacs;

import java.util.Iterator;

/*
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author Sukhpreet Singh Anand
 * @version 2.0
 */

public class CourseIterator implements Iterator<Course>
{
	ClassCourseList theCourseList;
	int currentCourseNumber;

	public CourseIterator() {
		this.currentCourseNumber = -1;
		this.theCourseList = new ClassCourseList();
	}

	public CourseIterator(ClassCourseList courseList) {
		this.currentCourseNumber = -1;
		this.theCourseList = courseList;
	}

	public boolean hasNext() {
		if (currentCourseNumber >= theCourseList.size() - 1) {
			return false;
		} else {
			return true;
		}
	}

	public Course next() {
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

	// The next Course that fits the given courseName
	public Object next(String CourseName) {
		Course theCourse;
		theCourse = (Course) next();
		while(theCourse != null) {
			if(CourseName.compareTo(theCourse.toString()) == 0) {
				return theCourse;
			}
			theCourse = (Course) next();
		}
		return null;
	}
}