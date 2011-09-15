grammar Portugol;

@lexer::header 
{ 
	package br.univali.portugol.nucleo.analise.sintatica;
}
 
@parser::header
{

	package br.univali.portugol.nucleo.analise.sintatica;

	import org.antlr.runtime.Token;
	import br.univali.portugol.nucleo.asa.*;
}

@parser::members
{
	private int quantidadeErros = 0;
	private String contexto = null;
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
			tradutor.traduzirErroSintatico(contexto, e, tokenNames);
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


PR_PROGRAMA			:	'programa'		;
PR_REAL				:	'real'			;
PR_VAZIO				:	'vazio'			;
PR_LOGICO				:	'logico'			;
PR_CADEIA				:	'cadeia'		;
PR_INTEIRO				:	'inteiro'		;
PR_CARACTER			:	'caracter'		;    
PR_ESCOLHA			:	'escolha'		;
PR_CASO_CONTRARIO		:	'caso contrario'	;
PR_CASO				:	'caso'			;
PR_CONST				:	'const'			;
PR_FUNCAO				:	'funcao'		;
PR_RETORNE			:	'retorne'		;  
PR_PARA				:	'para'			;
PR_PARE				:	'pare'			;
PR_FACA				:	'faca'			;
PR_ENQUANTO			:	'enquanto'		;
PR_SE					:	'se'			;
PR_SENAO				:	'senao'			;
    
fragment PR_FALSO			:	'falso'			;
fragment PR_VERDADEIRO		:	'verdadeiro'		;

OPERADOR_NAO			:	'nao'			;

LOGICO				: 	PR_VERDADEIRO | PR_FALSO  ;

ID 					:	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*  ;

INTEIRO 				:	'0'..'9'* ;

REAL					: 	('0'..'9')+ '.' ('0'..'9')+ ;
    
CADEIA				:	'"' ( SEQ_ESC | ~('\\'|'"') )* '"'  ;

CARACTER				:  	'\'' ( SEQ_ESC | ~('\''|'\\') ) '\''  ;

ESPACO				:	( ' ' | '\t' | '\r' | '\n')  {$channel=HIDDEN;}  ;


fragment DIGIT_HEX 		: 	('0'..'9'|'a'..'f'|'A'..'F')  ;

fragment SEQ_ESC			:	 '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')  |   ESC_UNICODE  |   ESC_OCTAL   ;

fragment ESC_OCTAL		:	'\\' ('0'..'3') ('0'..'7') ('0'..'7')  |   '\\' ('0'..'7') ('0'..'7')    |   '\\' ('0'..'7')    ;

fragment ESC_UNICODE		:	'\\' 'u' DIGIT_HEX DIGIT_HEX DIGIT_HEX DIGIT_HEX  ;

COMENTARIO			:   

	'//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}    	|  
	
	 '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
 ;



parse returns[ArvoreSintaticaAbstrata asa]:

	prog = programa
	{
		asa = prog;
	}
;

programa returns[ArvoreSintaticaAbstrata asa] @init
{
	contexto = "programa";
}:

	PR_PROGRAMA
	'{'		
		{
	 		asa = new ArvoreSintaticaAbstrataPrograma();
			asa.setListaDeclaracoesGlobais(new ArrayList<NoDeclaracao>());
		 }

		(declaracoesGlobais[asa] | declaracaoFuncao[asa])*
	'}'
;


declaracoesGlobais [ArvoreSintaticaAbstrata asa] @init
{
	contexto = "declaracoesGlobais";
}:

	vListaDeclaracoes = listaDeclaracoes
	{
		List<NoDeclaracao> listaDeclaracoesGlobais = asa.getListaDeclaracoesGlobais();
		
		for (NoDeclaracao declaracao: vListaDeclaracoes)
			listaDeclaracoesGlobais.add(declaracao);

	}
;


declaracoesLocais [List<NoBloco> listaBlocos]@init
{
	contexto = "declaracoesLocais";
}:

	vListaDeclaracoes = listaDeclaracoes
	{
		for (NoDeclaracao declaracao: vListaDeclaracoes)
			listaBlocos.add(declaracao);
	}
;



listaDeclaracoes returns[List<NoDeclaracao> listaDeclaracoes] @init
{
	contexto = "listaDeclaracoes";
	listaDeclaracoes = new ArrayList<NoDeclaracao>();
}:
(
	{tokenConst = null; }
	
	(tokenConst = PR_CONST)? informacaoTipoDado = declaracaoTipoDado
	
	(    vDeclaracao = declaracao[tokenConst, informacaoTipoDado] { listaDeclaracoes.add(vDeclaracao); })
	(',' vDeclaracao = declaracao[tokenConst, informacaoTipoDado] { listaDeclaracoes.add(vDeclaracao); })*
)
;


declaracao [Token tokenConst, InformacaoTipoDado informacaoTipoDado] returns[NoDeclaracao declaracao] @init
{
	contexto = "declaracao";
}:	

	(ID (tk1 = '[' (ind1 = expressao)? ']' (tk2 = '[' (ind2 = expressao)? ']')?)? ('=' inicializacao = expressao)?) 
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
		declaracao.setTrechoCodigoFonteTipoDado(informacaoTipoDado.getTrechoCodigoFonte());
	}
;


declaracaoTipoDado returns[InformacaoTipoDado informacaoTipoDado] @init
{
	contexto = "declaracaoTipoDado";
}:

	(tokenTipoDado = PR_INTEIRO | tokenTipoDado = PR_REAL | tokenTipoDado = PR_CARACTER | tokenTipoDado = PR_CADEIA | tokenTipoDado = PR_LOGICO)
	{
		informacaoTipoDado = new InformacaoTipoDado();
		informacaoTipoDado.setTipoDado(TipoDado.obterTipoDadoPeloNome(tokenTipoDado.getText()));
		informacaoTipoDado.setTrechoCodigoFonte(criarTrechoCodigoFonte(tokenTipoDado));
	}
;



declaracaoTipoDadoVazio returns[InformacaoTipoDado informacaoTipoDado] @init
{
	contexto = "declaracaoTipoDadoVazio";
}:

	PR_VAZIO
	{ 
		informacaoTipoDado = new InformacaoTipoDado();
		informacaoTipoDado.setTipoDado(TipoDado.VAZIO); 
		informacaoTipoDado.setTrechoCodigoFonte(criarTrechoCodigoFonte($PR_VAZIO));
	}
;




quantificador returns[Quantificador quantificador] @init
{
	contexto = "quantificador";
}:

	(tk1 = '[' ']' (tk2 = '[' ']')? )?
	{
		if ((tk1 == null) && (tk2 == null)) quantificador = Quantificador.VALOR;
		else		
		if ((tk1 != null) && (tk2 == null)) quantificador = Quantificador.VETOR;
		else
		if ((tk1 != null) && (tk2 != null)) quantificador = Quantificador.MATRIZ;
	}
;



tipoRetornoFuncao returns[InformacaoTipoDado informacaoTipoDado] @init
{
	contexto = "tipoRetornoFuncao";
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



declaracaoFuncao [ArvoreSintaticaAbstrata asa] @init
{
	contexto = "declaracaoFuncao";
}:

	PR_FUNCAO
	
		informacaoTipoDado = tipoRetornoFuncao 
		vQuantificador = quantificador 
		
	ID '(' vListaParametros = listaParametrosFuncao ')'	
        
        '{'
		vBlocos = blocos
        '}'
        
         {
         	NoDeclaracaoFuncao declaracaoFuncao = new NoDeclaracaoFuncao($ID.text, informacaoTipoDado.getTipoDado(), vQuantificador);
         	declaracaoFuncao.setParametros(vListaParametros);
	declaracaoFuncao.setBlocos(vBlocos);

	declaracaoFuncao.setTrechoCodigoFonteNome(criarTrechoCodigoFonte($ID));
	declaracaoFuncao.setTrechoCodigoFonteTipoDado(informacaoTipoDado.getTrechoCodigoFonte());

        	asa.getListaDeclaracoesGlobais().add(declaracaoFuncao);
         }
;



listaParametrosFuncao returns[List<NoParametro> listaParametros] @init
{
	contexto = "listaParametrosFuncao";
	listaParametros = new ArrayList<NoParametro>();
}:
	(
		(    vDeclaracaoParametro = declaracaoParametro { listaParametros.add(vDeclaracaoParametro); })
		(',' vDeclaracaoParametro = declaracaoParametro { listaParametros.add(vDeclaracaoParametro); })*
	)?
;




declaracaoParametro returns[NoParametro parametro] @init
{
	contexto = "declaracaoParametro";
}:

	informacaoTipoDado = declaracaoTipoDado (tkr = '&')? ID vQuantificador = quantificador
	{
		NoParametro.ModoAcesso modoAcesso = null;
		TipoDado tipoDado = null;
		TrechoCodigoFonte trechoCodigoFonteTipoDado = null;
		
		if (tkr == null) modoAcesso = NoParametro.ModoAcesso.POR_VALOR;
		else
		if (tkr != null) modoAcesso = NoParametro.ModoAcesso.POR_REFERENCIA;
		
		if (informacaoTipoDado != null) 
		{
			tipoDado = informacaoTipoDado.getTipoDado();
			trechoCodigoFonteTipoDado = informacaoTipoDado.getTrechoCodigoFonte();
		}
		
		parametro = new NoParametro($ID.text, tipoDado, vQuantificador, modoAcesso);
		parametro.setTrechoCodigoFonteNome(criarTrechoCodigoFonte($ID));
		parametro.setTrechoCodigoFonteTipoDado(trechoCodigoFonteTipoDado);
	}
;




blocos returns[List<NoBloco> blocos] @init
{
	contexto = "blocos";
	blocos = new ArrayList<NoBloco>();
}:
(
	vBloco = bloco { blocos.add(vBloco); } | declaracoesLocais[blocos]
)*
;



bloco returns[NoBloco bloco] @init
{
	contexto = "bloco";
}:	
(
	 vExpressao = expressao 		{ bloco = vExpressao; 	} | 
	 vPara = para 		 		{ bloco = vPara; 	 	} | 
	 vPare = pare 				{ bloco = vPare; 	 	} | 
	 vRetorne = retorne 			{ bloco = vRetorne; 	 	} | 
	 vSe = se 				{ bloco = vSe; 		} | 
	 vEnquanto = enquanto 		{ bloco = vEnquanto;		} |
	 vFacaEnquanto = facaEnquanto 	{ bloco = vFacaEnquanto; 	} | 
	 vEscolha = escolha  			{ bloco = vEscolha;	 	}
 )
;



para returns[NoPara para] @init
{
	contexto = "para";
}:

	PR_PARA '(' (inicializacao = inicializacaoPara)? ';' (condicao = expressao)? ';' (incremento = expressao)? ')' vBlocos = listaBlocos
	{
		para = new NoPara();
		para.setInicializacao(inicializacao);
		para.setCondicao(condicao);
		para.setIncremento(incremento);		
		para.setBlocos(vBlocos);
	}
;




inicializacaoPara returns[NoBloco bloco] @init
{
	contexto = "inicializacaoPara";
}:

	(vExpressao = expressao | vListaDeclaracoes = listaDeclaracoes)
	{
		if (vExpressao != null) bloco = vExpressao;
		else
		if (vExpressao == null) bloco = vListaDeclaracoes.get(0);
	}
;



listaBlocos returns[List<NoBloco> listaBlocos] @init
{
	contexto = "listaBlocos";
}:
(
	('{')=> '{' vListaBlocos = blocos { listaBlocos = vListaBlocos; } '}'
	  
	|
	
	vBloco = bloco
	{ 
		listaBlocos = new ArrayList<NoBloco>();
		listaBlocos.add(vBloco);
	}
)
;



pare returns[NoPare pare] @init
{
	contexto = "pare";
}:

	PR_PARE
	{
		pare = new NoPare();
	}

;



escolha returns[NoEscolha escolha] @init
{
	contexto = "escolha";
}:

	PR_ESCOLHA '(' vExpressao = expressao ')'
	'{' 
		vListaCasos = listaCasos
	'}'
	 {
		escolha = new NoEscolha(vExpressao);
		escolha.setCasos(vListaCasos);
	 }

;



listaCasos returns[List<NoCaso> casos] @init
{
	contexto = "listaCasos";
	casos = new ArrayList<NoCaso>();
}:
(
	 ( casoContrario |PR_CASO vExpressao = expressao) ':' vBlocos = blocosCaso
	{
		NoCaso caso = new NoCaso(vExpressao);
		caso.setBlocos(vBlocos);
		casos.add(caso);
		
		vExpressao = null;
	}
)*
;



casoContrario @init
{
	contexto = "casoContrario";
}: 
	PR_CASO_CONTRARIO
;




blocosCaso returns[List<NoBloco> listaBlocos] @init
{
	contexto = "blocosCaso";
}:

	( ('{')=> ('{' vBlocos = blocos '}') | (vBlocos = blocos))
	{
		listaBlocos = vBlocos;
	}
;



enquanto returns[NoEnquanto enquanto] @init
{
	contexto = "enquanto";
}:
	
	PR_ENQUANTO '(' vExpressao = expressao ')' vListaBlocos = listaBlocos
	{
		enquanto = new NoEnquanto(vExpressao);
		enquanto.setBlocos(vListaBlocos);
	}
;



facaEnquanto returns[NoFacaEnquanto facaEnquanto] @init
{
	contexto = "facaEnquanto";
}:

	PR_FACA vListaBlocos = listaBlocos PR_ENQUANTO '(' vExpressao = expressao ')'
	{
		facaEnquanto = new NoFacaEnquanto(vExpressao);
		facaEnquanto.setBlocos(vListaBlocos);
	}
;




se returns[NoSe se] @init
{
	contexto = "se";
}:
 
	PR_SE '(' vExpressao = expressao ')' vListaBlocos = listaBlocos (PR_SENAO listaBlocosSenao = listaBlocos)?
	{
		se = new NoSe(vExpressao);
		se.setBlocosVerdadeiros(vListaBlocos);
		se.setBlocosFalsos(listaBlocosSenao);
	}
;



retorne returns[NoRetorne retorne] @init
{
	contexto = "retorne";
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
	contexto = "expressao";
}:

	operandoEsquerdo = expressao2 vPilha = pilha { vPilha.push(operandoEsquerdo); }
	(
		(operador = '=' | operador = '+=' | operador = '-=' | operador = '/=' | operador = '*=' | operador = '%=')
		
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


expressao2 returns[NoExpressao expressao] @init
{
	contexto = "expressao2";
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
			
		(operador = 'e' | operador = 'ou')
		
		operandoDireito = expressao3
	)*
	{
		expressao = selecionarExpressao(operandoEsquerdo, operandoDireito, operador);
	}
;



expressao3 returns[NoExpressao expressao] @init
{
	contexto = "expressao3";
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
		
		(operador = '==' | operador = '!=') 
		
		operandoDireito = expressao4
	)*
	{
		expressao = selecionarExpressao(operandoEsquerdo, operandoDireito, operador);
	}
;



expressao4 returns[NoExpressao expressao] @init
{
	contexto = "expressao4";
}:

	operandoEsquerdo = expressao5 ((operador = '>=' | operador = '<=' | operador = '<' | operador = '>') operandoDireito = expressao5)?
	{
		expressao = selecionarExpressao(operandoEsquerdo, operandoDireito, operador);
	}
;



expressao5 returns[NoExpressao expressao] @init
{
	contexto = "expressao5";
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

			
		(operador = '+' operandoDireito = expressao6) | ('-')=> operador = '-' operandoDireito = expressao6
		
		
	)*
	{
		expressao = selecionarExpressao(operandoEsquerdo, operandoDireito, operador);
	}
;



expressao6 returns[NoExpressao expressao] @init
{
	contexto = "expressao6";
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

			
		(operador = '*' | operador = '/' | operador = '%') 
		
		operandoDireito = expressao7
	)*
	{
		expressao = selecionarExpressao(operandoEsquerdo, operandoDireito, operador);
	}
;



expressao7 returns[NoExpressao expressao] @init
{
	contexto = "expressao7";
}:

	(('-') => (listaTokenMenos += '-')? | (listaTokenNao += OPERADOR_NAO)*)  vExpressao = expressao8
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



expressao8 returns[NoExpressao expressao] @init
{
	contexto = "expressao8";
}:	
	
	('(' vExpressao = expressao ')' | vExpressao = tipoPrimitivo | vExpressao = referencia | vExpressao = matrizVetor) 
	
		(operador = '++' | operador = '--')?
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




tipoPrimitivo returns[NoExpressao expressao] @init
{
	contexto = "tipoPrimitivo";
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



referencia returns[NoReferencia referencia] @init
{
	contexto = "referencia";
}:	

	ID
	(
		('(') => vExpressao = chamadaFuncao[$ID.text] |
		('[') => vExpressao = referenciaVetorMatriz[$ID.text] |
			 vExpressao = referenciaId[$ID.text]
	)
	{
		referencia = (NoReferencia) vExpressao;
		referencia.setTrechoCodigoFonteNome(criarTrechoCodigoFonte($ID));
	}
;




referenciaId [String nome] returns[NoExpressao expressao] @init
{
	contexto = "referenciaId";
}:	

	{
		expressao = new NoReferenciaVariavel(nome);
	}

;



referenciaVetorMatriz [ String nome] returns[NoExpressao expressao] @init
{
	contexto = "referenciaVetorMatriz";
}:
	
	'[' indice1 = expressao ']' ('[' indice2 = expressao ']')?
	 {
	 	if ((indice1 != null) && (indice2 == null)) expressao = new NoReferenciaVetor(nome, indice1);
		else		
		if ((indice1 != null) && (indice2 != null)) expressao = new NoReferenciaMatriz(nome, indice1, indice2);		
	 }
;



chamadaFuncao [String nome] returns[NoExpressao expressao] @init
{
	contexto = "chamadaFuncao";
}:
	
	'(' (vListaParametros = listaParametros)? ')'
	 {
		NoChamadaFuncao chamadaFuncao = new NoChamadaFuncao(nome);
		chamadaFuncao.setParametros(vListaParametros);
		expressao = chamadaFuncao;
	 }
;




listaParametros returns[List<NoExpressao> listaParametros] @init
{
	contexto = "listaParametros";
	listaParametros = new ArrayList<NoExpressao>();
}:
	(   vExpressao = expressao { listaParametros.add(vExpressao); })
	(','vExpressao = expressao { listaParametros.add(vExpressao); })*
;



matrizVetor returns[NoExpressao expressao] @init
{
	contexto = "matrizVetor";
}:
	
	(('{' '{')=> vExpressao = matriz | vExpressao = vetor)
	{
		expressao = vExpressao;
	}
;




vetor returns[NoExpressao expressao] @init
{
	contexto = "vetor";
}:	

	'{' vListaExpressoes = listaExpressoes '}'
	 {
		expressao = new NoVetor(vListaExpressoes);
	 }
;



matriz returns[NoExpressao expressao] @init
{
	contexto = "matriz";
}:	
	
	'{'
		vListaListaExpressoes = listaListaExpressoes
	'}'
	 {
	 	
		expressao = new NoMatriz(vListaListaExpressoes);
	 }
;




listaListaExpressoes returns[List<List<Object>> listaListaExpressoes] @init
{
	contexto = "listaListaExpressoes";
	listaListaExpressoes = new ArrayList<List<Object>>();
}:
	(                   		   	      '{' vListaExpressoes = listaExpressoes '}' { listaListaExpressoes.add(vListaExpressoes); })
	( { vListaExpressoes = null; } ','  '{' vListaExpressoes = listaExpressoes '}' { listaListaExpressoes.add(vListaExpressoes); })*

;



listaExpressoes returns[List<Object> listaExpressoes] @init
{
	contexto = "listaExpressoes";
	listaExpressoes = new ArrayList<Object>();
}:
	({ vExpressao = null; }     (vExpressao = expressao)? { listaExpressoes.add(vExpressao); })
	({ vExpressao = null; } ',' (vExpressao = expressao)? { listaExpressoes.add(vExpressao); })*
;
