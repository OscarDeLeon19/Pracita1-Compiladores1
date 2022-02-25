package errores

import java.io.Serializable

class Error: Serializable {

    private var lexema = ""
    private var linea = 0
    private var columna = 0
    private var tipo = ""
    private var descripcion = ""

    constructor(){

    }

    /**
     * Constructor de la clase Error
     */
    constructor(lexema:String, linea:Int,columna:Int, tipo:String, descripcion:String){
        this.lexema = lexema
        this.linea = linea
        this.columna = columna
        this.tipo = tipo
        this.descripcion = descripcion
    }

    /**
     * Regresa el lexema en donde se encuentra el error
     */
    fun getLexema(): String {
        return lexema;
    }

    /**
     * Obtiene la linea en donde ocurrio el error
     */
    fun getLinea(): Int {
        return linea;
    }

    /**
     * Obtiene la columna en donde ocurrio un error
     */
    fun getColumna(): Int {
        return columna;
    }

    /**
     * Obtiene el tipo de error
     */
    fun getTipo(): String {
        return tipo;
    }

    /**
     * Obtiene la descripcion del error
     */
    fun getDescripcion(): String {
        return descripcion;
    }

}