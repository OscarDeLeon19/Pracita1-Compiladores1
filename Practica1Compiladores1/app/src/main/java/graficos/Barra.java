package graficos;

import java.io.Serializable;
import java.util.ArrayList;

public class Barra extends Grafica implements Serializable {

    private ArrayList<String> ejeX = new ArrayList<>();
    private ArrayList<Double> ejeY = new ArrayList<>();

    public Barra(String titulo, ArrayList<Integer> unir, ArrayList<String> ejeX, ArrayList<Double> ejeY) {
        super(titulo, unir);
        this.ejeX = ejeX;
        this.ejeY = ejeY;
    }

    public Barra(){
    }

    public ArrayList<String> getEjeX() {
        return ejeX;
    }

    public void setEjeX(ArrayList<String> ejeX) {
        this.ejeX = ejeX;
    }

    public ArrayList<Double> getEjeY() {
        return ejeY;
    }

    public void setEjeY(ArrayList<Double> ejeY) {
        this.ejeY = ejeY;
    }

    public void agregarEjeX(String eje){
        ejeX.add(eje);
    }

    public void agregarEjeY(double eje){
        ejeY.add(eje);
    }
}
