package graficos;

import java.util.ArrayList;

import errores.TablaDeErrores;

public class TablaDeGraficas {

    private ArrayList<Grafica> lista = new ArrayList<>();
    private ArrayList<String> cadenas = new ArrayList<>();
    private ArrayList<Double> numeros = new ArrayList<>();
    private ArrayList<Integer> enteros = new ArrayList<>();
    TablaDeErrores errores = new TablaDeErrores();
    private Barra barra = new Barra();
    private Pie pie = new Pie();
    private int ejecuciones = 0;
    private ArrayList<Grafica> listaDeEjecuciones = new ArrayList<>();

    public TablaDeGraficas() {

    }

    public ArrayList<Grafica> getListaDeEjecuciones() {
        return listaDeEjecuciones;
    }

    public void setListaDeEjecuciones(ArrayList<Grafica> listaDeEjecuciones) {
        this.listaDeEjecuciones = listaDeEjecuciones;
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

    public void reiniciarLista() {
        lista.clear();
    }

    public void agregarCadenas(String cadenaNueva) {
        cadenas.add(0, cadenaNueva.substring(1, cadenaNueva.length() - 1));
    }

    public void agregarNumeros(double nuevoNumero) {
        numeros.add(0, nuevoNumero);
    }


    public void agregarEntero(double numero1, double numero2) {
        int v1 = (int) numero1;
        int v2 = (int) numero2;

        enteros.add(0, v1);
        enteros.add(1, v2);
    }


    public void agregarGrafica(int valor, int linea, int columna) {
        if (ejecuciones > 0){
            errores.agregarError("DEF", linea, columna, "Sintactico", "No se pueden agregar mas graficas despues de la instruccion ejecutar");
        } else {
            if (valor == 1) {
                System.out.println("ASS: " + 2);
                lista.add(barra);
                barra = null;
                Barra nueva = new Barra();
                barra = nueva;
            } else if (valor == 2) {
                lista.add(pie);
                pie = null;
                Pie nuevo_pie = new Pie();
                pie = nuevo_pie;
            }
        }
    }

    public void contarGraficas() {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) instanceof Barra) {
                Barra nueva = (Barra) lista.get(i);
                System.out.println("Titulo: " + nueva.getTitulo());
                System.out.println("EjesX: " + nueva.getEjeX());
                System.out.println("Ejesy: " + nueva.getEjeY());
                System.out.println("Uniones: " + nueva.getUnir());
            }
        }
    }

    public void agregarTexto(String texto, int valor, int linea, int columna) {
        if (valor == 1) {
            if (("").equals(barra.getTitulo())) {
                barra.agregarTitulo(texto);
            } else {
                errores.agregarError("Titulo", linea, columna, "Sintactico", "La instruccion esta repetida");
            }
        } else if (valor == 2) {
            if (pie.getTitulo().equals("")) {
                pie.agregarTitulo(texto);
            } else {
                errores.agregarError("Titulo", linea, columna, "Sintactico", "La instruccion esta repetida");
            }
        } else if (valor == 3) {
            if (pie.getTipo().equals("")) {
                pie.agregarTipo(texto);
            } else {
                errores.agregarError("Tipo", linea, columna, "Sintactico", "La instruccion esta repetida");
            }
        } else if (valor == 4) {
            if (pie.getExtra().equals("")) {
                pie.agregarExtra(texto);
            } else {
                errores.agregarError("Extra", linea, columna, "Sintactico", "La instruccion esta repetida");
            }
        }
    }

    public void asignarCadenas(int valor, int linea, int columna) {
        if (valor == 1) {
            if (cadenas.isEmpty()) {
                errores.agregarError("EjeX", linea, columna, "Sintactico", "La instruccion esta repetida");
            } else {
                for (int i = 0; i < cadenas.size(); i++) {
                    barra.agregarEjeX(cadenas.get(i));
                }
            }
        } else if (valor == 2) {
            if (cadenas.isEmpty()) {
                errores.agregarError("Etiquetas", linea, columna, "Sintactico", "La instruccion esta repetida");
            } else {
                for (int i = 0; i < cadenas.size(); i++) {
                    pie.agregarEtiqueta(cadenas.get(i));
                }
            }
        }
        cadenas.clear();
    }

    public void asignarNumeros(int valor, int linea, int columna) {
        if (valor == 1) {
            if (numeros.isEmpty()) {
                errores.agregarError("EjeY", linea, columna, "Sintactico", "La instruccion esta repetida");
            } else {
                for (int i = 0; i < numeros.size(); i++) {
                    barra.agregarEjeY(numeros.get(i));
                }
            }
        } else if (valor == 2) {
            if (numeros.isEmpty()) {
                errores.agregarError("EjeY", linea, columna, "Sintactico", "La instruccion esta repetida");
            } else {
                for (int i = 0; i < numeros.size(); i++) {
                    pie.agregarValor(numeros.get(i));
                }
            }
        }
        numeros.clear();
    }

    public void asignarUniones(int valor, int linea, int columna) {
        if (valor == 1) {
            if (enteros.isEmpty()) {
                errores.agregarError("Unir", linea, columna, "Sintactico", "La instruccion esta repetida");
            } else {
                for (int i = 0; i < enteros.size(); i++) {
                    barra.agregarUnion(enteros.get(i));
                }
            }

        } else if (valor == 2) {
            if (enteros.isEmpty()) {
                errores.agregarError("Unir", linea, columna, "Sintactico", "La instruccion esta repetida");
            } else {
                for (int i = 0; i < enteros.size(); i++) {
                    pie.agregarUnion(enteros.get(i));
                }
            }
        }
        enteros.clear();
    }

    public void asignarTotal(double nuevo_total, int linea, int columna) {
        if (pie.getTotal() == 0) {
            pie.agregarTotal(nuevo_total);
        } else {
            errores.agregarError("Total", linea, columna, "Sintactico", "La instruccion esta repetida");
        }

    }


    public void agregarEjecucion(String texto, int linea, int columna) {
        String titulo = texto.substring(1,texto.length()-1);
        boolean prueba = false;
        for (int i = 0; i < lista.size(); i++) {
            Grafica grafica = lista.get(i);
            if (grafica.getTitulo().equals(titulo)){
                listaDeEjecuciones.add(grafica);
                i = lista.size();
                ejecuciones++;
                prueba = true;
            }
        }
        if (!prueba){
            errores.agregarError("Ejecutar", linea, columna, "Sintactico", "La grafica para ejecutar no existe");
        }
    }

    public void reiniciarEjecuciones(){
        ejecuciones = 0;
        listaDeEjecuciones.clear();
    }

}



