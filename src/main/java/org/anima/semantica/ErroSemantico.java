package org.anima.semantica;

public class ErroSemantico {
    private String mensagem;
    private int linha;
    private int coluna;
    private TipoErro tipo;

    public enum TipoErro {
        VARIAVEL_NAO_DECLARADA,
        VARIAVEL_JA_DECLARADA,
        TIPO_INCOMPATIVEL,
        VARIAVEL_NAO_INICIALIZADA,
        OPERACAO_INVALIDA
    }

    public ErroSemantico(String mensagem, int linha, int coluna, TipoErro tipo) {
        this.mensagem = mensagem;
        this.linha = linha;
        this.coluna = coluna;
        this.tipo = tipo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public TipoErro getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return String.format("❌ ERRO SEMÂNTICO na linha %d, coluna %d: %s",
                linha, coluna, mensagem);
    }
}
