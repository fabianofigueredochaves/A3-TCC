
package org.anima.semantica;

public class Simbolo {
    private String nome;
    private TipoSimbolo tipo;
    private boolean inicializada;
    private int linha;

    public Simbolo(String nome, TipoSimbolo tipo, int linha) {
        this.nome = nome;
        this.tipo = tipo;
        this.inicializada = false;
        this.linha = linha;
    }

    public Simbolo(String nome, TipoSimbolo tipo, boolean inicializada, int linha) {
        this.nome = nome;
        this.tipo = tipo;
        this.inicializada = inicializada;
        this.linha = linha;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public TipoSimbolo getTipo() {
        return tipo;
    }

    public boolean isInicializada() {
        return inicializada;
    }

    public void setInicializada(boolean inicializada) {
        this.inicializada = inicializada;
    }

    public int getLinha() {
        return linha;
    }

    @Override
    public String toString() {
        return String.format("Simbolo{nome='%s', tipo=%s, inicializada=%s, linha=%d}",
                nome, tipo, inicializada, linha);
    }
}
