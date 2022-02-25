package graficos;

import java.io.Serializable;
import java.util.ArrayList;

public class Pie extends Grafica implements Serializable {

    private ArrayList<String> etiquetas = new ArrayList<>();
    private ArrayList<Double> valores = new ArrayList<>();
    private String tipo = "";
    private double total = 0;
    private String extra = "";

    /**
     * Contructor de la clase Pie
     * @param titulo El titulo de la grafica
     * @param unir La lista de valores unir
     * @param etiquetas La lista de etiquetas
     * @param valores La lista de valores de las etiquetas
     * @param tipo El tipo de grafica
     * @param total El total
     * @param extra La etiqueta del valor total
     */
    public Pie(String titulo, ArrayList<Integer> unir, ArrayList<String> etiquetas, ArrayList<Double> valores, String tipo, double total, String extra) {
        super(titulo, unir);
        this.etiquetas = etiquetas;
        this.valores = valores;
        this.tipo = tipo;
        this.total = total;
        this.extra = extra;
    }

    /**
     * Constructor vacio
     */
    public Pie() {

    }

    /**
     * Obtiene la lista de etiquetas de la grafica
     * @return
     */
    public ArrayList<String> getEtiquetas() {
        return etiquetas;
    }

    /**
     * Obtiene la lista de valores de las etiquetas
     * @return
     */
    public ArrayList<Double> getValores() {
        return valores;
    }

    /**
     * Obtiene el tipo de grafica
     * @return El tipo de grafica
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Obtiene el total de una grafica
     * @return El total
     */
    public double getTotal() {
        return total;
    }

    /**
     * Obtiene el atributo extra de la grafica
     * @return El atributo extra
     */
    public String getExtra() {
        return extra;
    }

    /**
     * Agrega una etiqueta a la lista de etiquetas
     * @param etiqueta La etiqueta que se va a agregar
     */
    public void agregarEtiqueta(String etiqueta){
        etiquetas.add(etiqueta);
    }

    /**
     * Agrega un valor a la lista de valores
     * @param valor El valor que se agregara
     */
    public void agregarValor(double valor){
        valores.add(valor);
    }

    /**
     * Agrega un total a la grafica
     * @param nuevoTotal El valor total
     */
    public void agregarTotal(double nuevoTotal){
        total = nuevoTotal;
    }

    /**
     * Agrega el tipo de grafica
     * @param nuevo_tipo El tipo de grafica
     */
    public void agregarTipo(String nuevo_tipo){
        tipo = nuevo_tipo;
    }

    /**
     * Agrega el atributo extra a la grafica
     * @param nuevo_extra El atributo extra
     */
    public void agregarExtra(String nuevo_extra){
        extra = nuevo_extra;
    }
}
