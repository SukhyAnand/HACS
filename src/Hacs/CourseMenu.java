package Hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;

/*
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author Sukhpreet Singh Anand
 * @version 2.0
 */

abstract public class CourseMenu extends JDialog {
	
	private static final long serialVersionUID = 1L;

	Course theCourse;
	boolean bLogout = true;

	JRadioButton assignmentRadio = new JRadioButton();
	JComboBox<Assignment> assignmentCombox = new JComboBox<>();
	JButton assignmentViewButton = new JButton();
	JButton assignmentAddButton = new JButton();
	JRadioButton optionRadio = new JRadioButton();
	JLabel assignmentContentLabel = new JLabel();
	JComboBox<Rectangle> optionCombo = new JComboBox<>();
	JButton optionViewButton = new JButton();
	JButton optionAddButton = new JButton();
	JButton buttonChangeCourse = new JButton();
	JButton buttonLogout = new JButton();

	public CourseMenu() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		setModal(true);
		setSize(600, 350);
	}

	private void jbInit() throws Exception {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
		buttonChangeCourse.setText("Change course");
		buttonChangeCourse.setBounds(new Rectangle(100, 210, 120, 37));
		buttonChangeCourse.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonChangeCourseActionPerformed(e);
			}
		});
		this.getContentPane().setLayout(null);
		this.setTitle("");
		buttonLogout.setText("Logout");
		buttonLogout.setBounds(new Rectangle(290, 210, 90, 37));
		buttonLogout.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonLogoutActionPerformed(e);
			}
		});
		this.getContentPane().add(buttonChangeCourse, null);
		this.getContentPane().add(buttonLogout, null);
	}

	/*
	 * When the add button is pressed, call add assignment function of facade, after
	 * that refresh window
	 */

	abstract void showMenu(Course theCourse);
	abstract void showAddButtons();
	abstract void showViewButtons();
	abstract void showRadios();
	abstract void showComboxes();
	abstract void showLabel();

	void assignmentAddButtonActionPerformed(ActionEvent e) {
		Hacs.theFacade.addAssignment(theCourse);
		refresh();
	}

	void assignmentViewButtonActionPerformed(ActionEvent e) {
		Assignment theAss = (Assignment) assignmentCombox.getSelectedItem();
		Hacs.theFacade.viewAssignment(theAss);
	}

	void refresh() {
		assignmentCombox.removeAllItems();
		if (theCourse == null) {
			return;
		}
		Iterator<Assignment> Iter = theCourse.assignmentList.iterator();
		while (Iter.hasNext()) {
			assignmentCombox.addItem(Iter.next());
		}
	}

	void buttonChangeCourseActionPerformed(ActionEvent e) {
		bLogout = false;
		setVisible(false);
	}

	void buttonLogoutActionPerformed(ActionEvent e) {
		bLogout = true;
		setVisible(false);
	}

	boolean ifLogout() {
		return bLogout;
	}
}