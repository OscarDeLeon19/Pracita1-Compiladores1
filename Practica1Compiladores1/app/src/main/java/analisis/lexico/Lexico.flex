package analisis.lexico;

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

L {}