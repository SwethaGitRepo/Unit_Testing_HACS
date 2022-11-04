package hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 *
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author Swetha Ganapathy
 * @version 3.0 update to Java 11
 */

public class SolutionGradingDlg extends JDialog {
    final int l1 = 316, l2 = 186, l3 = 23, l4 = 30;
    final int l5 = 121, l6 = 18, l7 = 25, l8 = 66;
    final int l9 = 100, l10 = 22, l11 = 217, l12 = 67;
    final int l13 = 79, l14 = 29, l15 = 212, l16 = 34;
    final int l17 = 163, l18 = 18;
    Solution theSolution;
    JLabel jLabel1 = new JLabel();
    JTextField tfGrad = new JTextField();
    JButton buttonOK = new JButton();
    JLabel labelSolutionFileName = new JLabel();

    public SolutionGradingDlg() {
        try {
            jbInit();
            setSize(l1, l2);
            setLocationRelativeTo(null);
            setTitle("Provide Solution");
            setModal(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() {
        jLabel1.setText("Solution File Name");
        jLabel1.setBounds(new Rectangle(l3, l4, l5, l6));
        this.getContentPane().setLayout(null);
        tfGrad.setBounds(new Rectangle(l7, l8, l9, l10));
        buttonOK.setText("OK");
        buttonOK.setBounds(new Rectangle(l11, l12, l13, l14));
        buttonOK.addActionListener(this::buttonOkActionPerformed);
        labelSolutionFileName.setBounds(new Rectangle(l15, l16, l17, l18));
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(tfGrad, null);
        this.getContentPane().add(labelSolutionFileName, null);
        this.getContentPane().add(buttonOK, null);
    }

    void show(Solution solution) {
        theSolution = solution;
        tfGrad.setText("" + theSolution.getGradeInt());
        labelSolutionFileName.setText(theSolution.solutionFileName);
        setVisible(true);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
    }

    void buttonOkActionPerformed(ActionEvent e) {
        theSolution.theGrade = Integer.parseInt(tfGrad.getText());
        setVisible(false);
    }

}
