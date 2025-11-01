package org.anima;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import org.antlr.v4.runtime.*;
import java.io.IOException;
import org.anima.antlr.out.CompiladorLang;

public class Main {
    public static void main(String[] args) throws IOException {
        // Código de exemplo em CompiladorLang
        String codigoFonte =
                "inicio\n" +
                        "    declare inteiro idade = 25;\n" +
                        "    declare real salario = 1500.50;\n" +
                        "    declare texto nome = \"João Silva\";\n" +
                        "    \n" +
                        "    se (idade >= 18) entao {\n" +
                        "        escreva(\"Maior de idade\");\n" +
                        "    };\n" +
                        "fim";

        // Cria um CharStream a partir do código fonte
        CharStream input = CharStreams.fromString(codigoFonte);

        // Cria uma instância do lexer
        CompiladorLang lexer = new CompiladorLang(input);

        // Obtém todos os tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();

        // Imprime cada token
        System.out.println("=== TOKENS RECONHECIDOS ===\n");
        for (Token token : tokens.getTokens()) {
            String tokenName = lexer.getVocabulary().getSymbolicName(token.getType());
            String tokenText = token.getText();
            int linha = token.getLine();
            int coluna = token.getCharPositionInLine();

            // Ignora o token EOF (End Of File)
            if (token.getType() != Token.EOF) {
                System.out.printf("Linha %d, Coluna %d: %-20s -> '%s'\n",
                        linha, coluna, tokenName, tokenText);
            }
        }

        System.out.println("\n=== FIM DA ANÁLISE LÉXICA ===");
    }
}

/*

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.IOException;

public class TesteParser {
    public static void main(String[] args) throws IOException {
        // Código de exemplo em CompiladorLang
        String codigoFonte =
            "inicio\n" +
            "    declare inteiro x = 10;\n" +
            "    declare real y = 5.5;\n" +
            "    declare inteiro resultado;\n" +
            "    \n" +
            "    resultado = x + (y * 2);\n" +
            "    \n" +
            "    se (resultado > 15) entao {\n" +
            "        escreva(\"Resultado maior que 15\");\n" +
            "    } senao {\n" +
            "        escreva(\"Resultado menor ou igual a 15\");\n" +
            "    };\n" +
            "    \n" +
            "    para (declare inteiro i = 0; i < 3; i = i + 1) faca {\n" +
            "        escreva(\"Iteração: \" + i);\n" +
            "    };\n" +
            "fim";

        // Cria o CharStream
        CharStream input = CharStreams.fromString(codigoFonte);

        // Cria o lexer
        CompiladorLangLexer lexer = new CompiladorLangLexer(input);

        // Cria o stream de tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Cria o parser
        CompiladorLangParser parser = new CompiladorLangParser(tokens);

        // Inicia a análise pela regra 'programa'
        ParseTree tree = parser.programa();

        // Verifica se houve erros
        if (parser.getNumberOfSyntaxErrors() == 0) {
            System.out.println("✅ ANÁLISE SINTÁTICA CONCLUÍDA COM SUCESSO!");
            System.out.println("\n=== ÁRVORE SINTÁTICA ===\n");
            System.out.println(tree.toStringTree(parser));
        } else {
            System.out.println("❌ ERROS SINTÁTICOS ENCONTRADOS!");
            System.out.println("Número de erros: " + parser.getNumberOfSyntaxErrors());
        }
    }
}

 */