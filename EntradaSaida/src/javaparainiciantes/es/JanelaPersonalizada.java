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
//package javaparainiciantes.es;
//
//import com.sun.org.apache.bcel.internal.classfile.InnerClass;
//import java.awt.Dimension;
//import java.awt.Frame;
//import java.awt.GraphicsConfiguration;
//import java.awt.GraphicsDevice;
//import java.awt.Rectangle;
//import java.awt.Toolkit;
//import java.awt.geom.AffineTransform;
//import java.awt.image.ColorModel;
//import java.util.ArrayList;
//import java.util.List;
//import javax.swing.JFrame;
//
///**
// * Descrição de <code>JanelaPersonalizada</code>.
// * <dl>
// * <dd>• Ponto 1: "abc";
// * </dl>
// *
// * <br><br><small>Criado em: 06/03/2019</small>
// *
// * @author Tiago Penha Pedroso
// * @version 1.0
// */
//public class JanelaPersonalizada {
//
//    private Janela janela;
//    private List<PainelConteudo> paineis;
//
//    
//
//    //<editor-fold defaultstate="collapsed" desc="Construtores">
//    public JanelaPersonalizada(boolean telaCheia) {
//        super("Janela Personalizada do seu app");
//
//        int tamanhoTela = (int) getProporcaoTelaComputador() * 300;
//
//        iniciarJanela(
//                tamanhoTela,
//                tamanhoTela,
//                telaCheia
//        );
//    }
//    //</editor-fold>
//
//    //<editor-fold defaultstate="collapsed" desc="Métodos: Auxiliares">
//    /**
//     * Executa a inicialização de todos os componentes básicos da janela.
//     *
//     * @param comprimento O comprimento da janela
//     * @param altura A altura da janela
//     * @param telaCheia A janela deve ser no modo de tela cheia?
//     */
//    private void iniciarJanela(
//            Integer comprimento,
//            Integer altura,
//            boolean telaCheia,
//            PainelConteudo... novosPaineis
//    ) {
//        if (telaCheia) {
//            ativarTelaCheia(telaCheia);
//        } else {
//            this.telaCheia = telaCheia;
//            setDimensoes(comprimento, altura);
//        }
//
//        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        super.setAutoRequestFocus(true);
//        super.setResizable(false);
//        super.setDefaultLookAndFeelDecorated(true);
//
//        paineis = new ArrayList<>();
//        adicionarPainelConteudo(novosPaineis);
//
////        jpanelParaSwingComponents = new JPanel(true);
////        jpanelParaSwingComponents.setSize(new Dimension(comprimento, altura));
////        jpanelParaSwingComponents.setPreferredSize(new Dimension(comprimento, altura));
////        jpanelParaSwingComponents.setOpaque(true);
////        jpanelParaSwingComponents.setBackground(Color.red);
////        camadaDesenho = new JLayeredPane();
////        camadaDesenho.setPreferredSize(new Dimension(comprimento, altura));        
////        camadaDesenho.addKeyListener(this);
////        camadaDesenho.addMouseListener(this);
////        camadaDesenho.addMouseMotionListener(this);
////        camadaDesenho.addMouseWheelListener(this);
////        camadaDesenho.addMouseMotionListener(this);
////        jpanelParaSwingComponents.add(camadaDesenho);
////        super.setContentPane(jpanelParaSwingComponents);
//        if (UPS > 0) {
//            this.UPS = UPS;
//        }
//
//        super.addWindowListener(this);
//        super.addWindowFocusListener(this);
//        super.addWindowStateListener(this);
//
//        moverParaCentroTela();
//        super.pack();
//    }
//
//    /**
//     * Caso o valor passado por parâmetro seja true, a tela cheia será ativada.
//     *
//     * @param telaCheia Define se a tela cheia será ativada ou não
//     */
//    private void ativarTelaCheia(Boolean telaCheia) {
//        this.telaCheia = telaCheia;
//
//        if (telaCheia) {
//            setDimensoes(getComprimentoTelaComputador(), getAlturaTelaComputador());
//            super.setExtendedState(Frame.MAXIMIZED_BOTH);
//
//            //este método pode ser executado apenas no construtor
//            super.setUndecorated(true);
//        }
//    }
//    //</editor-fold>
//
//    /**
//     * Alterador das dimensões da Janea e do PainelDesenho
//     *
//     * @param comprimento O valor do novo comprimento
//     * @param altura O valor da nova altura
//     */
//    public void setDimensoes(Integer comprimento, Integer altura) {
//        if (comprimento > 0 && altura > 0) {
//            janela.setSize(new Dimension(getComprimento(), getAltura()));
//            janela.setPreferredSize(new Dimension(getComprimento(), getAltura()));
//            janela.pack();
//        }
//    }
//    
//    public Integer getComprimento(){
//        return janela.getWidth();
//    }
//    
//    public Integer getAltura(){
//        return janela.getHeight();
//    }
//
//    //<editor-fold defaultstate="collapsed" desc="Métodos: Resolução de Tela do Computador">
//    private static final Toolkit tk = Toolkit.getDefaultToolkit();
//    private static final Dimension d = tk.getScreenSize();
//
//    /**
//     * Retorna o comprimento da rezolução de tela atual.
//     *
//     * @return int
//     */
//    public static Integer getComprimentoTelaComputador() {
//        return d.width;
//    }
//
//    /**
//     * Retorna a altura da rezolução de tela atual.
//     *
//     * @return int
//     */
//    public static Integer getAlturaTelaComputador() {
//        return d.height;
//    }
//
//    /**
//     * Retorna a proporção da rezolução da tela atual.
//     *
//     * @return double
//     */
//    public static Double getProporcaoTelaComputador() {
//        return (double) d.width / (double) d.height;
//    }
//    //</editor-fold>
//
//    //<editor-fold defaultstate="collapsed" desc="Métodos: controle do List<PainelConteudo>">
//    public void adicionarPainelConteudo(PainelConteudo... novosPaineis) {
//        for (PainelConteudo painel : novosPaineis) {
//            janela.setContentPane(painel);
//            paineis.add(painel);
//            
//            painel.setVisible(false);
//            painel.setSize(new Dimension(getComprimento(), getAltura()));
//            painel.setPreferredSize(new Dimension(getComprimento(), getAltura()));
//            painel.setOpaque(true);
//        }
//    }
//
//    public void adicionarPainelConteudo(Integer indicePainelAtivo, PainelConteudo... novosPaineis) {
//        for (Integer contador = 0; contador < paineis.size(); contador++) {
//            janela.setContentPane(novosPaineis[contador]);
//            paineis.add(novosPaineis[contador]);
//            
//            if (indicePainelAtivo == contador) {
//                novosPaineis[contador].setVisible(true);
//            } else {
//                novosPaineis[contador].setVisible(false);                
//            }
//            
//            novosPaineis[contador].setSize(new Dimension(getComprimento(), getAltura()));
//            novosPaineis[contador].setPreferredSize(new Dimension(getComprimento(), getAltura()));
//            novosPaineis[contador].setOpaque(true);
//        }
//    }
//
//    public PainelConteudo getPainelConteudo(Integer indicePainel) {
//        return paineis.get(indicePainel);
//    }
//
//    public void removerPainelConteudo(Integer indicePainelProcurado) {
//        paineis.remove(indicePainelProcurado);
//    }
//
//    public void removerPainelConteudo(PainelConteudo painelProcurado) {
//        paineis.remove(painelProcurado);
//    }
//
//    public Integer getQuantidadePainelConteudo() {
//        return paineis.size();
//    }
//
//    public void trocarPainelConteudo(Integer indicePainelProcurado) {
//        for (Integer contador = 0; contador < paineis.size(); contador++) {
//            if (indicePainelProcurado == contador) {
//                paineis.get(contador).setVisible(true);
//            } else {
//                paineis.get(contador).setVisible(false);
//            }
//        }
//    }
//    //</editor-fold>
//
//    
//    /**
//     * Retorna se a JanelaDesenho está em tela cheia ou não.
//     * @return boolean
//     */
//    public Boolean isTelaCheia(){
//        return janela.telaCheia;
//    }
//    
//    /**
//     * Alinhador da JanelaDesenho ao centro exato da tela.
//     */
//    public void moverParaCentroTela(){
//        super.setLocation(
//                (ResolucaoTelaSO.getComprimento() / 2) - (super.getWidth() / 2), 
//                (ResolucaoTelaSO.getAltura() / 2) - (super.getHeight() / 2)
//        );
//    }
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    //<editor-fold defaultstate="collapsed" desc="Classe aninhada Janela">
//    private class Janela extends JFrame {
//        
//        Boolean telaCheia;
//        
//        //<editor-fold defaultstate="collapsed" desc="Construtores">
//        public Janela(Boolean telaCheia) {
//            super("Janela Personalizada do seu app");
//
//            Integer tamanhoTela = JanelaPersonalizada
//                    .getProporcaoTelaComputador()
//                    .intValue() * 300;
//
//            iniciarJanela(
//                    tamanhoTela,
//                    tamanhoTela,
//                    telaCheia
//            );
//        }
//        //</editor-fold>
//
//        //<editor-fold defaultstate="collapsed" desc="Métodos: Auxiliares">
//        /**
//         * Executa a inicialização de todos os componentes básicos da janela.
//         *
//         * @param comprimento O comprimento da janela
//         * @param altura A altura da janela
//         * @param iniciarEmTelaCheia A janela deve ser no modo de tela cheia?
//         */
//        private void iniciarJanela(
//                Integer comprimento,
//                Integer altura,
//                Boolean iniciarEmTelaCheia
//        ) {
//            if (iniciarEmTelaCheia) {
//                ativarTelaCheia(iniciarEmTelaCheia);
//            } else {
//                this.telaCheia = iniciarEmTelaCheia;
//                setDimensoes(comprimento, altura);
//            }
//
//            super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//            super.setAutoRequestFocus(true);
//            super.setResizable(false);
//            super.setDefaultLookAndFeelDecorated(true);
//
//            moverParaCentroTela();
//            super.pack();
//        }
//
//        /**
//         * Caso o valor passado por parâmetro seja true, a tela cheia será
//         * ativada.
//         *
//         * @param telaCheia Define se a tela cheia será ativada ou não
//         */
//        private void ativarTelaCheia(Boolean telaCheia) {
//            this.telaCheia = telaCheia;
//
//            if (telaCheia) {
//                setDimensoes(getComprimentoTelaComputador(), getAlturaTelaComputador());
//                super.setExtendedState(Frame.MAXIMIZED_BOTH);
//
//                //este método pode ser executado apenas no construtor
//                super.setUndecorated(true);
//            }
//        }
//        //</editor-fold>
//
//        /**
//         * Alterador das dimensões da Janea e do PainelDesenho
//         *
//         * @param comprimento O valor do novo comprimento
//         * @param altura O valor da nova altura
//         */
//        public void setDimensoes(Integer comprimento, Integer altura) {
//            if (comprimento > 0 && altura > 0) {
//                super.setSize(comprimento, altura);
//                super.pack();
//            }
//        }
//    }
//    //</editor-fold>
//
//}
