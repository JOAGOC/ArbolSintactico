/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Angel
 */
public class ArbolBinarioString {
    
    private Nodo raiz;
    private int profundidad, nivel;
    private ArbolListener al;
    
    public void setAl(ArbolListener al) {
        this.al = al;
    }

    public void clear(){
        raiz = null;
    }
    
    public ArbolBinarioString() {
        raiz = null;
    }

    public Nodo agregar(String cadena, Nodo padre, boolean izq) {
        Nodo n = new Nodo(cadena);
        if (raiz == null) {
            raiz = n;
        } 
        else if (izq){
            padre.setIzq(n);
        }else
            padre.setDer(n);
        notifyArbolChanged();
        return n;
    }

    public void notifyArbolChanged(){
        if (al != null)
            al.onArbolChanged(this);
    }

    public void preorden() {
        ArbolBinarioString.preorden(raiz);
        System.out.println();
    }

    public static void preorden(Nodo r) {
        if (r == null) {
            return;
        }
        System.out.print("[" + r.getInfo() + "]");
        preorden(r.getIzq());
        preorden(r.getDer());
    }

    public void postorden() {
        ArbolBinarioString.postorden(raiz);
        System.out.println();
    }

    public static void postorden(Nodo r) {
        if (r == null) {
            return;
        }
        postorden(r.getIzq());
        postorden(r.getDer());
        System.out.print("[" + r.getInfo() + "]");
    }

    public void inorden() {
        ArbolBinarioString.inorden(raiz);
        System.out.println();
    }

    public static void inorden(Nodo r) {
        if (r == null) {
            return;
        }
        inorden(r.getIzq());
        System.out.print("[" + r.getInfo() + "]");
        inorden(r.getDer());
    }

    private void profundidad(Nodo nodo) {
        if (nodo != null) {
            nivel++;
            if (nivel > profundidad) {
                profundidad = nivel;
            }
            profundidad(nodo.getIzq());
            profundidad(nodo.getDer());
            nivel--;
        }
    }

    public Nodo getRaiz() {
        return raiz;
    }

    //Devuleve la altura del arbol
    public int getProfundidad() {
        profundidad = nivel = 0;
        profundidad(raiz);
        return profundidad;
    }
}
