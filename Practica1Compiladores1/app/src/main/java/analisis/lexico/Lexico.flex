package analisis.lexico;

import java.sql.SQLOutput;
import static practica.main.Token.*;

%%
%class AnalizadorLexico
%type Token
%line
%column
%public


L=[a-zA-Z_]
D=[0-9]
punto=[.]
espacio=[ ,\t,\r,\n]+
comilla = [\"]
decimal = ({D}+{punto}{D}+)
entero = {D}+

%{
    private String lexema;
%}
%%
    Def | def {System.out.println(DEF); return DEF;}
    Barras {System.out.println(BARRAS); return BARRAS;}
    Pie {System.out.println(PIE); return PIE;}
    titulo {System.out.println(TITULO); return TITULO; }
    ejex {System.out.println(EJEX); return EJEX;}
    ejey {System.out.println(EJEY); return EJEY;}
    etiquetas {System.out.println(ETIQUETAS); return ETIQUETAS;}
    valores {System.out.println(VALORES); return VALORES;}
    unir {System.out.println(UNIR); return UNIR;}
    tipo {System.out.println(TIPO); return TIPO;}
    Cantidad {System.out.println(CANTIDAD); return CANTIDAD;}
    Porcentaje {System.out.println(PORCENTAJE); return PORCENTAJE;}
    total {System.out.println(TOTAL); return TOTAL;}
    extra {System.out.println(EXTRA); return EXTRA;}
    Ejecutar {System.out.println(EJECUTAR); return EJECUTAR;}
    {espacio} {/*ignorar*/}
    {comilla}.{L}.(L|D+)*.{comilla} {lexema = yytext(); System.out.println(CADENA + ": " + lexema); return CADENA;}
    (0)+.{decimal}  {lexema = yytext(); System.out.println(ERROR + ": " + lexema); return ERROR;}
    (0)+.{entero} {lexema = yytext(); System.out.println(ERROR + ": " + lexema); return ERROR;}
    {decimal}  {lexema = yytext(); System.out.println(DECIMAL + ": " + lexema); return DECIMAL;}
    {entero} {lexema = yytext(); System.out.println(ENTERO + ": " + lexema); return ENTERO;}
    "#".* {lexema = yytext(); System.out.println(COMENTARIO + ": " + lexema); return COMENTARIO;}
    "+" {System.out.println(SUMA); return SUMA;}
    "-" {System.out.println(RESTA); return RESTA;}
    "*" {System.out.println(MULTIPLICACION); return MULTIPLICACION;}
    "/" {System.out.println(DIVISION); return DIVISION;}
    "(" {System.out.println(PARENTESIS_A); return PARENTESIS_A;}
    ")" {System.out.println(PARENTESIS_C); return PARENTESIS_C;}
    ")" {System.out.println(PARENTESIS_C); return PARENTESIS_C; }
    ":" {System.out.println(DOS_PUNTOS); return DOS_PUNTOS; }
    ";" {System.out.println(PUNTO_COMA); return PUNTO_COMA;}
    "{" {System.out.println(LLAVE_A); return LLAVE_A;}
    "}" {System.out.println(LLAVE_C); return LLAVE_C;}
    "[" {System.out.println(CORCHETE_A); return CORCHETE_A; }
    "]" {System.out.println(CORCHETE_C); return CORCHETE_C; }
    [^] {System.out.println("Dato Irreconocible"); return ERROR;}
