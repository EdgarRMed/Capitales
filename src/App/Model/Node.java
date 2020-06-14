package App.Model;

import java.io.Serializable;

public class Node implements Serializable {

    public String capital;
    public String pais;
    public boolean estado;
    public String[] possibleCapitals;
    public boolean capitalsCharged;
    protected Node sig, ant;

    public Node(String pais, String capital) { // Constructor del nodo inicial
        this.capital = capital;
        this.pais = pais;
        this.sig = null;
        this.ant = null;
        this.estado = false;
    }

    @Override
    public String toString() {
        return pais + "," + capital;
    }
}
