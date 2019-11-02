package Hacs;

/*
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author Sukhpreet Singh Anand
 * @version 2.0
 */

import java.awt.*;
import java.awt.event.*;

public class LowLevelCourseMenu extends CourseMenu {

	private static final long serialVersionUID = 1L;

	public LowLevelCourseMenu() {
	}

	void showMenu(Course theCourse) {
		setVisible(true);
	}

	void showAddButtons() {
		assignmentAddButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				assignmentAddButtonActionPerformed(e);
			}
		});
		assignmentAddButton.setText("Add");
		assignmentAddButton.setBounds(new Rectangle(500, 54, 79, 29));
		optionAddButton.setText("Add");
		optionAddButton.setBounds(new Rectangle(500, 125, 79, 29));
		this.getContentPane().add(assignmentAddButton, null);
		this.getContentPane().add(optionAddButton, null);
	}

	void showRadios() {
		assignmentRadio.setText("Assignment");
		assignmentRadio.setBounds(new Rectangle(21, 55, 150, 26));
		this.getContentPane().add(assignmentRadio, null);
		optionRadio.setText("Low level presenttion");
		optionRadio.setBounds(new Rectangle(21, 128, 150, 26));
		this.getContentPane().add(optionRadio, null);
	}

	void showComboxes() {
		assignmentCombox.setBounds(new Rectangle(200, 57, 126, 22));
		optionCombo.setBounds(new Rectangle(200, 127, 126, 22));
		this.getContentPane().add(assignmentCombox, null);
		this.getContentPane().add(optionCombo, null);
		refresh();
	}

	void showViewButtons() {
		assignmentViewButton.setText("View");
		assignmentViewButton.setBounds(new Rectangle(400, 54, 79, 29));
		assignmentViewButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				assignmentViewButtonActionPerformed(e);
			}
		});
		optionViewButton.setText("View");
		optionViewButton.setBounds(new Rectangle(400, 124, 79, 29));
		this.getContentPane().add(assignmentViewButton, null);
		this.getContentPane().add(optionViewButton, null);
	}

	void showLabel() {
		assignmentContentLabel.setText("Assigment content");
		assignmentContentLabel.setBounds(new Rectangle(23, 186, 432, 99));
		this.getContentPane().add(assignmentContentLabel, null);
	}
}