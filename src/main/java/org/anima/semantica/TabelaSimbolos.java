package org.anima.semantica;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

public class TabelaSimbolos {
    private Map<String, Simbolo> simbolos;

    public TabelaSimbolos() {
        this.simbolos = new HashMap<>();
    }

    /**
     * Adiciona um símbolo à tabela
     * @return true se adicionou com sucesso, false se já existe
     */
    public boolean adicionar(Simbolo simbolo) {
        if (simbolos.containsKey(simbolo.getNome())) {
            return false;  // Símbolo já existe
        }
        simbolos.put(simbolo.getNome(), simbolo);
        return true;
    }

    /**
     * Verifica se um símbolo existe na tabela
     */
    public boolean existe(String nome) {
        return simbolos.containsKey(nome);
    }

    /**
     * Obtém um símbolo da tabela
     */
    public Simbolo obter(String nome) {
        return simbolos.get(nome);
    }

    /**
     * Atualiza o status de inicialização de uma variável
     */
    public void marcarInicializada(String nome) {
        Simbolo simbolo = simbolos.get(nome);
        if (simbolo != null) {
            simbolo.setInicializada(true);
        }
    }

    /**
     * Obtém todos os símbolos
     */
    public Collection<Simbolo> obterTodos() {
        return simbolos.values();
    }

    /**
     * Limpa a tabela
     */
    public void limpar() {
        simbolos.clear();
    }

    /**
     * Retorna o número de símbolos
     */
    public int tamanho() {
        return simbolos.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== TABELA DE SÍMBOLOS ===\n");
        for (Simbolo s : simbolos.values()) {
            sb.append(s.toString()).append("\n");
        }
        return sb.toString();
    }
}
