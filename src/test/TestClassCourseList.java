package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Hacs.ClassCourseList;

class TestClassCourseList {

	@Test
	void testInitializeFromFile() {
		ClassCourseList test = new ClassCourseList();
		test.initializeFromFile("CourseInfo.txt");
		assertEquals(test.size(), 3, "Total number of courses are 3.");
	}

	@Test
	void testFindCourseByCourseName() {
		ClassCourseList test = new ClassCourseList();
		assertNull(test.findCourseByCourseName("CSE111"), "Assert null because CSE111 course doesn't exist.");
	}
}
