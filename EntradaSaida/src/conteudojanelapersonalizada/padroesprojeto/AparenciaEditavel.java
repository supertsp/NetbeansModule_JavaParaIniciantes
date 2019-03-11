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

package conteudojanelapersonalizada.padroesprojeto;

import conteudojanelapersonalizada.Cor;

/**
 * Descrição de <code>AparenciaEditavel</code>.
 * <dl>
 * <dd>• Ponto 1: "abc";
 * </dl>
 * 
 * <br><br><small>Criado em: 10/03/2019</small>
 *
 * @author Tiago Penha Pedroso
 * @version 1.0
 */
public interface AparenciaEditavel {
    
    public void setCorDeFundo(String codigoCorHexa);
    
    public void setCorDeFundo(Cor novaCor);
    
    public String getCorDeFundoEmCodigoHexa();
    
    public Cor getCorDeFundo();
    
    public void setCorDaFrente(String codigoCorHexa);
    
    public void setCorDaFrente(Cor novaCor);
    
    public String getCorDaFrenteEmCodigoHexa();
    
    public Cor getCorDaFrente();
    
    public void setBorda(Integer espessura, String codigoCorHexa);
    
    public void setBorda(
            Integer espessuraEsquerda, Integer espessuraDireita,
            Integer espessuraSuperior, Integer espessuraInferior,
            String codigoCorHexa
    );
    
    public void setBorda(Integer espessura, Cor novaCor);
    
    public void setBorda(
            Integer espessuraEsquerda, Integer espessuraDireita,
            Integer espessuraSuperior, Integer espessuraInferior,
            Cor novaCor
    );
    
    public void removerBorda();
    
}
