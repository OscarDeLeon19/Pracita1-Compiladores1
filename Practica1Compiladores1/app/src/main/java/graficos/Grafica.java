package graficos;

import java.util.ArrayList;

public class Grafica {

    private String titulo = "";
    private ArrayList<Integer> unir = new ArrayList<>();

    public Grafica(String titulo, ArrayList<Integer> unir) {
        this.titulo = titulo;
        this.unir = unir;
    }

    public Grafica() {
    }

    public String getTitulo() {
        return titulo;
    }

    public ArrayList<Integer> getUnir() {
        return unir;
    }

    public void setUnir(ArrayList<Integer> unir) {
        this.unir = unir;
    }

    public void agregarUnion(int union1, int union2){
        unir.add(union1);
        unir.add(union2);
    }

    public  void agregarTitulo(String nuevotitulo){
        titulo = nuevotitulo.substring(1, nuevotitulo.length()-1);
    }
}
