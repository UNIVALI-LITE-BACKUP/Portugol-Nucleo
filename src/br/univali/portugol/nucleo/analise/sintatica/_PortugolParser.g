/*
	Se você utilizar o ANTLRWorks para compilar a gramática, execute-o com um mínimo de
	512MB de memória alocada para evitar travamentos ao editar e compilar.
	
	Para alterar a quantidade de RAM alocada utilize o parâmetro -xms na linha de comando.
	Ex.: java -jar "antlrworks-1.4.3.jar" -xms512
*/

parser grammar PortugolParser;

options
{
	tokenVocab = PortugolLexer;
}

@header
{
	package br.univali.portugol.nucleo.analise.sintatica;
	
	import org.antlr.runtime.Token;
	import br.univali.portugol.nucleo.asa.*;

}

@members
{
	private int quantidadeErros = 0;
	private Stack<String> pilhaContexto = new Stack<String>();
	private List<TradutorErrosSintaticos> tradutores  = new ArrayList<TradutorErrosSintaticos>();
	
	public void adicionarTradutorErros(TradutorErrosSintaticos tradutorErrosSintaticos)
	{
		if (!tradutores.contains(tradutorErrosSintaticos))
			tradutores.add(tradutorErrosSintaticos);
	}
	
	public void removerTradutorErros(TradutorErrosSintaticos tradutorErrosSintaticos)
	{
		tradutores.remove(tradutorErrosSintaticos);
	}

	@Override
	public void displayRecognitionError(String[] tokenNames, RecognitionException e)
	{
		quantidadeErros = quantidadeErros + 1;
		
		for (TradutorErrosSintaticos tradutor: tradutores)
			tradutor.traduzirErroSintatico(pilhaContexto, e, tokenNames);
	}
	
	private class InformacaoTipoDado
	{
		private TipoDado tipoDado;
		private TrechoCodigoFonte trechoCodigoFonte;
		
		public InformacaoTipoDado()
		{

		}

		public TipoDado getTipoDado()
		{
			return tipoDado;
		}

		public TrechoCodigoFonte getTrechoCodigoFonte()
		{
			return trechoCodigoFonte;
		}
		
		public void setTipoDado(TipoDado tipoDado)
		{
			this.tipoDado = tipoDado;
		}
		
		public void setTrechoCodigoFonte(TrechoCodigoFonte trechoCodigoFonte)
		{
			this.trechoCodigoFonte = trechoCodigoFonte;
		}
	}
	

	private TrechoCodigoFonte criarTrechoCodigoFonte(Token tokenAntlr)
	{
		if (tokenAntlr != null)
		{
			int linha = tokenAntlr.getLine();
			int coluna = tokenAntlr.getCharPositionInLine();
			int tamanhoTexto = tokenAntlr.getText().length();
			
			return new TrechoCodigoFonte(linha, coluna, tamanhoTexto);
		}
		
		return null;
	}
	
	private NoExpressao selecionarExpressao(NoExpressao operandoEsquerdo, NoExpressao operandoDireito, Token operador)
	{
		if (operandoDireito != null) 
		{
			NoOperacao operacao = new NoOperacao(Operacao.obterOperacaoPeloOperador(operador.getText()), operandoEsquerdo, operandoDireito);			
			operacao.setTrechoCodigoFonteOperador(criarTrechoCodigoFonte(operador));
			
			return operacao;
		}
		
		else return operandoEsquerdo;
	}
}

parse returns[ArvoreSintaticaAbstrata asa]:
	
	prog = programa
	{
		asa = prog;
	}
;

programa returns[ArvoreSintaticaAbstrata asa] @init
{
	pilhaContexto.push("programa");
}:

	PR_PROGRAMA ABRE_CH

		(declaracoesGlobais[asa] | declaracaoFuncao[asa])*
		
	FECHA_CH
	
	{
		asa = new ArvoreSintaticaAbstrataPrograma();
		asa.setListaDeclaracoesGlobais(new ArrayList<NoDeclaracao>());
	}
;
finally
{
	pilhaContexto.pop();
}

declaracoesGlobais [ArvoreSintaticaAbstrata asa] @init 
{
	pilhaContexto.push("declaracoesGlobais");
}:

	vListaDeclaracoes = listaDeclaracoes
	{
		List<NoDeclaracao> listaDeclaracoesGlobais = asa.getListaDeclaracoesGlobais();
		
		for (NoDeclaracao declaracao: vListaDeclaracoes)
			listaDeclaracoesGlobais.add(declaracao);

	}
;
finally
{
	pilhaContexto.pop();
}

declaracoesLocais [List<NoBloco> listaBlocos] @init
{
	pilhaContexto.push("declaracoesLocais");
}:

	vListaDeclaracoes = listaDeclaracoes
	{
		for (NoDeclaracao declaracao: vListaDeclaracoes)
			listaBlocos.add(declaracao);
	}
;
finally
{
	pilhaContexto.pop();
}

listaDeclaracoes returns[List<NoDeclaracao> listaDeclaracoes] @init
{
	pilhaContexto.push("listaDeclaracoes");
	listaDeclaracoes = new ArrayList<NoDeclaracao>();
}:
(
	{ tokenConst = null; }
	
	(tokenConst = PR_CONST)? informacaoTipoDado = declaracaoTipoDado
	
	(                  vDeclaracao = declaracao[tokenConst, informacaoTipoDado] { listaDeclaracoes.add(vDeclaracao); })
	(VIRGULA vDeclaracao = declaracao[tokenConst, informacaoTipoDado] { listaDeclaracoes.add(vDeclaracao); })*
)
;
finally
{
	pihaContexto.pop();
}


declaracao [Token tokenConst, InformacaoTipoDado informacaoTipoDado] returns[NoDeclaracao declaracao] @init
{
	pilhaContexto.push("declaracao");
}:	

	(ID (tk1 = ABRE_COL (ind1 = expressao)? FECHA_COL (tk2 = ABRE_COL (ind2 = expressao)? FECHA_COL)?)? 
	(OP_ATRIB inicializacao = expressao)?) 
	
	{
		boolean constante = (tokenConst != null);
		
		if ((tk1 == null) && (tk2 == null))
			declaracao = new NoDeclaracaoVariavel($ID.text, informacaoTipoDado.getTipoDado(), constante);
		
		else
		
		if ((tk1 != null) && (tk2 == null))
			declaracao = new NoDeclaracaoVetor($ID.text, informacaoTipoDado.getTipoDado(), ind1, constante);
		
		else
		
		if ((tk1 != null) && (tk2 != null))
			declaracao = new NoDeclaracaoMatriz($ID.text, informacaoTipoDado.getTipoDado(), ind1, ind2, constante);
	
		declaracao.setInicializacao(inicializacao);
		declaracao.setTrechoCodigoFonteNome(criarTrechoCodigoFonte($ID));
		declaracao.setTrechoCodigoFonteTipoDado(informacaoTipoDado.getToken());
	}
;
finally
{
	pilhaContexto.pop();
}

declaracaoTipoDado returns[InformacaoTipoDado informacaoTipoDado] @init
{
	pilhaContexto.push("declaracaoTipoDado");
}:

	(tokenTipoDado = PR_INTEIRO | tokenTipoDado = PR_REAL | tokenTipoDado = PR_CARACTER | tokenTipoDado = PR_CADEIA | tokenTipoDado = PR_LOGICO)
	{
		informacaoTipoDado = new InformacaoTipoDado();
		informacaoTipoDado.setTipoDado(TipoDado.obterTipoDadoPeloNome(tokenTipoDado.getText()));
		informacaoTipoDado.setTrechoCodigoFonte(criarTrechoCodigoFonte(tokenTipoDado));
	}
;
finally
{
	pilhaContexto.pop();
}

declaracaoTipoDadoVazio returns[InformacaoTipoDado informacaoTipoDado] @init
{
	pilhaContexto.push("declaracaoTipoDadoVazio");
}:

	PR_VAZIO
	{ 
		informacaoTipoDado = new InformacaoTipoDado();
		informacaoTipoDado.setTipoDado(TipoDado.VAZIO); 
		informacaoTipoDado.setTrechoCodigoFonte(criarTrechoCodigoFonte($PR_VAZIO));
	}
;
finally
{
	pilhaContexto.pop();
}

quantificador returns[Quantificador quantificador] @init
{
	pilhaContexto.push("quantificador");
}:

	(tk1 = ABRE_COL FECHA_COL (tk2 = ABRE_COL FECHA_COL)? )?
	{
		if ((tk1 == null) && (tk2 == null)) quantificador = Quantificador.VALOR;
		else		
		if ((tk1 != null) && (tk2 == null)) quantificador = Quantificador.VETOR;
		else
		if ((tk1 != null) && (tk2 != null)) quantificador = Quantificador.MATRIZ;
	}
;
finally
{
	pilhaContexto.pop();
}

tipoRetornoFuncao returns[InformacaoTipoDado informacaoTipoDado] @init
{
	pilhaContexto.push("tipoRetornoFuncao");
}:

	(informacao = declaracaoTipoDado | informacao = declaracaoTipoDadoVazio)?
	{
		if (informacao != null) informacaoTipoDado = informacao;
		
		else
		{
			informacaoTipoDado = new InformacaoTipoDado();
			informacaoTipoDado.setTipoDado(TipoDado.VAZIO);
		}
	}
;
finally
{
	pilhaContexto.pop();
}


declaracaoFuncao [ArvoreSintaticaAbstrata asa] @init
{
	pilhaContexto.push("declaracaoFuncao");
}:

	PR_FUNCAO
	
		informacaoTipoDado = tipoRetornoFuncao 
		vQuantificador = quantificador 
		
	ID ABRE_PAR vListaParametros = listaParametrosFuncao FECHA_PAR	
        
        ABRE_CH
		vBlocos = blocos
        FECHA_CH
        
         {
	         	NoDeclaracaoFuncao declaracaoFuncao = new NoDeclaracaoFuncao($ID.text, informacaoTipoDado.getTipoDado(), vQuantificador);
		declaracaoFuncao.setParametros(vListaParametros);
		declaracaoFuncao.setBlocos(vBlocos);

		declaracaoFuncao.setTrechoCodigoFonteNome(criarTrechoCodigoFonte($ID));
		declaracaoFuncao.setTrechoCodigoFonteTipoDado(informacaoTipoDado.getToken());

        		asa.getListaDeclaracoesGlobais().add(declaracaoFuncao);
         }
;
finally
{
	pilhaContexto.pop();
}



listaParametrosFuncao returns[List<NoParametro> listaParametros] @init
{
	pilhaContexto.push("listaParametrosFuncao");
}:
{
	listaParametros = new ArrayList<NoParametro>();
}
	(
		(                 vDeclaracaoParametro = declaracaoParametro { listaParametros.add(vDeclaracaoParametro); })
		(VIRGULA vDeclaracaoParametro = declaracaoParametro { listaParametros.add(vDeclaracaoParametro); })*
	)?
;
finally
{
	pilhaContexto.pop();
}

declaracaoParametro returns[NoParametro parametro] @init
{
	pilhaContexto.push("declaracaoParametro");
}:

	informacaoTipoDado = declaracaoTipoDado (tkr = OP_REFERENCIA)? ID vQuantificador = quantificador
	{
		NoParametro.ModoAcesso modoAcesso = null;
		
		if (tkr == null) modoAcesso = NoParametro.ModoAcesso.POR_VALOR;
		else
		if (tkr != null) modoAcesso = NoParametro.ModoAcesso.POR_REFERENCIA;
		
		
		parametro = new NoParametro($ID.text, informacaoTipoDado.getTipoDado(), vQuantificador, modoAcesso);
		parametro.setTrechoCodigoFonteNome(criarTrechoCodigoFonte($ID));
		parametro.setTrechoCodigoFonteTipoDado(informacaoTipoDado.getToken());
	}
;
finally
{
	pilhaContexto.pop();
}


blocos returns[List<NoBloco> blocos] @init
{
	pilhaContexto.push("blocos");
	blocos = new ArrayList<NoBloco>();
}:
(
	vBloco = bloco { blocos.add(vBloco); } | declaracoesLocais[blocos]
)*
;
finally
{
	pilhaContexto.pop();
}

bloco returns[NoBloco bloco] @init
{
	pilhaContexto.push("bloco");
}:	
(
	 vExpressao = expressao { bloco = vExpressao; } | 
	 vPara = para { bloco = vPara; } | 
	 vPare = pare { bloco = vPare; } | 
	 vRetorne = retorne { bloco = vRetorne; } | 
	 vSe = se { bloco = vSe; } | 
	 vEnquanto = enquanto { bloco = vEnquanto; } |
	 vFacaEnquanto = facaEnquanto { bloco = vFacaEnquanto; } | 
	 vEscolha = escolha { bloco = vEscolha; } |
 )
;
finally
{
	pilhaContexto.pop();
}


para returns[NoPara para] @init
{
	pilhaContexto.push("para");
}:

	PR_PARA ABRE_PAR (inicializacao = inicializacaoPara)? PONTO_VIRGULA (condicao = expressao)? PONTO_VIRGULA (incremento = expressao)? 
	FECHA_PAR vBlocos = listaBlocos
	
	{
		para = new NoPara();
		para.setInicializacao(inicializacao);
		para.setCondicao(condicao);
		para.setIncremento(incremento);		
		para.setBlocos(vBlocos);
	}
;
finally
{
	pilhaContexto.pop();
}

inicializacaoPara returns[NoBloco bloco] @init
{
	pilhaContexto.push("inicializacaoPara");
}:

	(vExpressao = expressao | vListaDeclaracoes = listaDeclaracoes)
	{
		if (vExpressao != null) bloco = vExpressao;
		else
		if (vExpressao == null) bloco = vListaDeclaracoes.get(0);
	}
;
finally
{
	pilhaContexto.pop();
}


listaBlocos returns[List<NoBloco> listaBlocos] @init 
{
	pilhaContexto.push("listaBlocos");
}:
(
	(ABRE_CH)=> ABRE_CH vListaBlocos = blocos { listaBlocos = vListaBlocos; } FECHA_CH
	  
	|
	
	vBloco = bloco
	{ 
		listaBlocos = new ArrayList<NoBloco>();
		listaBlocos.add(vBloco);
	}
)
;
finally
{
	pilhaContexto.pop();
}


pare returns[NoPare pare] @init
{
	pilhaContexto.push("pare");
}:

	PR_PARE
	{
		pare = new NoPare();
	}

;
finally
{
	pilhaContexto.pop();
}

escolha returns[NoEscolha escolha]:

	PR_ESCOLHA ABRE_PAR vExpressao = expressao FECHA_PAR
	ABRE_CH 
		vListaCasos = listaCasos
	FECHA_CH
	 {
		escolha = new NoEscolha(vExpressao);
		escolha.setCasos(vListaCasos);
	 }

;
finally
{
	pilhaContexto.pop();
}

listaCasos returns[List<NoCaso> casos] @init
{
	pilhaContexto.push("listaCasos");
	casos = new ArrayList<NoCaso>();
}:
(
	PR_CASO (PR_CONTRARIO | vExpressao = expressao) DOIS_PONTOS vBlocos = blocosCaso
	{
		NoCaso caso = new NoCaso(vExpressao);
		caso.setBlocos(vBlocos);
		casos.add(caso);
		
		vExpressao = null;
	}
)*
;
finally
{
	pilhaContexto.pop();
}

blocosCaso returns[List<NoBloco> listaBlocos] @init
{
	pihaContexto.push("blocosCaso");
}:

	(vBlocos = blocos)
	{
		listaBlocos = vBlocos;
	}
;
finally
{
	pilhaContexto.pop();
}

enquanto returns[NoEnquanto enquanto] @init
{
	pilhaContexto.push("enquanto");
}:
	
	PR_ENQUANTO ABRE_PAR vExpressao = expressao FECHA_PAR vListaBlocos = listaBlocos
	{
		enquanto = new NoEnquanto(vExpressao);
		enquanto.setBlocos(vListaBlocos);
	}
;
finally
{
	pilhaContexto.pop();
}


facaEnquanto returns[NoFacaEnquanto facaEnquanto] @init
{
	pilhaContexto.push("facaEnquanto");
}:

	PR_FACA vListaBlocos = listaBlocos PR_ENQUANTO ABRE_PAR vExpressao = expressao FECHA_PAR
	{
		facaEnquanto = new NoFacaEnquanto(vExpressao);
		facaEnquanto.setBlocos(vListaBlocos);
	}
;
finally
{
	pilhaContexto.pop();
}


se returns[NoSe se] @init
{
	pilhaContexto.push("se");
}:
 
	PR_SE ABRE_PAR vExpressao = expressao FECHA_PAR vListaBlocos = listaBlocos (PR_SENAO listaBlocosSenao = listaBlocos)?
	{
		se = new NoSe(vExpressao);
		se.setBlocosVerdadeiros(vListaBlocos);
		se.setBlocosFalsos(listaBlocosSenao);
	}
;
finally
{
	pilhaContexto.pop();
}




retorne returns[NoRetorne retorne] @init
{
	pilhaContexto.push("retorne");
}:
	
	PR_RETORNE vExpressao = expressao
	{
		retorne = new NoRetorne(vExpressao);
	}
;	

pilha returns[Stack<Object> pilha]:
{
	pilha = new Stack<Object>();
}	
;

expressao returns[NoExpressao expressao] @init
{
	pilhaContexto.push("expressao");
}:
 
	operandoEsquerdo = expressao2 vPilha = pilha { vPilha.push(operandoEsquerdo); }
	(
		(
			operador = OP_ATRIB | 
			operador = OP_SOMA_ACUM | 
			operador = OP_SUB_ACUM | 
			operador = OP_DIV_ACUM | 
			operador = OP_MULT_ACUM | 
			operador = OP_MOD_ACUM
		)
		
		operandoDireito = expressao2
		{
			vPilha.push(operador);
			vPilha.push(operandoDireito);
		}
	)*	
	{	

		while (vPilha.size() > 1)
		{
			operandoDireito = (NoExpressao) vPilha.pop();
			operador = ((Token) vPilha.pop());
			operandoEsquerdo = (NoExpressao) vPilha.pop();
			
			Operacao tipoOperacao = Operacao.obterOperacaoPeloOperador(operador.getText());
			
			NoOperacao operacao = new NoOperacao(tipoOperacao, operandoEsquerdo, operandoDireito);			
			operacao.setTrechoCodigoFonteOperador(criarTrechoCodigoFonte(operador));
			
			vPilha.push(operacao);
		}
		
		expressao = (NoExpressao) vPilha.pop();
	}
;
finally
{
	pilhaContexto.pop();
}


expressao2 returns[NoExpressao expressao] @init
{
	pilhaContexto.push("expressao2");
}:

	operandoEsquerdo = expressao3
	( 	
		{ 
		
			if (operandoDireito != null)
			{
				NoOperacao operacao = new NoOperacao(Operacao.obterOperacaoPeloOperador(operador.getText()), operandoEsquerdo, operandoDireito);
				operacao.setTrechoCodigoFonteOperador(criarTrechoCodigoFonte(operador));
			 	operandoEsquerdo = operacao; 
			 }
		}       
			
		(operador = OP_E | operador = OP_OU)
		
		operandoDireito = expressao3
	)*
	{
		expressao = selecionarExpressao(operandoEsquerdo, operandoDireito, operador);
	}
;
finally
{
	pilhaContexto.pop();
}



expressao3 returns[NoExpressao expressao] @init
{
	pilhaContexto.push("expressao3");
}:

	operandoEsquerdo = expressao4
	( 	
		{
		
			if (operandoDireito != null)
			{
				NoOperacao operacao = new NoOperacao(Operacao.obterOperacaoPeloOperador(operador.getText()), operandoEsquerdo, operandoDireito);
				operacao.setTrechoCodigoFonteOperador(criarTrechoCodigoFonte(operador));
			 	operandoEsquerdo = operacao; 
			 }
		}
		
		(operador = OP_IGUALDADE | operador = OP_DIFERENCA) 
		
		operandoDireito = expressao4
	)*
	{
		expressao = selecionarExpressao(operandoEsquerdo, operandoDireito, operador);
	}
;
finally
{
	pilhaContexto.pop();
}


expressao4 returns[NoExpressao expressao] @init
{
	pilhaContexto.push("expressao4");
}:

	operandoEsquerdo = expressao5 
	(
		(
			operador = OP_MAIOR_IGUAL | 
			operador = OP_MENOR_IGUAL |
			operador = OP_MENOR |
			operador = OP_MAIOR

			
		) operandoDireito = expressao5
		
	)?
	{
		expressao = selecionarExpressao(operandoEsquerdo, operandoDireito, operador);
	}
;
finally
{
	pilhaContexto.pop();
}


expressao5 returns[NoExpressao expressao] @init
{
	pilhaContexto.push("expressao5");
}:

	operandoEsquerdo = expressao6	
	( 	
		{
		
			if (operandoDireito != null)
			{
				NoOperacao operacao = new NoOperacao(Operacao.obterOperacaoPeloOperador(operador.getText()), operandoEsquerdo, operandoDireito);
				operacao.setTrechoCodigoFonteOperador(criarTrechoCodigoFonte(operador));
			 	operandoEsquerdo = operacao; 
			 }
		}

			
		(operador = OP_SOMA operandoDireito = expressao6) | 
		
		(OP_SUBTRACAO)=> operador = OP_SUBTRACAO operandoDireito = expressao6
	)*
	{
		expressao = selecionarExpressao(operandoEsquerdo, operandoDireito, operador);
	}
;
finally
{
	pilhaContexto.pop();
}


expressao6 returns[NoExpressao expressao] @init
{
	pilhaContexto.push("expressao6");
}:

	operandoEsquerdo = expressao7
	( 	
		{
		
			if (operandoDireito != null)
			{
				NoOperacao operacao = new NoOperacao(Operacao.obterOperacaoPeloOperador(operador.getText()), operandoEsquerdo, operandoDireito);
				operacao.setTrechoCodigoFonteOperador(criarTrechoCodigoFonte(operador));
			 	operandoEsquerdo = operacao; 
			 }
		}

			
		(
			operador = OP_MULTIPLICACAO | 
			operador = OP_DIVISAO | 
			operador = OP_MODULO'
		) 
		
		operandoDireito = expressao7
	)*
	{
		expressao = selecionarExpressao(operandoEsquerdo, operandoDireito, operador);
	}
;
finally
{
	pilhaContexto.pop();
}



expressao7 returns[NoExpressao expressao] @init
{
	pilhaContext.push("expressao7");
}:

	((OP_SUBTRACAO) => (listaTokenMenos += OP_SUBTRACAO)? | (listaTokenNao += OP_NAO)*)  vExpressao = expressao8
	{
		if ($listaTokenNao != null)
		{
			for (int i = 0; i < $listaTokenNao.size(); i++)
				vExpressao = new NoNao(vExpressao);
		}
		
		else 
		
		if ($listaTokenMenos != null) vExpressao = new NoMenosUnario(vExpressao);
		
		expressao = vExpressao;
	}
;
finally
{
	pilhaContexto.push();
}


expressao8 returns[NoExpressao expressao] @init
{
	pilhaContexto.push("expressao8");
}:	
	
	(ABRE_PAR vExpressao = expressao FECHA_PAR | vExpressao = tipoPrimitivo | vExpressao = referencia | vExpressao = matrizVetor) 
	
		(operador =OP_INCREMENTO | operador = OP_DECREMENTO)?
	{
		if (operador != null)
		{
			if (operador.getText().equals("++")) expressao = new NoIncremento(vExpressao);
			else
			if (operador.getText().equals("--")) expressao = new NoDecremento(vExpressao);
		}
		
		else expressao = vExpressao;
	}
;
finally
{
	pilhaContexto.pop();
}

tipoPrimitivo returns[NoExpressao expressao] @init
{
	pilhaContexto.push("tipoPrimitivo");
}:

	REAL      
	{ 
		NoReal real = new NoReal(Double.parseDouble($REAL.text));
		real.setTrechoCodigoFonte(criarTrechoCodigoFonte($REAL));
		expressao = real;
	} 
	
	|
	
	LOGICO
	{
		NoLogico logico = new NoLogico(($LOGICO.text.equals("verdadeiro")? true : false));
		logico.setTrechoCodigoFonte(criarTrechoCodigoFonte($LOGICO));
		expressao = logico;
	} 
	
	|
	
	CADEIA
	{
		String texto = $CADEIA.text;
		NoCadeia cadeia = new NoCadeia(texto.substring(1, texto.length() - 1));
		cadeia.setTrechoCodigoFonte(criarTrechoCodigoFonte($CADEIA));
		expressao = cadeia;
	}
	
	|
	
	INTEIRO
	{
		NoInteiro inteiro = new NoInteiro(Integer.parseInt($INTEIRO.text));
		inteiro.setTrechoCodigoFonte(criarTrechoCodigoFonte($INTEIRO));
		expressao = inteiro;
	} 
	
	| 
	
	CARACTER
	{
		NoCaracter caracter = new NoCaracter($CARACTER.text.charAt(1));
		caracter.setTrechoCodigoFonte(criarTrechoCodigoFonte($CARACTER));
		expressao = caracter;
	}	
; 
finally
{
	pilhaContexto.pop();
}


referencia returns[NoReferencia referencia] @init
{
	pilhaContexto.push("referencia");
}:	
	ID
	(
		(ABRE_PAR) => vExpressao = chamadaFuncao[$ID.text] |
		(ABRE_COL) => vExpressao = referenciaVetorMatriz[$ID.text] |
			 vExpressao = referenciaId[$ID.text]
	)
	{
		referencia = (NoReferencia) vExpressao;
		referencia.setTrechoCodigoFonteNome(criarTrechoCodigoFonte($ID));
		referencia.setTrechoCodigoFonteApelido(criarTrechoCodigoFonte($APELIDO));
	}
;
finally
{
	pilhaContexto.pop();
}


referenciaId [String nome] returns[NoExpressao expressao] @init
{
	pilhaContexto.push("referenciaId");
}:	

	{
		expressao = new NoReferenciaVariavel(nome);
	}

;
finally
{
	pilhaContexto.pop();
}

referenciaVetorMatriz [String apelido, String nome] returns[NoExpressao expressao] @init
{
	pilhaContexto.push("referenciaVetorMatriz");
}:
	
	ABRE_COL indice1 = expressao FECHA_COL (ABRE_COL indice2 = expressao FECHA_COL)?
	 {
	 	if ((indice1 != null) && (indice2 == null)) expressao = new NoReferenciaVetor(obterApelido(apelido), nome, indice1);
		else		
		if ((indice1 != null) && (indice2 != null)) expressao = new NoReferenciaMatriz(obterApelido(apelido), nome, indice1, indice2);		
	 }
;
finally
{
	pilhaContexto.pop();
}


chamadaFuncao [String apelido, String nome] returns[NoExpressao expressao] @init
{
	pilhaContexto.push("chamadaFuncao");
}:
	
	ABRE_PAR (vListaParametros = listaParametros)? FECHA_PAR
	 {
		NoChamadaFuncao chamadaFuncao = new NoChamadaFuncao(obterApelido(apelido), nome);
		chamadaFuncao.setParametros(vListaParametros);
		expressao = chamadaFuncao;
	 }
;
finally
{
	pilhaContexto.pop();
}


listaParametros returns[List<NoExpressao> listaParametros] @init
{
	pilhaContexto.push("listaParametros");
	listaParametros = new ArrayList<NoExpressao>();	
}:
	(                 vExpressao = expressao { listaParametros.add(vExpressao); })
	(VIRGULA vExpressao = expressao { listaParametros.add(vExpressao); })*
;
finally
{
	pilhaContexto.pop();
}

matrizVetor returns[NoExpressao expressao] @init
{
	pilhaContexto.push("matriizVetor");
}:
	
	((ABRE_CH ABRE_CH)=> vExpressao = matriz | vExpressao = vetor)
	{
		expressao = vExpressao;
	}
;
finally
{
	pilhaContexto.pop();
}


vetor returns[NoExpressao expressao] @init
{
	pilhaContexto.push("vetor");
}:	

	ABRE_CH vListaExpressoes = listaExpressoes FECHA_CH
	 {
		expressao = new NoVetor(vListaExpressoes);
	 }
;
finally
{
	pilhaContexto.pop();
}

matriz returns[NoExpressao expressao] @init
{
	pilhaContexto.push("matriz");
}:
	
	ABRE_CH
		vListaListaExpressoes = listaListaExpressoes
	FECHA_CH
	 {
	 	
		expressao = new NoMatriz(vListaListaExpressoes);
	 }
;
finally
{
	pilhaContexto.pop();
}

listaListaExpressoes returns[List<List<Object>> listaListaExpressoes] @init
{
	pilhaContexto.push("listaListaExpressoes");
	listaListaExpressoes = new ArrayList<List<Object>>();
}:

	(                   		   ABRE_CH vListaExpressoes = listaExpressoes FECHA_CH { listaListaExpressoes.add(vListaExpressoes); })
	( { vListaExpressoes = null; } VIRGULA ABRE_CH vListaExpressoes = listaExpressoes FECHA_CH { listaListaExpressoes.add(vListaExpressoes); })*
;
finally
{
	pilhaContexto.pop();
}

listaExpressoes returns[List<Object> listaExpressoes] @init
{
	pilhaContexto.push("listaExpressoes");
}:
{
	listaExpressoes = new ArrayList<Object>();
}
	({ vExpressao = null; }     (vExpressao = expressao)? { listaExpressoes.add(vExpressao); })
	({ vExpressao = null; } VIRGULA (vExpressao = expressao)? { listaExpressoes.add(vExpressao); })*
;
finally
{
	pilhaContexto.pop();
}