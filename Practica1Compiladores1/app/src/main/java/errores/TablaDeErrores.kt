package errores

import java.io.Serializable

class TablaDeErrores : Serializable {

    private var cantidadErroes = 0;
    private var lista = arrayListOf<Error>()

    constructor(){

    }

    fun getCantidadErrores():Int{
        return cantidadErroes
    }

    fun getListaDeErrores(): ArrayList<Error>{
        return lista
    }

    fun agregarError(lexema:String, linea:Int,columna:Int, tipo:String, descripcion:String){
        var nuevoError:Error = Error(lexema, linea, columna, tipo, descripcion)
        lista.add(nuevoError)
        cantidadErroes++
    }

    fun reiniciarTabla() {
        lista.clear()
        cantidadErroes = 0;


    }

}