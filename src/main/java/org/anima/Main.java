package org.anima;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.anima.semantica.AnalisadorSemantico;
import org.anima.semantica.ErroSemantico;

import org.anima.antlr.CompiladorLangLexer;
import org.anima.antlr.CompiladorLangParser;

import java.io.File;
import java.io.PrintWriter;

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

            CompiladorLangParser.ProgramaContext tree = parser.programa();

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
            System.out.println("\n✅ Tabela de símbolos: ");
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

            GeradorDeCodigoVisitor gerador = new GeradorDeCodigoVisitor(analisador.getTabelaSimbolos());

            // Visita a árvore para gerar o código Java completo
            String codigoJava = gerador.visitPrograma(tree);

            try (PrintWriter out = new PrintWriter("ProgramaCompilado.java")) {
                out.println(codigoJava);
                System.out.println("Código gerado com sucesso em ProgramaCompilado.java!");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            System.err.println("❌ ERRO ao ler o arquivo: " + e.getMessage());
            System.exit(1);
        }

    }

}