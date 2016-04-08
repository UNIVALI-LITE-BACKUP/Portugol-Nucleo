grammar Portugol;

PR_PROGRAMA     :   'programa';
PR_REAL         :   'real';
PR_VAZIO        :   'vazio';
PR_LOGICO       :   'logico';
PR_CADEIA       :   'cadeia';
PR_INTEIRO      :   'inteiro';
PR_CARACTER     :   'caracter';    
PR_ESCOLHA      :   'escolha';
PR_CASO         :   'caso';
PR_CONTRARIO    :   'contrario'	;
PR_CONST        :   'const';
PR_FUNCAO       :   'funcao';
PR_RETORNE      :   'retorne';  
PR_PARA         :   'para';
PR_PARE         :   'pare';
PR_FACA         :   'faca';
PR_ENQUANTO     :   'enquanto';
PR_SE           :   'se';
PR_SENAO        :   'senao';
PR_INCLUA       :   'inclua';
PR_BIBLIOTECA   :   'biblioteca';

GAMBIARRA 	:	'.' |'á'| 'à'| 'ã'|'â'|'é'|'ê'|'í'|'ó'|'ô'|'õ'|'ú'|'ü'|'ç'|'�?'|'À'|'Ã'|'Â'|'É'|'Ê'|'�?'|'Ó'|'Ô'|'Õ'|'Ú'|'Ü'|'Ç'|'#'|'$'|'"'|'§'|'?'|'¹'|'²'|'³'|'£'|'¢'|'¬'|'ª'|'º'|'~'|'\''|'`'|'\\'|'@';

fragment PR_FALSO       :	'falso';
fragment PR_VERDADEIRO	:	'verdadeiro';

OPERADOR_NAO		:	'nao';

LOGICO			: 	PR_VERDADEIRO | PR_FALSO;

ID 			:	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

ID_BIBLIOTECA		:	ID '.' ID;

INTEIRO 		:	'0'..'9'+ | ('0x'|'0X')(DIGIT_HEX)+ | ('0b'|'0B')('0'|'1')+;

REAL			: 	('0'..'9')+ '.' ('0'..'9')+;
    
CADEIA			:	'"' ( SEQ_ESC | ~('\\'|'"') )* '"';

CARACTER		:  	'\'' ( SEQ_ESC | ~('\''|'\\') ) '\'';

ESPACO			:	( ' ' | '\t' | '\r' | '\n') -> channel(HIDDEN);

fragment DIGIT_HEX	: 	('0'..'9'|'a'..'f'|'A'..'F');

fragment SEQ_ESC	:	 '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')  |   ESC_UNICODE  |   ESC_OCTAL;

fragment ESC_OCTAL	:	'\\' ('0'..'3') ('0'..'7') ('0'..'7')  |   '\\' ('0'..'7') ('0'..'7')    |   '\\' ('0'..'7');

fragment ESC_UNICODE	:	'\\' 'u' DIGIT_HEX DIGIT_HEX DIGIT_HEX DIGIT_HEX;

COMENTARIO	
    :   
        ( '//' ~[\r\n]* '\r'? '\n'
        | '/*' .*? '*/'
        ) -> channel(HIDDEN)
    ;

programa: PR_PROGRAMA '{' inclusaoBiblioteca* (declaracoesGlobais | declaracaoFuncao)* '}';

inclusaoBiblioteca: PR_INCLUA PR_BIBLIOTECA nome = ID ('-->'  alias = ID)?;

declaracoesGlobais: vListaDeclaracoes = listaDeclaracoes;

declaracoesLocais: vListaDeclaracoes = listaDeclaracoes;

listaDeclaracoes: ((tokenConst = PR_CONST)? informacaoTipoDado = declaracaoTipoDado ( vDeclaracao = declaracao)(',' vDeclaracao = declaracao)*);

declaracao: (ID (tk1 = '[' (ind1 = expressao)? ']' (tk2 = '[' (ind2 = expressao)? ']')?)? ('=' inicializacao = expressao)?);

declaracaoTipoDado: (tokenTipoDado = PR_INTEIRO | tokenTipoDado = PR_REAL | tokenTipoDado = PR_CARACTER | tokenTipoDado = PR_CADEIA | tokenTipoDado = PR_LOGICO);

declaracaoTipoDadoVazio: PR_VAZIO;

quantificador: (tk1 = '[' ']' (tk2 = '[' ']')? )?;

tipoRetornoFuncao: (informacao = declaracaoTipoDado | informacao = declaracaoTipoDadoVazio)?;

declaracaoFuncao: PR_FUNCAO informacaoTipoDado = tipoRetornoFuncao vQuantificador = quantificador ID '(' vListaParametros = listaParametrosFuncao ')' '{' vBlocos = blocos '}';

listaParametrosFuncao:((vDeclaracaoParametro = declaracaoParametro)(',' vDeclaracaoParametro = declaracaoParametro)*)?;

declaracaoParametro: informacaoTipoDado = declaracaoTipoDado (tkr = '&')? ID vQuantificador = quantificador;

blocos:(vBloco = bloco | declaracoesLocais)*;

bloco:	(
          vExpressao = expressao
        | vPara = para
        | vPare = pare
        | vRetorne = retorne
        | vSe = se
        | vEnquanto = enquanto
        | vFacaEnquanto = facaEnquanto
        | vEscolha = escolha
        );

para: PR_PARA '(' (inicializacao = inicializacaoPara)? ';' (condicao = expressao)? ';' (incremento = expressao)? fp = ')' vBlocos = listaBlocos;

inicializacaoPara: (vExpressao = expressao | vListaDeclaracoes = listaDeclaracoes);

listaBlocos: ('{' vListaBlocos = blocos '}' | vBloco = bloco);

pare: PR_PARE;

escolha: PR_ESCOLHA '(' vExpressaoEscolha = expressao ')' '{' (PR_CASO vExpressao = expressao ':' vBlocos = blocosCaso)+ (PR_CASO PR_CONTRARIO ':' vBlocos = blocosCaso)?'}';

blocosCaso:('{' vBlocos = blocos '}') | (vBlocos = blocos);

enquanto: PR_ENQUANTO '(' vExpressao = expressao ')' vListaBlocos = listaBlocos;

facaEnquanto: PR_FACA vListaBlocos = listaBlocos PR_ENQUANTO '(' vExpressao = expressao ')';

se: PR_SE '(' vExpressao = expressao ')' vListaBlocos = listaBlocos (PR_SENAO listaBlocosSenao = listaBlocos)?;

retorne: PR_RETORNE vExpressao = expressao?;	

pilha:;

expressao: operandoEsquerdo = expressao2 vPilha = pilha (
	(
           operador = '='   | 
           operador = '+='  | 
           operador = '-='  | 
           operador = '/='  | 
           operador = '*='  | 
           operador = '%='  | 
           operador = '>>=' |
           operador = '<<=' | 
           operador = '|='  | 
           operador = '&='  | 
           operador = '^='
        ) 	
	operandoDireito = expressao2)*;

expressao2: operandoEsquerdo = expressao2_5 ((operador = 'e' | operador = 'ou') operandoDireito = expressao2_5)*;

expressao2_5: operandoEsquerdo = expressao3((operador = '==' | operador = '!=') operandoDireito = expressao3)*;

expressao3: operandoEsquerdo = expressao3_5 ((operador = '>=' | operador = '<=' | operador = '<' | operador = '>') operandoDireito = expressao3_5)?;

expressao3_5: operandoEsquerdo = expressao4_5 ((operador = '&' | operador = '|' | operador = '^') operandoDireito = expressao4_5)*;

expressao4_5: operandoEsquerdo = expressao5 ((operador = '<<' | operador = '>>')operandoDireito = expressao5)*;

expressao5: operandoEsquerdo = expressao6 ((operador = '+' operandoDireito = expressao6) | (operador = '-' operandoDireito = expressao6))*;

expressao6: operandoEsquerdo = expressao7 ((operador = '*' | operador = '/' | operador = '%') operandoDireito = expressao7)*;

expressao7: ((listaTokenMenos += '-')? | (listaTokenNao += OPERADOR_NAO)* | listaTokenNot += '~' )  vExpressao = expressao8;

expressao8:( ab = '(' vExpressao = expressao fp = ')' | vExpressao = referencia| vExpressao = tipoPrimitivo | vExpressao = matrizVetor) (operador = '++' | operador = '--')?;

tipoPrimitivo: REAL | LOGICO | CADEIA | INTEIRO | CARACTER; 

referencia: (id = ID | id = ID_BIBLIOTECA) 
            (
            vExpressao = chamadaFuncao | 
            vExpressao = referenciaVetorMatriz |
            vExpressao = referenciaId
            );

referenciaId:;

referenciaVetorMatriz: '[' indice1 = expressao ']' ('[' indice2 = expressao ']')?;

chamadaFuncao: '(' (vListaParametros = listaParametros)? ')';

listaParametros: (vExpressao = expressao)(',' vExpressao = expressao)*;

matrizVetor: (vExpressao = matriz | vExpressao = vetor);

vetor: abre_ch = '{' vListaExpressoes = listaExpressoes fecha_ch = '}';

matriz:	abre_ch = '{' vListaListaExpressoes = listaListaExpressoes fecha_ch = '}';

listaListaExpressoes:( '{' vListaExpressoes = listaExpressoes '}')? (','  '{' vListaExpressoes = listaExpressoes '}' )*;

listaExpressoes: ((vExpressao = expressao)?) (',' (vExpressao = expressao))*;