package practica.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import graficos.TablaDeGraficas

class EjecucionActivity : AppCompatActivity() {

    var tablaDeGraficas = TablaDeGraficas()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejecucion)

        var objetoEnviado = intent.extras

        if (objetoEnviado!=null){
            tablaDeGraficas = objetoEnviado.getSerializable("tablaDeGraficas") as TablaDeGraficas
        }
    }

    fun eventoVerGraficas(view: View) {}
    fun verReporte1(view: View) {
        val miIntent = Intent(this@EjecucionActivity, ActividadReporte1::class.java)
        var miBundle = Bundle()
        miBundle.putSerializable("tablaDeGraficas", graficas)
        miIntent.putExtras(miBundle)
        startActivity(miIntent)
    }
    fun verReporte2(view: View) {}
}