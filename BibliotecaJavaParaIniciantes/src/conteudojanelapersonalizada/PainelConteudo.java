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

import conteudojanelapersonalizada.padroesprojeto.ComponenteDePainelConteudo;
import conteudojanelapersonalizada.padroesprojeto.Dimensionavel;
import conteudojanelapersonalizada.padroesprojeto.Posicionavel;
import static entradasaida.JanelaPersonalizada.getAlturaTelaComputador;
import static entradasaida.JanelaPersonalizada.getComprimentoTelaComputador;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

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
public class PainelConteudo implements Posicionavel, Dimensionavel {

    protected Painel painelBruto;

    public PainelConteudo() {
        painelBruto = new Painel(false);
    }

    public void setVisivel(Boolean visivel) {
        painelBruto.setVisible(visivel);
    }
    
    public JPanel getJPanel() {
        return painelBruto;
    }

    public void setCorDeFundo(String codigoHexaCor) {
        Cor novaCor = new Cor(codigoHexaCor);
        painelBruto.setBackground(novaCor.getColor());
    }

    //<editor-fold defaultstate="collapsed" desc="adicionarComponenteDePainelConteudo(...)">
    public void adicionarComponenteDePainelConteudo(Component novoComponente) {
        painelBruto.adicionarComponenteDePainelConteudo(novoComponente);
    }

    public void adicionarComponenteDePainelConteudo(ComponenteDePainelConteudo novoComponente) {
        painelBruto.adicionarComponenteDePainelConteudo(novoComponente, 0, 0);
    }

    public void adicionarComponenteDePainelConteudo(
            ComponenteDePainelConteudo novoComponente,
            Integer x, Integer y
    ) {
        painelBruto.adicionarComponenteDePainelConteudo(novoComponente, x, y);
    }

    public void adicionarComponenteDePainelConteudo(
            ComponenteDePainelConteudo novoComponente,
            Integer ordemCamada
    ) {
        painelBruto.adicionarComponenteDePainelConteudo(novoComponente, 0, 0, ordemCamada);
    }

    public void adicionarComponenteDePainelConteudo(
            ComponenteDePainelConteudo novoComponente,
            Integer x, Integer y,
            Integer ordemCamada
    ) {
        painelBruto.adicionarComponenteDePainelConteudo(novoComponente, x, y, ordemCamada);
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
        
//        public Paint getPaint(){
//            super.get
//        }

        //<editor-fold defaultstate="collapsed" desc="adicionarComponenteDePainelConteudo(...)">
        public void adicionarComponenteDePainelConteudo(
                Component novoComponente
        ) {
            novoComponente.setBounds(novoComponente.getBounds());
            camadaDesenho.add(novoComponente);
        }

        public void adicionarComponenteDePainelConteudo(ComponenteDePainelConteudo novoComponente) {
            adicionarComponenteDePainelConteudo(novoComponente, 0, 0);
        }

        public void adicionarComponenteDePainelConteudo(
                ComponenteDePainelConteudo novoComponente,
                Integer x, Integer y
        ) {
            novoComponente.setPosicao(x, y);
            camadaDesenho.add(novoComponente.getComponent());
        }

        public void adicionarComponenteDePainelConteudo(
                ComponenteDePainelConteudo novoComponente,
                Integer ordemCamada
        ) {
            adicionarComponenteDePainelConteudo(novoComponente, 0, 0, ordemCamada);
        }

        public void adicionarComponenteDePainelConteudo(
                ComponenteDePainelConteudo novoComponente,
                Integer x, Integer y,
                Integer ordemCamada
        ) {
            novoComponente.setPosicao(x, y);
            camadaDesenho.add(novoComponente.getComponent(), new Integer(ordemCamada));
        }
        //</editor-fold>

    }//nested class
    //</editor-fold>
//##########################################################################################    

}//class
