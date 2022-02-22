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

    constructor(lexema:String, linea:Int,columna:Int, tipo:String, descripcion:String){
        this.lexema = lexema
        this.linea = linea
        this.columna = columna
        this.tipo = tipo
        this.descripcion = descripcion
    }

    fun getLexema(): String {
        return lexema;
    }

    fun getLinea(): Int {
        return linea;
    }

    fun getColumna(): Int {
        return columna;
    }

    fun getTipo(): String {
        return tipo;
    }

    fun getDescripcion(): String {
        return descripcion;
    }

}