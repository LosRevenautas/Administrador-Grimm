/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador.Utils;

/**
 *
 * @author Merlin
 */
public class Validator {

    private static String validarString(String str) {
        if (!(str == null || str.equals(""))) {
            return "ok";
        } else {
            return "vacio";
        }
    }

    /**
     * Valida un string para ser usado como nombre.
     *
     * @param str El string a validar
     * @return devuelve "ok" si el string es correcto y "vacio" si es null o "";
     */
    public static String validarNombre(String str) {
        return validarString(str);
    }

    /**
     * Toma un string y valida si es un numbero correcto. Int o Double
     * dependiendo del parametro dado
     *
     * @param str El string a validar
     * @param tipo int o double segun el numero que corresponda en el string
     * @return "ok" si el numbero es correcto. "malParam" si el parametro es
     * incorrecto, "malNum" si el string no es un numero y "vacio" si es null o
     * "";
     */
    public static String validarInt(String str, String tipo) {
        try {
            if (validarString(str).equals("vacio")) {
                return "vacio";
            }
            switch (tipo.toLowerCase()) {
                case "int":
                    int testInt = Integer.valueOf(str);
                    return "ok";
                case "double":
                    double testDouble = Double.valueOf(str);
                    return "ok";
                default:
                    return "malParam";
            }
        } catch (NumberFormatException e) {
            return "malNum";
        }
    }

}
