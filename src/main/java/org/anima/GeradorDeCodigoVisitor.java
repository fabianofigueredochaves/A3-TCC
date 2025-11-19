package org.anima;

import org.anima.antlr.CompiladorLangParser;// GeradorDeCodigoVisitor.java
import org.anima.antlr.CompiladorLangParserBaseVisitor;
import org.anima.semantica.TabelaSimbolos;


public class GeradorDeCodigoVisitor extends CompiladorLangParserBaseVisitor<String> {

    // Usaremos para construir o código final dentro do método main.
    private StringBuilder codigoPrincipal = new StringBuilder();
    private TabelaSimbolos tabelaSimbolos; // Você precisará dela para saber os tipos!

    public GeradorDeCodigoVisitor() {
        this.tabelaSimbolos = new TabelaSimbolos();
    }

    // ... aqui vamos implementar os métodos visit ...
//}

// Dentro de GeradorDeCodigoVisitor.java

    @Override
    public String visitPrograma(CompiladorLangParser.ProgramaContext ctx) {
        // Visita todos os filhos (declaracoes, comandos, etc.)
        // O código gerado por eles será acumulado no nosso StringBuilder
        super.visitPrograma(ctx);

        // Agora, monta o arquivo Java final
        StringBuilder codigoFinal = new StringBuilder();
        codigoFinal.append("import java.util.Scanner;\n\n"); // Exemplo de import
        codigoFinal.append("public class ProgramaCompilado {\n");
        codigoFinal.append("    public static void main(String[] args) {\n");
        codigoFinal.append("        Scanner scanner = new Scanner(System.in);\n"); // Para comandos de leitura

        // Adiciona o código gerado dos filhos
        codigoFinal.append(codigoPrincipal.toString());

        codigoFinal.append("    }\n");
        codigoFinal.append("}\n");

        return codigoFinal.toString();
    }

// Dentro de GeradorDeCodigoVisitor.java

    @Override
    public String visitDeclaracao(CompiladorLangParser.DeclaracaoContext ctx) {
        String tipo = ctx.tipo().getText(); // "inteiro", "texto", etc.
        String id = ctx.IDENTIFICADOR().getText();
        String tipoJava = "";

        // Mapeia os tipos da sua linguagem para os tipos do Java
        switch (tipo) {
            case "inteiro":
                tipoJava = "int";
                break;
            case "real":
                tipoJava = "double";
                break;
            case "texto":
                tipoJava = "String";
                break;
            // Adicione outros tipos...
        }

        // Adiciona a declaração ao código do método main
        codigoPrincipal.append(String.format("        %s %s;\n", tipoJava, id));

        // Este método não precisa retornar nada para o nó pai, pois ele já escreve no StringBuilder
        return null;
    }

// Dentro de GeradorDeCodigoVisitor.java

    @Override
    public String visitComandoEscrita(CompiladorLangParser.ComandoEscritaContext ctx) {
        // Visita a expressão DENTRO do 'escreva' para obter seu valor/código
        String expressaoJava = visit(ctx.expressao());

        // Gera o código Java para imprimir no console
        codigoPrincipal.append(String.format("        System.out.println(%s);\n", expressaoJava));

        return null;
    }

// Dentro de GeradorDeCodigoVisitor.java

    // Para um número: '123' -> "123"
    @Override
    public String visitExpressao(CompiladorLangParser.ExpressaoContext ctx) {
        return ctx.getText();//tipo().KW_INTEIRO().getText();//getText();
    }

    // Para um ID: 'x' -> "x"
    @Override
    public String visitAtribuicao(CompiladorLangParser.AtribuicaoContext ctx) {//(CompiladorLangParser.DeclaracaoContext ctx) {
        return ctx.getText();//IDENTIFICADOR().getText();
    }

    // Para uma soma: 'a + b' -> "a + b"
   /*
    @Override
    public String visitExprSoma(CompiladorLangParser.ExprSomaContext ctx) {
        String esq = visit(ctx.expressao(0)); // Visita a expressão da esquerda
        String dir = visit(ctx.expressao(1)); // Visita a expressão da direita
        return String.format("%s + %s", esq, dir);
    }

    */
}