package hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;


/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author Swetha Ganapathy
 * @version 3.0 update to Java 11
 */

@SuppressWarnings("ALL")
abstract class CourseMenu extends JDialog {
    final int a = 503, b = 294, c = 101, d = 211;
    final int n = 150;
    final int f = 32;
    final int g = 272;
    Course theCourse;
    boolean bLogout = true;

    JRadioButton assignmentRadio = new JRadioButton();
    JComboBox assignmentCombox = new JComboBox();
    JButton assignmentViewButton = new JButton();
    JButton assignmentAddButton = new JButton();
    JRadioButton optionRadio = new JRadioButton();
    JLabel assignmentContentLable = new JLabel();
    JComboBox optionCombo = new JComboBox();
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
        setTitle("Assignment");
        setModal(true);
        setSize(a, b);
        setLocationRelativeTo(null);
    }

    private void jbInit() throws Exception {
        buttonChangeCourse.setText("ChangeCourse");
        buttonChangeCourse.setBounds(new Rectangle(c, d, n, f));
        buttonChangeCourse.addActionListener(e -> buttonChangeCourseActionPerformed(e));
        this.getContentPane().setLayout(null);
        this.setTitle("");
        buttonLogout.setText("Logout");
        buttonLogout.setBounds(new Rectangle(g, d, c, f));
        buttonLogout.addActionListener(e -> buttonLogoutActionPerformed(e));
        this.getContentPane().add(buttonChangeCourse, null);
        this.getContentPane().add(buttonLogout, null);
    }

    /*** when the add button is pressed, call add assignment
     function of facade, after that refresh window
     when the add button is pressed, call ViewAssignment
     function of facade, after that refresh window
     ***/

    abstract void showMenu(Course course);
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
        Iterator iter = theCourse.assignmentList.iterator();
        while (iter.hasNext()) {
            assignmentCombox.addItem(iter.next());
        }
    }

    void buttonChangeCourseActionPerformed(ActionEvent e) {
        bLogout = false;
        this.setVisible(false);
    }

    void buttonLogoutActionPerformed(ActionEvent e) {
        bLogout = true;
        this.setVisible(false);
    }
    boolean ifLogout() {
        return bLogout;
    }
}
