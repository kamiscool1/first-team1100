package displaygrid.apps;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

public class TextBannerServerFrame extends javax.swing.JFrame {

    public TextBannerServerFrame() {
        initComponents();
        font = new Font(Font.MONOSPACED, Font.BOLD, panel.getHeight()/2);
        setVisible(true);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        panel = new JPanel(){
            public void paint(Graphics g){
                paintPanel(g);
            }
        };
        messageField = new javax.swing.JTextField();
        bgcolorButton = new javax.swing.JButton();
        textcolorButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        speedSlider = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 138, Short.MAX_VALUE)
        );

        messageField.setText("Go Team 1100!");

        bgcolorButton.setText("Background");
        bgcolorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bgcolorButtonActionPerformed(evt);
            }
        });

        textcolorButton.setText("Text");

        jLabel1.setText("Message:");

        jLabel2.setText("Color:");

        speedSlider.setMaximum(50);
        speedSlider.setValue(10);

        jLabel3.setText("Speed:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(speedSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bgcolorButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textcolorButton)
                        .addGap(0, 180, Short.MAX_VALUE))
                    .addComponent(messageField))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(messageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textcolorButton)
                    .addComponent(bgcolorButton)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(speedSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(21, 21, 21))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bgcolorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bgcolorButtonActionPerformed
    }//GEN-LAST:event_bgcolorButtonActionPerformed

    public void paintPanel(Graphics g){
        g.setColor(bgColor);
        g.fillRect(0,0,panel.getWidth(), panel.getHeight());
        g.setColor(textColor);
        g.setFont(font);
        Rectangle target = new Rectangle(0, 0, panel.getWidth(), panel.getHeight());
        Rectangle2D text = g.getFontMetrics().getStringBounds(message, g);
        
        int tx = (int) ((target.width-text.getWidth())/2);        
        int cy = (target.height) - (int) (target.height - text.getHeight()) / 2 - target.height / 5;
        g.drawString(message, tx, cy);
    }
    
    public void setPanelDisplay(String m, Color bg, Color text){
        message = m;
        font = scaleFont(message, panel.getBounds(), panel.getGraphics(), font);
        bgColor = bg;
        textColor = text;
    }
    
    public Font scaleFont(String text, Rectangle rect, Graphics g, Font pFont) {
        float fontSize = 2.0f;
        Font f = g.getFont().deriveFont(1);
        while(g.getFontMetrics(f).stringWidth(text) < rect.width && g.getFontMetrics(f).getHeight() < rect.getHeight()){
            fontSize++;
            f = f.deriveFont(fontSize-1);
        }
        return f.deriveFont(fontSize-1);
    }
    
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TextBannerServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TextBannerServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TextBannerServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TextBannerServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TextBannerServerFrame().setVisible(true);
            }
        });
    }
    
    private String message = "";
    private Font font;
    private Color bgColor;
    private Color textColor;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bgcolorButton;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JTextField messageField;
    public javax.swing.JPanel panel;
    public javax.swing.JSlider speedSlider;
    public javax.swing.JButton textcolorButton;
    // End of variables declaration//GEN-END:variables
}
