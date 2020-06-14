package App.Model;
import java.io.*;

public class NuevoTest {
    public static void main(String [] arg) {
        File archivo ;
        int cont = 0;
        FileReader fileReader = null;
        BufferedReader bufferedReader ;
        ArPa continente= new ArPa();

        /* Se abre el fichero para se lectura */
        try {

            archivo = new File ("src/App/ContinentsTXT/America.txt");//la ruta se puede cambiar por una variale que la contenga
            fileReader = new FileReader (archivo);
            bufferedReader = new BufferedReader(fileReader);

            // Lectura del fichero
            String linea;
            while((linea = bufferedReader.readLine()) != null){
                continente.insertar(linea, bufferedReader.readLine());
                cont += 1;

            }
        } catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if( null != fileReader ){
                    fileReader.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
        /*se seleccionan aleatoriamente 4 nodos de los cuales el primero se veriicara su estado para ver si ya fue procesado
        esto quiere decir que si ya se pregunto la capital de dicho pais contenido en el nodo, si ya se proceso no se volvera
        a tomar en cuenta para procesarse pero si la capital para poner como opcion*/
            int valueCounter = 0;
            int rand;
            int [] capitals = {0,0,0,0}; // Array para comprobar que no se repitan capitales
            for (int i = 0; i < 4; i++) {

                rand = continente.random(cont);
                Nodo temp = continente.recorrido(rand);
                if (rand > 1 && rand != capitals[0] && rand != capitals[1] && rand != capitals[2]) {
                    capitals[valueCounter] = rand;
                    valueCounter++;
                    if (i == 0) {
                        System.out.println(temp.pais);
                        System.out.println();
                        System.out.println(temp.capital);
                        temp.correcto = true;
                    } else {
                        System.out.println(temp.capital);
                    }
                } else i--;

            }

    }
}