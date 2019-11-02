package test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import org.junit.jupiter.api.Test;

import Hacs.Assignment;
import Hacs.Solution;

class TestAssignment {

	@Test
	void testIsOverDue() {
		Assignment test = new Assignment();
		Instant now = Instant.now();
		Instant before = now.minus(Duration.ofDays(300));
		test.setDueDate(Date.from(before));
		assertTrue(test.isOverDue(), "Returns true when due date is over due");
	}
	
	@Test
	void testAddSolution() {
		Assignment test = new Assignment();
		test.addSolution(new Solution());
		assertEquals(test.getSolutionList().size(), 1, "Solution list should be one after addition of new Solution object");
	}
	
	@Test
	void testGetSolution() {
		Assignment test = new Assignment();
		Solution solution = new Solution();
		test.addSolution(solution);
		assertEquals(test.getSolution(""), solution, "Getting a newly created Solution should return empty itself on calling getSolution().");		
	}
	
	@Test
	void testGetSugSolution() {
		Assignment test = new Assignment();
		assertNotNull(test.getSugSolution(), "Suggested solution should not be null.");
	}
	
	@Test
	void testGetSolutionIterator() {
		Assignment test = new Assignment();
		assertNotNull(test.getSolutionIterator(), "Solution iterator should not be null.");
	}

	@Test
	void testToString() {
		Assignment test = new Assignment();
		assertNull(test.toString(), "New assignment name should be null.");
	}
	
	@Test
	void testGetDueDateString() {
		Assignment test = new Assignment();
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		assertEquals(test.getDueDateString(), dateFormat.format(new Date()), "Due date should be same as new date in short date format.");
	}
}
