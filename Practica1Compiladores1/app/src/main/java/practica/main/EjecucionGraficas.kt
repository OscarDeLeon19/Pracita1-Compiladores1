package practica.main

import android.graphics.Color
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import graficos.Barra
import graficos.Pie
import graficos.TablaDeGraficas

class EjecucionGraficas : AppCompatActivity() {
    /**
     * Actividad que muestra todas las graficas que se ejecutan
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejecucion_graficas)
        var objetoEnviado = intent.extras
        var tablaDeGraficas = TablaDeGraficas()
        if (objetoEnviado!=null){
            tablaDeGraficas = objetoEnviado.getSerializable("tablaDeGraficas") as TablaDeGraficas
        }
        var lista = tablaDeGraficas.listaDeEjecuciones
        var layoutL = findViewById(R.id.linealLayout) as LinearLayout
        var parametrosLayout = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.MATCH_PARENT)
        parametrosLayout.bottomMargin = 100
        parametrosLayout.gravity = 1
        parametrosLayout.width = 600
        parametrosLayout.height=600
        // Obtiene todos los colores que se usaran en las graficas
        var colors = ArrayList<Int>()
        for (color in ColorTemplate.MATERIAL_COLORS) {
            colors.add(color)
        }
        for (color in ColorTemplate.VORDIPLOM_COLORS) {
            colors.add(color)
        }
        for (i  in  lista.indices) {
            if (lista[i] is Barra) {
                var graficaBarra = lista[i] as Barra
                var grafica:BarChart = BarChart(this)
                var listaEtiquetas = graficaBarra.ejeX
                var listaValores = graficaBarra.ejeY
                var listaUniones = graficaBarra.unir
                grafica.setLayoutParams(parametrosLayout)
                grafica.description.setText(graficaBarra.titulo)
                grafica.description.setTextSize(10f)

                var entradas = ArrayList<BarEntry>()
                var etiquetas = ArrayList<String>()
                var i = 0
                var pos = 0
                while (i < listaUniones.size) {
                    try {
                        etiquetas.add(listaEtiquetas[listaUniones[i]])
                        var entrada =
                            BarEntry(pos.toFloat(), listaValores[listaUniones[i + 1]].toFloat())
                        entradas.add(entrada)
                        pos++
                    } catch (e:Exception){
                        Toast.makeText(this,"Error en valor de unir de " + graficaBarra.titulo,Toast.LENGTH_SHORT).show()
                    }
                    i+=2
                }
                // Agrega los parametros de el ejex de la grafica
                var xasis = grafica.xAxis
                xasis.setGranularityEnabled(true)
                xasis.setLabelRotationAngle(45f)
                xasis.setPosition(XAxis.XAxisPosition.BOTTOM)
                var index = IndexAxisValueFormatter(etiquetas)
                xasis.setValueFormatter(index)
                // Agrega los datos a la grafica de barras
                var dataSet = BarDataSet(entradas, graficaBarra.titulo)
                var data = BarData(dataSet)
                data.setBarWidth(0.4f)
                dataSet.setColors(colors)
                grafica.setData(data)
                grafica.setFitBars(true)
                layoutL.addView(grafica)
            } else if (lista[i] is Pie) {
                var graficaPie = lista[i] as Pie
                var grafica:PieChart = PieChart(this)
                grafica.setLayoutParams(parametrosLayout)
                var listaEtiquetas = graficaPie.etiquetas
                var listaValores = graficaPie.valores
                var listaUniones = graficaPie.unir

                var dataSet = PieDataSet(null, null);
                var dataValores = ArrayList<PieEntry>()
                var i = 0
                while (i < listaUniones.size) {
                    try {
                        if (i == listaUniones.size) {

                        } else {
                            var nuevoPie = PieEntry(
                                listaValores[listaUniones[i + 1]].toFloat(),
                                listaEtiquetas[listaUniones[i]]
                            )
                            dataValores.add(nuevoPie);

                        }
                    } catch (e: Exception){
                        Toast.makeText(this,"Error en valor de unir de " + graficaPie.titulo,Toast.LENGTH_SHORT).show()

                    }
                    i+=2
                }
                if (graficaPie.tipo == "Porcentaje"){
                    grafica.setUsePercentValues(true)
                    var residuo = 360 - sumarValores(listaValores)
                    var nuevoPie = PieEntry(residuo.toFloat(), "Extra")
                    dataValores.add(nuevoPie);
                } else {
                    var residuo = graficaPie.total - sumarValores(listaValores)
                    var extra = ""
                    if (graficaPie.extra.equals("")){
                        extra = "Extra"
                    } else {
                        extra = graficaPie.extra
                    }
                    if (residuo > 0) {
                        var nuevoPie = PieEntry(residuo.toFloat(), extra)
                        dataValores.add(nuevoPie);
                    }
                }
                dataSet.setValues(dataValores)
                dataSet.setLabel(graficaPie.titulo)
                dataSet.setColors(colors)
                dataSet.setValueTextSize(10f)
                dataSet.setValueTextColor(Color.BLACK)

                var dataPie = PieData(dataSet)
                
                grafica.setData(dataPie)
                grafica.description.setEnabled(false)
                grafica.setEntryLabelTextSize(10f)
                grafica.setEntryLabelColor(Color.BLACK)
                grafica.setCenterText(graficaPie.titulo)
                dataSet.setFormLineWidth(4F)
                layoutL.addView(grafica)
            }

        }


    }

    /**
     * Suma los valores de la lista de double y devuelve la suma entera
     */
    fun sumarValores(lista: ArrayList<Double>): Double {
        var suma:Double = 0.0
        lista.forEach {
            suma += it
        }
        return suma
    }


}