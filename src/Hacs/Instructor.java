package Hacs;

/*
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author Sukhpreet Singh Anand
 * @version 2.0
 */

public class Instructor extends Person {
	
	public Instructor() {
		// type = 1: Instructor
		type = UserInfoItem.USER_TYPE.Instructor.ordinal();
	}

	public CourseMenu createCourseMenu(Course theCourse, int theLevel) {
		if (theLevel == CourseLevel.HIGH_LEVEL_COURSE.ordinal()) {
			// 0: High level defined in CourseSeletDlg.
			theCourseMenu = new HighLevelCourseMenu();
		} else {
			// 1: Low level defined in CourseSeletDlg.
			theCourseMenu = new LowLevelCourseMenu();
		}
		return theCourseMenu;
	}

	public boolean showMenu() {
		super.showMenu();
		showAddButton();
		showViewButtons();
		showComboxes();
		showRadios();
		show();
		return ifLogout();
	}
}