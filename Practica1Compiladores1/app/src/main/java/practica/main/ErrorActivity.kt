package practica.main

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TableLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import errores.Error
import errores.TablaDeErrores

class ErrorActivity : AppCompatActivity() {
    var tablaLayout:TableLayout?= null

    /**
     * Muestra la tabla de errores que pueden ocurrir en el programa
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_error)

        tablaLayout = findViewById(R.id.tablaErrores)
        var objetoEnviado = intent.extras
        var tabla = TablaDeErrores()
        if (objetoEnviado != null){
            tabla = objetoEnviado.getSerializable("Tabla") as TablaDeErrores
        }
        var listaDeErrores = tabla.getListaDeErrores()
        agregarDatos(listaDeErrores)
    }

    /**
     * Agrega los datos de los errores a una tabla para visualizarse
     */
    fun agregarDatos(lista: ArrayList<Error>){
        for (i in -1 until  lista.size){
            val registro = LayoutInflater.from(this).inflate(R.layout.item_tabla_layout, null,false)
            val itemLexema = registro.findViewById<View>(R.id.itemLexema) as TextView
            val itemLinea = registro.findViewById<View>(R.id.itemLinea) as TextView
            val itemColumna = registro.findViewById<View>(R.id.itemColumna) as TextView
            val itemTipo = registro.findViewById<View>(R.id.itemTipo) as TextView
            val itemDescripcion = registro.findViewById<View>(R.id.itemDescripcion) as TextView

            if (i == -1){
                itemLexema.setText("Lexema")
                itemLexema.setBackgroundColor(Color.BLACK)
                itemLexema.setTextColor(Color.WHITE);

                itemLinea.setText("Linea")
                itemLinea.setBackgroundColor(Color.BLACK)
                itemLinea.setTextColor(Color.WHITE);

                itemColumna.setText("Columna")
                itemColumna.setBackgroundColor(Color.BLACK)
                itemColumna.setTextColor(Color.WHITE);

                itemTipo.setText("Tipo")
                itemTipo.setBackgroundColor(Color.BLACK)
                itemTipo.setTextColor(Color.WHITE);

                itemDescripcion.setText("Descripcion")
                itemDescripcion.setBackgroundColor(Color.BLACK)
                itemDescripcion.setTextColor(Color.WHITE);
            } else {

                itemLexema.setText(lista[i].getLexema())
                itemLexema.setBackgroundColor(Color.GRAY)
                itemLexema.setTextColor(Color.BLACK);


                itemLinea.setText(lista[i].getLinea().toString())
                itemLinea.setBackgroundColor(Color.GRAY)
                itemLinea.setTextColor(Color.BLACK);

                itemColumna.setText(lista[i].getColumna().toString())
                itemColumna.setBackgroundColor(Color.GRAY)
                itemColumna.setTextColor(Color.BLACK);

                itemTipo.setText(lista[i].getTipo())
                itemTipo.setBackgroundColor(Color.GRAY)
                itemTipo.setTextColor(Color.BLACK);

                itemDescripcion.setText(lista[i].getDescripcion())
                itemDescripcion.setBackgroundColor(Color.GRAY)
                itemDescripcion.setTextColor(Color.BLACK);
            }
            tablaLayout?.addView(registro)
        }
    }

    /**
     * Regresa a la actividad con el area de texto
     */
    fun eventoBoton1(view: View) {
        var textoEnviado = intent.getStringExtra("textoArea");
        println("Texto Enviado: " + textoEnviado)
        val miIntent = Intent(this@ErrorActivity, MainActivity::class.java)
        miIntent.putExtra("textoArea", textoEnviado)
        startActivity(miIntent);
    }
}