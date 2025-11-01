// Define a gramática do parser para a linguagem CompiladorLang
parser grammar CompiladorLangParser;

// Importa os tokens definidos no lexer
options {
    tokenVocab = CompiladorLangLexer;
}

// --- REGRA INICIAL: Um programa completo ---
// Todo programa começa com 'inicio', tem uma lista de comandos, e termina com 'fim'
programa
    : KW_INICIO listaComandos KW_FIM
    ;

// --- LISTA DE COMANDOS ---
// Um programa pode ter zero ou mais comandos
listaComandos
    : comando*
    ;

// --- COMANDO ---
// Um comando pode ser uma das seguintes opções:
comando
    : declaracao
    | atribuicao
    | estruturaCondicional
    | estruturaRepeticao
    | comandoLeitura
    | comandoEscrita
    ;

// --- DECLARAÇÃO DE VARIÁVEL ---
// Sintaxe: declare <tipo> <identificador>;
// ou: declare <tipo> <identificador> = <expressao>;
declaracao
    : KW_DECLARE tipo IDENTIFICADOR (OP_ATRIBUICAO expressao)? PONTO_VIRGULA
    ;

// --- TIPOS DE DADOS ---
tipo
    : KW_INTEIRO
    | KW_REAL
    | KW_TEXTO
    ;

// --- ATRIBUIÇÃO ---
// Sintaxe: <identificador> = <expressao>;
atribuicao
    : IDENTIFICADOR OP_ATRIBUICAO expressao PONTO_VIRGULA
    ;

// --- ESTRUTURA CONDICIONAL (if...else) ---
// Sintaxe: se (<condicao>) entao { <comandos> } senao { <comandos> };
// O bloco 'senao' é opcional
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

// Loop ENQUANTO (while)
// Sintaxe: enquanto (<condicao>) faca { <comandos> };
loopEnquanto
    : KW_ENQUANTO ABRE_PARENTESES expressao FECHA_PARENTESES
      KW_FACA ABRE_CHAVES listaComandos FECHA_CHAVES PONTO_VIRGULA
    ;

// Loop PARA (for)
// Sintaxe: para (<inicializacao>; <condicao>; <incremento>) faca { <comandos> };
// A inicialização pode ser uma declaração ou atribuição
loopPara
    : KW_PARA ABRE_PARENTESES
      (declaracaoLoop | atribuicaoLoop) PONTO_VIRGULA
      expressao PONTO_VIRGULA
      atribuicaoLoop
      FECHA_PARENTESES
      KW_FACA ABRE_CHAVES listaComandos FECHA_CHAVES PONTO_VIRGULA
    ;

// Declaração dentro do loop 'para' (sem ponto e vírgula no final)
declaracaoLoop
    : KW_DECLARE tipo IDENTIFICADOR (OP_ATRIBUICAO expressao)?
    ;

// Atribuição dentro do loop 'para' (sem ponto e vírgula no final)
atribuicaoLoop
    : IDENTIFICADOR OP_ATRIBUICAO expressao
    ;

// --- COMANDO DE LEITURA (scanf) ---
// Sintaxe: leia(<identificador>);
comandoLeitura
    : KW_LEIA ABRE_PARENTESES IDENTIFICADOR FECHA_PARENTESES PONTO_VIRGULA
    ;

// --- COMANDO DE ESCRITA (printf) ---
// Sintaxe: escreva(<expressao>);
comandoEscrita
    : KW_ESCREVA ABRE_PARENTESES expressao FECHA_PARENTESES PONTO_VIRGULA
    ;

// --- EXPRESSÕES ---
// Esta é a parte mais importante para garantir a precedência correta dos operadores

// Expressão de nível mais alto: Operadores lógicos OR (menor precedência)
expressao
    : expressaoE (KW_OU expressaoE)*
    ;

// Operadores lógicos AND
expressaoE
    : expressaoRelacional (KW_E expressaoRelacional)*
    ;

// Operadores relacionais (==, !=, <, >, <=, >=)
expressaoRelacional
    : expressaoAditiva
        expressaoAditiva
      )?
    ;

// Operadores aditivos (+ e -)
expressaoAditiva
    : expressaoMultiplicativa ((OP_SOMA | OP_SUBTRACAO) expressaoMultiplicativa)*
    ;

// Operadores multiplicativos (* e /)
expressaoMultiplicativa
    : expressaoUnaria ((OP_MULTIPLICACAO | OP_DIVISAO) expressaoUnaria)*
    ;

// Expressões unárias (NOT lógico, negativo)
expressaoUnaria
    : KW_NAO expressaoUnaria
    | OP_SUBTRACAO expressaoUnaria
    | expressaoPrimaria
    ;

// Expressões primárias (valores básicos e parênteses)
expressaoPrimaria
    : NUMERO_INTEIRO
    | NUMERO_REAL
    | TEXTO_LITERAL
    | IDENTIFICADOR
    | ABRE_PARENTESES expressao FECHA_PARENTESES
    ;