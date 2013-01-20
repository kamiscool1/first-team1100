/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package displaygrid.log;

import javax.swing.JFrame;

/**
 *
 * @author Akshay
 */
public class LogPanel extends javax.swing.JPanel implements ILogOutput {

    /**
     * Creates new form LogPanel
     */
    public LogPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        logArea = new javax.swing.JTextArea();
        logCheck = new javax.swing.JCheckBox();
        logClear = new javax.swing.JButton();

        logArea.setEditable(false);
        logArea.setColumns(20);
        logArea.setRows(5);
        jScrollPane1.setViewportView(logArea);

        logCheck.setSelected(true);
        logCheck.setText("Logging Enabled");
        logCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logCheckActionPerformed(evt);
            }
        });

        logClear.setText("Clear");
        logClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logClear))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logCheck)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(logClear)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void logCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logCheckActionPerformed
        logEnabled = logCheck.isSelected();
    }//GEN-LAST:event_logCheckActionPerformed

    private void logClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logClearActionPerformed
        logArea.setText("");
    }//GEN-LAST:event_logClearActionPerformed

    public void log(String s){
        if(logEnabled){
            logArea.setText(logArea.getText()+"\n"+s);      
        }
    }
    
    public static void main(String[] args){
        JFrame f = new JFrame();
        f.add(new LogPanel());
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    
    private boolean logEnabled = true;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea logArea;
    private javax.swing.JCheckBox logCheck;
    private javax.swing.JButton logClear;
    // End of variables declaration//GEN-END:variables
}