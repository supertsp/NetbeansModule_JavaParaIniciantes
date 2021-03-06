//<editor-fold defaultstate="collapsed" desc="License">
/* 
 * Copyright (C) 2019 Tiago Penha Pedroso
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
//</editor-fold>
package conteudojanelapersonalizada;

import conteudojanelapersonalizada.padroesprojeto.AparenciaEditavel;
import conteudojanelapersonalizada.padroesprojeto.ComponenteDePainelConteudo;
import conteudojanelapersonalizada.padroesprojeto.Dimensionavel;
import conteudojanelapersonalizada.padroesprojeto.Posicionavel;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

public class ImagemBitmap implements
        ComponenteDePainelConteudo,
        Posicionavel,
        Dimensionavel,
        AparenciaEditavel {

    protected Image imagem;
    protected JLabel imagemLabel;
    protected String URL = "";
    protected Boolean importouImagem = false;

    //<editor-fold defaultstate="collapsed" desc="Atributos: Auxiliares">
    private Cor corTemp = Cor.TRANSPARENTE;
    private Border borda;
    private static ImagemBitmap imagemTransparente = new ImagemBitmap("/conteudojanelapersonalizada/megaTileTransparente.gif", 0, 0);
    private static ImagemBitmap imagemTransparenteFatiada = new ImagemBitmap("/conteudojanelapersonalizada/megaTileTransparente.gif", 0, 0);;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    /**
     * *
     * Cria uma nova imagem a partir de um endereço (URL).<br>
     * Os formatos permitidos são: JPEG, JPG, GIF e PNG.
     *
     * @param imagemURL O formato padrão é "/[nome pasta ou pacote]/[nome
     * arquivo]". Ex.: "/assets/personagem.png"
     * @param posicaoX A posição x inicial da imagem no
     * <code>PainelConteudo</code>
     * @param posicaoY A posição x inicial da imagem no
     * <code>PainelConteudo</code>
     */
    public ImagemBitmap(String imagemURL, Integer posicaoX, Integer posicaoY) {
        URL = imagemURL;
        imagemLabel = new JLabel();
        imagemLabel.setHorizontalAlignment(JLabel.CENTER);
        imagemLabel.setOpaque(false);
        imagemLabel.setDoubleBuffered(true);
        setPosicao(posicaoX, posicaoY);
        importar();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos: Auxiliares">
    private void importar() {
        if (!URL.equals("")) {
            try {
                imagem = ImageIO.read(this.getClass().getResource(URL));
                importouImagem = true;
                imagemLabel.setIcon(getObjetoIcon());
                imagemLabel.setBounds(
                        getPosicaoX(), getPosicaoY(),
                        getDimensaoComprimento(), getDimensaoAltura()
                );
                imagemLabel.setSize(new Dimension(getDimensaoComprimento(), getDimensaoAltura()));
                imagemLabel.setPreferredSize(new Dimension(getDimensaoComprimento(), getDimensaoAltura()));
            } catch (Exception e) {
                //caso uma imagem anterior tenha sido importada com sucesso essa 
                //variável teria continuado a valer true
                importouImagem = false;
                System.out.println(
                        "+------------------------------------+\n"
                        + "| Erro ao importar a ImagemBitmap! :(\n"
                        + "| URL: " + URL + "\n"
                        + "+------------------------------------+\n"
                );
            }
        } else {
            importouImagem = false;
        }
    }

    private Image getFatia(Integer xInicial, Integer yInicial, Integer comprimentoFinal, Integer alturaFinal) {
        if (importouImagem) {
            xInicial = xInicial < 0 ? 0 : xInicial;
            xInicial = xInicial > getDimensaoComprimento() ? 0 : xInicial;
            yInicial = yInicial < 0 ? 0 : yInicial;
            yInicial = yInicial > getDimensaoAltura() ? 0 : yInicial;

            comprimentoFinal = comprimentoFinal < 0
                    ? (getDimensaoComprimento() - xInicial) : comprimentoFinal;
            comprimentoFinal = comprimentoFinal > (getDimensaoComprimento() - xInicial)
                    ? (getDimensaoComprimento() - xInicial) : comprimentoFinal;

            alturaFinal = alturaFinal < 0
                    ? (getDimensaoAltura() - yInicial) : alturaFinal;
            alturaFinal = alturaFinal > (getDimensaoAltura() - yInicial)
                    ? (getDimensaoAltura() - yInicial) : alturaFinal;

            Image temp = null;

            try {
                temp = getObjetoBufferedImage()
                        .getSubimage(
                                xInicial, yInicial,
                                comprimentoFinal, alturaFinal
                        );
            } catch (Exception e) {
                System.out.println(
                        "+-------------------------------------+\n"
                        + "|ERRO AO TENTAR FATIAR A IMAGEM!!! :( |\n"
                        + "+-------------------------------------+\n"
                        + "xInicial: " + xInicial + ", yInicial: " + yInicial + "\n"
                        + "comprimentoFinal: " + comprimentoFinal + ", alturaFinal: " + alturaFinal
                );
                e.printStackTrace();
            }

            return temp;
        } else {
            return null;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="STATIC getImageVaziaTransparente..(Integer comprimento, Integer altura)">
    public static ImagemBitmap getImagemVaziaTransparente(Integer comprimento, Integer altura) {
        if (comprimento >= 1 && comprimento <= 100 && altura >= 1 && altura <= 100) {
            imagemTransparenteFatiada.imagem = imagemTransparente.getFatia(0, 0, comprimento, altura);
            return imagemTransparenteFatiada;
        }
        else if (comprimento > 100 && altura > 100) {
            imagemTransparenteFatiada.imagem = imagemTransparente.imagem;
            return imagemTransparenteFatiada;
        }

        return null;
    }
    
    public static Image getImagemVaziaTransparenteComoObjetoImage(Integer comprimento, Integer altura) {
        if (comprimento >= 1 && comprimento <= 100 && altura >= 1 && altura <= 100) {            
            return imagemTransparente.getFatia(0, 0, comprimento, altura);
        }
        else if (comprimento > 100 && altura > 100) {
            return imagemTransparente.getObjetoImage();
        }

        return null;
    }
    
    public static Icon getImagemVaziaTransparenteComoObjetoIcon(Integer comprimento, Integer altura) {
        return getImagemVaziaTransparenteComoObjetoImageIcon(comprimento, altura);
    }
    
    public static ImageIcon getImagemVaziaTransparenteComoObjetoImageIcon(Integer comprimento, Integer altura) {
        ImageIcon icon = new ImageIcon(getImagemVaziaTransparenteComoObjetoImage(comprimento, altura));
        return icon;
    }
    
    public static BufferedImage getImagemVaziaTransparenteComoObjetoBufferedImage(Integer comprimento, Integer altura) {
        return (BufferedImage) getImagemVaziaTransparenteComoObjetoImage(comprimento, altura);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getFatiaImagem(Integer xInicial, Integer yInicial, Integer comprimentoFinal, Integer alturaFinal) : ImagemBitmap">
    /**
     * Fatiador de imagem que mantém as mesmas coordenadas da imagem
     * original.<br>
     * Obs.: Caso algum valor de parâmetro seja inválido (Ex.: comprimentoFinal
     * &gt; comprimento), o valor passado será descartado e será mantido o
     * orignal (Ex.: comprimentoFinal = comprimento).
     *
     * @param xInicial Posição x em relação à imagem original e não com a Tela
     * @param yInicial Posição y em relação à imagem original e não com a Tela
     * @param comprimentoFinal Comprimento da nova imagem em relação à imagem
     * original
     * @param alturaFinal Altura da nova imagem em relação à imagem original
     * @return ImagemBitmap : Caso o fatiamento tenha ocorrido com sucesso<br>
     * null : Caso houve alguma falha ao fatiar
     */
    public ImagemBitmap getFatiaImagem(
            Integer xInicial, Integer yInicial,
            Integer comprimentoFinal, Integer alturaFinal
    ) {
        Image tempImage = getFatia(xInicial, yInicial, comprimentoFinal, alturaFinal);

        if (tempImage != null) {
            ImagemBitmap temp = new ImagemBitmap(URL, getPosicaoX(), getPosicaoY());
            temp.imagem = tempImage;
            return temp;
        }

        return null;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="getObjeto..()">
    /**
     * Retorna a imagem importada no formato Image.
     *
     * @return Image
     */
    public Image getObjetoImage() {
        return imagem;
    }

    public Icon getObjetoIcon() {
        return getObjetoImageIcon();
    }

    public ImageIcon getObjetoImageIcon() {
        ImageIcon icon = new ImageIcon(imagem);
        return icon;
    }

    /**
     * Retorna a imagem importada no formato BufferedImage.
     *
     * @return BufferedImage
     */
    public BufferedImage getObjetoBufferedImage() {
        return (BufferedImage) imagem;
    }

    public JLabel getObjetoJLabel() {
        return imagemLabel;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="GETTERS & SETTERS">
    /**
     * Retorna o endereço da imagem importada. Caso os contrutores de imagens já
     * importadas tenha sido utilizado, o retorno será uma String vazia.
     *
     * @return String
     */
    public String getURL() {
        return URL;
    }

    /**
     * Retorna o status da importação da imagem.
     *
     * @return boolean
     */
    public boolean isImportouImagem() {
        return importouImagem;
    }

    public void setTextoDeRotulo(String novoTexto) {
        imagemLabel.setText(novoTexto);
    }

    public void mudarPosicaoTextoDeRotulo(Boolean ficarLadoDireito) {
        imagemLabel.setHorizontalAlignment(0);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Métodos: ComponenteDePainelConteudo">
    @Override
    public JComponent getObjetoJComponent() {
        return imagemLabel;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Métodos: Posicionavel">
    @Override
    public void setPosicao(Integer novoX, Integer novoY) {
        imagemLabel.setLocation(novoX, novoY);
    }

    @Override
    public void setPosicaoX(Integer novoX) {
        setPosicao(novoX, getPosicaoY());
    }

    @Override
    public void setPosicaoY(Integer novoY) {
        setPosicao(getPosicaoX(), novoY);
    }

    @Override
    public void incrementarPosicao(Integer valorIncrementoXY) {
        setPosicao(getPosicaoX() + valorIncrementoXY, getPosicaoY() + valorIncrementoXY);
    }

    @Override
    public void incrementarPosicao(Integer valorIncrementoX, Integer valorIncrementoY) {
        setPosicao(getPosicaoX() + valorIncrementoX, getPosicaoY() + valorIncrementoY);
    }

    @Override
    public void incrementarPosicaoX(Integer valorIncremento) {
        setPosicaoX(getPosicaoX() + valorIncremento);
    }

    @Override
    public void incrementarPosicaoY(Integer valorIncremento) {
        setPosicaoY(getPosicaoY() + valorIncremento);
    }

    @Override
    public Integer getPosicaoX() {
        return imagemLabel.getX();
    }

    @Override
    public Integer getPosicaoY() {
        return imagemLabel.getY();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos: Dimensionavel">
    @Override
    public void setDimensao(Double proporcaoNovaDimensao) {
        setDimensao(
                (int) (getDimensaoComprimento() * proporcaoNovaDimensao),
                (int) (getDimensaoAltura() * proporcaoNovaDimensao)
        );
    }

    @Override
    public void setDimensao(Integer novoComprimento, Integer novaAltura) {
        if (importouImagem && novoComprimento > 0 && novaAltura > 0) {
            imagem = imagem.getScaledInstance(novoComprimento, novaAltura, Image.SCALE_SMOOTH);
            imagemLabel.setIcon(getObjetoIcon());
            imagemLabel.setBounds(
                    getPosicaoX(), getPosicaoY(),
                    getDimensaoComprimento(), getDimensaoAltura()
            );
            imagemLabel.setSize(new Dimension(novoComprimento, novaAltura));
            imagemLabel.setPreferredSize(new Dimension(novoComprimento, novaAltura));
        }
    }

    @Override
    public void setDimensaoComprimento(Integer novoComprimento) {
        setDimensao(novoComprimento, getDimensaoAltura());
    }

    @Override
    public void setDimensaoAltura(Integer novaAltura) {
        setDimensao(getDimensaoComprimento(), novaAltura);
    }

    @Override
    public void incrementarDimensao(Integer valorIncrementoComprimentoAltura) {
        setDimensao(
                getDimensaoComprimento() + valorIncrementoComprimentoAltura,
                getDimensaoAltura() + valorIncrementoComprimentoAltura
        );
    }

    @Override
    public void incrementarDimensao(Integer valorIncrementoComprimento, Integer valorIncrementoAltura) {
        setDimensao(
                getDimensaoComprimento() + valorIncrementoComprimento,
                getDimensaoAltura() + valorIncrementoAltura
        );
    }

    @Override
    public void incrementarDimensaoComprimento(Integer valorIncremento) {
        setDimensao(
                getDimensaoComprimento() + valorIncremento,
                getDimensaoAltura()
        );
    }

    @Override
    public void incrementarDimensaoAltura(Integer valorIncremento) {
        setDimensao(
                getDimensaoComprimento(),
                getDimensaoAltura() + valorIncremento
        );
    }

    @Override
    public Integer getDimensaoComprimento() {
        if (importouImagem) {
            return imagem.getWidth(null);
        }

        return -1;
    }

    @Override
    public Integer getDimensaoAltura() {
        if (importouImagem) {
            return imagem.getHeight(null);
        }

        return -1;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Métodos: AparenciaEditavel">
    @Override
    public void setCorDeFundo(String codigoCorHexa) {
        corTemp.mudarCor(codigoCorHexa);
        imagemLabel.setBackground(corTemp.getObjetoColor());
    }

    @Override
    public void setCorDeFundo(Cor novaCor) {
        imagemLabel.setBackground(novaCor.getObjetoColor());
    }

    @Override
    public String getCorDeFundoEmCodigoHexa() {
        return Cor.getCodigoHexadecimal(imagemLabel.getBackground());
    }

    @Override
    public Cor getCorDeFundo() {
        return Cor.converterObjetoColorEmCor(imagemLabel.getBackground());
    }

    @Override
    public void setCorDaFrente(String codigoCorHexa) {
        corTemp.mudarCor(codigoCorHexa);
        imagemLabel.setForeground(corTemp.getObjetoColor());
    }

    @Override
    public void setCorDaFrente(Cor novaCor) {
        imagemLabel.setForeground(novaCor.getObjetoColor());
    }

    @Override
    public String getCorDaFrenteEmCodigoHexa() {
        return Cor.getCodigoHexadecimal(imagemLabel.getForeground());
    }

    @Override
    public Cor getCorDaFrente() {
        return Cor.converterObjetoColorEmCor(imagemLabel.getForeground());
    }

    @Override
    public void setBorda(Integer espessura, String codigoCorHexa) {
        corTemp.mudarCor(codigoCorHexa);
        borda = BorderFactory.createMatteBorder(
                espessura, espessura, espessura, espessura,
                corTemp.getObjetoColor()
        );
        imagemLabel.setBorder(borda);
    }

    @Override
    public void setBorda(Integer espessuraEsquerda, Integer espessuraDireita, Integer espessuraSuperior, Integer espessuraInferior, String codigoCorHexa) {
        corTemp.mudarCor(codigoCorHexa);
        borda = BorderFactory.createMatteBorder(
                espessuraSuperior, espessuraEsquerda,
                espessuraInferior, espessuraDireita,
                corTemp.getObjetoColor()
        );
        imagemLabel.setBorder(borda);
    }

    @Override
    public void setBorda(Integer espessura, Cor novaCor) {
        borda = BorderFactory.createMatteBorder(
                espessura, espessura, espessura, espessura,
                novaCor.getObjetoColor()
        );
        imagemLabel.setBorder(borda);
    }

    @Override
    public void setBorda(
            Integer espessuraEsquerda,
            Integer espessuraDireita,
            Integer espessuraSuperior,
            Integer espessuraInferior,
            Cor novaCor
    ) {
        borda = BorderFactory.createMatteBorder(
                espessuraSuperior, espessuraEsquerda,
                espessuraInferior, espessuraDireita,
                novaCor.getObjetoColor()
        );
        imagemLabel.setBorder(borda);
    }

    @Override
    public void removerBorda() {
        borda = BorderFactory.createMatteBorder(
                0, 0, 0, 0,
                Cor.TRANSPARENTE.getObjetoColor()
        );
        imagemLabel.setBorder(borda);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos: Object">
    /**
     * Caso todos os atributos comparados sejam iguais o retorno será true, caso
     * contrário, será false.<br>
     * Atributos:
     * <ul>
     * <li>imagem</li>
     * <li>comprimento</li>
     * <li>altura</li>
     * </ul>
     *
     * @param outraImagemBitmap A outra ImagemBitmap a ser comparada
     * @return boolean
     */
    @Override
    public boolean equals(Object outraImagemBitmap) {
        return outraImagemBitmap instanceof ImagemBitmap
                && ((ImagemBitmap) outraImagemBitmap).getObjetoImage().equals(getObjetoImage())
                && ((ImagemBitmap) outraImagemBitmap).getDimensaoComprimento() == getDimensaoComprimento()
                && ((ImagemBitmap) outraImagemBitmap).getDimensaoAltura() == getDimensaoAltura();
    }

    @Override
    public String toString() {
        //Imprime Desenho final
        return "ImagemBitmap{\n"
                + "  URL: " + getURL()
                + "  dimensões: " + getDimensaoComprimento() + "x" + getDimensaoAltura() + " px\n"
                + "  importou imagem? " + (importouImagem ? "sim" : "não") + "\n"
                + "}";
    }
    //</editor-fold>

}
