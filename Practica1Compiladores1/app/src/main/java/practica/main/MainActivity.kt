package practica.main

import analisis.lexico.AnalizadorLexico
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import errores.TablaDeErrores
import java.io.StringReader

var tabla:TablaDeErrores = TablaDeErrores()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // iniciarAplicacion();

    }

    fun eventoBoton1(view: View) {
        var areaTexto:EditText = findViewById(R.id.areaTexto)
        var texto = areaTexto.text.toString();
        println(texto)
        val str = StringReader(texto)
        val analizador = AnalizadorLexico(str)
        analizador.setTabla(tabla)
        try {
            var bandera = true
            while (bandera) {
                val tokens = analizador.yylex()
                if (tokens == null) {
                    bandera = false
                }
                if (tokens == Token.ERROR){
                    println("ESte es un error")
                }
            }
        } catch (e: Exception) {
        }

        if (tabla.getCantidadErrores() > 0){
            var lista = tabla.getListaDeErrores()
            lista.forEach{
                println("Lexema: ${it.getLexema()} Linea: ${it.getLinea()} Columna: ${it.getColumna()} Tipo: ${it.getTipo()}")
            }
        } else {
            println("No hay errores en el programa")
        }

    }
}