package analisis.lexico;

import java.sql.SQLOutput;
import practica.main.Token;

%%
%class AnalizadorLexico
%line
%column
%public

L=[a-zA-Z_]
D=[1-9]
punto=[.]
espacio=[ ,\t,\r,\n]+
comilla = [\"]

%{
    private String lexema;
%}
%%
    Def | def {return DEF; System.out.println(DEF);}
    Barras {return BARRAS; System.out.println(BARRAS);}
    Pie {return PIE; System.out.println(PIE);}
    titulo {return TITULO; System.out.println(TITULO);}
    ejex {return EJEX; System.out.println(EJEX);}
    ejey {return EJEY; System.out.println(EJEY);}
    etiquetas {return ETIQUETAS; System.out.println(ETIQUETAS);}
    valores {return VALORES; System.out.println(VALORES);}
    unir {return UNIR; System.out.println(UNIR);}
    tipo {return TIPO; System.out.println(TIPO);}
    Cantidad {return CANTIDAD; System.out.println(CANTIDAD);}
    Porcentaje {return PORCENTAJE; System.out.println(PORCENTAJE);}
    total {return TOTAL; System.out.println(TOTAL);}
    extra {return EXTRA; System.out.println(EXTRA);}
    Ejecutar {return EJECUTAR; System.out.println(EJECUTAR);}
    {espacio} {/*ignorar*/}
    {comilla}.{L}.(L|D|0)*.{comilla} {return CADENA; lexema = yytext(); System.out.println(CADENA + ": " + lexema);}
    {D}.(D|0)* {return ENTERO; lexema = yytext(); System.out.println(ENTERO + ": " + lexema);}
    {D}.(D|0)*.{punto}.(D|0)+ {return DECIMAL; lexema = yytext(); System.out.println(DECIMAL + ": " + lexema);}
    "#".* {return COMENTARIO; lexema = yytext(); System.out.println(COMENTARIO + ": " + lexema);}
    "+" {return SUMA; System.out.println(SUMA);}
    "-" {return RESTA; System.out.println(RESTA);}
    "*" {return MULTIPLICACION; System.out.println(MULTIPLICACION);}
    "/" {return DIVISION; System.out.println(DIVISION);}
    "(" {return PARENTESIS_A; System.out.println(PARENTESIS_A);}
    ")" {return PARENTESIS_C; System.out.println(PARENTESIS_C);}
    ")" {return PARENTESIS_C; System.out.println(PARENTESIS_C);}
    ":" {return DOS_PUNTOS; System.out.println(DOS_PUNTOS);}
    ";" {return PUNTO_COMA; System.out.println(PUNTO_COMA);}
    "{" {return LLAVE_A; System.out.println(LLAVE_A);}
    "}" {return LLAVE_C; System.out.println(LLAVE_C);}
    "[" {return CORCHETE_A; System.out.println(CORCHETE_A);}
    "]" {return CORCHETE_C; System.out.println(CORCHETE_C);}
