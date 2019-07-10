//<editor-fold defaultstate="collapsed" desc="License">
/* 
 * Copyright (C) 2015, 2019 Tiago Penha Pedroso
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
package conteudo;

import java.awt.Color;

/**
 * Representa uma cor qualquer no padrão RGBA (Red, Green, Blue, Alpha) em
 * Hexadecimal. Ou seja, para uma cor vermelha 100% opaca pode ser passado
 * "ff0000ff", já para a mesm a cor com menos opacidade pode ser "ff0000b3".
 * Obs.: Não existe distinção entre letras com caixa alta ou baixa.
 * <br><br><small>Criado em: 25/07/2015. Modificado em: 10/03/2019</small>
 *
 * @author Tiago Penha Pedroso
 * @version 1.0
 */
public class Cor {

    private Color cor;
    private String codigoHexa;
    private Integer R;
    private Integer G;
    private Integer B;
    private Integer A;
    
    //Auxiliares
    private enum CorCodigo {
        R, G, B, A;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Constantes: Cores Básicas">
    /*01*/ public static final Cor TRANSPARENTE = new Cor("11001100");
    /*02*/ public static final Cor PRETO = new Cor("000000");
    /*03*/ public static final Cor BRANCO = new Cor("FFFFFF");
    /*04*/ public static final Cor PRETO_90_PORCENTO = new Cor("3c3431");
    /*05*/ public static final Cor PRETO_80_PORCENTO = new Cor("534b48");
    /*06*/ public static final Cor PRETO_70_PORCENTO = new Cor("6a625f");
    /*07*/ public static final Cor PRETO_60_PORCENTO = new Cor("7d7573");
    /*08*/ public static final Cor PRETO_50_PORCENTO = new Cor("8e8684");
    /*09*/ public static final Cor PRETO_40_PORCENTO = new Cor("9d9797");
    /*10*/ public static final Cor PRETO_30_PORCENTO = new Cor("ada7a7");
    /*11*/ public static final Cor PRETO_20_PORCENTO = new Cor("bebab9");
    /*12*/ public static final Cor PRETO_10_PORCENTO = new Cor("d0cccb");
    /*13*/ public static final Cor CINZA = new Cor("8e8684");
    
    /*14*/ public static final Cor VERMELHO = new Cor("e01318");
    /*15*/ public static final Cor MAGENTA = new Cor("e20376");
    /*16*/ public static final Cor VERMELHO_NEON = new Cor("e51141");
    /*17*/ public static final Cor VERMELHO_VERDADEIRO = new Cor("ba5c52");
    /*18*/ public static final Cor VERMELHO_TIJOULO = new Cor("bd5c27");
    /*19*/ public static final Cor VERMELHO_RUBI = new Cor("994731");
    
    /*20*/ public static final Cor VERDE = new Cor("01943c");
    /*21*/ public static final Cor VERDE_GRAMA = new Cor("397460");
    /*22*/ public static final Cor VERDE_PRIMAVERA = new Cor("4e915e");
    /*23*/ public static final Cor VERDE_MAR = new Cor("419296");
    /*24*/ public static final Cor VERDE_AMARELADO = new Cor("96ba24");
    /*25*/ public static final Cor VERDE_MENTA = new Cor("8abd92");
    
    /*26*/ public static final Cor AZUL = new Cor("312c86");
    /*27*/ public static final Cor CIANO = new Cor("049ee4");
    /*28*/ public static final Cor AZUL_BEBE = new Cor("677db6");
    /*29*/ public static final Cor AZUL_MARINHO = new Cor("434d70");
    /*30*/ public static final Cor AZUL_CELESTE = new Cor("0481c4");
    /*31*/ public static final Cor AZUL_GELO = new Cor("7cc1e8");
    
    /*32*/ public static final Cor AMARELO = new Cor("eed902");
    /*33*/ public static final Cor AMARELO_BANANA = new Cor("beb149");
    /*34*/ public static final Cor AMARELO_ESCURO = new Cor("f3b103");
    /*35*/ public static final Cor AMARELO_CLARO = new Cor("f2e251");
    /*36*/ public static final Cor AMARELO_GIZ = new Cor("f4e886");
    /*37*/ public static final Cor AMARELO_PALIDO = new Cor("f6ecb9");
    
    /*38*/ public static final Cor PURPURA = new Cor("9b386f");
    /*39*/ public static final Cor PURPURA_PALIDO = new Cor("bf9ea9");
    /*40*/ public static final Cor PURPURA_MAJESTOSO = new Cor("9f5b84");
    /*41*/ public static final Cor VIOLETA = new Cor("bb7a92");
    /*42*/ public static final Cor VIOLETA_ESCURO = new Cor("974865");
    /*43*/ public static final Cor VIOLETA_CLARO = new Cor("c14c90");
    
    /*44*/ public static final Cor ROSA = new Cor("e88e8d");
    /*45*/ public static final Cor ROSA_ESCURO = new Cor("ba5d68");
    /*46*/ public static final Cor ROSA_DESBOTADO = new Cor("edb59c");
    /*47*/ public static final Cor ROSA_SUAVE = new Cor("ee9472");
    /*48*/ public static final Cor ROSA_TROPICAL = new Cor("e9714f");
    /*49*/ public static final Cor ROSA_INTENSO = new Cor("e64b5b");    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Construtores">
    /**
     * Os formatos de código de cores permitidos são:
     * <dl>
     * <dd>• RRGGBB: "37e5df";
     * <dd>• #RRGGBB: "#37E5DF";
     * <dd>• RRGGBBAA: "37E5DFFF";
     * <dd>• #RRGGBBAA: "#37e5dfff";
     * </dl>
     *
     * @param codigoHexadecimal O valor da cor na seguinte ordem: "RRGGBBAA"
     */
    public Cor(String codigoHexadecimal) {
        inicializarAtributos(codigoHexadecimal);
    }
    
    public Cor(Integer red, Integer green, Integer blue, Integer alpha){
        this.R = red;
        this.G = green;
        this.B = blue;
        this.A = alpha;
        cor = new Color(R, G, B, A);
        converterColorParaCodigoHexa(cor);
    }
       
    private void converterColorParaCodigoHexa(Color corCriada) {
        codigoHexa = Integer.toHexString(corCriada.getRed()).charAt(0) == '0'
                ? "00"
                : Integer.toHexString(corCriada.getRed());

        codigoHexa += Integer.toHexString(corCriada.getGreen()).charAt(0) == '0'
                ? "00"
                : Integer.toHexString(corCriada.getGreen());

        codigoHexa += Integer.toHexString(corCriada.getBlue()).charAt(0) == '0'
                ? "00"
                : Integer.toHexString(corCriada.getBlue());

        codigoHexa += Integer.toHexString(corCriada.getAlpha()).charAt(0) == '0'
                ? "00"
                : Integer.toHexString(corCriada.getAlpha());
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos: Auxiliares">
    /**
     * Validador do código hexadecimal de cada elemento do RGBA.
     *
     * @param codigoHexa O valor de um dos elementos do RGBA
     * @return boolean
     */
    private boolean isCodigoHexaValido(String codigoHexa) {
        char cod0 = codigoHexa.charAt(0);
        char cod1 = codigoHexa.charAt(1);

        return (cod0 == '0' || cod0 == '1'
                || cod0 == '2' || cod0 == '3'
                || cod0 == '4' || cod0 == '5'
                || cod0 == '6' || cod0 == '7'
                || cod0 == '8' || cod0 == '9'
                || cod0 == 'A' || cod0 == 'B'
                || cod0 == 'C' || cod0 == 'D'
                || cod0 == 'E' || cod0 == 'F')
                && (cod1 == '0' || cod1 == '1'
                || cod1 == '2' || cod1 == '3'
                || cod1 == '4' || cod1 == '5'
                || cod1 == '6' || cod1 == '7'
                || cod1 == '8' || cod1 == '9'
                || cod1 == 'A' || cod1 == 'B'
                || cod1 == 'C' || cod1 == 'D'
                || cod1 == 'E' || cod1 == 'F');
    }

    /**
     * Quando o código de uma cor é invalido a String codigoHexa deve ser
     * alterada.
     *
     * @param corEscolhida A a cor a ser zerada (R, G, B ou A)
     */
    private int zerarCodigoCor(CorCodigo corEscolhida) {
        //01 23 45 67
        //RR GG BB AA

        if (corEscolhida == CorCodigo.R) {
            codigoHexa = "00" + codigoHexa.substring(2);
            return 0;
        }

        if (corEscolhida == CorCodigo.G) {
            codigoHexa = codigoHexa.substring(0, 2) + "00" + codigoHexa.substring(4);
            return 0;
        }

        if (corEscolhida == CorCodigo.B) {
            codigoHexa = codigoHexa.substring(0, 4) + "00" + codigoHexa.substring(6);
            return 0;
        }

        if (corEscolhida == CorCodigo.A) {
            codigoHexa = codigoHexa.substring(0, 6) + "00";
            return 0;
        }

        return 0;
    }

    private void inicializarRGBA(String codigoHexaValidado) {
        R = isCodigoHexaValido(codigoHexa.substring(0, 2))
                ? Integer.parseInt(codigoHexa.substring(0, 2), 16)
                : zerarCodigoCor(CorCodigo.R);

        G = isCodigoHexaValido(codigoHexa.substring(2, 4))
                ? Integer.parseInt(codigoHexa.substring(2, 4), 16)
                : zerarCodigoCor(CorCodigo.G);

        B = isCodigoHexaValido(codigoHexa.substring(4, 6))
                ? Integer.parseInt(codigoHexa.substring(4, 6), 16)
                : zerarCodigoCor(CorCodigo.B);

        A = isCodigoHexaValido(codigoHexa.substring(6))
                ? Integer.parseInt(codigoHexa.substring(6), 16)
                : zerarCodigoCor(CorCodigo.A);
        
        cor = new Color(R, G, B, A);
    }

    /**
     * Inicializador dos atributos de classe.
     *
     * @param codigoHexaNaoValidado A String que representa uma cor no formato
     * RGBA
     */
    private void inicializarAtributos(String codigoHexaNaoValidado) {
        codigoHexaNaoValidado = codigoHexaNaoValidado.trim();
        codigoHexaNaoValidado = codigoHexaNaoValidado.toUpperCase();

        //quando o código passado é no formato "RRGGBB"
        if (codigoHexaNaoValidado.length() == 6) {
            codigoHexa = codigoHexaNaoValidado + "FF";
            inicializarRGBA(codigoHexaNaoValidado);
        }

        //quando o código passado é no formato "#RRGGBB"
        if (codigoHexaNaoValidado.length() == 7) {
            codigoHexa = codigoHexaNaoValidado.substring(1) + "FF";
            inicializarRGBA(codigoHexaNaoValidado);
        }

        //quando o código passado é no formato "RRGGBBAA"
        if (codigoHexaNaoValidado.length() == 8) {
            codigoHexa = codigoHexaNaoValidado;
            inicializarRGBA(codigoHexaNaoValidado);
        }

        //quando o código passado é no formato "#RRGGBBAA"
        if (codigoHexaNaoValidado.length() == 9) {
            this.codigoHexa = codigoHexaNaoValidado.substring(1);
            inicializarRGBA(codigoHexaNaoValidado);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GETTERS">
    /**
     * Retorna um objeto do tipo Color.
     *
     * @return Color
     */
    public Color getObjetoColor() {
        return cor;
    }

    /**
     * Retorna o código hexadecimal da cor atual.
     *
     * @return String
     */
    public String getCodigoHexadecimal() {
        return codigoHexa;
    }
    
    /**
     * Retorna o código hexadecimal da cor atual.
     *
     * @return String
     */
    public static String getCodigoHexadecimal(Color objetoColor) {
        int R = objetoColor.getRed();
        int G = objetoColor.getGreen();
        int B = objetoColor.getBlue();
        int A = objetoColor.getAlpha();
        String hexa = 
                Integer.toHexString(R) +
                Integer.toHexString(G) +
                Integer.toHexString(B) +
                Integer.toHexString(A);
        return hexa;   
    }
    
    /**
     * Retorna o valor de Red.
     *
     * @return int no formato decimal.
     */
    public int getR() {
        return R;
    }

    /**
     * Retorna o valor de Green.
     *
     * @return int no formato decimal.
     */
    public int getG() {
        return G;
    }

    /**
     * Retorna o valor de Blue.
     *
     * @return int no formato decimal.
     */
    public int getB() {
        return B;
    }

    /**
     * Retorna o valor de Alpha.
     *
     * @return int no formato decimal.
     */
    public int getA() {
        return A;
    }
    //</editor-fold>
    
    /**
     * Os formatos de código de cores permitidos são:
     * <dl>
     * <dd>• RRGGBB: "37e5df";
     * <dd>• #RRGGBB: "#37E5DF";
     * <dd>• RRGGBBAA: "37E5DFFF";
     * <dd>• #RRGGBBAA: "#37e5dfff";
     * </dl>
     *
     * @param codigoHexadecimal O valor da cor na seguinte ordem: "RRGGBBAA"
     */
    public void mudarCor(String codigoHexadecimal) {
        inicializarAtributos(codigoHexadecimal);
    }
    
    public static Cor converterObjetoColorEmCor(Color objetoColor){
        return new Cor(getCodigoHexadecimal(objetoColor));
    }

    //<editor-fold defaultstate="collapsed" desc="Sobrescrita: Object">
    @Override
    public String toString() {
        return "CorRGBA{\n"
                + "  codigoHexa: " + codigoHexa + "\n"
                + "  R: " + R + "\n"
                + "  G: " + G + "\n"
                + "  B: " + B + "\n"
                + "  A: " + A + "\n"
                + "}";
    }
    //</editor-fold>

}
