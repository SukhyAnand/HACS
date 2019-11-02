package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Hacs.Assignment;
import Hacs.Course;

class TestCourse {

	@Test
	void testAddAssignment() {
		Course test = new Course("CSE870", 0);
		test.addAssignment(new Assignment());
		assertEquals(test.assignmentList.size(), 1, "After adding new assignment to Course object, the assignmentList will have a size of 1.");
	}
	
	@Test
	void testToString() {
		Course test = new Course("CSE870", 0);
		assertEquals(test.toString(), "CSE870", "Course name should be equal to CSE870");
	}
}