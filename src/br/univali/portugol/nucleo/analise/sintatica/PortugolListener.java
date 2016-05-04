// Generated from Portugol.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PortugolParser}.
 */
public interface PortugolListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PortugolParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(PortugolParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(PortugolParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#inclusaoBiblioteca}.
	 * @param ctx the parse tree
	 */
	void enterInclusaoBiblioteca(PortugolParser.InclusaoBibliotecaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#inclusaoBiblioteca}.
	 * @param ctx the parse tree
	 */
	void exitInclusaoBiblioteca(PortugolParser.InclusaoBibliotecaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#declaracoesGlobais}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracoesGlobais(PortugolParser.DeclaracoesGlobaisContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#declaracoesGlobais}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracoesGlobais(PortugolParser.DeclaracoesGlobaisContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#declaracoesLocais}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracoesLocais(PortugolParser.DeclaracoesLocaisContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#declaracoesLocais}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracoesLocais(PortugolParser.DeclaracoesLocaisContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#listaDeclaracoes}.
	 * @param ctx the parse tree
	 */
	void enterListaDeclaracoes(PortugolParser.ListaDeclaracoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#listaDeclaracoes}.
	 * @param ctx the parse tree
	 */
	void exitListaDeclaracoes(PortugolParser.ListaDeclaracoesContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao(PortugolParser.DeclaracaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao(PortugolParser.DeclaracaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#declaracaoTipoDado}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracaoTipoDado(PortugolParser.DeclaracaoTipoDadoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#declaracaoTipoDado}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracaoTipoDado(PortugolParser.DeclaracaoTipoDadoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#declaracaoTipoDadoVazio}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracaoTipoDadoVazio(PortugolParser.DeclaracaoTipoDadoVazioContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#declaracaoTipoDadoVazio}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracaoTipoDadoVazio(PortugolParser.DeclaracaoTipoDadoVazioContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#quantificador}.
	 * @param ctx the parse tree
	 */
	void enterQuantificador(PortugolParser.QuantificadorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#quantificador}.
	 * @param ctx the parse tree
	 */
	void exitQuantificador(PortugolParser.QuantificadorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#tipoRetornoFuncao}.
	 * @param ctx the parse tree
	 */
	void enterTipoRetornoFuncao(PortugolParser.TipoRetornoFuncaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#tipoRetornoFuncao}.
	 * @param ctx the parse tree
	 */
	void exitTipoRetornoFuncao(PortugolParser.TipoRetornoFuncaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#declaracaoFuncao}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracaoFuncao(PortugolParser.DeclaracaoFuncaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#declaracaoFuncao}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracaoFuncao(PortugolParser.DeclaracaoFuncaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#listaParametrosFuncao}.
	 * @param ctx the parse tree
	 */
	void enterListaParametrosFuncao(PortugolParser.ListaParametrosFuncaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#listaParametrosFuncao}.
	 * @param ctx the parse tree
	 */
	void exitListaParametrosFuncao(PortugolParser.ListaParametrosFuncaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#declaracaoParametro}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracaoParametro(PortugolParser.DeclaracaoParametroContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#declaracaoParametro}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracaoParametro(PortugolParser.DeclaracaoParametroContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#blocos}.
	 * @param ctx the parse tree
	 */
	void enterBlocos(PortugolParser.BlocosContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#blocos}.
	 * @param ctx the parse tree
	 */
	void exitBlocos(PortugolParser.BlocosContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(PortugolParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(PortugolParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#para}.
	 * @param ctx the parse tree
	 */
	void enterPara(PortugolParser.ParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#para}.
	 * @param ctx the parse tree
	 */
	void exitPara(PortugolParser.ParaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#inicializacaoPara}.
	 * @param ctx the parse tree
	 */
	void enterInicializacaoPara(PortugolParser.InicializacaoParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#inicializacaoPara}.
	 * @param ctx the parse tree
	 */
	void exitInicializacaoPara(PortugolParser.InicializacaoParaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#listaBlocos}.
	 * @param ctx the parse tree
	 */
	void enterListaBlocos(PortugolParser.ListaBlocosContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#listaBlocos}.
	 * @param ctx the parse tree
	 */
	void exitListaBlocos(PortugolParser.ListaBlocosContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#pare}.
	 * @param ctx the parse tree
	 */
	void enterPare(PortugolParser.PareContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#pare}.
	 * @param ctx the parse tree
	 */
	void exitPare(PortugolParser.PareContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#escolha}.
	 * @param ctx the parse tree
	 */
	void enterEscolha(PortugolParser.EscolhaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#escolha}.
	 * @param ctx the parse tree
	 */
	void exitEscolha(PortugolParser.EscolhaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#blocosCaso}.
	 * @param ctx the parse tree
	 */
	void enterBlocosCaso(PortugolParser.BlocosCasoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#blocosCaso}.
	 * @param ctx the parse tree
	 */
	void exitBlocosCaso(PortugolParser.BlocosCasoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#enquanto}.
	 * @param ctx the parse tree
	 */
	void enterEnquanto(PortugolParser.EnquantoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#enquanto}.
	 * @param ctx the parse tree
	 */
	void exitEnquanto(PortugolParser.EnquantoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#facaEnquanto}.
	 * @param ctx the parse tree
	 */
	void enterFacaEnquanto(PortugolParser.FacaEnquantoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#facaEnquanto}.
	 * @param ctx the parse tree
	 */
	void exitFacaEnquanto(PortugolParser.FacaEnquantoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#se}.
	 * @param ctx the parse tree
	 */
	void enterSe(PortugolParser.SeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#se}.
	 * @param ctx the parse tree
	 */
	void exitSe(PortugolParser.SeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#retorne}.
	 * @param ctx the parse tree
	 */
	void enterRetorne(PortugolParser.RetorneContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#retorne}.
	 * @param ctx the parse tree
	 */
	void exitRetorne(PortugolParser.RetorneContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterExpressao(PortugolParser.ExpressaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitExpressao(PortugolParser.ExpressaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#tipoPrimitivo}.
	 * @param ctx the parse tree
	 */
	void enterTipoPrimitivo(PortugolParser.TipoPrimitivoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#tipoPrimitivo}.
	 * @param ctx the parse tree
	 */
	void exitTipoPrimitivo(PortugolParser.TipoPrimitivoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#referencia}.
	 * @param ctx the parse tree
	 */
	void enterReferencia(PortugolParser.ReferenciaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#referencia}.
	 * @param ctx the parse tree
	 */
	void exitReferencia(PortugolParser.ReferenciaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#referenciaVetorMatriz}.
	 * @param ctx the parse tree
	 */
	void enterReferenciaVetorMatriz(PortugolParser.ReferenciaVetorMatrizContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#referenciaVetorMatriz}.
	 * @param ctx the parse tree
	 */
	void exitReferenciaVetorMatriz(PortugolParser.ReferenciaVetorMatrizContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#chamadaFuncao}.
	 * @param ctx the parse tree
	 */
	void enterChamadaFuncao(PortugolParser.ChamadaFuncaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#chamadaFuncao}.
	 * @param ctx the parse tree
	 */
	void exitChamadaFuncao(PortugolParser.ChamadaFuncaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#listaParametros}.
	 * @param ctx the parse tree
	 */
	void enterListaParametros(PortugolParser.ListaParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#listaParametros}.
	 * @param ctx the parse tree
	 */
	void exitListaParametros(PortugolParser.ListaParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#matrizVetor}.
	 * @param ctx the parse tree
	 */
	void enterMatrizVetor(PortugolParser.MatrizVetorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#matrizVetor}.
	 * @param ctx the parse tree
	 */
	void exitMatrizVetor(PortugolParser.MatrizVetorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#vetor}.
	 * @param ctx the parse tree
	 */
	void enterVetor(PortugolParser.VetorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#vetor}.
	 * @param ctx the parse tree
	 */
	void exitVetor(PortugolParser.VetorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#matriz}.
	 * @param ctx the parse tree
	 */
	void enterMatriz(PortugolParser.MatrizContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#matriz}.
	 * @param ctx the parse tree
	 */
	void exitMatriz(PortugolParser.MatrizContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#listaListaExpressoes}.
	 * @param ctx the parse tree
	 */
	void enterListaListaExpressoes(PortugolParser.ListaListaExpressoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#listaListaExpressoes}.
	 * @param ctx the parse tree
	 */
	void exitListaListaExpressoes(PortugolParser.ListaListaExpressoesContext ctx);
	/**
	 * Enter a parse tree produced by {@link PortugolParser#listaExpressoes}.
	 * @param ctx the parse tree
	 */
	void enterListaExpressoes(PortugolParser.ListaExpressoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link PortugolParser#listaExpressoes}.
	 * @param ctx the parse tree
	 */
	void exitListaExpressoes(PortugolParser.ListaExpressoesContext ctx);
}