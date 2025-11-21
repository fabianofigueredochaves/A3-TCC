parser grammar CompiladorLangParser;

options {
    tokenVocab = CompiladorLangLexer;
}
programa
    : KW_INICIO listaComandos KW_FIM
    ;

// --- LISTA DE COMANDOS ---
listaComandos
    : comando*
    ;

// --- COMANDO ---
comando
    : declaracao
    | atribuicao
    | estruturaCondicional
    | estruturaRepeticao
    | comandoLeitura
    | comandoEscrita
    ;

// --- DECLARAÇÃO DE VARIÁVEL ---
declaracao
    : KW_DECLARE tipo id=IDENTIFICADOR
    (OP_ATRIBUICAO init=expressao)? PONTO_VIRGULA
    ;

// --- TIPOS DE DADOS ---
tipo
    : KW_INTEIRO
    | KW_REAL
    | KW_TEXTO
    ;

// --- ATRIBUIÇÃO ---
atribuicao
    : destino=IDENTIFICADOR
    OP_ATRIBUICAO valor=expressao PONTO_VIRGULA
    ;

// --- ESTRUTURA CONDICIONAL ---
estruturaCondicional
    : KW_SE ABRE_PARENTESES expressao FECHA_PARENTESES KW_ENTAO
      ABRE_CHAVES listaComandos FECHA_CHAVES
      (KW_SENAO ABRE_CHAVES listaComandos FECHA_CHAVES)?
      PONTO_VIRGULA
    ;

// --- ESTRUTURAS DE REPETIÇÃO ---
estruturaRepeticao
    : loopEnquanto
    | loopPara
    ;

// Loop ENQUANTO
loopEnquanto
    : KW_ENQUANTO ABRE_PARENTESES expressao FECHA_PARENTESES
      KW_FACA ABRE_CHAVES listaComandos FECHA_CHAVES PONTO_VIRGULA
    ;

// Loop PARA
loopPara
    : KW_PARA ABRE_PARENTESES
      inicializacaoLoop PONTO_VIRGULA
      expressao PONTO_VIRGULA
      incrementoLoop
      FECHA_PARENTESES
      KW_FACA ABRE_CHAVES listaComandos FECHA_CHAVES PONTO_VIRGULA
    ;

// Inicialização do loop
inicializacaoLoop
    : declaracaoLoop
    | atribuicaoLoop
    |
    ;

// Incremento do loop
incrementoLoop
    : atribuicaoLoop
    |
    ;

// Declaração dentro do loop
declaracaoLoop
    : KW_DECLARE tipo IDENTIFICADOR
    (OP_ATRIBUICAO expressao)?
    ;

// Atribuição dentro do loop
atribuicaoLoop
    : IDENTIFICADOR
    OP_ATRIBUICAO expressao
    ;

// --- COMANDO DE LEITURA ---
comandoLeitura
    : KW_LEIA ABRE_PARENTESES IDENTIFICADOR
    FECHA_PARENTESES PONTO_VIRGULA
    ;

// --- COMANDO DE ESCRITA ---
comandoEscrita
    : KW_ESCREVA ABRE_PARENTESES expressao FECHA_PARENTESES PONTO_VIRGULA
    ;

// ============================================
// EXPRESSÕES (AQUI OS OPERADORES SÃO USADOS!)
// ============================================

// Nível 1: OR lógico (menor precedência)
expressao
    : expressaoE (KW_OU expressaoE)*
    ;

// Nível 2: AND lógico
expressaoE
    : expressaoRelacional (KW_E expressaoRelacional)*
    ;

// Nível 3: Operadores relacionais
// AQUI É ONDE OS OPERADORES RELACIONAIS SÃO USADOS!
expressaoRelacional
    : expressaoAditiva
      (
        ( OP_IGUAL        // ==
        | OP_DIFERENTE    // !=
        | OP_MENOR        // <
        | OP_MAIOR        // >
        | OP_MENOR_IGUAL  // <=
        | OP_MAIOR_IGUAL  // >=
        )
        expressaoAditiva
      )?
    ;

// Nível 4: Adição e subtração
expressaoAditiva
    : expressaoMultiplicativa
      (
        ( OP_SOMA        // +
        | OP_SUBTRACAO   // -
        )
        expressaoMultiplicativa
      )*
    ;

// Nível 5: Multiplicação e divisão
expressaoMultiplicativa
    : expressaoUnaria
      (
        ( OP_MULTIPLICACAO  // *
        | OP_DIVISAO        // /
        )
        expressaoUnaria
      )*
    ;

// Nível 6: Operadores unários
expressaoUnaria
    : KW_NAO expressaoUnaria              // nao expr
    | OP_SUBTRACAO expressaoUnaria        // -expr
    | expressaoPrimaria                   // valor básico
    ;

// Nível 7: Expressões primárias (maior precedência)
expressaoPrimaria
    : NUMERO_INTEIRO                      // 123
    | NUMERO_REAL                         // 123.45
    | TEXTO_LITERAL                       // "texto"
    | IDENTIFICADOR                       // variavel
    | ABRE_PARENTESES expressao FECHA_PARENTESES  // (expr)
    ;