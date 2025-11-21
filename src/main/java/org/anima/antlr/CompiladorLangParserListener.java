// Generated from /home/fabiano/IdeaProjects/A3-TCC/src/main/java/org/anima/antlr/CompiladorLangParser.g4 by ANTLR 4.13.2
package org.anima.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CompiladorLangParser}.
 */
public interface CompiladorLangParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CompiladorLangParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(CompiladorLangParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompiladorLangParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(CompiladorLangParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompiladorLangParser#listaComandos}.
	 * @param ctx the parse tree
	 */
	void enterListaComandos(CompiladorLangParser.ListaComandosContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompiladorLangParser#listaComandos}.
	 * @param ctx the parse tree
	 */
	void exitListaComandos(CompiladorLangParser.ListaComandosContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompiladorLangParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterComando(CompiladorLangParser.ComandoContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompiladorLangParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitComando(CompiladorLangParser.ComandoContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompiladorLangParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao(CompiladorLangParser.DeclaracaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompiladorLangParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao(CompiladorLangParser.DeclaracaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompiladorLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(CompiladorLangParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompiladorLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(CompiladorLangParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompiladorLangParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void enterAtribuicao(CompiladorLangParser.AtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompiladorLangParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void exitAtribuicao(CompiladorLangParser.AtribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompiladorLangParser#estruturaCondicional}.
	 * @param ctx the parse tree
	 */
	void enterEstruturaCondicional(CompiladorLangParser.EstruturaCondicionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompiladorLangParser#estruturaCondicional}.
	 * @param ctx the parse tree
	 */
	void exitEstruturaCondicional(CompiladorLangParser.EstruturaCondicionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompiladorLangParser#estruturaRepeticao}.
	 * @param ctx the parse tree
	 */
	void enterEstruturaRepeticao(CompiladorLangParser.EstruturaRepeticaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompiladorLangParser#estruturaRepeticao}.
	 * @param ctx the parse tree
	 */
	void exitEstruturaRepeticao(CompiladorLangParser.EstruturaRepeticaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompiladorLangParser#loopEnquanto}.
	 * @param ctx the parse tree
	 */
	void enterLoopEnquanto(CompiladorLangParser.LoopEnquantoContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompiladorLangParser#loopEnquanto}.
	 * @param ctx the parse tree
	 */
	void exitLoopEnquanto(CompiladorLangParser.LoopEnquantoContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompiladorLangParser#loopPara}.
	 * @param ctx the parse tree
	 */
	void enterLoopPara(CompiladorLangParser.LoopParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompiladorLangParser#loopPara}.
	 * @param ctx the parse tree
	 */
	void exitLoopPara(CompiladorLangParser.LoopParaContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompiladorLangParser#inicializacaoLoop}.
	 * @param ctx the parse tree
	 */
	void enterInicializacaoLoop(CompiladorLangParser.InicializacaoLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompiladorLangParser#inicializacaoLoop}.
	 * @param ctx the parse tree
	 */
	void exitInicializacaoLoop(CompiladorLangParser.InicializacaoLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompiladorLangParser#incrementoLoop}.
	 * @param ctx the parse tree
	 */
	void enterIncrementoLoop(CompiladorLangParser.IncrementoLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompiladorLangParser#incrementoLoop}.
	 * @param ctx the parse tree
	 */
	void exitIncrementoLoop(CompiladorLangParser.IncrementoLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompiladorLangParser#declaracaoLoop}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracaoLoop(CompiladorLangParser.DeclaracaoLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompiladorLangParser#declaracaoLoop}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracaoLoop(CompiladorLangParser.DeclaracaoLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompiladorLangParser#atribuicaoLoop}.
	 * @param ctx the parse tree
	 */
	void enterAtribuicaoLoop(CompiladorLangParser.AtribuicaoLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompiladorLangParser#atribuicaoLoop}.
	 * @param ctx the parse tree
	 */
	void exitAtribuicaoLoop(CompiladorLangParser.AtribuicaoLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompiladorLangParser#comandoLeitura}.
	 * @param ctx the parse tree
	 */
	void enterComandoLeitura(CompiladorLangParser.ComandoLeituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompiladorLangParser#comandoLeitura}.
	 * @param ctx the parse tree
	 */
	void exitComandoLeitura(CompiladorLangParser.ComandoLeituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompiladorLangParser#comandoEscrita}.
	 * @param ctx the parse tree
	 */
	void enterComandoEscrita(CompiladorLangParser.ComandoEscritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompiladorLangParser#comandoEscrita}.
	 * @param ctx the parse tree
	 */
	void exitComandoEscrita(CompiladorLangParser.ComandoEscritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompiladorLangParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterExpressao(CompiladorLangParser.ExpressaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompiladorLangParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitExpressao(CompiladorLangParser.ExpressaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompiladorLangParser#expressaoE}.
	 * @param ctx the parse tree
	 */
	void enterExpressaoE(CompiladorLangParser.ExpressaoEContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompiladorLangParser#expressaoE}.
	 * @param ctx the parse tree
	 */
	void exitExpressaoE(CompiladorLangParser.ExpressaoEContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompiladorLangParser#expressaoRelacional}.
	 * @param ctx the parse tree
	 */
	void enterExpressaoRelacional(CompiladorLangParser.ExpressaoRelacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompiladorLangParser#expressaoRelacional}.
	 * @param ctx the parse tree
	 */
	void exitExpressaoRelacional(CompiladorLangParser.ExpressaoRelacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompiladorLangParser#expressaoAditiva}.
	 * @param ctx the parse tree
	 */
	void enterExpressaoAditiva(CompiladorLangParser.ExpressaoAditivaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompiladorLangParser#expressaoAditiva}.
	 * @param ctx the parse tree
	 */
	void exitExpressaoAditiva(CompiladorLangParser.ExpressaoAditivaContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompiladorLangParser#expressaoMultiplicativa}.
	 * @param ctx the parse tree
	 */
	void enterExpressaoMultiplicativa(CompiladorLangParser.ExpressaoMultiplicativaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompiladorLangParser#expressaoMultiplicativa}.
	 * @param ctx the parse tree
	 */
	void exitExpressaoMultiplicativa(CompiladorLangParser.ExpressaoMultiplicativaContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompiladorLangParser#expressaoUnaria}.
	 * @param ctx the parse tree
	 */
	void enterExpressaoUnaria(CompiladorLangParser.ExpressaoUnariaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompiladorLangParser#expressaoUnaria}.
	 * @param ctx the parse tree
	 */
	void exitExpressaoUnaria(CompiladorLangParser.ExpressaoUnariaContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompiladorLangParser#expressaoPrimaria}.
	 * @param ctx the parse tree
	 */
	void enterExpressaoPrimaria(CompiladorLangParser.ExpressaoPrimariaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompiladorLangParser#expressaoPrimaria}.
	 * @param ctx the parse tree
	 */
	void exitExpressaoPrimaria(CompiladorLangParser.ExpressaoPrimariaContext ctx);
}