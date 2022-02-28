package practica.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import graficos.TablaDeGraficas
import ocurrencias.TablaDeOcurrencias

class EjecucionActivity : AppCompatActivity() {

    var tablaDeGraficas = TablaDeGraficas()
    var tablaDeOcurrencias = TablaDeOcurrencias()

    /**
     * Metodo que muestra las acciones a realizar en caso no hay errores lexicos o de sintaxis
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejecucion)

        var objetoEnviado = intent.extras

        if (objetoEnviado!=null){
            tablaDeGraficas = objetoEnviado.getSerializable("tablaDeGraficas") as TablaDeGraficas
            tablaDeOcurrencias = objetoEnviado.getSerializable("tablaDeOcurrencias") as TablaDeOcurrencias
        }
    }

    /**
     * Cambia a la actividad para visualizar las graficas para ejecutarse
     */
    fun eventoVerGraficas(view: View) {
        if (graficas.listaDeEjecuciones.size == 0){
            Toast.makeText(this,"No hay graficas listas para ejecucion",Toast.LENGTH_SHORT).show()
        } else {
            val miIntent = Intent(this@EjecucionActivity, EjecucionGraficas::class.java)
            var miBundle = Bundle()
            miBundle.putSerializable("tablaDeGraficas", graficas)
            miIntent.putExtras(miBundle)
            startActivity(miIntent)
        }
    }

    /**
     * Metodo que cambia a la actividad del reporte de graficas definidas
     */
    fun verReporte1(view: View) {
        val miIntent = Intent(this@EjecucionActivity, ActividadReporte1::class.java)
        var miBundle = Bundle()
        miBundle.putSerializable("tablaDeGraficas", graficas)
        miIntent.putExtras(miBundle)
        startActivity(miIntent)
    }

    /**
     * Metodo que cambia a la actividad del reporte de ocurrencias de operadores
     */
    fun verReporte2(view: View) {
        val miIntent = Intent(this@EjecucionActivity, ActividadReporte2::class.java)
        var miBundle = Bundle()
        miBundle.putSerializable("tablaDeOcurrencias", tablaDeOcurrencias)
        miIntent.putExtras(miBundle)
        startActivity(miIntent)
    }
}