
package View;

import javax.swing.JOptionPane;


public class DialogRGB extends javax.swing.JDialog {

    public boolean cancel = true;
    public int red, green, blue;
    public DialogRGB(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelRed = new javax.swing.JLabel();
        jSliderRed = new javax.swing.JSlider();
        jLabelGreen = new javax.swing.JLabel();
        jSliderGreen = new javax.swing.JSlider();
        jLabelBlue = new javax.swing.JLabel();
        jSliderBlue = new javax.swing.JSlider();
        jButton1 = new javax.swing.JButton();
        jTextFieldRed = new javax.swing.JTextField();
        jTextFieldGreen = new javax.swing.JTextField();
        jTextFieldBlue = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabelRed.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabelRed.setForeground(new java.awt.Color(255, 0, 0));
        jLabelRed.setText("Red:");

        jSliderRed.setBackground(new java.awt.Color(255, 255, 255));
        jSliderRed.setMaximum(256);
        jSliderRed.setMinimum(1);
        jSliderRed.setPaintLabels(true);
        jSliderRed.setPaintTicks(true);
        jSliderRed.setSnapToTicks(true);
        jSliderRed.setValue(128);
        jSliderRed.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderRedStateChanged(evt);
            }
        });

        jLabelGreen.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabelGreen.setForeground(new java.awt.Color(0, 255, 0));
        jLabelGreen.setText("Green:");

        jSliderGreen.setBackground(new java.awt.Color(255, 255, 255));
        jSliderGreen.setMaximum(256);
        jSliderGreen.setMinimum(1);
        jSliderGreen.setPaintLabels(true);
        jSliderGreen.setPaintTicks(true);
        jSliderGreen.setSnapToTicks(true);
        jSliderGreen.setValue(128);
        jSliderGreen.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderGreenStateChanged(evt);
            }
        });

        jLabelBlue.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabelBlue.setForeground(new java.awt.Color(0, 0, 255));
        jLabelBlue.setText("Blue:");

        jSliderBlue.setBackground(new java.awt.Color(255, 255, 255));
        jSliderBlue.setMaximum(256);
        jSliderBlue.setMinimum(1);
        jSliderBlue.setPaintLabels(true);
        jSliderBlue.setPaintTicks(true);
        jSliderBlue.setSnapToTicks(true);
        jSliderBlue.setValue(128);
        jSliderBlue.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderBlueStateChanged(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextFieldRed.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jTextFieldRed.setText("128");
        jTextFieldRed.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextFieldRedCaretUpdate(evt);
            }
        });
        jTextFieldRed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldRedKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldRedKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldRedKeyTyped(evt);
            }
        });

        jTextFieldGreen.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jTextFieldGreen.setText("128");
        jTextFieldGreen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldGreenKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldGreenKeyTyped(evt);
            }
        });

        jTextFieldBlue.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jTextFieldBlue.setText("128");
        jTextFieldBlue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBlueKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldBlueKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSliderBlue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSliderGreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelBlue)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldBlue, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelGreen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldGreen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSliderRed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelRed)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldRed, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRed)
                    .addComponent(jTextFieldRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSliderRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabelGreen))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldGreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSliderGreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelBlue)
                    .addComponent(jTextFieldBlue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSliderBlue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSliderRedStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderRedStateChanged
        this.jTextFieldRed.setText(String.valueOf(this.jSliderRed.getValue()));
    }//GEN-LAST:event_jSliderRedStateChanged

    private void jSliderGreenStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderGreenStateChanged
        this.jTextFieldGreen.setText(String.valueOf(this.jSliderGreen.getValue()));
    }//GEN-LAST:event_jSliderGreenStateChanged

    private void jSliderBlueStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderBlueStateChanged
        this.jTextFieldBlue.setText(String.valueOf(this.jSliderBlue.getValue()));
    }//GEN-LAST:event_jSliderBlueStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(this.jTextFieldRed.getText().equals("") || this.jTextFieldGreen.getText().equals("") || this.jTextFieldBlue.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Campo vazio!");
            return;
        }
        this.red = this.jSliderRed.getValue();
        this.green = this.jSliderGreen.getValue();
        this.blue = this.jSliderBlue.getValue();
        this.cancel=false;
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldRedCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextFieldRedCaretUpdate
        
    }//GEN-LAST:event_jTextFieldRedCaretUpdate

    private void jTextFieldRedKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRedKeyTyped
       
    }//GEN-LAST:event_jTextFieldRedKeyTyped

    private void jTextFieldGreenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldGreenKeyTyped
        
    }//GEN-LAST:event_jTextFieldGreenKeyTyped

    private void jTextFieldBlueKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBlueKeyTyped
        
    }//GEN-LAST:event_jTextFieldBlueKeyTyped

    private void jTextFieldRedKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRedKeyPressed
        
    }//GEN-LAST:event_jTextFieldRedKeyPressed

    private void jTextFieldRedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRedKeyReleased
        if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }
        try{
            if(Integer.parseInt(this.jTextFieldRed.getText())>256){
                this.jTextFieldRed.setText("256");
            }
            this.jSliderRed.setValue(Integer.parseInt(this.jTextFieldRed.getText()));
        }
        catch(NumberFormatException e){}
    }//GEN-LAST:event_jTextFieldRedKeyReleased

    private void jTextFieldGreenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldGreenKeyReleased
        if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }
        try{
            if(Integer.parseInt(this.jTextFieldGreen.getText())>256){
                this.jTextFieldGreen.setText("256");
            }
            this.jSliderGreen.setValue(Integer.parseInt(this.jTextFieldGreen.getText()));
        }
        catch(NumberFormatException e){}
    }//GEN-LAST:event_jTextFieldGreenKeyReleased

    private void jTextFieldBlueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBlueKeyReleased
        if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }
        try{
            if(Integer.parseInt(this.jTextFieldBlue.getText())>256){
                this.jTextFieldBlue.setText("256");
            }
            this.jSliderBlue.setValue(Integer.parseInt(this.jTextFieldBlue.getText()));
        }
        catch(NumberFormatException e){}
    }//GEN-LAST:event_jTextFieldBlueKeyReleased

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(DialogRGB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogRGB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogRGB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogRGB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogRGB dialog = new DialogRGB(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabelBlue;
    private javax.swing.JLabel jLabelGreen;
    private javax.swing.JLabel jLabelRed;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider jSliderBlue;
    private javax.swing.JSlider jSliderGreen;
    private javax.swing.JSlider jSliderRed;
    private javax.swing.JTextField jTextFieldBlue;
    private javax.swing.JTextField jTextFieldGreen;
    private javax.swing.JTextField jTextFieldRed;
    // End of variables declaration//GEN-END:variables
}
