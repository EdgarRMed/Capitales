package Modelo;
import java.io.*;

public class NuevoTest {
    public static void main(String [] arg) {
        File archivo ;
        int sem=0, cont=0;
        FileReader fr = null;
        BufferedReader br ;
        ArPa continente= new ArPa();
        /*Se habre el fichero para se lectura*/
        try {
            archivo = new File ("C:\\Users\\mach1_000\\IdeaProjects\\Modelo\\Continentes\\Oceania.txt");//la ruta se puede cambiar por una variale que la contenga
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while((linea=br.readLine())!=null){
                continente.insertar(linea,linea=br.readLine());
                cont+=1;

            }
        } catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
        /*se seleccionan aleatoriamente 4 nodos de los cuales el primero se veriicara su estado para ver si ya fue procesado
        esto quiere decir que si ya se pregunto la capital de dicho pais contenido en el nodo, si ya se proceso no se volvera
        a tomar en cuenta para procesarse pero si la capital para poner como opcion*/
        for(int i=0; i<4;i++){
            int [] ar=new int[4];
            int a=0;
            a=continente.random(cont);
            Node temp=continente.recorrido(a);
            if(a!=0 ){
                System.out.println(a);
                if(i==0){
                    System.out.println(temp.pais);
                    System.out.println(temp.capital);
                    temp.estado=true;
                }else{
                    System.out.println(temp.capital);
                }
            }else i--;

        }
    }
}