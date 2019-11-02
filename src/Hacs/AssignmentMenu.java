package Hacs;

import javax.swing.*;

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

abstract public class AssignmentMenu extends JDialog {
	
	private static final long serialVersionUID = 1L;

	abstract void showMenu(Assignment ass, Person per);
  
	public AssignmentMenu() {
		setModal(true);
		setSize(575, 330);
	}
}