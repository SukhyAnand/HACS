package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Hacs.Course;
import Hacs.HighLevelCourseMenu;
import Hacs.Instructor;

class TestInstructor {

	@Test
	void testCreateCourseMenu() {
		Course course = new Course("CSE555", 0);
		Instructor test = new Instructor();
		assertTrue(test.createCourseMenu(course, 0) instanceof HighLevelCourseMenu);
	}
}
