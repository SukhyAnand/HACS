package Hacs;

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

public class Student extends Person {

	public Student() {
		type = UserInfoItem.USER_TYPE.Student.ordinal(); // type = 0: student
	}

	public CourseMenu createCourseMenu(Course theCourse, int theLevel) {
		if (theLevel == CourseLevel.HIGH_LEVEL_COURSE.ordinal()) {
			// 0: High level defined in CourseSelectDlg.
			theCourseMenu = new HighLevelCourseMenu();
		} else {
			// 1: Low level defined in CourseSelectDlg.
			theCourseMenu = new LowLevelCourseMenu();
		}
		return theCourseMenu;
	}

	@Override
	public boolean showMenu() {
		super.showMenu();
		showViewButtons();
		showComboxes();
		showRadios();
		show();
		return ifLogout();
	}
}