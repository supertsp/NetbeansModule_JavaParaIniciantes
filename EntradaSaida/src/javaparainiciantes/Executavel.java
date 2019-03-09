package javaparainiciantes;

import java.math.BigDecimal;
import javaparainiciantes.es.Console;
import javaparainiciantes.es.JanelaPopup;

public class Executavel {

    public static void main(String[] args) {

        BigDecimal c = JanelaPopup.lerBigDecimal("Digite um decimal");
        BigDecimal sum = new BigDecimal("0.0");
        
        for (int i = 0; i < 100_000; i++) {
            sum = sum.add(c);
        }
        
        JanelaPopup.escreverString("c: " + c + "\nsum: " + sum);
        
    }

}
