package App.Model;

public class Model {

    // Se cargan los arrays de cada continente

    public LoadFile america = new LoadFile();
    public LoadFile europe = new LoadFile();
    public LoadFile asia = new LoadFile();
    public LoadFile africa = new LoadFile();
    public LoadFile oceania = new LoadFile();

    public ArPa arrayAmerica = america.loadContinent("America");
    public ArPa arrayEurope = europe.loadContinent("Europa");
    public ArPa arrayAsia = asia.loadContinent("Asia");
    public ArPa arrayAfrica = africa.loadContinent("Africa");
    public ArPa arrayOceania = oceania.loadContinent("Oceania");


    /* ---------------------- DESCRIPCION DEL MÉTODO -------------------------------------------------------------------
        Retorna un array de cadenas con el nombre de cada botón respectivamente
        para ser operados en el controlador y asignados a los botones.

        se seleccionan aleatoriamente 4 nodos de los cuales el primero se veriicara su estado para ver si ya fue
        procesado esto quiere decir que si ya se pregunto la capital de dicho pais contenido en el nodo, si ya se
        proceso no se volvera a tomar en cuenta para procesarse pero si la capital para poner como opcion
      ------------------------------------------------------------------------------------------------------------------
    */
    public String[] generateCapitalsForButtons(ArPa continent, LoadFile file){
        int valueCounter = 0;
        int rand;
        int cont = file.cont;
        String [] capitalsForButtons = new String[4];
        int [] capitals = {0,0,0,0}; // Array para comprobar que no se repitan capitales
        for (int i = 0; i < 4; i++) {
            rand = continent.random(cont);
            Node temp = continent.recorrido(rand);
            if (rand > 1 && rand != capitals[0] && rand != capitals[1] && rand != capitals[2]) {
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

}
