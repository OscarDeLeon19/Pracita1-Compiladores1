package graficos;

import java.io.Serializable;
import java.util.ArrayList;

import errores.TablaDeErrores;

public class TablaDeGraficas implements Serializable {

    private ArrayList<Grafica> listaGraficasDefinidas = new ArrayList<>();
    private ArrayList<String> cadenas = new ArrayList<>();
    private ArrayList<Double> numeros = new ArrayList<>();
    private ArrayList<Integer> enteros = new ArrayList<>();
    private TablaDeErrores errores = new TablaDeErrores();
    private Barra barra = new Barra();
    private Pie pie = new Pie();
    private int ejecuciones = 0;
    private ArrayList<Grafica> listaDeEjecuciones = new ArrayList<>();

    /**
     * Contructor de la clase grafica
     */
    public TablaDeGraficas() {

    }

    /**
     * Devuelve la lista de graficas que seran ejecutadas y mostradas en pantalla
     * @return La lista de ejecuciones
     */
    public ArrayList<Grafica> getListaDeEjecuciones() {
        return listaDeEjecuciones;
    }

    /**
     * Ingresa la tabla de errores para manejarlos
     * @param errores La tabla de errores
     */
    public void setErrores(TablaDeErrores errores) {
        this.errores = errores;
    }

    /**
     * Devuelve la lista de graficos definidos por la aplicacion
     * @return La lista de graficos
     */
    public ArrayList<Grafica> getListaGraficasDefinidas() {
        return listaGraficasDefinidas;
    }

    /**
     * Ingresa la lista de graficas
     * @param listaGraficasDefinidas La lista de graficas
     */
    public void setListaGraficasDefinidas(ArrayList<Grafica> listaGraficasDefinidas) {
        this.listaGraficasDefinidas = listaGraficasDefinidas;
    }

    /**
     * Borra todos los datos de la lista de graficas definidas
     */
    public void reiniciarLista() {
        listaGraficasDefinidas.clear();
    }

    /**
     * Agrega una cadena nueva a la lista de cadenas
     * @param cadenaNueva La cadena nueva
     */
    public void agregarCadenas(String cadenaNueva) {
        cadenas.add(0, cadenaNueva.substring(1, cadenaNueva.length() - 1));
    }

    /**
     * Agrega un numero nuevo a la lista de numeros
     * @param nuevoNumero El numero nuevo
     */
    public void agregarNumeros(double nuevoNumero) {
        numeros.add(0, nuevoNumero);
    }

    /**
     * Agrega un entero a la lista de enteros y los convierte a Int
     * @param numero1 El primer entero de la union
     * @param numero2 El segundo entero de la union
     */
    public void agregarEntero(double numero1, double numero2) {
        int valor1 = (int) numero1;
        int valor2 = (int) numero2;

        enteros.add(0, valor1);
        enteros.add(1, valor2);
    }

    /**
     * Agrega una grafica a la lista de graficas definidas despues de su analisis sintactico.
     * Ademas comprueva de que no falte ningun atributo de la grafica
     * @param valor Un valor para definir si se agrega una grafica barra o pie
     * @param linea La linea en donde se realza la ejecucion
     * @param columna La columna en donde se realiza la ejecicion
     */
    public void agregarGrafica(int valor, int linea, int columna) {
        if (ejecuciones > 0){
            errores.agregarError("DEF", linea, columna, "Sintactico", "No se pueden agregar mas graficas despues de la instruccion ejecutar");
        } else {
            if (valor == 1) {
                if (barra.getTitulo().equals("")){
                    errores.agregarError("DEF", linea, columna, "Sintactico", "Falta atributo de titulo");
                }
                if (barra.getUnir().size() == 0){
                    errores.agregarError("DEF", linea, columna, "Sintactico", "Falta atributo de unir");
                }
                if (barra.getEjeX().size() == 0){
                    errores.agregarError("DEF", linea, columna, "Sintactico", "Falta atributo de EjeX");
                }
                if (barra.getEjeY().size() == 0){
                    errores.agregarError("DEF", linea, columna, "Sintactico", "Falta atributo de EjeY");
                }
                listaGraficasDefinidas.add(barra);
                barra = null;
                Barra nueva = new Barra();
                barra = nueva;
            } else if (valor == 2) {
                if (pie.getTipo().equals("")){
                    errores.agregarError("DEF", linea, columna, "Sintactico", "El tipo de grafica no esta definida");
                } else {
                        if (pie.getTitulo().equals("")){
                            errores.agregarError("DEF", linea, columna, "Sintactico", "Falta atributo de titulo");
                        }
                        if (pie.getUnir().size() == 0){
                            errores.agregarError("DEF", linea, columna, "Sintactico", "Falta atributo de unir");
                        }
                        if (pie.getEtiquetas().size() == 0){
                            errores.agregarError("DEF", linea, columna, "Sintactico", "Falta atributo de Etiquetas");
                        }
                        if (pie.getValores().size() == 0){
                            errores.agregarError("DEF", linea, columna, "Sintactico", "Falta atributo de Valores");
                        }
                    if (pie.getExtra().equals("")){
                        errores.agregarError("DEF", linea, columna, "Sintactico", "Falta atributo de extra");
                    }
                    if (pie.getTipo().equals("Porcentaje")){
                        if (pie.getTotal() != 0){
                            errores.agregarError("DEF", linea, columna, "Sintactico", "El atributo total no debe estar definido");
                        }
                    } else if (pie.getTipo().equals("Cantidad")){
                        if (pie.getTotal() == 0){
                            errores.agregarError("DEF", linea, columna, "Sintactico", "Falta el atributo Total");
                        }
                    }
                }
                listaGraficasDefinidas.add(pie);
                pie = null;
                Pie nuevo_pie = new Pie();
                pie = nuevo_pie;
            }
        }
    }

    /**
     * Metodo para agregar un valor de texto a diferentes atributos dependiendo del atributo valor
     * @param texto El texto que se va a agregar
     * @param valor El valor que diferenciara el atributo que se agregara
     * @param linea La linea en donde se realiza la accion
     * @param columna La columna en donde se realiza la accion
     */
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

    /**
     * Metodo para asignar las cadenas obtenidas en una lista de ejex o de etiquetas dependiendo de el atributo valor
     * @param valor El valor que diferencia a que lista se agregaran las cadenas
     * @param linea La linea en donde se realiza la accion
     * @param columna La columna en donde se realiza la accion.
     */
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

    /**
     * Metodo que asigna los numeros obtenidos a una lista de una grafica, diferenciado por el valor enviado
     * @param valor El valor que diferencia a que lista se agregaran los numeros
     * @param linea La linea en donde ocurre la accion
     * @param columna La columna donde ocurre la accion
     */
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

    /**
     * Metodo para agregar los enteros obtenidos en valores de union de una grafica
     * @param valor Diferencia a que tipo de grafica se agregaran las uniones
     * @param linea La linea en donde ocurre la accion
     * @param columna La columna en donde ocurre la accion
     */
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

    /**
     * Asigna un valor total al atributo de la grafica Pie
     * @param nuevo_total El total que se asignara
     * @param linea La linea en donde ocurre la accion
     * @param columna La columna en donde ocurre la accion
     */
    public void asignarTotal(double nuevo_total, int linea, int columna) {
        if (pie.getTotal() == 0) {
            pie.agregarTotal(nuevo_total);
        } else {
            errores.agregarError("Total", linea, columna, "Sintactico", "La instruccion esta repetida");
        }

    }

    /**
     * Agrega una grafica a la lista de ejeciciones comprobando si la grafica se encuentra en la lista
     * @param texto El titulo de la grafica que se comprobara
     * @param linea La linea en donde ocurre esta accion
     * @param columna La columna en donde ocurre esta accion
     */
    public void agregarEjecucion(String texto, int linea, int columna) {
        String titulo = texto.substring(1,texto.length()-1);
        boolean prueba = false;
        for (int i = 0; i < listaGraficasDefinidas.size(); i++) {
            Grafica grafica = listaGraficasDefinidas.get(i);
            if (grafica.getTitulo().equals(titulo)){
                listaDeEjecuciones.add(grafica);
                i = listaGraficasDefinidas.size();
                ejecuciones++;
                prueba = true;
            }
        }
        if (!prueba){
            errores.agregarError("Ejecutar", linea, columna, "Sintactico", "La grafica para ejecutar no existe");
        }
    }

    /**
     * Limpia la lista de graficas listas para la ejecucion y reinicia el conteo
     */
    public void reiniciarEjecuciones(){
        ejecuciones = 0;
        listaDeEjecuciones.clear();
    }

}



