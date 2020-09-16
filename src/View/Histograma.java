
package View;

import Model.Imagem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Paint;
import java.awt.image.Raster;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;
import org.jfree.data.xy.IntervalXYDataset;

public class Histograma extends javax.swing.JDialog {

    private static final int MAX_NC = 256;
    private HistogramDataset dataset;
    private XYBarRenderer renderer;
    Imagem imagem = null;
    boolean equalizado = false;
    public Histograma(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Histograma e equalização");
        this.jPanelRGB.setVisible(false);
    }
    
    public void setImagem(Imagem imagem){
        this.imagem = imagem;
        this.createChartPanel();
    }
    
    private void createChartPanel() {
        dataset = new HistogramDataset();
        Raster raster = imagem.getBuffer().getRaster();
        final int w = imagem.getBuffer().getWidth();
        final int h = imagem.getBuffer().getHeight();
        double[] r = new double[w * h];
        r = raster.getSamples(0, 0, w, h, 0, r);
        dataset.addSeries("Red", r, MAX_NC);
        r = raster.getSamples(0, 0, w, h, 1, r);
        dataset.addSeries("Green", r, MAX_NC);
        r = raster.getSamples(0, 0, w, h, 2, r);
        dataset.addSeries("Blue", r, MAX_NC);
        JFreeChart chart = ChartFactory.createHistogram(
            "Histogram", 
            "Value",
            "Count", 
            dataset, 
            PlotOrientation.VERTICAL, 
            true, 
            true, 
            false
        );
        XYPlot plot = (XYPlot) chart.getPlot();
        this.renderer = (XYBarRenderer) plot.getRenderer();
        this.renderer.setBarPainter(new StandardXYBarPainter());
        Paint[] paintArray = {
            new Color(0x80ff0000, true),
            new Color(0x8000ff00, true),
            new Color(0x800000ff, true)
        };
        plot.setDrawingSupplier(new DefaultDrawingSupplier(
            paintArray,
            DefaultDrawingSupplier.DEFAULT_FILL_PAINT_SEQUENCE,
            DefaultDrawingSupplier.DEFAULT_OUTLINE_PAINT_SEQUENCE,
            DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE,
            DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE,
            DefaultDrawingSupplier.DEFAULT_SHAPE_SEQUENCE));
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setMouseWheelEnabled(true);
        chartPanel.setSize(607, 486);
        this.jPanelHistograma.removeAll();
        this.jPanelHistograma.add(chartPanel, BorderLayout.CENTER);
        this.jPanelHistograma.updateUI();
        this.jLabelImagem.setIcon(imagem.getIcon());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBG = new javax.swing.JPanel();
        jLabelImagem = new javax.swing.JLabel();
        jButtonEqualizar = new javax.swing.JButton();
        jPanelHistograma = new javax.swing.JPanel();
        jPanelRGB = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldRed = new javax.swing.JTextField();
        jTextFieldGreen = new javax.swing.JTextField();
        jTextFieldBlue = new javax.swing.JTextField();
        jPanelColor = new javax.swing.JPanel();
        jPanelControl = new javax.swing.JPanel();
        jCheckBoxRed = new javax.swing.JCheckBox();
        jCheckBoxGreen = new javax.swing.JCheckBox();
        jCheckBoxBlue = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelBG.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBG.setPreferredSize(new java.awt.Dimension(600, 600));

        jLabelImagem.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabelImagemMouseMoved(evt);
            }
        });
        jLabelImagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelImagemMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelImagemMouseReleased(evt);
            }
        });

        jButtonEqualizar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonEqualizar.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jButtonEqualizar.setText("Equalizar");
        jButtonEqualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEqualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEqualizarActionPerformed(evt);
            }
        });

        jPanelHistograma.setBackground(new java.awt.Color(255, 255, 255));
        jPanelHistograma.setPreferredSize(new java.awt.Dimension(627, 489));

        javax.swing.GroupLayout jPanelHistogramaLayout = new javax.swing.GroupLayout(jPanelHistograma);
        jPanelHistograma.setLayout(jPanelHistogramaLayout);
        jPanelHistogramaLayout.setHorizontalGroup(
            jPanelHistogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanelHistogramaLayout.setVerticalGroup(
            jPanelHistogramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        jPanelRGB.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRGB.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Red");

        jLabel5.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 0));
        jLabel5.setText("Green");

        jLabel6.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 255));
        jLabel6.setText("Blue");

        jTextFieldRed.setEditable(false);
        jTextFieldRed.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jTextFieldGreen.setEditable(false);
        jTextFieldGreen.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jTextFieldBlue.setEditable(false);
        jTextFieldBlue.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanelColorLayout = new javax.swing.GroupLayout(jPanelColor);
        jPanelColor.setLayout(jPanelColorLayout);
        jPanelColorLayout.setHorizontalGroup(
            jPanelColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );
        jPanelColorLayout.setVerticalGroup(
            jPanelColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelRGBLayout = new javax.swing.GroupLayout(jPanelRGB);
        jPanelRGB.setLayout(jPanelRGBLayout);
        jPanelRGBLayout.setHorizontalGroup(
            jPanelRGBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRGBLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanelRGBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRGBLayout.createSequentialGroup()
                        .addComponent(jTextFieldRed, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldGreen, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelRGBLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelRGBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldBlue, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanelColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanelRGBLayout.setVerticalGroup(
            jPanelRGBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRGBLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelRGBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelRGBLayout.createSequentialGroup()
                        .addGroup(jPanelRGBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelRGBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldGreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldBlue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10))
        );

        jPanelControl.setBackground(new java.awt.Color(255, 255, 255));

        jCheckBoxRed.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxRed.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jCheckBoxRed.setForeground(new java.awt.Color(255, 0, 0));
        jCheckBoxRed.setSelected(true);
        jCheckBoxRed.setText("Red");
        jCheckBoxRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxRedActionPerformed(evt);
            }
        });

        jCheckBoxGreen.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxGreen.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jCheckBoxGreen.setForeground(new java.awt.Color(0, 255, 51));
        jCheckBoxGreen.setSelected(true);
        jCheckBoxGreen.setText("Green");
        jCheckBoxGreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxGreenActionPerformed(evt);
            }
        });

        jCheckBoxBlue.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxBlue.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jCheckBoxBlue.setForeground(new java.awt.Color(0, 0, 255));
        jCheckBoxBlue.setSelected(true);
        jCheckBoxBlue.setText("Blue");
        jCheckBoxBlue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxBlueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelControlLayout = new javax.swing.GroupLayout(jPanelControl);
        jPanelControl.setLayout(jPanelControlLayout);
        jPanelControlLayout.setHorizontalGroup(
            jPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelControlLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jCheckBoxRed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxGreen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBoxBlue)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanelControlLayout.setVerticalGroup(
            jPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelControlLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxRed)
                    .addComponent(jCheckBoxGreen)
                    .addComponent(jCheckBoxBlue))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelBGLayout = new javax.swing.GroupLayout(jPanelBG);
        jPanelBG.setLayout(jPanelBGLayout);
        jPanelBGLayout.setHorizontalGroup(
            jPanelBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBGLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelHistograma, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelRGB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 19, Short.MAX_VALUE))
            .addGroup(jPanelBGLayout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(jPanelControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonEqualizar)
                .addGap(84, 84, 84))
        );
        jPanelBGLayout.setVerticalGroup(
            jPanelBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBGLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelHistograma, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelBGLayout.createSequentialGroup()
                        .addComponent(jPanelRGB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabelImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBGLayout.createSequentialGroup()
                        .addComponent(jPanelControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(jPanelBGLayout.createSequentialGroup()
                        .addComponent(jButtonEqualizar)
                        .addGap(20, 20, 20))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBG, javax.swing.GroupLayout.PREFERRED_SIZE, 895, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBG, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEqualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEqualizarActionPerformed
        this.imagem.equalizar();
        this.createChartPanel();
        this.equalizado = true;
    }//GEN-LAST:event_jButtonEqualizarActionPerformed

    private void jLabelImagemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImagemMouseReleased
    }//GEN-LAST:event_jLabelImagemMouseReleased

    private void jLabelImagemMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImagemMouseMoved
        try{
            int x = (int) evt.getPoint().getX(), y = (int) evt.getPoint().getY();
            Color color = imagem.getRGB(x, y);
            this.jTextFieldRed.setText(String.valueOf(color.getRed()));
            this.jTextFieldGreen.setText(String.valueOf(color.getGreen()));
            this.jTextFieldBlue.setText(String.valueOf(color.getBlue()));
            this.jPanelColor.setBackground(color);
            this.jPanelRGB.setVisible(true);
        }
        catch(Exception e){}
    }//GEN-LAST:event_jLabelImagemMouseMoved

    private void jLabelImagemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImagemMouseExited
        this.jPanelRGB.setVisible(false);
    }//GEN-LAST:event_jLabelImagemMouseExited

    private void jCheckBoxRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxRedActionPerformed
        this.renderer.setSeriesVisible(0, jCheckBoxRed.isSelected());
    }//GEN-LAST:event_jCheckBoxRedActionPerformed

    private void jCheckBoxGreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxGreenActionPerformed
        this.renderer.setSeriesVisible(1, jCheckBoxGreen.isSelected());
    }//GEN-LAST:event_jCheckBoxGreenActionPerformed

    private void jCheckBoxBlueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxBlueActionPerformed
        this.renderer.setSeriesVisible(2, jCheckBoxBlue.isSelected());
    }//GEN-LAST:event_jCheckBoxBlueActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Histograma dialog = new Histograma(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonEqualizar;
    private javax.swing.JCheckBox jCheckBoxBlue;
    private javax.swing.JCheckBox jCheckBoxGreen;
    private javax.swing.JCheckBox jCheckBoxRed;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelImagem;
    private javax.swing.JPanel jPanelBG;
    private javax.swing.JPanel jPanelColor;
    private javax.swing.JPanel jPanelControl;
    private javax.swing.JPanel jPanelHistograma;
    private javax.swing.JPanel jPanelRGB;
    private javax.swing.JTextField jTextFieldBlue;
    private javax.swing.JTextField jTextFieldGreen;
    private javax.swing.JTextField jTextFieldRed;
    // End of variables declaration//GEN-END:variables
}
