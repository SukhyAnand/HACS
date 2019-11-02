package Hacs;

import java.util.ArrayList;
import java.io.*;

/*
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author mjfindler
 * @version 2.0 update to Java 8
 * @author Sukhpreet Singh Anand
 * @version 3.0
 */

public class ClassCourseList extends ArrayList<Course> {

	private static final long serialVersionUID = 1L;

	public ClassCourseList() { }

	// Initialize the list by reading from the file.
	public void initializeFromFile(String theFileName) {
		try {
			String strCourseName = null;
			BufferedReader file = new BufferedReader(new FileReader(theFileName));
			while ((strCourseName = file.readLine()) != null) {
				Course theCourse;
				theCourse = new Course(strCourseName, 0);
				//theCourse.CourseName= strCourseName;
				add(theCourse);
			}
			file.close();
		} catch (Exception ee) { 
			ee.printStackTrace();
		}
	}

	public Course findCourseByCourseName(String courseName) {
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