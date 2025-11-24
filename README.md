# CompiladorLang - Linguagem de Programação

## 📋 Visão Geral

**CompiladorLang** é uma linguagem de programação educacional desenvolvida em português, que compila código-fonte para Java. A linguagem foi implementada utilizando ANTLR 4 para análise léxica e sintática, com análise semântica e geração de código Java.

## 🎯 Características Principais

- **Sintaxe em Português**: Palavras-chave e comandos em português brasileiro
- **Tipagem Estática**: Verificação de tipos em tempo de compilação
- **Compilação para Java**: Gera código Java executável
- **Análise Semântica**: Verifica compatibilidade de tipos e declarações
- **Estruturas de Controle**: Suporta condicionais e loops

## 📝 Tipos de Dados

A linguagem suporta três tipos primitivos:

- **`inteiro`**: Números inteiros (ex: `10`, `-5`, `100`)
- **`real`**: Números decimais (ex: `3.14`, `-2.5`, `10.0`)
- **`texto`**: Strings de caracteres (ex: `"Olá mundo"`, `"nome"`)

## 🔤 Sintaxe da Linguagem

### Estrutura de um Programa

Todo programa deve começar com `inicio` e terminar com `fim`:

```
inicio
    // comandos aqui
fim
```

### Declaração de Variáveis

```cpl
declare tipo nome;
declare tipo nome = valor;
```

**Exemplos:**
```cpl
declare inteiro idade;
declare real salario = 1500.50;
declare texto nome = "João";
```

### Atribuição

```cpl
nomeVariavel = expressao;
```

**Exemplos:**
```cpl
idade = 25;
salario = 2000.0;
nome = "Maria";
```

### Operadores Aritméticos

- `+` : Adição
- `-` : Subtração
- `*` : Multiplicação
- `/` : Divisão

**Exemplos:**
```cpl
resultado = 10 + 5;
resultado = 20 - 8;
resultado = 5 * 4;
resultado = 15 / 3;
```

### Operadores Relacionais

- `==` : Igual a
- `!=` : Diferente de
- `<` : Menor que
- `>` : Maior que
- `<=` : Menor ou igual a
- `>=` : Maior ou igual a

**Exemplos:**
```cpl
se (idade >= 18) entao {
    escreva("Maior de idade");
};
```

### Operadores Lógicos

- `e` : E lógico (AND)
- `ou` : OU lógico (OR)
- `nao` : NÃO lógico (NOT)

**Exemplos:**
```cpl
se (idade >= 18 e salario > 1000) entao {
    escreva("Condições atendidas");
};
```

### Estrutura Condicional

```cpl
se (expressao) entao {
    // comandos
};
```

```cpl
se (expressao) entao {
    // comandos se verdadeiro
} senao {
    // comandos se falso
};
```

**Exemplo:**
```cpl
se (idade >= 18) entao {
    escreva("Você é maior de idade");
} senao {
    escreva("Você é menor de idade");
};
```

### Estruturas de Repetição

#### Loop Enquanto

```cpl
enquanto (expressao) faca {
    // comandos
};
```

**Exemplo:**
```cpl
declare inteiro contador = 0;
enquanto (contador < 5) faca {
    escreva("Iteração: " + contador);
    contador = contador + 1;
};
```

#### Loop Para

```cpl
para (inicializacao; condicao; incremento) faca {
    // comandos
};
```

**Exemplo:**
```cpl
para (declare inteiro i = 0; i < 10; i = i + 1) faca {
    escreva("Valor: " + i);
};
```

### Comandos de Entrada e Saída

#### Leitura

```cpl
leia(variavel);
```

**Exemplo:**
```cpl
declare texto nome;
escreva("Digite seu nome: ");
leia(nome);
```

#### Escrita

```cpl
escreva(expressao);
```

**Exemplos:**
```cpl
escreva("Olá mundo");
escreva("Idade: " + idade);
escreva(10 + 5);
```

## 🔧 Compilação

### Pré-requisitos

- Java JDK 24 ou superior
- Maven 3.x

### Como Compilar

1. **Compilar o projeto:**
```bash
mvn clean compile
```

2. **Executar o compilador:**
```bash
java -cp target/classes org.anima.Main programa.cpl
```

O compilador irá:
1. Realizar análise léxica
2. Realizar análise sintática
3. Realizar análise semântica
4. Gerar o arquivo `ProgramaCompilado.java`

3. **Compilar o código Java gerado:**
```bash
javac ProgramaCompilado.java
```

4. **Executar o programa:**
```bash
java ProgramaCompilado
```

## 📊 Fases da Compilação

### 1. Análise Léxica
- Identifica tokens (palavras-chave, operadores, identificadores, literais)
- Remove espaços em branco e comentários

### 2. Análise Sintática
- Verifica se o código segue a gramática da linguagem
- Constrói a árvore sintática abstrata (AST)

### 3. Análise Semântica
- Verifica declaração de variáveis
- Verifica compatibilidade de tipos
- Constrói a tabela de símbolos
- Detecta erros semânticos

### 4. Geração de Código
- Gera código Java equivalente ao programa fonte
- Mantém a lógica e estrutura do programa original

## ⚠️ Regras Semânticas

- Variáveis devem ser declaradas antes do uso
- Não é permitida redeclaração de variáveis
- Tipos devem ser compatíveis em atribuições:
  - `inteiro` pode ser atribuído a `real`
  - `real` não pode ser atribuído a `inteiro` diretamente
  - `texto` só pode ser atribuído a variáveis do tipo `texto`
- Condições em estruturas de controle devem resultar em valores booleanos
- Operações aritméticas entre `inteiro` e `real` resultam em `real`
- Divisão de inteiros resulta em `real`

## 📁 Estrutura do Projeto

```
A3-TCC/
├── src/main/java/org/anima/
│   ├── Main.java                    # Ponto de entrada do compilador
│   ├── GeradorDeCodigoVisitor.java  # Geração de código Java
│   ├── antlr/                       # Gramáticas ANTLR
│   │   ├── CompiladorLangLexer.g4   # Gramática léxica
│   │   └── CompiladorLangParser.g4  # Gramática sintática
│   └── semantica/                   # Análise semântica
│       ├── AnalisadorSemantico.java
│       ├── TabelaSimbolos.java
│       ├── Simbolo.java
│       ├── TipoSimbolo.java
│       └── ErroSemantico.java
├── programa.cpl                     # Exemplo de programa fonte
├── ProgramaCompilado.java          # Código Java gerado
└── pom.xml                          # Configuração Maven
```

## 📝 Exemplo de Programa

```cpl
inicio
    declare inteiro idade;
    declare texto nome;
    declare real salario;
    
    escreva("Digite seu nome: ");
    leia(nome);
    
    escreva("Digite sua idade: ");
    leia(idade);
    
    escreva("Digite seu salário: ");
    leia(salario);
    
    escreva("Nome: " + nome);
    escreva("Idade: " + idade);
    escreva("Salário: " + salario);
    
    se (idade >= 18) entao {
        escreva("Você é maior de idade");
    } senao {
        escreva("Você é menor de idade");
    };
fim
```

## 🛠️ Tecnologias Utilizadas

- **ANTLR 4.13.2**: Geração de analisadores léxicos e sintáticos
- **Java 24**: Linguagem de implementação
- **Maven**: Gerenciamento de dependências e build

## 📄 Licença

Este projeto foi desenvolvido para fins educacionais como parte do trabalho A3 Teoria da Computação e Compiladores.

