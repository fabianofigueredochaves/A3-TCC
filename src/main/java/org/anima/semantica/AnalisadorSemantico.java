/*
package org.anima.semantica;

import org.anima.antlr.CompiladorLangBaseVisitor;
import org.anima.antlr.CompiladorLangParser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class AnalisadorSemantico extends CompiladorLangBaseVisitor<TipoSimbolo> {

    private TabelaSimbolos tabelaSimbolos;
    private List<ErroSemantico> erros;

    public AnalisadorSemantico() {
        this.tabelaSimbolos = new TabelaSimbolos();
        this.erros = new ArrayList<>();
    }

    public TabelaSimbolos getTabelaSimbolos() {
        return tabelaSimbolos;
    }

    public List<ErroSemantico> getErros() {
        return erros;
    }

    public boolean temErros() {
        return !erros.isEmpty();
    }

    // ===== VISITAÇÃO DE DECLARAÇÃO =====

    @Override
    public TipoSimbolo visitDeclaracao(CompiladorLangParser.DeclaracaoContext ctx) {
        String nomeTipo = ctx.tipo().getText();
        TipoSimbolo tipo = TipoSimbolo.fromString(nomeTipo);

        String nomeVariavel = ctx.IDENTIFICADOR().getText();
        int linha = ctx.IDENTIFICADOR().getSymbol().getLine();
        int coluna = ctx.IDENTIFICADOR().getSymbol().getCharPositionInLine();

        // Verifica se a variável já foi declarada
        if (tabelaSimbolos.existe(nomeVariavel)) {
            Simbolo simboloExistente = tabelaSimbolos.obter(nomeVariavel);
            erros.add(new ErroSemantico(
                    String.format("Variável '%s' já foi declarada na linha %d",
                            nomeVariavel, simboloExistente.getLinha()),
                    linha,
                    coluna,
                    ErroSemantico.TipoErro.VARIAVEL_JA_DECLARADA
            ));
            return tipo;
        }

        // Verifica se há inicialização
        boolean inicializada = ctx.expressao() != null;

        // Se há inicialização, verifica o tipo da expressão
        if (inicializada) {
            TipoSimbolo tipoExpressao = visit(ctx.expressao());
            if (!tiposCompativeis(tipo, tipoExpressao)) {
                erros.add(new ErroSemantico(
                        String.format("Tipo incompatível: não é possível atribuir %s a %s",
                                tipoExpressao, tipo),
                        linha,
                        coluna,
                        ErroSemantico.TipoErro.TIPO_INCOMPATIVEL
                ));
            }
        }

        // Adiciona o símbolo à tabela
        Simbolo simbolo = new Simbolo(nomeVariavel, tipo, inicializada, linha);
        tabelaSimbolos.adicionar(simbolo);

        return tipo;
    }

    // ===== VISITAÇÃO DE ATRIBUIÇÃO =====

    @Override
    public TipoSimbolo visitAtribuicao(CompiladorLangParser.AtribuicaoContext ctx) {
        String nomeVariavel = ctx.IDENTIFICADOR().getText();
        int linha = ctx.IDENTIFICADOR().getSymbol().getLine();
        int coluna = ctx.IDENTIFICADOR().getSymbol().getCharPositionInLine();

        // Verifica se a variável foi declarada
        if (!tabelaSimbolos.existe(nomeVariavel)) {
            erros.add(new ErroSemantico(
                    String.format("Variável '%s' não foi declarada", nomeVariavel),
                    linha,
                    coluna,
                    ErroSemantico.TipoErro.VARIAVEL_NAO_DECLARADA
            ));
            return TipoSimbolo.DESCONHECIDO;
        }

        Simbolo simbolo = tabelaSimbolos.obter(nomeVariavel);
        TipoSimbolo tipoVariavel = simbolo.getTipo();

        // Verifica o tipo da expressão
        TipoSimbolo tipoExpressao = visit(ctx.expressao());

        if (!tiposCompativeis(tipoVariavel, tipoExpressao)) {
            erros.add(new ErroSemantico(
                    String.format("Tipo incompatível: não é possível atribuir %s a %s",
                            tipoExpressao, tipoVariavel),
                    linha,
                    coluna,
                    ErroSemantico.TipoErro.TIPO_INCOMPATIVEL
            ));
        }

        // Marca a variável como inicializada
        tabelaSimbolos.marcarInicializada(nomeVariavel);

        return tipoVariavel;
    }

    // ===== VISITAÇÃO DE EXPRESSÕES PRIMÁRIAS =====

    @Override
    public TipoSimbolo visitExpressaoPrimaria(CompiladorLangParser.ExpressaoPrimariaContext ctx) {
        if (ctx.NUMERO_INTEIRO() != null) {
            return TipoSimbolo.INTEIRO;
        }
        if (ctx.NUMERO_REAL() != null) {
            return TipoSimbolo.REAL;
        }
        if (ctx.TEXTO_LITERAL() != null) {
            return TipoSimbolo.TEXTO;
        }
        if (ctx.IDENTIFICADOR() != null) {
            String nomeVariavel = ctx.IDENTIFICADOR().getText();
            int linha = ctx.IDENTIFICADOR().getSymbol().getLine();
            int coluna = ctx.IDENTIFICADOR().getSymbol().getCharPositionInLine();

            if (!tabelaSimbolos.existe(nomeVariavel)) {
                erros.add(new ErroSemantico(
                        String.format("Variável '%s' não foi declarada", nomeVariavel),
                        linha,
                        coluna,
                        ErroSemantico.TipoErro.VARIAVEL_NAO_DECLARADA
                ));
                return TipoSimbolo.DESCONHECIDO;
            }

            Simbolo simbolo = tabelaSimbolos.obter(nomeVariavel);

            // Aviso: variável pode não estar inicializada
            if (!simbolo.isInicializada()) {
                System.err.println(String.format(
                        "⚠️  AVISO na linha %d, coluna %d: Variável '%s' pode não estar inicializada",
                        linha, coluna, nomeVariavel
                ));
            }

            return simbolo.getTipo();
        }
        if (ctx.expressao() != null) {
            return visit(ctx.expressao());
        }

        return TipoSimbolo.DESCONHECIDO;
    }

    // ===== VISITAÇÃO DE OPERAÇÕES ARITMÉTICAS =====

    @Override
    public TipoSimbolo visitExpressaoAditiva(CompiladorLangParser.ExpressaoAditivaContext ctx) {
        TipoSimbolo tipoEsquerda = visit(ctx.expressaoMultiplicativa(0));

        for (int i = 1; i < ctx.expressaoMultiplicativa().size(); i++) {
            TipoSimbolo tipoDireita = visit(ctx.expressaoMultiplicativa(i));
            tipoEsquerda = inferirTipoOperacao(tipoEsquerda, tipoDireita, ctx.start.getLine());
        }

        return tipoEsquerda;
    }

    @Override
    public TipoSimbolo visitExpressaoMultiplicativa(CompiladorLangParser.ExpressaoMultiplicativaContext ctx) {
        TipoSimbolo tipoEsquerda = visit(ctx.expressaoUnaria(0));

        for (int i = 1; i < ctx.expressaoUnaria().size(); i++) {
            TipoSimbolo tipoDireita = visit(ctx.expressaoUnaria(i));
            tipoEsquerda = inferirTipoOperacao(tipoEsquerda, tipoDireita, ctx.start.getLine());
        }

        return tipoEsquerda;
    }

    // ===== VISITAÇÃO DE COMANDO DE LEITURA =====

    @Override
    public TipoSimbolo visitComandoLeitura(CompiladorLangParser.ComandoLeituraContext ctx) {
        String nomeVariavel = ctx.IDENTIFICADOR().getText();
        int linha = ctx.IDENTIFICADOR().getSymbol().getLine();
        int coluna = ctx.IDENTIFICADOR().getSymbol().getCharPositionInLine();

        if (!tabelaSimbolos.existe(nomeVariavel)) {
            erros.add(new ErroSemantico(
                    String.format("Variável '%s' não foi declarada", nomeVariavel),
                    linha,
                    coluna,
                    ErroSemantico.TipoErro.VARIAVEL_NAO_DECLARADA
            ));
            return TipoSimbolo.DESCONHECIDO;
        }

        // Marca como inicializada (leitura inicializa a variável)
        tabelaSimbolos.marcarInicializada(nomeVariavel);

        return tabelaSimbolos.obter(nomeVariavel).getTipo();
    }

    // ===== MÉTODOS AUXILIARES =====

    private boolean tiposCompativeis(TipoSimbolo tipo1, TipoSimbolo tipo2) {
        return true;  // Ignora erros já reportados
    }

    // Inteiro pode ser atribuído a Real (conversão implícita)
        if (tipo1 == TipoSimbolo.REAL && tipo2 == TipoSimbolo.INTEIRO) {
        return true;
    }

        return tipo1 == tipo2;
}

private TipoSimbolo inferirTipoOperacao(TipoSimbolo tipo1, TipoSimbolo tipo2, int linha) {
    return TipoSimbolo.DESCONHECIDO;
}

// TEXTO só pode ser concatenado com +
            return TipoSimbolo.TEXTO;
        }

                // Operações numéricas
                return TipoSimbolo.REAL;
        }

                if (tipo1 == TipoSimbolo.INTEIRO && tipo2 == TipoSimbolo.INTEIRO) {
        return TipoSimbolo.INTEIRO;
        }

                erros.add(new ErroSemantico(
        String.format("Operação inválida entre %s e %s", tipo1, tipo2),
linha,
        0,
ErroSemantico.TipoErro.OPERACAO_INVALIDA
        ));

                return TipoSimbolo.DESCONHECIDO;
    }
            }


 */