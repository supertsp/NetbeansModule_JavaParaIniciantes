package javaparainiciantes;

import conteudojanelapersonalizada.PainelConteudo;
import java.math.BigDecimal;
import entradasaida.Console;
import entradasaida.*;
import ferramentas.ExecucaoParalela;
import ferramentas.padroes.MetodoExecutavelParalelamente;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.PaintContext;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;
import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.plaf.ButtonUI;

public class Executavel{

    public static void main(String[] args) {

        PainelConteudo painel01 = new PainelConteudo();
        painel01.setCorDeFundo("#d1d1d1"); //cinza alaranjado      
        painel01.getJPanel().setBorder(BorderFactory.createBevelBorder(1));
        
        JButton botaoTela1 = createButton("tela 01", Color.gray, 10, 50);
        botaoTela1.setForeground(Color.MAGENTA);
        
        //<editor-fold defaultstate="collapsed" desc="Bordas">
//        Border borda = BorderFactory.createLineBorder(Color.black, 5, false);
        
//        Border borda = BorderFactory.createTitledBorder("hello mundo");
//        Border borda = BorderFactory.createStrokeBorder(
//                new BasicStroke(
//                        4, 
//                        BasicStroke.CAP_ROUND, 
//                        BasicStroke.JOIN_ROUND
//                )
//        );
//        Border borda = BorderFactory.createStrokeBorder(
//                new BasicStroke(
//                        4, 
//                        BasicStroke.CAP_ROUND, 
//                        BasicStroke.JOIN_ROUND
//                ),
//                new GradientPaint(0, 0, Color.black, 0, 0, Color.black)
//        );
//        Border borda = BorderFactory.create
        //</editor-fold>
        Border borda = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black);
        botaoTela1.setBorder(borda);
        botaoTela1.setBorderPainted(false);
//        botaoTela1.setContentAreaFilled(false);
        
        JTextField inputTela01 = createTextField("placeholder tela 01", Color.DARK_GRAY, 5, 100);
        inputTela01.setForeground(Color.MAGENTA);
        inputTela01.setBorder(BorderFactory.createEmptyBorder());
//        inputTela01.
        
        painel01.adicionarComponenteDePainelConteudo(botaoTela1);
        painel01.adicionarComponenteDePainelConteudo(inputTela01);

        PainelConteudo painel02 = new PainelConteudo();
        painel02.setCorDeFundo("#ed590a"); //laranja
        JButton botaoTela2 = createButton("tela 01", Color.gray, 10, 60);
        JTextField inputTela02 = createTextField("placeholder tela 01", Color.DARK_GRAY, 5, 110);
//        painel02.adicionarComponenteDePainelConteudo(botaoTela2);
//        painel02.adicionarComponenteDePainelConteudo(inputTela02);

        PainelConteudo painel03 = new PainelConteudo();
        painel03.setCorDeFundo("#0aeddd"); //verde azulado
        JButton botaoTela3 = createButton("tela 01", Color.gray, 10, 70);
        JTextField inputTela03 = createTextField("placeholder tela 01", Color.DARK_GRAY, 5, 120);
//        painel03.adicionarComponenteDePainelConteudo(botaoTela3);
//        painel03.adicionarComponenteDePainelConteudo(inputTela03);

        JanelaPersonalizada janela = new JanelaPersonalizada();
        janela.adicionarPainelConteudo(0, painel01, painel02, painel03);

        janela.setCorDeFundo("000000");
//        janela.getJFrame()
        

//        for (int cont = 0; cont < 2000; cont++) {
//            janela.incrementarDimensao(1);
//
//            System.out.println("Dimensao: " + janela.getDimensaoComprimento() + "x" + janela.getDimensaoAltura());
//
//            ExecucaoParalela.pausar(.05);
//        }

//        try {
//            int painelAtivo = 0;
//            for (int conto = 0; conto < 5; conto++) {
//                Thread.sleep(1000);
//                janela.trocarPainelConteudo(painelAtivo);
//                
//                painelAtivo++;
//                
//                if (painelAtivo >= janela.getQuantidadePainelConteudo()) {
//                    painelAtivo = 0;
//                }
//            }
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Executavel.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    private static JButton createButton(String text, Color color, int x, int y) {
        JButton button = new JButton(text);
        button.setOpaque(true);
        button.setDoubleBuffered(true);

        button.setVerticalAlignment(JButton.TOP);
        button.setHorizontalAlignment(JButton.CENTER);

//        button.setIgnoreRepaint(true);
//        button.setBackground(color);
//        button.setForeground(Color.black);
//        button.setBorder(BorderFactory.createLineBorder(Color.black));
        button.setBounds(x, y, 100, 90);
        return button;
    }

    private static JTextField createTextField(String text, Color color, int x, int y) {
        JTextField textField = new JTextField(text);
        textField.setOpaque(true);
        textField.setDoubleBuffered(true);

//        textField.setVerticalAlignment(JButton.TOP);
        textField.setHorizontalAlignment(JButton.CENTER);

//        textField.setIgnoreRepaint(true);
//        button.setBackground(color);
//        textField.setForeground(Color.black);
//        textField.setBorder(BorderFactory.createLineBorder(Color.black));
        textField.setBounds(x, y, 100, 90);
        return textField;
    }
    

}
