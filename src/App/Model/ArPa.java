package App.Model;

import java.io.Serializable;
import java.util.Random;

public class ArPa implements Serializable {
    Node raiz;
    String filename;

    public ArPa() {
        raiz = null;
    }

    public void insertar(String pa, String cap) {
        Node pais = new Node(pa, cap);
        if (raiz != null) {
            raiz.ant = pais;
            pais.sig = raiz;
        }
        raiz = pais;
    }

    public Node recorrido(int semilla) {
        Node aux = raiz;

        for (int i = 0; i <= semilla; i++) {
            aux = aux.sig;
        }
        return aux;
    }

    public int random(int cont) {
        return new Random().nextInt(cont);
    }

    @Override
    public String toString() {
        String cad = "";

        Node reco = raiz;
        while (reco != null) {
            cad += reco.pais + "->" + reco.capital + "  ";
            reco = reco.sig;
        }
        return cad;
    }


}
