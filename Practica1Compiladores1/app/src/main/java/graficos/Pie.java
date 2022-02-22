package graficos;

import java.io.Serializable;
import java.util.ArrayList;

public class Pie extends Grafica implements Serializable {

    private ArrayList<String> etiquetas = new ArrayList<>();
    private ArrayList<Double> valores = new ArrayList<>();
    private String tipo = "";
    private double total = 0;
    private String extra = "";

    public Pie(String titulo, ArrayList<Integer> unir, ArrayList<String> etiquetas, ArrayList<Double> valores, String tipo, double total, String extra) {
        super(titulo, unir);
        this.etiquetas = etiquetas;
        this.valores = valores;
        this.tipo = tipo;
        this.total = total;
        this.extra = extra;
    }

    public Pie() {
    }

    public ArrayList<String> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(ArrayList<String> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public ArrayList<Double> getValores() {
        return valores;
    }

    public void setValores(ArrayList<Double> valores) {
        this.valores = valores;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public void agregarEtiqueta(String etiqueta){
        etiquetas.add(etiqueta);
    }

    public void agregarValor(double valor){
        valores.add(valor);
    }

    public void agregarTotal(double nuevoTotal){
        total = nuevoTotal;
    }

    public void agregarTipo(String nuevo_tipo){
        tipo = nuevo_tipo;
    }

    public void agregarExtra(String nuevo_extra){
        extra = nuevo_extra;
    }
}
