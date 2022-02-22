package practica.main

import analisis.lexico.AnalizadorLexico
import analisis.sintactico.parser
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import errores.TablaDeErrores
import graficos.Barra
import graficos.Pie
import graficos.TablaDeGraficas
import java.io.StringReader
import android.content.Intent


var tabla:TablaDeErrores = TablaDeErrores()
var graficas:TablaDeGraficas = TablaDeGraficas()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var nuevoTexto = intent.getStringExtra("textoArea")
        println("Nuevo Texto Enviado: " + nuevoTexto)
        var areaTexto:EditText = findViewById(R.id.areaTexto)
        areaTexto.setText(nuevoTexto);

    }

    fun eventoBoton1(view: View) {
        tabla.reiniciarTabla()
        graficas.reiniciarLista()
        graficas.reiniciarEjecuciones()
        var areaTexto:EditText = findViewById(R.id.areaTexto)
        var texto = areaTexto.text.toString();
        println(texto)
        val str = StringReader(texto)
        val analizador = AnalizadorLexico(str)
        var par:parser = parser(analizador)
        graficas.setErrores(tabla)
        par.setTabla(tabla)
        par.setGraficas(graficas);
        analizador.setTabla(tabla)
        try {
            par.parse()
        } catch (e: Exception) {
            println(e.printStackTrace())
        }

        if (tabla.getCantidadErrores() > 0){
            var lista = tabla.getListaDeErrores()
            val miIntent = Intent(this@MainActivity, ErrorActivity::class.java)
            val miBundle = Bundle()
            miBundle.putSerializable("Tabla", tabla)
            miBundle.putString("textoArea", texto)
            miIntent.putExtras(miBundle)
            startActivity(miIntent)
        } else {
            val miIntent = Intent(this@MainActivity, EjecucionActivity::class.java)
            var miBundle = Bundle()
            miBundle.putSerializable("tablaDeGraficas", graficas)
            miBundle.putString("textoArea", texto)
            miIntent.putExtras(miBundle)
            startActivity(miIntent)


            var lista = graficas.listaDeEjecuciones;
            println("Cantidad de graficas: " + lista.size)
            for (i in lista.indices) {
                if (lista[i] is Barra) {
                    val nueva = lista[i] as Barra
                    println("Titulo: " + nueva.titulo)
                    println("EjesX: " + nueva.ejeX)
                    println("Ejesy: " + nueva.ejeY)
                    println("Uniones: " + nueva.unir)
                } else if (lista[i] is Pie){
                    val nueva = lista[i] as Pie
                    println("Titulo: " + nueva.titulo)
                    println("Tipo: " + nueva.tipo)
                    println("Etiquetas: " + nueva.etiquetas)
                    println("Valores: " + nueva.valores)
                    println("Uniones: " + nueva.unir)
                    println("Total: " + nueva.total)
                    println("Extra: " + nueva.extra)
                }
            }
        }

    }
}