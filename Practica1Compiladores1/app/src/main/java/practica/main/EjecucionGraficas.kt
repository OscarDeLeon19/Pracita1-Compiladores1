package practica.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import graficos.Barra
import graficos.Pie
import graficos.TablaDeGraficas

class EjecucionGraficas : AppCompatActivity() {
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

        var parametrosLayout = LinearLayout.LayoutParams(1000,800)
        println(LinearLayout.LayoutParams.MATCH_PARENT)
        println(LinearLayout.LayoutParams.WRAP_CONTENT)
        var colors = ArrayList<Int>()
        for (color in ColorTemplate.MATERIAL_COLORS) {
            colors.add(color)
        }
        for (color in ColorTemplate.VORDIPLOM_COLORS) {
            colors.add(color)
        }

        for (i  in  lista.indices) {
            if (lista[i] is Barra) {


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
                    if (i == listaUniones.size){

                    } else {
                        var nuevoPie = PieEntry(listaValores[listaUniones[i+1]].toFloat(), listaEtiquetas[listaUniones[i]])
                        dataValores.add(nuevoPie);

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
                dataSet.setValueTextSize(16f)

                var dataPie = PieData(dataSet)

                grafica.setData(dataPie)



                grafica.description.setEnabled(false)
                grafica.setCenterText(graficaPie.titulo)
                dataSet.setFormLineWidth(4F)


                layoutL.addView(grafica)
            }
        }




    }

    fun sumarValores(lista: ArrayList<Double>): Double {
        var suma:Double = 0.0
        lista.forEach {
            suma += it
        }
        return suma
    }


}