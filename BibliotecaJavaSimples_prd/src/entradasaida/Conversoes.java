package entradasaida;

public class Conversoes {
    
    public static String converterParaString(Object variavelParaConverter){
        try {
            return variavelParaConverter.toString();
        } catch (Exception e) {
            return null;
        }
    }
    
    public static Character converterParaCharacter(Object variavelParaConverter){
        try {
            return variavelParaConverter.toString().charAt(0);
        } catch (Exception e) {
            return null;
        }
    }
    
    public static Boolean converterParaBoolean(Object variavelParaConverter){
        try {
            return Boolean.parseBoolean(variavelParaConverter.toString());
        } catch (Exception e) {
            return null;
        }
    }
    
    public static Integer converterParaInteger(Object variavelParaConverter){
        try {
            return Integer.parseInt(variavelParaConverter.toString());
        } catch (Exception e) {
            return null;
        }
    }
    
    public static Float converterParaFloat(Object variavelParaConverter){
        try {
            return Float.parseFloat(variavelParaConverter.toString());
        } catch (Exception e) {
            return null;
        }
    }
    
    public static Double converterParaDouble(Object variavelParaConverter){
        try {
            return Double.parseDouble(variavelParaConverter.toString());
        } catch (Exception e) {
            return null;
        }
    }

}
