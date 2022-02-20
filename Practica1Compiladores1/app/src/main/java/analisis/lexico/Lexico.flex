package analisis.lexico;

import java.sql.SQLOutput;import java.util.ArrayList;
import static practica.main.Token.*;
import errores.TablaDeErrores;import practica.main.Token;
import java_cup.runtime.*;
import analisis.sintactico.sym;
import static analisis.sintactico.sym.*;

%%
%class AnalizadorLexico
%public
%line
%column
%cup
%cupdebug


L=[a-zA-Z]
D=[0-9]
punto=[.]
espacio=[ ]+
tab = [\t]+
salto = [\n]+
rot = [\r]+
comilla = [\"]
decimal = ({D}+{punto}{D}+)
entero = {D}+
cadena = {L}({L}|{D})*

%{
    private TablaDeErrores tabla = new TablaDeErrores();

    public void setTabla(TablaDeErrores tabla){
        this.tabla = tabla;
    }

    private String lexema;
%}
%%
    Def | def {return new Symbol(sym.DEF, yyline+1, yycolumn+1, yytext());}
    Barras {return new Symbol(sym.BARRAS, yyline+1, yycolumn+1, yytext());}
    Pie {return new Symbol(sym.PIE, yyline+1, yycolumn+1, yytext());}
    titulo {return new Symbol(sym.TITULO, yyline+1, yycolumn+1, yytext());}
    ejex {return new Symbol(sym.EJEX, yyline+1, yycolumn+1, yytext());}
    ejey {return new Symbol(sym.EJEY, yyline+1, yycolumn+1, yytext());}
    etiquetas {return new Symbol(sym.ETIQUETAS, yyline+1, yycolumn+1, yytext());}
    valores {return new Symbol(sym.VALORES, yyline+1, yycolumn+1, yytext());}
    unir {return new Symbol(sym.UNIR, yyline+1, yycolumn+1, yytext());}
    tipo {return new Symbol(sym.TIPO, yyline+1, yycolumn+1, yytext());}
    Cantidad {return new Symbol(sym.CANTIDAD, yyline+1, yycolumn+1, yytext());}
    Porcentaje {return new Symbol(sym.PORCENTAJE, yyline+1, yycolumn+1, yytext());}
    total {return new Symbol(sym.TOTAL, yyline+1, yycolumn+1, yytext());}
    extra {return new Symbol(sym.EXTRA, yyline+1, yycolumn+1, yytext());}
    Ejecutar {return new Symbol(sym.EJECUTAR, yyline+1, yycolumn+1, yytext());}
    {espacio} {/*ignorar*/}
    {tab} {/*ignorar*/}
    {salto} {/*ignorar*/}
    {rot} {/*ignorar*/}
    {comilla}({cadena}|{espacio}|{entero})*.{comilla} {return new Symbol(sym.CADENA, yyline+1, yycolumn+1, yytext());}
    {decimal}  {return new Symbol(sym.DECIMAL, yyline+1, yycolumn+1, new Double(yytext()));}
    {entero} {return new Symbol(sym.ENTERO, yyline+1, yycolumn+1, new Double(yytext()));}
    0.(0)+.{decimal}  {System.out.println("Error: " + yytext()); tabla.agregarError(yytext(), yyline, yycolumn, "Lexico", "Los numeros enteros no pueden iniciar en cero"); return new Symbol(sym.ERROR, yyline+1, yycolumn+1, yytext());}
    0.(0)+.{entero} {System.out.println("Error: " + yytext()); tabla.agregarError(yytext(), yyline, yycolumn, "Lexico", "Los numeros enteros no pueden iniciar en cero"); return new Symbol(sym.ERROR, yyline+1, yycolumn+1, yytext());}
    "#".* {}
    "+" {return new Symbol(sym.SUMA, yyline+1, yycolumn+1, yytext());}
    "-" {return new Symbol(sym.RESTA, yyline+1, yycolumn+1, yytext());}
    "*" {return new Symbol(sym.MULTIPLICACION, yyline+1, yycolumn+1, yytext());}
    "/" {return new Symbol(sym.DIVISION, yyline+1, yycolumn+1, yytext());}
    "(" { return new Symbol(sym.PARENTESIS_A, yyline+1, yycolumn+1, yytext());}
    ")" {return new Symbol(sym.PARENTESIS_C, yyline+1, yycolumn+1, yytext());}
    ":" {return new Symbol(sym.DOS_PUNTOS, yyline+1, yycolumn+1, yytext());}
    ";" {return new Symbol(sym.PUNTO_COMA, yyline+1, yycolumn+1, yytext());}
    "{" {return new Symbol(sym.LLAVE_A, yyline+1, yycolumn+1, yytext());}
    "}" {return new Symbol(sym.LLAVE_C, yyline+1, yycolumn+1, yytext());}
    "[" {return new Symbol(sym.CORCHETE_A, yyline+1, yycolumn+1, yytext());}
    "]" {return new Symbol(sym.CORCHETE_C, yyline+1, yycolumn+1, yytext());}
    "=" {return new Symbol(sym.SIGNO_IGUAL, yyline+1, yycolumn+1, yytext());}
    "," {return new Symbol(sym.COMA, yyline+1, yycolumn+1, yytext());}
    [^] {tabla.agregarError(yytext(), yyline+1, yycolumn+1, "Lexico", "Dato Irreconocible"); return new Symbol(sym.ERROR, yyline+1, yycolumn+1, yytext());}
