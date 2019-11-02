package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Hacs.Course;
import Hacs.HighLevelCourseMenu;
import Hacs.Student;

class TestStudent {

	@Test
	void testCreateCourseMenu() {
		Course course = new Course("CSE555", 0);
		Student test = new Student();
		assertTrue(test.createCourseMenu(course, 0) instanceof HighLevelCourseMenu);
	}
}
