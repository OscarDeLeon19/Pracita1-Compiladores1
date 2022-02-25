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
import com.github.mikephil.charting.charts.PieChart
import ocurrencias.TablaDeOcurrencias


var tabla:TablaDeErrores = TablaDeErrores()
var graficas:TablaDeGraficas = TablaDeGraficas()
var operadores:TablaDeOcurrencias = TablaDeOcurrencias()

class MainActivity : AppCompatActivity() {
    /**
     * Actividad inicial en donde esta el area de texto y un boton para realizar las acciones de la aplicacion
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var nuevoTexto = intent.getStringExtra("textoArea")
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
        par.setTablaDeOcurrencias(operadores)
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
            miBundle.putSerializable("tablaDeOcurrencias", operadores)
            miBundle.putString("textoArea", texto)
            miIntent.putExtras(miBundle)
            startActivity(miIntent)
        }
    }
}