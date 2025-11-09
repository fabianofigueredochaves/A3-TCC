package org.anima;

import org.anima.antlr.CompiladorLangLexer;
import org.anima.antlr.CompiladorLangParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.IOException;

import org.anima.semantica.AnalisadorSemantico;
import org.anima.semantica.ErroSemantico;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String nomeArquivo = "programa.cpl";

        if (args.length > 0) {
            nomeArquivo = args[0];
        }

        System.out.println("📂 Lendo arquivo: " + nomeArquivo);
        System.out.println("=====================================\n");

        File arquivo = new File(nomeArquivo);
        if (!arquivo.exists()) {
            System.err.println("❌ ERRO: Arquivo não encontrado!");
            System.err.println("   Caminho procurado: " + arquivo.getAbsolutePath());
            System.exit(1);
        }

        try {
            CharStream input = CharStreams.fromFileName(nomeArquivo);
            CompiladorLangLexer lexer = new CompiladorLangLexer(input);

            lexer.removeErrorListeners();
            lexer.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer,
                                        Object offendingSymbol,
                                        int line,
                                        int charPositionInLine,
                                        String msg,
                                        RecognitionException e) {
                    System.err.println("❌ ERRO LÉXICO na linha " + line +
                            ", coluna " + charPositionInLine);
                    System.err.println("   " + msg);
                    System.err.println();
                }
            });

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            CompiladorLangParser parser = new CompiladorLangParser(tokens);

            parser.removeErrorListeners();
            parser.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer,
                                        Object offendingSymbol,
                                        int line,
                                        int charPositionInLine,
                                        String msg,
                                        RecognitionException e) {
                    System.err.println("❌ ERRO SINTÁTICO na linha " + line +
                            ", coluna " + charPositionInLine);
                    System.err.println("   " + msg);
                    if (offendingSymbol instanceof Token) {
                        Token token = (Token) offendingSymbol;
                        System.err.println("   Token problemático: '" +
                                token.getText() + "'");
                    }
                    System.err.println();
                }
            });

            System.out.println("🔍 FASE 1: Análise Léxica");
            System.out.println("🔍 FASE 2: Análise Sintática\n");

            ParseTree tree = parser.programa();

            if (parser.getNumberOfSyntaxErrors() > 0) {
                System.out.println("\n❌ COMPILAÇÃO FALHOU na análise sintática!");
                System.out.println("   Corrija os erros sintáticos antes de prosseguir.\n");
                System.exit(1);
            }

            System.out.println("✅ Análise Léxica e Sintática concluídas com sucesso!\n");

            // ===== ANÁLISE SEMÂNTICA =====
            System.out.println("🔍 FASE 3: Análise Semântica\n");

            AnalisadorSemantico analisador = new AnalisadorSemantico();
            analisador.visit(tree);

            // Exibe a tabela de símbolos
            System.out.println(analisador.getTabelaSimbolos());

            // Verifica se houve erros semânticos
            if (analisador.temErros()) {
                System.out.println("\n❌ ERROS SEMÂNTICOS ENCONTRADOS:\n");
                for (ErroSemantico erro : analisador.getErros()) {
                    System.err.println(erro);
                }
                System.out.println("\n❌ COMPILAÇÃO FALHOU!");
                System.out.println("   Foram encontrados " + analisador.getErros().size() +
                        " erro(s) semântico(s).\n");
                System.exit(1);
            }

            System.out.println("\n✅ COMPILAÇÃO CONCLUÍDA COM SUCESSO!");
            System.out.println("   O código está sintaticamente e semanticamente correto.\n");

        } catch (IOException e) {
            System.err.println("❌ ERRO ao ler o arquivo: " + e.getMessage());
            System.exit(1);
        }

    }

}



/*
public class Main {
    public static void main(String[] args) throws IOException {
        // Nome do arquivo fixo (você pode mudar aqui)
        String nomeArquivo = "programa.cpl";

        System.out.println("📂 Lendo arquivo: " + nomeArquivo);
        System.out.println("=====================================\n");

        // Cria o CharStream a partir do arquivo
        CharStream input = CharStreams.fromFileName(nomeArquivo);

        // Cria o lexer
        CompiladorLangLexer lexer = new CompiladorLangLexer(input);

        // Cria o stream de tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Cria o parser
        CompiladorLangParser parser = new CompiladorLangParser(tokens);

        // Inicia a análise
        ParseTree tree = parser.programa();

        // Verifica resultado
        if (parser.getNumberOfSyntaxErrors() == 0) {
            System.out.println("✅ CÓDIGO CORRETO!");
        } else {
            System.out.println("❌ CÓDIGO COM ERROS!");
        }
    }
}


// Classe para tratar erros de forma mais amigável
class ErrorListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line,
                            int charPositionInLine,
                            String msg,
                            RecognitionException e) {
        System.err.println("❌ ERRO SINTÁTICO na linha " + line + ", coluna " + charPositionInLine);
        System.err.println("   " + msg);

        // Mostra o token problemático se disponível
        if (offendingSymbol instanceof Token) {
            Token token = (Token) offendingSymbol;
            System.err.println("   Token problemático: '" + token.getText() + "'");
        }
        System.err.println();
    }
}

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
                        "    dMaineclare inteiro idade = 25;\n" +
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



import org.anima.antlr.g4.CompiladorLangLexer;
import org.anima.antlr.g4.CompiladorLangParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.IOException;

public class Main {
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