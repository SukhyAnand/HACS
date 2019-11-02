package Hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author Sukhpreet Singh Anand
 * @version 2.0
 */

public class CourseSelectDlg extends JDialog {

	private static final long serialVersionUID = 1L;
	
	/*
	 * 0: High level presentation 
	 * 1: Low level presentation
	 */
	ClassCourseList theCourseList;
	Course selectedCourse;
	int nCourseLevel = 0;
	boolean mbLogout = false;
	JComboBox<Course> courseNameCom = new JComboBox<>();
	JRadioButton highLevelRadio = new JRadioButton();
	JRadioButton lowLevelRadio = new JRadioButton();
	JLabel jLabel1 = new JLabel();
	JButton okButton = new JButton();
	ButtonGroup buttonGroup1 = new ButtonGroup();
	JButton buttonLogout = new JButton();

	public CourseSelectDlg() {
		try {
			jbInit();
			setSize(420, 238);
			setModal(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
		this.getContentPane().setLayout(null);
		courseNameCom.setBounds(new Rectangle(155, 41, 203, 22));
		highLevelRadio.setText("High level");
		highLevelRadio.setBounds(new Rectangle(50, 87, 103, 26));
		lowLevelRadio.setToolTipText("");
		lowLevelRadio.setSelected(true);
		lowLevelRadio.setText("Low level");
		lowLevelRadio.setBounds(new Rectangle(236, 88, 103, 26));
		jLabel1.setText("Course name");
		jLabel1.setBounds(new Rectangle(39, 44, 85, 18));
		okButton.setText("OK");
		okButton.setBounds(new Rectangle(78, 140, 90, 30));
		okButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OKButtonActionPerformed(e);
			}
		});
		buttonLogout.setText("Logout");
		buttonLogout.setBounds(new Rectangle(224, 140, 90, 31));
		buttonLogout.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonLogout_actionPerformed(e);
			}
		});
		this.getContentPane().add(courseNameCom, null);
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(highLevelRadio, null);
		this.getContentPane().add(lowLevelRadio, null);
		this.getContentPane().add(okButton, null);
		this.getContentPane().add(buttonLogout, null);
		buttonGroup1.add(highLevelRadio);
		buttonGroup1.add(lowLevelRadio);
	}

	/*
	 * show the theCourseList in a combox Show the Course type selection button
	 * return the pointer pointing to the Course object return the Course Type
	 */

	public Course ShowDlg(ClassCourseList courseList) {

		theCourseList = courseList;
		CourseIterator theIterator = new CourseIterator(theCourseList);
		Course theCourse;
		while ((theCourse = (Course) theIterator.next()) != null) /// end of the list
		{
			courseNameCom.addItem(theCourse);
		}
		setVisible(true);
		return selectedCourse;
	}

	void OKButtonActionPerformed(ActionEvent e) {
		selectedCourse = (Course) courseNameCom.getSelectedItem();
		if (highLevelRadio.isSelected()) {
			nCourseLevel = CourseLevel.HIGH_LEVEL_COURSE.ordinal(); // High Level course: 0
		} else {
			nCourseLevel = CourseLevel.LOW_LEVEL_COURSE.ordinal(); // Low level course: 1
		}
		setVisible(false);
	}

	public boolean isLogout() {
		return mbLogout;
	}

	void buttonLogout_actionPerformed(ActionEvent e) {
		mbLogout = true;
		setVisible(false);
	}
}