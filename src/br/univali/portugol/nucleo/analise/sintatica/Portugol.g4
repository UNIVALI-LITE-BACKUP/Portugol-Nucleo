/*
Dicas:
1)
Nunca faça isso:
ATRIBUICAO_DIRETA       :       '=';
ATRIBUICOES             :       ATRIBUICAO_DIRETA | '+=' | '-=' | '/=' | '*=' | '%=' | '>>=' | '<<=' | '|=' | '&=' | '^=';
ou isto
ATRIBUICAO_DIRETA       :       '=';
ATRIBUICOES             :       '=' | '+=' | '-=' | '/=' | '*=' | '%=' | '>>=' | '<<=' | '|=' | '&=' | '^=';
No lugar faça isto:
ATRIBUICAO_DIRETA       :       '=';
ATRIBUICOES             :       '+=' | '-=' | '/=' | '*=' | '%=' | '>>=' | '<<=' | '|=' | '&=' | '^=';
E use os 2 tokens quando precisar dos 2 :P
Sério, eu perdia dias por causa disto.
*/
grammar Portugol;
//Lexico
//PR - Palavra Reservada


PR_PROGRAMA     :   'programa';

PR_CONST        :   'const';

PR_TIPO_DA_VAR_OU_CONST  :   PR_REAL | PR_LOGICO | PR_CADEIA | PR_INTEIRO | PR_CARACTER ;
PR_TIPO_DA_FUNCAO  :   PR_REAL | PR_LOGICO | PR_CADEIA | PR_INTEIRO | PR_CARACTER | PR_VAZIO;
fragment PR_REAL         :   'real';
fragment PR_VAZIO        :   'vazio';
fragment PR_LOGICO       :   'logico';
fragment PR_CADEIA       :   'cadeia';
fragment PR_INTEIRO      :   'inteiro';
fragment PR_CARACTER     :   'caracter';

PR_SE           :   'se';
PR_SENAO        :   'senao';

PR_ESCOLHA      :   'escolha';
PR_CASO         :   'caso';
PR_CONTRARIO    :   'contrario'	;

PR_FACA         :   'faca';
PR_ENQUANTO     :   'enquanto';
PR_PARA         :   'para';

PR_PARE         :   'pare';

PR_FUNCAO       :   'funcao';
PR_RETORNE      :   'retorne';

PR_INCLUA_BIBLIOTECA       :   'inclua biblioteca';

//GAMBIARRA 	:	'.' |'á'| 'à'| 'ã'|'â'|'é'|'ê'|'í'|'ó'|'ô'|'õ'|'ú'|'ü'|'ç'|'??'|'À'|'Ã'|'Â'|'É'|'Ê'|'??'|'Ó'|'Ô'|'Õ'|'Ú'|'Ü'|'Ç'|'#'|'$'|'"'|'§'|'?'|'¹'|'²'|'³'|'£'|'¢'|'¬'|'ª'|'º'|'~'|'\''|'`'|'\\'|'@';


//Definições
LOGICO			: 	PR_VERDADEIRO | PR_FALSO;
fragment PR_FALSO       :	'falso';
fragment PR_VERDADEIRO	:	'verdadeiro';
OPERADOR_NAO		:	'nao';


ATRIBUICAO_DIRETA       :       '=';
ATRIBUICOES             :       '+=' | '-=' | '/=' | '*=' | '%=' | '>>=' | '<<=' | '|=' | '&=' | '^=';

REAL			: 	('0'..'9')+ '.' ('0'..'9')+;
INTEIRO 		:	'0'..'9'+ | ('0x'|'0X')(DIGIT_HEX)+ | ('0b'|'0B')('0'|'1')+;
CADEIA			:	'"' ( SEQ_ESC | ~('\\'|'"') )* '"';
CARACTER		:  	'\'' ( SEQ_ESC | ~('\''|'\\') ) '\'';

fragment DIGIT_HEX	: 	('0'..'9'|'a'..'f'|'A'..'F');
fragment SEQ_ESC	:	 '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')  |   ESC_UNICODE  |   ESC_OCTAL;
fragment ESC_OCTAL	:	'\\' ('0'..'3') ('0'..'7') ('0'..'7')  |   '\\' ('0'..'7') ('0'..'7')    |   '\\' ('0'..'7');
fragment ESC_UNICODE	:	'\\' 'u' DIGIT_HEX DIGIT_HEX DIGIT_HEX DIGIT_HEX;

ESPACO			:	( ' ' | '\t' | '\r' | '\n') -> channel(HIDDEN);

COMENTARIO
    :   
	('//' ~('\n'|'\r')* '\r'? '\n'
        | 
        '/*' .*? '*/') -> channel(HIDDEN)
    ;

ID_BIBLIOTECA		:	ID '.' ID;
ID 			:	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

//Expressões
expressao: 
         ( '('  expressao  ')' |  referencia |  tipo_primitivo ) ( '++' |  '--' )?
         | op_negacao expressao
         | expressao op_mult_div_mod expressao
         | expressao op_soma_sub expressao
         | expressao op_bit_shift expressao
         | expressao op_bit_logica expressao
         | expressao op_logica expressao
         | expressao op_igualdade expressao
         | expressao op_logica_eou expressao
         ;
op_negacao:  '-' | (OPERADOR_NAO)+ | '~' ;
op_mult_div_mod: '*' |  '/' |  '%'; 
op_soma_sub: '+' | '-';
op_bit_shift: '<<' | '>>';
op_bit_logica:  '&' |  '|' |  '^' ;
op_logica: '>=' |  '<=' |  '<' |  '>';
op_igualdade: '==' |  '!=';
op_logica_eou: 'e' |  'ou';
tipo_primitivo: REAL | LOGICO | CADEIA | INTEIRO | CARACTER; 

referencia: referencia_chamada_funcao | referencia_variavel_constante;

referencia_chamada_funcao: (ID | ID_BIBLIOTECA) '(' ((referencia ',')* referencia)? ')';
referencia_variavel_constante: (ID | ID_BIBLIOTECA) posicao_dimensional? ;

posicao_dimensional: ('['  expressao ']')+;
//Atribuições
atribuicao_var: ID atribuicao_simples; 
atribuicao_var_dimensional: ID posicao_dimensional atribuicao_simples; 
atribuicao_definicao: ATRIBUICAO_DIRETA expressao;
atribuicao_definicao_dimensional: ATRIBUICAO_DIRETA lista_dimensional;
//*Auxiliares
atribuicao_simples: (ATRIBUICOES | ATRIBUICAO_DIRETA) expressao;
lista_dimensional: '{' ((expressao|lista_dimensional) ',')* (expressao|lista_dimensional) '}';

//Definições, fluxo do programa
programa: PR_PROGRAMA '{' definicao_global* '}';
definicao_global: 
                definicao_variaveis
                | definicao_constantes
                | definicao_funcao 
                | definicao_biblioteca;

//Definições fixas (só podem ser colocadas no escopo do programa)
definicao_biblioteca: PR_INCLUA_BIBLIOTECA ID ('-->' ID)?;
definicao_funcao: PR_FUNCAO PR_TIPO_DA_FUNCAO? ID funcao_parametros '{' comando* '}';
//*Auxiliares
funcao_parametros: '(' ((definicao_funcao_parametros ',')* definicao_funcao_parametros)? ')' ;
definicao_funcao_parametros: definicao_funcao_parametro | definicao_funcao_parametro_dimensional;
definicao_funcao_parametro: PR_TIPO_DA_VAR_OU_CONST ID;
definicao_funcao_parametro_dimensional: definicao_funcao_parametro posicao_dimensional;

//Definições livres (podem ser colocadas no escopo do programa ou em subescopos)
definicao_variaveis: PR_TIPO_DA_VAR_OU_CONST ((definicao_variavel | definicao_variavel_dimensional) ',')* (definicao_variavel | definicao_variavel_dimensional);
definicao_constantes: PR_CONST PR_TIPO_DA_VAR_OU_CONST ((definicao_constante | definicao_constante_dimensional) ',')* (definicao_constante | definicao_constante_dimensional);

//*Auxiliares
definicao_variavel: ID atribuicao_definicao?;
definicao_constante: ID atribuicao_definicao;
definicao_variavel_dimensional: ID posicao_dimensional atribuicao_definicao_dimensional?;
definicao_constante_dimensional: ID posicao_dimensional atribuicao_definicao_dimensional;

//Comandos (usado dentro de escopos de funções)
comando: definicao_variaveis
       | definicao_constantes
       | atribuicao_var
       | atribuicao_var_dimensional
       | se
       | escolha
       | enquanto
       | faca
       | para
       ;
//*Se
se: PR_SE se_teste_e_comandos senao_se* senao?;
senao_se: PR_SENAO PR_SE se_teste_e_comandos;
senao: se_comandos;

se_teste_e_comandos: '(' expressao ')' se_comandos;
se_comandos: '{' comando* '}';
//*Escolha
escolha: PR_ESCOLHA '(' expressao ')' '{' (caso)+ caso_contrario? '}';
caso: PR_CASO expressao ':' comando*;
caso_contrario: PR_CASO PR_CONTRARIO ':' comando*;
//*Enquanto
enquanto: PR_ENQUANTO '(' expressao ')' ('{' comando* '}' | comando);
//*Faça - Enquanto
faca: PR_FACA ('{' comando* '}' | comando) PR_ENQUANTO '(' expressao ')';
//*Para
para: PR_PARA '(' (definicao_variaveis | atribuicao_var | atribuicao_var_dimensional) ';' expressao ';' expressao ')' ('{' comando* '}' | comando);
 