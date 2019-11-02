package Hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;

/*
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author Sukhpreet Singh Anand
 * @version 2.0
 */

public class InstructorAssignmentMenu extends AssignmentMenu {

	private static final long serialVersionUID = 1L;
	// class AssignmentMenu
	//private boolean bSubmit = false;
	private Solution theSolution;
	private Assignment theAssignment;
	JComboBox<Solution> combSolutionList = new JComboBox<>();

	JTextField tbAssignmentName = new JTextField();
	JTextField tbDueDate = new JTextField();
	JTextField tbSuggestedSolution = new JTextField();

	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JButton buttonGrade = new JButton();
	JButton buttonReport = new JButton();
	JButton buttonClose = new JButton();

	public InstructorAssignmentMenu() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		jLabel1.setText("Assignment Name");
		jLabel1.setBounds(new Rectangle(25, 31, 118, 18));
		this.getContentPane().setLayout(null);
		tbAssignmentName.setText("jTextField1");
		tbAssignmentName.setBounds(new Rectangle(192, 31, 341, 22));
		jLabel2.setText("Due date");
		jLabel2.setBounds(new Rectangle(28, 90, 113, 18));
		tbDueDate.setText("tbDueDate");
		tbDueDate.setBounds(new Rectangle(195, 87, 337, 22));
		jLabel3.setText("Suggested solution");
		jLabel3.setBounds(new Rectangle(28, 151, 118, 18));
		tbSuggestedSolution.setText("jTextField2");
		tbSuggestedSolution.setBounds(new Rectangle(197, 149, 339, 22));
		buttonGrade.setText("Grade");
		buttonGrade.setBounds(new Rectangle(458, 199, 79, 29));
		buttonGrade.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonGradeActionPerformed(e);
			}
		});
		buttonReport.setText("Report");
		buttonReport.setBounds(new Rectangle(365, 249, 79, 29));
		buttonReport.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonReportActionPerformed(e);
				buttonCloseActionPerformed(e);
			}
		});
		buttonClose.setText("Close");
		buttonClose.setBounds(new Rectangle(86, 253, 79, 29));
		buttonClose.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonCloseActionPerformed(e);
			}
		});
		combSolutionList.setBounds(new Rectangle(32, 204, 413, 22));
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(tbAssignmentName, null);
		this.getContentPane().add(jLabel2, null);
		this.getContentPane().add(tbDueDate, null);
		this.getContentPane().add(jLabel3, null);
		this.getContentPane().add(tbSuggestedSolution, null);
		this.getContentPane().add(buttonClose, null);
		this.getContentPane().add(combSolutionList, null);
		this.getContentPane().add(buttonGrade, null);
		this.getContentPane().add(buttonReport, null);
	}

	public void showMenu(Assignment assignment, Person person) {
		theAssignment = assignment;
		//Solution theSolution;
		tbAssignmentName.setText(theAssignment.assName);

		DateFormat theDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		tbDueDate.setText(theDateFormat.format(theAssignment.dueDate));
		tbSuggestedSolution.setText(theAssignment.suggestSolution.solutionFileName);
		refreshSolutionList();
		setVisible(true);
	}

	void buttonCloseActionPerformed(ActionEvent event) {
		theAssignment.assName = tbAssignmentName.getText();
		DateFormat tempDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		try {
			theAssignment.dueDate = tempDateFormat.parse(tbDueDate.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
		theAssignment.suggestSolution.solutionFileName = tbSuggestedSolution.getText();
		setVisible(false);
	}

	void buttonGradeActionPerformed(ActionEvent event) {
		Solution theSolution = (Solution) combSolutionList.getSelectedItem();
		if (theSolution == null) {
			return;
		}
		Hacs.theFacade.gradeSolution(theSolution);
		refreshSolutionList();
	}

	void buttonReportActionPerformed(ActionEvent event) {
		Hacs.theFacade.reportSolutions(theAssignment);
		refreshSolutionList();
	}

	private void refreshSolutionList() {
		combSolutionList.removeAllItems();
		SolutionIterator solutionIterator = new SolutionIterator(theAssignment.theSolutionList);
		while (solutionIterator.hasNext()) {
			theSolution = (Solution) solutionIterator.next();
			combSolutionList.addItem(theSolution);
		}
	}
}