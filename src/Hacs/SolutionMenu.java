package Hacs;

import javax.swing.*;

/*
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author mjfindler
 * @version 2.0
 * @author Sukhpreet Singh Anand
 * @version 3.0
 * 
 * Update to Java 8
 */

public class SolutionMenu extends JDialog {

	private static final long serialVersionUID = 1L;

	public SolutionMenu() {
	}

	void ShowMenu(Solution theSolution) {
		SolutionGradingDlg dlg = new SolutionGradingDlg();
		dlg.show(theSolution);
	}
}