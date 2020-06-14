package App.Model;

import java.io.Serializable;

public class Nodo implements Serializable {

    public String capital;
    public String pais;
    public boolean correcto;
    public String[] possibleCapitals;
    public int seleccionado = 0;
    public Nodo sig, ant;

    public Nodo(String pais, String capital) { // Constructor del nodo inicial
        this.capital = capital;
        this.pais = pais;
        this.sig = null;
        this.ant = null;
        this.correcto = false;
    }

    @Override
    public String toString() {
        return pais + "," + capital;
    }
}
