package hacs;
import javax.swing.*;
/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 * @author mjfindler
 * @version 1.0
 * @author Swetha Ganapathy
 * @version 2.0
 */

abstract class AssignmentMenu extends JDialog {
    final int len = 575;
    final int height = 330;
    abstract void showMenu(Assignment ass, Person per);
    public AssignmentMenu() {
        setTitle("Add Assignment");
        setModal(true);
        setSize(len, height);
        setLocationRelativeTo(null);
    }
}
