////<editor-fold defaultstate="collapsed" desc="License">
///* 
// * Copyright (C) 2019 Tiago Penha Pedroso
// *
// * This program is free software: you can redistribute it and/or modify
// * it under the terms of the GNU General Public License as published by
// * the Free Software Foundation, either version 3 of the License, or
// * (at your option) any later version.
// *
// * This program is distributed in the hope that it will be useful,
// * but WITHOUT ANY WARRANTY; without even the implied warranty of
// * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// * GNU General Public License for more details.
// *
// * You should have received a copy of the GNU General Public License
// * along with this program.  If not, see <http://www.gnu.org/licenses/>.
// */
////</editor-fold>
package entradasaida;

import conteudojanelapersonalizada.PainelConteudo;
import com.sun.org.apache.bcel.internal.classfile.InnerClass;
import conteudojanelapersonalizada.Cor;
import conteudojanelapersonalizada.padroesprojeto.Dimensionavel;
import conteudojanelapersonalizada.padroesprojeto.Posicionavel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.ColorModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 * Descrição de <code>JanelaPersonalizada</code>.
 * <dl>
 * <dd>• Ponto 1: "abc";
 * </dl>
 *
 * <br><br><small>Criado em: 06/03/2019</small>
 *
 * @author Tiago Penha Pedroso
 * @version 1.0
 */
public class JanelaPersonalizada implements Posicionavel, Dimensionavel {

    private volatile Janela janela;
    private List<PainelConteudo> paineis;
    private Integer indicePainelConteudoVisivel = -1;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public JanelaPersonalizada() {
        janela = new Janela();
        paineis = new ArrayList<>();

        synchronized (this) {
            javax.swing.SwingUtilities.invokeLater(() -> {
                janela.exibir();
            });
        }
    }

    public JanelaPersonalizada(Boolean telaCheia) {
        janela = new Janela(telaCheia);
        paineis = new ArrayList<>();

        synchronized (this) {
            javax.swing.SwingUtilities.invokeLater(() -> {
                janela.exibir();
            });
        }
    }

    public JanelaPersonalizada(Integer comprimento, Integer altura) {
        janela = new Janela(comprimento, altura);
        paineis = new ArrayList<>();

        synchronized (this) {
            javax.swing.SwingUtilities.invokeLater(() -> {
                janela.exibir();
            });
        }
    }

    public JanelaPersonalizada(Integer comprimento, Integer altura, Boolean telaCheia) {
        janela = new Janela(comprimento, altura, telaCheia);
        paineis = new ArrayList<>();

        synchronized (this) {
            javax.swing.SwingUtilities.invokeLater(() -> {
                janela.exibir();
            });
        }
    }

    public JanelaPersonalizada(
            String tituloJanela, Integer comprimento, Integer altura,
            Boolean telaCheia
    ) {
        janela = new Janela(tituloJanela, comprimento, altura, telaCheia);
        paineis = new ArrayList<>();

        synchronized (this) {
            javax.swing.SwingUtilities.invokeLater(() -> {
                janela.exibir();
            });
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos: Resolução de Tela do Computador">
    private static final Toolkit tk = Toolkit.getDefaultToolkit();
    private static final Dimension d = tk.getScreenSize();

    /**
     * Retorna o comprimento da rezolução de tela atual.
     *
     * @return int
     */
    public static Integer getComprimentoTelaComputador() {
        return d.width;
    }

    /**
     * Retorna a altura da rezolução de tela atual.
     *
     * @return int
     */
    public static Integer getAlturaTelaComputador() {
        return d.height;
    }

    /**
     * Retorna a proporção da rezolução da tela atual.
     *
     * @return double
     */
    public static Double getProporcaoTelaComputador() {
        return (double) d.width / (double) d.height;
    }
    //</editor-fold>

    public void setCorDeFundo(String codigoHexaCor) {
        Cor novaCor = new Cor(codigoHexaCor);
        janela.setBackground(novaCor.getColor());
    }
    
    public JFrame getJFrame(){
        return janela;
    }

    //<editor-fold defaultstate="collapsed" desc="Métodos: controle do List<PainelConteudo>">
    public void adicionarPainelConteudo(PainelConteudo... novosPaineis) {
        for (PainelConteudo painel : novosPaineis) {
            janela.setContentPane(painel.getJPanel());
            paineis.add(painel);

            painel.setVisivel(false);
            painel.setDimensao(getDimensaoComprimento(), getDimensaoAltura());
        }
    }

    public void adicionarPainelConteudo(Integer indicePainelAtivo, PainelConteudo... novosPaineis) {
        for (Integer contador = 0; contador < novosPaineis.length; contador++) {
//            janela.setContentPane(novosPaineis[contador].getJPanel());
            paineis.add(novosPaineis[contador]);

            if (indicePainelAtivo == contador) {
                System.out.println("painel ativo");
                janela.setContentPane(novosPaineis[contador].getJPanel());
                novosPaineis[contador].setVisivel(true);
                indicePainelConteudoVisivel = indicePainelAtivo;
            } else {
                janela.remove(novosPaineis[contador].getJPanel());
                novosPaineis[contador].setVisivel(false);
            }

            novosPaineis[contador].setDimensao(getDimensaoComprimento(), getDimensaoAltura());
        }
    }

    public PainelConteudo getPainelConteudo(Integer indicePainel) {
        return paineis.get(indicePainel);
    }

    public PainelConteudo getPainelConteudoVisivel() {
        return paineis.get(indicePainelConteudoVisivel);
    }

    public void removerPainelConteudo(Integer indicePainelProcurado) {
        PainelConteudo painelProcurado = paineis.get(indicePainelProcurado);
        Boolean removeu = paineis.remove(indicePainelProcurado);
        if (removeu) {
            //se removeu o elemento atual visível
            if (indicePainelProcurado == indicePainelConteudoVisivel) {
                if (indicePainelConteudoVisivel >= getQuantidadePainelConteudo()) {
                    if (getQuantidadePainelConteudo() > 0) {
                        indicePainelConteudoVisivel = 0;
                    } else {
                        indicePainelConteudoVisivel = -1;
                    }
                }
            }

            //se removeu o elemento anterior ao atual visível
            if (indicePainelProcurado < indicePainelConteudoVisivel) {
                indicePainelConteudoVisivel--;
            }

            //atualiza o painel atual dentro da JanelaPersonalizada
            if (painelProcurado != null) {
                //remove painel antigo
                janela.remove(painelProcurado.getJPanel());
                //adiciona o novo
                janela.setContentPane(getPainelConteudo(indicePainelConteudoVisivel).getJPanel());
            }
        }
    }

    public void removerPainelConteudo(PainelConteudo painelProcurado) {
        Integer indicePainelProcurado = paineis.indexOf(painelProcurado);
        Boolean removeu = paineis.remove(painelProcurado);
        if (removeu) {
            //se removeu o elemento atual visível
            if (indicePainelProcurado == indicePainelConteudoVisivel) {
                if (indicePainelConteudoVisivel >= getQuantidadePainelConteudo()) {
                    if (getQuantidadePainelConteudo() > 0) {
                        indicePainelConteudoVisivel = 0;
                    } else {
                        indicePainelConteudoVisivel = -1;
                    }
                }
            }

            //se removeu o elemento anterior ao atual visível
            if (indicePainelProcurado < indicePainelConteudoVisivel) {
                indicePainelConteudoVisivel--;
            }

            //atualiza o painel atual dentro da JanelaPersonalizada
            if (painelProcurado != null) {
                //remove painel antigo
                janela.remove(painelProcurado.getJPanel());
                //adiciona o novo
                janela.setContentPane(getPainelConteudo(indicePainelConteudoVisivel).getJPanel());
            }
        }
    }

    public Integer getQuantidadePainelConteudo() {
        return paineis.size();
    }

    public void trocarPainelConteudo(Integer indicePainelProcurado) {
        if (indicePainelProcurado >= 0 && indicePainelProcurado < getQuantidadePainelConteudo()) {
            for (Integer contador = 0; contador < paineis.size(); contador++) {
                if (indicePainelProcurado == contador) {
                    janela.setContentPane(paineis.get(contador).getJPanel());
                    paineis.get(contador).setVisivel(true);
                } else {
                    janela.remove(paineis.get(contador).getJPanel());
                    paineis.get(contador).setVisivel(false);
                }
            }
        }
    }
    //</editor-fold>

    
    public Boolean isTelaCheia() {
        return janela.telaCheia;
    }

    public Boolean isFechada() {
        return janela.isActive();
    }

    public void moverParaCentroTela() {
        janela.moverParaCentroTela();
    }

    //<editor-fold defaultstate="collapsed" desc="Métodos: Posicionavel">
    @Override
    public void setPosicao(Integer novoX, Integer novoY) {
        janela.setLocation(novoX, novoY);
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
        return janela.getX();
    }

    @Override
    public Integer getPosicaoY() {
        return janela.getY();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos: Dimensionavel">
    @Override
    public void setDimensao(Integer novoComprimento, Integer novaAltura) {
        janela.setDimensao(novoComprimento, novaAltura);
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
        return janela.getWidth();
    }

    @Override
    public Integer getDimensaoAltura() {
        return janela.getHeight();
    }
    //</editor-fold>

//##########################################################################################
    //<editor-fold defaultstate="collapsed" desc="Classe aninhada Janela">
    private class Janela extends JFrame {

        Boolean telaCheia;

        //<editor-fold defaultstate="collapsed" desc="Construtores">
        public Janela() {
            this(false);
        }

        public Janela(Boolean telaCheia) {
            super("Janela Personalizada do seu app");

            Integer tamanhoTela = JanelaPersonalizada
                    .getProporcaoTelaComputador()
                    .intValue() * 300;

            iniciarJanela(
                    tamanhoTela,
                    tamanhoTela,
                    telaCheia
            );
        }

        public Janela(Integer comprimento, Integer altura) {
            super("Janela Personalizada do seu app");
            iniciarJanela(
                    comprimento,
                    altura,
                    false
            );
        }

        public Janela(Integer comprimento, Integer altura, Boolean telaCheia) {
            super("Janela Personalizada do seu app");
            iniciarJanela(
                    comprimento,
                    altura,
                    telaCheia
            );
        }

        public Janela(
                String tituloJanela, Integer comprimento, Integer altura,
                Boolean telaCheia
        ) {
            super(tituloJanela);
            iniciarJanela(
                    comprimento,
                    altura,
                    telaCheia
            );
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
        private synchronized void iniciarJanela(
                Integer comprimento,
                Integer altura,
                Boolean iniciarEmTelaCheia
        ) {
            if (iniciarEmTelaCheia) {
                ativarTelaCheia(iniciarEmTelaCheia);
            } else {
                this.telaCheia = iniciarEmTelaCheia;
                setDimensao(comprimento, altura);
            }

            super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            super.setAutoRequestFocus(true);
            super.setResizable(false);
            super.setDefaultLookAndFeelDecorated(true);
        }

        /**
         * Caso o valor passado por parâmetro seja true, a tela cheia será
         * ativada.
         *
         * @param telaCheia Define se a tela cheia será ativada ou não
         */
        private void ativarTelaCheia(Boolean telaCheia) {
            this.telaCheia = telaCheia;

            if (telaCheia) {
                //este método pode ser executado apenas no construtor e antes do setVisible(true)
                super.setUndecorated(true);

                setDimensao(getComprimentoTelaComputador(), getAlturaTelaComputador());
                super.setExtendedState(Frame.MAXIMIZED_BOTH);

            }
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
                super.pack();
            }
        }

        public void setTituloJanela(String novoTitulo) {
            super.setTitle(novoTitulo);
        }

        public String getTituloJanela() {
            return super.getTitle();
        }

        /**
         * Alinhador da JanelaDesenho ao centro exato da tela.
         */
        public void moverParaCentroTela() {
            super.setLocation(
                    (JanelaPersonalizada.getComprimentoTelaComputador() / 2) - (super.getWidth() / 2),
                    (JanelaPersonalizada.getAlturaTelaComputador() / 2) - (super.getHeight() / 2)
            );
        }

        public synchronized void exibir() {
            moverParaCentroTela();
            super.pack();
            super.setVisible(true);
        }

    }// nested class
    //</editor-fold>
//##########################################################################################

}//class
