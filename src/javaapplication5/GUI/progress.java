package javaapplication5.GUI;

import java.awt.Color;
import java.math.BigDecimal;
import javax.swing.UIManager;

public class progress extends javax.swing.JFrame {

    float currMoney = 0;

    BigDecimal famount = BigDecimal.ZERO;

    BigDecimal pamount = BigDecimal.ZERO;

    public progress() {
        initComponents();
    }

    public progress(float currValue, BigDecimal pamount, BigDecimal famount) {
        initComponents();
        this.pamount = pamount;
        this.famount = famount;
        this.currMoney = currValue;
        System.out.println("pamount = " + pamount.toString());
        System.out.println("famount = " + famount.toString());
        System.out.println("currValue = " + currValue);
        double pam, fam;
        pam = Double.parseDouble(this.pamount.toString());
        fam = Double.parseDouble(this.famount.toString());
        fam *= 100;
        fam /= pam;
        System.out.println(fam);
        jProgressBar1.setValue((int) fam);
        jProgressBar1.setStringPainted(true);
        currMoneyLabel.setText(Float.toString(currValue));
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        currMoneyLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jProgressBar1.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar1.setFont(new java.awt.Font("Tahoma", 1, 18));
        jProgressBar1.setBorder(new javax.swing.border.MatteBorder(null));
        currMoneyLabel.setFont(new java.awt.Font("Tahoma", 1, 35));
        currMoneyLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        currMoneyLabel.setText("0");
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 35));
        jLabel2.setText("$");
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel3.setText("План бюджета 2019");
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(53, 53, 53).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel4).addComponent(jLabel3).addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(jPanel1Layout.createSequentialGroup().addComponent(currMoneyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))).addContainerGap(49, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(94, 94, 94).addComponent(jLabel3).addGap(18, 18, 18).addComponent(jLabel4).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(44, 44, 44).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(currMoneyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)).addContainerGap(65, Short.MAX_VALUE)));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(0, 0, Short.MAX_VALUE)));
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(progress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(progress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(progress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(progress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new progress().setVisible(true);
            }
        });
    }

    private javax.swing.JLabel currMoneyLabel;

    private javax.swing.JLabel jLabel2;

    private javax.swing.JLabel jLabel3;

    private javax.swing.JLabel jLabel4;

    private javax.swing.JPanel jPanel1;

    private javax.swing.JProgressBar jProgressBar1;

}
