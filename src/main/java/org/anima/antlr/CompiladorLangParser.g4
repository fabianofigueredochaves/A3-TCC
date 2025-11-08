parser grammar CompiladorLangParser;

options {
    tokenVocab = CompiladorLangLexer;
}

@members {
    // Lista para armazenar variáveis já declaradas
    private java.util.Set<String> variaveisDeclaradas = new java.util.HashSet<>();

    // Método para verificar se uma variável já foi declarada
    private boolean jaFoiDeclarada(String nomeVariavel) {
        return variaveisDeclaradas.contains(nomeVariavel);
    }

    // Método para adicionar uma variável à lista
    private void declararVariavel(String nomeVariavel, int linha) {
        if (jaFoiDeclarada(nomeVariavel)) {
            System.err.println("❌ ERRO SEMÂNTICO na linha " + linha +
                             ": Variável '" + nomeVariavel + "' já foi declarada!");
        } else {
            variaveisDeclaradas.add(nomeVariavel);
            System.out.println("✅ Variável '" + nomeVariavel + "' declarada na linha " + linha);
        }
    }

    // Método para verificar se uma variável foi declarada antes de usar
    private void verificarDeclaracao(String nomeVariavel, int linha) {
        if (!jaFoiDeclarada(nomeVariavel)) {
            System.err.println("❌ ERRO SEMÂNTICO na linha " + linha +
                             ": Variável '" + nomeVariavel + "' não foi declarada!");
        }
    }

    // Método para limpar a lista (útil para múltiplas compilações)
    public void limparVariaveis() {
        variaveisDeclaradas.clear();
    }

    // Método para obter todas as variáveis declaradas
    public java.util.Set<String> getVariaveisDeclaradas() {
        return new java.util.HashSet<>(variaveisDeclaradas);
    }
}
// ============================================
// REGRAS DO PARSER
// ============================================

// --- REGRA INICIAL: Um programa completo ---
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
    : KW_DECLARE tipo IDENTIFICADOR
    {
         String nomeVar = $IDENTIFICADOR.text;
         int linha = $IDENTIFICADOR.line;
         declararVariavel(nomeVar, linha);
    }
    (OP_ATRIBUICAO expressao)? PONTO_VIRGULA
    ;

// --- TIPOS DE DADOS ---
tipo
    : KW_INTEIRO
    | KW_REAL
    | KW_TEXTO
    ;

// --- ATRIBUIÇÃO ---
atribuicao
    : IDENTIFICADOR
    {
         String nomeVar = $IDENTIFICADOR.text;
         int linha = $IDENTIFICADOR.line;
         verificarDeclaracao(nomeVar, linha);
    }
    OP_ATRIBUICAO expressao PONTO_VIRGULA
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
    {
         String nomeVar = $IDENTIFICADOR.text;
         int linha = $IDENTIFICADOR.line;
         declararVariavel(nomeVar, linha);
    }
    (OP_ATRIBUICAO expressao)?
    ;

// Atribuição dentro do loop
atribuicaoLoop
    : IDENTIFICADOR
    {
         String nomeVar = $IDENTIFICADOR.text;
         int linha = $IDENTIFICADOR.line;
         verificarDeclaracao(nomeVar, linha);
    }
    OP_ATRIBUICAO expressao
    ;

// --- COMANDO DE LEITURA ---
comandoLeitura
    : KW_LEIA ABRE_PARENTESES IDENTIFICADOR
    {
         String nomeVar = $IDENTIFICADOR.text;
         int linha = $IDENTIFICADOR.line;
         verificarDeclaracao(nomeVar, linha);
    }
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
    {
              String nomeVar = $IDENTIFICADOR.text;
              int linha = $IDENTIFICADOR.line;
              verificarDeclaracao(nomeVar, linha);
    }
    | ABRE_PARENTESES expressao FECHA_PARENTESES  // (expr)
    ;

/*
parser grammar CompiladorLangParser;

options {
    tokenVocab = CompiladorLangLexer;
}

// ============================================
// BLOCO @members - Código Java do Parser
// ============================================

@members {
    // Lista para armazenar variáveis já declaradas
    private java.util.Set<String> variaveisDeclaradas = new java.util.HashSet<>();

    // Método para verificar se uma variável já foi declarada
    private boolean jaFoiDeclarada(String nomeVariavel) {
        return variaveisDeclaradas.contains(nomeVariavel);
    }

    // Método para adicionar uma variável à lista
    private void declararVariavel(String nomeVariavel, int linha) {
        if (jaFoiDeclarada(nomeVariavel)) {
            System.err.println("❌ ERRO SEMÂNTICO na linha " + linha +
                             ": Variável '" + nomeVariavel + "' já foi declarada!");
        } else {
            variaveisDeclaradas.add(nomeVariavel);
            System.out.println("✅ Variável '" + nomeVariavel + "' declarada na linha " + linha);
        }
    }

    // Método para verificar se uma variável foi declarada antes de usar
    private void verificarDeclaracao(String nomeVariavel, int linha) {
        if (!jaFoiDeclarada(nomeVariavel)) {
            System.err.println("❌ ERRO SEMÂNTICO na linha " + linha +
                             ": Variável '" + nomeVariavel + "' não foi declarada!");
        }
    }

    // Método para limpar a lista (útil para múltiplas compilações)
    public void limparVariaveis() {
        variaveisDeclaradas.clear();
    }

    // Método para obter todas as variáveis declaradas
    public java.util.Set<String> getVariaveisDeclaradas() {
        return new java.util.HashSet<>(variaveisDeclaradas);
    }
}

// ============================================
// REGRAS DO PARSER COM AÇÕES JAVA
// ============================================

// --- REGRA INICIAL ---
programa
    : KW_INICIO
      { System.out.println("\n🔍 Iniciando análise do programa...\n"); }
      listaComandos
      KW_FIM
      {
          System.out.println("\n📊 Total de variáveis declaradas: " + variaveisDeclaradas.size());
          System.out.println("📋 Variáveis: " + variaveisDeclaradas);
      }
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

// --- DECLARAÇÃO COM VERIFICAÇÃO DE DUPLICATAS ---
declaracao
    : KW_DECLARE tipo IDENTIFICADOR
      {
          String nomeVar = $IDENTIFICADOR.text;
          int linha = $IDENTIFICADOR.line;
          declararVariavel(nomeVar, linha);
      }
      (OP_ATRIBUICAO expressao)? PONTO_VIRGULA
    ;

// --- TIPOS DE DADOS ---
tipo
    : KW_INTEIRO
    | KW_REAL
    | KW_TEXTO
    ;

// --- ATRIBUIÇÃO COM VERIFICAÇÃO DE DECLARAÇÃO ---
atribuicao
    : IDENTIFICADOR
      {
          String nomeVar = $IDENTIFICADOR.text;
          int linha = $IDENTIFICADOR.line;
          verificarDeclaracao(nomeVar, linha);
      }
      OP_ATRIBUICAO expressao PONTO_VIRGULA
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
      {
          String nomeVar = $IDENTIFICADOR.text;
          int linha = $IDENTIFICADOR.line;
          declararVariavel(nomeVar, linha);
      }
      (OP_ATRIBUICAO expressao)?
    ;

// Atribuição dentro do loop
atribuicaoLoop
    : IDENTIFICADOR
      {
          String nomeVar = $IDENTIFICADOR.text;
          int linha = $IDENTIFICADOR.line;
          verificarDeclaracao(nomeVar, linha);
      }
      OP_ATRIBUICAO expressao
    ;

// --- COMANDO DE LEITURA ---
comandoLeitura
    : KW_LEIA ABRE_PARENTESES IDENTIFICADOR
      {
          String nomeVar = $IDENTIFICADOR.text;
          int linha = $IDENTIFICADOR.line;
          verificarDeclaracao(nomeVar, linha);
      }
      FECHA_PARENTESES PONTO_VIRGULA
    ;

// --- COMANDO DE ESCRITA ---
comandoEscrita
    : KW_ESCREVA ABRE_PARENTESES expressao FECHA_PARENTESES PONTO_VIRGULA
    ;

// --- EXPRESSÕES ---

expressao
    : expressaoE (KW_OU expressaoE)*
    ;

expressaoE
    : expressaoRelacional (KW_E expressaoRelacional)*
    ;

expressaoRelacional
    : expressaoAditiva
    ;

expressaoAditiva
    : expressaoMultiplicativa ((OP_SOMA | OP_SUBTRACAO) expressaoMultiplicativa)*
    ;

expressaoMultiplicativa
    : expressaoUnaria ((OP_MULTIPLICACAO | OP_DIVISAO) expressaoUnaria)*
    ;

expressaoUnaria
    : KW_NAO expressaoUnaria
    | OP_SUBTRACAO expressaoUnaria
    | expressaoPrimaria
    ;

expressaoPrimaria
    : NUMERO_INTEIRO
    | NUMERO_REAL
    | TEXTO_LITERAL
    | IDENTIFICADOR
      {
          String nomeVar = $IDENTIFICADOR.text;
          int linha = $IDENTIFICADOR.line;
          verificarDeclaracao(nomeVar, linha);
      }
    | ABRE_PARENTESES expressao FECHA_PARENTESES
    ;
*/


/*

// Define a gramática do parser para a linguagem CompiladorLang
parser grammar CompiladorLangParser;

// Importa os tokens definidos no lexer
options {
    tokenVocab = CompiladorLangLexer;
}

// --- REGRA INICIAL: Um programa completo ---
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
    : KW_DECLARE tipo IDENTIFICADOR (OP_ATRIBUICAO expressao)? PONTO_VIRGULA
//    : KW_DECLARE tipo atribuicao
    ;

// --- TIPOS DE DADOS ---
tipo
    : KW_INTEIRO
    | KW_REAL
    | KW_TEXTO
    ;

// --- ATRIBUIÇÃO ---
atribuicao
    : IDENTIFICADOR OP_ATRIBUICAO expressao PONTO_VIRGULA
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
    : KW_DECLARE tipo IDENTIFICADOR (OP_ATRIBUICAO expressao)?
    ;

// Atribuição dentro do loop
atribuicaoLoop
    : IDENTIFICADOR OP_ATRIBUICAO expressao
    ;

// --- COMANDO DE LEITURA ---
comandoLeitura
    : KW_LEIA ABRE_PARENTESES IDENTIFICADOR FECHA_PARENTESES PONTO_VIRGULA
    ;

// --- COMANDO DE ESCRITA ---
comandoEscrita
    : KW_ESCREVA ABRE_PARENTESES expressao FECHA_PARENTESES PONTO_VIRGULA
    ;

// --- EXPRESSÕES ---

// Nível 1: OR lógico
expressao
    : expressaoE (KW_OU expressaoE)*
    ;

// Nível 2: AND lógico
expressaoE
    : expressaoRelacional (KW_E expressaoRelacional)*
    ;

// Nível 3: Operadores relacionais
expressaoRelacional
    : expressaoAditiva
    ;

// Nível 4: Adição e subtração
expressaoAditiva
    : expressaoMultiplicativa ((OP_SOMA | OP_SUBTRACAO) expressaoMultiplicativa)*
    ;

// Nível 5: Multiplicação e divisão
expressaoMultiplicativa
    : expressaoUnaria ((OP_MULTIPLICACAO | OP_DIVISAO) expressaoUnaria)*
    ;

// Nível 6: Operadores unários
expressaoUnaria
    : KW_NAO expressaoUnaria
    | OP_SUBTRACAO expressaoUnaria
    | expressaoPrimaria
    ;

// Nível 7: Expressões primárias
expressaoPrimaria
    : NUMERO_INTEIRO
    | NUMERO_REAL
    | TEXTO_LITERAL
    | IDENTIFICADOR
    | ABRE_PARENTESES expressao FECHA_PARENTESES
    ;

    */
