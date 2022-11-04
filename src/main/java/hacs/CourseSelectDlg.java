package hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

@SuppressWarnings("ALL")
public class CourseSelectDlg extends JDialog {
    //0 HighLevel presentation 1 LowLevel Experiment
    final int tr = 18, xs = 78, ln = 139, hs = 79;
    final int kl = 29, js = 224, mn = 140, op = 82;
    final int jk = 31, ko = 420, sn = 238, th = 155;
    final int hm = 203, ij = 22, om = 50;
    final int gk = 87, pk = 103, nu = 26, ok = 39;
    final int ik = 44, nm = 85, hj = 236, gj = 88;
    ClassCourseList theCourseList;
    Course selectedCourse;
    int nCourseLevel = 0;
    boolean mbLogout = false;
    JComboBox courseNameCom = new JComboBox();
    JRadioButton highLevelRadio = new JRadioButton();
    JRadioButton lowLevelRadio = new JRadioButton();
    JLabel jLabel1 = new JLabel();
    JButton okButton = new JButton();
    ButtonGroup buttonGroup1 = new ButtonGroup();
    JButton buttonLogout = new JButton();

    public CourseSelectDlg() {
        try {
            jbInit();
            setSize(ko, sn);
            setLocationRelativeTo(null);
            setModal(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout(null);
        courseNameCom.setBounds(new Rectangle(th, kl, hm, ij));
        highLevelRadio.setText("HighLevel");
        highLevelRadio.setBounds(new Rectangle(om, gk, pk, nu));
        lowLevelRadio.setToolTipText("");
        lowLevelRadio.setSelected(true);
        lowLevelRadio.setText("LowLevel");
        lowLevelRadio.setBounds(new Rectangle(hj, gj, pk, nu));
        jLabel1.setText("CourseName");
        jLabel1.setBounds(new Rectangle(ok, ik, nm, tr));
        okButton.setText("OK");
        okButton.setBounds(new Rectangle(xs, ln, hs, jk));
        okButton.addActionListener(e -> okButtonActionPerformed(e));
        buttonLogout.setText("Logout");
        buttonLogout.setBounds(new Rectangle(js, mn, op, jk));
        buttonLogout.addActionListener(e -> buttonLogoutActionPerformed(e));
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

    public Course showDlg(ClassCourseList courseList) {

        theCourseList = courseList;
        CourseIterator theIterator = new CourseIterator(theCourseList);
        Course theCourse;
        while ((theCourse = (Course) theIterator.next()) != null) {
            courseNameCom.addItem(theCourse);
        }
        this.setVisible(true);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        return selectedCourse;
    }

    void okButtonActionPerformed(ActionEvent e) {
        selectedCourse = (Course) courseNameCom.getSelectedItem();
        if (highLevelRadio.isSelected()) {
            nCourseLevel = 0; // highlevel course: 0
        } else {
            nCourseLevel = 1; // lowlevel course: 1
        }
        setVisible(false);
    }

    public boolean isLogout() {
        return mbLogout;
    }

    void buttonLogoutActionPerformed(ActionEvent e) {
        mbLogout = true;
        setVisible(false);
    }
}
