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
package conteudo;

import java.awt.Font;

/**
 * Descrição de <code>FonteTexto</code>.
 * <dl>
 * <dd>• Ponto 1: "abc";
 * </dl>
 *
 * <br><br><small>Criado em: 10/03/2019</small>
 *
 * @author Tiago Penha Pedroso
 * @version 1.0
 */
public class FonteTexto {

    protected Font fonte;
    protected String URL = "";
    protected String nomeFonteImportada = "";
    protected Boolean importouFonteTexto = false;
    protected Boolean importouViaURL = false;
    protected Espessura espessura = Espessura.NORMAL;

    public enum Espessura {
        NORMAL(Font.PLAIN),
        NEGRITO(Font.BOLD),
        ITALICO(Font.ITALIC),
        NEGRITO_ITALICO(Font.BOLD + Font.ITALIC);

        public int valorEspessura;

        Espessura(int valor) {
            valorEspessura = valor;
        }
    }

    public FonteTexto(
            Integer tamanhoCaraInteger,
            Espessura espessura,
            String nomeFonteInstaladaNoComputador
    ) {
        iniciarFonteViaSistema(
                tamanhoCaraInteger, 
                nomeFonteInstaladaNoComputador,
                espessura
        );
    }

    public FonteTexto(
            Integer tamanhoCaraInteger,
            String nomeFonteInstaladaNoComputador
    ) {
        iniciarFonteViaSistema(
                tamanhoCaraInteger, 
                nomeFonteInstaladaNoComputador,
                Espessura.NORMAL
        );
    }

    public FonteTexto(String URL, Integer tamanhoCaractere, Espessura espessura) {
        this.URL = URL;
        iniciartFonteViaURL(tamanhoCaractere, espessura);
    }

    public FonteTexto(String URL, Integer tamanhoCaractere) {
        this.URL = URL;
        iniciartFonteViaURL(tamanhoCaractere, Espessura.NORMAL);
    }

    /**
     * Importa um arquivo de Fonte.
     */
    private void iniciartFonteViaURL(Integer tamanhoCaractere, Espessura espessura) {
        importouViaURL = true;

        if (URL.substring(URL.length() - 3).contains("ttf")) {
            try {
                this.espessura = espessura;
                fonte = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream(URL));
                fonte = fonte.deriveFont(espessura.valorEspessura, tamanhoCaractere);
                importouFonteTexto = true;
                nomeFonteImportada = fonte.getFontName();
            } catch (Exception e) {
                importouFonteTexto = false;
                System.out.println(
                        "+------------------------------------+\n"
                        + "| Erro ao importar a FonteTexto! :(\n"
                        + "| URL: " + URL + "\n"
                        + "+------------------------------------+\n"
                );
            }
        } else {
            importouFonteTexto = false;
            System.out.println(
                    "+----------------------------------+\n"
                    + "| Extensão de arquivo inválida! :( |\n"
                    + "| Extensão permitada: ttf          |\n"
                    + "+----------------------------------+\n"
            );
        }
    }

    private void iniciarFonteViaSistema(
            Integer tamanhoCaractere,
            String nomeFonte,
            Espessura espessura
    ) {
        importouViaURL = false;
        
        this.espessura = espessura;
        fonte = new Font(nomeFonte, espessura.valorEspessura, tamanhoCaractere);

        if (fonte.getFamily().equalsIgnoreCase("Dialog")) {
            importouFonteTexto = false;
            System.out.println(
                    "+---------------------------------------------------+\n"
                    + "| Erro ao importar a FonteTexto! :(\n"
                    + "| Fonte inexistente no Sistema: " + nomeFonte + "\n"
                    + "+---------------------------------------------------+\n"
            );
        } else {
            nomeFonteImportada = nomeFonte;
            importouFonteTexto = true;
        }
    }

    public Font getObjetoFont() {
        return fonte;
    }

    public Integer getTamanhoCaractere() {
        return fonte.getSize();
    }

    public void setTamanhoCaractere(Integer tamanhoCaractere) {
        if (importouViaURL) {
            iniciartFonteViaURL(tamanhoCaractere, espessura);
        } else {
            iniciarFonteViaSistema(tamanhoCaractere, nomeFonteImportada, espessura);
        }
    }
    
    public void setEspessura(Espessura novaEspessura){
        espessura = novaEspessura;
        
        if (importouViaURL) {            
            iniciartFonteViaURL(fonte.getSize(), espessura);
        } else {
            iniciarFonteViaSistema(fonte.getSize(), nomeFonteImportada, espessura);
        }
    }

    @Override
    public String toString() {
        return "FonteTexto{\n"
                + //                "  fonte=" + Font. + "\n" +
                "  fonte=" + fonte.getFamily() + "\n"
                + "  URL=" + URL + "\n"
                + "  importouFonteTexto=" + importouFonteTexto + "\n"
                + "  importouViaURL=" + importouViaURL + "\n"
                + "}";
    }

}
