package errores

import java.io.Serializable

class TablaDeErrores : Serializable {

    private var cantidadErroes = 0;
    private var lista = arrayListOf<Error>()

    constructor(){

    }

    /**
     * Retorna la cantidad de errores de la tabla
     */
    fun getCantidadErrores():Int{
        return cantidadErroes
    }

    /**
     * Retorna la lista en donde se encuentra los errores
     */
    fun getListaDeErrores(): ArrayList<Error>{
        return lista
    }

    /**
     * Agrega un error a la lista de errores
     */
    fun agregarError(lexema:String, linea:Int,columna:Int, tipo:String, descripcion:String){
        var nuevoError:Error = Error(lexema, linea, columna, tipo, descripcion)
        lista.add(nuevoError)
        cantidadErroes++
    }

    /**
     * Limpia la tabla de errores y el contador regresa a 0
     */
    fun reiniciarTabla() {
        lista.clear()
        cantidadErroes = 0;


    }

}