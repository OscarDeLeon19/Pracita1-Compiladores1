package practica.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import graficos.TablaDeGraficas
import ocurrencias.TablaDeOcurrencias

class EjecucionActivity : AppCompatActivity() {

    var tablaDeGraficas = TablaDeGraficas()
    var tablaDeOcurrencias = TablaDeOcurrencias()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejecucion)

        var objetoEnviado = intent.extras

        if (objetoEnviado!=null){
            tablaDeGraficas = objetoEnviado.getSerializable("tablaDeGraficas") as TablaDeGraficas
            tablaDeOcurrencias = objetoEnviado.getSerializable("tablaDeOcurrencias") as TablaDeOcurrencias
        }
    }

    fun eventoVerGraficas(view: View) {
        val miIntent = Intent(this@EjecucionActivity, EjecucionGraficas::class.java)
        var miBundle = Bundle()
        miBundle.putSerializable("tablaDeGraficas", graficas)
        miIntent.putExtras(miBundle)
        startActivity(miIntent)
    }
    fun verReporte1(view: View) {
        val miIntent = Intent(this@EjecucionActivity, ActividadReporte1::class.java)
        var miBundle = Bundle()
        miBundle.putSerializable("tablaDeGraficas", graficas)
        miIntent.putExtras(miBundle)
        startActivity(miIntent)
    }
    fun verReporte2(view: View) {
        val miIntent = Intent(this@EjecucionActivity, ActividadReporte2::class.java)
        var miBundle = Bundle()
        miBundle.putSerializable("tablaDeOcurrencias", tablaDeOcurrencias)
        miIntent.putExtras(miBundle)
        startActivity(miIntent)
    }
}