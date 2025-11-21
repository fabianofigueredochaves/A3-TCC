package org.anima;

import org.anima.antlr.CompiladorLangParser;// GeradorDeCodigoVisitor.java
import org.anima.antlr.CompiladorLangParserBaseVisitor;
import org.anima.semantica.TabelaSimbolos;


public class GeradorDeCodigoVisitor extends CompiladorLangParserBaseVisitor<String> {

    // Usaremos para construir o código final dentro do método main.
    private final StringBuilder codigoPrincipal = new StringBuilder();
    private TabelaSimbolos tabelaSimbolos; // Você precisará dela para saber os tipos!

    public GeradorDeCodigoVisitor(TabelaSimbolos tabelaSimbolos) {
        this.tabelaSimbolos = tabelaSimbolos;
        // TabelaSimbolos tabelaSimbolos1 = this.tabelaSimbolos;// = new TabelaSimbolos();
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
        String id = ctx.IDENTIFICADOR().getText();//.id();//.getText();
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

        if (ctx.init != null) {
            // A inicialização existe! Vamos visitar a expressão ('init') para obter seu valor.
            // Ex: para '= 10', o visit(ctx.init) retornará a string "10".
            String valorInicial = visit(ctx.init);

            // Retorna a string de declaração COM o valor inicial.
            //return String.format("%s %s = %s;\n", tipoJava, id, valorInicial);
            codigoPrincipal.append(String.format("        %s %s = %s;\n", tipoJava, id, valorInicial));
        } else {
            // A inicialização não existe. Retorna a declaração simples.
            codigoPrincipal.append(String.format("        %s %s;\n", tipoJava, id));
        }

        // Adiciona a declaração ao código do método main
       // codigoPrincipal.append(String.format("        %s %s;\n", tipoJava, id));

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

    /**
     * Visita um comando de leitura, como "leia(variavel);".
     * Gera o código Java correspondente usando o Scanner, com base no tipo da variável.
     * Retorna uma String com o código Java gerado.
     */
    @Override
    public String visitComandoLeitura(CompiladorLangParser.ComandoLeituraContext ctx) {
        // Passo 1: Obter o nome da variável que receberá a entrada.
        String nomeVariavel = ctx.IDENTIFICADOR().getText();

        // Passo 2: Consultar a Tabela de Símbolos para descobrir o tipo da variável.
        // Assumindo que sua TabelaDeSimbolos tem um método como 'getTipo(nome)'.
        String tipoDaVariavel = tabelaSimbolos.getTipo(nomeVariavel).toString();//.getTipo(nomeVariavel);

        String metodoScanner = "";

        // Passo 3: Decidir qual método do Scanner usar com base no tipo.
        switch (tipoDaVariavel) {
            case "inteiro":
                metodoScanner = "nextInt()";
                break;
            case "real":
                metodoScanner = "nextDouble()";
                break;
            case "texto":
                // Usar nextLine() para capturar strings com espaços.
                metodoScanner = "nextLine()";
                break;
            default:
                // Isso não deveria acontecer se a análise semântica estiver correta,
                // mas é uma boa prática ter um fallback.
                metodoScanner = "next()";
                break;
        }
        codigoPrincipal.append(String.format("        %s = scanner.%s;\n", nomeVariavel, metodoScanner));

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

        String nomeVariavel = ctx.destino.getText();

        // Passo 2: Visitar a expressão do lado direito para gerar seu código.
        // ESTA É A PARTE MAIS IMPORTANTE!
        // Não nos preocupamos se é '36', 'x' ou '36 + 85'. Apenas delegamos.
        // A chamada recursiva a 'visit' vai acionar o método correto
        // (visitExpressaoAditiva, visitNumero, etc.) e nos retornar a string pronta.
        String expressaoJava = visit(ctx.valor); // Para "36 + 85", isso retornará a string "36 + 85"

        // Passo 3: Montar a linha de código Java final.
        // Usamos String.format para montar a string "idade = 36 + 85;\n".
       // return String.format("%s = %s;\n", nomeVariavel, expressaoJava);
        codigoPrincipal.append(String.format("        %s = %s;\n", nomeVariavel, expressaoJava));

        return null;
        // return ctx.getText();//IDENTIFICADOR().getText();
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


    @Override
    public String visitEstruturaCondicional(CompiladorLangParser.CmdSeContext ctx) {
        // 1. Visita a expressão da condição para obter seu código Java.
        String condicao = visit(ctx.cond);

        // 2. Visita o bloco 'entao' (o corpo do 'if').
        // O visitBloco que acabamos de criar fará o trabalho pesado.
        String blocoEntao = visit(ctx.entao);

        StringBuilder ifElse = new StringBuilder();

        // 3. Monta a parte 'if'
        ifElse.append(String.format("if (%s) {\n", condicao));
        ifElse.append(blocoEntao); // O bloco já vem com comandos e indentação
        ifElse.append("        }\n");

        // 4. Verifica se existe um bloco 'senao' (else).
        // O ANTLR deixa ctx.senao como null se a cláusula 'senao' não foi encontrada!
        if (ctx.senao != null) {
            // Visita o bloco 'senao'
            String blocoSenao = visit(ctx.senao);

            ifElse.append("        else {\n");
            ifElse.append(blocoSenao);
            ifElse.append("        }\n");
        }

        // Retorna a string completa do "if" ou "if-else"
        return ifElse.toString();
    }

    @Override
    public String visitCmdEnquanto(CompiladorLangParser.CmdEnquantoContext ctx) {
        // 1. Visita a expressão da condição.
        String condicao = visit(ctx.cond);

        // 2. Visita o bloco 'faca' (o corpo do 'while').
        String blocoFaca = visit(ctx.faca);

        // 3. Monta a string do 'while' e a retorna.
        return String.format("while (%s) {\n%s        }\n", condicao, blocoFaca);
    }
*/
}