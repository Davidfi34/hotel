package util;

public class ValueVerification {


    public static boolean isNumeric(String cadena) {
        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }

    public static boolean esAlfanumerico(String str) {
        return str.matches("[a-zA-Z0-9]+");
    }
    public static boolean isWord(String str) {
        return str.matches("^[a-zA-Z]+$");
    }


}
