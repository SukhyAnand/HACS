package Hacs;

import java.util.*;

/*
 * Title: HACS Description: CSE870 Homework 3: Implementing Design Patterns
 * Copyright: Copyright (c) 2002 Company: Department of Computer Science and
 * Engineering, Michigan State University
 * 
 * @author Ji Zhang, Wei Zhu
 * @version 1.0
 * @author Sukhpreet Singh Anand
 * @version 2.0
 */

abstract public class Person {
	int type;
	String userName;
	ClassCourseList courseList;
	CourseMenu theCourseMenu;
	Course currentCourse;
	Assignment currentAssignment;

	public Person() {
		this.type = 0; // type = 0: student, type = 1: instructor
		this.courseList = new ClassCourseList();
	}

	abstract public CourseMenu createCourseMenu(Course theCourse, int theLevel);

	public void showAddButton() {
		theCourseMenu.showAddButtons();
	}

	public void showViewButtons() {
		theCourseMenu.showViewButtons();
	}

	public void showComboxes() {
		theCourseMenu.showComboxes();
	}

	public void showRadios() {
		theCourseMenu.showRadios();
	}

	public void show() {
		theCourseMenu.setVisible(true);
	}

	public boolean ifLogout() {
		return theCourseMenu.ifLogout();
	}

	// Show the assignment list
	public boolean showMenu() {
		// Create a iterator for the assignment list
		// Iterator theIter=new ListIterator(CurrentCourse.AssList );
		if (currentCourse == null) {
			return false;
		}
		Iterator<Assignment> theIter = currentCourse.assignmentList.iterator();
		theCourseMenu.theCourse = currentCourse;
		Assignment theAssignment;
		while (theIter.hasNext()) {
			theAssignment = (Assignment) theIter.next();
			theCourseMenu.assignmentCombox.addItem(theAssignment);
		}
		return true;
	}

	public ClassCourseList getCourseList() {
		return courseList;
	}

	public void addCourse(Course theCourse) {
		courseList.add(theCourse);
	}
}