package org.anima.semantica;

import org.anima.antlr.CompiladorLangParserVisitor;
import org.anima.antlr.CompiladorLangParser;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class AnalisadorSemantico implements CompiladorLangParserVisitor<TipoSimbolo> {

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

    // ===== MÉTODOS DE VISITAÇÃO PRINCIPAIS =====

    @Override
    public TipoSimbolo visitPrograma(CompiladorLangParser.ProgramaContext ctx) {
        // Visita todos os comandos do programa
        if (ctx.listaComandos() != null) {
            visit(ctx.listaComandos());
        }
        return TipoSimbolo.DESCONHECIDO;
    }

    @Override
    public TipoSimbolo visitListaComandos(CompiladorLangParser.ListaComandosContext ctx) {
        // Visita cada comando da lista
        // CORREÇÃO: ctx.comando() retorna uma LISTA, precisamos iterar sobre ela.
        if (ctx.comando() != null) {
            for (CompiladorLangParser.ComandoContext comandoCtx : ctx.comando()) {
                visit(comandoCtx); // Visita cada comando individualmente
            }
        }
        return TipoSimbolo.DESCONHECIDO;
    }

    @Override
    public TipoSimbolo visitComando(CompiladorLangParser.ComandoContext ctx) {
        // CORREÇÃO: Os métodos chamados aqui devem bater com os da gramática/parser.
        // Trocado "comandoSe" por "estruturaCondicional"
        // Trocado "comandoEnquanto" e "comandoPara" por "estruturaRepeticao"

        // Visita o tipo específico de comando
        if (ctx.declaracao() != null) {
            return visit(ctx.declaracao());
        } else if (ctx.atribuicao() != null) {
            return visit(ctx.atribuicao());
        } else if (ctx.estruturaCondicional() != null) { // Corrigido
            return visit(ctx.estruturaCondicional());
        } else if (ctx.estruturaRepeticao() != null) { // Corrigido
            return visit(ctx.estruturaRepeticao());
        } else if (ctx.comandoLeitura() != null) {
            return visit(ctx.comandoLeitura());
        } else if (ctx.comandoEscrita() != null) {
            return visit(ctx.comandoEscrita());
        }
        return TipoSimbolo.DESCONHECIDO;
    }

    // ===== VISITAÇÃO DE DECLARAÇÃO E TIPO =====

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

    @Override
    public TipoSimbolo visitTipo(CompiladorLangParser.TipoContext ctx) {
        // Este método é geralmente chamado por outros (como visitDeclaracao)
        // e não precisa de implementação se não for visitado diretamente.
        return TipoSimbolo.DESCONHECIDO;
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

    // ===== VISITAÇÃO DE ESTRUTURAS DE CONTROLE (SE, ENQUANTO, PARA) =====

    @Override
    public TipoSimbolo visitEstruturaCondicional(CompiladorLangParser.EstruturaCondicionalContext ctx) {
        // Implementação movida do "visitComandoSe" comentado
        // Visita a expressão condicional
        TipoSimbolo tipoCondicao = visit(ctx.expressao());

        // Verifica se a condição é booleana
        if (tipoCondicao != TipoSimbolo.BOOLEANO && tipoCondicao != TipoSimbolo.DESCONHECIDO) {
            erros.add(new ErroSemantico(
                    "Condição do SE deve ser uma expressão booleana",
                    ctx.start.getLine(),
                    ctx.start.getCharPositionInLine(),
                    ErroSemantico.TipoErro.TIPO_INCOMPATIVEL
            ));
        }

        // Visita o bloco ENTÃO (listaComandos(0))
        if (ctx.listaComandos(0) != null) {
            visit(ctx.listaComandos(0));
        }

        // Visita o bloco SENÃO (listaComandos(1)) (se existir)
        if (ctx.listaComandos(1) != null) {
            visit(ctx.listaComandos(1));
        }

        return TipoSimbolo.DESCONHECIDO;
    }

    @Override
    public TipoSimbolo visitEstruturaRepeticao(CompiladorLangParser.EstruturaRepeticaoContext ctx) {
        // Delega para o tipo de loop correto
        if (ctx.loopEnquanto() != null) {
            return visit(ctx.loopEnquanto());
        }
        if (ctx.loopPara() != null) {
            return visit(ctx.loopPara());
        }
        return TipoSimbolo.DESCONHECIDO;
    }

    @Override
    public TipoSimbolo visitLoopEnquanto(CompiladorLangParser.LoopEnquantoContext ctx) {
        // Implementação movida do "visitComandoEnquanto" comentado
        // Visita a expressão condicional
        TipoSimbolo tipoCondicao = visit(ctx.expressao());

        // Verifica se a condição é booleana
        if (tipoCondicao != TipoSimbolo.BOOLEANO && tipoCondicao != TipoSimbolo.DESCONHECIDO) {
            erros.add(new ErroSemantico(
                    "Condição do ENQUANTO deve ser uma expressão booleana",
                    ctx.start.getLine(),
                    ctx.start.getCharPositionInLine(),
                    ErroSemantico.TipoErro.TIPO_INCOMPATIVEL
            ));
        }

        // Visita o bloco de comandos
        if (ctx.listaComandos() != null) {
            visit(ctx.listaComandos());
        }

        return TipoSimbolo.DESCONHECIDO;
    }

    @Override
    public TipoSimbolo visitLoopPara(CompiladorLangParser.LoopParaContext ctx) {
        // Implementação adaptada do "visitComandoPara" comentado

        // Visita a inicialização
        if (ctx.inicializacaoLoop() != null) {
            visit(ctx.inicializacaoLoop());
        }

        // Visita a condição
        if (ctx.expressao() != null) {
            TipoSimbolo tipoCondicao = visit(ctx.expressao());

            if (tipoCondicao != TipoSimbolo.BOOLEANO && tipoCondicao != TipoSimbolo.DESCONHECIDO) {
                erros.add(new ErroSemantico(
                        "Condição do PARA deve ser uma expressão booleana",
                        ctx.start.getLine(),
                        ctx.start.getCharPositionInLine(),
                        ErroSemantico.TipoErro.TIPO_INCOMPATIVEL
                ));
            }
        }

        // Visita o incremento
        if (ctx.incrementoLoop() != null) {
            visit(ctx.incrementoLoop());
        }

        // Visita o bloco de comandos
        if (ctx.listaComandos() != null) {
            visit(ctx.listaComandos());
        }

        return TipoSimbolo.DESCONHECIDO;
    }

    @Override
    public TipoSimbolo visitInicializacaoLoop(CompiladorLangParser.InicializacaoLoopContext ctx) {
        if (ctx.declaracaoLoop() != null) {
            return visit(ctx.declaracaoLoop());
        }
        if (ctx.atribuicaoLoop() != null) {
            return visit(ctx.atribuicaoLoop());
        }
        return TipoSimbolo.DESCONHECIDO;
    }

    @Override
    public TipoSimbolo visitIncrementoLoop(CompiladorLangParser.IncrementoLoopContext ctx) {
        if (ctx.atribuicaoLoop() != null) {
            return visit(ctx.atribuicaoLoop());
        }
        return TipoSimbolo.DESCONHECIDO;
    }

    @Override
    public TipoSimbolo visitDeclaracaoLoop(CompiladorLangParser.DeclaracaoLoopContext ctx) {
        // Similar a visitDeclaracao, mas sem ponto e vírgula e dentro do escopo do loop
        // (Para simplicidade, estamos usando um escopo global, mas o ideal seria um escopo de loop)
        String nomeTipo = ctx.tipo().getText();
        TipoSimbolo tipo = TipoSimbolo.fromString(nomeTipo);

        String nomeVariavel = ctx.IDENTIFICADOR().getText();
        int linha = ctx.IDENTIFICADOR().getSymbol().getLine();
        int coluna = ctx.IDENTIFICADOR().getSymbol().getCharPositionInLine();

        if (tabelaSimbolos.existe(nomeVariavel)) {
            Simbolo simboloExistente = tabelaSimbolos.obter(nomeVariavel);
            erros.add(new ErroSemantico(
                    String.format("Variável '%s' já foi declarada na linha %d",
                            nomeVariavel, simboloExistente.getLinha()),
                    linha,
                    coluna,
                    ErroSemantico.TipoErro.VARIAVEL_JA_DECLARADA
            ));
        }

        boolean inicializada = ctx.expressao() != null;
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

        Simbolo simbolo = new Simbolo(nomeVariavel, tipo, inicializada, linha);
        tabelaSimbolos.adicionar(simbolo);
        return tipo;
    }

    @Override
    public TipoSimbolo visitAtribuicaoLoop(CompiladorLangParser.AtribuicaoLoopContext ctx) {
        // Similar a visitAtribuicao, mas sem ponto e vírgula
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
        TipoSimbolo tipoVariavel = simbolo.getTipo();
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

        tabelaSimbolos.marcarInicializada(nomeVariavel);
        return tipoVariavel;
    }

    // ===== VISITAÇÃO DE LEITURA E ESCRITA =====

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

    @Override
    public TipoSimbolo visitComandoEscrita(CompiladorLangParser.ComandoEscritaContext ctx) {
        // Visita a expressão a ser escrita
        if (ctx.expressao() != null) {
            visit(ctx.expressao());
        }
        return TipoSimbolo.DESCONHECIDO;
    }

    // ===== VISITAÇÃO DE EXPRESSÕES (LÓGICAS, RELACIONAIS, ARITMÉTICAS) =====

    @Override
    public TipoSimbolo visitExpressao(CompiladorLangParser.ExpressaoContext ctx) {
        // Expressão OU lógica
        if (ctx.expressaoE().size() > 1) {
            // Verifica se ambos os operandos são booleanos
            TipoSimbolo tipo1 = visit(ctx.expressaoE(0));
            TipoSimbolo tipo2 = TipoSimbolo.DESCONHECIDO;

            // Itera por todas as expressões 'OU'
            for(int i = 1; i < ctx.expressaoE().size(); i++) {
                tipo2 = visit(ctx.expressaoE(i));
                if((tipo1 != TipoSimbolo.BOOLEANO && tipo1 != TipoSimbolo.DESCONHECIDO) ||
                        (tipo2 != TipoSimbolo.BOOLEANO && tipo2 != TipoSimbolo.DESCONHECIDO)) {

                    erros.add(new ErroSemantico(
                            "Operador OU requer operandos booleanos",
                            ctx.KW_OU(i-1).getSymbol().getLine(), // Pega a linha do operador 'OU'
                            ctx.KW_OU(i-1).getSymbol().getCharPositionInLine(),
                            ErroSemantico.TipoErro.OPERACAO_INVALIDA
                    ));
                    return TipoSimbolo.DESCONHECIDO;
                }
                tipo1 = TipoSimbolo.BOOLEANO; // O resultado de A ou B é booleano
            }
            return TipoSimbolo.BOOLEANO;
        }

        return visit(ctx.expressaoE(0));
    }

    @Override
    public TipoSimbolo visitExpressaoE(CompiladorLangParser.ExpressaoEContext ctx) {
        // Expressão E lógica
        if (ctx.expressaoRelacional().size() > 1) {
            TipoSimbolo tipo1 = visit(ctx.expressaoRelacional(0));
            TipoSimbolo tipo2 = TipoSimbolo.DESCONHECIDO;

            for(int i = 1; i < ctx.expressaoRelacional().size(); i++) {
                tipo2 = visit(ctx.expressaoRelacional(i));
                if ((tipo1 != TipoSimbolo.BOOLEANO && tipo1 != TipoSimbolo.DESCONHECIDO) ||
                        (tipo2 != TipoSimbolo.BOOLEANO && tipo2 != TipoSimbolo.DESCONHECIDO)) {

                    erros.add(new ErroSemantico(
                            "Operador E requer operandos booleanos",
                            ctx.KW_E(i-1).getSymbol().getLine(),
                            ctx.KW_E(i-1).getSymbol().getCharPositionInLine(),
                            ErroSemantico.TipoErro.OPERACAO_INVALIDA
                    ));
                    return TipoSimbolo.DESCONHECIDO;
                }
                tipo1 = TipoSimbolo.BOOLEANO;
            }
            return TipoSimbolo.BOOLEANO;
        }

        return visit(ctx.expressaoRelacional(0));
    }

    @Override
    public TipoSimbolo visitExpressaoRelacional(CompiladorLangParser.ExpressaoRelacionalContext ctx) {
        TipoSimbolo tipoEsquerda = visit(ctx.expressaoAditiva(0));

        // Verifica se há um operador relacional
        if (ctx.expressaoAditiva().size() > 1) {
            TipoSimbolo tipoDireita = visit(ctx.expressaoAditiva(1));

            // Pega o operador (==, !=, <, >, <=, >=)
            String operador = ctx.getChild(1).getText(); // O operador está na posição 1

            // Chama o método de inferência de tipo para comparação
            return inferirTipoComparacao(tipoEsquerda, tipoDireita, operador, ctx.start.getLine());
        }

        return tipoEsquerda;
    }

    @Override
    public TipoSimbolo visitExpressaoAditiva(CompiladorLangParser.ExpressaoAditivaContext ctx) {
        if (ctx.expressaoMultiplicativa().size() > 1) {
            TipoSimbolo tipoEsquerda = visit(ctx.expressaoMultiplicativa(0));

            for (int i = 1; i < ctx.expressaoMultiplicativa().size(); i++) {
                TipoSimbolo tipoDireita = visit(ctx.expressaoMultiplicativa(i));
                String operador = ctx.getChild(i * 2 - 1).getText();
                tipoEsquerda = inferirTipoOperacao(tipoEsquerda, tipoDireita, operador, ctx.start.getLine());
            }

            return tipoEsquerda;
        }
        return visit(ctx.expressaoMultiplicativa(0));
    }


    @Override
    public TipoSimbolo visitExpressaoMultiplicativa(CompiladorLangParser.ExpressaoMultiplicativaContext ctx) {
        if (ctx.expressaoUnaria().size() > 1) {
            TipoSimbolo tipoEsquerda = visit(ctx.expressaoUnaria(0));

            for (int i = 1; i < ctx.expressaoUnaria().size(); i++) {
                TipoSimbolo tipoDireita = visit(ctx.expressaoUnaria(i));
                // Pega o operador (* ou /)
                String operador = ctx.getChild(i * 2 - 1).getText();
                tipoEsquerda = inferirTipoOperacao(tipoEsquerda, tipoDireita, operador, ctx.start.getLine());
            }

            return tipoEsquerda;
        }
        return visit(ctx.expressaoUnaria(0));
    }

    @Override
    public TipoSimbolo visitExpressaoUnaria(CompiladorLangParser.ExpressaoUnariaContext ctx) {
        // Expressões unárias (NAO, negação)
        if (ctx.KW_NAO() != null) {
            TipoSimbolo tipoOperando = visit(ctx.expressaoUnaria());

            if (tipoOperando != TipoSimbolo.BOOLEANO && tipoOperando != TipoSimbolo.DESCONHECIDO) {
                erros.add(new ErroSemantico(
                        "Operador NAO requer operando booleano",
                        ctx.start.getLine(),
                        ctx.start.getCharPositionInLine(),
                        ErroSemantico.TipoErro.OPERACAO_INVALIDA
                ));
                return TipoSimbolo.DESCONHECIDO;
            }
            return TipoSimbolo.BOOLEANO;
        }

        if (ctx.OP_SUBTRACAO() != null) {
            TipoSimbolo tipoOperando = visit(ctx.expressaoUnaria());

            if (tipoOperando != TipoSimbolo.INTEIRO &&
                    tipoOperando != TipoSimbolo.REAL &&
                    tipoOperando != TipoSimbolo.DESCONHECIDO) {
                erros.add(new ErroSemantico(
                        "Operador de negação (-) requer operando numérico",
                        ctx.start.getLine(),
                        ctx.start.getCharPositionInLine(),
                        ErroSemantico.TipoErro.OPERACAO_INVALIDA
                ));
                return TipoSimbolo.DESCONHECIDO;
            }
            return tipoOperando;
        }

        return visit(ctx.expressaoPrimaria());
    }

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
                erros.add(new ErroSemantico(
                        "Variável '" + nomeVariavel + "' pode não estar inicializada",
                        linha,
                        coluna,
                        ErroSemantico.TipoErro.VARIAVEL_NAO_INICIALIZADA
                ));
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

    // ===== MÉTODOS BASE DO VISITOR (IMPLEMENTAÇÃO CORRETA) =====

    @Override
    public TipoSimbolo visit(ParseTree parseTree) {
        // CORREÇÃO: Método fundamental. Deve chamar 'accept' no nó da árvore.
        if (parseTree == null) {
            return TipoSimbolo.DESCONHECIDO;
        }
        return parseTree.accept(this);
    }

    @Override
    public TipoSimbolo visitChildren(RuleNode ruleNode) {
        // CORREÇÃO: Implementação padrão para visitar todos os filhos de um nó.
        TipoSimbolo result = TipoSimbolo.DESCONHECIDO; // Default
        int n = ruleNode.getChildCount();
        for (int i = 0; i < n; i++) {
            ParseTree child = ruleNode.getChild(i);
            // Chama o visit(ParseTree) corrigido
            result = visit(child);
        }
        return result; // Retorna o resultado do último filho visitado
    }

    @Override
    public TipoSimbolo visitTerminal(TerminalNode terminalNode) {
        // Terminais (palavras-chave, operadores, literais) geralmente não
        // retornam um tipo, a menos que seja em visitExpressaoPrimaria.
        return TipoSimbolo.DESCONHECIDO;
    }

    @Override
    public TipoSimbolo visitErrorNode(ErrorNode errorNode) {
        // Trata nós de erro (ex: sintaxe inesperada)
        System.err.println("Erro de sintaxe detectado: " + errorNode.getText());
        return TipoSimbolo.DESCONHECIDO;
    }


    // ===== MÉTODOS AUXILIARES =====

    private TipoSimbolo obterTipo(CompiladorLangParser.TipoContext ctx) {
        if (ctx.KW_INTEIRO() != null) {
            return TipoSimbolo.INTEIRO;
        } else if (ctx.KW_REAL() != null) {
            return TipoSimbolo.REAL;
        } else if (ctx.KW_TEXTO() != null) {
            return TipoSimbolo.TEXTO;
        }
        return TipoSimbolo.DESCONHECIDO;
    }

    private boolean tiposCompativeis(TipoSimbolo tipo1, TipoSimbolo tipo2) {
        if (tipo1 == TipoSimbolo.DESCONHECIDO || tipo2 == TipoSimbolo.DESCONHECIDO) {
            return true; // Evita erros em cascata
        }

        if (tipo1 == tipo2) {
            return true;
        }

        // Permite atribuir INTEIRO a REAL
        if (tipo1 == TipoSimbolo.REAL && tipo2 == TipoSimbolo.INTEIRO) {
            return true;
        }

        return false;
    }

    private TipoSimbolo inferirTipoOperacao(TipoSimbolo tipo1, TipoSimbolo tipo2, String operador, int linha) {
        if (tipo1 == TipoSimbolo.DESCONHECIDO || tipo2 == TipoSimbolo.DESCONHECIDO) {
            return TipoSimbolo.DESCONHECIDO;
        }

        // Concatenação de Texto (apenas com +)
        if (operador.equals("+")) {
            if (tipo1 == TipoSimbolo.TEXTO || tipo2 == TipoSimbolo.TEXTO) {
                return TipoSimbolo.TEXTO;
            }
        }

        // Operações Aritméticas
        if (tipo1 == TipoSimbolo.REAL && tipo2 == TipoSimbolo.REAL) {
            return TipoSimbolo.REAL;
        }
        if (tipo1 == TipoSimbolo.REAL && tipo2 == TipoSimbolo.INTEIRO) {
            return TipoSimbolo.REAL;
        }
        if (tipo1 == TipoSimbolo.INTEIRO && tipo2 == TipoSimbolo.REAL) {
            return TipoSimbolo.REAL;
        }
        if (tipo1 == TipoSimbolo.INTEIRO && tipo2 == TipoSimbolo.INTEIRO) {
            // Divisão de inteiros pode resultar em real na sua linguagem?
            // Vou assumir que / gera REAL e *,- geram INTEIRO.
            if (operador.equals("/")) {
                return TipoSimbolo.REAL; // Ou mantenha INTEIRO se for divisão inteira
            }
            return TipoSimbolo.INTEIRO;
        }

        // Se chegou aqui, é uma operação inválida
        erros.add(new ErroSemantico(
                "Operação '" + operador + "' não pode ser aplicada aos tipos " + tipo1 + " e " + tipo2,
                linha, 0, ErroSemantico.TipoErro.OPERACAO_INVALIDA));

        return TipoSimbolo.DESCONHECIDO;
    }

    private TipoSimbolo inferirTipoComparacao(TipoSimbolo tipo1, TipoSimbolo tipo2,
                                              String operador, int linha) {

        if (tipo1 == TipoSimbolo.DESCONHECIDO || tipo2 == TipoSimbolo.DESCONHECIDO) {
            return TipoSimbolo.BOOLEANO; // Assume que a comparação é booleana para evitar erros cascata
        }

        // Comparações de texto (só == e !=)
        if (tipo1 == TipoSimbolo.TEXTO || tipo2 == TipoSimbolo.TEXTO) {
            if (operador.equals("==") || operador.equals("!=")) {
                if (tipo1 != tipo2) { // Ex: comparando TEXTO com INTEIRO
                    erros.add(new ErroSemantico(String.format("Não é possível comparar %s com %s", tipo1, tipo2),
                            linha, 0, ErroSemantico.TipoErro.OPERACAO_INVALIDA));
                    return TipoSimbolo.DESCONHECIDO;
                }
                return TipoSimbolo.BOOLEANO;
            } else {
                erros.add(new ErroSemantico(String.format("Operador '%s' não pode ser usado com tipo texto. Use apenas == ou !=",
                        operador), linha, 0, ErroSemantico.TipoErro.OPERACAO_INVALIDA));
                return TipoSimbolo.DESCONHECIDO;
            }
        }

        // Comparações numéricas (INTEIRO e REAL)
        if ((tipo1 == TipoSimbolo.INTEIRO || tipo1 == TipoSimbolo.REAL) &&
                (tipo2 == TipoSimbolo.INTEIRO || tipo2 == TipoSimbolo.REAL)) {
            return TipoSimbolo.BOOLEANO;
        }

        // Comparação de Booleanos (só == e !=)
        if(tipo1 == TipoSimbolo.BOOLEANO && tipo2 == TipoSimbolo.BOOLEANO) {
            if (operador.equals("==") || operador.equals("!=")) {
                return TipoSimbolo.BOOLEANO;
            } else {
                erros.add(new ErroSemantico(String.format("Operador '%s' não pode ser usado com tipo booleano.",
                        operador), linha, 0, ErroSemantico.TipoErro.OPERACAO_INVALIDA));
                return TipoSimbolo.DESCONHECIDO;
            }
        }

        // Outras comparações inválidas
        erros.add(new ErroSemantico(String.format("Não é possível comparar %s com %s", tipo1, tipo2),
                linha, 0, ErroSemantico.TipoErro.OPERACAO_INVALIDA));

        return TipoSimbolo.DESCONHECIDO;
    }
}