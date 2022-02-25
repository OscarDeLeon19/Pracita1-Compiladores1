package ocurrencias;

import java.io.Serializable;
import java.util.ArrayList;

public class TablaDeOcurrencias implements Serializable {

    private ArrayList<Ocurrencia> lista = new ArrayList<>();

    /**
     * Constructor de la clase TablaDeOcurrencia
     * @param lista La lista de ocurrencias
     */
    public TablaDeOcurrencias(ArrayList<Ocurrencia> lista) {
        this.lista = lista;
    }

    /**
     * Contructor vacio de la tabla de ocurrencias
     */
    public TablaDeOcurrencias() {
    }

    /**
     * Devuelve la lista de ocurrencias
     * @return La lista de ocurrencias
     */
    public ArrayList<Ocurrencia> getLista() {
        return lista;
    }

    /**
     * Obtiene la lista de ocurrencias
     * @param lista La lista de ocurrencias
     */
    public void setLista(ArrayList<Ocurrencia> lista) {
        this.lista = lista;
    }

    /**
     * Agrega una ocurrencia a la lista de ocurrencias
     * @param operador El operador de la ocurrencia
     * @param linea La linea de ocurrencia
     * @param columna La columna de la ocurrencia
     * @param ejemplo El ejemplo de la ocurrencia
     */
    public void agregarOcurrencia(String operador, int linea, int columna, String ejemplo){
        Ocurrencia nueva_ocurrencia = new Ocurrencia(operador, linea, columna, ejemplo);
        lista.add(nueva_ocurrencia);

    }
}
