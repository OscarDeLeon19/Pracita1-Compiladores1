package practica.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TableLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import graficos.Barra
import graficos.Grafica
import graficos.Pie
import graficos.TablaDeGraficas

class EjecutarGraficas : AppCompatActivity() {
    var tablaLayout: TableLayout?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejecutar_graficas)
        tablaLayout = findViewById(R.id.tablaGraficasPie)
        var objetoEnviado = intent.extras
        var tablaDeGraficas = TablaDeGraficas()
        if (objetoEnviado!=null){
            tablaDeGraficas = objetoEnviado.getSerializable("tablaDeGraficas") as TablaDeGraficas
        }
        var lista = tablaDeGraficas.listaDeEjecuciones

        agregarGrafica(lista)

        /*
        var primera: Pie = lista[0] as Pie

        var PieCharg:PieChart = findViewById(R.id.graficaPie)

        var listaEtiquetas = primera.etiquetas
        var listaValores = primera.valores
        var listaUniones = primera.unir

        var dataValores = ArrayList<PieEntry>()
        var i = 0
            while (i < listaUniones.size) {
                if (i == listaUniones.size){

                } else {
                    var nuevoPie = PieEntry(listaValores[listaUniones[i+1]].toFloat(), listaEtiquetas[listaUniones[i]])
                    dataValores.add(nuevoPie);

                }

                i+=2
            }

        var colors = ArrayList<Int>()
        for (color in ColorTemplate.MATERIAL_COLORS) {
            colors.add(color)
        }
        for (color in ColorTemplate.VORDIPLOM_COLORS) {
            colors.add(color)
        }



        data.setValues(dataValores)
        data.setLabel(primera.titulo)
        data.setColors(colors)
        data.setValueTextSize(16f)

        var dataPie: PieData = PieData(data)

        PieCharg.setData(dataPie)

        if (primera.tipo == "Porcentaje"){
            PieCharg.setUsePercentValues(true)
        }

        PieCharg.description.setEnabled(false)
        PieCharg.setCenterText(primera.titulo)
        data.setFormLineWidth(4F)
        */
    }

    fun agregarGrafica(lista: ArrayList<Grafica>){

        var colors = ArrayList<Int>()
        for (color in ColorTemplate.MATERIAL_COLORS) {
            colors.add(color)
        }
        for (color in ColorTemplate.VORDIPLOM_COLORS) {
            colors.add(color)
        }

        for (i  in  lista.indices){
            if (lista[i] is Barra){
            }else if (lista[i] is Pie){
                println("Se encontro graficaPie")
                var graficaPie = lista[i] as Pie
                val registro = LayoutInflater.from(this).inflate(R.layout.item_grafica1, null, false)
                val itemGrafica1 = registro.findViewById<View>(R.id.itemGraficaPie) as PieChart
                val itemGrafica2 = registro.findViewById<View>(R.id.itemGraficaBar) as BarChart


                var listaEtiquetas = graficaPie.etiquetas
                var listaValores = graficaPie.valores
                var listaUniones = graficaPie.unir

                var dataSet = PieDataSet(null, null);
                var dataValores = ArrayList<PieEntry>()
                var i = 0
                while (i < listaUniones.size) {
                    if (i == listaUniones.size){

                    } else {
                        var nuevoPie = PieEntry(listaValores[listaUniones[i+1]].toFloat(), listaEtiquetas[listaUniones[i]])
                        dataValores.add(nuevoPie);

                    }
                    i+=2
                }

                if (graficaPie.tipo == "Porcentaje"){
                    itemGrafica1.setUsePercentValues(true)
                    var nuevoPie = PieEntry(360f, "Extra")
                    dataValores.add(nuevoPie);
                }

                dataSet.setValues(dataValores)
                dataSet.setLabel(graficaPie.titulo)
                dataSet.setColors(colors)
                dataSet.setValueTextSize(16f)

                var dataPie = PieData(dataSet)

                itemGrafica1.setData(dataPie)



                itemGrafica1.description.setEnabled(false)
                itemGrafica1.setCenterText(graficaPie.titulo)
                dataSet.setFormLineWidth(4F)
                tablaLayout?.addView(registro)
            }
        }

    }
}