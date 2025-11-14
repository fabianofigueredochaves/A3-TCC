package org.anima.semantica;

public enum TipoSimbolo {
    INTEIRO("inteiro"),
    REAL("real"),
    TEXTO("texto"),
    BOOLEANO("booleano"),
    DESCONHECIDO("desconhecido") ;

    private final String nome;

    TipoSimbolo(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static TipoSimbolo fromString(String texto) {
        for (TipoSimbolo tipo : TipoSimbolo.values()) {
            if (tipo.nome.equalsIgnoreCase(texto)) {
                return tipo;
            }
        }
        return DESCONHECIDO;
    }

    @Override
    public String toString() {
        return nome;
    }
}
