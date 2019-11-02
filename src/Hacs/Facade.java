package Hacs;

import java.io.*;

/*
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author mjfindler
 * @version 2.0
 * @author Sukhpreet Singh Anand
 * @version 3.0
 * 
 * Update to Java 8
 */

public class Facade {
	public int userType;
	private Course theSelectedCourse;
	private int nCourseLevel;
	ClassCourseList theCourseList;
	Person thePerson;

	public Facade() {
		this.theSelectedCourse = null;
		this.nCourseLevel = CourseLevel.HIGH_LEVEL_COURSE.ordinal();
	}

	public boolean login(UserInfoItem userInfoItem) {
		Login login = new Login();
		login.setModal(true);
		login.setVisible(true);
		userInfoItem.strUserName = login.getUserName();
		userInfoItem.userType = login.getUserType();
		return login.isExit();
	}

	/* 
	 * Functions for CourseMenu
	 *
	 * On clicking the add button of the CourseMenu , call this function this
	 * function will new an assignment fill the required infomation this function
	 * will call InstructorAssignmentMenu or StudentAssignmentMenu according to the
	 * type of the user it will not update the course menu. the coursemenu need to
	 * refreshed outside the function
	 */

	void addAssignment(Course theCourse) {
		AssignmentMenu theAssignmentMenu;
		if (thePerson.type == 0) {
			// Check for student
			theAssignmentMenu = new StudentAssignmentMenu();
		} else {
			// Check for instructor
			theAssignmentMenu = new InstructorAssignmentMenu();
		}
		Assignment theAssignment = new Assignment();
		theAssignmentMenu.showMenu(theAssignment, thePerson);
		theCourse.addAssignment(theAssignment);
	}

	/*
	 * On clicking the view button of the CourseMenu , call this function and pass
	 * the pointer of the Assignment and the person pointer to this function this
	 * function will new an assignment fill the required infomation this function
	 * will call InstructorAssignmentMenu or StudentAssignmentMenu according to the
	 * type of the user
	 */
	void viewAssignment(Assignment theAssignment) {
		AssignmentMenu theAssignmentMenu;
		if (thePerson.type == 0)/// student
		{
			theAssignmentMenu = new StudentAssignmentMenu();
		} else {
			theAssignmentMenu = new InstructorAssignmentMenu();
		}

		theAssignmentMenu.showMenu(theAssignment, thePerson);
	}

	/* 
	 * Functions for InstructorAssignmentMenu
	 *
	 * This function will grade the give Solution: theSolution this function calls
	 */

	void gradeSolution(Solution theSolution) {
		SolutionMenu solutionMenu = new SolutionMenu();
		solutionMenu.ShowMenu(theSolution);
	}

	void reportSolutions(Assignment theAssignment) {
		Solution theSolution;
		SolutionIterator theSolutionIterator;
		theSolutionIterator = theAssignment.getSolutionIterator();
		theSolution = (Solution) theSolutionIterator.next();
		while (theSolution != null) {
			theSolution.setReported(true);
			theSolution = (Solution) theSolutionIterator.next();
		}
	}

	// Functions for StudentAssignmentMenu
	void submitSolution(Assignment theAssignment, Solution theSolution) {
		theAssignment.addSolution(theSolution);
	}

	void remind() {
		Reminder theReminder = new Reminder();
		theReminder.showReminder(thePerson.getCourseList());
	}

	void createUser(UserInfoItem userinfoitem) {
		if (userinfoitem.userType == UserInfoItem.USER_TYPE.Student) {
			// student
			thePerson = new Student();
		} else {
			// instructor
			thePerson = new Instructor();
		}
		thePerson.userName = userinfoitem.strUserName;
	}

	/*
	 * Create a course list and initialize it with the file CourseInfo.txt
	 */
	void createCourseList() {
		theCourseList = new ClassCourseList();
		theCourseList.initializeFromFile("CourseInfo.txt");
	}

	/*
	 * Call this function after create user, create courselist read the
	 * UserCourse.txt file match the coursename with theCouresList attach the
	 * Matched course object to the new create user Facade.thePerson.CourseList
	 */
	void attachCourseToUser() {
		BufferedReader file;
		try {
			file = new BufferedReader(new FileReader("UserCourse.txt"));
			String aline, strUserName, strCourseName;
			while ((aline = file.readLine()) != null) {
				// Not the EOF
				strUserName = getUserName(aline);
				strCourseName = getCourseName(aline);
				if (strUserName.compareTo(thePerson.userName) == 0) {
					// the UserName matches
					theSelectedCourse = findCourseByCourseName(strCourseName);
					//System.out.println(theSelectedCourse);
					if (theSelectedCourse != null) {
						// Find the Course in the CourseList--->attach
						thePerson.addCourse(theSelectedCourse);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Get the user name from a line UserName:CourseName
	 */
	private String getUserName(String aline) {
		int sep = aline.lastIndexOf(':');
		return aline.substring(0, sep);
	}

	/*
	 * Get the CourseName from a line UserName:CourseName
	 */
	private String getCourseName(String aline) {
		int sep = aline.lastIndexOf(':');
		return aline.substring(sep + 1, aline.length());
	}

	/*
	 * show the course selection dialog, show the course attached to thePerson and
	 * return the selected course and assign the course to the class member
	 * theSelecteCourse, the Course Level to CourseLevel CourseLeve = 0: High,
	 * CourseLevel = 1: Low
	 */
	public boolean selectCourse() {
		CourseSelectDlg theDlg = new CourseSelectDlg();
		theSelectedCourse = theDlg.ShowDlg(thePerson.courseList);
		thePerson.currentCourse = theSelectedCourse;
		nCourseLevel = theDlg.nCourseLevel;
		return theDlg.isLogout();
	}

	/*
	 * call the thePerson.CreateCourseMenu according to the really object(student or
	 * instructor) and the nCourseLevel it will call different menu creater and show
	 * the menu;
	 */

	public boolean courseOperation() {
		thePerson.createCourseMenu(theSelectedCourse, nCourseLevel);
		/* 
		 * 0: Logout
		 * 1: Select another course
		 */
		return thePerson.showMenu();
	}

	/*
	 * find the course in theCourseList that matches strCourseName 1 create a
	 * CourseIterator for the List 2 Find the Course with the Iterator return the
	 * pointer of the Course if not fine, return null;
	 */
	private Course findCourseByCourseName(String strCourseName) {
		CourseIterator Iterator = new CourseIterator(theCourseList);
		return (Course) Iterator.next(strCourseName);
	}

}