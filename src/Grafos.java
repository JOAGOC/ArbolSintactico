/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Angel
 */
public class Grafos {

    static boolean esHexadecimal(String cad) {// #,123,A-F,!"$
        if (cad.equals(""))
            return false;
        if (cad.length() == 7 && !cad.startsWith("#"))
            return false;
        else if (cad.length() != 6 && cad.length() != 7)
            return false;
        int M[][] = { { 1, 1, 1, -1 }, { -1, 1, 1, -1 } }, ent = 0, edo = 0;
        char c;
        for (int i = 0; i < cad.length(); i++) {
            c = cad.charAt(i);
            if (c == '#') {
                ent = 0;
            } else if (c >= 48 && c <= 57) {
                ent = 1;
            } else if (c >= 65 && c <= 70 || c >= 97 && c <= 102) {
                ent = 2;
            } else {
                ent = 3;
            }
            if ((edo = M[edo][ent]) == -1) {
                return false;
            }
        }
        return true;
    }

    static boolean esFlotante(String cad) {// +,-,123,'.',@#&
        if (cad.equals(""))
            return false;
        int M[][] = { { 1, 1, 1, 2, -1 }, { -1, -1, 1, 2, -1 }, { -1, -1, 2, -1, -1 } }, ent = 0, edo = 0;
        char c;
        for (int i = 0; i < cad.length(); i++) {
            c = cad.charAt(i);
            if (c == '+') {
                ent = 0;
            } else if (c == '-') {
                ent = 1;
            } else if (c >= 48 && c <= 57) {
                ent = 2;
            } else if (c == '.') {
                ent = 3;
            } else {
                ent = 4;
            }
            if ((edo = M[edo][ent]) == -1) {
                return false;
            }
        }
        return true;
    }

    static boolean esEntero(String cad) {
        if (cad.equals(""))
            return false;
        int M[][] = { { 1, 1, 1, -1 }, { 1, -1, -1, -1 } }, ent, edo = 0;
        char c;
        for (int i = 0; i < cad.length(); i++) {
            c = cad.charAt(i);
            if (c >= 48 && c <= 57) {
                ent = 0;
            } else if (c == '+') {
                ent = 1;
            } else if (c == '-') {
                ent = 2;
            } else {
                ent = 3;
            }
            if ((edo = M[edo][ent]) == -1) {
                return false;
            }
        }
        return true;
    }

    static boolean esIdentificador(String cad) {// ABC,_,142,##/!´+
        if (cad.equals(""))
            return false;
        int M[][] = { { 1, 1, -1, -1 }, { 1, 1, 1, -1 } }, ent, edo = 0;
        char c;
        for (int i = 0; i < cad.length(); i++) {
            c = cad.charAt(i);
            if (c >= 65 && c <= 90 || c >= 97 && c <= 122) {
                ent = 0;
            } else if (c == '_') {
                ent = 1;
            } else if (c >= 48 && c <= 57) {
                ent = 2;
            } else {
                ent = 3;
            }
            edo = M[edo][ent];
            if (edo == -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // String xd[] = {"+34", "+.43", "+31.43", "+32#", "+.42.3", "+-134", "-34",
        // "-.43", "-31.43", "-32#", "-.42.3", "31.23", ".543.31", ".54", "das", "..."};
        // System.out.println("Flotante");
        // for (int i = 0; i < xd.length; i++) {
        // System.out.println(xd[i] + " es flotante " + (esFlotante(xd[i]) ? "Válido" :
        // "No válido"));
        // }
        // String xd1[] =
        // {"#432314","#2h3124","135674","HLDSCF","#FFFFFF","$32ABcd","abcdef","#xd","3256471"};
        // System.out.println("\nHexadecimal");
        // for (int i = 0; i < xd1.length; i++) {
        // System.out.println(xd1[i] + " es hexadecimal " + (esHexadecimal(xd1[i]) ?
        // "Válido" : "No válido"));
        // }
        // String xd[] = {"3FCR", "_ed2", "F_EA__", "cd13__31", "__21", "31__", "dc3#",
        // "fe13!\"", "313", "-312", "+314", "-31+2", "23+", "-21"};
        // System.out.println("Identificador");
        // for (int i = 0; i < xd.length; i++) {
        // System.out.println(xd[i] + " es identificador " + (esIdentificador(xd[i]) ?
        // "Válido" : "No válido"));
        // }
        // System.out.println("\nEntero");
        // for (int i = 0; i < xd.length; i++) {
        // System.out.println(xd[i] + " es entero " + (esEntero(xd[i]) ? "Válido" : "No
        // válido"));
        // }
    }
}
