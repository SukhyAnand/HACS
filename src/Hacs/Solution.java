package Hacs;

import java.util.*;

/*
 * Title: HACS Description: CSE870 Homework 3: Implementing Design Patterns
 * Copyright: Copyright (c) 2002 Company: Department of Computer Science and
 * Engineering, Michigan State University
 * 
 * @author Ji Zhang, Wei Zhu
 * @version 1.0
 * @author mjfindler
 * @version 2.0
 * @author Sukhpreet Singh Anand
 * @version 3.0
 * 
 * update to Java 8
 */

public class Solution {
	String theAuthor;
	String solutionFileName;
	Date theSubmitData;
	int theGrade;
	boolean reported;

	public Solution() {
		theAuthor = "";
		solutionFileName = "";
		theSubmitData = new Date();
		reported = false;
	}

	@Override
	public String toString() {
		String string;
		string = theAuthor + "  " + solutionFileName + " Grade=" + getGradeInt() + "  ";
		if (isReported()) {
			string += "reported";
		} else {
			string += "not reported";
		}
		return (string);
	}

	String getGradeString() {
		if (isReported()) {
			return "" + theGrade;
		} else {
			return "-1";
		}
	}

	int getGradeInt() {
		return theGrade;
	}

	public void setReported(boolean reported) {
		this.reported = reported;
	}

	public boolean isReported() {
		return reported;
	}
}