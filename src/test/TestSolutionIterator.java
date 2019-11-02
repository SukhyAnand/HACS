package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Hacs.Solution;
import Hacs.SolutionIterator;
import Hacs.SolutionList;

class TestSolutionIterator {

	@Test
	void testMoveToHead() {
		SolutionList list = new SolutionList();
		list.add(new Solution());
		SolutionIterator test = new SolutionIterator(list);
		test.next();
		assertFalse(test.hasNext(), "SolutionIterator points to the last element of the SolutionList which is why hasNext() returns false.");
		test.moveToHead();
		assertTrue(test.hasNext(), "SolutionIterator points to head, which is why hasNext() returns true.");
	}

	@Test
	void testHasNext() {
		SolutionIterator test = new SolutionIterator();
		assertFalse(test.hasNext(), "hasNext() should return false on an empty SolutionList.");
		
		SolutionList list = new SolutionList();
		list.add(new Solution());
		SolutionIterator test2 = new SolutionIterator(list);
		assertTrue(test2.hasNext(), "hasNext() returns true because SolutionList has one item.");
	}
	
	@Test
	void testNext() {
		SolutionList list = new SolutionList();
		Solution solution = new Solution();
		list.add(solution);
		SolutionIterator test = new SolutionIterator(list);
		assertEquals(test.next(), solution, "next() should return the newly created Solution object.");
	}
	
	@Test
	void testNext2() {
		SolutionIterator test = new SolutionIterator();
		assertNull(test.next("Solution1"), "Returns null because Solution1 doesn't exist.");
	}
	
	@Test
	void testRemove() {
		SolutionList list = new SolutionList();
		Solution solution = new Solution();
		list.add(solution);
		SolutionIterator test = new SolutionIterator(list);
		test.next();
		test.remove();
		test.moveToHead();
		assertFalse(test.hasNext(), "hasNext() returns false after calling remove() and then moving SolutionIterator back to head by calling moveToHead().");
	}
}
