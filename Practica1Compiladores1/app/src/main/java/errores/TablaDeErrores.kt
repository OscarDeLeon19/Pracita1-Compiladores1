package errores

class TablaDeErrores {

    private var cantidadErroes = 0;
    private var lista = arrayListOf<Error>()

    constructor(){

    }

    fun getListaDeErrores(): ArrayList<Error>{
        return lista
    }

    fun agregarError(lexema:String, linea:Int,columna:Int, tipo:String, descripcion:String){
        var nuevoError:Error = Error(lexema, linea, columna, tipo, descripcion)
        lista.add(nuevoError)
        cantidadErroes++
    }


}