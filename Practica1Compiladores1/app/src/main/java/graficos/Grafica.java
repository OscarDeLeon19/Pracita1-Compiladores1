package graficos;

import java.io.Serializable;
import java.util.ArrayList;

public class Grafica implements Serializable {

    private String titulo = "";
    private ArrayList<Integer> unir = new ArrayList<>();

    /**
     * Constructor de la clase Grafica de la cual heredan Barra y Pie
     * @param titulo El titulo de la grafica
     * @param unir El valor unir de la grafica
     */
    public Grafica(String titulo, ArrayList<Integer> unir) {
        this.titulo = titulo;
        this.unir = unir;
    }

    /**
     * Constructor vacio de la clase Grafica
     */
    public Grafica() {
    }

    /**
     * Obtiene el titulo de la grafica
     * @return El titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Devuelve los valores de las uniones de la grafica
     * @return Los valores unir
     */
    public ArrayList<Integer> getUnir() {
        return unir;
    }

    /**
     * Agrega un valor a la lista de uniones
     * @param union El valor a la lista
     */
    public void agregarUnion(int union){
        unir.add(union);
    }

    /**
     * Agrega el titulo de la grafica
     * @param nuevotitulo El titulo
     */
    public  void agregarTitulo(String nuevotitulo){
        titulo = nuevotitulo.substring(1, nuevotitulo.length()-1);
    }

}
