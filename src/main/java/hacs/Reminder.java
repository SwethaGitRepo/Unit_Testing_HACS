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

public class Reminder extends JDialog {
    final int l1 = 400, l2 = 386, l3 = 38, l4 = 40;
    final int l5 = 159, l6 = 17, l7 = 39, l8 = 160;
    final int l9 = 161, l10 = 29, l11 = 65, l12 = 340;
    final int l13 = 79, l14 = 31, l15 = 187, l16 = 337;
    final int l17 = 85, l18 = 149, l19 = 308, l20 = 67,  l21 = 37;
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    java.awt.List listUpcoming = new java.awt.List();
    java.awt.List listOverdue = new java.awt.List();
    Button buttonOK = new Button();

    public Reminder() {
        try {
            jbInit();
            setModal(true);
            setSize(l1, l2);
            setLocationRelativeTo(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() {
        jLabel1.setText("Upcoming Assignments");
        jLabel1.setBounds(new Rectangle(l3, l4, l5, l6));
        this.getContentPane().setLayout(null);
        jLabel2.setText("OverDue Assignments");
        jLabel2.setBounds(new Rectangle(l7, l8, l9, l6));
        listUpcoming.setBounds(new Rectangle(l10, l11, l12, l13));
        listOverdue.setBounds(new Rectangle(l14, l15, l16, l17));
        buttonOK.setLabel("OK");
        buttonOK.setBounds(new Rectangle(l18, l19, l20, l21));
        buttonOK.addActionListener(this::buttonOkActionPerformed);
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(listUpcoming, null);
        this.getContentPane().add(listOverdue, null);
        this.getContentPane().add(buttonOK, null);
    }

    void showReminder() {
        ReminderVisitor visitor = new ReminderVisitor(this);
        visitor.visitFacade(Hacs.theFacade);
        setVisible(true);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
    }

    void buttonOkActionPerformed(ActionEvent e) {
        setVisible(false);
    }
}
