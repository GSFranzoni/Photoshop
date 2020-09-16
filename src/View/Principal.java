package View;

import Model.Operacoes;
import Model.Imagem;
import com.sun.javafx.iio.ImageMetadata;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Principal extends javax.swing.JFrame {

    public int x_pos_ini = -1, y_pos_ini = -1, x_pos_fim = -1, y_pos_fim = -1;

    public Map<String, String> help = new HashMap<>();

    public boolean pixelize = false;
    public boolean applyingEffect = false;
    public boolean pow = false;
    public Operacoes operations;
    private JLabel labels[];
    private int selected_img = 0;

    public Principal() {
        initComponents();
        this.jPanelGamma.setVisible(false);
        this.gerenciar_botoes(false);
        this.jPanelRGB.setVisible(false);
        this.jButtonCancelPix.setVisible(false);
        this.operations = new Operacoes();
        this.labels = new JLabel[]{
            this.jLabelImage1,
            this.jLabelImage2,
            this.jLabelImage3
        };
        this.setLocationRelativeTo(null);
    }

    public Component getComponent() {
        return this;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBG = new javax.swing.JPanel();
        jButtonNegative = new javax.swing.JButton();
        jButtonEspelhoH = new javax.swing.JButton();
        jButtonEspelhoV = new javax.swing.JButton();
        jButtonRotacao90direita = new javax.swing.JButton();
        jButtonRotacao90esquerda = new javax.swing.JButton();
        jButtonRotacao180 = new javax.swing.JButton();
        jButtonPotencia = new javax.swing.JButton();
        jButtonLog = new javax.swing.JButton();
        jButtonRaiz = new javax.swing.JButton();
        jButtonAmostragem = new javax.swing.JButton();
        jButtonQuantizacao = new javax.swing.JButton();
        jButtonHistograma = new javax.swing.JButton();
        jButtonLogInverso = new javax.swing.JButton();
        jPanelImagens = new javax.swing.JPanel();
        jPanelImagem1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelImage1 = new javax.swing.JLabel();
        jButtonArquivo1 = new javax.swing.JButton();
        jLabelVoltar1 = new javax.swing.JLabel();
        jLabelAvancar1 = new javax.swing.JLabel();
        jLabelRefresh1 = new javax.swing.JLabel();
        jLabelDelete1 = new javax.swing.JLabel();
        jPanelImagem2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabelImage2 = new javax.swing.JLabel();
        jButtonArquivo2 = new javax.swing.JButton();
        jLabelVoltar2 = new javax.swing.JLabel();
        jLabelAvancar2 = new javax.swing.JLabel();
        jLabelRefresh2 = new javax.swing.JLabel();
        jLabelDelete2 = new javax.swing.JLabel();
        jPanelImagem3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabelImage3 = new javax.swing.JLabel();
        jLabelVoltar3 = new javax.swing.JLabel();
        jLabelAvancar3 = new javax.swing.JLabel();
        jLabelRefresh3 = new javax.swing.JLabel();
        jLabelDelete3 = new javax.swing.JLabel();
        jButtonSoma = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanelRGB = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldRed = new javax.swing.JTextField();
        jTextFieldGreen = new javax.swing.JTextField();
        jTextFieldBlue = new javax.swing.JTextField();
        jPanelColor = new javax.swing.JPanel();
        jPanelGamma = new javax.swing.JPanel();
        jSliderGamma = new javax.swing.JSlider();
        jLabel8 = new javax.swing.JLabel();
        jLabelGammaPow1 = new javax.swing.JLabel();
        jLabelDescartarGamma = new javax.swing.JLabel();
        jLabelAplicarGamma = new javax.swing.JLabel();
        jButtonMediana = new javax.swing.JButton();
        jButtonMedia = new javax.swing.JButton();
        jButtonModa = new javax.swing.JButton();
        jButtonMax = new javax.swing.JButton();
        jButtonMin = new javax.swing.JButton();
        jButtonExpansao = new javax.swing.JButton();
        jButtonCompressao = new javax.swing.JButton();
        jButtonPrewitt = new javax.swing.JButton();
        jButtonSobel = new javax.swing.JButton();
        jButtonGray = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButtonGaussian = new javax.swing.JButton();
        jButtonPixelize = new javax.swing.JButton();
        jButtonCancelPix = new javax.swing.JButton();
        jButtonMotion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanelBG.setBackground(new java.awt.Color(255, 255, 255));

        jButtonNegative.setBackground(new java.awt.Color(255, 255, 255));
        jButtonNegative.setForeground(new java.awt.Color(51, 102, 255));
        jButtonNegative.setText("Negativo");
        jButtonNegative.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonNegative.setPreferredSize(new java.awt.Dimension(150, 32));
        jButtonNegative.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButtonNegativeMouseMoved(evt);
            }
        });
        jButtonNegative.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNegativeActionPerformed(evt);
            }
        });

        jButtonEspelhoH.setBackground(new java.awt.Color(255, 255, 255));
        jButtonEspelhoH.setForeground(new java.awt.Color(51, 102, 255));
        jButtonEspelhoH.setText("Espelho H.");
        jButtonEspelhoH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEspelhoH.setPreferredSize(new java.awt.Dimension(150, 32));
        jButtonEspelhoH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEspelhoHActionPerformed(evt);
            }
        });

        jButtonEspelhoV.setBackground(new java.awt.Color(255, 255, 255));
        jButtonEspelhoV.setForeground(new java.awt.Color(51, 102, 255));
        jButtonEspelhoV.setText("Espelho V.");
        jButtonEspelhoV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEspelhoV.setPreferredSize(new java.awt.Dimension(150, 32));
        jButtonEspelhoV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEspelhoVActionPerformed(evt);
            }
        });

        jButtonRotacao90direita.setBackground(new java.awt.Color(255, 255, 255));
        jButtonRotacao90direita.setForeground(new java.awt.Color(51, 102, 255));
        jButtonRotacao90direita.setText("Rotação 90º dir");
        jButtonRotacao90direita.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRotacao90direita.setPreferredSize(new java.awt.Dimension(150, 32));
        jButtonRotacao90direita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRotacao90direitaActionPerformed(evt);
            }
        });

        jButtonRotacao90esquerda.setBackground(new java.awt.Color(255, 255, 255));
        jButtonRotacao90esquerda.setForeground(new java.awt.Color(51, 102, 255));
        jButtonRotacao90esquerda.setText("Rotação 90º esq");
        jButtonRotacao90esquerda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRotacao90esquerda.setPreferredSize(new java.awt.Dimension(150, 32));
        jButtonRotacao90esquerda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRotacao90esquerdaActionPerformed(evt);
            }
        });

        jButtonRotacao180.setBackground(new java.awt.Color(255, 255, 255));
        jButtonRotacao180.setForeground(new java.awt.Color(51, 102, 255));
        jButtonRotacao180.setText("Rotação 180º");
        jButtonRotacao180.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRotacao180.setPreferredSize(new java.awt.Dimension(150, 32));
        jButtonRotacao180.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRotacao180ActionPerformed(evt);
            }
        });

        jButtonPotencia.setBackground(new java.awt.Color(255, 255, 255));
        jButtonPotencia.setForeground(new java.awt.Color(51, 102, 255));
        jButtonPotencia.setText("Potência");
        jButtonPotencia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonPotencia.setPreferredSize(new java.awt.Dimension(150, 32));
        jButtonPotencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPotenciaActionPerformed(evt);
            }
        });

        jButtonLog.setBackground(new java.awt.Color(255, 255, 255));
        jButtonLog.setForeground(new java.awt.Color(51, 102, 255));
        jButtonLog.setText("Log");
        jButtonLog.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonLog.setPreferredSize(new java.awt.Dimension(150, 32));
        jButtonLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogActionPerformed(evt);
            }
        });

        jButtonRaiz.setBackground(new java.awt.Color(255, 255, 255));
        jButtonRaiz.setForeground(new java.awt.Color(51, 102, 255));
        jButtonRaiz.setText("Raiz");
        jButtonRaiz.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRaiz.setPreferredSize(new java.awt.Dimension(150, 32));
        jButtonRaiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRaizActionPerformed(evt);
            }
        });

        jButtonAmostragem.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAmostragem.setForeground(new java.awt.Color(51, 102, 255));
        jButtonAmostragem.setText("Amostragem");
        jButtonAmostragem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAmostragem.setPreferredSize(new java.awt.Dimension(150, 32));
        jButtonAmostragem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAmostragemActionPerformed(evt);
            }
        });

        jButtonQuantizacao.setBackground(new java.awt.Color(255, 255, 255));
        jButtonQuantizacao.setForeground(new java.awt.Color(51, 102, 255));
        jButtonQuantizacao.setText("Quantização");
        jButtonQuantizacao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonQuantizacao.setPreferredSize(new java.awt.Dimension(150, 32));
        jButtonQuantizacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuantizacaoActionPerformed(evt);
            }
        });

        jButtonHistograma.setBackground(new java.awt.Color(255, 255, 255));
        jButtonHistograma.setForeground(new java.awt.Color(51, 102, 255));
        jButtonHistograma.setText("Histograma");
        jButtonHistograma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonHistograma.setPreferredSize(new java.awt.Dimension(150, 32));
        jButtonHistograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHistogramaActionPerformed(evt);
            }
        });

        jButtonLogInverso.setBackground(new java.awt.Color(255, 255, 255));
        jButtonLogInverso.setForeground(new java.awt.Color(51, 102, 255));
        jButtonLogInverso.setText("Log inverso");
        jButtonLogInverso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonLogInverso.setPreferredSize(new java.awt.Dimension(150, 32));
        jButtonLogInverso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogInversoActionPerformed(evt);
            }
        });

        jPanelImagens.setBackground(new java.awt.Color(255, 255, 255));

        jPanelImagem1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelImagem1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 255), 2, true));
        jPanelImagem1.setForeground(new java.awt.Color(255, 255, 255));
        jPanelImagem1.setMaximumSize(new java.awt.Dimension(300, 400));
        jPanelImagem1.setPreferredSize(new java.awt.Dimension(300, 400));
        jPanelImagem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelImagem1MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setText("Imagem 1");

        jLabelImage1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabelImage1MouseMoved(evt);
            }
        });
        jLabelImage1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelImage1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelImage1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelImage1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelImage1MouseReleased(evt);
            }
        });
        jLabelImage1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jLabelImage1CaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jLabelImage1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jLabelImage1PropertyChange(evt);
            }
        });

        jButtonArquivo1.setBackground(new java.awt.Color(255, 255, 255));
        jButtonArquivo1.setForeground(new java.awt.Color(0, 102, 255));
        jButtonArquivo1.setText("Abrir arquivo");
        jButtonArquivo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonArquivo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonArquivo1ActionPerformed(evt);
            }
        });

        jLabelVoltar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/undo.png"))); // NOI18N
        jLabelVoltar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelVoltar1.setEnabled(false);
        jLabelVoltar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelVoltar1MouseClicked(evt);
            }
        });

        jLabelAvancar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/redo.png"))); // NOI18N
        jLabelAvancar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAvancar1.setEnabled(false);
        jLabelAvancar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAvancar1MouseClicked(evt);
            }
        });

        jLabelRefresh1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/refresh.png"))); // NOI18N
        jLabelRefresh1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRefresh1.setEnabled(false);
        jLabelRefresh1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRefresh1MouseClicked(evt);
            }
        });

        jLabelDelete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/delete.png"))); // NOI18N
        jLabelDelete1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDelete1.setEnabled(false);
        jLabelDelete1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDelete1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelImagem1Layout = new javax.swing.GroupLayout(jPanelImagem1);
        jPanelImagem1.setLayout(jPanelImagem1Layout);
        jPanelImagem1Layout.setHorizontalGroup(
            jPanelImagem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelImagem1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanelImagem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanelImagem1Layout.createSequentialGroup()
                        .addComponent(jLabelDelete1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelRefresh1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelVoltar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelAvancar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonArquivo1))
                    .addComponent(jLabelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelImagem1Layout.setVerticalGroup(
            jPanelImagem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelImagem1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanelImagem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelRefresh1)
                    .addComponent(jLabelDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelVoltar1)
                    .addComponent(jLabelAvancar1)
                    .addComponent(jButtonArquivo1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelImagem2.setBackground(new java.awt.Color(255, 255, 255));
        jPanelImagem2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelImagem2.setMaximumSize(new java.awt.Dimension(300, 400));
        jPanelImagem2.setPreferredSize(new java.awt.Dimension(300, 400));
        jPanelImagem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelImagem2MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 102, 255));
        jLabel2.setText("Imagem 2");
        jLabel2.setPreferredSize(new java.awt.Dimension(150, 32));

        jLabelImage2.setForeground(new java.awt.Color(51, 102, 255));
        jLabelImage2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabelImage2MouseMoved(evt);
            }
        });
        jLabelImage2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelImage2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelImage2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelImage2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelImage2MouseReleased(evt);
            }
        });
        jLabelImage2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jLabelImage2PropertyChange(evt);
            }
        });

        jButtonArquivo2.setBackground(new java.awt.Color(255, 255, 255));
        jButtonArquivo2.setForeground(new java.awt.Color(0, 102, 255));
        jButtonArquivo2.setText("Abrir arquivo");
        jButtonArquivo2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonArquivo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonArquivo2ActionPerformed(evt);
            }
        });

        jLabelVoltar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/undo.png"))); // NOI18N
        jLabelVoltar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelVoltar2.setEnabled(false);
        jLabelVoltar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelVoltar2MouseClicked(evt);
            }
        });

        jLabelAvancar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/redo.png"))); // NOI18N
        jLabelAvancar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAvancar2.setEnabled(false);

        jLabelRefresh2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/refresh.png"))); // NOI18N
        jLabelRefresh2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRefresh2.setEnabled(false);
        jLabelRefresh2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRefresh2MouseClicked(evt);
            }
        });

        jLabelDelete2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/delete.png"))); // NOI18N
        jLabelDelete2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDelete2.setEnabled(false);
        jLabelDelete2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDelete2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelImagem2Layout = new javax.swing.GroupLayout(jPanelImagem2);
        jPanelImagem2.setLayout(jPanelImagem2Layout);
        jPanelImagem2Layout.setHorizontalGroup(
            jPanelImagem2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelImagem2Layout.createSequentialGroup()
                .addGroup(jPanelImagem2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelImagem2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanelImagem2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelImagem2Layout.createSequentialGroup()
                                .addComponent(jLabelDelete2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelRefresh2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelVoltar2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelAvancar2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonArquivo2))))
                    .addGroup(jPanelImagem2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelImagem2Layout.setVerticalGroup(
            jPanelImagem2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelImagem2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelImagem2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelRefresh2)
                    .addComponent(jLabelVoltar2)
                    .addComponent(jLabelAvancar2)
                    .addComponent(jLabelDelete2)
                    .addComponent(jButtonArquivo2))
                .addGap(27, 27, 27))
        );

        jPanelImagem3.setBackground(new java.awt.Color(255, 255, 255));
        jPanelImagem3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelImagem3.setMaximumSize(new java.awt.Dimension(300, 400));
        jPanelImagem3.setPreferredSize(new java.awt.Dimension(300, 400));
        jPanelImagem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelImagem3MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 102, 255));
        jLabel3.setText("Resultado");

        jLabelImage3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabelImage3MouseMoved(evt);
            }
        });
        jLabelImage3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelImage3MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelImage3MouseExited(evt);
            }
        });
        jLabelImage3.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jLabelImage3PropertyChange(evt);
            }
        });

        jLabelVoltar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/undo.png"))); // NOI18N
        jLabelVoltar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelVoltar3.setEnabled(false);
        jLabelVoltar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelVoltar3MouseClicked(evt);
            }
        });

        jLabelAvancar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/redo.png"))); // NOI18N
        jLabelAvancar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAvancar3.setEnabled(false);

        jLabelRefresh3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/refresh.png"))); // NOI18N
        jLabelRefresh3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRefresh3.setEnabled(false);
        jLabelRefresh3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRefresh3MouseClicked(evt);
            }
        });

        jLabelDelete3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/delete.png"))); // NOI18N
        jLabelDelete3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDelete3.setEnabled(false);
        jLabelDelete3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDelete3MouseClicked(evt);
            }
        });

        jButtonSoma.setBackground(new java.awt.Color(255, 255, 255));
        jButtonSoma.setForeground(new java.awt.Color(51, 102, 255));
        jButtonSoma.setText("Soma");
        jButtonSoma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSoma.setPreferredSize(new java.awt.Dimension(150, 32));
        jButtonSoma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSomaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelImagem3Layout = new javax.swing.GroupLayout(jPanelImagem3);
        jPanelImagem3.setLayout(jPanelImagem3Layout);
        jPanelImagem3Layout.setHorizontalGroup(
            jPanelImagem3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelImagem3Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanelImagem3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelImagem3Layout.createSequentialGroup()
                        .addComponent(jLabelDelete3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelRefresh3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelVoltar3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelAvancar3))
                    .addComponent(jLabelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelImagem3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSoma, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelImagem3Layout.setVerticalGroup(
            jPanelImagem3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelImagem3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanelImagem3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jButtonSoma, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jLabelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelImagem3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelVoltar3)
                    .addGroup(jPanelImagem3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabelDelete3)
                        .addComponent(jLabelRefresh3))
                    .addComponent(jLabelAvancar3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelImagensLayout = new javax.swing.GroupLayout(jPanelImagens);
        jPanelImagens.setLayout(jPanelImagensLayout);
        jPanelImagensLayout.setHorizontalGroup(
            jPanelImagensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelImagensLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelImagem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelImagem2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelImagem3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelImagensLayout.setVerticalGroup(
            jPanelImagensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelImagensLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelImagensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelImagem1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelImagem2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelImagem3, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanelColorLayout.setVerticalGroup(
            jPanelColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelRGBLayout = new javax.swing.GroupLayout(jPanelRGB);
        jPanelRGB.setLayout(jPanelRGBLayout);
        jPanelRGBLayout.setHorizontalGroup(
            jPanelRGBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRGBLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanelRGBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldRed, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelRGBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldGreen, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelRGBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldBlue, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jPanelColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanelRGBLayout.setVerticalGroup(
            jPanelRGBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRGBLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRGBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelRGBLayout.createSequentialGroup()
                        .addGroup(jPanelRGBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(4, 4, 4)
                        .addGroup(jPanelRGBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldGreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldBlue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanelRGB, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 300, -1));

        jPanelGamma.setBackground(new java.awt.Color(255, 255, 255));
        jPanelGamma.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jSliderGamma.setBackground(new java.awt.Color(255, 255, 255));
        jSliderGamma.setValue(22);
        jSliderGamma.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderGammaStateChanged(evt);
            }
        });
        jSliderGamma.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jSliderGammaPropertyChange(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 102, 255));
        jLabel8.setText("Gamma:");

        jLabelGammaPow1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelGammaPow1.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabelGammaPow1.setForeground(new java.awt.Color(51, 102, 255));
        jLabelGammaPow1.setText("2.2");

        jLabelDescartarGamma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/delete.png"))); // NOI18N
        jLabelDescartarGamma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDescartarGamma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDescartarGammaMouseClicked(evt);
            }
        });

        jLabelAplicarGamma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/apply.png"))); // NOI18N
        jLabelAplicarGamma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAplicarGamma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAplicarGammaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelGammaLayout = new javax.swing.GroupLayout(jPanelGamma);
        jPanelGamma.setLayout(jPanelGammaLayout);
        jPanelGammaLayout.setHorizontalGroup(
            jPanelGammaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGammaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGammaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGammaLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelGammaPow1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelGammaLayout.createSequentialGroup()
                        .addComponent(jSliderGamma, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelDescartarGamma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelAplicarGamma)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelGammaLayout.setVerticalGroup(
            jPanelGammaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGammaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelGammaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelDescartarGamma)
                    .addGroup(jPanelGammaLayout.createSequentialGroup()
                        .addGroup(jPanelGammaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelGammaPow1)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSliderGamma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelAplicarGamma))
                .addGap(63, 63, 63))
        );

        jPanel1.add(jPanelGamma, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 74));

        jButtonMediana.setBackground(new java.awt.Color(255, 255, 255));
        jButtonMediana.setForeground(new java.awt.Color(51, 102, 255));
        jButtonMediana.setText("Mediana");
        jButtonMediana.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonMediana.setEnabled(false);
        jButtonMediana.setPreferredSize(new java.awt.Dimension(150, 32));
        jButtonMediana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMedianaActionPerformed(evt);
            }
        });

        jButtonMedia.setBackground(new java.awt.Color(255, 255, 255));
        jButtonMedia.setForeground(new java.awt.Color(51, 102, 255));
        jButtonMedia.setText("Média");
        jButtonMedia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonMedia.setEnabled(false);
        jButtonMedia.setPreferredSize(new java.awt.Dimension(150, 32));
        jButtonMedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMediaActionPerformed(evt);
            }
        });

        jButtonModa.setBackground(new java.awt.Color(255, 255, 255));
        jButtonModa.setForeground(new java.awt.Color(51, 102, 255));
        jButtonModa.setText("Moda");
        jButtonModa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonModa.setEnabled(false);
        jButtonModa.setPreferredSize(new java.awt.Dimension(150, 32));
        jButtonModa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModaActionPerformed(evt);
            }
        });

        jButtonMax.setBackground(new java.awt.Color(255, 255, 255));
        jButtonMax.setForeground(new java.awt.Color(51, 102, 255));
        jButtonMax.setText("Max");
        jButtonMax.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonMax.setEnabled(false);
        jButtonMax.setPreferredSize(new java.awt.Dimension(150, 32));
        jButtonMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMaxActionPerformed(evt);
            }
        });

        jButtonMin.setBackground(new java.awt.Color(255, 255, 255));
        jButtonMin.setForeground(new java.awt.Color(51, 102, 255));
        jButtonMin.setText("Min");
        jButtonMin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonMin.setEnabled(false);
        jButtonMin.setPreferredSize(new java.awt.Dimension(150, 32));
        jButtonMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMinActionPerformed(evt);
            }
        });

        jButtonExpansao.setBackground(new java.awt.Color(255, 255, 255));
        jButtonExpansao.setForeground(new java.awt.Color(51, 102, 255));
        jButtonExpansao.setText("Expansão");
        jButtonExpansao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonExpansao.setEnabled(false);
        jButtonExpansao.setPreferredSize(new java.awt.Dimension(150, 32));
        jButtonExpansao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExpansaoActionPerformed(evt);
            }
        });

        jButtonCompressao.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCompressao.setForeground(new java.awt.Color(51, 102, 255));
        jButtonCompressao.setText("Compressão");
        jButtonCompressao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCompressao.setEnabled(false);
        jButtonCompressao.setPreferredSize(new java.awt.Dimension(150, 32));
        jButtonCompressao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCompressaoActionPerformed(evt);
            }
        });

        jButtonPrewitt.setBackground(new java.awt.Color(255, 255, 255));
        jButtonPrewitt.setForeground(new java.awt.Color(51, 102, 255));
        jButtonPrewitt.setText("Prewitt");
        jButtonPrewitt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonPrewitt.setEnabled(false);
        jButtonPrewitt.setPreferredSize(new java.awt.Dimension(150, 32));
        jButtonPrewitt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrewittActionPerformed(evt);
            }
        });

        jButtonSobel.setBackground(new java.awt.Color(255, 255, 255));
        jButtonSobel.setForeground(new java.awt.Color(51, 102, 255));
        jButtonSobel.setText("Sobel");
        jButtonSobel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSobel.setEnabled(false);
        jButtonSobel.setPreferredSize(new java.awt.Dimension(150, 32));
        jButtonSobel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSobelActionPerformed(evt);
            }
        });

        jButtonGray.setBackground(new java.awt.Color(255, 255, 255));
        jButtonGray.setForeground(new java.awt.Color(51, 102, 255));
        jButtonGray.setText("Gray");
        jButtonGray.setToolTipText("");
        jButtonGray.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonGray.setEnabled(false);
        jButtonGray.setPreferredSize(new java.awt.Dimension(150, 32));
        jButtonGray.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGrayActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setForeground(new java.awt.Color(0, 153, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/info.png"))); // NOI18N
        jLabel7.setText("Sobre  ");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jButtonGaussian.setBackground(new java.awt.Color(255, 255, 255));
        jButtonGaussian.setForeground(new java.awt.Color(51, 102, 255));
        jButtonGaussian.setText("Gaussian");
        jButtonGaussian.setToolTipText("");
        jButtonGaussian.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonGaussian.setPreferredSize(new java.awt.Dimension(150, 32));
        jButtonGaussian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGaussianActionPerformed(evt);
            }
        });

        jButtonPixelize.setBackground(new java.awt.Color(255, 255, 255));
        jButtonPixelize.setForeground(new java.awt.Color(51, 102, 255));
        jButtonPixelize.setText("Pixelize");
        jButtonPixelize.setToolTipText("");
        jButtonPixelize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonPixelize.setPreferredSize(new java.awt.Dimension(150, 32));
        jButtonPixelize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonPixelizeMouseClicked(evt);
            }
        });
        jButtonPixelize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPixelizeActionPerformed(evt);
            }
        });

        jButtonCancelPix.setBackground(new java.awt.Color(255, 0, 0));
        jButtonCancelPix.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCancelPix.setText("Cancelar pixelize");
        jButtonCancelPix.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCancelPix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelPixActionPerformed(evt);
            }
        });

        jButtonMotion.setBackground(new java.awt.Color(255, 255, 255));
        jButtonMotion.setForeground(new java.awt.Color(51, 102, 255));
        jButtonMotion.setText("Motion");
        jButtonMotion.setToolTipText("");
        jButtonMotion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonMotion.setPreferredSize(new java.awt.Dimension(150, 32));
        jButtonMotion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMotionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBGLayout = new javax.swing.GroupLayout(jPanelBG);
        jPanelBG.setLayout(jPanelBGLayout);
        jPanelBGLayout.setHorizontalGroup(
            jPanelBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBGLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBGLayout.createSequentialGroup()
                            .addComponent(jButtonNegative, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonEspelhoH, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonEspelhoV, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonPotencia, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonRaiz, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonLog, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonLogInverso, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelBGLayout.createSequentialGroup()
                            .addComponent(jButtonRotacao90direita, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonRotacao90esquerda, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonRotacao180, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonAmostragem, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonQuantizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonHistograma, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonModa, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelBGLayout.createSequentialGroup()
                        .addGroup(jPanelBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonMax, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelBGLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelBGLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonMin, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelBGLayout.createSequentialGroup()
                                .addComponent(jButtonCancelPix, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonPixelize, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBGLayout.createSequentialGroup()
                                .addComponent(jButtonMediana, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonExpansao, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCompressao, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBGLayout.createSequentialGroup()
                                .addComponent(jButtonMotion, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonGaussian, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonGray, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonPrewitt, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSobel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBGLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelImagens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanelBGLayout.setVerticalGroup(
            jPanelBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBGLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonRaiz, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonEspelhoH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonEspelhoV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonPotencia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonLog, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonLogInverso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonNegative, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRotacao90direita, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRotacao90esquerda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRotacao180, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAmostragem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonQuantizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonHistograma, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonModa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonMax, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMediana, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExpansao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCompressao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSobel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBGLayout.createSequentialGroup()
                        .addGap(0, 20, Short.MAX_VALUE)
                        .addComponent(jLabel7))
                    .addGroup(jPanelBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonPrewitt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonGray, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonGaussian, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonPixelize, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonCancelPix, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonMotion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelImagens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelBG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonArquivo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonArquivo1ActionPerformed
        FileScreen fs = new FileScreen(this, true);
        fs.setVisible(true);
        if (fs.image != null) {
            ImageIcon icon = new ImageIcon(fs.image);
            if(icon.getIconWidth()>256 || icon.getIconWidth()>256) {
                JOptionPane.showMessageDialog(rootPane, "Dimensão de imagem inválida!");
                return;
            }
            this.operations.getStack(0).clear();
            this.operations.setImage(0, new Imagem(fs.image));
            this.labels[0].setIcon(icon);
            this.gerenciar_botoes(true);
        }
        this.gerenciar_icones();
    }//GEN-LAST:event_jButtonArquivo1ActionPerformed

    private void jButtonNegativeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNegativeActionPerformed
        Imagem clone = this.operations.getImage(selected_img).getClone();
        this.operations.setImage(selected_img, clone);
        this.labels[selected_img].setIcon(clone.negative());
    }//GEN-LAST:event_jButtonNegativeActionPerformed

    private void jButtonEspelhoHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEspelhoHActionPerformed
        Imagem clone = this.operations.getImage(selected_img).getClone();
        this.operations.setImage(selected_img, clone);
        this.labels[selected_img].setIcon(clone.espelho_h());
    }//GEN-LAST:event_jButtonEspelhoHActionPerformed

    private void jButtonEspelhoVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEspelhoVActionPerformed
        Imagem clone = this.operations.getImage(selected_img).getClone();
        this.operations.setImage(selected_img, clone);
        this.labels[selected_img].setIcon(clone.espelho_v());
    }//GEN-LAST:event_jButtonEspelhoVActionPerformed

    private void jButtonRotacao90direitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRotacao90direitaActionPerformed
        Imagem clone = this.operations.getImage(selected_img).getClone();
        this.operations.setImage(selected_img, clone);
        this.labels[selected_img].setIcon(clone.rotacao_90_direita());
    }//GEN-LAST:event_jButtonRotacao90direitaActionPerformed

    private void jButtonRotacao90esquerdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRotacao90esquerdaActionPerformed
        Imagem clone = this.operations.getImage(selected_img).getClone();
        this.operations.setImage(selected_img, clone);
        this.labels[selected_img].setIcon(clone.rotacao_90_esquerda());
    }//GEN-LAST:event_jButtonRotacao90esquerdaActionPerformed

    private void jButtonArquivo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonArquivo2ActionPerformed
        FileScreen fs = new FileScreen(this, true);
        fs.setVisible(true);
        if (fs.image != null) {
            ImageIcon icon = new ImageIcon(fs.image);
            if(icon.getIconWidth()>256 || icon.getIconWidth()>256) {
                JOptionPane.showMessageDialog(rootPane, "Dimensão de imagem inválida!");
                return;
            }
            this.operations.getStack(1).clear();
            this.operations.setImage(1, new Imagem(fs.image));
            this.labels[1].setIcon(icon);
            this.gerenciar_botoes(true);
        }
        this.gerenciar_icones();
    }//GEN-LAST:event_jButtonArquivo2ActionPerformed

    private void jLabelImage1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImage1MouseClicked
        if (this.applyingEffect) {
            return;
        }
        this.gerenciar_botoes(this.jLabelImage1.getIcon() != null);
        this.jPanelImagem1.setBorder(new javax.swing.border.LineBorder(new Color(0, 102, 255), 2));
        this.jPanelImagem2.setBorder(new javax.swing.border.EtchedBorder());
        this.jPanelImagem3.setBorder(new javax.swing.border.EtchedBorder());
        this.selected_img = 0;
    }//GEN-LAST:event_jLabelImage1MouseClicked

    private void jLabelImage2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImage2MouseClicked
        if (this.applyingEffect) {
            return;
        }
        this.gerenciar_botoes(this.jLabelImage2.getIcon() != null);
        this.jPanelImagem1.setBorder(new javax.swing.border.EtchedBorder());
        this.jPanelImagem2.setBorder(new javax.swing.border.LineBorder(new Color(0, 102, 255), 2));
        this.jPanelImagem3.setBorder(new javax.swing.border.EtchedBorder());
        this.selected_img = 1;
    }//GEN-LAST:event_jLabelImage2MouseClicked

    private void jLabelImage3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImage3MouseClicked
        if (this.applyingEffect) {
            return;
        }
        this.gerenciar_botoes(this.jLabelImage3.getIcon() != null);
        this.jPanelImagem1.setBorder(new javax.swing.border.EtchedBorder());
        this.jPanelImagem2.setBorder(new javax.swing.border.EtchedBorder());
        this.jPanelImagem3.setBorder(new javax.swing.border.LineBorder(new Color(0, 102, 255), 2));
        this.selected_img = 2;
    }//GEN-LAST:event_jLabelImage3MouseClicked

    private void jButtonRotacao180ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRotacao180ActionPerformed
        Imagem clone = this.operations.getImage(selected_img).getClone();
        this.operations.setImage(selected_img, clone);
        this.labels[selected_img].setIcon(clone.rotacao_180());
    }//GEN-LAST:event_jButtonRotacao180ActionPerformed

    private void jButtonSomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSomaActionPerformed
        //this.jPanelSoma.setVisible(true);

        PercentInput in = new PercentInput(this, true, "Digite a porcentagem da imagem 1", 100);
        in.setVisible(true);

        float perc1;
        if (in.percent != -1) {
            perc1 = in.percent;
        } else {
            return;
        }

        float perc2 = 100 - perc1;

        this.operations.setImage(2, Imagem.soma(this.operations.getImage(0), this.operations.getImage(1), perc1 / 100, perc2 / 100));
        this.labels[2].setIcon(this.operations.getImage(2).getIcon());
    }//GEN-LAST:event_jButtonSomaActionPerformed

    private void jButtonPotenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPotenciaActionPerformed
        Imagem clone = this.operations.getImage(selected_img).getClone();
        this.labels[selected_img].setIcon(clone.potencia(((float) 22 / 10.0f)));
        this.operations.setImage(selected_img, clone);
        this.jSliderGamma.setValue(22);
        this.jPanelGamma.setVisible(true);
        this.applyingEffect = true;
        this.gerenciar_botoes(false);
        this.gerenciar_icones(false);
        this.pow = true;
    }//GEN-LAST:event_jButtonPotenciaActionPerformed

    private void jButtonLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogActionPerformed
        Imagem clone = this.operations.getImage(selected_img).getClone();
        this.operations.setImage(selected_img, clone);
        this.labels[selected_img].setIcon(clone.log());
    }//GEN-LAST:event_jButtonLogActionPerformed

    private void jButtonRaizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRaizActionPerformed
        Imagem clone = this.operations.getImage(selected_img).getClone();
        this.labels[selected_img].setIcon(clone.raiz(((float) this.jSliderGamma.getValue() / 10.0f)));
        this.operations.setImage(selected_img, clone);
        this.jSliderGamma.setValue(22);
        this.applyingEffect = true;
        this.jPanelGamma.setVisible(true);
        this.pow = false;
        this.gerenciar_botoes(false);
        this.gerenciar_icones(false);
    }//GEN-LAST:event_jButtonRaizActionPerformed

    public void ImageMouseMoved(Imagem imagem, MouseEvent evt) {
        try {
            int x = (int) evt.getPoint().getX(), y = (int) evt.getPoint().getY();
            Color color = imagem.getRGB(x, y);
            this.jTextFieldRed.setText(String.valueOf(color.getRed()));
            this.jTextFieldGreen.setText(String.valueOf(color.getGreen()));
            this.jTextFieldBlue.setText(String.valueOf(color.getBlue()));
            this.jPanelColor.setBackground(color);
            this.jPanelRGB.setVisible(true);
        } catch (Exception e) {
        }
    }

    private void jLabelImage1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImage1MouseMoved
        if (!this.operations.getStack(0).isEmpty()) {
            this.ImageMouseMoved(this.operations.getImage(0), evt);
        }
    }//GEN-LAST:event_jLabelImage1MouseMoved

    private void jLabelImage1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImage1MouseExited
        this.jPanelRGB.setVisible(false);
    }//GEN-LAST:event_jLabelImage1MouseExited

    private void jLabelImage2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImage2MouseExited
        this.jPanelRGB.setVisible(false);
    }//GEN-LAST:event_jLabelImage2MouseExited

    private void jLabelImage2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImage2MouseMoved
        if (!this.operations.getStack(1).isEmpty()) {
            this.ImageMouseMoved(this.operations.getImage(1), evt);
        }
    }//GEN-LAST:event_jLabelImage2MouseMoved

    private void jLabelImage3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImage3MouseExited
        this.jPanelRGB.setVisible(false);
    }//GEN-LAST:event_jLabelImage3MouseExited

    private void jLabelImage3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImage3MouseMoved
        if (!this.operations.getStack(2).isEmpty()) {
            this.ImageMouseMoved(this.operations.getImage(2), evt);
        }
    }//GEN-LAST:event_jLabelImage3MouseMoved

    private void jButtonAmostragemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAmostragemActionPerformed
        Imagem clone = this.operations.getImage(selected_img).getClone();
        this.operations.setImage(selected_img, clone);
        int mask;
        try {
            mask = Integer.parseInt(JOptionPane.showInputDialog("Tamanho da máscara: "));
            this.labels[selected_img].setIcon(clone.amostragem(mask));
        } catch (NullPointerException | NumberFormatException e) {
        }
    }//GEN-LAST:event_jButtonAmostragemActionPerformed

    private void jButtonQuantizacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuantizacaoActionPerformed
        Imagem clone = this.operations.getImage(selected_img).getClone();
        this.operations.setImage(selected_img, clone);
        DialogRGB dialog = new DialogRGB(this, true);
        if (!dialog.cancel) {
            this.labels[selected_img].setIcon(clone.quantizacao(dialog.red, dialog.green, dialog.blue));
        }
    }//GEN-LAST:event_jButtonQuantizacaoActionPerformed

    private void jButtonHistogramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHistogramaActionPerformed
        Imagem clone = this.operations.getImage(selected_img).getClone();
        Histograma h = new Histograma(this, true);
        h.setImagem(clone);
        h.setVisible(true);
        if (h.equalizado) {
            clone = h.imagem;
            this.operations.setImage(selected_img, clone);
            this.labels[selected_img].setIcon(clone.getIcon());
        }
    }//GEN-LAST:event_jButtonHistogramaActionPerformed

    private void jButtonLogInversoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogInversoActionPerformed
        Imagem clone = this.operations.getImage(selected_img).getClone();
        this.operations.setImage(selected_img, clone);
        this.labels[selected_img].setIcon(clone.logInverso());
    }//GEN-LAST:event_jButtonLogInversoActionPerformed

    private void jLabelVoltar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVoltar1MouseClicked
        if (this.jLabelVoltar1.isEnabled()) {
            this.operations.popImage(0);
            this.labels[0].setIcon(this.operations.getImage(0).getIcon());
        }
    }//GEN-LAST:event_jLabelVoltar1MouseClicked

    private void jLabelVoltar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVoltar2MouseClicked
        if (this.jLabelVoltar2.isEnabled()) {
            this.operations.popImage(1);
            this.labels[1].setIcon(this.operations.getImage(1).getIcon());
        }
    }//GEN-LAST:event_jLabelVoltar2MouseClicked

    private void jLabelVoltar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVoltar3MouseClicked
        if (this.jLabelVoltar3.isEnabled()) {
            this.operations.popImage(2);
            this.labels[2].setIcon(this.operations.getImage(2).getIcon());
        }
    }//GEN-LAST:event_jLabelVoltar3MouseClicked

    private void jLabelAvancar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAvancar1MouseClicked

    }//GEN-LAST:event_jLabelAvancar1MouseClicked

    private void jLabelRefresh1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRefresh1MouseClicked
        if (this.jLabelRefresh1.isEnabled()) {
            this.operations.refresh(0);
            this.labels[0].setIcon(this.operations.getImage(0).getIcon());
        }
    }//GEN-LAST:event_jLabelRefresh1MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        /*
        try {
            this.operations.setImage(0, new Imagem(ImageIO.read(new File("src\\\\Imagens\\\\default1.bmp"))));
            this.operations.setImage(1, new Imagem(ImageIO.read(new File("src\\\\Imagens\\\\default2.bmp"))));
            this.operations.setImage(2, Imagem.soma(this.operations.getImage(0), this.operations.getImage(1), 1, 1));
            this.labels[0].setIcon(this.operations.getImage(0).getIcon());
            this.labels[1].setIcon(this.operations.getImage(1).getIcon());
            this.labels[2].setIcon(this.operations.getImage(2).getIcon());
        } catch (IOException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
         */
    }//GEN-LAST:event_formWindowOpened

    private void jLabelDelete1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDelete1MouseClicked
        if (this.jLabelDelete1.isEnabled()) {
            this.operations.getStack(0).clear();
            this.labels[0].setIcon(null);
            this.gerenciar_botoes(this.labels[selected_img] != null);
        }
    }//GEN-LAST:event_jLabelDelete1MouseClicked

    private void jLabelDelete2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDelete2MouseClicked
        if (this.jLabelDelete2.isEnabled()) {
            this.operations.getStack(1).clear();
            this.labels[1].setIcon(null);
            this.gerenciar_botoes(this.labels[selected_img] != null);
        }
    }//GEN-LAST:event_jLabelDelete2MouseClicked

    private void jLabelDelete3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDelete3MouseClicked
        if (this.jLabelDelete3.isEnabled()) {
            this.operations.getStack(2).clear();
            this.labels[2].setIcon(null);
            this.gerenciar_botoes(this.labels[selected_img] != null);
        }
    }//GEN-LAST:event_jLabelDelete3MouseClicked

    private void jLabelImage1CaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jLabelImage1CaretPositionChanged

    }//GEN-LAST:event_jLabelImage1CaretPositionChanged

    private void jLabelImage1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jLabelImage1PropertyChange
        this.gerenciar_icones();
    }//GEN-LAST:event_jLabelImage1PropertyChange

    private void jLabelImage2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jLabelImage2PropertyChange
        this.gerenciar_icones();
    }//GEN-LAST:event_jLabelImage2PropertyChange

    private void jLabelImage3PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jLabelImage3PropertyChange
        this.gerenciar_icones();
    }//GEN-LAST:event_jLabelImage3PropertyChange

    private void jLabelRefresh2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRefresh2MouseClicked
        if (this.jLabelRefresh2.isEnabled()) {
            this.operations.refresh(1);
            this.labels[1].setIcon(this.operations.getImage(1).getIcon());
        }
    }//GEN-LAST:event_jLabelRefresh2MouseClicked

    private void jLabelRefresh3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRefresh3MouseClicked
        if (this.jLabelRefresh3.isEnabled()) {
            this.operations.refresh(2);
            this.labels[2].setIcon(this.operations.getImage(2).getIcon());
        }
    }//GEN-LAST:event_jLabelRefresh3MouseClicked

    private void jSliderGammaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderGammaStateChanged
        this.jButtonArquivo1.setEnabled(false);
        this.jButtonArquivo1.setEnabled(false);
        if (this.pow) {
            this.operations.popImage(selected_img);
            Imagem clone = this.operations.getImage(selected_img).getClone();
            this.labels[selected_img].setIcon(clone.potencia(((float) this.jSliderGamma.getValue() / 10.0f)));
            this.operations.setImage(selected_img, clone);
        } else {
            this.operations.popImage(selected_img);
            Imagem clone = this.operations.getImage(selected_img).getClone();
            this.labels[selected_img].setIcon(clone.raiz(((float) this.jSliderGamma.getValue() / 10.0f)));
            this.operations.setImage(selected_img, clone);
        }
        this.jLabelGammaPow1.setText(String.valueOf(this.jSliderGamma.getValue() / 10.0f));
    }//GEN-LAST:event_jSliderGammaStateChanged

    private void jPanelImagem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelImagem1MouseClicked
        this.jLabelImage1MouseClicked(evt);
    }//GEN-LAST:event_jPanelImagem1MouseClicked

    private void jPanelImagem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelImagem2MouseClicked
        this.jLabelImage2MouseClicked(evt);
    }//GEN-LAST:event_jPanelImagem2MouseClicked

    private void jPanelImagem3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelImagem3MouseClicked
        this.jLabelImage3MouseClicked(evt);
    }//GEN-LAST:event_jPanelImagem3MouseClicked

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void jLabelAplicarGammaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAplicarGammaMouseClicked
        this.applyingEffect = false;
        this.jPanelGamma.setVisible(false);
        this.gerenciar_botoes(true);
        this.gerenciar_icones();
    }//GEN-LAST:event_jLabelAplicarGammaMouseClicked

    private void jLabelDescartarGammaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDescartarGammaMouseClicked
        this.operations.popImage(selected_img);
        this.labels[selected_img].setIcon(this.operations.getImage(selected_img).getIcon());
        this.applyingEffect = false;
        this.jPanelGamma.setVisible(false);
        this.gerenciar_botoes(true);
        this.gerenciar_icones();
    }//GEN-LAST:event_jLabelDescartarGammaMouseClicked

    private void jButtonMedianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMedianaActionPerformed
        int size;
        try {
            size = Integer.parseInt(JOptionPane.showInputDialog("Tamanho da máscara: "));
        } catch (NumberFormatException e) {
            return;
        }
        Imagem clone = this.operations.getImage(selected_img).getClone();
        this.operations.setImage(selected_img, clone);
        this.labels[selected_img].setIcon(clone.mediana(size));
    }//GEN-LAST:event_jButtonMedianaActionPerformed

    private void jButtonMediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMediaActionPerformed
        int size;
        try {
            size = Integer.parseInt(JOptionPane.showInputDialog("Tamanho da máscara: "));
        } catch (NumberFormatException e) {
            return;
        }
        Imagem clone = this.operations.getImage(selected_img).getClone();
        this.operations.setImage(selected_img, clone);
        this.labels[selected_img].setIcon(clone.media(size));
    }//GEN-LAST:event_jButtonMediaActionPerformed

    private void jButtonModaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModaActionPerformed
        int size;
        try {
            size = Integer.parseInt(JOptionPane.showInputDialog("Tamanho da máscara: "));
        } catch (NumberFormatException e) {
            return;
        }
        Imagem clone = this.operations.getImage(selected_img).getClone();
        this.operations.setImage(selected_img, clone);
        this.labels[selected_img].setIcon(clone.moda(size));
    }//GEN-LAST:event_jButtonModaActionPerformed

    private void jButtonMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMaxActionPerformed
        int size;
        try {
            size = Integer.parseInt(JOptionPane.showInputDialog("Tamanho da máscara: "));
        } catch (NumberFormatException e) {
            return;
        }
        Imagem clone = this.operations.getImage(selected_img).getClone();
        this.operations.setImage(selected_img, clone);
        this.labels[selected_img].setIcon(clone.max(size));
    }//GEN-LAST:event_jButtonMaxActionPerformed

    private void jButtonMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMinActionPerformed
        int size;
        try {
            size = Integer.parseInt(JOptionPane.showInputDialog("Tamanho da máscara: "));
        } catch (NumberFormatException e) {
            return;
        }
        Imagem clone = this.operations.getImage(selected_img).getClone();
        this.operations.setImage(selected_img, clone);
        this.labels[selected_img].setIcon(clone.min(size));
    }//GEN-LAST:event_jButtonMinActionPerformed

    private void jSliderGammaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jSliderGammaPropertyChange

    }//GEN-LAST:event_jSliderGammaPropertyChange

    private void jButtonExpansaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExpansaoActionPerformed
        FormAB form = new FormAB(this, true);
        form.setTitle("Expansão");
        form.setLabel("y = a*x + b");
        form.setVisible(true);
        if (form.cancel) {
            return;
        }
        Imagem clone = this.operations.getImage(selected_img).getClone();
        this.operations.setImage(selected_img, clone);
        this.labels[selected_img].setIcon(clone.expansao(form.a, form.b));
    }//GEN-LAST:event_jButtonExpansaoActionPerformed

    private void jButtonCompressaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCompressaoActionPerformed
        FormAB form = new FormAB(this, true);
        form.setTitle("Compressão");
        form.setLabel("y = x/a - b");
        form.setVisible(true);
        if (form.cancel) {
            return;
        }
        Imagem clone = this.operations.getImage(selected_img).getClone();
        this.operations.setImage(selected_img, clone);
        this.labels[selected_img].setIcon(clone.compressao(form.a, form.b));
    }//GEN-LAST:event_jButtonCompressaoActionPerformed

    private void jButtonPrewittActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrewittActionPerformed
        Imagem clone = this.operations.getImage(selected_img).getClone();
        this.operations.setImage(selected_img, clone);
        this.labels[selected_img].setIcon(clone.prewitt());
    }//GEN-LAST:event_jButtonPrewittActionPerformed

    private void jButtonSobelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSobelActionPerformed
        Imagem clone = this.operations.getImage(selected_img).getClone();
        this.operations.setImage(selected_img, clone);
        this.labels[selected_img].setIcon(clone.sobel());
    }//GEN-LAST:event_jButtonSobelActionPerformed

    private void jButtonGrayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGrayActionPerformed
        Imagem clone = this.operations.getImage(selected_img).getClone();
        this.operations.setImage(selected_img, clone);
        this.labels[selected_img].setIcon(clone.gray());
    }//GEN-LAST:event_jButtonGrayActionPerformed

    private void jButtonNegativeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonNegativeMouseMoved

    }//GEN-LAST:event_jButtonNegativeMouseMoved

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        (new Sobre(this, true)).setVisible(true);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jButtonGaussianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGaussianActionPerformed
        GaussianInput gaussianIn = new GaussianInput(this, true);
        gaussianIn.setVisible(true);
        if(gaussianIn.kernelSize!=-1 && gaussianIn.sigma!=-1){
            Imagem clone = this.operations.getImage(selected_img).getClone();
            this.operations.setImage(selected_img, clone);
            this.labels[selected_img].setIcon(clone.gaussian(gaussianIn.sigma, gaussianIn.kernelSize));
        }
    }//GEN-LAST:event_jButtonGaussianActionPerformed

    private void jButtonPixelizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPixelizeActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Clique, arraste e solte na área que deseja desfocar!");
        this.pixelize = true;
        this.gerenciar_botoes(false);
        this.gerenciar_icones(false);
        this.jButtonCancelPix.setVisible(true);
    }//GEN-LAST:event_jButtonPixelizeActionPerformed

    private void jButtonPixelizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonPixelizeMouseClicked
    }//GEN-LAST:event_jButtonPixelizeMouseClicked

    private void jLabelImage1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImage1MousePressed
        if (this.pixelize) {
            this.x_pos_ini = evt.getX();
            this.y_pos_ini = evt.getY();
        }
    }//GEN-LAST:event_jLabelImage1MousePressed

    private void jLabelImage1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImage1MouseReleased
        this.pix(0, evt.getX(), evt.getY());
    }//GEN-LAST:event_jLabelImage1MouseReleased

    public void pix(int img, int x, int y) {
        if (this.pixelize) {
            this.x_pos_fim = x;
            this.y_pos_fim = y;

            this.x_pos_fim = this.x_pos_fim > 255 ? 255 : this.x_pos_fim;
            this.y_pos_fim = this.y_pos_fim > 255 ? 255 : this.y_pos_fim;

            try {
                Imagem clone = this.operations.getImage(img).getClone();
                this.operations.setImage(img, clone);

                int mask;
                try {
                    mask = Integer.parseInt(JOptionPane.showInputDialog("Tamanho da máscara: "));
                    this.labels[img].setIcon(clone.pixelize(mask, x_pos_ini, y_pos_ini, x_pos_fim, y_pos_fim));
                } catch (NullPointerException | NumberFormatException e) {
                    System.out.println(e);
                }
            } catch (EmptyStackException e) {
                JOptionPane.showMessageDialog(rootPane, "Imagem inválida!");
            }
            this.gerenciar_icones();
            this.gerenciar_botoes(true);
            this.jButtonCancelPix.setVisible(false);
        }
        this.pixelize = false;
    }

    private void jButtonCancelPixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelPixActionPerformed
        this.gerenciar_icones();
        this.gerenciar_botoes(true);
        this.jButtonCancelPix.setVisible(false);
    }//GEN-LAST:event_jButtonCancelPixActionPerformed

    private void jLabelImage2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImage2MousePressed
        if (this.pixelize) {
            this.x_pos_ini = evt.getX();
            this.y_pos_ini = evt.getY();
        }
    }//GEN-LAST:event_jLabelImage2MousePressed

    private void jLabelImage2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImage2MouseReleased
        this.pix(1, evt.getX(), evt.getY());
    }//GEN-LAST:event_jLabelImage2MouseReleased

    private void jButtonMotionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMotionActionPerformed
        int size;
        try {
            size = Integer.parseInt(JOptionPane.showInputDialog("Tamanho da máscara: "));
        } catch (NumberFormatException e) {
            return;
        }
        Imagem clone = this.operations.getImage(selected_img).getClone();
        this.operations.setImage(selected_img, clone);
        this.labels[selected_img].setIcon(clone.motion(size));
    }//GEN-LAST:event_jButtonMotionActionPerformed

    public void gerenciar_botoes(boolean ativa) {
        this.jButtonMotion.setEnabled(ativa);
        this.jButtonPixelize.setEnabled(ativa);
        this.jButtonGaussian.setEnabled(ativa);
        this.jButtonEspelhoH.setEnabled(ativa);
        this.jButtonEspelhoV.setEnabled(ativa);
        this.jButtonHistograma.setEnabled(ativa);
        this.jButtonLog.setEnabled(ativa);
        this.jButtonLogInverso.setEnabled(ativa);
        this.jButtonNegative.setEnabled(ativa);
        this.jButtonPotencia.setEnabled(ativa);
        this.jButtonQuantizacao.setEnabled(ativa);
        this.jButtonRaiz.setEnabled(ativa);
        this.jButtonRotacao180.setEnabled(ativa);
        this.jButtonRotacao90direita.setEnabled(ativa);
        this.jButtonRotacao90esquerda.setEnabled(ativa);
        this.jButtonMediana.setEnabled(ativa);
        this.jButtonMedia.setEnabled(ativa);
        this.jButtonModa.setEnabled(ativa);
        this.jButtonMax.setEnabled(ativa);
        this.jButtonMin.setEnabled(ativa);
        this.jButtonExpansao.setEnabled(ativa);
        this.jButtonCompressao.setEnabled(ativa);
        this.jButtonPrewitt.setEnabled(ativa);
        this.jButtonSobel.setEnabled(ativa);
        this.jButtonGray.setEnabled(ativa);
        if (ativa && this.jLabelImage1.getIcon() != null && this.jLabelImage2.getIcon() != null) {
            this.jButtonSoma.setEnabled(true);
        } else {
            this.jButtonSoma.setEnabled(false);
        }
        this.jButtonAmostragem.setEnabled(ativa);
    }

    public void gerenciar_icones(boolean ativa) {
        this.jLabelAvancar1.setEnabled(false);
        this.jLabelDelete1.setEnabled(ativa);
        this.jLabelVoltar1.setEnabled(ativa);
        this.jLabelRefresh1.setEnabled(ativa);
        this.jLabelAvancar2.setEnabled(false);
        this.jLabelDelete2.setEnabled(ativa);
        this.jLabelVoltar2.setEnabled(ativa);
        this.jLabelRefresh2.setEnabled(ativa);
        this.jLabelAvancar3.setEnabled(false);
        this.jLabelDelete3.setEnabled(ativa);
        this.jLabelVoltar3.setEnabled(ativa);
        this.jLabelRefresh3.setEnabled(ativa);
        this.jButtonArquivo1.setEnabled(!this.jPanelGamma.isVisible());
        this.jButtonArquivo2.setEnabled(!this.jPanelGamma.isVisible());
    }

    public void gerenciar_icones() {
        if (this.operations == null) {
            return;
        }
        this.jButtonArquivo1.setEnabled(!this.jPanelGamma.isVisible());
        this.jButtonArquivo2.setEnabled(!this.jPanelGamma.isVisible());
        this.jLabelAvancar1.setEnabled(false);
        this.jLabelDelete1.setEnabled(!this.operations.getStack(0).isEmpty());
        this.jLabelVoltar1.setEnabled(this.operations.getStack(0).size() > 1);
        this.jLabelRefresh1.setEnabled(this.operations.getStack(0).size() > 1);
        this.jLabelAvancar2.setEnabled(false);
        this.jLabelDelete2.setEnabled(!this.operations.getStack(1).isEmpty());
        this.jLabelVoltar2.setEnabled(this.operations.getStack(1).size() > 1);
        this.jLabelRefresh2.setEnabled(this.operations.getStack(1).size() > 1);
        this.jLabelAvancar3.setEnabled(false);
        this.jLabelDelete3.setEnabled(!this.operations.getStack(2).isEmpty());
        this.jLabelVoltar3.setEnabled(this.operations.getStack(2).size() > 1);
        this.jLabelRefresh3.setEnabled(this.operations.getStack(2).size() > 1);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAmostragem;
    private javax.swing.JButton jButtonArquivo1;
    private javax.swing.JButton jButtonArquivo2;
    private javax.swing.JButton jButtonCancelPix;
    private javax.swing.JButton jButtonCompressao;
    private javax.swing.JButton jButtonEspelhoH;
    private javax.swing.JButton jButtonEspelhoV;
    private javax.swing.JButton jButtonExpansao;
    private javax.swing.JButton jButtonGaussian;
    private javax.swing.JButton jButtonGray;
    private javax.swing.JButton jButtonHistograma;
    private javax.swing.JButton jButtonLog;
    private javax.swing.JButton jButtonLogInverso;
    private javax.swing.JButton jButtonMax;
    private javax.swing.JButton jButtonMedia;
    private javax.swing.JButton jButtonMediana;
    private javax.swing.JButton jButtonMin;
    private javax.swing.JButton jButtonModa;
    private javax.swing.JButton jButtonMotion;
    private javax.swing.JButton jButtonNegative;
    private javax.swing.JButton jButtonPixelize;
    private javax.swing.JButton jButtonPotencia;
    private javax.swing.JButton jButtonPrewitt;
    private javax.swing.JButton jButtonQuantizacao;
    private javax.swing.JButton jButtonRaiz;
    private javax.swing.JButton jButtonRotacao180;
    private javax.swing.JButton jButtonRotacao90direita;
    private javax.swing.JButton jButtonRotacao90esquerda;
    private javax.swing.JButton jButtonSobel;
    private javax.swing.JButton jButtonSoma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelAplicarGamma;
    private javax.swing.JLabel jLabelAvancar1;
    private javax.swing.JLabel jLabelAvancar2;
    private javax.swing.JLabel jLabelAvancar3;
    private javax.swing.JLabel jLabelDelete1;
    private javax.swing.JLabel jLabelDelete2;
    private javax.swing.JLabel jLabelDelete3;
    private javax.swing.JLabel jLabelDescartarGamma;
    private javax.swing.JLabel jLabelGammaPow1;
    private javax.swing.JLabel jLabelImage1;
    private javax.swing.JLabel jLabelImage2;
    private javax.swing.JLabel jLabelImage3;
    private javax.swing.JLabel jLabelRefresh1;
    private javax.swing.JLabel jLabelRefresh2;
    private javax.swing.JLabel jLabelRefresh3;
    private javax.swing.JLabel jLabelVoltar1;
    private javax.swing.JLabel jLabelVoltar2;
    private javax.swing.JLabel jLabelVoltar3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelBG;
    private javax.swing.JPanel jPanelColor;
    private javax.swing.JPanel jPanelGamma;
    private javax.swing.JPanel jPanelImagem1;
    private javax.swing.JPanel jPanelImagem2;
    private javax.swing.JPanel jPanelImagem3;
    private javax.swing.JPanel jPanelImagens;
    private javax.swing.JPanel jPanelRGB;
    private javax.swing.JSlider jSliderGamma;
    private javax.swing.JTextField jTextFieldBlue;
    private javax.swing.JTextField jTextFieldGreen;
    private javax.swing.JTextField jTextFieldRed;
    // End of variables declaration//GEN-END:variables
}
