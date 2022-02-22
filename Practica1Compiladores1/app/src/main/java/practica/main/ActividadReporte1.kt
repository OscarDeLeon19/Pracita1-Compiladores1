package practica.main

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TableLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import graficos.Barra
import graficos.Grafica
import graficos.Pie
import graficos.TablaDeGraficas

class ActividadReporte1 : AppCompatActivity() {
    var tablaLayout: TableLayout?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_reporte1)
        tablaLayout = findViewById(R.id.tablaReporte1)
        var objetoEnviado = intent.extras
        var tablaDeGraficas = TablaDeGraficas()
        if (objetoEnviado!=null){
            tablaDeGraficas = objetoEnviado.getSerializable("tablaDeGraficas") as TablaDeGraficas
        }

        var lista = tablaDeGraficas.lista
        agregarDatos(lista)
    }

    fun agregarDatos(lista: ArrayList<Grafica>){
        println("Cantidad de graficas definidas: " + lista.size)
        var cantidadBarras = 0;
        var cantidadPie = 0;
        for (i  in  lista.indices){
            if (lista[i] is Barra){
                cantidadBarras++
            }else if (lista[i] is Pie){
                cantidadPie++;
            }
        }

        for (i in 0..2) {
            val registro = LayoutInflater.from(this).inflate(R.layout.item_reporte1, null, false)
            val itemObjeto = registro.findViewById<View>(R.id.itemObjeto) as TextView
            val itemCantidad = registro.findViewById<View>(R.id.itemCantidad) as TextView
            if (i == 0) {
                itemObjeto.setText("Objeto")
                itemObjeto.setBackgroundColor(Color.BLACK)
                itemObjeto.setTextColor(Color.WHITE);

                itemCantidad.setText("Cantidad de Definiciones")
                itemCantidad.setBackgroundColor(Color.BLACK)
                itemCantidad.setTextColor(Color.WHITE);
            } else if (i == 1) {
                itemObjeto.setText("Barras")
                itemObjeto.setBackgroundColor(Color.GRAY)
                itemObjeto.setTextColor(Color.BLACK);

                itemCantidad.setText(cantidadBarras.toString())
                itemCantidad.setBackgroundColor(Color.GRAY)
                itemCantidad.setTextColor(Color.BLACK);
            } else if (i == 2) {
                itemObjeto.setText("Pie")
                itemObjeto.setBackgroundColor(Color.GRAY)
                itemObjeto.setTextColor(Color.BLACK);

                itemCantidad.setText(cantidadPie.toString())
                itemCantidad.setBackgroundColor(Color.GRAY)
                itemCantidad.setTextColor(Color.BLACK);
            }
            tablaLayout?.addView(registro)
        }
    }
}