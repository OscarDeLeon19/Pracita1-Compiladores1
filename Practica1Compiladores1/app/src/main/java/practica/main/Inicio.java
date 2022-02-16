package practica.main;

import java.io.StringReader;

import analisis.lexico.AnalizadorLexico;

public class Inicio {

    public Inicio() {
    }

    public void iniciarAnalisis(){
        String texto = "{} 43 \"BAD BUNNI\" Def Barras total 02 025.25 5 546.26 #hola mundo";
        System.out.println(texto);
        StringReader str = new StringReader(texto);
        AnalizadorLexico analizador = new AnalizadorLexico(str);
        try{
            boolean bandera = true;
            while (bandera == true){
                Token tokens = analizador.yylex();
                if (tokens == null){
                    bandera =false;
                }

            }

        }catch(Exception e){

        }
    }
}
