package App.Model;

import java.io.Serializable;
import java.util.Random;

public class ArPa implements Serializable {
    public Nodo raiz;
    String filename;

    public ArPa() {
        raiz = null;
    }

    public void insertar(String pa, String cap) {
        Nodo pais = new Nodo(pa, cap);
        if (raiz != null) {
            raiz.ant = pais;
            pais.sig = raiz;
        }
        raiz = pais;
    }

    public Nodo recorrido(int semilla) {
        Nodo aux = raiz;

        for (int i = 0; i < semilla; i++) {
            aux = aux.sig;
        }
        return aux;
    }

    public int random(int cont) {
        return new Random().nextInt(cont);
    }

    public Nodo getRaiz() {
        return raiz;
    }

    @Override
    public String toString() {
        String cad = "";

        Nodo reco = raiz;
        while (reco != null) {
            cad += reco.pais + "->" + reco.capital + "  ";
            reco = reco.sig;
        }
        return cad;
    }


}
