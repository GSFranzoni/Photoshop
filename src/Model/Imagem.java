package Model;

import View.Principal;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
    O buffer image e a classe utilizada para o auxilio do tratamendo dos dados da imagem. 
 */
public class Imagem {

    private BufferedImage buffer;
    private final int MAX_NC = 256;
    private final int WIDTH = 256;
    private final int HEIGHT = 256;

    /*
    O getClone retorna uma copia do objeto sem a referencia de memoria.
     */
    public Imagem getClone() {
        Imagem i = new Imagem();
        BufferedImage buf = new BufferedImage(this.WIDTH, this.HEIGHT, Image.SCALE_DEFAULT);
        for (int x = 0; x < this.WIDTH; x++) {
            for (int y = 0; y < this.HEIGHT; y++) {
                buf.setRGB(x, y, this.buffer.getRGB(x, y));
            }
        }
        i.setBuffer(buf);
        return i;
    }

    /*
        Construtor recebe um objeto do tipo image e seta o buffer de acordo com a imagem recebida.
     */
    public Imagem(Image i) {
        this.buffer = imageToBufferedImage(i);
    }

    public Imagem() {
        this.buffer = new BufferedImage(this.WIDTH, this.HEIGHT, Image.SCALE_DEFAULT);
    }

    public ImageIcon gaussian(double sigma, int kernelsize) {
        double[][] kernel = gaussianKernel(sigma, kernelsize);
        double red, green, blue;
        Color color;
        for (int x = 0; x < this.WIDTH; x++) {
            for (int y = 0; y < this.HEIGHT; y++) {
                red = green = blue = 0;
                for (int i = x - (int) (kernelsize / 2), kx = 0; i <= x + (int) (kernelsize / 2); i++, kx++) {
                    for (int j = y - (int) (kernelsize / 2), ky = 0; j <= y + (int) (kernelsize / 2); j++, ky++) {
                        try {
                            color = new Color(this.buffer.getRGB(i, j));
                            red += (color.getRed() * kernel[kx][ky]);
                            green += (color.getGreen() * kernel[kx][ky]);
                            blue += (color.getBlue() * kernel[kx][ky]);
                        } catch (ArrayIndexOutOfBoundsException e) {}
                    }
                }
                this.buffer.setRGB(x, y, new Color((int) red, (int) green, (int) blue).getRGB());
            }
        }
        return this.getIcon();
    }

    public static double[][] gaussianKernel(double sigma, int kernelsize) {
        double[][] kernel = new double[kernelsize][kernelsize];
        float sum = 0;
        for (int i = 0; i < kernelsize; i++) {
            double x = i - (kernelsize - 1) / 2;
            for (int j = 0; j < kernelsize; j++) {
                double y = j - (kernelsize - 1) / 2;
                kernel[i][j] = 1 / (2 * Math.PI * sigma * sigma) * Math.exp(-(x * x + y * y) / (2 * sigma * sigma));
                sum += kernel[i][j];
            }
        }
        for (int i = 0; i < kernelsize; i++) {
            for (int j = 0; j < kernelsize; j++) {
                kernel[i][j] /= sum;
            }
        }
        return kernel;
    }
    
    public static double[][] motionKernel(int kernelsize) {
        double[][] kernel = new double[kernelsize][kernelsize];
        for (int i = 0; i < kernelsize; i++) {
            for (int j = 0; j < kernelsize; j++) {
                kernel[i][j] = (i==j)? 1: 0;
                System.out.print(kernel[i][j] + " ");
            }
            System.out.println(" ");
        }
        return kernel;
    }
    
    public ImageIcon motion(int kernelsize) {
        double[][] kernel = motionKernel(kernelsize);
        double red, green, blue;
        int count;
        Color color;
        for (int x = 0; x < this.WIDTH; x++) {
            for (int y = 0; y < this.HEIGHT; y++) {
                red = green = blue = count = 0;
                for (int i = x - (int) (kernelsize / 2), kx = 0; i <= x + (int) (kernelsize / 2); i++, kx++) {
                    for (int j = y - (int) (kernelsize / 2), ky = 0; j <= y + (int) (kernelsize / 2); j++, ky++) {
                        try {
                            color = new Color(this.buffer.getRGB(i, j));
                            red += (color.getRed() * kernel[kx][ky]);
                            green += (color.getGreen() * kernel[kx][ky]);
                            blue += (color.getBlue() * kernel[kx][ky]);
                            if(kernel[kx][ky]==1){
                                count++;
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {}
                    }
                }
                this.buffer.setRGB(x, y, new Color((int)(red/count), (int) (green/count), (int) (blue/count)).getRGB());
            }
        }
        return this.getIcon();
    }

    public BufferedImage getBuffer() {
        return buffer;
    }

    public void setBuffer(BufferedImage buffer) {
        this.buffer = buffer;
    }

    /*
        Retorna a cor do pixel X e Y analisados.
     */
    public Color getRGB(int x, int y) {
        return new Color(this.buffer.getRGB(x, y));
    }

    /*
        Retorna o nivel de cinza do pixel X e Y analisados.
     */
    public int getGraylevel(int x, int y) {
        return (this.getRGB(x, y).getRed() + this.getRGB(x, y).getGreen() + this.getRGB(x, y).getBlue()) / 3;
    }

    /*
        Trsanforma o buffer da imagem em icon para setar na Label.
     */
    public ImageIcon getIcon() {
        return new ImageIcon(this.buffer.getScaledInstance(this.WIDTH, this.HEIGHT, Image.SCALE_DEFAULT));
    }

    /*
    * Converte um objeto do tipo Image em BufferedImage
     */
    public static BufferedImage imageToBufferedImage(Image im) {
        BufferedImage bi = new BufferedImage(im.getWidth(null), im.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics bg = bi.getGraphics();
        bg.drawImage(im, 0, 0, null);
        bg.dispose();
        return bi;
    }

    /*
    * Converte um objeto do tipo ImageIcon em BufferedImage 
     */
    public static BufferedImage imageIconToBufferedImage(ImageIcon icon) {
        BufferedImage bi = new BufferedImage(
                icon.getIconWidth(),
                icon.getIconHeight(),
                BufferedImage.TYPE_INT_RGB
        );
        Graphics g = bi.createGraphics();
        icon.paintIcon(null, g, 0, 0);
        g.dispose();
        return bi;
    }

    public ImageIcon pixelize(int mask, int x_ini, int y_ini, int x_fim, int y_fim) {
        int soma_r, soma_g, soma_b, count;
        Color color;
        for (int x = x_ini; x < x_fim; x += mask) {
            for (int y = y_ini; y < y_fim; y += mask) {
                soma_r = 0;
                soma_g = 0;
                soma_b = 0;
                count = 0;
                for (int i = x; i < x + mask; i++) {
                    for (int j = y; j < y + mask; j++) {
                        if (!(i < 0 || j < 0 || i > (x_fim) || j > (y_fim))) {
                            soma_r += this.getRGB(i, j).getRed();
                            soma_g += this.getRGB(i, j).getGreen();
                            soma_b += this.getRGB(i, j).getBlue();
                            count++;
                        }
                    }
                }
                for (int i = x; i < x + mask; i++) {
                    for (int j = y; j < y + mask; j++) {
                        if (!(i < 0 || j < 0 || i > (x_fim) || j > (y_fim))) {
                            color = new Color(
                                (int) ((double) soma_r / (double) count), 
                                (int) ((double) soma_g / (double) count), 
                                (int) ((double) soma_b / (double) count)
                            );
                            this.buffer.setRGB(i, j, color.getRGB());
                        }
                    }
                }
            }
        }
        return this.getIcon();
    }

    /*
    * Faz o calculo do pixel em analise de acordo com o maximo do nivel de cinza da escala (256-1) menos o pixel X e Y analisado dando o efeito da inversao de cores.
     */
    public ImageIcon negative() {
        for (int x = 0; x < this.WIDTH; x++) {
            for (int y = 0; y < this.HEIGHT; y++) {
                this.buffer.setRGB(x, y, new Color((this.MAX_NC - 1) - this.getRGB(x, y).getRed(), (this.MAX_NC - 1) - this.getRGB(x, y).getGreen(), (this.MAX_NC - 1) - this.getRGB(x, y).getBlue()).getRGB());
            }
        }
        return this.getIcon();
    }

    /*
        O efeito de espelhamento na horizontal e realizado devido ao fato de a imagem ser espelhada de acordo com um "espelho" que se encontra na vertical.
     */
    public ImageIcon espelho_h() {
        BufferedImage aux = new BufferedImage(this.buffer.getWidth(), this.buffer.getHeight(), BufferedImage.TYPE_INT_ARGB);
        for (int x = 0; x < this.WIDTH; x++) {
            for (int y = 0; y < this.HEIGHT; y++) {
                aux.setRGB((this.WIDTH - 1) - x, y, this.buffer.getRGB(x, y));
            }
        }
        this.buffer = aux;
        return this.getIcon();
    }

    /*
        O efeito de espelhamento na vertical e realizado devido ao fato de a imagem ser espelhada de acordo com um "espelho" que se encontra na horizontal.
     */
    public ImageIcon espelho_v() {
        BufferedImage aux = new BufferedImage(this.buffer.getWidth(), this.buffer.getHeight(), BufferedImage.TYPE_INT_ARGB);
        for (int x = 0; x < this.WIDTH; x++) {
            for (int y = 0; y < this.HEIGHT; y++) {
                aux.setRGB(x, (this.HEIGHT - 1) - y, this.buffer.getRGB(x, y));
            }
        }
        this.buffer = aux;
        return this.getIcon();
    }

    /*
        A rotação 90° a direita acontece graças ao calculo do pixel origem que sera trocado de posição de acordo com a formula: PX(Altura-1-y,x)= PX(X,Y);
     */
    public ImageIcon rotacao_90_direita() {
        BufferedImage aux = new BufferedImage(this.buffer.getWidth(), this.buffer.getHeight(), BufferedImage.TYPE_INT_ARGB);
        for (int x = 0; x < this.WIDTH; x++) {
            for (int y = 0; y < this.HEIGHT; y++) {
                aux.setRGB((this.HEIGHT - 1) - y, x, this.buffer.getRGB(x, y));
            }
        }
        this.buffer = aux;
        return this.getIcon();
    }

    /*
        A rotação 90° a esquerda acontece graças ao calculo do pixel origem que sera trocado de posição de acordo com a formula: PX(Largura-1-x,y)= PX(X,Y);
     */
    public ImageIcon rotacao_90_esquerda() {
        BufferedImage aux = new BufferedImage(this.WIDTH, this.HEIGHT, BufferedImage.TYPE_INT_ARGB);
        for (int x = 0; x < this.WIDTH; x++) {
            for (int y = 0; y < this.HEIGHT; y++) {
                aux.setRGB(y, (this.WIDTH - 1) - x, this.buffer.getRGB(x, y));
            }
        }
        this.buffer = aux;
        return this.getIcon();
    }

    /*
        A rotação 180° acontece graças ao calculo do pixel origem que sera trocado de posição de acordo com a formula: PX(Largura-1,x), (Altura-1,y) PX(X,Y);
     */
    public ImageIcon rotacao_180() {
        BufferedImage aux = new BufferedImage(this.WIDTH, this.HEIGHT, BufferedImage.TYPE_INT_ARGB);
        for (int x = 0; x < this.WIDTH; x++) {
            for (int y = 0; y < this.HEIGHT; y++) {
                aux.setRGB((this.WIDTH - 1) - x, (this.HEIGHT - 1) - y, this.buffer.getRGB(x, y));
            }
        }
        this.buffer = aux;
        return this.getIcon();
    }

    /*
        A faz o calculo da raiz. 
     */
    public double calculate_root(double base, double n) {
        return (double) Math.pow(Math.E, Math.log(base) / n);
    }

    /*
        Faz o calculo da potencia e seta a mesma para cada canal da imagem.
     */
    public ImageIcon potencia(double gamma) {
        double r, g, b;
        for (int x = 0; x < this.WIDTH; x++) {
            for (int y = 0; y < this.HEIGHT; y++) {
                r = (double) Math.round(Math.pow((this.getRGB(x, y).getRed() / (double) (this.MAX_NC - 1)), gamma) * (double) (this.MAX_NC));
                g = (double) Math.round(Math.pow((this.getRGB(x, y).getGreen() / (double) (this.MAX_NC - 1)), gamma) * (double) (this.MAX_NC));
                b = (double) Math.round(Math.pow((this.getRGB(x, y).getBlue() / (double) (this.MAX_NC - 1)), gamma) * (double) (this.MAX_NC));
                this.buffer.setRGB(x, y, new Color(this.normalize((int) r), this.normalize((int) g), this.normalize((int) r)).getRGB());
            }
        }
        return this.getIcon();
    }

    /*
        Faz o calculo da raiz e seta a mesma para cada canal da imagem.
     */
    public ImageIcon raiz(double gamma) {
        Color color = null;
        double r, g, b;
        for (int x = 0; x < this.WIDTH; x++) {
            for (int y = 0; y < this.HEIGHT; y++) {
                r = (double) Math.round(this.calculate_root((this.getRGB(x, y).getRed() / (double) (this.MAX_NC - 1)), gamma) * (double) (this.MAX_NC));
                g = (double) Math.round(this.calculate_root((this.getRGB(x, y).getGreen() / (double) (this.MAX_NC - 1)), gamma) * (double) (this.MAX_NC));
                b = (double) Math.round(this.calculate_root((this.getRGB(x, y).getBlue() / (double) (this.MAX_NC - 1)), gamma) * (double) (this.MAX_NC));
                this.buffer.setRGB(x, y, new Color(this.normalize((int) r), this.normalize((int) g), this.normalize((int) r)).getRGB());
            }
        }
        return this.getIcon();
    }

    /*
        Faz o calculo do Log e seta o mesma para cada canal da imagem.
     */
    public ImageIcon log() {
        Color color = null;
        int r, g, b, maxRed = this.maxRed(), maxBlue = this.maxBlue(), maxGreen = this.maxGreen();
        for (int x = 0; x < this.WIDTH; x++) {
            for (int y = 0; y < this.HEIGHT; y++) {
                r = (int) Math.round(this.E() * Math.log10(getRGB(x, y).getRed()));
                g = (int) Math.round(this.E() * Math.log10(getRGB(x, y).getGreen()));
                b = (int) Math.round(this.E() * Math.log10(getRGB(x, y).getBlue()));
                this.buffer.setRGB(x, y, new Color(this.normalize(r), this.normalize(g), this.normalize(b)).getRGB());
            }
        }
        return this.getIcon();
    }

    /*
        Faz o calculo do LogInverso e aplica o resultado no pixel analisado.
     */
    public ImageIcon logInverso() {
        Color color = null;
        int r, g, b, maxRed = this.maxRed(), maxBlue = this.maxBlue(), maxGreen = this.maxGreen();
        for (int x = 0; x < this.WIDTH; x++) {
            for (int y = 0; y < this.HEIGHT; y++) {
                r = (int) Math.round(Math.pow(10, (double) this.getRGB(x, y).getRed() / this.E()));
                g = (int) Math.round(Math.pow(10, (double) this.getRGB(x, y).getGreen() / this.E()));
                b = (int) Math.round(Math.pow(10, (double) this.getRGB(x, y).getBlue() / this.E()));
                this.buffer.setRGB(x, y, new Color(this.normalize(r), this.normalize(g), this.normalize(b)).getRGB());
            }
        }
        return this.getIcon();
    }

    /*
        Constante ultilizada no calculo do LogInverso e  da função de Log.
     */
    public double E() {
        return (double) (this.MAX_NC - 1) / (Math.log10((double) MAX_NC - 1));
    }

    /*
        Ajustas as cores que exederam o nivel maximo para os niveis aceitaveis.
     */
    public int normalize(int color) {
        if (color < 0) {
            color = 0;
        } else if (color > (this.MAX_NC - 1)) {
            color = (this.MAX_NC - 1);
        }
        return color;
    }

    /*
       Função onde o histograma da imagem é gerado.
     */
    public double[][] histograma() {
        double[][] histograma = new double[3][this.MAX_NC];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(histograma[i], 0);
        }
        for (int x = 0; x < this.WIDTH; x++) {
            for (int y = 0; y < this.HEIGHT; y++) {
                histograma[0][this.getRGB(x, y).getRed()]++;
                histograma[1][this.getRGB(x, y).getGreen()]++;
                histograma[2][this.getRGB(x, y).getBlue()]++;
            }
        }
        return histograma;
    }

    /*
        Realiza a equalização de modo com que a imagem se mantenha com os niveis de cinza distribuidos.
    
    public ImageIcon equalizar(){
        BufferedImage aux = new BufferedImage(this.WIDTH, this.HEIGHT, BufferedImage.TYPE_INT_ARGB);
        double[][] nk = this.histograma();
        int[][] sk = new int[3][this.MAX_NC];
        double[][] cdf = new double[3][this.MAX_NC];
        double[][] pr = new double[3][this.MAX_NC];
        double[][] rk = new double[3][this.MAX_NC];
        int n = this.WIDTH*this.HEIGHT;
        
        for(int i=0; i<3; i++){
            for(int j=0; j<this.MAX_NC; j++){
                rk[i][j] = j;
                cdf[i][j] = (j==0)?(nk[i][j]):cdf[i][j-1]+(nk[i][j]);
                pr[i][j] = (double)(cdf[i][j]*(double)(this.MAX_NC-1))/(double)n;
                sk[i][j] = (int)Math.round(pr[i][j]);
            }
        }
        int r = 0, g = 0, b = 0;
        for(int x=0; x<this.WIDTH; x++){
            for(int y=0; y<this.HEIGHT; y++){
                r=sk[0][this.getRGB(x, y).getRed()];
                g=sk[1][this.getRGB(x, y).getGreen()];
                b=sk[2][this.getRGB(x, y).getBlue()];
                aux.setRGB(x, y, new Color(r, g, b).getRGB());
            }
        }
        this.buffer = aux;
        return this.getIcon();
    }
    
     */
    public ImageIcon equalizar() {
        BufferedImage aux = new BufferedImage(this.WIDTH, this.HEIGHT, BufferedImage.TYPE_INT_ARGB);

        // NK recebe 3 vetores (1 para cada banda de cor (red, green, blue)) que representa a quantidade de vezes em que os niveis de cinza aparecem na imagem
        double[][] nk = this.histograma();//////////
        double[][] cdf = new double[3][this.MAX_NC];
        int[][] change = new int[3][this.MAX_NC];
        int n = this.WIDTH * this.HEIGHT;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < this.MAX_NC; j++) {
                // A cada iteração o cdf incrementa seu valor de acordo com o valor de NK (sempre normalizando de 0 a 1, dada pela divisão por n)
                cdf[i][j] = (j == 0) ? (nk[i][j] / ((double) n)) : cdf[i][j - 1] + (nk[i][j] / ((double) n));
                // Change recebe o novo valor do nível de cinza j
                change[i][j] = (int) (cdf[i][j] * (this.MAX_NC - 1));
            }
        }

        // Percorre a imagem e seta a cor de acordo com o change
        for (int x = 0; x < this.WIDTH; x++) {
            for (int y = 0; y < this.HEIGHT; y++) {
                aux.setRGB(x, y,
                        new Color(
                                change[0][this.getRGB(x, y).getRed()],
                                change[1][this.getRGB(x, y).getGreen()],
                                change[1][this.getRGB(x, y).getBlue()]
                        ).getRGB()
                );
            }
        }

        this.buffer = aux;
        return this.getIcon();
    }

    /*
        Função de sublista utilizada para auxiliar no desenvolvimento da função de quantização. 
     */
    public static ArrayList<List<Integer>> sublist(ArrayList<Integer> array, int qntd) {
        int size = (int) Math.ceil(array.size() / (double) qntd);
        ArrayList<List<Integer>> partitions = new ArrayList<List<Integer>>();
        for (int i = 0; i < array.size(); i += size) {
            partitions.add(array.subList(i, Math.min(i + size, array.size())));
        }
        List<Integer> sub = null;
        int diff = (qntd - partitions.size());
        for (int i = 0; i < diff; i++) {
            sub = new ArrayList<Integer>(partitions.get(0));
            partitions.remove(0);
            partitions.add(sub.subList(0, sub.size() / 2));
            partitions.add(sub.subList(sub.size() / 2, sub.size()));
        }
        return partitions;
    }

    /*
        Realiza a distribuição dos niveis de cinza de acordo com a quantidade estabelicida pelo usuario.
     */
    public ImageIcon quantizacao(int qntd_r, int qntd_g, int qntd_b) {
        List<Integer> red = new ArrayList<>(), green = new ArrayList<>(), blue = new ArrayList<>();
        Color color = null;
        for (int x = 0; x < this.WIDTH; x++) {
            for (int y = 0; y < this.HEIGHT; y++) {
                color = this.getRGB(x, y);
                if (!red.contains(color.getRed())) {
                    red.add(color.getRed());
                }
                if (!green.contains(color.getGreen())) {
                    green.add(color.getGreen());
                }
                if (!blue.contains(color.getBlue())) {
                    blue.add(color.getBlue());
                }
            }
        }

        if (qntd_r > red.size()) {
            qntd_r = red.size();
            JOptionPane.showMessageDialog(null, "A imagem já possui menos vermelho que o requerido!");
        }
        if (qntd_g > green.size()) {
            qntd_g = green.size();
            JOptionPane.showMessageDialog(null, "A imagem já possui menos verde que o requerido!");
        }
        if (qntd_b > blue.size()) {
            qntd_b = blue.size();
            JOptionPane.showMessageDialog(null, "A imagem já possui menos azul que o requerido!");
        }
        if (qntd_r == red.size() && qntd_g == green.size() && qntd_b == blue.size()) {
            return this.getIcon();
        }

        red.sort(null);
        green.sort(null);
        blue.sort(null);

        ArrayList<List<Integer>> sublists_red = sublist((ArrayList<Integer>) red, qntd_r);
        ArrayList<List<Integer>> sublists_green = sublist((ArrayList<Integer>) green, qntd_g);
        ArrayList<List<Integer>> sublists_blue = sublist((ArrayList<Integer>) blue, qntd_b);

        int r = 0, g = 0, b = 0;

        System.out.println(sublists_red);

        for (int x = 0; x < this.WIDTH; x++) {
            for (int y = 0; y < this.HEIGHT; y++) {
                for (int i = 0; i < sublists_red.size(); i++) {
                    if (sublists_red.get(i).contains(this.getRGB(x, y).getRed())) {
                        r = Estatistica.media(sublists_red.get(i));
                    }
                }
                for (int i = 0; i < sublists_green.size(); i++) {
                    if (sublists_green.get(i).contains(this.getRGB(x, y).getGreen())) {
                        g = Estatistica.media(sublists_green.get(i));
                    }
                }
                for (int i = 0; i < sublists_blue.size(); i++) {
                    if (sublists_blue.get(i).contains(this.getRGB(x, y).getBlue())) {
                        b = Estatistica.media(sublists_blue.get(i));
                    }
                }
                this.buffer.setRGB(x, y, new Color(r, g, b).getRGB());
            }
        }
        return this.getIcon();
    }

    /*
       Função onde uma mascara percorre a imagem e seta a media em todos os pixels.
     */
    public ImageIcon amostragem(int mask) {
        BufferedImage aux = new BufferedImage(this.WIDTH, this.HEIGHT, BufferedImage.TYPE_INT_ARGB);
        int soma_r, soma_g, soma_b, count = 0;
        Color color;
        for (int x = 0; x < this.WIDTH; x += mask) {
            for (int y = 0; y < this.HEIGHT; y += mask) {
                soma_r = 0;
                soma_g = 0;
                soma_b = 0;
                count = 0;
                for (int i = x; i < x + mask; i++) {
                    for (int j = y; j < y + mask; j++) {
                        if (!(i < 0 || j < 0 || i > (this.WIDTH - 1) || j > (this.HEIGHT - 1))) {
                            soma_r += this.getRGB(i, j).getRed();
                            soma_g += this.getRGB(i, j).getGreen();
                            soma_b += this.getRGB(i, j).getBlue();
                            count++;
                        }
                    }
                }
                for (int i = x; i < x + mask; i++) {
                    for (int j = y; j < y + mask; j++) {
                        if (!(i < 0 || j < 0 || i > (this.WIDTH - 1) || j > (this.HEIGHT - 1))) {
                            color = new Color((int) ((double) soma_r / (double) count), (int) ((double) soma_g / (double) count), (int) ((double) soma_b / (double) count));
                            aux.setRGB(i, j, color.getRGB());
                        }
                    }
                }
            }
        }
        this.buffer = aux;
        return this.getIcon();
    }

    /*
        Transforma a imagem em escala de cinza.
     */
    public ImageIcon gray() {
        int nc;
        for (int x = 0; x < this.WIDTH; x++) {
            for (int y = 0; y < this.HEIGHT; y++) {
                nc = Math.round(this.getRGB(x, y).getRed() + this.getRGB(x, y).getGreen() + this.getRGB(x, y).getBlue()) / 3;
                this.buffer.setRGB(x, y, new Color(nc, nc, nc).getRGB());
            }
        }
        return this.getIcon();
    }

    /*
        Função onde uma mascara percorre a imagem fazendo assim a media dos pixels da mascara e seta ponto a ponto com o decorrer da mascara.
     */
    public ImageIcon media(int mask) {
        BufferedImage aux = new BufferedImage(this.WIDTH, this.HEIGHT, BufferedImage.TYPE_INT_ARGB);
        int media_r, media_g, media_b;
        ArrayList<Integer>[] arr = (ArrayList<Integer>[]) new ArrayList[3];
        for (int x = 0; x < this.WIDTH; x++) {
            for (int y = 0; y < this.HEIGHT; y++) {
                arr[0] = new ArrayList<>();
                arr[1] = new ArrayList<>();
                arr[2] = new ArrayList<>();
                for (int i = (mask % 2 == 0) ? x : (int) (x - Math.floor(mask / 2.0f)); i < ((mask % 2 == 0) ? x + mask : (int) Math.floor(x + (mask / 2.0f)) + 1); i++) {
                    for (int j = (mask % 2 == 0) ? y : (int) (y - Math.floor(mask / 2.0f)); j < ((mask % 2 == 0) ? y + mask : (int) Math.floor(y + (mask / 2.0f)) + 1); j++) {
                        if (!(i < 0 || j < 0 || i > (this.WIDTH - 1) || j > (this.HEIGHT - 1))) {
                            arr[0].add(this.getRGB(i, j).getRed());
                            arr[1].add(this.getRGB(i, j).getGreen());
                            arr[2].add(this.getRGB(i, j).getBlue());
                        }
                    }
                }
                media_r = Estatistica.media(arr[0]);
                media_g = Estatistica.media(arr[1]);
                media_b = Estatistica.media(arr[2]);
                aux.setRGB(x, y, new Color(media_r, media_g, media_b).getRGB());
            }
        }
        this.buffer = aux;
        return this.getIcon();
    }

    /*
        Função que armazena os vizinhos de um pixel através de uma máscara de tamanho recebido por parâmetro em uma lista e, através desta lista
        calcula-se a mediana e atribui-se o resultado ao pixel analisado.
     */
    public ImageIcon mediana(int mask) {
        BufferedImage aux = new BufferedImage(this.WIDTH, this.HEIGHT, BufferedImage.TYPE_INT_ARGB);
        int mediana_r, mediana_g, mediana_b;
        ArrayList<Integer>[] arr = (ArrayList<Integer>[]) new ArrayList[3];
        for (int x = 0; x < this.WIDTH; x++) {
            for (int y = 0; y < this.HEIGHT; y++) {
                arr[0] = new ArrayList<>();
                arr[1] = new ArrayList<>();
                arr[2] = new ArrayList<>();
                for (int i = (mask % 2 == 0) ? x : (int) (x - Math.floor(mask / 2.0f)); i < ((mask % 2 == 0) ? x + mask : (int) Math.floor(x + (mask / 2.0f)) + 1); i++) {
                    for (int j = (mask % 2 == 0) ? y : (int) (y - Math.floor(mask / 2.0f)); j < ((mask % 2 == 0) ? y + mask : (int) Math.floor(y + (mask / 2.0f)) + 1); j++) {
                        if (!(i < 0 || j < 0 || i > (this.WIDTH - 1) || j > (this.HEIGHT - 1))) {
                            arr[0].add(this.getRGB(i, j).getRed());
                            arr[1].add(this.getRGB(i, j).getGreen());
                            arr[2].add(this.getRGB(i, j).getBlue());
                        }
                    }
                }
                mediana_r = Estatistica.mediana(arr[0]);
                mediana_g = Estatistica.mediana(arr[1]);
                mediana_b = Estatistica.mediana(arr[2]);
                aux.setRGB(x, y, new Color(mediana_r, mediana_g, mediana_b).getRGB());
            }
        }
        this.buffer = aux;
        return this.getIcon();
    }

    /*
        Função que armazena os vizinhos de um pixel através de uma máscara de tamanho recebido por parâmetro em uma lista e, através desta lista
        calcula-se a moda e atribui-se o resultado ao pixel analisado.
     */
    public ImageIcon moda(int mask) {
        BufferedImage aux = new BufferedImage(this.WIDTH, this.HEIGHT, BufferedImage.TYPE_INT_ARGB);
        int moda_r = 0, moda_g, moda_b;
        ArrayList<Integer>[] arr = (ArrayList<Integer>[]) new ArrayList[3];
        for (int x = 0; x < this.WIDTH; x++) {
            for (int y = 0; y < this.HEIGHT; y++) {
                arr[0] = new ArrayList<>();
                arr[1] = new ArrayList<>();
                arr[2] = new ArrayList<>();
                for (int i = (mask % 2 == 0) ? x : (int) (x - Math.floor(mask / 2.0f)); i < ((mask % 2 == 0) ? x + mask : (int) Math.floor(x + (mask / 2.0f)) + 1); i++) {
                    for (int j = (mask % 2 == 0) ? y : (int) (y - Math.floor(mask / 2.0f)); j < ((mask % 2 == 0) ? y + mask : (int) Math.floor(y + (mask / 2.0f)) + 1); j++) {
                        if (!(i < 0 || j < 0 || i > (this.WIDTH - 1) || j > (this.HEIGHT - 1))) {
                            arr[0].add(this.getRGB(i, j).getRed());
                            arr[1].add(this.getRGB(i, j).getGreen());
                            arr[2].add(this.getRGB(i, j).getBlue());
                        }
                    }
                }
                moda_r = Estatistica.moda(arr[0], this.buffer.getRGB(x, y));
                moda_g = Estatistica.moda(arr[1], this.buffer.getRGB(x, y));
                moda_b = Estatistica.moda(arr[2], this.buffer.getRGB(x, y));
                aux.setRGB(x, y, new Color(moda_r, moda_g, moda_b).getRGB());
            }
        }
        this.buffer = aux;
        return this.getIcon();
    }

    /*
        Função que armazena os vizinhos de um pixel através de uma máscara de tamanho recebido por parâmetro em uma lista e, através desta lista
        calcula-se o valor máximo e atribui-se o resultado ao pixel analisado.
     */
    public ImageIcon max(int mask) {
        BufferedImage aux = new BufferedImage(this.WIDTH, this.HEIGHT, BufferedImage.TYPE_INT_ARGB);
        int max_r, max_g, max_b;
        ArrayList<Integer>[] arr = (ArrayList<Integer>[]) new ArrayList[3];
        for (int x = 0; x < this.WIDTH; x++) {
            for (int y = 0; y < this.HEIGHT; y++) {
                arr[0] = new ArrayList<>();
                arr[1] = new ArrayList<>();
                arr[2] = new ArrayList<>();
                for (int i = (mask % 2 == 0) ? x : (int) (x - Math.floor(mask / 2.0f)); i < ((mask % 2 == 0) ? x + mask : (int) Math.floor(x + (mask / 2.0f)) + 1); i++) {
                    for (int j = (mask % 2 == 0) ? y : (int) (y - Math.floor(mask / 2.0f)); j < ((mask % 2 == 0) ? y + mask : (int) Math.floor(y + (mask / 2.0f)) + 1); j++) {
                        if (!(i < 0 || j < 0 || i > (this.WIDTH - 1) || j > (this.HEIGHT - 1))) {
                            arr[0].add(this.getRGB(i, j).getRed());
                            arr[1].add(this.getRGB(i, j).getGreen());
                            arr[2].add(this.getRGB(i, j).getBlue());
                        }
                    }
                }
                max_r = Estatistica.max(arr[0]);
                max_g = Estatistica.max(arr[1]);
                max_b = Estatistica.max(arr[2]);
                aux.setRGB(x, y, new Color(max_r, max_g, max_b).getRGB());
            }
        }
        this.buffer = aux;
        return this.getIcon();
    }

    /*
        Função que armazena os vizinhos de um pixel através de uma máscara de tamanho recebido por parâmetro em uma lista e, através desta lista
        calcula-se o valor mínimo e atribui-se o resultado ao pixel analisado.
     */
    public ImageIcon min(int mask) {
        BufferedImage aux = new BufferedImage(this.WIDTH, this.HEIGHT, BufferedImage.TYPE_INT_ARGB);
        int min_r, min_g, min_b;
        ArrayList<Integer>[] arr = (ArrayList<Integer>[]) new ArrayList[3];
        for (int x = 0; x < this.WIDTH; x++) {
            for (int y = 0; y < this.HEIGHT; y++) {
                arr[0] = new ArrayList<>();
                arr[1] = new ArrayList<>();
                arr[2] = new ArrayList<>();
                for (int i = (mask % 2 == 0) ? x : (int) (x - Math.floor(mask / 2.0f)); i < ((mask % 2 == 0) ? x + mask : (int) Math.floor(x + (mask / 2.0f)) + 1); i++) {
                    for (int j = (mask % 2 == 0) ? y : (int) (y - Math.floor(mask / 2.0f)); j < ((mask % 2 == 0) ? y + mask : (int) Math.floor(y + (mask / 2.0f)) + 1); j++) {
                        if (!(i < 0 || j < 0 || i > (this.WIDTH - 1) || j > (this.HEIGHT - 1))) {
                            arr[0].add(this.getRGB(i, j).getRed());
                            arr[1].add(this.getRGB(i, j).getGreen());
                            arr[2].add(this.getRGB(i, j).getBlue());
                        }
                    }
                }
                min_r = Estatistica.min(arr[0]);
                min_g = Estatistica.min(arr[1]);
                min_b = Estatistica.min(arr[2]);
                aux.setRGB(x, y, new Color(min_r, min_g, min_b).getRGB());
            }
        }
        this.buffer = aux;
        return this.getIcon();
    }

    /*
        Filtro de expansão calculado ponto a ponto dado pela fórmula: y = a*x+b;
     */
    public ImageIcon expansao(double a, double b) {
        BufferedImage aux = new BufferedImage(this.WIDTH, this.HEIGHT, BufferedImage.TYPE_INT_ARGB);
        int red, green, blue;
        for (int x = 0; x < this.WIDTH; x++) {
            for (int y = 0; y < this.HEIGHT; y++) {
                red = this.normalize((int) (a * this.getRGB(x, y).getRed() + b));
                green = this.normalize((int) (a * this.getRGB(x, y).getGreen() + b));
                blue = this.normalize((int) (a * this.getRGB(x, y).getBlue() + b));
                aux.setRGB(x, y, new Color(red, green, blue).getRGB());
            }
        }
        this.buffer = aux;
        return this.getIcon();
    }

    /*
        Filtro de compressão calculado ponto a ponto dado pela fórmula: y = x/a-b;
     */
    public ImageIcon compressao(double a, double b) {
        BufferedImage aux = new BufferedImage(this.WIDTH, this.HEIGHT, BufferedImage.TYPE_INT_ARGB);
        int red, green, blue;
        for (int x = 0; x < this.WIDTH; x++) {
            for (int y = 0; y < this.HEIGHT; y++) {
                red = this.normalize((int) (this.getRGB(x, y).getRed() / a - b));
                green = this.normalize((int) (this.getRGB(x, y).getGreen() / a - b));
                blue = this.normalize((int) (this.getRGB(x, y).getBlue() / a - b));
                aux.setRGB(x, y, new Color(red, green, blue).getRGB());
            }
        }
        this.buffer = aux;
        return this.getIcon();
    }

    /*
        Filtro passa alta de prewitt utilizado para realce de bordas
     */
    public ImageIcon prewitt() {
        BufferedImage aux = new BufferedImage(this.WIDTH, this.HEIGHT, BufferedImage.TYPE_INT_ARGB);
        int red, green, blue, column0, column2, line0, line2;
        for (int x = 1; x < this.WIDTH - 1; x++) {
            for (int y = 1; y < this.HEIGHT - 1; y++) {
                line0 = this.getRGB(x - 1, y - 1).getRed() + this.getRGB(x, y - 1).getRed() + this.getRGB(x + 1, y - 1).getRed();
                line2 = this.getRGB(x - 1, y + 1).getRed() + this.getRGB(x, y + 1).getRed() + this.getRGB(x + 1, y + 1).getRed();
                column0 = this.getRGB(x - 1, y - 1).getRed() + this.getRGB(x - 1, y).getRed() + this.getRGB(x - 1, y + 1).getRed();
                column2 = this.getRGB(x + 1, y - 1).getRed() + this.getRGB(x + 1, y).getRed() + this.getRGB(x + 1, y + 1).getRed();
                red = this.normalize(Math.abs(line0 - line2) + Math.abs(column0 - column2));

                line0 = this.getRGB(x - 1, y - 1).getGreen() + this.getRGB(x, y - 1).getGreen() + this.getRGB(x + 1, y - 1).getGreen();
                line2 = this.getRGB(x - 1, y + 1).getGreen() + this.getRGB(x, y + 1).getGreen() + this.getRGB(x + 1, y + 1).getGreen();
                column0 = this.getRGB(x - 1, y - 1).getGreen() + this.getRGB(x - 1, y).getGreen() + this.getRGB(x - 1, y + 1).getGreen();
                column2 = this.getRGB(x + 1, y - 1).getGreen() + this.getRGB(x + 1, y).getGreen() + this.getRGB(x + 1, y + 1).getGreen();
                green = this.normalize(Math.abs(line0 - line2) + Math.abs(column0 - column2));

                line0 = this.getRGB(x - 1, y - 1).getBlue() + this.getRGB(x, y - 1).getBlue() + this.getRGB(x + 1, y - 1).getBlue();
                line2 = this.getRGB(x - 1, y + 1).getBlue() + this.getRGB(x, y + 1).getBlue() + this.getRGB(x + 1, y + 1).getBlue();
                column0 = this.getRGB(x - 1, y - 1).getBlue() + this.getRGB(x - 1, y).getBlue() + this.getRGB(x - 1, y + 1).getBlue();
                column2 = this.getRGB(x + 1, y - 1).getBlue() + this.getRGB(x + 1, y).getBlue() + this.getRGB(x + 1, y + 1).getBlue();
                blue = this.normalize(Math.abs(line0 - line2) + Math.abs(column0 - column2));
                aux.setRGB(x, y, new Color(red, green, blue).getRGB());
            }
        }
        this.buffer = aux;
        return this.getIcon();
    }

    /*
        Filtro passa alta de sobel utilizado para realce de bordas
     */
    public ImageIcon sobel() {
        BufferedImage aux = new BufferedImage(this.WIDTH, this.HEIGHT, BufferedImage.TYPE_INT_ARGB);
        int red, green, blue, column0, column2, line0, line2;
        for (int x = 1; x < this.WIDTH - 1; x++) {
            for (int y = 1; y < this.HEIGHT - 1; y++) {
                line0 = this.getRGB(x - 1, y - 1).getRed() + (2 * this.getRGB(x, y - 1).getRed()) + this.getRGB(x + 1, y - 1).getRed();
                line2 = this.getRGB(x - 1, y + 1).getRed() + (2 * this.getRGB(x, y + 1).getRed()) + this.getRGB(x + 1, y + 1).getRed();
                column0 = this.getRGB(x - 1, y - 1).getRed() + (2 * this.getRGB(x - 1, y).getRed()) + this.getRGB(x - 1, y + 1).getRed();
                column2 = this.getRGB(x + 1, y - 1).getRed() + (2 * this.getRGB(x + 1, y).getRed()) + this.getRGB(x + 1, y + 1).getRed();
                red = this.normalize(Math.abs(line0 - line2) + Math.abs(column0 - column2));

                line0 = this.getRGB(x - 1, y - 1).getGreen() + (2 * this.getRGB(x, y - 1).getGreen()) + this.getRGB(x + 1, y - 1).getGreen();
                line2 = this.getRGB(x - 1, y + 1).getGreen() + (2 * this.getRGB(x, y + 1).getGreen()) + this.getRGB(x + 1, y + 1).getGreen();
                column0 = this.getRGB(x - 1, y - 1).getGreen() + (2 * this.getRGB(x - 1, y).getGreen()) + this.getRGB(x - 1, y + 1).getGreen();
                column2 = this.getRGB(x + 1, y - 1).getGreen() + (2 * this.getRGB(x + 1, y).getGreen()) + this.getRGB(x + 1, y + 1).getGreen();
                green = this.normalize(Math.abs(line0 - line2) + Math.abs(column0 - column2));

                line0 = this.getRGB(x - 1, y - 1).getBlue() + (2 * this.getRGB(x, y - 1).getBlue()) + this.getRGB(x + 1, y - 1).getBlue();
                line2 = this.getRGB(x - 1, y + 1).getBlue() + (2 * this.getRGB(x, y + 1).getBlue()) + this.getRGB(x + 1, y + 1).getBlue();
                column0 = this.getRGB(x - 1, y - 1).getBlue() + (2 * this.getRGB(x - 1, y).getBlue()) + this.getRGB(x - 1, y + 1).getBlue();
                column2 = this.getRGB(x + 1, y - 1).getBlue() + (2 * this.getRGB(x + 1, y).getBlue()) + this.getRGB(x + 1, y + 1).getBlue();
                blue = this.normalize(Math.abs(line0 - line2) + Math.abs(column0 - column2));

                aux.setRGB(x, y, new Color(red, green, blue).getRGB());
            }
        }
        this.buffer = aux;
        return this.getIcon();
    }

    /*
        Função usada para somar duas imagens através da porcentagem atribuída à cada uma delas passada por parâmetro
     */
    public static Imagem soma(Imagem a, Imagem b, float perc1, float perc2) {
        Color color = null;
        Imagem soma = new Imagem();
        for (int x = 0; x < a.WIDTH; x++) {
            for (int y = 0; y < a.HEIGHT; y++) {
                color = new Color(
                        (int) ((((a.getRGB(x, y).getRed()) * perc1) + ((b.getRGB(x, y).getRed()) * perc2)) / 2.0),
                        (int) ((((a.getRGB(x, y).getGreen()) * perc1) + ((b.getRGB(x, y).getGreen()) * perc2)) / 2.0),
                        (int) ((((a.getRGB(x, y).getBlue()) * perc1) + ((b.getRGB(x, y).getBlue()) * perc2)) / 2.0)
                );
                soma.buffer.setRGB(x, y, color.getRGB());
            }
        }
        return soma;
    }

    public int maxRed() {
        int maxRed = 0;
        for (int x = 0; x < this.WIDTH; x++) {
            for (int y = 0; y < this.HEIGHT; y++) {
                if (this.getRGB(x, y).getRed() > maxRed) {
                    maxRed = this.getRGB(x, y).getRed();
                }
            }
        }
        return maxRed;
    }

    public int maxBlue() {
        int maxBlue = 0;
        for (int x = 0; x < this.WIDTH; x++) {
            for (int y = 0; y < this.HEIGHT; y++) {
                if (this.getRGB(x, y).getBlue() > maxBlue) {
                    maxBlue = this.getRGB(x, y).getBlue();
                }
            }
        }
        return maxBlue;
    }

    public int maxGreen() {
        int maxGreen = 0;
        for (int x = 0; x < this.WIDTH; x++) {
            for (int y = 0; y < this.HEIGHT; y++) {
                if (this.getRGB(x, y).getGreen() > maxGreen) {
                    maxGreen = this.getRGB(x, y).getGreen();
                }
            }
        }
        return maxGreen;
    }
}
