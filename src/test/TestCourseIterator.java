package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Hacs.ClassCourseList;
import Hacs.CourseIterator;

class TestCourseIterator {

	@Test
	void testHasNext() {
		ClassCourseList list = new ClassCourseList();
		list.initializeFromFile("CourseInfo.txt");
		CourseIterator test = new CourseIterator(list);
		assertTrue(test.hasNext(), "hasNext() should return true as it points to the start of the populated course list.");
	}
	
	@Test
	void testNext() {
		ClassCourseList list = new ClassCourseList();
		list.initializeFromFile("CourseInfo.txt");
		CourseIterator test = new CourseIterator(list);
		assertEquals(test.next().toString(), "CSE870", "next() should return the first Course object with courseName CSE870.");
	}
	
	@Test
	void testRemove() {
		ClassCourseList list = new ClassCourseList();
		list.initializeFromFile("CourseInfo.txt");
		CourseIterator test = new CourseIterator(list);
		test.next();
		test.remove();
		assertEquals(test.next().toString(), "CSE890", "After removal of first course, next() should return Course object with courseName CSE890.");
	}
	
	@Test 
	void testNext2() {
		ClassCourseList list = new ClassCourseList();
		list.initializeFromFile("CourseInfo.txt");
		CourseIterator test = new CourseIterator(list);
		assertEquals(test.next("CSE880").toString(), "CSE880", "next() should return the Course object with courseName CSE880.");
		assertNull(test.next("CSE111"), "Should return null for non-existent Course object.");
	}
}