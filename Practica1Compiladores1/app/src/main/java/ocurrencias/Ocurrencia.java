package ocurrencias;

import java.io.Serializable;

public class Ocurrencia implements Serializable {

    private String operador;
    private int linea;
    private int columna;
    private String ejemplo;

    /**
     * Constructor de la clase Ocurrencia
     * @param operador El operador de la ocurrencia
     * @param linea La linea en donde ocurre la ocurrencia
     * @param columna La columna en donde ocurre la ocurrencia
     * @param ejemplo El ejemplo de la ocurrencia
     */
    public Ocurrencia(String operador, int linea, int columna, String ejemplo) {
        this.operador = operador;
        this.linea = linea;
        this.columna = columna;
        this.ejemplo = ejemplo;
    }

    /**
     * Contructor vacio de la clase ocurrecia
     */
    public Ocurrencia(){

    }

    /**
     * Devuelve el operador de la ocurrencia
     * @return El operador de la ocurrencia
     */
    public String getOperador() {
        return operador;
    }

    /**
     * Establece un operador
     * @param operador El operador
     */
    public void setOperador(String operador) {
        this.operador = operador;
    }

    /**
     * Devuelve la linea en donde ocurre la ocurrencia
     * @return La linea de la ocurrencia
     */
    public int getLinea() {
        return linea;
    }

    /**
     * Establece la linea en donde ocurre la ocurrencia de operador
     * @param linea La linea
     */
    public void setLinea(int linea) {
        this.linea = linea;
    }

    /**
     * Devuelve el valor de la columna en donde ocurre la operacion
     * @return La columna
     */
    public int getColumna() {
        return columna;
    }

    /**
     * Establece la columna en donde ocurre la ocurrencia
     * @param columna La columna
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }

    /**
     * Devuelve el ejemplo de la ocurrencia
     * @return El ejemplo
     */
    public String getEjemplo() {
        return ejemplo;
    }

    /**
     * Obtiene el valor del ejemplo de la ocurrencia
     * @param ejemplo El ejemplo
     */
    public void setEjemplo(String ejemplo) {
        this.ejemplo = ejemplo;
    }
}
