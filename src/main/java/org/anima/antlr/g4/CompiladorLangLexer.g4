// Define a gramática para a linguagem CompiladorLang
// O 'lexer grammar' indica que esta é uma gramática para o lexer
lexer grammar CompiladorLang;

// --- 1. Palavras-chave (Keywords) ---
// As palavras-chave são definidas como tokens individuais.
// A ordem pode importar para algumas ambiguidades, mas aqui é simples.
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

// --- 2. Operadores Aritméticos ---
OP_SOMA : '+';
OP_SUBTRACAO : '-';
OP_MULTIPLICACAO : '*';
OP_DIVISAO : '/';

// --- 3. Operador de Atribuição ---
OP_ATRIBUICAO : '=';

// --- 4. Operadores Relacionais ---
OP_IGUAL : '==';
OP_DIFERENTE : '!=';
OP_MENOR : '<';
OP_MAIOR : '>';
OP_MENOR_IGUAL : '<=';
OP_MAIOR_IGUAL : '>=';

// --- 5. Delimitadores e Símbolos ---
ABRE_PARENTESES : '(';
FECHA_PARENTESES : ')';
ABRE_CHAVES : '{';
FECHA_CHAVES : '}';
PONTO_VIRGULA : ';';
VIRGULA : ',';

// --- 6. Literais ---
// Identificadores: Começa com letra, seguido de letras, números ou underscore.
// IMPORTANTE: Definir ID antes de KW, para que AntLR priorize as palavras-chave
// Se um token se parece com uma palavra-chave, mas é um ID, o AntLR priorizará a regra que aparece primeiro.
// No entanto, é mais comum o AntLR resolver tokens maiores primeiro.
// Para garantir que KW_INICIO seja 'inicio' e não um ID, as regras de KW devem vir antes do ID ou
// o AntLR usa a regra do \"match mais longo\" por padrão. Para gramáticas com palavras-chave,
// o AntLR resolve o problema naturalmente se as keywords forem listadas.
// Vamos colocar aqui a definição do ID, pois o AntLR tem um comportamento de \"longest match wins\",
// o que significa que 'inicio' será tokenizado como KW_INICIO e não como ID.

// Número Real: Aceita dígitos, ponto e dígitos.
// Ex: 3.14, 0.5, 123.0
// É importante definir o NUMERO_REAL antes do NUMERO_INTEIRO para que '123.0' não seja tokenizado como '123' (INTEIRO) e '.0' (outro token)
NUMERO_REAL : DIGITO+ '.' DIGITO+;

// Número Inteiro: Uma sequência de um ou mais dígitos.
// Ex: 123, 0, 42
NUMERO_INTEIRO : DIGITO+;

// Texto Literal (String): Qualquer coisa entre aspas duplas, escapando aspas internas.
// '\\"' permite incluir uma aspa dentro do texto.


/////////TEXTO_LITERAL : '\"' (~'\"' | '\\"')* '\"';


// --- 7. Espaços em Branco (ignorar) ---
// Espaços, tabulações, quebras de linha.
// O comando '-> skip' faz com que esses tokens sejam ignorados pelo parser.

// --- 8. Comentários (opcional, mas boa prática) ---
// Comentário de linha única, começando com '//' e indo até o final da linha.

/////////COMENTARIO_LINHA : '//' ~('\r' | '\\n')* ('\r'? '\\n')? -> skip;

// --- 9. Regras base para Identificador e Números (fragmentos) ---
// Fragments são partes de regras que não se tornam tokens por si só,
// mas são usadas para construir outras regras.
fragment LETRA : ('a'..'z' | 'A'..'Z');
fragment DIGITO : '0'..'9';