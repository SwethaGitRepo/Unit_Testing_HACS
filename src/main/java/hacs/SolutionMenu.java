package hacs;

import javax.swing.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zhang ji Zhu Wei
 * @version 1.0
 *
 * @author mjfindler
 * @version 2.0
 *
 * Update to Java 8
 * @author Swetha Ganapathy
 * @version 3.0 update to Java 11
 */

public class SolutionMenu extends JDialog {

    public SolutionMenu() {
    }

    void showMenu(Solution theSolution) {
        setVisible(true);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
    }

}
