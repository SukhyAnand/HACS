package Hacs;

import java.util.*;

/*
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author mjfindler
 * @version 2.0
 * @author Sukhpreet Singh Anand
 * @version 3.0
 */

public class ListIterator implements Iterator<Object> {
	ArrayList<Object> theList;
	int currentNumber;

	public ListIterator() {
		theList = new ArrayList<>();
		currentNumber = -1;
	}

	public ListIterator(ArrayList<Object> list) {
		theList = list;
		currentNumber = -1;
	}

	public boolean hasNext() {
		if (currentNumber >= theList.size() - 1) {
			return false;
		} else {
			return true;
		}
	}

	public Object next() {
		if (hasNext() == true) {
			currentNumber++;
			return theList.get(currentNumber);
		} else {
			return null;
		}
	}

	public void remove() {
		theList.remove(currentNumber);
	}
}