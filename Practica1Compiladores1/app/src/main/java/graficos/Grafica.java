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

    public void agregarUnion(int union){
        unir.add(union);
    }

    public  void agregarTitulo(String nuevotitulo){
        titulo = nuevotitulo.substring(1, nuevotitulo.length()-1);
    }


/*
    public void ver(){
        for (int i = 0; i<lista.size(); i++){
            Grafica graf = lista.get(i);
            if (graf instanceof Barra){
                Barra bar = (Barra) graf;
                System.out.println("Titulo: " + bar.getTitulo());
            }
        }
    }

 */
}
