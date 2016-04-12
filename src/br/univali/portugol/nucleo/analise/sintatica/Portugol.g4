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

GAMBIARRA 	:	'.' |'á'| 'à'| 'ã'|'â'|'é'|'ê'|'í'|'ó'|'ô'|'õ'|'ú'|'ü'|'ç'|'??'|'À'|'Ã'|'Â'|'É'|'Ê'|'??'|'Ó'|'Ô'|'Õ'|'Ú'|'Ü'|'Ç'|'#'|'$'|'"'|'§'|'?'|'¹'|'²'|'³'|'£'|'¢'|'¬'|'ª'|'º'|'~'|'\''|'`'|'\\'|'@';

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
	('//' ~('\n'|'\r')* '\r'? '\n'
        | 
        '/*' .*? '*/') -> channel(HIDDEN)
 ;

programa: PR_PROGRAMA '{' inclusaoBiblioteca* (declaracoesGlobais | declaracaoFuncao)* '}';

inclusaoBiblioteca: PR_INCLUA PR_BIBLIOTECA ID ('-->' ID)?;

declaracoesGlobais: listaDeclaracoes;

declaracoesLocais: listaDeclaracoes;

listaDeclaracoes: ((PR_CONST)? declaracaoTipoDado (declaracao)(',' declaracao)*);

declaracao: (ID ('[' (expressao)? ']' ('[' (expressao)? ']')?)? (expressao)?);

declaracaoTipoDado: (PR_INTEIRO | PR_REAL | PR_CARACTER | PR_CADEIA | PR_LOGICO);

declaracaoTipoDadoVazio: PR_VAZIO;

quantificador: ('[' ']' ('[' ']')? )?;

tipoRetornoFuncao: (declaracaoTipoDado | declaracaoTipoDadoVazio)?;

declaracaoFuncao: PR_FUNCAO tipoRetornoFuncao quantificador ID '(' listaParametrosFuncao ')' '{' blocos '}';

listaParametrosFuncao:((declaracaoParametro)(',' declaracaoParametro)*)?;

declaracaoParametro: declaracaoTipoDado ('&')? ID quantificador;

blocos:(bloco | declaracoesLocais)*;

bloco:	(
          expressao
        | para
        | pare
        | retorne
        | se
        | enquanto
        | facaEnquanto
        | escolha
        );

para: PR_PARA '(' (inicializacaoPara)? ';' (expressao)? ';' (expressao)? ')'listaBlocos;

inicializacaoPara: (expressao | listaDeclaracoes);

listaBlocos: ('{' blocos '}' | bloco);

pare: PR_PARE;

escolha: PR_ESCOLHA '(' expressao ')' '{' (PR_CASO  expressao ':' blocosCaso)+ (PR_CASO PR_CONTRARIO ':' blocosCaso)?'}';

blocosCaso:('{' blocos '}') | (blocos);

enquanto: PR_ENQUANTO '(' expressao ')' listaBlocos;

facaEnquanto: PR_FACA listaBlocos PR_ENQUANTO '(' expressao ')';

se: PR_SE '(' expressao ')' listaBlocos (PR_SENAO listaBlocos)?;

retorne: PR_RETORNE expressao?;	

expressao: expressao2 (
	(
           '='   | 
           '+='  | 
           '-='  | 
           '/='  | 
           '*='  | 
           '%='  | 
           '>>=' |
           '<<=' | 
           '|='  | 
           '&='  | 
           '^='
        ) 	
	expressao2)*;

expressao2: expressao2_5 (( 'e' |  'ou')  expressao2_5)*;

expressao2_5:  expressao3(( '==' |  '!=')  expressao3)*;

expressao3:  expressao3_5 (( '>=' |  '<=' |  '<' |  '>')  expressao3_5)?;

expressao3_5:  expressao4_5 (( '&' |  '|' |  '^')  expressao4_5)*;

expressao4_5:  expressao5 (( '<<' |  '>>') expressao5)*;

expressao5:  expressao6 (( '+'  expressao6) | ( '-'  expressao6))*;

expressao6:  expressao7 (( '*' |  '/' |  '%')  expressao7)*;

expressao7: ((listaTokenMenos += '-')? | (listaTokenNao += OPERADOR_NAO)* | listaTokenNot += '~' )   expressao8;

expressao8:(  '('  expressao  ')' |  referencia|  tipoPrimitivo |  matrizVetor) ( '++' |  '--')?;

tipoPrimitivo: REAL | LOGICO | CADEIA | INTEIRO | CARACTER; 

referencia: ( ID |  ID_BIBLIOTECA) 
            (
             chamadaFuncao | 
             referenciaVetorMatriz
            );

referenciaVetorMatriz: '['  expressao ']' ('['  expressao ']')?;

chamadaFuncao: '(' ( listaParametros)? ')';

listaParametros: ( expressao)(','  expressao)*;

matrizVetor: ( matriz |  vetor);

vetor:  '{'  listaExpressoes  '}';

matriz:	 '{'  listaListaExpressoes  '}';

listaListaExpressoes:( '{'  listaExpressoes '}')? (','  '{'  listaExpressoes '}' )*;

listaExpressoes: (( expressao)?) (',' ( expressao))*;