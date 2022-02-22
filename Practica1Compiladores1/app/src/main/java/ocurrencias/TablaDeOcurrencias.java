package ocurrencias;

import java.io.Serializable;
import java.util.ArrayList;

public class TablaDeOcurrencias implements Serializable {

    private ArrayList<Ocurrencia> lista = new ArrayList<>();

    public TablaDeOcurrencias(ArrayList<Ocurrencia> lista) {
        this.lista = lista;
    }

    public TablaDeOcurrencias() {
    }

    public ArrayList<Ocurrencia> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Ocurrencia> lista) {
        this.lista = lista;
    }

    public void agregarOcurrencia(String operador, int linea, int columna, String ejemplo){
        Ocurrencia nueva_ocurrencia = new Ocurrencia(operador, linea, columna, ejemplo);
        lista.add(nueva_ocurrencia);

    }
}
