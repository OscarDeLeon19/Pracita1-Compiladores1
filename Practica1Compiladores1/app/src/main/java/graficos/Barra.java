package graficos;

import java.io.Serializable;
import java.util.ArrayList;

public class Barra extends Grafica implements Serializable {

    private ArrayList<String> ejeX = new ArrayList<>();
    private ArrayList<Double> ejeY = new ArrayList<>();

    /**
     * Contructor de la clase barra
     * @param titulo El titulo de la grafica
     * @param unir Lista de uniones
     * @param ejeX Lista de etiquetas del ejeX
     * @param ejeY Lista de valores y tamaños de las barras
     */
    public Barra(String titulo, ArrayList<Integer> unir, ArrayList<String> ejeX, ArrayList<Double> ejeY) {
        super(titulo, unir);
        this.ejeX = ejeX;
        this.ejeY = ejeY;
    }

    /**
     * Contructor vacio
     */
    public Barra(){
    }

    /**
     * Returna la lista de el ejeX
     * @return Lista de valores
     */
    public ArrayList<String> getEjeX() {
        return ejeX;
    }

    /**
     * Obtiene la lista de valores del ejeY
     * @return La lista de valores en y
     */
    public ArrayList<Double> getEjeY() {
        return ejeY;
    }

    /**
     * Agrega un valor al ejeX
     * @param eje El eje que se agregará
     */
    public void agregarEjeX(String eje){
        ejeX.add(eje);
    }

    /**
     * Agrega un valor al ejeY
     * @param eje El valor que se agregara
     */
    public void agregarEjeY(double eje){
        ejeY.add(eje);
    }
}
