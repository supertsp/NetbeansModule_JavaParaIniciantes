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

import java.math.BigDecimal;
import static javax.swing.JOptionPane.*;

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
 * <dd>• <code>BigDecimal</code>: dado (objeto) do tipo numérico real de precisão
 * exata. Ex.: new BigDecimal("1.46") ou new BigDecimal("50100200.539")
 * </dl>
 *
 * <br><br><small>Criado em: 06/03/2019</small>
 *
 * @author Tiago Penha Pedroso
 * @version 1.0
 */
public class JanelaPopup {

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

    // <editor-fold defaultstate="collapsed" desc="lerString(String mensagemParaUsuario) : String|null">
    /**
     * Executa a operção de "leitura" de uma variável (objeto) do tipo
     * <code>String</code>.
     *
     * @param mensagemParaUsuario A mensagem a ser exibida para o usuário.
     * @return A <code>String</code> lida ou <code>null</code> em caso de erro.
     */
    public static String lerString(String mensagemParaUsuario) {
        try {
            return showInputDialog(
                    null,
                    mensagemParaUsuario,
                    "Janela para Leitura de String",
                    PLAIN_MESSAGE
            );
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="lerString(String mensagemParaUsuario, Object[s] formatParams) : String|null">
    /**
     * Executa a operção de "leitura" de uma variável (objeto) do tipo
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
            return showInputDialog(
                    null,
                    String.format(mensagemParaUsuario, variaveisDeSubstituicao),
                    "Janela para Leitura de String",
                    PLAIN_MESSAGE
            );
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="lerCharacter(String mensagemParaUsuario) : Character|null">
    /**
     * Executa a operção de "leitura" de uma variável (objeto) do tipo
     * <code>Character</code>. <br>
     *
     * @param mensagemParaUsuario A mensagem a ser exibida para o usuário.
     * @return O <code>Character</code> lido ou <code>null</code> em caso de
     * erro.
     */
    public static Character lerCharacter(String mensagemParaUsuario) {
        try {
            return showInputDialog(
                    null,
                    mensagemParaUsuario,
                    "Janela para Leitura de Character",
                    PLAIN_MESSAGE
            ).charAt(0);
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="lerCharacter(String mensagemParaUsuario, Object[s] variaveisDeSubstituicao) : Character|null">
    /**
     * Executa a operção de "leitura" de uma variável (objeto) do tipo
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
            return showInputDialog(
                    null,
                    String.format(mensagemParaUsuario, variaveisDeSubstituicao),
                    "Janela para Leitura de Character",
                    PLAIN_MESSAGE
            ).charAt(0);
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="lerBoolean(String mensagemParaUsuario) : Boolean|null">
    /**
     * Executa a operção de "leitura" de uma variável (objeto) do tipo
     * <code>Boolean</code>. <br>
     *
     * @param mensagemParaUsuario A mensagem a ser exibida para o usuário.
     * @return O <code>Boolean</code> lido ou <code>null</code> em caso de erro.
     */
    public static Boolean lerBoolean(String mensagemParaUsuario) {
        try {
            return Boolean.parseBoolean(
                    showInputDialog(
                            null,
                            mensagemParaUsuario,
                            "Janela para Leitura de Boolean",
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
     * Executa a operção de "leitura" de uma variável (objeto) do tipo
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
            return Boolean.parseBoolean(
                    showInputDialog(
                            null,
                            String.format(mensagemParaUsuario, variaveisDeSubstituicao),
                            "Janela para Leitura de Boolean",
                            PLAIN_MESSAGE
                    )
            );
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="lerInteger(String mensagemParaUsuario) : Integer|null">
    /**
     * Executa a operção de "leitura" de uma variável (objeto) do tipo
     * <code>Integer</code>. <br>
     *
     * @param mensagemParaUsuario A mensagem a ser exibida para o usuário.
     * @return O <code>Integer</code> lido ou <code>null</code> em caso de erro.
     */
    public static Integer lerInteger(String mensagemParaUsuario) {
        try {
            return Integer.parseInt(
                    showInputDialog(
                            null,
                            mensagemParaUsuario,
                            "Janela para Leitura de Integer",
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
     * Executa a operção de "leitura" de uma variável (objeto) do tipo
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
            return Integer.parseInt(
                    showInputDialog(
                            null,
                            String.format(mensagemParaUsuario, variaveisDeSubstituicao),
                            "Janela para Leitura de Integer",
                            PLAIN_MESSAGE
                    )
            );
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="lerFloat(String mensagemParaUsuario) : Float|null">
    /**
     * Executa a operção de "leitura" de uma variável (objeto) do tipo
     * <code>Float</code>. <br>
     *
     * @param mensagemParaUsuario A mensagem a ser exibida para o usuário.
     * @return O <code>Float</code> lido ou <code>null</code> em caso de erro.
     */
    public static Float lerFloat(String mensagemParaUsuario) {
        try {
            return Float.parseFloat(
                    showInputDialog(
                            null,
                            mensagemParaUsuario,
                            "Janela para Leitura de Float",
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
     * Executa a operção de "leitura" de uma variável (objeto) do tipo
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
            return Float.parseFloat(
                    showInputDialog(
                            null,
                            String.format(mensagemParaUsuario, variaveisDeSubstituicao),
                            "Janela para Leitura de Float",
                            PLAIN_MESSAGE
                    )
            );
        } catch (Exception e) {
            return Float.MAX_VALUE;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="lerDouble(String mensagemParaUsuario) : Double|null">
    /**
     * Executa a operção de "leitura" de uma variável (objeto) do tipo
     * <code>Double</code>. <br>
     *
     * @param mensagemParaUsuario A mensagem a ser exibida para o usuário.
     * @return O <code>Double</code> lido ou <code>null</code> em caso de erro.
     */
    public static Double lerDouble(String mensagemParaUsuario) {
        try {
            return Double.parseDouble(
                    showInputDialog(
                            null,
                            mensagemParaUsuario,
                            "Janela para Leitura de Double",
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
     * Executa a operção de "leitura" de uma variável (objeto) do tipo
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
            return Double.parseDouble(
                    showInputDialog(
                            null,
                            String.format(mensagemParaUsuario, variaveisDeSubstituicao),
                            "Janela para Leitura de Double",
                            PLAIN_MESSAGE
                    )
            );
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="lerBigDecimal(String mensagemParaUsuario) : BigDecimal|null">
    /**
     * Executa a operção de "leitura" de uma variável (objeto) do tipo
     * <code>BigDecimal</code>. <br>
     *
     * @param mensagemParaUsuario A mensagem a ser exibida para o usuário.
     * @return O <code>BigDecimal</code> lido ou <code>null</code> em caso de erro.
     */
    public static BigDecimal lerBigDecimal(String mensagemParaUsuario) {
        try {
            return new BigDecimal(
                    showInputDialog(
                            null,
                            mensagemParaUsuario,
                            "Janela para Leitura de BigDecimal",
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
     * Executa a operção de "leitura" de uma variável (objeto) do tipo
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
     * @return O <code>BigDecimal</code> lido ou <code>null</code> em caso de erro.
     */
    public static BigDecimal lerBigDecimal(String mensagemParaUsuario, Object... variaveisDeSubstituicao) {
        try {
            return new BigDecimal(
                    showInputDialog(
                            null,
                            String.format(mensagemParaUsuario, variaveisDeSubstituicao),
                            "Janela para Leitura de BigDecimal",
                            PLAIN_MESSAGE
                    )
            );
        } catch (Exception e) {
            return null;
        }
    }
    // </editor-fold>
        
    // <editor-fold defaultstate="collapsed" desc="escreverString(String mensagemOuVariavel) : void">
    /**
     * Executa a operção de "escrita" de uma variável (objeto) do tipo
     * <code>String</code>. <br>
     *
     * @param mensagemOuVariavel A mensagem ou variável a ser exibida para o
     * usuário.
     */
    public static void escreverString(String mensagemOuVariavel) {
        showMessageDialog(
                null,
                mensagemOuVariavel,
                "Janela para Escrita de String",
                PLAIN_MESSAGE
        );
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="escreverString(String mensagemOuVariavel, Object[s] variaveisDeSubstituicao) : void">
    /**
     * Executa a operção de "escrita" de uma variável (objeto) do tipo
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
        showMessageDialog(
                null,
                String.format(mensagemOuVariavel, variaveisDeSubstituicao),
                "Janela para Escrita de String",
                PLAIN_MESSAGE
        );
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="escreverLinhaDeString(String mensagemOuVariavel) : void">
    /**
     * Executa a operção de "escrita" de uma variável (objeto) do tipo
     * <code>String</code> e logo após faz uma quebra de linha. <br>
     *
     * @param mensagemOuVariavel A mensagem ou variável a ser exibida para o
     * usuário.
     */
    public static void escreverLinhaDeString(String mensagemOuVariavel) {
        showMessageDialog(
                null,
                mensagemOuVariavel + NOVA_LINHA_01,
                "Janela para Escrita de String",
                PLAIN_MESSAGE
        );
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="escreverLinhaDeString(String mensagemOuVariavel, Object[s] variaveisDeSubstituicao) : void">
    /**
     * Executa a operção de "escrita" de uma variável (objeto) do tipo
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
        showMessageDialog(
                null,
                String.format(mensagemOuVariavel, variaveisDeSubstituicao) + NOVA_LINHA_01,
                "Janela para Escrita de String",
                PLAIN_MESSAGE
        );
    }
    // </editor-fold>
}
