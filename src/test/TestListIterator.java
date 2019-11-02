package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Hacs.ListIterator;

class TestListIterator {

	@Test
	void testHasNext() {
		ListIterator test = new ListIterator();
		assertFalse(test.hasNext(), "hasNext() on empty list returns false.");
		
		ArrayList<Object> list = new ArrayList<>();
		list.add(new Object());
		ListIterator test2 = new ListIterator(list);
		assertTrue(test2.hasNext(), "hasNext() returns true because list has one element.");
	}

	@Test
	void testNext() {
		ArrayList<Object> list = new ArrayList<>();
		Object obj = new Object();
		list.add(obj);
		ListIterator test = new ListIterator(list);
		assertEquals(test.next(), obj, "next() should return obj");
	}
	
	@Test
	void testRemove() {
		ArrayList<Object> list = new ArrayList<>();
		list.add(new Object());
		ListIterator test = new ListIterator(list);
		test.next();
		test.remove();
		assertFalse(test.hasNext(), "After removal of obj, hasNext() should return false.");
	}
}
