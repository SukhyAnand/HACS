package Hacs;

import java.util.*;

/*
 * Title:        HACS
 * Description:  CSE870 Homework 3:  Implementing Design Patterns
 * Copyright:    Copyright (c) 2002
 * Company:      Department of Computer Science and Engineering, Michigan State University
 * @author Ji Zhang, Wei Zhu
 * @version 1.0
 * @author mjfindler
 * @version 2.0 
 * @author Sukhpreet Singh Anand
 * @version 3.0
 * Update to Java 8
 */

public class Course {
	String courseName;
	public ArrayList<Assignment> assignmentList;
	int numOfAss;
	int courseLevel;

	public Course(String strCourse, int theLevel) {
		this.courseName = strCourse;
		/* 0: High level presentation, 
		 * 1: Low Level presentation
		 */
		this.courseLevel = theLevel;
		this.assignmentList = new ArrayList<Assignment>();
		this.numOfAss = 0;
	}
  
	public void addAssignment(Assignment newAssignment) {
		assignmentList.add(newAssignment);
	}
 
	public String toString() {
		return courseName;
	}
  
	void accept(NodeVisitor visitor) {
		visitor.visitCourse(this);
	}
}