package App.Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LoadFile {

    public int cont = 0;

    // Este método devuelve un array con los datos del continente

    public ArPa loadContinent(String name) {
        File file;
        FileReader fileReader = null;
        BufferedReader bufferedReader;
        ArPa continent = new ArPa();

        /* Se abre el fichero para se lectura */
        try {
            // Cambiar el pathname segun el equipo donde se corre el proyecto
            file = new File("src/App/ContinentsTXT/" + name + ".txt");
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            // Lectura del fichero
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                continent.insertar(linea, bufferedReader.readLine());
                cont += 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fileReader) {
                    fileReader.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return continent;
    }
}
