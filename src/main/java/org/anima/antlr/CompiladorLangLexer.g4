
// Define a gramática para a linguagem CompiladorLang
// O 'lexer grammar' indica que esta é uma gramática para o lexer
lexer grammar CompiladorLangLexer;

// --- Palavras-chave ---
KW_INICIO : 'inicio';
KW_FIM : 'fim';
KW_DECLARE : 'declare';
KW_INTEIRO : 'inteiro';
KW_REAL : 'real';
KW_TEXTO : 'texto';
KW_SE : 'se';
KW_ENTAO : 'entao';
KW_SENAO : 'senao';
KW_ENQUANTO : 'enquanto';
KW_PARA : 'para';
KW_FACA : 'faca';
KW_LEIA : 'leia';
KW_ESCREVA : 'escreva';
KW_E : 'e';
KW_OU : 'ou';
KW_NAO : 'nao';

// --- Operadores Aritméticos ---
OP_SOMA : '+';
OP_SUBTRACAO : '-';
OP_MULTIPLICACAO : '*';
OP_DIVISAO : '/';

// --- Operador de Atribuição ---
OP_ATRIBUICAO : '=';

// --- Operadores Relacionais ---
OP_IGUAL : '==';
OP_DIFERENTE : '!=';
OP_MENOR : '<';
OP_MAIOR : '>';
OP_MENOR_IGUAL : '<=';
OP_MAIOR_IGUAL : '>=';

// --- Delimitadores e Símbolos ---
ABRE_PARENTESES : '(';
FECHA_PARENTESES : ')';
ABRE_CHAVES : '{';
FECHA_CHAVES : '}';
PONTO_VIRGULA : ';';
VIRGULA : ',';

// --- Literais ---

// Número Real (deve vir ANTES do inteiro)
NUMERO_REAL : DIGITO+ '.' DIGITO+;

// Número Inteiro
NUMERO_INTEIRO : DIGITO+;


TEXTO_LITERAL : '"' ~["\r\n]* '"';

IDENTIFICADOR : [a-zA-Z] [a-zA-Z0-9_]*;
//IDENTIFICADOR : [a-zA-Z]*;


// --- Espaços em Branco (ignorar) ---
WS : [ \t\r\n]+ -> skip;

// --- Comentários ---
//COMENTARIO_LINHA : '//' ~[\r\n]* -> skip;
COMENTARIO_LINHA : '//' ~('\r' | '\n')* ('\r'? '\\n')? -> skip;
// --- Fragmentos (auxiliares) ---
fragment LETRA : [a-zA-Z];
fragment DIGITO : [0-9];