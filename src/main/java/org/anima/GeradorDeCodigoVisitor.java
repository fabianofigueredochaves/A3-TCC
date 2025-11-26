package org.anima;

import org.anima.antlr.CompiladorLangParser;
import org.anima.antlr.CompiladorLangParserBaseVisitor;
import org.anima.semantica.TabelaSimbolos;


public class GeradorDeCodigoVisitor extends CompiladorLangParserBaseVisitor<String> {

    private final StringBuilder codigoPrincipal = new StringBuilder();
    private TabelaSimbolos tabelaSimbolos;
    public GeradorDeCodigoVisitor(TabelaSimbolos tabelaSimbolos) {
        this.tabelaSimbolos = tabelaSimbolos;
    }

    @Override
    public String visitPrograma(CompiladorLangParser.ProgramaContext ctx) {

        super.visitPrograma(ctx);

        StringBuilder codigoFinal = new StringBuilder();
        codigoFinal.append("import java.util.Scanner;\n\n"); // Exemplo de import
        codigoFinal.append("public class ProgramaCompilado {\n");
        codigoFinal.append("    public static void main(String[] args) {\n");
        codigoFinal.append("        Scanner scanner = new Scanner(System.in);\n");

        codigoFinal.append(codigoPrincipal.toString());

        codigoFinal.append("    }\n");
        codigoFinal.append("}\n");

        return codigoFinal.toString();
    }

    @Override
    public String visitDeclaracao(CompiladorLangParser.DeclaracaoContext ctx) {
        String tipo = ctx.tipo().getText(); // "inteiro", "texto", etc.
        String id = ctx.IDENTIFICADOR().getText();//.id();//.getText();
        String tipoJava = "";

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
        }

        if (ctx.init != null) {
            String valorInicial = visit(ctx.init);
            codigoPrincipal.append(String.format("        %s %s = %s;\n", tipoJava, id, valorInicial));
        } else {
            codigoPrincipal.append(String.format("        %s %s;\n", tipoJava, id));
        }
        return null;
    }

    @Override
    public String visitComandoEscrita(CompiladorLangParser.ComandoEscritaContext ctx) {

        String expressaoJava = visit(ctx.expressao());
        codigoPrincipal.append(String.format("        System.out.println(%s);\n", expressaoJava));
        return null;
    }

    @Override
    public String visitComandoLeitura(CompiladorLangParser.ComandoLeituraContext ctx) {
        String nomeVariavel = ctx.IDENTIFICADOR().getText();

        String tipoDaVariavel = tabelaSimbolos.getTipo(nomeVariavel).toString();//.getTipo(nomeVariavel);

        String metodoScanner = "";

        switch (tipoDaVariavel) {
            case "inteiro":
                metodoScanner = "nextInt()";
                break;
            case "real":
                metodoScanner = "nextDouble()";
                break;
            case "texto":
                metodoScanner = "nextLine()";
                break;
            default:
                metodoScanner = "next()";
                break;
        }
        codigoPrincipal.append(String.format("        %s = scanner.%s;\n", nomeVariavel, metodoScanner));
        return null;
    }

    // Para um número: '123' -> "123"
    @Override
    public String visitExpressao(CompiladorLangParser.ExpressaoContext ctx) {
        return ctx.getText();
    }

    // Para um ID: 'x' -> "x"
    @Override
    public String visitAtribuicao(CompiladorLangParser.AtribuicaoContext ctx) {//(CompiladorLangParser.DeclaracaoContext ctx) {

        String nomeVariavel = ctx.destino.getText();
        String expressaoJava = visit(ctx.valor);
        codigoPrincipal.append(String.format("        %s = %s;\n", nomeVariavel, expressaoJava));

        return null;
    }

    // Para uma soma: 'a + b' -> "a + b"
/*
    @Override
    public String visitExpressaoAditiva(CompiladorLangParser.ExpressaoAditivaContext ctx) {//.ExprSomaContext ctx) {

        // Se não houver operador, apenas visita a expressão filha
        if (ctx.OP_SOMA() == null && ctx.OP_SUBTRACAO() == null) {
            return visit(ctx.expressaoMultiplicativa(0));
        }

        // Há um operador!
        // Visita a expressão da esquerda (que será '36')
        String esq = visit(ctx.expressaoMultiplicativa(0)); // Retornará "36"

        // Visita a expressão da direita (que será '85')
        String dir = visit(ctx.expressaoMultiplicativa(1)); // Retornará "85"

        // Pega o operador
        String op = ctx.OP_SOMA() != null ? "+" : "-";

        // Monta e retorna a string "36 + 85"
        return String.format("%s %s %s", esq, op, dir);

        String esq = visit(ctx.OP_SOMA(0));//.expressao(0)); // Visita a expressão da esquerda
        String dir = visit(ctx.OP_SOMA(1)); // Visita a expressão da direita
        return String.format("%s + %s", esq, dir);
    }
*/

/*
    @Override
    public String visitBloco(CompiladorLangParser.BlocoContext ctx) {
        StringBuilder blocoDeCodigo = new StringBuilder();

        // Para cada comando dentro do bloco...
        for (CompiladorLangParser.ComandoContext cmdCtx : ctx.comando()) {
            // ...visita o comando. O método visit do comando específico
            // (ex: visitCmdAtribuicao) retornará a string de código pronta.
            String comandoGerado = visit(cmdCtx);

            // Adiciona o comando gerado ao nosso bloco, com a indentação correta.
            blocoDeCodigo.append("    " + comandoGerado);
        }

        return blocoDeCodigo.toString();
    }
*/

    @Override
    public String visitEstruturaCondicional(CompiladorLangParser.EstruturaCondicionalContext ctx) {//CmdSeContext ctx) {
        String condicao = visit(ctx.cond);
        codigoPrincipal.append(String.format("        if (%s) {\n", condicao));
        visit(ctx.entao);
        codigoPrincipal.append("        }\n");

        if (ctx.senao != null) {

            codigoPrincipal.append("        else {\n");

            visit(ctx.senao);

            codigoPrincipal.append("        }\n");
        }
        return null;
    }

    @Override
    public String visitLoopEnquanto(CompiladorLangParser.LoopEnquantoContext ctx) {
        String condicao = visit(ctx.cond);
        codigoPrincipal.append(String.format("        while (%s) {\n", condicao));
        visit(ctx.faca);
        codigoPrincipal.append("        }\n");
        return null;
    }

}