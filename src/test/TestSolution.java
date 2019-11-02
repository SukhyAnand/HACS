package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Hacs.Solution;

class TestSolution {

	@Test
	void testToString() {
		Solution test = new Solution();
		assertTrue(test.toString().contains("not reported"), "Newly created Solution object is not graded.");
	}

	@Test
	void testIsReported() {
		Solution test = new Solution();
		assertFalse(test.isReported(), "New solution is not reported, hence returns false");
		test.setReported(true);
		assertTrue(test.isReported(), "Should return true because solution is reported.");
	}
}
