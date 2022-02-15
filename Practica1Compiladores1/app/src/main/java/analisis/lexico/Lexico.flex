package analisis.lexico;

%%
%class AnalizadorLexico
%line
%column
%public

L=[a-zA-Z_]
D=[0-9]
punto=[.]
espacio=[ ,\t,\r,\n]+

%{
    private String lexema;
%}
%%

L {}