// Generated from C:\Users\4276663\Desktop\Git\Portugol-Nucleo\src\br\u005Cunivali\portugol\nucleo\analise\sintatica\Portugol.g4 by ANTLR 4.1
package br.univali.portugol.nucleo.analise.sintatica;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PortugolParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PortugolVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PortugolParser#matrizVetor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatrizVetor(@NotNull PortugolParser.MatrizVetorContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#declaracaoTipoDadoVazio}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracaoTipoDadoVazio(@NotNull PortugolParser.DeclaracaoTipoDadoVazioContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#enquanto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnquanto(@NotNull PortugolParser.EnquantoContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#chamadaFuncao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChamadaFuncao(@NotNull PortugolParser.ChamadaFuncaoContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#bloco}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloco(@NotNull PortugolParser.BlocoContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#listaBlocos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaBlocos(@NotNull PortugolParser.ListaBlocosContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#referenciaVetorMatriz}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenciaVetorMatriz(@NotNull PortugolParser.ReferenciaVetorMatrizContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#declaracaoParametro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracaoParametro(@NotNull PortugolParser.DeclaracaoParametroContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#listaExpressoes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaExpressoes(@NotNull PortugolParser.ListaExpressoesContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(@NotNull PortugolParser.ProgramaContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#listaParametros}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaParametros(@NotNull PortugolParser.ListaParametrosContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressao(@NotNull PortugolParser.ExpressaoContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#retorne}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetorne(@NotNull PortugolParser.RetorneContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#matriz}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatriz(@NotNull PortugolParser.MatrizContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#pare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPare(@NotNull PortugolParser.PareContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#se}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSe(@NotNull PortugolParser.SeContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#inclusaoBiblioteca}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclusaoBiblioteca(@NotNull PortugolParser.InclusaoBibliotecaContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#para}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPara(@NotNull PortugolParser.ParaContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#pilha}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPilha(@NotNull PortugolParser.PilhaContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#listaListaExpressoes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaListaExpressoes(@NotNull PortugolParser.ListaListaExpressoesContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#blocosCaso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlocosCaso(@NotNull PortugolParser.BlocosCasoContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#listaParametrosFuncao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaParametrosFuncao(@NotNull PortugolParser.ListaParametrosFuncaoContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#referenciaId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenciaId(@NotNull PortugolParser.ReferenciaIdContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#tipoRetornoFuncao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoRetornoFuncao(@NotNull PortugolParser.TipoRetornoFuncaoContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#expressao8}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressao8(@NotNull PortugolParser.Expressao8Context ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#blocos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlocos(@NotNull PortugolParser.BlocosContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#expressao7}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressao7(@NotNull PortugolParser.Expressao7Context ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#quantificador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantificador(@NotNull PortugolParser.QuantificadorContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#expressao4_5}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressao4_5(@NotNull PortugolParser.Expressao4_5Context ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#expressao6}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressao6(@NotNull PortugolParser.Expressao6Context ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#expressao3_5}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressao3_5(@NotNull PortugolParser.Expressao3_5Context ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#expressao2_5}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressao2_5(@NotNull PortugolParser.Expressao2_5Context ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#vetor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVetor(@NotNull PortugolParser.VetorContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#declaracoesLocais}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracoesLocais(@NotNull PortugolParser.DeclaracoesLocaisContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#tipoPrimitivo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoPrimitivo(@NotNull PortugolParser.TipoPrimitivoContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#listaDeclaracoes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaDeclaracoes(@NotNull PortugolParser.ListaDeclaracoesContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#expressao5}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressao5(@NotNull PortugolParser.Expressao5Context ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#declaracaoTipoDado}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracaoTipoDado(@NotNull PortugolParser.DeclaracaoTipoDadoContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#expressao3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressao3(@NotNull PortugolParser.Expressao3Context ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#expressao2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressao2(@NotNull PortugolParser.Expressao2Context ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#escolha}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEscolha(@NotNull PortugolParser.EscolhaContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#inicializacaoPara}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicializacaoPara(@NotNull PortugolParser.InicializacaoParaContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#declaracao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao(@NotNull PortugolParser.DeclaracaoContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#declaracaoFuncao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracaoFuncao(@NotNull PortugolParser.DeclaracaoFuncaoContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#facaEnquanto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFacaEnquanto(@NotNull PortugolParser.FacaEnquantoContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#referencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferencia(@NotNull PortugolParser.ReferenciaContext ctx);

	/**
	 * Visit a parse tree produced by {@link PortugolParser#declaracoesGlobais}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracoesGlobais(@NotNull PortugolParser.DeclaracoesGlobaisContext ctx);
}