// Generated from C:/Users/Raphael/IdeaProjects/A3-TCC/src/main/java/org/anima/antlr/CompiladorLangParser.g4 by ANTLR 4.13.2
package org.anima.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CompiladorLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CompiladorLangParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CompiladorLangParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(CompiladorLangParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompiladorLangParser#listaComandos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaComandos(CompiladorLangParser.ListaComandosContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompiladorLangParser#comando}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComando(CompiladorLangParser.ComandoContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompiladorLangParser#declaracao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao(CompiladorLangParser.DeclaracaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompiladorLangParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(CompiladorLangParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompiladorLangParser#atribuicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtribuicao(CompiladorLangParser.AtribuicaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompiladorLangParser#estruturaCondicional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEstruturaCondicional(CompiladorLangParser.EstruturaCondicionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompiladorLangParser#estruturaRepeticao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEstruturaRepeticao(CompiladorLangParser.EstruturaRepeticaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompiladorLangParser#loopEnquanto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopEnquanto(CompiladorLangParser.LoopEnquantoContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompiladorLangParser#loopPara}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopPara(CompiladorLangParser.LoopParaContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompiladorLangParser#inicializacaoLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicializacaoLoop(CompiladorLangParser.InicializacaoLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompiladorLangParser#incrementoLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncrementoLoop(CompiladorLangParser.IncrementoLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompiladorLangParser#declaracaoLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracaoLoop(CompiladorLangParser.DeclaracaoLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompiladorLangParser#atribuicaoLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtribuicaoLoop(CompiladorLangParser.AtribuicaoLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompiladorLangParser#comandoLeitura}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandoLeitura(CompiladorLangParser.ComandoLeituraContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompiladorLangParser#comandoEscrita}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandoEscrita(CompiladorLangParser.ComandoEscritaContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompiladorLangParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressao(CompiladorLangParser.ExpressaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompiladorLangParser#expressaoE}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressaoE(CompiladorLangParser.ExpressaoEContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompiladorLangParser#expressaoRelacional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressaoRelacional(CompiladorLangParser.ExpressaoRelacionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompiladorLangParser#expressaoAditiva}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressaoAditiva(CompiladorLangParser.ExpressaoAditivaContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompiladorLangParser#expressaoMultiplicativa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressaoMultiplicativa(CompiladorLangParser.ExpressaoMultiplicativaContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompiladorLangParser#expressaoUnaria}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressaoUnaria(CompiladorLangParser.ExpressaoUnariaContext ctx);
	/**
	 * Visit a parse tree produced by {@link CompiladorLangParser#expressaoPrimaria}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressaoPrimaria(CompiladorLangParser.ExpressaoPrimariaContext ctx);
}