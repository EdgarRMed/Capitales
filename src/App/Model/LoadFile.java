package App.Model;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class LoadFile {

    public int cont = 0;
    // Este método devuelve un array con los datos del continente

    public ArPa loadContinent(String name) {
        Path caminoArchivo = Paths.get("src/App/ContinentsTXT/" + name + ".txt");
        Scanner sc;
        ArPa continent = new ArPa();

        /* Se abre el fichero para se lectura */
        try {
            // Cambiar el pathname segun el equipo donde se corre el proyecto
            sc = new Scanner(caminoArchivo);

            // Lectura del fichero
            while (sc.hasNextLine()) {
                continent.insertar(sc.nextLine(), sc.nextLine());
                cont++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return continent;
    }
}
