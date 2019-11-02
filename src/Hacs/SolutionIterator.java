package Hacs;

import java.util.Iterator;

/*
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author Sukhpreet Singh Anand
 * @version 2.0
 */

public class SolutionIterator implements Iterator<Solution> {
	SolutionList solutionList;
	// CurrentSolutionNumber: point to the location before the first element
	int currentSolutionNumber;

	public SolutionIterator() {
		this.currentSolutionNumber = -1;
		this.solutionList = new SolutionList();
	}

	public SolutionIterator(SolutionList thesolutionlist) {
		solutionList = thesolutionlist;
		moveToHead();
	}

	public void moveToHead() {
		// CurrentSolutionNumber: point to the location before the first element
		currentSolutionNumber = -1;
	}

	public boolean hasNext() {
		// TODO: Implement this java.util.Iterator method
		if (currentSolutionNumber >= solutionList.size() - 1) {
			return false;
		} else {
			return true;
		}
		// throw new java.lang.UnsupportedOperationException("Method hasNext() not yet implemented.");
	}

	public Solution next() {
		// TODO: Implement this java.util.Iterator method
		if (hasNext() == true) {
			currentSolutionNumber++;
			return solutionList.get(currentSolutionNumber);
		} else {
			return null;
		}
		// throw new java.lang.UnsupportedOperationException("Method next() not yet implemented.");
	}

	// Get the next Solution that fits the userName;
	public Object next(String userName) {
		Solution theSolution;
		theSolution = (Solution) next();
		while (theSolution != null) {
			if (userName.compareTo(theSolution.theAuthor) == 0) {
				return theSolution;
			}
			theSolution = (Solution) next();
		}
		return null;
	}

	public void remove() {
		// TODO: Implement this java.util.Iterator method
		solutionList.remove(currentSolutionNumber);
		// throw new java.lang.UnsupportedOperationException("Method remove() not yet implemented.");
	}
}