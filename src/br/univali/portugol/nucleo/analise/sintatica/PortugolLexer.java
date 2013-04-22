// $ANTLR 3.3 Nov 30, 2010 12:45:30 /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g 2013-04-17 16:21:13
 
	package br.univali.portugol.nucleo.analise.sintatica;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class PortugolLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__50=50;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__59=59;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__73=73;
    public static final int PR_PROGRAMA=4;
    public static final int PR_REAL=5;
    public static final int PR_VAZIO=6;
    public static final int PR_LOGICO=7;
    public static final int PR_CADEIA=8;
    public static final int PR_INTEIRO=9;
    public static final int PR_CARACTER=10;
    public static final int PR_ESCOLHA=11;
    public static final int PR_CASO=12;
    public static final int PR_CONTRARIO=13;
    public static final int PR_CONST=14;
    public static final int PR_FUNCAO=15;
    public static final int PR_RETORNE=16;
    public static final int PR_PARA=17;
    public static final int PR_PARE=18;
    public static final int PR_FACA=19;
    public static final int PR_ENQUANTO=20;
    public static final int PR_SE=21;
    public static final int PR_SENAO=22;
    public static final int PR_INCLUA=23;
    public static final int PR_BIBLIOTECA=24;
    public static final int GAMBIARRA=25;
    public static final int PR_FALSO=26;
    public static final int PR_VERDADEIRO=27;
    public static final int OPERADOR_NAO=28;
    public static final int LOGICO=29;
    public static final int ID=30;
    public static final int ID_BIBLIOTECA=31;
    public static final int INTEIRO=32;
    public static final int REAL=33;
    public static final int SEQ_ESC=34;
    public static final int CADEIA=35;
    public static final int CARACTER=36;
    public static final int ESPACO=37;
    public static final int DIGIT_HEX=38;
    public static final int ESC_UNICODE=39;
    public static final int ESC_OCTAL=40;
    public static final int COMENTARIO=41;

    // delegates
    // delegators

    public PortugolLexer() {;} 
    public PortugolLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public PortugolLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g"; }

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:7:7: ( '{' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:7:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:8:7: ( '}' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:8:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:9:7: ( '-->' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:9:9: '-->'
            {
            match("-->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:10:7: ( ',' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:10:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:11:7: ( '[' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:11:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:12:7: ( ']' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:12:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:13:7: ( '=' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:13:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:14:7: ( '(' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:14:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:15:7: ( ')' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:15:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:16:7: ( '&' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:16:9: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:17:7: ( ';' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:17:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:18:7: ( ':' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:18:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:19:7: ( '+=' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:19:9: '+='
            {
            match("+="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:20:7: ( '-=' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:20:9: '-='
            {
            match("-="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:21:7: ( '/=' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:21:9: '/='
            {
            match("/="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:22:7: ( '*=' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:22:9: '*='
            {
            match("*="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:23:7: ( '%=' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:23:9: '%='
            {
            match("%="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:24:7: ( 'e' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:24:9: 'e'
            {
            match('e'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:25:7: ( 'ou' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:25:9: 'ou'
            {
            match("ou"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:26:7: ( '==' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:26:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:27:7: ( '!=' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:27:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:28:7: ( '>=' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:28:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:29:7: ( '<=' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:29:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:30:7: ( '<' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:30:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:31:7: ( '>' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:31:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:32:7: ( '+' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:32:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:33:7: ( '-' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:33:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:34:7: ( '*' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:34:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:35:7: ( '/' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:35:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:36:7: ( '%' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:36:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:37:7: ( '++' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:37:9: '++'
            {
            match("++"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:38:7: ( '--' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:38:9: '--'
            {
            match("--"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "PR_PROGRAMA"
    public final void mPR_PROGRAMA() throws RecognitionException {
        try {
            int _type = PR_PROGRAMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:139:15: ( 'programa' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:139:17: 'programa'
            {
            match("programa"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PR_PROGRAMA"

    // $ANTLR start "PR_REAL"
    public final void mPR_REAL() throws RecognitionException {
        try {
            int _type = PR_REAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:140:12: ( 'real' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:140:14: 'real'
            {
            match("real"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PR_REAL"

    // $ANTLR start "PR_VAZIO"
    public final void mPR_VAZIO() throws RecognitionException {
        try {
            int _type = PR_VAZIO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:141:13: ( 'vazio' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:141:15: 'vazio'
            {
            match("vazio"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PR_VAZIO"

    // $ANTLR start "PR_LOGICO"
    public final void mPR_LOGICO() throws RecognitionException {
        try {
            int _type = PR_LOGICO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:142:14: ( 'logico' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:142:16: 'logico'
            {
            match("logico"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PR_LOGICO"

    // $ANTLR start "PR_CADEIA"
    public final void mPR_CADEIA() throws RecognitionException {
        try {
            int _type = PR_CADEIA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:143:14: ( 'cadeia' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:143:16: 'cadeia'
            {
            match("cadeia"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PR_CADEIA"

    // $ANTLR start "PR_INTEIRO"
    public final void mPR_INTEIRO() throws RecognitionException {
        try {
            int _type = PR_INTEIRO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:144:15: ( 'inteiro' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:144:17: 'inteiro'
            {
            match("inteiro"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PR_INTEIRO"

    // $ANTLR start "PR_CARACTER"
    public final void mPR_CARACTER() throws RecognitionException {
        try {
            int _type = PR_CARACTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:145:15: ( 'caracter' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:145:17: 'caracter'
            {
            match("caracter"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PR_CARACTER"

    // $ANTLR start "PR_ESCOLHA"
    public final void mPR_ESCOLHA() throws RecognitionException {
        try {
            int _type = PR_ESCOLHA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:146:15: ( 'escolha' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:146:17: 'escolha'
            {
            match("escolha"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PR_ESCOLHA"

    // $ANTLR start "PR_CASO"
    public final void mPR_CASO() throws RecognitionException {
        try {
            int _type = PR_CASO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:147:12: ( 'caso' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:147:14: 'caso'
            {
            match("caso"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PR_CASO"

    // $ANTLR start "PR_CONTRARIO"
    public final void mPR_CONTRARIO() throws RecognitionException {
        try {
            int _type = PR_CONTRARIO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:148:16: ( 'contrario' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:148:18: 'contrario'
            {
            match("contrario"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PR_CONTRARIO"

    // $ANTLR start "PR_CONST"
    public final void mPR_CONST() throws RecognitionException {
        try {
            int _type = PR_CONST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:149:13: ( 'const' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:149:15: 'const'
            {
            match("const"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PR_CONST"

    // $ANTLR start "PR_FUNCAO"
    public final void mPR_FUNCAO() throws RecognitionException {
        try {
            int _type = PR_FUNCAO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:150:14: ( 'funcao' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:150:16: 'funcao'
            {
            match("funcao"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PR_FUNCAO"

    // $ANTLR start "PR_RETORNE"
    public final void mPR_RETORNE() throws RecognitionException {
        try {
            int _type = PR_RETORNE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:151:15: ( 'retorne' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:151:17: 'retorne'
            {
            match("retorne"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PR_RETORNE"

    // $ANTLR start "PR_PARA"
    public final void mPR_PARA() throws RecognitionException {
        try {
            int _type = PR_PARA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:152:12: ( 'para' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:152:14: 'para'
            {
            match("para"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PR_PARA"

    // $ANTLR start "PR_PARE"
    public final void mPR_PARE() throws RecognitionException {
        try {
            int _type = PR_PARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:153:12: ( 'pare' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:153:14: 'pare'
            {
            match("pare"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PR_PARE"

    // $ANTLR start "PR_FACA"
    public final void mPR_FACA() throws RecognitionException {
        try {
            int _type = PR_FACA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:154:12: ( 'faca' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:154:14: 'faca'
            {
            match("faca"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PR_FACA"

    // $ANTLR start "PR_ENQUANTO"
    public final void mPR_ENQUANTO() throws RecognitionException {
        try {
            int _type = PR_ENQUANTO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:155:15: ( 'enquanto' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:155:17: 'enquanto'
            {
            match("enquanto"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PR_ENQUANTO"

    // $ANTLR start "PR_SE"
    public final void mPR_SE() throws RecognitionException {
        try {
            int _type = PR_SE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:156:10: ( 'se' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:156:12: 'se'
            {
            match("se"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PR_SE"

    // $ANTLR start "PR_SENAO"
    public final void mPR_SENAO() throws RecognitionException {
        try {
            int _type = PR_SENAO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:157:13: ( 'senao' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:157:15: 'senao'
            {
            match("senao"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PR_SENAO"

    // $ANTLR start "PR_INCLUA"
    public final void mPR_INCLUA() throws RecognitionException {
        try {
            int _type = PR_INCLUA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:158:14: ( 'inclua' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:158:16: 'inclua'
            {
            match("inclua"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PR_INCLUA"

    // $ANTLR start "PR_BIBLIOTECA"
    public final void mPR_BIBLIOTECA() throws RecognitionException {
        try {
            int _type = PR_BIBLIOTECA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:159:17: ( 'biblioteca' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:159:19: 'biblioteca'
            {
            match("biblioteca"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PR_BIBLIOTECA"

    // $ANTLR start "GAMBIARRA"
    public final void mGAMBIARRA() throws RecognitionException {
        try {
            int _type = GAMBIARRA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:162:12: ( '.' | 'á' | 'à' | 'ã' | 'â' | 'é' | 'ê' | 'í' | 'ó' | 'ô' | 'õ' | 'ú' | 'ü' | 'ç' | 'Á' | 'À' | 'Ã' | 'Â' | 'É' | 'Ê' | 'Í' | 'Ó' | 'Ô' | 'Õ' | 'Ú' | 'Ü' | 'Ç' | '#' | '$' | '\"' | '§' | '?' | '¹' | '²' | '³' | '£' | '¢' | '¬' | 'ª' | 'º' | '~' | '^' | '\\'' | '`' | '|' | '&' | '\\\\' | '@' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:
            {
            if ( (input.LA(1)>='\"' && input.LA(1)<='$')||(input.LA(1)>='&' && input.LA(1)<='\'')||input.LA(1)=='.'||(input.LA(1)>='?' && input.LA(1)<='@')||input.LA(1)=='\\'||input.LA(1)=='^'||input.LA(1)=='`'||input.LA(1)=='|'||input.LA(1)=='~'||(input.LA(1)>='\u00A2' && input.LA(1)<='\u00A3')||input.LA(1)=='\u00A7'||input.LA(1)=='\u00AA'||input.LA(1)=='\u00AC'||(input.LA(1)>='\u00B2' && input.LA(1)<='\u00B3')||(input.LA(1)>='\u00B9' && input.LA(1)<='\u00BA')||(input.LA(1)>='\u00C0' && input.LA(1)<='\u00C3')||input.LA(1)=='\u00C7'||(input.LA(1)>='\u00C9' && input.LA(1)<='\u00CA')||input.LA(1)=='\u00CD'||(input.LA(1)>='\u00D3' && input.LA(1)<='\u00D5')||input.LA(1)=='\u00DA'||input.LA(1)=='\u00DC'||(input.LA(1)>='\u00E0' && input.LA(1)<='\u00E3')||input.LA(1)=='\u00E7'||(input.LA(1)>='\u00E9' && input.LA(1)<='\u00EA')||input.LA(1)=='\u00ED'||(input.LA(1)>='\u00F3' && input.LA(1)<='\u00F5')||input.LA(1)=='\u00FA'||input.LA(1)=='\u00FC' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GAMBIARRA"

    // $ANTLR start "PR_FALSO"
    public final void mPR_FALSO() throws RecognitionException {
        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:164:21: ( 'falso' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:164:23: 'falso'
            {
            match("falso"); 


            }

        }
        finally {
        }
    }
    // $ANTLR end "PR_FALSO"

    // $ANTLR start "PR_VERDADEIRO"
    public final void mPR_VERDADEIRO() throws RecognitionException {
        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:165:25: ( 'verdadeiro' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:165:27: 'verdadeiro'
            {
            match("verdadeiro"); 


            }

        }
        finally {
        }
    }
    // $ANTLR end "PR_VERDADEIRO"

    // $ANTLR start "OPERADOR_NAO"
    public final void mOPERADOR_NAO() throws RecognitionException {
        try {
            int _type = OPERADOR_NAO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:167:16: ( 'nao' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:167:18: 'nao'
            {
            match("nao"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OPERADOR_NAO"

    // $ANTLR start "LOGICO"
    public final void mLOGICO() throws RecognitionException {
        try {
            int _type = LOGICO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:169:11: ( PR_VERDADEIRO | PR_FALSO )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='v') ) {
                alt1=1;
            }
            else if ( (LA1_0=='f') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:169:14: PR_VERDADEIRO
                    {
                    mPR_VERDADEIRO(); 

                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:169:30: PR_FALSO
                    {
                    mPR_FALSO(); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LOGICO"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:171:8: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:171:10: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:171:34: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "ID_BIBLIOTECA"
    public final void mID_BIBLIOTECA() throws RecognitionException {
        try {
            int _type = ID_BIBLIOTECA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:173:17: ( ID '.' ID )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:173:19: ID '.' ID
            {
            mID(); 
            match('.'); 
            mID(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ID_BIBLIOTECA"

    // $ANTLR start "INTEIRO"
    public final void mINTEIRO() throws RecognitionException {
        try {
            int _type = INTEIRO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:175:13: ( ( '0' .. '9' )* )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:175:15: ( '0' .. '9' )*
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:175:15: ( '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:175:15: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTEIRO"

    // $ANTLR start "REAL"
    public final void mREAL() throws RecognitionException {
        try {
            int _type = REAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:177:10: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )+ )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:177:13: ( '0' .. '9' )+ '.' ( '0' .. '9' )+
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:177:13: ( '0' .. '9' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:177:14: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

            match('.'); 
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:177:29: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:177:30: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "REAL"

    // $ANTLR start "CADEIA"
    public final void mCADEIA() throws RecognitionException {
        try {
            int _type = CADEIA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:179:11: ( '\"' ( SEQ_ESC | ~ ( '\\\\' | '\"' ) )* '\"' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:179:13: '\"' ( SEQ_ESC | ~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:179:17: ( SEQ_ESC | ~ ( '\\\\' | '\"' ) )*
            loop6:
            do {
                int alt6=3;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='\\') ) {
                    alt6=1;
                }
                else if ( ((LA6_0>='\u0000' && LA6_0<='!')||(LA6_0>='#' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='\uFFFF')) ) {
                    alt6=2;
                }


                switch (alt6) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:179:19: SEQ_ESC
            	    {
            	    mSEQ_ESC(); 

            	    }
            	    break;
            	case 2 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:179:29: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CADEIA"

    // $ANTLR start "CARACTER"
    public final void mCARACTER() throws RecognitionException {
        try {
            int _type = CARACTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:181:13: ( '\\'' ( SEQ_ESC | ~ ( '\\'' | '\\\\' ) ) '\\'' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:181:17: '\\'' ( SEQ_ESC | ~ ( '\\'' | '\\\\' ) ) '\\''
            {
            match('\''); 
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:181:22: ( SEQ_ESC | ~ ( '\\'' | '\\\\' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\\') ) {
                alt7=1;
            }
            else if ( ((LA7_0>='\u0000' && LA7_0<='&')||(LA7_0>='(' && LA7_0<='[')||(LA7_0>=']' && LA7_0<='\uFFFF')) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:181:24: SEQ_ESC
                    {
                    mSEQ_ESC(); 

                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:181:34: ~ ( '\\'' | '\\\\' )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CARACTER"

    // $ANTLR start "ESPACO"
    public final void mESPACO() throws RecognitionException {
        try {
            int _type = ESPACO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:183:11: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:183:13: ( ' ' | '\\t' | '\\r' | '\\n' )
            {
            if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ESPACO"

    // $ANTLR start "DIGIT_HEX"
    public final void mDIGIT_HEX() throws RecognitionException {
        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:186:22: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:186:25: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT_HEX"

    // $ANTLR start "SEQ_ESC"
    public final void mSEQ_ESC() throws RecognitionException {
        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:188:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ESC_UNICODE | ESC_OCTAL )
            int alt8=3;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='\\') ) {
                switch ( input.LA(2) ) {
                case '\"':
                case '\'':
                case '\\':
                case 'b':
                case 'f':
                case 'n':
                case 'r':
                case 't':
                    {
                    alt8=1;
                    }
                    break;
                case 'u':
                    {
                    alt8=2;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    {
                    alt8=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:188:23: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    {
                    match('\\'); 
                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:188:70: ESC_UNICODE
                    {
                    mESC_UNICODE(); 

                    }
                    break;
                case 3 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:188:87: ESC_OCTAL
                    {
                    mESC_OCTAL(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "SEQ_ESC"

    // $ANTLR start "ESC_OCTAL"
    public final void mESC_OCTAL() throws RecognitionException {
        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:190:21: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt9=3;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\\') ) {
                int LA9_1 = input.LA(2);

                if ( ((LA9_1>='0' && LA9_1<='3')) ) {
                    int LA9_2 = input.LA(3);

                    if ( ((LA9_2>='0' && LA9_2<='7')) ) {
                        int LA9_4 = input.LA(4);

                        if ( ((LA9_4>='0' && LA9_4<='7')) ) {
                            alt9=1;
                        }
                        else {
                            alt9=2;}
                    }
                    else {
                        alt9=3;}
                }
                else if ( ((LA9_1>='4' && LA9_1<='7')) ) {
                    int LA9_3 = input.LA(3);

                    if ( ((LA9_3>='0' && LA9_3<='7')) ) {
                        alt9=2;
                    }
                    else {
                        alt9=3;}
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:190:23: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:190:28: ( '0' .. '3' )
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:190:29: '0' .. '3'
                    {
                    matchRange('0','3'); 

                    }

                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:190:39: ( '0' .. '7' )
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:190:40: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:190:50: ( '0' .. '7' )
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:190:51: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:190:66: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:190:71: ( '0' .. '7' )
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:190:72: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:190:82: ( '0' .. '7' )
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:190:83: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 3 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:190:100: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:190:105: ( '0' .. '7' )
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:190:106: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "ESC_OCTAL"

    // $ANTLR start "ESC_UNICODE"
    public final void mESC_UNICODE() throws RecognitionException {
        try {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:192:23: ( '\\\\' 'u' DIGIT_HEX DIGIT_HEX DIGIT_HEX DIGIT_HEX )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:192:25: '\\\\' 'u' DIGIT_HEX DIGIT_HEX DIGIT_HEX DIGIT_HEX
            {
            match('\\'); 
            match('u'); 
            mDIGIT_HEX(); 
            mDIGIT_HEX(); 
            mDIGIT_HEX(); 
            mDIGIT_HEX(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "ESC_UNICODE"

    // $ANTLR start "COMENTARIO"
    public final void mCOMENTARIO() throws RecognitionException {
        try {
            int _type = COMENTARIO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:194:14: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='/') ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1=='/') ) {
                    alt13=1;
                }
                else if ( (LA13_1=='*') ) {
                    alt13=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:196:2: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
                    {
                    match("//"); 

                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:196:7: (~ ( '\\n' | '\\r' ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\uFFFF')) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:196:7: ~ ( '\\n' | '\\r' )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:196:21: ( '\\r' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='\r') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:196:21: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 
                    _channel=HIDDEN;

                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:198:3: '/*' ( options {greedy=false; } : . )* '*/'
                    {
                    match("/*"); 

                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:198:8: ( options {greedy=false; } : . )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0=='*') ) {
                            int LA12_1 = input.LA(2);

                            if ( (LA12_1=='/') ) {
                                alt12=2;
                            }
                            else if ( ((LA12_1>='\u0000' && LA12_1<='.')||(LA12_1>='0' && LA12_1<='\uFFFF')) ) {
                                alt12=1;
                            }


                        }
                        else if ( ((LA12_0>='\u0000' && LA12_0<=')')||(LA12_0>='+' && LA12_0<='\uFFFF')) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:198:36: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    match("*/"); 

                    _channel=HIDDEN;

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMENTARIO"

    public void mTokens() throws RecognitionException {
        // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:8: ( T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | PR_PROGRAMA | PR_REAL | PR_VAZIO | PR_LOGICO | PR_CADEIA | PR_INTEIRO | PR_CARACTER | PR_ESCOLHA | PR_CASO | PR_CONTRARIO | PR_CONST | PR_FUNCAO | PR_RETORNE | PR_PARA | PR_PARE | PR_FACA | PR_ENQUANTO | PR_SE | PR_SENAO | PR_INCLUA | PR_BIBLIOTECA | GAMBIARRA | OPERADOR_NAO | LOGICO | ID | ID_BIBLIOTECA | INTEIRO | REAL | CADEIA | CARACTER | ESPACO | COMENTARIO )
        int alt14=64;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:10: T__42
                {
                mT__42(); 

                }
                break;
            case 2 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:16: T__43
                {
                mT__43(); 

                }
                break;
            case 3 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:22: T__44
                {
                mT__44(); 

                }
                break;
            case 4 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:28: T__45
                {
                mT__45(); 

                }
                break;
            case 5 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:34: T__46
                {
                mT__46(); 

                }
                break;
            case 6 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:40: T__47
                {
                mT__47(); 

                }
                break;
            case 7 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:46: T__48
                {
                mT__48(); 

                }
                break;
            case 8 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:52: T__49
                {
                mT__49(); 

                }
                break;
            case 9 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:58: T__50
                {
                mT__50(); 

                }
                break;
            case 10 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:64: T__51
                {
                mT__51(); 

                }
                break;
            case 11 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:70: T__52
                {
                mT__52(); 

                }
                break;
            case 12 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:76: T__53
                {
                mT__53(); 

                }
                break;
            case 13 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:82: T__54
                {
                mT__54(); 

                }
                break;
            case 14 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:88: T__55
                {
                mT__55(); 

                }
                break;
            case 15 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:94: T__56
                {
                mT__56(); 

                }
                break;
            case 16 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:100: T__57
                {
                mT__57(); 

                }
                break;
            case 17 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:106: T__58
                {
                mT__58(); 

                }
                break;
            case 18 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:112: T__59
                {
                mT__59(); 

                }
                break;
            case 19 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:118: T__60
                {
                mT__60(); 

                }
                break;
            case 20 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:124: T__61
                {
                mT__61(); 

                }
                break;
            case 21 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:130: T__62
                {
                mT__62(); 

                }
                break;
            case 22 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:136: T__63
                {
                mT__63(); 

                }
                break;
            case 23 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:142: T__64
                {
                mT__64(); 

                }
                break;
            case 24 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:148: T__65
                {
                mT__65(); 

                }
                break;
            case 25 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:154: T__66
                {
                mT__66(); 

                }
                break;
            case 26 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:160: T__67
                {
                mT__67(); 

                }
                break;
            case 27 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:166: T__68
                {
                mT__68(); 

                }
                break;
            case 28 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:172: T__69
                {
                mT__69(); 

                }
                break;
            case 29 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:178: T__70
                {
                mT__70(); 

                }
                break;
            case 30 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:184: T__71
                {
                mT__71(); 

                }
                break;
            case 31 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:190: T__72
                {
                mT__72(); 

                }
                break;
            case 32 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:196: T__73
                {
                mT__73(); 

                }
                break;
            case 33 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:202: PR_PROGRAMA
                {
                mPR_PROGRAMA(); 

                }
                break;
            case 34 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:214: PR_REAL
                {
                mPR_REAL(); 

                }
                break;
            case 35 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:222: PR_VAZIO
                {
                mPR_VAZIO(); 

                }
                break;
            case 36 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:231: PR_LOGICO
                {
                mPR_LOGICO(); 

                }
                break;
            case 37 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:241: PR_CADEIA
                {
                mPR_CADEIA(); 

                }
                break;
            case 38 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:251: PR_INTEIRO
                {
                mPR_INTEIRO(); 

                }
                break;
            case 39 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:262: PR_CARACTER
                {
                mPR_CARACTER(); 

                }
                break;
            case 40 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:274: PR_ESCOLHA
                {
                mPR_ESCOLHA(); 

                }
                break;
            case 41 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:285: PR_CASO
                {
                mPR_CASO(); 

                }
                break;
            case 42 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:293: PR_CONTRARIO
                {
                mPR_CONTRARIO(); 

                }
                break;
            case 43 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:306: PR_CONST
                {
                mPR_CONST(); 

                }
                break;
            case 44 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:315: PR_FUNCAO
                {
                mPR_FUNCAO(); 

                }
                break;
            case 45 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:325: PR_RETORNE
                {
                mPR_RETORNE(); 

                }
                break;
            case 46 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:336: PR_PARA
                {
                mPR_PARA(); 

                }
                break;
            case 47 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:344: PR_PARE
                {
                mPR_PARE(); 

                }
                break;
            case 48 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:352: PR_FACA
                {
                mPR_FACA(); 

                }
                break;
            case 49 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:360: PR_ENQUANTO
                {
                mPR_ENQUANTO(); 

                }
                break;
            case 50 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:372: PR_SE
                {
                mPR_SE(); 

                }
                break;
            case 51 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:378: PR_SENAO
                {
                mPR_SENAO(); 

                }
                break;
            case 52 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:387: PR_INCLUA
                {
                mPR_INCLUA(); 

                }
                break;
            case 53 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:397: PR_BIBLIOTECA
                {
                mPR_BIBLIOTECA(); 

                }
                break;
            case 54 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:411: GAMBIARRA
                {
                mGAMBIARRA(); 

                }
                break;
            case 55 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:421: OPERADOR_NAO
                {
                mOPERADOR_NAO(); 

                }
                break;
            case 56 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:434: LOGICO
                {
                mLOGICO(); 

                }
                break;
            case 57 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:441: ID
                {
                mID(); 

                }
                break;
            case 58 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:444: ID_BIBLIOTECA
                {
                mID_BIBLIOTECA(); 

                }
                break;
            case 59 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:458: INTEIRO
                {
                mINTEIRO(); 

                }
                break;
            case 60 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:466: REAL
                {
                mREAL(); 

                }
                break;
            case 61 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:471: CADEIA
                {
                mCADEIA(); 

                }
                break;
            case 62 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:478: CARACTER
                {
                mCARACTER(); 

                }
                break;
            case 63 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:487: ESPACO
                {
                mESPACO(); 

                }
                break;
            case 64 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:494: COMENTARIO
                {
                mCOMENTARIO(); 

                }
                break;

        }

    }


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\1\43\2\uffff\1\51\3\uffff\1\53\5\uffff\1\57\1\62\1\64\1\66\1\71"+
        "\1\75\1\uffff\1\77\1\101\11\75\1\45\2\75\1\43\1\uffff\1\45\2\uffff"+
        "\1\124\17\uffff\2\75\1\uffff\1\75\1\uffff\1\127\5\uffff\13\75\1"+
        "\151\1\75\1\uffff\1\75\4\uffff\2\75\1\uffff\21\75\1\uffff\1\75\1"+
        "\u0082\3\75\1\u0086\1\u0087\1\u0088\6\75\1\u008f\5\75\1\u0095\3"+
        "\75\1\uffff\3\75\3\uffff\1\75\1\u009d\4\75\1\uffff\1\75\1\u00a3"+
        "\3\75\1\uffff\1\u00a7\1\u00a8\5\75\1\uffff\1\75\1\u00af\1\u00b0"+
        "\2\75\1\uffff\1\75\1\u00b4\1\u00b5\2\uffff\1\75\1\u00b7\2\75\1\u00ba"+
        "\1\75\2\uffff\2\75\1\u00be\2\uffff\1\75\1\uffff\1\u00c0\1\u00c1"+
        "\1\uffff\1\75\1\u00c3\1\75\1\uffff\1\75\2\uffff\1\75\1\uffff\1\u00c7"+
        "\1\75\1\u00a7\1\uffff\1\u00c9\1\uffff";
    static final String DFA14_eofS =
        "\u00ca\uffff";
    static final String DFA14_minS =
        "\1\11\2\uffff\1\55\3\uffff\1\75\5\uffff\1\53\1\52\2\75\2\56\1\uffff"+
        "\2\75\11\56\1\0\3\56\1\uffff\1\0\2\uffff\1\76\17\uffff\2\56\1\uffff"+
        "\1\56\1\uffff\1\56\5\uffff\15\56\1\uffff\1\56\4\uffff\2\56\1\uffff"+
        "\21\56\1\uffff\30\56\1\uffff\3\56\3\uffff\6\56\1\uffff\5\56\1\uffff"+
        "\7\56\1\uffff\5\56\1\uffff\3\56\2\uffff\6\56\2\uffff\3\56\2\uffff"+
        "\1\56\1\uffff\2\56\1\uffff\3\56\1\uffff\1\56\2\uffff\1\56\1\uffff"+
        "\3\56\1\uffff\1\56\1\uffff";
    static final String DFA14_maxS =
        "\1\u00fc\2\uffff\1\75\3\uffff\1\75\5\uffff\4\75\2\172\1\uffff\2"+
        "\75\11\172\1\uffff\2\172\1\71\1\uffff\1\uffff\2\uffff\1\76\17\uffff"+
        "\2\172\1\uffff\1\172\1\uffff\1\172\5\uffff\15\172\1\uffff\1\172"+
        "\4\uffff\2\172\1\uffff\21\172\1\uffff\30\172\1\uffff\3\172\3\uffff"+
        "\6\172\1\uffff\5\172\1\uffff\7\172\1\uffff\5\172\1\uffff\3\172\2"+
        "\uffff\6\172\2\uffff\3\172\2\uffff\1\172\1\uffff\2\172\1\uffff\3"+
        "\172\1\uffff\1\172\2\uffff\1\172\1\uffff\3\172\1\uffff\1\172\1\uffff";
    static final String DFA14_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\4\1\5\1\6\1\uffff\1\10\1\11\1\12\1\13"+
        "\1\14\6\uffff\1\25\17\uffff\1\73\1\uffff\1\66\1\77\1\uffff\1\16"+
        "\1\33\1\24\1\7\1\12\1\15\1\37\1\32\1\17\1\100\1\35\1\20\1\34\1\21"+
        "\1\36\2\uffff\1\22\1\uffff\1\72\1\uffff\1\71\1\26\1\31\1\27\1\30"+
        "\15\uffff\1\75\1\uffff\1\74\1\76\1\3\1\40\2\uffff\1\23\21\uffff"+
        "\1\62\30\uffff\1\67\3\uffff\1\56\1\57\1\42\6\uffff\1\51\5\uffff"+
        "\1\60\7\uffff\1\43\5\uffff\1\53\3\uffff\1\70\1\63\6\uffff\1\44\1"+
        "\45\3\uffff\1\64\1\54\1\uffff\1\50\2\uffff\1\55\3\uffff\1\46\1\uffff"+
        "\1\61\1\41\1\uffff\1\47\3\uffff\1\52\1\uffff\1\65";
    static final String DFA14_specialS =
        "\37\uffff\1\0\4\uffff\1\1\u00a5\uffff}>";
    static final String[] DFA14_transitionS = {
            "\2\46\2\uffff\1\46\22\uffff\1\46\1\23\1\37\2\45\1\20\1\12\1"+
            "\44\1\10\1\11\1\17\1\15\1\4\1\3\1\45\1\16\12\42\1\14\1\13\1"+
            "\25\1\7\1\24\2\45\32\41\1\5\1\45\1\6\1\45\1\41\1\45\1\41\1\36"+
            "\1\32\1\41\1\21\1\34\2\41\1\33\2\41\1\31\1\41\1\40\1\22\1\26"+
            "\1\41\1\27\1\35\2\41\1\30\4\41\1\1\1\45\1\2\1\45\43\uffff\2"+
            "\45\3\uffff\1\45\2\uffff\1\45\1\uffff\1\45\5\uffff\2\45\5\uffff"+
            "\2\45\5\uffff\4\45\3\uffff\1\45\1\uffff\2\45\2\uffff\1\45\5"+
            "\uffff\3\45\4\uffff\1\45\1\uffff\1\45\3\uffff\4\45\3\uffff\1"+
            "\45\1\uffff\2\45\2\uffff\1\45\5\uffff\3\45\4\uffff\1\45\1\uffff"+
            "\1\45",
            "",
            "",
            "\1\47\17\uffff\1\50",
            "",
            "",
            "",
            "\1\52",
            "",
            "",
            "",
            "",
            "",
            "\1\56\21\uffff\1\55",
            "\1\61\4\uffff\1\61\15\uffff\1\60",
            "\1\63",
            "\1\65",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\15\72"+
            "\1\70\4\72\1\67\7\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\24\72"+
            "\1\74\5\72",
            "",
            "\1\76",
            "\1\100",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\1\103"+
            "\20\72\1\102\10\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\4\72"+
            "\1\104\25\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\1\105"+
            "\3\72\1\106\25\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\16\72"+
            "\1\107\13\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\1\110"+
            "\15\72\1\111\13\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\15\72"+
            "\1\112\14\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\1\114"+
            "\23\72\1\113\5\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\4\72"+
            "\1\115\25\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\10\72"+
            "\1\116\21\72",
            "\0\117",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\1\120"+
            "\31\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\121\1\uffff\12\42",
            "",
            "\47\122\1\uffff\uffd8\122",
            "",
            "",
            "\1\123",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\2\72"+
            "\1\125\27\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\20\72"+
            "\1\126\11\72",
            "",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "",
            "",
            "",
            "",
            "",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\16\72"+
            "\1\130\13\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\21\72"+
            "\1\131\10\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\1\132"+
            "\22\72\1\133\6\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\31\72"+
            "\1\134",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\21\72"+
            "\1\135\10\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\6\72"+
            "\1\136\23\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\3\72"+
            "\1\137\15\72\1\140\1\141\7\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\15\72"+
            "\1\142\14\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\2\72"+
            "\1\144\20\72\1\143\6\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\15\72"+
            "\1\145\14\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\2\72"+
            "\1\146\10\72\1\147\16\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\15\72"+
            "\1\150\14\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\1\72"+
            "\1\152\30\72",
            "",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\16\72"+
            "\1\153\13\72",
            "",
            "",
            "",
            "",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\16\72"+
            "\1\154\13\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\24\72"+
            "\1\155\5\72",
            "",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\6\72"+
            "\1\156\23\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\1\157"+
            "\3\72\1\160\25\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\13\72"+
            "\1\161\16\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\16\72"+
            "\1\162\13\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\10\72"+
            "\1\163\21\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\3\72"+
            "\1\164\26\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\10\72"+
            "\1\165\21\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\4\72"+
            "\1\166\25\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\1\167"+
            "\31\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\16\72"+
            "\1\170\13\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\22\72"+
            "\1\172\1\171\6\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\4\72"+
            "\1\173\25\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\13\72"+
            "\1\174\16\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\2\72"+
            "\1\175\27\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\1\176"+
            "\31\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\22\72"+
            "\1\177\7\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\1\u0080"+
            "\31\72",
            "",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\13\72"+
            "\1\u0081\16\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\13\72"+
            "\1\u0083\16\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\1\u0084"+
            "\31\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\21\72"+
            "\1\u0085\10\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\21\72"+
            "\1\u0089\10\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\16\72"+
            "\1\u008a\13\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\1\u008b"+
            "\31\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\2\72"+
            "\1\u008c\27\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\10\72"+
            "\1\u008d\21\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\2\72"+
            "\1\u008e\27\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\21\72"+
            "\1\u0090\10\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\23\72"+
            "\1\u0091\6\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\10\72"+
            "\1\u0092\21\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\24\72"+
            "\1\u0093\5\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\1\u0094"+
            "\31\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\16\72"+
            "\1\u0096\13\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\16\72"+
            "\1\u0097\13\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\10\72"+
            "\1\u0098\21\72",
            "",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\7\72"+
            "\1\u0099\22\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\15\72"+
            "\1\u009a\14\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\1\u009b"+
            "\31\72",
            "",
            "",
            "",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\15\72"+
            "\1\u009c\14\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\3\72"+
            "\1\u009e\26\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\16\72"+
            "\1\u009f\13\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\1\u00a0"+
            "\31\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\23\72"+
            "\1\u00a1\6\72",
            "",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\1\u00a2"+
            "\31\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\21\72"+
            "\1\u00a4\10\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\1\u00a5"+
            "\31\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\16\72"+
            "\1\u00a6\13\72",
            "",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\16\72"+
            "\1\u00a9\13\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\1\u00aa"+
            "\31\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\23\72"+
            "\1\u00ab\6\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\14\72"+
            "\1\u00ac\15\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\4\72"+
            "\1\u00ad\25\72",
            "",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\4\72"+
            "\1\u00ae\25\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\4\72"+
            "\1\u00b1\25\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\21\72"+
            "\1\u00b2\10\72",
            "",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\16\72"+
            "\1\u00b3\13\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "",
            "",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\23\72"+
            "\1\u00b6\6\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\16\72"+
            "\1\u00b8\13\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\1\u00b9"+
            "\31\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\10\72"+
            "\1\u00bb\21\72",
            "",
            "",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\21\72"+
            "\1\u00bc\10\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\10\72"+
            "\1\u00bd\21\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "",
            "",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\4\72"+
            "\1\u00bf\25\72",
            "",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\21\72"+
            "\1\u00c2\10\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\16\72"+
            "\1\u00c4\13\72",
            "",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\2\72"+
            "\1\u00c5\27\72",
            "",
            "",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\16\72"+
            "\1\u00c6\13\72",
            "",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\1\u00c8"+
            "\31\72",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            "",
            "\1\73\1\uffff\12\72\7\uffff\32\72\4\uffff\1\72\1\uffff\32\72",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | PR_PROGRAMA | PR_REAL | PR_VAZIO | PR_LOGICO | PR_CADEIA | PR_INTEIRO | PR_CARACTER | PR_ESCOLHA | PR_CASO | PR_CONTRARIO | PR_CONST | PR_FUNCAO | PR_RETORNE | PR_PARA | PR_PARE | PR_FACA | PR_ENQUANTO | PR_SE | PR_SENAO | PR_INCLUA | PR_BIBLIOTECA | GAMBIARRA | OPERADOR_NAO | LOGICO | ID | ID_BIBLIOTECA | INTEIRO | REAL | CADEIA | CARACTER | ESPACO | COMENTARIO );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_31 = input.LA(1);

                        s = -1;
                        if ( ((LA14_31>='\u0000' && LA14_31<='\uFFFF')) ) {s = 79;}

                        else s = 37;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA14_36 = input.LA(1);

                        s = -1;
                        if ( ((LA14_36>='\u0000' && LA14_36<='&')||(LA14_36>='(' && LA14_36<='\uFFFF')) ) {s = 82;}

                        else s = 37;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}