lexer grammar PortugolLexer;

@header
{
	package br.univali.portugol.nucleo.analise.sintatica;
}

ABRE_CH 				:	'{'		;
FECHA_CH				:	'}'		;
ABRE_PAR				:	'('		;
FECHA_PAR				:	')'		;
ABRE_COL				:	'['		;
FECHA_COL				:	']'		;
VIRGULA				:	','		;
PONTO_VIRGULA			:	';'		;
DOIS_PONTOS			:	':'		;
OP_MENOR_IGUAL			:	'<='		;
OP_MAIOR_IGUAL			:	'>='		;
OP_IGUALDADE			:	'=='		;
OP_DIFERENCA			:	'!='		;
OP_SOMA_ACUM			:	'+='		;
OP_DIV_ACUM			:	'/='		;
OP_SUB_ACUM			:	'-='		;
OP_MULT_ACUM			:	'*='		;
OP_MOD_ACUM			:	'%='		;
OP_INCREMENTO			:	'++'		;
OP_DECREMENTO			:	'--'		;
OP_SOMA				:	'+'		;
OP_SUBTRACAO			:	'-'		;
OP_MULTIPLICACAO		:	'*'		;
OP_DIVISAO				:	'/'		;
OP_MODULO			:	'%'		;
OP_ATRIB				:	'='		;
OP_MAIOR				:	'>'		;
OP_MENOR				:	'<'		;
OP_REFERENCIA			:	'&'		;
OP_E					:	'e'		;
OP_OU				:	'ou'		;
OP_NAO				:	'nao'		;

PR_PROGRAMA		  	:	'programa'	;
PR_REAL				:	'real'		;
PR_VAZIO				:	'vazio'		;
PR_LOGICO				:	'logico'		;
PR_CADEIA				:	'cadeia'	;
PR_INTEIRO				:	'inteiro'	;
PR_CARACTER			:	'caracter'	;
PR_ESCOLHA			:	'escolha'	;
PR_CASO				:	'caso'		;
PR_CONTRARIO			:	'contrario'	;
PR_CONST				:	'const'		;
PR_FUNCAO				:	'funcao'	;
PR_RETORNE			:	'retorne'	;  
PR_PARA				:	'para'		;
PR_PARE				:	'pare'		;
PR_FACA				:	'faca'		;
PR_ENQUANTO			:	'enquanto'	;
PR_SE					:	'se'		;
PR_SENAO				:	'senao'		;
    
fragment PR_FALSO			:	'falso'		;
fragment PR_VERDADEIRO		:	'verdadeiro'	;

LOGICO				: 	PR_VERDADEIRO | PR_FALSO  ;

ID 					:	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*  ;

INTEIRO 				:	'0'..'9'* ;

REAL					: 	('0'..'9')+ '.' ('0'..'9')+ ;
    
CADEIA				:	'"' ( SEQ_ESC | ~('\\'|'"') )* '"'  ;

CARACTER				:  	'\'' ( SEQ_ESC | ~('\''|'\\') ) '\''  ;

EB					:	( ' ' | '\t' | '\r' | '\n')  {$channel=HIDDEN;}  ;

fragment DIGIT_HEX 		: 	('0'..'9'|'a'..'f'|'A'..'F')  ;

fragment SEQ_ESC			:	 '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')  |   ESC_UNICODE  |   ESC_OCTAL   ;

fragment ESC_OCTAL		:	'\\' ('0'..'3') ('0'..'7') ('0'..'7')  |   '\\' ('0'..'7') ('0'..'7')    |   '\\' ('0'..'7')    ;

fragment ESC_UNICODE		:	'\\' 'u' DIGIT_HEX DIGIT_HEX DIGIT_HEX DIGIT_HEX  ;

COMENTARIO			:   

	'//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}    	|  
	
	 '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
 ;