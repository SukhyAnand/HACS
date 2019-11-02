package Hacs;

/*
 * Title:        HACS
 * Description:  CSE870 Homework 3:  Implementing Design Patterns
 * Copyright:    Copyright (c) 2002
 * Company:      Department of Computer Science and Engineering, Michigan State University
 * @author Ji Zhang, Wei Zhu
 * @version 1.0
 * @author Sukhpreet Singh Anand
 * @version 2.0
 */

import java.util.*;
import java.text.DateFormat;

public class Assignment {

	  protected String assName;
	  protected String strAssignmentFilename;
	  protected Date dueDate = new Date();
	  protected String assSpec;
	  protected SolutionList theSolutionList = new SolutionList();
	  protected Solution suggestSolution = new Solution();

	  public Assignment() { }
	
	  public void setDueDate(Date theDueDate) {
		  this.dueDate = theDueDate;
	  }
	
	  public void setAssSpec(String theSpec) {
		  this.assSpec = theSpec;
	  }
	
	  public boolean isOverDue() {
		  Date today;
		  today = new Date();
		  if (today.after(this.dueDate)) {
			  return true;
		  } else {
			  return false;
		  }
	  }
	
	  // Add the theSolution to the theSolutionlist
	  public void addSolution(Solution theSolution) {
		  theSolutionList.add(theSolution);
	  }
	
	  public void submitSolution() {
	  }
	
	  public SolutionList getSolutionList() {
		  return theSolutionList;
	  }
	
	  // Return the solution of the give name
	  public Solution getSolution(String studentname) {
		  SolutionIterator Iterator = getSolutionIterator();//(SolutionIterator) theSolutionList.iterator();
		  return (Solution)Iterator.next(studentname);
	  }
	
	  public Solution getSugSolution() {
		  return suggestSolution;
	  }
	
	  public SolutionIterator getSolutionIterator() {
		  SolutionIterator theSolutionIterator = new SolutionIterator(theSolutionList);
		  return theSolutionIterator;
	  }
	
	  public String toString() {
		  return assName;
	  }
	
	  public String getDueDateString() {
		  DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		  return dateFormat.format(dueDate);
	  }
	
	  public void accept(NodeVisitor visitor) {
		  visitor.visitAssignment(this);
	  }
}