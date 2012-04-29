grammar Portugol;

@lexer::header 
{ 
	package br.univali.portugol.nucleo.analise.sintatica;
}
 
@parser::header
{

	package br.univali.portugol.nucleo.analise.sintatica;

	import java.util.Stack;
	import org.antlr.runtime.Token;
	import br.univali.portugol.nucleo.asa.*;
}

@parser::members
{
	private boolean gerarArvore = true;
	private int quantidadeErros = 0;		
	private Stack<String> pilhaContexto = new Stack<String>();
	private List<ObservadorParsing> observadores  = new ArrayList<ObservadorParsing>();
	
	public void adicionarObservadorParsing(ObservadorParsing observador)
	{
		if (!observadores.contains(observador))
			observadores.add(observador);
	}
	
	
	public void removerObservadorParsing(ObservadorParsing observador)
	{
		observadores.remove(observador);
	}

	@Override
	public void displayRecognitionError(String[] tokenNames, RecognitionException e)
	{
		gerarArvore = false;
		quantidadeErros = quantidadeErros + 1;
		String mensagemPadrao = getErrorHeader(e) + " - " + getErrorMessage(e, tokenNames);
		
		for (ObservadorParsing observador: observadores)
		{
			Stack<String> copiaPilha = new Stack<String>();
			copiaPilha.addAll(pilhaContexto);
			
			observador.tratarErroParsing(e, tokenNames, copiaPilha, mensagemPadrao);
		}
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
	pilhaContexto.push("programa");
}:

	PR_PROGRAMA
	'{'		
		{
			if (gerarArvore)
			{
		 		asa = new ArvoreSintaticaAbstrataPrograma();
				asa.setListaDeclaracoesGlobais(new ArrayList<NoDeclaracao>());
			}
		 }

		(declaracoesGlobais[asa] | declaracaoFuncao[asa])*
	'}'
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
		if (gerarArvore)
		{
			if (asa != null)
			{
				List<NoDeclaracao> listaDeclaracoesGlobais = asa.getListaDeclaracoesGlobais();
				
				if (listaDeclaracoesGlobais != null)
				{
					for (NoDeclaracao declaracao: vListaDeclaracoes)
						listaDeclaracoesGlobais.add(declaracao);
				}
			}
		}
	}
;
finally
{
	pilhaContexto.pop();
}


declaracoesLocais [List<NoBloco> listaBlocos]@init
{
	pilhaContexto.push("declaracoesLocais");
}:

	vListaDeclaracoes = listaDeclaracoes
	{
		if (gerarArvore)
		{
			if ((listaBlocos != null) &&  (vListaDeclaracoes != null))
			{
				for (NoDeclaracao declaracao: vListaDeclaracoes)
					listaBlocos.add(declaracao);
			}
		}
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
	{tokenConst = null; }
	
	(tokenConst = PR_CONST)? informacaoTipoDado = declaracaoTipoDado
	
	( vDeclaracao = declaracao[tokenConst, informacaoTipoDado] 
	     { 
	     	if (gerarArvore)
	     	{
		     	if (vDeclaracao != null)	     	
			     	listaDeclaracoes.add(vDeclaracao); 
		     	
			vDeclaracao = null;
		}
	     })
	     
	(',' vDeclaracao = declaracao[tokenConst, informacaoTipoDado] 
	   { 
	   	if (gerarArvore)
	   	{
		   	if (vDeclaracao != null)
			   	listaDeclaracoes.add(vDeclaracao); 	   
		   	
			 vDeclaracao = null;
		 }
	   })*
)
;
finally
{
	pilhaContexto.pop();
}


declaracao [Token tokenConst, InformacaoTipoDado informacaoTipoDado] returns[NoDeclaracao declaracao] @init
{
	pilhaContexto.push("declaracao");
}:	

	(ID (tk1 = '[' (ind1 = expressao)? ']' (tk2 = '[' (ind2 = expressao)? ']')?)? ('=' inicializacao = expressao)?) 
	{
		if (gerarArvore)
		{
			boolean constante = (tokenConst != null);
			TipoDado tipoDado = (informacaoTipoDado != null)? informacaoTipoDado.getTipoDado() : null;
			String nome = ($ID != null)? $ID.text : null;
			
			if ((tk1 == null) && (tk2 == null))
				declaracao = new NoDeclaracaoVariavel(nome, tipoDado, constante);
			
			else
			
			if ((tk1 != null) && (tk2 == null))
				declaracao = new NoDeclaracaoVetor(nome, tipoDado, ind1, constante);
			
			else
			
			if ((tk1 != null) && (tk2 != null))
				declaracao = new NoDeclaracaoMatriz(nome, tipoDado, ind1, ind2, constante);
		
			declaracao.setInicializacao(inicializacao);
			declaracao.setTrechoCodigoFonteNome(criarTrechoCodigoFonte($ID));
			declaracao.setTrechoCodigoFonteTipoDado((informacaoTipoDado != null)? informacaoTipoDado.getTrechoCodigoFonte(): null);
		}
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
		if (gerarArvore)
		{
			informacaoTipoDado = new InformacaoTipoDado();
			informacaoTipoDado.setTipoDado(TipoDado.obterTipoDadoPeloNome(tokenTipoDado.getText()));
			informacaoTipoDado.setTrechoCodigoFonte(criarTrechoCodigoFonte(tokenTipoDado));
		}
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
		if (gerarArvore)
		{
			informacaoTipoDado = new InformacaoTipoDado();
			informacaoTipoDado.setTipoDado(TipoDado.VAZIO); 
			informacaoTipoDado.setTrechoCodigoFonte(criarTrechoCodigoFonte($PR_VAZIO));
		}
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

	(tk1 = '[' ']' (tk2 = '[' ']')? )?
	{
		if (gerarArvore)
		{
			if ((tk1 == null) && (tk2 == null)) quantificador = Quantificador.VALOR;
			else		
			if ((tk1 != null) && (tk2 == null)) quantificador = Quantificador.VETOR;
			else
			if ((tk1 != null) && (tk2 != null)) quantificador = Quantificador.MATRIZ;
		}
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
		if (gerarArvore)
		{
			if (informacao != null) informacaoTipoDado = informacao;
			
			else
			{
				informacaoTipoDado = new InformacaoTipoDado();
				informacaoTipoDado.setTipoDado(TipoDado.VAZIO);
			}
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
		
	ID '(' vListaParametros = listaParametrosFuncao ')'	
        
        '{'
		vBlocos = blocos
        '}'
        
         {
         	if (gerarArvore)
         	{
	         	NoDeclaracaoFuncao declaracaoFuncao = new NoDeclaracaoFuncao($ID.text, informacaoTipoDado.getTipoDado(), vQuantificador);
	         	declaracaoFuncao.setParametros(vListaParametros);
		declaracaoFuncao.setBlocos(vBlocos);
	
		declaracaoFuncao.setTrechoCodigoFonteNome(criarTrechoCodigoFonte($ID));
		declaracaoFuncao.setTrechoCodigoFonteTipoDado(informacaoTipoDado.getTrechoCodigoFonte());
	
	        	asa.getListaDeclaracoesGlobais().add(declaracaoFuncao);
        	}
         }
;
finally
{
	pilhaContexto.pop();
}


listaParametrosFuncao returns[List<NoDeclaracaoParametro> listaParametros] @init
{
	pilhaContexto.push("listaParametrosFuncao");
	listaParametros = new ArrayList<NoDeclaracaoParametro>();
}:
	(
		(    vDeclaracaoParametro = declaracaoParametro 
		     { 
		     	if (gerarArvore)
		     	{
			     	listaParametros.add(vDeclaracaoParametro); 
		     	}		     
		     }
		 )
		     
		(',' vDeclaracaoParametro = declaracaoParametro 
		    { 
		    	if (gerarArvore)
		    	{
			    	listaParametros.add(vDeclaracaoParametro); 
		    	}		    
		    }
		  )*
	)?
;
finally
{
	pilhaContexto.pop();
}


declaracaoParametro returns[NoDeclaracaoParametro parametro] @init
{
	pilhaContexto.push("declaracaoParametro");
}:

	informacaoTipoDado = declaracaoTipoDado (tkr = '&')? ID vQuantificador = quantificador
	{
		if (gerarArvore)
		{
			ModoAcesso modoAcesso = null;
			TipoDado tipoDado = null;
			TrechoCodigoFonte trechoCodigoFonteTipoDado = null;
			
			if (tkr == null) modoAcesso = ModoAcesso.POR_VALOR;
			else
			if (tkr != null) modoAcesso = ModoAcesso.POR_REFERENCIA;
			
			if (informacaoTipoDado != null) 
			{
				tipoDado = informacaoTipoDado.getTipoDado();
				trechoCodigoFonteTipoDado = informacaoTipoDado.getTrechoCodigoFonte();
			}
			
			parametro = new NoDeclaracaoParametro($ID.text, tipoDado, vQuantificador, modoAcesso);
			parametro.setTrechoCodigoFonteNome(criarTrechoCodigoFonte($ID));
			parametro.setTrechoCodigoFonteTipoDado(trechoCodigoFonteTipoDado);
		}
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
finally
{
	pilhaContexto.pop();
}


para returns[NoPara para] @init
{
	pilhaContexto.push("para");
}:

	PR_PARA '(' (inicializacao = inicializacaoPara)? ';' (condicao = expressao)? ';' (incremento = expressao)? ')' vBlocos = listaBlocos
	{
		if (gerarArvore)
		{
			para = new NoPara();
			para.setInicializacao(inicializacao);
			para.setCondicao(condicao);
			para.setIncremento(incremento);		
			para.setBlocos(vBlocos);
		}
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
		if (gerarArvore)
		{
			if (vExpressao != null) bloco = vExpressao;
			else
			if (vExpressao == null) bloco = vListaDeclaracoes.get(0);
		}
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
	('{')=> '{' vListaBlocos = blocos { listaBlocos = vListaBlocos; } '}'
	  
	|
	
	vBloco = bloco
	{ 
		if (gerarArvore)
		{
			listaBlocos = new ArrayList<NoBloco>();
			listaBlocos.add(vBloco);
		}
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
		if (gerarArvore)
		{
			pare = new NoPare();
		}
	}

;
finally
{
	pilhaContexto.pop();
}


escolha returns[NoEscolha escolha] @init
{
	pilhaContexto.push("escolha");
}:

	PR_ESCOLHA '(' vExpressao = expressao ')'
	'{' 
		vListaCasos = listaCasos
	'}'
	 {
	 	if (gerarArvore)
	 	{
			escolha = new NoEscolha(vExpressao);
			escolha.setCasos(vListaCasos);
		}
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
	 ( casoContrario |PR_CASO vExpressao = expressao) ':' vBlocos = blocosCaso
	{
		if (gerarArvore)
		{
			NoCaso caso = new NoCaso(vExpressao);
			caso.setBlocos(vBlocos);
			casos.add(caso);
			
			vExpressao = null;
		}
	}
)*
;
finally
{
	pilhaContexto.pop();
}


casoContrario @init
{
	pilhaContexto.push("casoContrario");
}: 
	PR_CASO_CONTRARIO
;
finally
{
	pilhaContexto.pop();
}


blocosCaso returns[List<NoBloco> listaBlocos] @init
{
	pilhaContexto.push("blocosCaso");
}:

	( ('{')=> ('{' vBlocos = blocos '}') | (vBlocos = blocos))
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
	
	PR_ENQUANTO '(' vExpressao = expressao ')' vListaBlocos = listaBlocos
	{
		if (gerarArvore)
		{
			enquanto = new NoEnquanto(vExpressao);
			enquanto.setBlocos(vListaBlocos);
		}
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

	PR_FACA vListaBlocos = listaBlocos PR_ENQUANTO '(' vExpressao = expressao ')'
	{
		if (gerarArvore)
		{
			facaEnquanto = new NoFacaEnquanto(vExpressao);
			facaEnquanto.setBlocos(vListaBlocos);
		}
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
 
	PR_SE '(' vExpressao = expressao ')' vListaBlocos = listaBlocos (PR_SENAO listaBlocosSenao = listaBlocos)?
	{
		if (gerarArvore)
		{
			se = new NoSe(vExpressao);
			se.setBlocosVerdadeiros(vListaBlocos);
			se.setBlocosFalsos(listaBlocosSenao);
		}
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
		if (gerarArvore)
		{
			retorne = new NoRetorne(vExpressao);
		}
	}
;
finally
{
	pilhaContexto.pop();
}	


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
		(operador = '=' | operador = '+=' | operador = '-=' | operador = '/=' | operador = '*=' | operador = '%=')
		
		operandoDireito = expressao2
		{
			if (gerarArvore)
			{
				vPilha.push(operador);
				vPilha.push(operandoDireito);
			}
		}
	)*	
	{	
		if (gerarArvore)
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
		
			if (gerarArvore)
			{
				if (operandoDireito != null)
				{
					NoOperacao operacao = new NoOperacao(Operacao.obterOperacaoPeloOperador(operador.getText()), operandoEsquerdo, operandoDireito);
					operacao.setTrechoCodigoFonteOperador(criarTrechoCodigoFonte(operador));
				 	operandoEsquerdo = operacao; 
				 }
			 }
		}       
			
		(operador = 'e' | operador = 'ou')
		
		operandoDireito = expressao3
	)*
	{
		if (gerarArvore)
		{
			expressao = selecionarExpressao(operandoEsquerdo, operandoDireito, operador);
		}
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
			if (gerarArvore)
			{
		
				if (operandoDireito != null)
				{
					NoOperacao operacao = new NoOperacao(Operacao.obterOperacaoPeloOperador(operador.getText()), operandoEsquerdo, operandoDireito);
					operacao.setTrechoCodigoFonteOperador(criarTrechoCodigoFonte(operador));
				 	operandoEsquerdo = operacao; 
				 }
			 }
		}
		
		(operador = '==' | operador = '!=') 
		
		operandoDireito = expressao4
	)*
	{
		if (gerarArvore)
		{
			expressao = selecionarExpressao(operandoEsquerdo, operandoDireito, operador);
		}
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

	operandoEsquerdo = expressao5 ((operador = '>=' | operador = '<=' | operador = '<' | operador = '>') operandoDireito = expressao5)?
	{
		if (gerarArvore)
		{
			expressao = selecionarExpressao(operandoEsquerdo, operandoDireito, operador);
		}
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
			if (gerarArvore)
			{
				if (operandoDireito != null)
				{
					NoOperacao operacao = new NoOperacao(Operacao.obterOperacaoPeloOperador(operador.getText()), operandoEsquerdo, operandoDireito);
					operacao.setTrechoCodigoFonteOperador(criarTrechoCodigoFonte(operador));
				 	operandoEsquerdo = operacao; 
				 }
			 }
		}

			
		(operador = '+' operandoDireito = expressao6) | ('-')=> operador = '-' operandoDireito = expressao6
		
		
	)*
	{
		if (gerarArvore)
		{
			expressao = selecionarExpressao(operandoEsquerdo, operandoDireito, operador);
		}
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
			if (gerarArvore)
			{
				if (operandoDireito != null)
				{
					NoOperacao operacao = new NoOperacao(Operacao.obterOperacaoPeloOperador(operador.getText()), operandoEsquerdo, operandoDireito);
					operacao.setTrechoCodigoFonteOperador(criarTrechoCodigoFonte(operador));
				 	operandoEsquerdo = operacao; 
				 }
			 }
		}

			
		(operador = '*' | operador = '/' | operador = '%') 
		
		operandoDireito = expressao7
	)*
	{
		if (gerarArvore)
		{
			expressao = selecionarExpressao(operandoEsquerdo, operandoDireito, operador);
		}
	}
;
finally
{
	pilhaContexto.pop();
}


expressao7 returns[NoExpressao expressao] @init
{
	pilhaContexto.push("expressao7");
}:

	(('-') => (listaTokenMenos += '-')? | (listaTokenNao += OPERADOR_NAO)*)  vExpressao = expressao8
	{
		if (gerarArvore)
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
	}
;
finally
{
	pilhaContexto.pop();
}


expressao8 returns[NoExpressao expressao] @init
{
	pilhaContexto.push("expressao8");
}:	
	
	('(' vExpressao = expressao ')' | vExpressao = tipoPrimitivo | vExpressao = referencia | vExpressao = matrizVetor) 
	
		(operador = '++' | operador = '--')?
	{
		if (gerarArvore)
		{
			if (operador != null)
			{
				if (operador.getText().equals("++")) expressao = new NoIncremento(vExpressao);
				else
				if (operador.getText().equals("--")) expressao = new NoDecremento(vExpressao);
			}
			
			else expressao = vExpressao;
		}
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
		if (gerarArvore)
		{
			NoReal real = new NoReal(Double.parseDouble($REAL.text));
			real.setTrechoCodigoFonte(criarTrechoCodigoFonte($REAL));
			expressao = real;
		}
	} 
	
	|
	
	LOGICO
	{
		if (gerarArvore)
		{
			NoLogico logico = new NoLogico(($LOGICO.text.equals("verdadeiro")? true : false));
			logico.setTrechoCodigoFonte(criarTrechoCodigoFonte($LOGICO));
			expressao = logico;
		}
	} 
	
	|
	
	CADEIA
	{
		if (gerarArvore)
		{
			String texto = $CADEIA.text;
			NoCadeia cadeia = new NoCadeia(texto.substring(1, texto.length() - 1));
			cadeia.setTrechoCodigoFonte(criarTrechoCodigoFonte($CADEIA));
			expressao = cadeia;
		}
	}
	
	|
	
	INTEIRO
	{
		if (gerarArvore)
		{
			NoInteiro inteiro = new NoInteiro(Integer.parseInt($INTEIRO.text));
			inteiro.setTrechoCodigoFonte(criarTrechoCodigoFonte($INTEIRO));
			expressao = inteiro;
		}
	} 
	
	| 
	
	CARACTER
	{
		if (gerarArvore)
		{
			NoCaracter caracter = new NoCaracter($CARACTER.text.charAt(1));
			caracter.setTrechoCodigoFonte(criarTrechoCodigoFonte($CARACTER));
			expressao = caracter;
		}
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
		('(') => vExpressao = chamadaFuncao[$ID.text] |
		('[') => vExpressao = referenciaVetorMatriz[$ID.text] |
			 vExpressao = referenciaId[$ID.text]
	)
	{
		if (gerarArvore)
		{
			referencia = (NoReferencia) vExpressao;
			referencia.setTrechoCodigoFonteNome(criarTrechoCodigoFonte($ID));
		}
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
		if (gerarArvore)
		{
			expressao = new NoReferenciaVariavel(nome);
		}
	}

;
finally
{
	pilhaContexto.pop();
}


referenciaVetorMatriz [ String nome] returns[NoExpressao expressao] @init
{
	pilhaContexto.push("referenciaVetorMatriz");
}:
	
	'[' indice1 = expressao ']' ('[' indice2 = expressao ']')?
	 {
		if (gerarArvore)
		{
		 	if ((indice1 != null) && (indice2 == null)) expressao = new NoReferenciaVetor(nome, indice1);
			else		
			if ((indice1 != null) && (indice2 != null)) expressao = new NoReferenciaMatriz(nome, indice1, indice2);		
		}
	 }
;
finally
{
	pilhaContexto.pop();
}


chamadaFuncao [String nome] returns[NoExpressao expressao] @init
{
	pilhaContexto.push("chamadaFuncao");
}:
	
	'(' (vListaParametros = listaParametros)? ')'
	 {
 		if (gerarArvore)
 		{
			NoChamadaFuncao chamadaFuncao = new NoChamadaFuncao(nome);
			chamadaFuncao.setParametros(vListaParametros);
			expressao = chamadaFuncao;
		}
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
	(   vExpressao = expressao 
	   {
		if (gerarArvore) 
		{
			listaParametros.add(vExpressao); 
		}
	   }
	)
	
	(',' vExpressao = expressao 
	
		{ 
			if (gerarArvore)
			{
				listaParametros.add(vExpressao); 
			}
		}
	)*
;
finally
{
	pilhaContexto.pop();
}


matrizVetor returns[NoExpressao expressao] @init
{
	pilhaContexto.push("matrizVetor");
}:
	
	(('{' '{')=> vExpressao = matriz | vExpressao = vetor)
	{
		if (gerarArvore)
		{
			expressao = vExpressao;
		}
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

	'{' vListaExpressoes = listaExpressoes '}'
	 {
		if (gerarArvore)
		{
			expressao = new NoVetor(vListaExpressoes);
		}
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
	
	'{'
		vListaListaExpressoes = listaListaExpressoes
	'}'
	 {
		if (gerarArvore)
	 	{
			expressao = new NoMatriz(vListaListaExpressoes);
		}
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
	( '{' vListaExpressoes = listaExpressoes '}' 
		{
			if (gerarArvore)
			{
				 listaListaExpressoes.add(vListaExpressoes); 
			 }
		}
	)
	( { vListaExpressoes = null; } ','  '{' vListaExpressoes = listaExpressoes '}' 
	
	   { 
	   	if (gerarArvore)
	   	{
		   	listaListaExpressoes.add(vListaExpressoes); 
	   	}
	   })*

;
finally
{
	pilhaContexto.pop();
}


listaExpressoes returns[List<Object> listaExpressoes] @init
{
	pilhaContexto.push("listaExpressoes");
	listaExpressoes = new ArrayList<Object>();
}:
	({ vExpressao = null; }     (vExpressao = expressao)? 
	 { 
	 	if (gerarArvore)
	 	{
		 	listaExpressoes.add(vExpressao); 
	 	}
	 })
	({ vExpressao = null; } ',' (vExpressao = expressao)? 
	{
		if (gerarArvore)
		{
		 	listaExpressoes.add(vExpressao); 
	 	}
	 })*
;
finally
{
	pilhaContexto.pop();
}
