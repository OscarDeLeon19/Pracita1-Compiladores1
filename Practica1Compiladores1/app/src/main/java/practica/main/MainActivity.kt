package practica.main

import analisis.lexico.AnalizadorLexico
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.StringReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // iniciarAplicacion();

    }

    private fun iniciarAplicacion(){
        val texto = "{} 43 \"BAD BUNNI\" Def Barras total 02 025.25 5 546.26 #hola mundo"
        println(texto)
        val str = StringReader(texto)
        val analizador = AnalizadorLexico(str)
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
    }

    fun eventoBoton1(view: View) {
        var areaTexto:EditText = findViewById(R.id.areaTexto)
        var texto = areaTexto.text.toString();
        println(texto)
        val str = StringReader(texto)
        val analizador = AnalizadorLexico(str)
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
    }
}