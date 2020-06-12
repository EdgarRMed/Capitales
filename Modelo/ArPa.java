package Modelo;

import java.io.Serializable;
import java.util.Random;

public class ArPa implements Serializable{
    Node raiz;
    String filename;

    public void ArPa(){
        raiz=null;
    }

    public void insertar(String pa, String cap){
        Node pais = new Node(pa,cap);
        if (raiz!=null){
            raiz.ant = pais;
            pais.sig = raiz;
        }
        raiz= pais;
    }

    public Node recorrido(int sem) {
        int cont = sem;
        int cont2 = 0;
        String cad;
        Node aux =raiz;
        for (int i=0;i<sem-1;i++ ){
            aux = aux.sig;
        }
        cad=aux.pais+"su capital"+aux.capital;
        return aux;

    }

    public int random(int cont){
        int M=cont;
        Random numAleatorio = new Random();
        int n=numAleatorio.nextInt(M-0+1)+0;
        return n;

    }

    @Override
    public String toString(){
        String cad = "";

        Node reco=raiz;
        while(reco!=null){
            cad+=reco.pais+"->"+reco.capital+"  ";
            reco=reco.sig;
        }
        return cad;
    }


}
