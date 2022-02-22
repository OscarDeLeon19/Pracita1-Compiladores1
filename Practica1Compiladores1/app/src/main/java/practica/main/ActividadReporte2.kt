package practica.main

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TableLayout
import android.widget.TextView
import graficos.TablaDeGraficas
import ocurrencias.Ocurrencia
import ocurrencias.TablaDeOcurrencias

class ActividadReporte2 : AppCompatActivity() {
    var tablaLayout: TableLayout?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_reporte2)
        tablaLayout = findViewById(R.id.tablaReporte2)
        var objetoEnviado = intent.extras
        var tablaDeOcurrencias = TablaDeOcurrencias()
        if (objetoEnviado!=null){
            tablaDeOcurrencias = objetoEnviado.getSerializable("tablaDeOcurrencias") as TablaDeOcurrencias
        }

        var lista = tablaDeOcurrencias.lista
        agregarDatos(lista)
    }

    fun agregarDatos(lista: ArrayList<Ocurrencia>){
        for (i in -1 until  lista.size){
            val registro = LayoutInflater.from(this).inflate(R.layout.item_reporte2, null,false)
            val itemOperador = registro.findViewById<View>(R.id.itemOperador) as TextView
            val itemLinea = registro.findViewById<View>(R.id.itemLineaOP) as TextView
            val itemColumna = registro.findViewById<View>(R.id.itemColumnaOP) as TextView
            val itemEjemplo = registro.findViewById<View>(R.id.itemEjemplo) as TextView

            if (i == -1){
                itemOperador.setText("Operador")
                itemOperador.setBackgroundColor(Color.BLACK)
                itemOperador.setTextColor(Color.WHITE);

                itemLinea.setText("Linea")
                itemLinea.setBackgroundColor(Color.BLACK)
                itemLinea.setTextColor(Color.WHITE);

                itemColumna.setText("Columna")
                itemColumna.setBackgroundColor(Color.BLACK)
                itemColumna.setTextColor(Color.WHITE);

                itemEjemplo.setText("Tipo")
                itemEjemplo.setBackgroundColor(Color.BLACK)
                itemEjemplo.setTextColor(Color.WHITE);

            } else {

                itemOperador.setText(lista[i].operador)
                itemOperador.setBackgroundColor(Color.GRAY)
                itemOperador.setTextColor(Color.BLACK);


                itemLinea.setText(lista[i].getLinea().toString())
                itemLinea.setBackgroundColor(Color.GRAY)
                itemLinea.setTextColor(Color.BLACK);

                itemColumna.setText(lista[i].getColumna().toString())
                itemColumna.setBackgroundColor(Color.GRAY)
                itemColumna.setTextColor(Color.BLACK);

                itemEjemplo.setText(lista[i].ejemplo)
                itemEjemplo.setBackgroundColor(Color.GRAY)
                itemEjemplo.setTextColor(Color.BLACK);

            }
            tablaLayout?.addView(registro)
        }
    }
}