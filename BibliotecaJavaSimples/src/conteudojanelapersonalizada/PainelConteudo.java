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
import javax.swing.*;
import javax.swing.border.Border;

/**
 * Descrição de <code>PainelConteudo</code>.
 * <dl>
 * <dd>• Ponto 1: "abc";
 * </dl>
 *
 * <br><br><small>Criado em: 06/03/2019</small>
 *
 * @author Tiago Penha Pedroso
 * @version 1.0
 */
public class PainelConteudo implements 
        Posicionavel, 
        Dimensionavel,
        AparenciaEditavel {

    protected Painel painelBruto;
    
    //<editor-fold defaultstate="collapsed" desc="Atributos: Auxiliares">
    private Cor corTemp = Cor.TRANSPARENTE;
    private Border borda;
    //</editor-fold>

    public PainelConteudo() {
        painelBruto = new Painel(false);
    }

    public void setVisivel(Boolean visivel) {
        painelBruto.setVisible(visivel);
    }

    public JPanel getObjetoJPanel() {
        return painelBruto;
    }
    
    //<editor-fold defaultstate="collapsed" desc="adicionarComponenteDePainelConteudo(...)">
    public void adicionarComponenteDePainelConteudo(JComponent novoComponente) {
        painelBruto.adicionarComponenteDePainelConteudo(novoComponente);
    }

    public void adicionarComponenteDePainelConteudo(ComponenteDePainelConteudo novoComponente) {
        painelBruto.adicionarComponenteDePainelConteudo(
                novoComponente,
                novoComponente.getPosicaoX(),
                novoComponente.getPosicaoY()
        );
    }

    public void adicionarComponenteDePainelConteudo(
            ComponenteDePainelConteudo novoComponente,
            Integer novoX, Integer novoY
    ) {
        painelBruto.adicionarComponenteDePainelConteudo(novoComponente, novoX, novoY);
    }

    public void adicionarComponenteDePainelConteudo(
            ComponenteDePainelConteudo novoComponente,
            Integer ordemCamada
    ) {
        painelBruto.adicionarComponenteDePainelConteudo(
                novoComponente,
                novoComponente.getPosicaoX(),
                novoComponente.getPosicaoY(),
                ordemCamada
        );
    }

    public void adicionarComponenteDePainelConteudo(
            ComponenteDePainelConteudo novoComponente,
            Integer novoX, Integer novoY,
            Integer ordemCamada
    ) {
        painelBruto.adicionarComponenteDePainelConteudo(
                novoComponente,
                novoX,
                novoY,
                ordemCamada
        );
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos: Posicionavel">
    @Override
    public void setPosicao(Integer novoX, Integer novoY) {
        painelBruto.setLocation(novoX, novoY);
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
        return painelBruto.getX();
    }

    @Override
    public Integer getPosicaoY() {
        return painelBruto.getY();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos: Dimensionavel">
    @Override
    public void setDimensao(Double proporcaoNovaDimensao){
        painelBruto.setDimensao(
                (int)(getDimensaoComprimento() * proporcaoNovaDimensao),
                (int)(getDimensaoAltura() * proporcaoNovaDimensao)
        );
    }
    
    @Override
    public void setDimensao(Integer novoComprimento, Integer novaAltura) {
        painelBruto.setDimensao(novoComprimento, novaAltura);
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
        return painelBruto.getWidth();
    }

    @Override
    public Integer getDimensaoAltura() {
        return painelBruto.getHeight();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Métodos: AparenciaEditavel">
    @Override
    public void setCorDeFundo(String codigoCorHexa) {
        corTemp.mudarCor(codigoCorHexa);
        painelBruto.setBackground(corTemp.getObjetoColor());
    }

    @Override
    public void setCorDeFundo(Cor novaCor) {
        painelBruto.setBackground(novaCor.getObjetoColor());
    }

    @Override
    public String getCorDeFundoEmCodigoHexa() {
        return Cor.getCodigoHexadecimal(painelBruto.getBackground());
    }

    @Override
    public Cor getCorDeFundo() {
        return Cor.converterObjetoColorEmCor(painelBruto.getBackground());
    }

    @Override
    public void setCorDaFrente(String codigoCorHexa) {
        corTemp.mudarCor(codigoCorHexa);
        painelBruto.setForeground(corTemp.getObjetoColor());
    }

    @Override
    public void setCorDaFrente(Cor novaCor) {
        painelBruto.setForeground(novaCor.getObjetoColor());
    }

    @Override
    public String getCorDaFrenteEmCodigoHexa() {
        return Cor.getCodigoHexadecimal(painelBruto.getForeground());
    }

    @Override
    public Cor getCorDaFrente() {
        return Cor.converterObjetoColorEmCor(painelBruto.getForeground());
    }

    @Override
    public void setBorda(Integer espessura, String codigoCorHexa) {
        corTemp.mudarCor(codigoCorHexa);
        borda = BorderFactory.createMatteBorder(
                espessura, espessura, espessura, espessura,
                corTemp.getObjetoColor()
        );
        painelBruto.setBorder(borda);
    }

    @Override
    public void setBorda(Integer espessuraEsquerda, Integer espessuraDireita, Integer espessuraSuperior, Integer espessuraInferior, String codigoCorHexa) {
        corTemp.mudarCor(codigoCorHexa);
        borda = BorderFactory.createMatteBorder(
                espessuraSuperior, espessuraEsquerda,
                espessuraInferior, espessuraDireita,
                corTemp.getObjetoColor()
        );
        painelBruto.setBorder(borda);
    }

    @Override
    public void setBorda(Integer espessura, Cor novaCor) {
        borda = BorderFactory.createMatteBorder(
                espessura, espessura, espessura, espessura,
                novaCor.getObjetoColor()
        );
        painelBruto.setBorder(borda);
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
        painelBruto.setBorder(borda);
    }

    @Override
    public void removerBorda() {
        borda = BorderFactory.createMatteBorder(
                0, 0, 0, 0,
                Cor.TRANSPARENTE.getObjetoColor()
        );
        painelBruto.getObjetoJPanel().setBorder(borda);
    }
    //</editor-fold>
    
//##########################################################################################
    //<editor-fold defaultstate="collapsed" desc="Classe aninhada Painel">
    private class Painel extends JPanel {

        private JLayeredPane camadaDesenho;

        //<editor-fold defaultstate="collapsed" desc="Construtores">
        public Painel(Boolean visivel) {
            super();
            iniciarJanela(visivel);
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Métodos: Auxiliares">
        /**
         * Executa a inicialização de todos os componentes básicos da janela.
         *
         * @param comprimento O comprimento da janela
         * @param altura A altura da janela
         * @param iniciarEmTelaCheia A janela deve ser no modo de tela cheia?
         */
        private void iniciarJanela(Boolean visivel) {
            //Desativando todos os métodos de repaint para um melhor controle manual
//            super.setIgnoreRepaint(true);
            super.setDoubleBuffered(true);
            super.setOpaque(true);

            camadaDesenho = new JLayeredPane();

//            camadaDesenho.addKeyListener(this);
//            camadaDesenho.addMouseListener(this);
//            camadaDesenho.addMouseMotionListener(this);
//            camadaDesenho.addMouseWheelListener(this);
//            camadaDesenho.addMouseMotionListener(this);
            super.add(camadaDesenho);

            setVisivel(visivel);
        }
        //</editor-fold>

        /**
         * Alterador das dimensões da Janea e do PainelDesenho
         *
         * @param comprimento O valor do novo comprimento
         * @param altura O valor da nova altura
         */
        public void setDimensao(Integer comprimento, Integer altura) {
            if (comprimento > 0 && altura > 0) {
                super.setSize(new Dimension(comprimento, altura));
                super.setPreferredSize(new Dimension(comprimento, altura));
                camadaDesenho.setSize(new Dimension(comprimento, altura));
                camadaDesenho.setPreferredSize(new Dimension(comprimento, altura));
            }
        }

        public void setVisivel(Boolean visivel) {
            super.setVisible(visivel);

            if (visivel) {
                super.setFocusable(true);
                super.requestFocus();
            }
        }

        public JPanel getObjetoJPanel() {
            return this;
        }

        //<editor-fold defaultstate="collapsed" desc="adicionarComponenteDePainelConteudo(...)">
        public void adicionarComponenteDePainelConteudo(JComponent novoComponente) {
            camadaDesenho.add(novoComponente);
        }

        public void adicionarComponenteDePainelConteudo(ComponenteDePainelConteudo novoComponente) {
            this.adicionarComponenteDePainelConteudo(
                    novoComponente,
                    novoComponente.getPosicaoX(),
                    novoComponente.getPosicaoY()
            );
        }

        public void adicionarComponenteDePainelConteudo(
                ComponenteDePainelConteudo novoComponente,
                Integer x, Integer y
        ) {
            novoComponente.setPosicao(x, y);
            camadaDesenho.add(novoComponente.getObjetoJComponent());
        }

        public void adicionarComponenteDePainelConteudo(
                ComponenteDePainelConteudo novoComponente,
                Integer ordemCamada
        ) {
            this.adicionarComponenteDePainelConteudo(
                    novoComponente,
                    novoComponente.getPosicaoX(),
                    novoComponente.getPosicaoY(),
                    ordemCamada
            );
        }

        public void adicionarComponenteDePainelConteudo(
                ComponenteDePainelConteudo novoComponente,
                Integer x, Integer y,
                Integer ordemCamada
        ) {
            novoComponente.setPosicao(x, y);
            camadaDesenho.add(novoComponente.getObjetoJComponent(), new Integer(ordemCamada));
        }
        //</editor-fold>

    }//nested class
    //</editor-fold>
//##########################################################################################    

}//class
