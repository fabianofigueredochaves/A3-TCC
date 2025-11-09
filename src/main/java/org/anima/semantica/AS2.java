/*


private TipoSimbolo inferirTipoOperacao(TipoSimbolo tipo1, TipoSimbolo tipo2,
                                        String operador, int linha) {
    return TipoSimbolo.DESCONHECIDO;
}

// Operador + pode concatenar strings
    if (operador.equals("+")) {
        return TipoSimbolo.TEXTO;
        }

                return TipoSimbolo.REAL;
        }


                }

                // Operadores -, *, /
                erros.add(new ErroSemantico(
        String.format("Operação '%s' inválida com tipo texto", operador),
linha,
        0,
ErroSemantico.TipoErro.OPERACAO_INVALIDA
            ));
                    return TipoSimbolo.DESCONHECIDO;
        }

                return TipoSimbolo.REAL;
        }

                if (tipo1 == TipoSimbolo.INTEIRO && tipo2 == TipoSimbolo.INTEIRO) {
        // Divisão sempre retorna real
        if (operador.equals("/")) {
        return TipoSimbolo.REAL;
            }
                    return TipoSimbolo.INTEIRO;
        }
                }

                erros.add(new ErroSemantico(
        String.format("Operação '%s' inválida entre %s e %s", operador, tipo1, tipo2),
linha,
        0,
ErroSemantico.TipoErro.OPERACAO_INVALIDA
    ));

            return TipoSimbolo.DESCONHECIDO;
}


private TipoSimbolo inferirTipoComparacao(TipoSimbolo tipo1, TipoSimbolo tipo2,
                                          String operador, int linha) {
    return TipoSimbolo.INTEIRO;
}

        return TipoSimbolo.INTEIRO;
    }

            if (tipo1 == TipoSimbolo.TEXTO && tipo2 == TipoSimbolo.TEXTO) {
        return TipoSimbolo.INTEIRO;
        } else {
                erros.add(new ErroSemantico(
                                  String.format("Operador '%s' não pode ser usado com tipo texto. Use apenas == ou !=",
                          operador),
linha,
        0,
ErroSemantico.TipoErro.OPERACAO_INVALIDA
            ));
                    return TipoSimbolo.DESCONHECIDO;
        }
                }

                erros.add(new ErroSemantico(
        String.format("Não é possível comparar %s com %s", tipo1, tipo2),
linha,
        0,
ErroSemantico.TipoErro.OPERACAO_INVALIDA
    ));

            return TipoSimbolo.DESCONHECIDO;
}

*/