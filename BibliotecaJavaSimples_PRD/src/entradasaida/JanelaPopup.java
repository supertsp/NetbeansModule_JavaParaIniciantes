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
package entradasaida;

import conteudo.ImagemBitmap;
import conteudo.Cor;
import conteudo.FonteTexto;
import java.awt.*;
import java.math.BigDecimal;
import javax.swing.*;
import static javax.swing.JOptionPane.*;
import javax.swing.border.Border;

/**
 * Classe com métodos estáticos que facilitam as operações de "leitura" e
 * "escrita" (E/S) de variáveis via Janela Popup. Os tipos de dados compatíveis
 * são:
 * <dl>
 * <dd>• <code>String</code>: dado (objeto) do tipo texto. Ex.: "abc";
 * <dd>• <code>Character</code>: dado (objeto) do tipo texto (apenas uma letra)
 * e numérico inteiro. Ex.: 'a' ou 13;
 * <dd>• <code>Boolean</code>: dado (objeto) do tipo lógico. Ex.: true ou false;
 * <dd>• <code>Integer</code>: dado (objeto) do tipo numérico inteiro. Ex.: 1,
 * 13 ou 50100200;
 * <dd>• <code>Float</code>: dado (objeto) do tipo numérico real de baixa
 * precisão. Ex.: 1f, 0.5f, .7f ou 50100200.539f;
 * <dd>• <code>Double</code>: dado (objeto) do tipo numérico real de precisão
 * dupla. Ex.: 1d, 0.5, .7 ou 50100200.539;
 * <dd>• <code>BigDecimal</code>: dado (objeto) do tipo numérico real de
 * precisão exata. Ex.: new BigDecimal("1.46") ou new BigDecimal("50100200.539")
 * </dl>
 *
 * <br><br><small>Criado em: 06/03/2019</small>
 *
 * @author Tiago Penha Pedroso
 * @version 1.0
 */
public class JanelaPopup {

    /**
     * Enum (Lista de Constantes) que define todas as possíveis posições de uma
     * <code>ImagemBitmap</code> dentro de uma mensagem.
     */
    public enum PosicaoImagem {
        SUPERIOR,
        INFERIOR,
        ESQUERDA,
        DIREITA
    }

    // <editor-fold defaultstate="collapsed" desc="Constantes String NOVA_LINHA_**">
    /**
     * Constante de <code>String</code> que contém 1 quebra de linha.
     */
    public static final String NOVA_LINHA_01 = "\n";

    /**
     * Constante de <code>String</code> que contém 2 quebras de linha.
     */
    public static final String NOVA_LINHA_02 = "\n\n";

    /**
     * Constante de <code>String</code> que contém 3 quebras de linha.
     */
    public static final String NOVA_LINHA_03 = "\n\n\n";

    /**
     * Constante de <code>String</code> que contém 4 quebras de linha.
     */
    public static final String NOVA_LINHA_04 = "\n\n\n\n";

    /**
     * Constante de <code>String</code> que contém 5 quebras de linha.
     */
    public static final String NOVA_LINHA_05 = "\n\n\n\n\n";

    /**
     * Constante de <code>String</code> que contém 6 quebras de linha.
     */
    public static final String NOVA_LINHA_06 = "\n\n\n\n\n\n";

    /**
     * Constante de <code>String</code> que contém 7 quebras de linha.
     */
    public static final String NOVA_LINHA_07 = "\n\n\n\n\n\n\n";

    /**
     * Constante de <code>String</code> que contém 8 quebras de linha.
     */
    public static final String NOVA_LINHA_08 = "\n\n\n\n\n\n\n\n";

    /**
     * Constante de <code>String</code> que contém 9 quebras de linha.
     */
    public static final String NOVA_LINHA_09 = "\n\n\n\n\n\n\n\n\n";

    /**
     * Constante de <code>String</code> que contém 10 quebras de linha.
     */
    public static final String NOVA_LINHA_10 = "\n\n\n\n\n\n\n\n\n\n";
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Auxiliar: iniciarTemplateDePopup() : void">
    private static JPanel painel = new JPanel(true);
    private static BasicLabel mensagemFinal = new BasicLabel();
    private static FonteTexto fontMonospaced = new FonteTexto(15, FonteTexto.Espessura.NEGRITO_ITALICO, "Consolas");
    private static Cor corCinzaEscuro = new Cor("3C3f41");
    private static Cor corCinzaClaro = new Cor("727A7C");
    private static Cor corCinzaMaisClaro = new Cor("b4c1c4");

    private static void iniciarTemplateDePopup() {
        //site dicas:
        //http://www.java2s.com/Tutorial/Java/0240__Swing/SettingJOptionPanebuttonlabelstoFrench.htm
        //http://nadeausoftware.com/articles/2010/12/java_tip_how_use_systemcolors_access_os_user_interface_theme_colors

        //Mudando JOptionPane
        UIManager.put("OptionPane.background", corCinzaEscuro.getObjetoColor());
        UIManager.put("OptionPane.okButtonText", "Inserir");

        //Mudando JPanel
        UIManager.put("Panel.background", corCinzaEscuro.getObjetoColor());

        //Mudando JButton
        UIManager.put("Button.background", corCinzaClaro.getObjetoColor());
        UIManager.put("Button.foreground", corCinzaMaisClaro.getObjetoColor());
        UIManager.put("Button.font", fontMonospaced.getObjetoFont());

        //Mudando JTextField
        Border bordaInput = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.gray);
        UIManager.put("TextField.background", corCinzaEscuro.getObjetoColor());
        UIManager.put("TextField.foreground", Color.white);
        UIManager.put("TextField.border", bordaInput);
        UIManager.put("TextField.font", mensagemFinal.getFont());

        //Preparando painel para ficar transparente e exibir melhor a imagem
        painel.setOpaque(false);
        painel.setBackground(Cor.TRANSPARENTE.getObjetoColor());
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="lerString(String mensagemParaUsuario) : String|null">
    /**
     * Executa a operação de "leitura" de uma variável (objeto) do tipo
     * <code>String</code>.
     *
     * @param mensagemParaUsuario A mensagem a ser exibida para o usuário.
     * @return A <code>String</code> lida ou <code>null</code> em caso de erro.
     */
    public static String lerString(String mensagemParaUsuario) {
        try {
            iniciarTemplateDePopup();
            mensagemFinal.setText(mensagemParaUsuario);
            return showInputDialog(
                    null,
                    mensagemFinal,
                    "Operação: LEITURA  -  Tipo: String",
                    PLAIN_MESSAGE
            );
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="lerString(String mensagemParaUsuario, Object[s] formatParams) : String|null">
    /**
     * Executa a operação de "leitura" de uma variável (objeto) do tipo
     * <code>String</code>. <br>
     * Com este método é possível formatar a mensagem com Strings especiais:
     * <dl>
     * <dd>• "%s": para substituir por uma variável <code>String</code>
     * <dd>• "%d": para substituir por uma variável <code>Integer</code>
     * <dd>• "%.2f": para substituir por uma variável
     * <code>Float</code>/<code>Double</code> com 2 casas decimais de exibição
     * </dl>
     *
     * * @see
     * <a href="https://docs.oracle.com/javase/10/docs/api/java/util/Formatter.html">
     * String Formatter</a>
     *
     * @param mensagemParaUsuario A mensagem a ser exibida para o usuário.
     * @param variaveisDeSubstituicao As variáveis que irão substituir as
     * Strings especiais.
     * @return A <code>String</code> lida ou <code>null</code> em caso de erro.
     */
    public static String lerString(String mensagemParaUsuario, Object... variaveisDeSubstituicao) {
        try {
            iniciarTemplateDePopup();
            mensagemFinal.setText(String.format(
                    mensagemParaUsuario, variaveisDeSubstituicao)
            );
            return showInputDialog(
                    null,
                    mensagemFinal,
                    "Operação: LEITURA  -  Tipo: String",
                    PLAIN_MESSAGE
            );
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>

    /**
     * Executa a operação de "leitura" de uma variável (objeto) do tipo
     * <code>String</code>.
     *
     * @param imagemExplicativaDaMensagem Uma imagem qualquer a ser exibida.
     * @param mensagemParaUsuario A mensagem a ser exibida para o usuário.
     * @return A <code>String</code> lida ou <code>null</code> em caso de erro.
     */
    public static String lerString(
            ImagemBitmap imagemExplicativaDaMensagem,
            String mensagemParaUsuario
    ) {
        return lerString(imagemExplicativaDaMensagem, PosicaoImagem.ESQUERDA, mensagemParaUsuario);
    }

    /**
     * Executa a operação de "leitura" de uma variável (objeto) do tipo
     * <code>String</code>.
     *
     * @param imagemExplicativaDaMensagem Uma imagem qualquer a ser exibida.
     * @param posicaoImagem A posição da imagem no popup.
     * @param mensagemParaUsuario A mensagem a ser exibida para o usuário.
     * @return A <code>String</code> lida ou <code>null</code> em caso de erro.
     */
    public static String lerString(
            ImagemBitmap imagemExplicativaDaMensagem,
            PosicaoImagem posicaoImagem,
            String mensagemParaUsuario
    ) {
        try {
            iniciarTemplateDePopup();
            mensagemFinal.setText(mensagemParaUsuario);

            // <editor-fold defaultstate="collapsed" desc="Acerta Imagem na posição escolhida">
            switch (posicaoImagem) {
                case SUPERIOR:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    painel.add(mensagemFinal);
                    break;

                case INFERIOR:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                    painel.add(mensagemFinal);
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    break;

                case ESQUERDA:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    painel.add(mensagemFinal);
                    break;

                case DIREITA:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                    painel.add(mensagemFinal);
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    break;
            }
            // </editor-fold>

            return showInputDialog(
                    null,
                    painel,
                    "Operação: LEITURA  -  Tipo: String",
                    PLAIN_MESSAGE
            );
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Executa a operação de "leitura" de uma variável (objeto) do tipo
     * <code>String</code>. <br>
     * Com este método é possível formatar a mensagem com Strings especiais:
     * <dl>
     * <dd>• "%s": para substituir por uma variável <code>String</code>
     * <dd>• "%d": para substituir por uma variável <code>Integer</code>
     * <dd>• "%.2f": para substituir por uma variável
     * <code>Float</code>/<code>Double</code> com 2 casas decimais de exibição
     * </dl>
     *
     * * @see
     * <a href="https://docs.oracle.com/javase/10/docs/api/java/util/Formatter.html">
     * String Formatter</a>
     *
     * @param imagemExplicativaDaMensagem Uma imagem qualquer a ser exibida.
     * @param mensagemParaUsuario A mensagem a ser exibida para o usuário.
     * @param variaveisDeSubstituicao As variáveis que irão substituir as
     * Strings especiais.
     * @return A <code>String</code> lida ou <code>null</code> em caso de erro.
     */
    public static String lerString(
            ImagemBitmap imagemExplicativaDaMensagem,
            String mensagemParaUsuario,
            Object... variaveisDeSubstituicao
    ) {
        return lerString(imagemExplicativaDaMensagem, PosicaoImagem.ESQUERDA, mensagemParaUsuario, variaveisDeSubstituicao);
    }
    
    /**
     * Executa a operação de "leitura" de uma variável (objeto) do tipo
     * <code>String</code>. <br>
     * Com este método é possível formatar a mensagem com Strings especiais:
     * <dl>
     * <dd>• "%s": para substituir por uma variável <code>String</code>
     * <dd>• "%d": para substituir por uma variável <code>Integer</code>
     * <dd>• "%.2f": para substituir por uma variável
     * <code>Float</code>/<code>Double</code> com 2 casas decimais de exibição
     * </dl>
     *
     * * @see
     * <a href="https://docs.oracle.com/javase/10/docs/api/java/util/Formatter.html">
     * String Formatter</a>
     *
     * @param imagemExplicativaDaMensagem Uma imagem qualquer a ser exibida.
     * @param posicaoImagem A posição da imagem no popup.
     * @param mensagemParaUsuario A mensagem a ser exibida para o usuário.
     * @param variaveisDeSubstituicao As variáveis que irão substituir as
     * Strings especiais.
     * @return A <code>String</code> lida ou <code>null</code> em caso de erro.
     */
    public static String lerString(
            ImagemBitmap imagemExplicativaDaMensagem,
            PosicaoImagem posicaoImagem,
            String mensagemParaUsuario,
            Object... variaveisDeSubstituicao
    ) {
        try {
            iniciarTemplateDePopup();
            mensagemFinal.setText(String.format(
                    mensagemParaUsuario, variaveisDeSubstituicao)
            );

            // <editor-fold defaultstate="collapsed" desc="Acerta Imagem na posição escolhida">
            switch (posicaoImagem) {
                case SUPERIOR:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    painel.add(mensagemFinal);
                    break;

                case INFERIOR:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                    painel.add(mensagemFinal);
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    break;

                case ESQUERDA:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    painel.add(mensagemFinal);
                    break;

                case DIREITA:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                    painel.add(mensagemFinal);
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    break;
            }
            // </editor-fold>

            return showInputDialog(
                    null,
                    painel,
                    "Operação: LEITURA  -  Tipo: String",
                    PLAIN_MESSAGE
            );
        } catch (Exception e) {
            return null;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="lerCharacter(String mensagemParaUsuario) : Character|null">
    /**
     * Executa a operação de "leitura" de uma variável (objeto) do tipo
     * <code>Character</code>. <br>
     *
     * @param mensagemParaUsuario A mensagem a ser exibida para o usuário.
     * @return O <code>Character</code> lido ou <code>null</code> em caso de
     * erro.
     */
    public static Character lerCharacter(String mensagemParaUsuario) {
        try {
            iniciarTemplateDePopup();
            mensagemFinal.setText(mensagemParaUsuario);
            return showInputDialog(
                    null,
                    mensagemFinal,
                    "Operação: LEITURA  -  Tipo: Character",
                    PLAIN_MESSAGE
            ).charAt(0);
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="lerCharacter(String mensagemParaUsuario, Object[s] variaveisDeSubstituicao) : Character|null">
    /**
     * Executa a operação de "leitura" de uma variável (objeto) do tipo
     * <code>Character</code>. <br>
     * Com este método é possível formatar a mensagem com Strings especiais:
     * <dl>
     * <dd>• "%s": para substituir por uma variável <code>String</code>
     * <dd>• "%d": para substituir por uma variável <code>Integer</code>
     * <dd>• "%.2f": para substituir por uma variável
     * <code>Float</code>/<code>Double</code> com 2 casas decimais de exibição
     * </dl>
     *
     * * @see
     * <a href="https://docs.oracle.com/javase/10/docs/api/java/util/Formatter.html">
     * String Formatter</a>
     *
     * @param mensagemParaUsuario A mensagem a ser exibida para o usuário.
     * @param variaveisDeSubstituicao As variáveis que irão substituir as
     * Strings especiais.
     * @return O <code>Character</code> lido ou <code>null</code> em caso de
     * erro.
     */
    public static Character lerCharacter(String mensagemParaUsuario, Object... variaveisDeSubstituicao) {
        try {
            iniciarTemplateDePopup();
            mensagemFinal.setText(String.format(
                    mensagemParaUsuario, variaveisDeSubstituicao)
            );
            return showInputDialog(
                    null,
                    mensagemFinal,
                    "Operação: LEITURA  -  Tipo: Character",
                    PLAIN_MESSAGE
            ).charAt(0);
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>

    public static Character lerCharacter(
            ImagemBitmap imagemExplicativaDaMensagem,
            String mensagemParaUsuario
    ) {
        return lerCharacter(imagemExplicativaDaMensagem, PosicaoImagem.ESQUERDA, mensagemParaUsuario);
    }

    public static Character lerCharacter(
            ImagemBitmap imagemExplicativaDaMensagem,
            PosicaoImagem posicaoImagem,
            String mensagemParaUsuario
    ) {
        try {
            iniciarTemplateDePopup();
            mensagemFinal.setText(mensagemParaUsuario);

            // <editor-fold defaultstate="collapsed" desc="Acerta Imagem na posição escolhida">
            switch (posicaoImagem) {
                case SUPERIOR:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    painel.add(mensagemFinal);
                    break;

                case INFERIOR:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                    painel.add(mensagemFinal);
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    break;

                case ESQUERDA:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    painel.add(mensagemFinal);
                    break;

                case DIREITA:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                    painel.add(mensagemFinal);
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    break;
            }
            // </editor-fold>

            return showInputDialog(
                    null,
                    painel,
                    "Operação: LEITURA  -  Tipo: Character",
                    PLAIN_MESSAGE
            ).charAt(0);
        } catch (Exception e) {
            return null;
        }
    }

    public static Character lerCharacter(
            ImagemBitmap imagemExplicativaDaMensagem,
            String mensagemParaUsuario,
            Object... variaveisDeSubstituicao
    ) {
        return lerCharacter(imagemExplicativaDaMensagem, PosicaoImagem.ESQUERDA, mensagemParaUsuario, variaveisDeSubstituicao);
    }

    public static Character lerCharacter(
            ImagemBitmap imagemExplicativaDaMensagem,
            PosicaoImagem posicaoImagem,
            String mensagemParaUsuario,
            Object... variaveisDeSubstituicao
    ) {
        try {
            iniciarTemplateDePopup();
            mensagemFinal.setText(String.format(
                    mensagemParaUsuario, variaveisDeSubstituicao)
            );

            // <editor-fold defaultstate="collapsed" desc="Acerta Imagem na posição escolhida">
            switch (posicaoImagem) {
                case SUPERIOR:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    painel.add(mensagemFinal);
                    break;

                case INFERIOR:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                    painel.add(mensagemFinal);
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    break;

                case ESQUERDA:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    painel.add(mensagemFinal);
                    break;

                case DIREITA:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                    painel.add(mensagemFinal);
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    break;
            }
            // </editor-fold>

            return showInputDialog(
                    null,
                    painel,
                    "Operação: LEITURA  -  Tipo: Character",
                    PLAIN_MESSAGE
            ).charAt(0);
        } catch (Exception e) {
            return null;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="lerBoolean(String mensagemParaUsuario) : Boolean|null">
    /**
     * Executa a operação de "leitura" de uma variável (objeto) do tipo
     * <code>Boolean</code>. <br>
     *
     * @param mensagemParaUsuario A mensagem a ser exibida para o usuário.
     * @return O <code>Boolean</code> lido ou <code>null</code> em caso de erro.
     */
    public static Boolean lerBoolean(String mensagemParaUsuario) {
        try {
            iniciarTemplateDePopup();
            mensagemFinal.setText(mensagemParaUsuario);

            return Boolean.parseBoolean(
                    showInputDialog(
                            null,
                            mensagemFinal,
                            "Operação: LEITURA  -  Tipo: Boolean",
                            PLAIN_MESSAGE
                    )
            );
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="lerBoolean(String mensagemParaUsuario, Object[s] variaveisDeSubstituicao) : Boolean|null">
    /**
     * Executa a operação de "leitura" de uma variável (objeto) do tipo
     * <code>Boolean</code>. <br>
     * Com este método é possível formatar a mensagem com Strings especiais:
     * <dl>
     * <dd>• "%s": para substituir por uma variável <code>String</code>
     * <dd>• "%d": para substituir por uma variável <code>Integer</code>
     * <dd>• "%.2f": para substituir por uma variável
     * <code>Float</code>/<code>Double</code> com 2 casas decimais de exibição
     * </dl>
     *
     * @see
     * <a href="https://docs.oracle.com/javase/10/docs/api/java/util/Formatter.html">
     * String Formatter</a>
     *
     * @param mensagemParaUsuario A mensagem a ser exibida para o usuário.
     * @param variaveisDeSubstituicao As variáveis que irão substituir as
     * Strings especiais.
     * @return O <code>Boolean</code> lido ou <code>null</code> em caso de erro.
     */
    public static Boolean lerBoolean(String mensagemParaUsuario, Object... variaveisDeSubstituicao) {
        try {
            iniciarTemplateDePopup();
            mensagemFinal.setText(String.format(
                    mensagemParaUsuario, variaveisDeSubstituicao)
            );

            return Boolean.parseBoolean(
                    showInputDialog(
                            null,
                            mensagemFinal,
                            "Operação: LEITURA  -  Tipo: Boolean",
                            PLAIN_MESSAGE
                    )
            );
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>

    public static Boolean lerBoolean(
            ImagemBitmap imagemExplicativaDaMensagem,
            String mensagemParaUsuario
    ) {
        return lerBoolean(imagemExplicativaDaMensagem, PosicaoImagem.ESQUERDA, mensagemParaUsuario);
    }

    public static Boolean lerBoolean(
            ImagemBitmap imagemExplicativaDaMensagem,
            PosicaoImagem posicaoImagem,
            String mensagemParaUsuario
    ) {
        try {
            iniciarTemplateDePopup();
            mensagemFinal.setText(mensagemParaUsuario);

            // <editor-fold defaultstate="collapsed" desc="Acerta Imagem na posição escolhida">
            switch (posicaoImagem) {
                case SUPERIOR:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    painel.add(mensagemFinal);
                    break;

                case INFERIOR:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                    painel.add(mensagemFinal);
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    break;

                case ESQUERDA:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    painel.add(mensagemFinal);
                    break;

                case DIREITA:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                    painel.add(mensagemFinal);
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    break;
            }
            // </editor-fold>

            return Boolean.parseBoolean(
                    showInputDialog(
                            null,
                            painel,
                            "Operação: LEITURA  -  Tipo: Boolean",
                            PLAIN_MESSAGE
                    )
            );
        } catch (Exception e) {
            return null;
        }
    }

    public static Boolean lerBoolean(
            ImagemBitmap imagemExplicativaDaMensagem,
            String mensagemParaUsuario,
            Object... variaveisDeSubstituicao
    ) {
        return lerBoolean(imagemExplicativaDaMensagem, PosicaoImagem.ESQUERDA, mensagemParaUsuario, variaveisDeSubstituicao);
    }

    public static Boolean lerBoolean(
            ImagemBitmap imagemExplicativaDaMensagem,
            PosicaoImagem posicaoImagem,
            String mensagemParaUsuario,
            Object... variaveisDeSubstituicao
    ) {
        try {
            iniciarTemplateDePopup();
            mensagemFinal.setText(String.format(
                    mensagemParaUsuario, variaveisDeSubstituicao)
            );

            // <editor-fold defaultstate="collapsed" desc="Acerta Imagem na posição escolhida">
            switch (posicaoImagem) {
                case SUPERIOR:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    painel.add(mensagemFinal);
                    break;

                case INFERIOR:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                    painel.add(mensagemFinal);
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    break;

                case ESQUERDA:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    painel.add(mensagemFinal);
                    break;

                case DIREITA:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                    painel.add(mensagemFinal);
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    break;
            }
            // </editor-fold>

            return Boolean.parseBoolean(
                    showInputDialog(
                            null,
                            painel,
                            "Operação: LEITURA  -  Tipo: Boolean",
                            PLAIN_MESSAGE
                    )
            );
        } catch (Exception e) {
            return null;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="lerInteger(String mensagemParaUsuario) : Integer|null">
    /**
     * Executa a operação de "leitura" de uma variável (objeto) do tipo
     * <code>Integer</code>. <br>
     *
     * @param mensagemParaUsuario A mensagem a ser exibida para o usuário.
     * @return O <code>Integer</code> lido ou <code>null</code> em caso de erro.
     */
    public static Integer lerInteger(String mensagemParaUsuario) {
        try {
            iniciarTemplateDePopup();
            mensagemFinal.setText(mensagemParaUsuario);

            return Integer.parseInt(
                    showInputDialog(
                            null,
                            mensagemFinal,
                            "Operação: LEITURA  -  Tipo: Integer",
                            PLAIN_MESSAGE
                    )
            );
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="lerInteger(String mensagemParaUsuario, Object[s] variaveisDeSubstituicao) : Integer|null">
    /**
     * Executa a operação de "leitura" de uma variável (objeto) do tipo
     * <code>Integer</code>. <br>
     * Com este método é possível formatar a mensagem com Strings especiais:
     * <dl>
     * <dd>• "%s": para substituir por uma variável <code>String</code>
     * <dd>• "%d": para substituir por uma variável <code>Integer</code>
     * <dd>• "%.2f": para substituir por uma variável
     * <code>Float</code>/<code>Double</code> com 2 casas decimais de exibição
     * </dl>
     *
     * @see
     * <a href="https://docs.oracle.com/javase/10/docs/api/java/util/Formatter.html">
     * String Formatter</a>
     *
     * @param mensagemParaUsuario A mensagem a ser exibida para o usuário.
     * @param variaveisDeSubstituicao As variáveis que irão substituir as
     * Strings especiais.
     * @return O <code>Integer</code> lido ou <code>null</code> em caso de erro.
     */
    public static Integer lerInteger(String mensagemParaUsuario, Object... variaveisDeSubstituicao) {
        try {
            iniciarTemplateDePopup();
            mensagemFinal.setText(String.format(
                    mensagemParaUsuario, variaveisDeSubstituicao)
            );

            return Integer.parseInt(
                    showInputDialog(
                            null,
                            mensagemFinal,
                            "Operação: LEITURA  -  Tipo: Integer",
                            PLAIN_MESSAGE
                    )
            );
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>

    public static Integer lerInteger(
            ImagemBitmap imagemExplicativaDaMensagem,
            String mensagemParaUsuario
    ) {
        return lerInteger(imagemExplicativaDaMensagem, PosicaoImagem.ESQUERDA, mensagemParaUsuario);
    }

    public static Integer lerInteger(
            ImagemBitmap imagemExplicativaDaMensagem,
            PosicaoImagem posicaoImagem,
            String mensagemParaUsuario
    ) {
        try {
            iniciarTemplateDePopup();
            mensagemFinal.setText(mensagemParaUsuario);

            // <editor-fold defaultstate="collapsed" desc="Acerta Imagem na posição escolhida">
            switch (posicaoImagem) {
                case SUPERIOR:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    painel.add(mensagemFinal);
                    break;

                case INFERIOR:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                    painel.add(mensagemFinal);
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    break;

                case ESQUERDA:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    painel.add(mensagemFinal);
                    break;

                case DIREITA:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                    painel.add(mensagemFinal);
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    break;
            }
            // </editor-fold>

            return Integer.parseInt(
                    showInputDialog(
                            null,
                            painel,
                            "Operação: LEITURA  -  Tipo: Integer",
                            PLAIN_MESSAGE
                    )
            );
        } catch (Exception e) {
            return null;
        }
    }

    public static Integer lerInteger(
            ImagemBitmap imagemExplicativaDaMensagem,
            String mensagemParaUsuario,
            Object... variaveisDeSubstituicao
    ) {
        return lerInteger(imagemExplicativaDaMensagem, PosicaoImagem.ESQUERDA, mensagemParaUsuario, variaveisDeSubstituicao);
    }

    public static Integer lerInteger(
            ImagemBitmap imagemExplicativaDaMensagem,
            PosicaoImagem posicaoImagem,
            String mensagemParaUsuario,
            Object... variaveisDeSubstituicao
    ) {
        try {
            iniciarTemplateDePopup();
            mensagemFinal.setText(String.format(
                    mensagemParaUsuario, variaveisDeSubstituicao)
            );

            // <editor-fold defaultstate="collapsed" desc="Acerta Imagem na posição escolhida">
            switch (posicaoImagem) {
                case SUPERIOR:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    painel.add(mensagemFinal);
                    break;

                case INFERIOR:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                    painel.add(mensagemFinal);
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    break;

                case ESQUERDA:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    painel.add(mensagemFinal);
                    break;

                case DIREITA:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                    painel.add(mensagemFinal);
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    break;
            }
            // </editor-fold>

            return Integer.parseInt(
                    showInputDialog(
                            null,
                            painel,
                            "Operação: LEITURA  -  Tipo: Integer",
                            PLAIN_MESSAGE
                    )
            );
        } catch (Exception e) {
            return null;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="lerFloat(String mensagemParaUsuario) : Float|null">
    /**
     * Executa a operação de "leitura" de uma variável (objeto) do tipo
     * <code>Float</code>. <br>
     *
     * @param mensagemParaUsuario A mensagem a ser exibida para o usuário.
     * @return O <code>Float</code> lido ou <code>null</code> em caso de erro.
     */
    public static Float lerFloat(String mensagemParaUsuario) {
        try {
            iniciarTemplateDePopup();
            mensagemFinal.setText(mensagemParaUsuario);

            return Float.parseFloat(
                    showInputDialog(
                            null,
                            mensagemFinal,
                            "Operação: LEITURA  -  Tipo: Float",
                            PLAIN_MESSAGE
                    )
            );
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="lerFloat(String mensagemParaUsuario, Object[s] variaveisDeSubstituicao) : Float|null">
    /**
     * Executa a operação de "leitura" de uma variável (objeto) do tipo
     * <code>Float</code>. <br>
     * Com este método é possível formatar a mensagem com Strings especiais:
     * <dl>
     * <dd>• "%s": para substituir por uma variável <code>String</code>
     * <dd>• "%d": para substituir por uma variável <code>Integer</code>
     * <dd>• "%.2f": para substituir por uma variável
     * <code>Float</code>/<code>Double</code> com 2 casas decimais de exibição
     * </dl>
     *
     * @see
     * <a href="https://docs.oracle.com/javase/10/docs/api/java/util/Formatter.html">
     * String Formatter</a>
     *
     * @param mensagemParaUsuario A mensagem a ser exibida para o usuário.
     * @param variaveisDeSubstituicao As variáveis que irão substituir as
     * Strings especiais.
     * @return O <code>Float</code> lido ou <code>null</code> em caso de erro.
     */
    public static Float lerFloat(String mensagemParaUsuario, Object... variaveisDeSubstituicao) {
        try {
            iniciarTemplateDePopup();
            mensagemFinal.setText(String.format(
                    mensagemParaUsuario, variaveisDeSubstituicao)
            );

            return Float.parseFloat(
                    showInputDialog(
                            null,
                            mensagemFinal,
                            "Operação: LEITURA  -  Tipo: Float",
                            PLAIN_MESSAGE
                    )
            );
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>

    public static Float lerFloat(
            ImagemBitmap imagemExplicativaDaMensagem,
            String mensagemParaUsuario
    ) {
        return lerFloat(imagemExplicativaDaMensagem, PosicaoImagem.ESQUERDA, mensagemParaUsuario);
    }

    public static Float lerFloat(
            ImagemBitmap imagemExplicativaDaMensagem,
            PosicaoImagem posicaoImagem,
            String mensagemParaUsuario
    ) {
        try {
            iniciarTemplateDePopup();
            mensagemFinal.setText(mensagemParaUsuario);

            // <editor-fold defaultstate="collapsed" desc="Acerta Imagem na posição escolhida">
            switch (posicaoImagem) {
                case SUPERIOR:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    painel.add(mensagemFinal);
                    break;

                case INFERIOR:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                    painel.add(mensagemFinal);
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    break;

                case ESQUERDA:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    painel.add(mensagemFinal);
                    break;

                case DIREITA:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                    painel.add(mensagemFinal);
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    break;
            }
            // </editor-fold>

            return Float.parseFloat(
                    showInputDialog(
                            null,
                            painel,
                            "Operação: LEITURA  -  Tipo: Float",
                            PLAIN_MESSAGE
                    )
            );
        } catch (Exception e) {
            return null;
        }
    }

    public static Float lerFloat(
            ImagemBitmap imagemExplicativaDaMensagem,
            String mensagemParaUsuario,
            Object... variaveisDeSubstituicao
    ) {
        return lerFloat(imagemExplicativaDaMensagem, PosicaoImagem.ESQUERDA, mensagemParaUsuario, variaveisDeSubstituicao);
    }

    public static Float lerFloat(
            ImagemBitmap imagemExplicativaDaMensagem,
            PosicaoImagem posicaoImagem,
            String mensagemParaUsuario,
            Object... variaveisDeSubstituicao
    ) {
        try {
            iniciarTemplateDePopup();
            mensagemFinal.setText(String.format(
                    mensagemParaUsuario, variaveisDeSubstituicao)
            );

            // <editor-fold defaultstate="collapsed" desc="Acerta Imagem na posição escolhida">
            switch (posicaoImagem) {
                case SUPERIOR:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    painel.add(mensagemFinal);
                    break;

                case INFERIOR:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                    painel.add(mensagemFinal);
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    break;

                case ESQUERDA:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    painel.add(mensagemFinal);
                    break;

                case DIREITA:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                    painel.add(mensagemFinal);
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    break;
            }
            // </editor-fold>

            return Float.parseFloat(
                    showInputDialog(
                            null,
                            painel,
                            "Operação: LEITURA  -  Tipo: Float",
                            PLAIN_MESSAGE
                    )
            );
        } catch (Exception e) {
            return null;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="lerDouble(String mensagemParaUsuario) : Double|null">
    /**
     * Executa a operação de "leitura" de uma variável (objeto) do tipo
     * <code>Double</code>. <br>
     *
     * @param mensagemParaUsuario A mensagem a ser exibida para o usuário.
     * @return O <code>Double</code> lido ou <code>null</code> em caso de erro.
     */
    public static Double lerDouble(String mensagemParaUsuario) {
        try {
            iniciarTemplateDePopup();
            mensagemFinal.setText(mensagemParaUsuario);

            return Double.parseDouble(
                    showInputDialog(
                            null,
                            mensagemFinal,
                            "Operação: LEITURA  -  Tipo: Double",
                            PLAIN_MESSAGE
                    )
            );
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="lerDouble(String mensagemParaUsuario, Object[s] variaveisDeSubstituicao) : Double|null">
    /**
     * Executa a operação de "leitura" de uma variável (objeto) do tipo
     * <code>Double</code>. <br>
     * Com este método é possível formatar a mensagem com Strings especiais:
     * <dl>
     * <dd>• "%s": para substituir por uma variável <code>String</code>
     * <dd>• "%d": para substituir por uma variável <code>Integer</code>
     * <dd>• "%.2f": para substituir por uma variável
     * <code>Float</code>/<code>Double</code> com 2 casas decimais de exibição
     * </dl>
     *
     * @see
     * <a href="https://docs.oracle.com/javase/10/docs/api/java/util/Formatter.html">
     * String Formatter</a>
     *
     * @param mensagemParaUsuario A mensagem a ser exibida para o usuário.
     * @param variaveisDeSubstituicao As variáveis que irão substituir as
     * Strings especiais.
     * @return O <code>Double</code> lido ou <code>null</code> em caso de erro.
     */
    public static Double lerDouble(String mensagemParaUsuario, Object... variaveisDeSubstituicao) {
        try {
            iniciarTemplateDePopup();
            mensagemFinal.setText(String.format(
                    mensagemParaUsuario, variaveisDeSubstituicao)
            );

            return Double.parseDouble(
                    showInputDialog(
                            null,
                            mensagemFinal,
                            "Operação: LEITURA  -  Tipo: Double",
                            PLAIN_MESSAGE
                    )
            );
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>

    public static Double lerDouble(
            ImagemBitmap imagemExplicativaDaMensagem,
            String mensagemParaUsuario
    ) {
        return lerDouble(imagemExplicativaDaMensagem, PosicaoImagem.ESQUERDA, mensagemParaUsuario);
    }

    public static Double lerDouble(
            ImagemBitmap imagemExplicativaDaMensagem,
            PosicaoImagem posicaoImagem,
            String mensagemParaUsuario
    ) {
        try {
            iniciarTemplateDePopup();
            mensagemFinal.setText(mensagemParaUsuario);

            // <editor-fold defaultstate="collapsed" desc="Acerta Imagem na posição escolhida">
            switch (posicaoImagem) {
                case SUPERIOR:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    painel.add(mensagemFinal);
                    break;

                case INFERIOR:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                    painel.add(mensagemFinal);
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    break;

                case ESQUERDA:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    painel.add(mensagemFinal);
                    break;

                case DIREITA:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                    painel.add(mensagemFinal);
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    break;
            }
            // </editor-fold>

            return Double.parseDouble(
                    showInputDialog(
                            null,
                            painel,
                            "Operação: LEITURA  -  Tipo: Double",
                            PLAIN_MESSAGE
                    )
            );
        } catch (Exception e) {
            return null;
        }
    }

    public static Double lerDouble(
            ImagemBitmap imagemExplicativaDaMensagem,
            String mensagemParaUsuario,
            Object... variaveisDeSubstituicao
    ) {
        return lerDouble(imagemExplicativaDaMensagem, PosicaoImagem.ESQUERDA, mensagemParaUsuario, variaveisDeSubstituicao);
    }

    public static Double lerDouble(
            ImagemBitmap imagemExplicativaDaMensagem,
            PosicaoImagem posicaoImagem,
            String mensagemParaUsuario,
            Object... variaveisDeSubstituicao
    ) {
        try {
            iniciarTemplateDePopup();
            mensagemFinal.setText(String.format(
                    mensagemParaUsuario, variaveisDeSubstituicao)
            );

            // <editor-fold defaultstate="collapsed" desc="Acerta Imagem na posição escolhida">
            switch (posicaoImagem) {
                case SUPERIOR:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    painel.add(mensagemFinal);
                    break;

                case INFERIOR:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                    painel.add(mensagemFinal);
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    break;

                case ESQUERDA:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    painel.add(mensagemFinal);
                    break;

                case DIREITA:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                    painel.add(mensagemFinal);
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    break;
            }
            // </editor-fold>

            return Double.parseDouble(
                    showInputDialog(
                            null,
                            painel,
                            "Operação: LEITURA  -  Tipo: Double",
                            PLAIN_MESSAGE
                    )
            );
        } catch (Exception e) {
            return null;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="lerBigDecimal(String mensagemParaUsuario) : BigDecimal|null">
    /**
     * Executa a operação de "leitura" de uma variável (objeto) do tipo
     * <code>BigDecimal</code>. <br>
     *
     * @param mensagemParaUsuario A mensagem a ser exibida para o usuário.
     * @return O <code>BigDecimal</code> lido ou <code>null</code> em caso de
     * erro.
     */
    public static BigDecimal lerBigDecimal(String mensagemParaUsuario) {
        try {
            iniciarTemplateDePopup();
            mensagemFinal.setText(mensagemParaUsuario);

            return new BigDecimal(
                    showInputDialog(
                            null,
                            mensagemFinal,
                            "Operação: LEITURA  -  Tipo: BigDecimal",
                            PLAIN_MESSAGE
                    )
            );
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="lerBigDecimal(String mensagemParaUsuario, Object[s] variaveisDeSubstituicao) : BigDecimal|null">
    /**
     * Executa a operação de "leitura" de uma variável (objeto) do tipo
     * <code>BigDecimal</code>. <br>
     * Com este método é possível formatar a mensagem com Strings especiais:
     * <dl>
     * <dd>• "%s": para substituir por uma variável <code>String</code>
     * <dd>• "%d": para substituir por uma variável <code>Integer</code>
     * <dd>• "%.2f": para substituir por uma variável
     * <code>Float</code>/<code>Double</code> com 2 casas decimais de exibição
     * </dl>
     *
     * @see
     * <a href="https://docs.oracle.com/javase/10/docs/api/java/util/Formatter.html">
     * String Formatter</a>
     *
     * @param mensagemParaUsuario A mensagem a ser exibida para o usuário.
     * @param variaveisDeSubstituicao As variáveis que irão substituir as
     * Strings especiais.
     * @return O <code>BigDecimal</code> lido ou <code>null</code> em caso de
     * erro.
     */
    public static BigDecimal lerBigDecimal(String mensagemParaUsuario, Object... variaveisDeSubstituicao) {
        try {
            iniciarTemplateDePopup();
            mensagemFinal.setText(String.format(
                    mensagemParaUsuario, variaveisDeSubstituicao)
            );

            return new BigDecimal(
                    showInputDialog(
                            null,
                            mensagemFinal,
                            "Operação: LEITURA  -  Tipo: BigDecimal",
                            PLAIN_MESSAGE
                    )
            );
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>

    public static BigDecimal lerBigDecimal(
            ImagemBitmap imagemExplicativaDaMensagem,
            String mensagemParaUsuario
    ) {
        return lerBigDecimal(imagemExplicativaDaMensagem, PosicaoImagem.ESQUERDA, mensagemParaUsuario);
    }

    public static BigDecimal lerBigDecimal(
            ImagemBitmap imagemExplicativaDaMensagem,
            PosicaoImagem posicaoImagem,
            String mensagemParaUsuario
    ) {
        try {
            iniciarTemplateDePopup();
            mensagemFinal.setText(mensagemParaUsuario);

            // <editor-fold defaultstate="collapsed" desc="Acerta Imagem na posição escolhida">
            switch (posicaoImagem) {
                case SUPERIOR:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    painel.add(mensagemFinal);
                    break;

                case INFERIOR:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                    painel.add(mensagemFinal);
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    break;

                case ESQUERDA:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    painel.add(mensagemFinal);
                    break;

                case DIREITA:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                    painel.add(mensagemFinal);
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    break;
            }
            // </editor-fold>

            return new BigDecimal(
                    showInputDialog(
                            null,
                            painel,
                            "Operação: LEITURA  -  Tipo: BigDecimal",
                            PLAIN_MESSAGE
                    )
            );
        } catch (Exception e) {
            return null;
        }
    }

    public static BigDecimal lerBigDecimal(
            ImagemBitmap imagemExplicativaDaMensagem,
            String mensagemParaUsuario,
            Object... variaveisDeSubstituicao
    ) {
        return lerBigDecimal(imagemExplicativaDaMensagem, PosicaoImagem.ESQUERDA, mensagemParaUsuario, variaveisDeSubstituicao);
    }

    public static BigDecimal lerBigDecimal(
            ImagemBitmap imagemExplicativaDaMensagem,
            PosicaoImagem posicaoImagem,
            String mensagemParaUsuario,
            Object... variaveisDeSubstituicao
    ) {
        try {
            iniciarTemplateDePopup();
            mensagemFinal.setText(String.format(
                    mensagemParaUsuario, variaveisDeSubstituicao)
            );

            // <editor-fold defaultstate="collapsed" desc="Acerta Imagem na posição escolhida">
            switch (posicaoImagem) {
                case SUPERIOR:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    painel.add(mensagemFinal);
                    break;

                case INFERIOR:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                    painel.add(mensagemFinal);
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    break;

                case ESQUERDA:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    painel.add(mensagemFinal);
                    break;

                case DIREITA:
                    painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                    painel.add(mensagemFinal);
                    painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                    break;
            }
            // </editor-fold>

            return new BigDecimal(
                    showInputDialog(
                            null,
                            painel,
                            "Operação: LEITURA  -  Tipo: BigDecimal",
                            PLAIN_MESSAGE
                    )
            );
        } catch (Exception e) {
            return null;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="escreverString(String mensagemOuVariavel) : void">
    /**
     * Executa a operação de "escrita" de uma variável (objeto) do tipo
     * <code>String</code>. <br>
     *
     * @param mensagemOuVariavel A mensagem ou variável a ser exibida para o
     * usuário.
     */
    public static void escreverString(String mensagemOuVariavel) {
        iniciarTemplateDePopup();
        UIManager.put("OptionPane.okButtonText", "Fechar");
        mensagemFinal.setText(mensagemOuVariavel);

        showMessageDialog(
                null,
                mensagemFinal,
                "Operação: ESCRITA  -  Tipo: String",
                PLAIN_MESSAGE
        );
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="escreverString(String mensagemOuVariavel, Object[s] variaveisDeSubstituicao) : void">
    /**
     * Executa a operação de "escrita" de uma variável (objeto) do tipo
     * <code>String</code>. <br>
     * Com este método é possível formatar a mensagem com Strings especiais:
     * <dl>
     * <dd>• "%s": para substituir por uma variável <code>String</code>
     * <dd>• "%d": para substituir por uma variável <code>Integer</code>
     * <dd>• "%.2f": para substituir por uma variável
     * <code>Float</code>/<code>Double</code> com 2 casas decimais de exibição
     * </dl>
     *
     * @see
     * <a href="https://docs.oracle.com/javase/10/docs/api/java/util/Formatter.html">
     * String Formatter</a>
     *
     * @param mensagemOuVariavel A mensagem ou variável a ser exibida para o
     * usuário.
     * @param variaveisDeSubstituicao As variáveis que irão substituir as
     * Strings especiais.
     */
    public static void escreverString(String mensagemOuVariavel, Object... variaveisDeSubstituicao) {
        iniciarTemplateDePopup();
        UIManager.put("OptionPane.okButtonText", "Fechar");
        mensagemFinal.setText(String.format(
                mensagemOuVariavel, variaveisDeSubstituicao)
        );

        showMessageDialog(
                null,
                mensagemFinal,
                "Operação: ESCRITA  -  Tipo: String",
                PLAIN_MESSAGE
        );
    }
    // </editor-fold>

    public static void escreverString(
            ImagemBitmap imagemExplicativaDaMensagem,
            String mensagemOuVariavel
    ) {
        escreverString(imagemExplicativaDaMensagem, PosicaoImagem.ESQUERDA, mensagemOuVariavel);
    }

    public static void escreverString(
            ImagemBitmap imagemExplicativaDaMensagem,
            PosicaoImagem posicaoImagem,
            String mensagemOuVariavel
    ) {
        iniciarTemplateDePopup();
        UIManager.put("OptionPane.okButtonText", "Fechar");
        mensagemFinal.setText(mensagemOuVariavel);

        // <editor-fold defaultstate="collapsed" desc="Acerta Imagem na posição escolhida">
        switch (posicaoImagem) {
            case SUPERIOR:
                painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                painel.add(mensagemFinal);
                break;

            case INFERIOR:
                painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                painel.add(mensagemFinal);
                painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                break;

            case ESQUERDA:
                painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                painel.add(mensagemFinal);
                break;

            case DIREITA:
                painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                painel.add(mensagemFinal);
                painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                break;
        }
        // </editor-fold>

        showMessageDialog(
                null,
                painel,
                "Operação: ESCRITA  -  Tipo: String",
                PLAIN_MESSAGE
        );
    }

    public static void escreverString(
            ImagemBitmap imagemExplicativaDaMensagem,
            String mensagemOuVariavel,
            Object... variaveisDeSubstituicao
    ) {
        escreverString(imagemExplicativaDaMensagem, PosicaoImagem.ESQUERDA, mensagemOuVariavel, variaveisDeSubstituicao);
    }

    public static void escreverString(
            ImagemBitmap imagemExplicativaDaMensagem,
            PosicaoImagem posicaoImagem,
            String mensagemOuVariavel,
            Object... variaveisDeSubstituicao
    ) {
        iniciarTemplateDePopup();
        UIManager.put("OptionPane.okButtonText", "Fechar");
        mensagemFinal.setText(String.format(
                mensagemOuVariavel, variaveisDeSubstituicao)
        );

        // <editor-fold defaultstate="collapsed" desc="Acerta Imagem na posição escolhida">
        switch (posicaoImagem) {
            case SUPERIOR:
                painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                painel.add(mensagemFinal);
                break;

            case INFERIOR:
                painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                painel.add(mensagemFinal);
                painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                break;

            case ESQUERDA:
                painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                painel.add(mensagemFinal);
                break;

            case DIREITA:
                painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                painel.add(mensagemFinal);
                painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                break;
        }
        // </editor-fold>

        showMessageDialog(
                null,
                painel,
                "Operação: ESCRITA  -  Tipo: String",
                PLAIN_MESSAGE
        );
    }

    // <editor-fold defaultstate="collapsed" desc="escreverLinhaDeString(String mensagemOuVariavel) : void">
    /**
     * Executa a operação de "escrita" de uma variável (objeto) do tipo
     * <code>String</code> e logo após faz uma quebra de linha. <br>
     *
     * @param mensagemOuVariavel A mensagem ou variável a ser exibida para o
     * usuário.
     */
    public static void escreverLinhaDeString(String mensagemOuVariavel) {
        iniciarTemplateDePopup();
        UIManager.put("OptionPane.okButtonText", "Fechar");
        mensagemFinal.setText(mensagemOuVariavel + NOVA_LINHA_01);

        showMessageDialog(
                null,
                mensagemFinal,
                "Operação: ESCRITA  -  Tipo: String",
                PLAIN_MESSAGE
        );
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="escreverLinhaDeString(String mensagemOuVariavel, Object[s] variaveisDeSubstituicao) : void">
    /**
     * Executa a operação de "escrita" de uma variável (objeto) do tipo
     * <code>String</code> e logo após faz uma quebra de linha. <br>
     * Com este método é possível formatar a mensagem com Strings especiais:
     * <dl>
     * <dd>• "%s": para substituir por uma variável <code>String</code>
     * <dd>• "%d": para substituir por uma variável <code>Integer</code>
     * <dd>• "%.2f": para substituir por uma variável
     * <code>Float</code>/<code>Double</code> com 2 casas decimais de exibição
     * </dl>
     *
     * @see
     * <a href="https://docs.oracle.com/javase/10/docs/api/java/util/Formatter.html">
     * String Formatter</a>
     *
     * @param mensagemOuVariavel A mensagem ou variável a ser exibida para o
     * usuário.
     * @param variaveisDeSubstituicao As variáveis que irão substituir as
     * Strings especiais.
     */
    public static void escreverLinhaDeString(String mensagemOuVariavel, Object... variaveisDeSubstituicao) {
        iniciarTemplateDePopup();
        UIManager.put("OptionPane.okButtonText", "Fechar");
        mensagemFinal.setText(String.format(
                mensagemOuVariavel + NOVA_LINHA_01, variaveisDeSubstituicao)
        );

        showMessageDialog(
                null,
                mensagemFinal,
                "Operação: ESCRITA  -  Tipo: String",
                PLAIN_MESSAGE
        );
    }
    // </editor-fold>

    public static void escreverLinhaDeString(
            ImagemBitmap imagemExplicativaDaMensagem,
            String mensagemOuVariavel
    ) {
        escreverLinhaDeString(imagemExplicativaDaMensagem, PosicaoImagem.ESQUERDA, mensagemOuVariavel);
    }

    public static void escreverLinhaDeString(
            ImagemBitmap imagemExplicativaDaMensagem,
            PosicaoImagem posicaoImagem,
            String mensagemOuVariavel
    ) {
        iniciarTemplateDePopup();
        UIManager.put("OptionPane.okButtonText", "Fechar");
        mensagemFinal.setText(mensagemOuVariavel + NOVA_LINHA_01);

        // <editor-fold defaultstate="collapsed" desc="Acerta Imagem na posição escolhida">
        switch (posicaoImagem) {
            case SUPERIOR:
                painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                painel.add(mensagemFinal);
                break;

            case INFERIOR:
                painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                painel.add(mensagemFinal);
                painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                break;

            case ESQUERDA:
                painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                painel.add(mensagemFinal);
                break;

            case DIREITA:
                painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                painel.add(mensagemFinal);
                painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                break;
        }
        // </editor-fold>

        showMessageDialog(
                null,
                painel,
                "Operação: ESCRITA  -  Tipo: String",
                PLAIN_MESSAGE
        );
    }

    public static void escreverLinhaDeString(
            ImagemBitmap imagemExplicativaDaMensagem,
            String mensagemOuVariavel,
            Object... variaveisDeSubstituicao
    ) {
        escreverLinhaDeString(imagemExplicativaDaMensagem, PosicaoImagem.ESQUERDA, mensagemOuVariavel, variaveisDeSubstituicao);
    }

    public static void escreverLinhaDeString(
            ImagemBitmap imagemExplicativaDaMensagem,
            PosicaoImagem posicaoImagem,
            String mensagemOuVariavel,
            Object... variaveisDeSubstituicao
    ) {
        iniciarTemplateDePopup();
        UIManager.put("OptionPane.okButtonText", "Fechar");
        mensagemFinal.setText(String.format(
                mensagemOuVariavel + NOVA_LINHA_01, variaveisDeSubstituicao)
        );

        // <editor-fold defaultstate="collapsed" desc="Acerta Imagem na posição escolhida">
        switch (posicaoImagem) {
            case SUPERIOR:
                painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                painel.add(mensagemFinal);
                break;

            case INFERIOR:
                painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                painel.add(mensagemFinal);
                painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                break;

            case ESQUERDA:
                painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                painel.add(mensagemFinal);
                break;

            case DIREITA:
                painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
                painel.add(mensagemFinal);
                painel.add(imagemExplicativaDaMensagem.getObjetoJLabel());
                break;
        }
        // </editor-fold>

        showMessageDialog(
                null,
                painel,
                "Operação: ESCRITA  -  Tipo: String",
                PLAIN_MESSAGE
        );
    }
    
    public static void print(Object mensagemParaUsuario){
        System.out.print(mensagemParaUsuario);
    }
    
    public static void println(Object mensagemParaUsuario){
        System.out.println(mensagemParaUsuario);
    }
    
    public static String readLine(Object mensagemParaUsuario){
        return Console.readLine(mensagemParaUsuario);
    }

//##########################################################################################
    //<editor-fold defaultstate="collapsed" desc="Classe aninhada BasicLabel">
    private static class BasicLabel extends JTextArea {

        //<editor-fold defaultstate="collapsed" desc="Construtores">
        public BasicLabel() {
            super();
            super.setEditable(false);

            Cor corTemp = new Cor("3c3f41");
            setBackground(corTemp.getObjetoColor());

            corTemp = new Cor("b4c1c4");
            setForeground(corTemp.getObjetoColor());

            setDoubleBuffered(true);
            FonteTexto fontMonospaced = new FonteTexto(20, "Consolas");
            setFont(fontMonospaced.getObjetoFont());

        }
        //</editor-fold>

    }// nested class
    //</editor-fold>
//##########################################################################################

}
