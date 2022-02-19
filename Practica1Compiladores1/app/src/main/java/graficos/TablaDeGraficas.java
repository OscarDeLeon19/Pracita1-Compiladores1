package graficos;

import java.util.ArrayList;

import errores.TablaDeErrores;

public class TablaDeGraficas {

    private ArrayList<Grafica> lista = new ArrayList<>();
    private ArrayList<String> cadenas = new ArrayList<>();
    TablaDeErrores errores = new TablaDeErrores();
    private Barra barra = new Barra();
    private Pie pie = new Pie();

    public TablaDeGraficas(){

    }

    public void setErrores(TablaDeErrores errores) {
        this.errores = errores;
    }

    public ArrayList<Grafica> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Grafica> lista) {
        this.lista = lista;
    }

    public void reiniciarLista(){
        lista.clear();
    }

    public void agregarCadenas(String cadenaNueva){
        cadenas.add(cadenaNueva.substring(1,cadenaNueva.length()-1));
    }

    public void agregarTitulo(String titulo,int valor, int linea, int columna){
        if (valor == 1){
            if (barra.getTitulo() == ""){
                barra.agregarTitulo(titulo);
            } else {
                errores.agregarError("Titulo", linea, columna, "Sintactico", "La instruccion esta repetida");
            }
        } else if (valor == 2){
            if (pie.getTitulo() == ""){
                pie.agregarTitulo(titulo);
            } else {
                errores.agregarError("Titulo", linea, columna, "Sintactico", "La instruccion esta repetida");
            }
        }
    }

    public void asignarCadena(int valor, int linea, int columna){
        if (valor == 1){
            if (barra.getEjeX().isEmpty()) {
                barra.setEjeX(cadenas);
            } else {
                errores.agregarError("EjeX", linea, columna, "Sintactico", "La instruccion esta repetida");
            }
        } else if (valor == 2){
            if (pie.getEtiquetas().isEmpty()) {
                pie.setEtiquetas(cadenas);
            } else {
                errores.agregarError("Etiquetas", linea, columna, "Sintactico", "La instruccion esta repetida");
            }
        }
        cadenas.clear();
    }



}
