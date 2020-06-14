package App.Model;

import java.util.Random;

public class Model {

    // Se cargan los arrays de cada continente

    public LoadFile americaFile = new LoadFile();
    public LoadFile europeFile = new LoadFile();
    public LoadFile asiaFile = new LoadFile();
    public LoadFile africaFile = new LoadFile();
    public LoadFile oceaniaFile = new LoadFile();

    public ArPa arrayAmerica = americaFile.loadContinent("America");
    public ArPa arrayEurope = europeFile.loadContinent("Europa");
    public ArPa arrayAsia = asiaFile.loadContinent("Asia");
    public ArPa arrayAfrica = africaFile.loadContinent("Africa");
    public ArPa arrayOceania = oceaniaFile.loadContinent("Oceania");


    /* ---------------------- DESCRIPCION DEL MÉTODO -------------------------------------------------------------------
        Retorna un array de cadenas con el nombre de cada botón respectivamente
        para ser operados en el controlador y asignados a los botones.

        se seleccionan aleatoriamente 4 nodos de los cuales el primero se verificara su estado para ver si ya fue
        procesado esto quiere decir que si ya se pregunto la capital de dicho pais contenido en el nodo, si ya se
        proceso no se volvera a tomar en cuenta para procesarse pero si la capital para poner como opcion
      ------------------------------------------------------------------------------------------------------------------
    */
    public void generateCapitalsForButtons(ArPa continent, LoadFile file) {
        int cont = file.cont;
        Random random = new Random();

        // Array para comprobar que no se repitan capitales

        int paisIndex = 0;
        for (Nodo aux = continent.raiz; aux != null; aux = aux.sig, paisIndex++) {
            int[] capitals = new int[4];

            int i = 0;
            while (i < 4) {
                int x = random.nextInt(cont);
                boolean yaEsta = false;

                for (int j = 0; j <= i; j++) {
                    if (x == capitals[j] && paisIndex != x) {
                        yaEsta = true;
                        break;
                    }
                }
                if (yaEsta) {
                    continue;
                }
                capitals[i] = x;
                i++;
            }

            String[] capitalsForButtons = new String[4];
            capitalsForButtons[new Random().nextInt(4)] = aux.capital;

            for (i = 0; i < 4; i++) {
                Nodo temp = continent.recorrido(capitals[i]);

                if (capitalsForButtons[i] == null) {
                    capitalsForButtons[i] = temp.capital;
                }
            }

            aux.possibleCapitals = capitalsForButtons;
        }
    }
    /*public String[] generateCapitalsForButtons(ArPa continent, LoadFile file) {
        int valueCounter = 0;
        int rand;
        int cont = file.cont;
        String[] capitalsForButtons = new String[5];
        int[] capitals = {0, 0, 0, 0, 0}; // Array para comprobar que no se repitan capitales

        for (int i = 0; i < 5; i++) {
            rand = continent.random(cont);
            Node temp = continent.recorrido(rand);

            if (rand > 1 && rand != capitals[0] && rand != capitals[1] && rand != capitals[2] && rand != capitals[3]) {
                capitals[valueCounter] = rand;
                valueCounter++;
                if (i == 0) {
                    // El primer y segundo elemento del array corresponden al país y capital respectivamente
                    capitalsForButtons[0] = temp.pais;
                    capitalsForButtons[1] = temp.capital;
                    temp.estado = true;
                } else {
                    capitalsForButtons[i] = temp.capital;
                }
            } else i--;
        }
        return capitalsForButtons;
    }

     */

}
