// $ANTLR 3.3 Nov 30, 2010 12:45:30 /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g 2013-04-25 14:27:03
 
	package br.univali.portugol.nucleo.analise.sintatica;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class PortugolLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
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
    public static final int GAMBIARRA=23;
    public static final int PR_FALSO=24;
    public static final int PR_VERDADEIRO=25;
    public static final int OPERADOR_NAO=26;
    public static final int LOGICO=27;
    public static final int ID=28;
    public static final int INTEIRO=29;
    public static final int REAL=30;
    public static final int SEQ_ESC=31;
    public static final int CADEIA=32;
    public static final int CARACTER=33;
    public static final int ESPACO=34;
    public static final int DIGIT_HEX=35;
    public static final int ESC_UNICODE=36;
    public static final int ESC_OCTAL=37;
    public static final int COMENTARIO=38;

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

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
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
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
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
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:9:7: ( ',' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:9:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:10:7: ( '[' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:10:9: '['
            {
            match('['); 

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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:11:7: ( ']' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:11:9: ']'
            {
            match(']'); 

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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:12:7: ( '=' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:12:9: '='
            {
            match('='); 

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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:13:7: ( '(' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:13:9: '('
            {
            match('('); 

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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:14:7: ( ')' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:14:9: ')'
            {
            match(')'); 

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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:15:7: ( '&' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:15:9: '&'
            {
            match('&'); 

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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:16:7: ( ';' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:16:9: ';'
            {
            match(';'); 

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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:17:7: ( ':' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:17:9: ':'
            {
            match(':'); 

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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:18:7: ( '+=' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:18:9: '+='
            {
            match("+="); 


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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:19:7: ( '-=' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:19:9: '-='
            {
            match("-="); 


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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:20:7: ( '/=' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:20:9: '/='
            {
            match("/="); 


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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:21:7: ( '*=' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:21:9: '*='
            {
            match("*="); 


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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:22:7: ( '%=' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:22:9: '%='
            {
            match("%="); 


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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:23:7: ( 'e' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:23:9: 'e'
            {
            match('e'); 

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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:24:7: ( 'ou' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:24:9: 'ou'
            {
            match("ou"); 


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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:25:7: ( '==' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:25:9: '=='
            {
            match("=="); 


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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:26:7: ( '!=' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:26:9: '!='
            {
            match("!="); 


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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:27:7: ( '>=' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:27:9: '>='
            {
            match(">="); 


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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:28:7: ( '<=' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:28:9: '<='
            {
            match("<="); 


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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:29:7: ( '<' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:29:9: '<'
            {
            match('<'); 

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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:30:7: ( '>' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:30:9: '>'
            {
            match('>'); 

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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:31:7: ( '+' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:31:9: '+'
            {
            match('+'); 

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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:32:7: ( '-' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:32:9: '-'
            {
            match('-'); 

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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:33:7: ( '*' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:33:9: '*'
            {
            match('*'); 

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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:34:7: ( '/' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:34:9: '/'
            {
            match('/'); 

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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:35:7: ( '%' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:35:9: '%'
            {
            match('%'); 

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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:36:7: ( '++' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:36:9: '++'
            {
            match("++"); 


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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:37:7: ( '--' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:37:9: '--'
            {
            match("--"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:146:14: ( 'escolha' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:146:16: 'escolha'
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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:151:14: ( 'retorne' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:151:16: 'retorne'
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

    // $ANTLR start "GAMBIARRA"
    public final void mGAMBIARRA() throws RecognitionException {
        try {
            int _type = GAMBIARRA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:159:12: ( '.' | 'á' | 'à' | 'ã' | 'â' | 'é' | 'ê' | 'í' | 'ó' | 'ô' | 'õ' | 'ú' | 'ü' | 'ç' | 'Á' | 'À' | 'Ã' | 'Â' | 'É' | 'Ê' | 'Í' | 'Ó' | 'Ô' | 'Õ' | 'Ú' | 'Ü' | 'Ç' | '#' | '$' | '\"' | '§' | '?' | '¹' | '²' | '³' | '£' | '¢' | '¬' | 'ª' | 'º' | '~' | '^' | '\\'' | '`' | '|' | '&' | '\\\\' | '@' )
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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:161:21: ( 'falso' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:161:23: 'falso'
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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:162:25: ( 'verdadeiro' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:162:27: 'verdadeiro'
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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:164:16: ( 'nao' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:164:18: 'nao'
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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:166:11: ( PR_VERDADEIRO | PR_FALSO )
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
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:166:14: PR_VERDADEIRO
                    {
                    mPR_VERDADEIRO(); 

                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:166:30: PR_FALSO
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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:168:8: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:168:10: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:168:34: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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

    // $ANTLR start "INTEIRO"
    public final void mINTEIRO() throws RecognitionException {
        try {
            int _type = INTEIRO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:170:13: ( ( '0' .. '9' )* )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:170:15: ( '0' .. '9' )*
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:170:15: ( '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:170:15: '0' .. '9'
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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:172:10: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )+ )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:172:13: ( '0' .. '9' )+ '.' ( '0' .. '9' )+
            {
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:172:13: ( '0' .. '9' )+
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
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:172:14: '0' .. '9'
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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:172:29: ( '0' .. '9' )+
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
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:172:30: '0' .. '9'
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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:174:11: ( '\"' ( SEQ_ESC | ~ ( '\\\\' | '\"' ) )* '\"' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:174:13: '\"' ( SEQ_ESC | ~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:174:17: ( SEQ_ESC | ~ ( '\\\\' | '\"' ) )*
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
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:174:19: SEQ_ESC
            	    {
            	    mSEQ_ESC(); 

            	    }
            	    break;
            	case 2 :
            	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:174:29: ~ ( '\\\\' | '\"' )
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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:176:13: ( '\\'' ( SEQ_ESC | ~ ( '\\'' | '\\\\' ) ) '\\'' )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:176:17: '\\'' ( SEQ_ESC | ~ ( '\\'' | '\\\\' ) ) '\\''
            {
            match('\''); 
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:176:22: ( SEQ_ESC | ~ ( '\\'' | '\\\\' ) )
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
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:176:24: SEQ_ESC
                    {
                    mSEQ_ESC(); 

                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:176:34: ~ ( '\\'' | '\\\\' )
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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:178:11: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:178:13: ( ' ' | '\\t' | '\\r' | '\\n' )
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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:181:22: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:181:25: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:183:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ESC_UNICODE | ESC_OCTAL )
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
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:183:23: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:183:70: ESC_UNICODE
                    {
                    mESC_UNICODE(); 

                    }
                    break;
                case 3 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:183:87: ESC_OCTAL
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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:185:21: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
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
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:185:23: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:185:28: ( '0' .. '3' )
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:185:29: '0' .. '3'
                    {
                    matchRange('0','3'); 

                    }

                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:185:39: ( '0' .. '7' )
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:185:40: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:185:50: ( '0' .. '7' )
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:185:51: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 2 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:185:66: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:185:71: ( '0' .. '7' )
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:185:72: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:185:82: ( '0' .. '7' )
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:185:83: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 3 :
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:185:100: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:185:105: ( '0' .. '7' )
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:185:106: '0' .. '7'
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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:187:23: ( '\\\\' 'u' DIGIT_HEX DIGIT_HEX DIGIT_HEX DIGIT_HEX )
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:187:25: '\\\\' 'u' DIGIT_HEX DIGIT_HEX DIGIT_HEX DIGIT_HEX
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
            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:189:14: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
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
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:191:2: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
                    {
                    match("//"); 

                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:191:7: (~ ( '\\n' | '\\r' ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\uFFFF')) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:191:7: ~ ( '\\n' | '\\r' )
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

                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:191:21: ( '\\r' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='\r') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:191:21: '\\r'
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
                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:193:3: '/*' ( options {greedy=false; } : . )* '*/'
                    {
                    match("/*"); 

                    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:193:8: ( options {greedy=false; } : . )*
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
                    	    // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:193:36: .
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
        // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:8: ( T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | PR_PROGRAMA | PR_REAL | PR_VAZIO | PR_LOGICO | PR_CADEIA | PR_INTEIRO | PR_CARACTER | PR_ESCOLHA | PR_CASO | PR_CONTRARIO | PR_CONST | PR_FUNCAO | PR_RETORNE | PR_PARA | PR_PARE | PR_FACA | PR_ENQUANTO | PR_SE | PR_SENAO | GAMBIARRA | OPERADOR_NAO | LOGICO | ID | INTEIRO | REAL | CADEIA | CARACTER | ESPACO | COMENTARIO )
        int alt14=60;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:10: T__39
                {
                mT__39(); 

                }
                break;
            case 2 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:16: T__40
                {
                mT__40(); 

                }
                break;
            case 3 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:22: T__41
                {
                mT__41(); 

                }
                break;
            case 4 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:28: T__42
                {
                mT__42(); 

                }
                break;
            case 5 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:34: T__43
                {
                mT__43(); 

                }
                break;
            case 6 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:40: T__44
                {
                mT__44(); 

                }
                break;
            case 7 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:46: T__45
                {
                mT__45(); 

                }
                break;
            case 8 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:52: T__46
                {
                mT__46(); 

                }
                break;
            case 9 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:58: T__47
                {
                mT__47(); 

                }
                break;
            case 10 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:64: T__48
                {
                mT__48(); 

                }
                break;
            case 11 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:70: T__49
                {
                mT__49(); 

                }
                break;
            case 12 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:76: T__50
                {
                mT__50(); 

                }
                break;
            case 13 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:82: T__51
                {
                mT__51(); 

                }
                break;
            case 14 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:88: T__52
                {
                mT__52(); 

                }
                break;
            case 15 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:94: T__53
                {
                mT__53(); 

                }
                break;
            case 16 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:100: T__54
                {
                mT__54(); 

                }
                break;
            case 17 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:106: T__55
                {
                mT__55(); 

                }
                break;
            case 18 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:112: T__56
                {
                mT__56(); 

                }
                break;
            case 19 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:118: T__57
                {
                mT__57(); 

                }
                break;
            case 20 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:124: T__58
                {
                mT__58(); 

                }
                break;
            case 21 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:130: T__59
                {
                mT__59(); 

                }
                break;
            case 22 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:136: T__60
                {
                mT__60(); 

                }
                break;
            case 23 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:142: T__61
                {
                mT__61(); 

                }
                break;
            case 24 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:148: T__62
                {
                mT__62(); 

                }
                break;
            case 25 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:154: T__63
                {
                mT__63(); 

                }
                break;
            case 26 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:160: T__64
                {
                mT__64(); 

                }
                break;
            case 27 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:166: T__65
                {
                mT__65(); 

                }
                break;
            case 28 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:172: T__66
                {
                mT__66(); 

                }
                break;
            case 29 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:178: T__67
                {
                mT__67(); 

                }
                break;
            case 30 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:184: T__68
                {
                mT__68(); 

                }
                break;
            case 31 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:190: T__69
                {
                mT__69(); 

                }
                break;
            case 32 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:196: PR_PROGRAMA
                {
                mPR_PROGRAMA(); 

                }
                break;
            case 33 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:208: PR_REAL
                {
                mPR_REAL(); 

                }
                break;
            case 34 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:216: PR_VAZIO
                {
                mPR_VAZIO(); 

                }
                break;
            case 35 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:225: PR_LOGICO
                {
                mPR_LOGICO(); 

                }
                break;
            case 36 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:235: PR_CADEIA
                {
                mPR_CADEIA(); 

                }
                break;
            case 37 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:245: PR_INTEIRO
                {
                mPR_INTEIRO(); 

                }
                break;
            case 38 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:256: PR_CARACTER
                {
                mPR_CARACTER(); 

                }
                break;
            case 39 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:268: PR_ESCOLHA
                {
                mPR_ESCOLHA(); 

                }
                break;
            case 40 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:279: PR_CASO
                {
                mPR_CASO(); 

                }
                break;
            case 41 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:287: PR_CONTRARIO
                {
                mPR_CONTRARIO(); 

                }
                break;
            case 42 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:300: PR_CONST
                {
                mPR_CONST(); 

                }
                break;
            case 43 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:309: PR_FUNCAO
                {
                mPR_FUNCAO(); 

                }
                break;
            case 44 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:319: PR_RETORNE
                {
                mPR_RETORNE(); 

                }
                break;
            case 45 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:330: PR_PARA
                {
                mPR_PARA(); 

                }
                break;
            case 46 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:338: PR_PARE
                {
                mPR_PARE(); 

                }
                break;
            case 47 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:346: PR_FACA
                {
                mPR_FACA(); 

                }
                break;
            case 48 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:354: PR_ENQUANTO
                {
                mPR_ENQUANTO(); 

                }
                break;
            case 49 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:366: PR_SE
                {
                mPR_SE(); 

                }
                break;
            case 50 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:372: PR_SENAO
                {
                mPR_SENAO(); 

                }
                break;
            case 51 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:381: GAMBIARRA
                {
                mGAMBIARRA(); 

                }
                break;
            case 52 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:391: OPERADOR_NAO
                {
                mOPERADOR_NAO(); 

                }
                break;
            case 53 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:404: LOGICO
                {
                mLOGICO(); 

                }
                break;
            case 54 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:411: ID
                {
                mID(); 

                }
                break;
            case 55 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:414: INTEIRO
                {
                mINTEIRO(); 

                }
                break;
            case 56 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:422: REAL
                {
                mREAL(); 

                }
                break;
            case 57 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:427: CADEIA
                {
                mCADEIA(); 

                }
                break;
            case 58 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:434: CARACTER
                {
                mCARACTER(); 

                }
                break;
            case 59 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:443: ESPACO
                {
                mESPACO(); 

                }
                break;
            case 60 :
                // /home/luiz/Documentos/Projetos/Java/Portugol/Projetos/Portugol-Nucleo/src/br/univali/portugol/nucleo/analise/sintatica/Portugol.g:1:450: COMENTARIO
                {
                mCOMENTARIO(); 

                }
                break;

        }

    }


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\1\42\5\uffff\1\47\5\uffff\1\53\1\56\1\61\1\63\1\65\1\70\1\40\1"+
        "\uffff\1\73\1\75\10\40\1\44\1\40\1\uffff\1\42\1\uffff\1\44\22\uffff"+
        "\2\40\1\uffff\1\120\4\uffff\13\40\1\141\1\uffff\1\40\2\uffff\2\40"+
        "\1\uffff\20\40\1\uffff\1\167\3\40\1\173\1\174\1\175\6\40\1\u0084"+
        "\4\40\1\u0089\2\40\1\uffff\3\40\3\uffff\1\40\1\u0090\4\40\1\uffff"+
        "\1\40\1\u0096\2\40\1\uffff\1\u0099\1\u009a\4\40\1\uffff\1\40\1\u00a0"+
        "\1\u00a1\2\40\1\uffff\1\40\1\u00a5\2\uffff\1\u00a6\2\40\1\u00a9"+
        "\1\40\2\uffff\2\40\1\u00ad\2\uffff\1\u00ae\1\u00af\1\uffff\1\40"+
        "\1\u00b1\1\40\3\uffff\1\40\1\uffff\1\u00b4\1\u0099\1\uffff";
    static final String DFA14_eofS =
        "\u00b5\uffff";
    static final String DFA14_minS =
        "\1\11\5\uffff\1\75\5\uffff\1\53\1\55\1\52\2\75\1\60\1\165\1\uffff"+
        "\2\75\1\141\1\145\1\141\1\157\1\141\1\156\1\141\1\145\1\0\1\141"+
        "\1\uffff\1\56\1\uffff\1\0\22\uffff\1\143\1\161\1\uffff\1\60\4\uffff"+
        "\1\157\1\162\1\141\1\172\1\162\1\147\1\144\1\156\1\164\1\156\1\143"+
        "\1\60\1\uffff\1\157\2\uffff\1\157\1\165\1\uffff\1\147\1\141\1\154"+
        "\1\157\1\151\1\144\1\151\1\145\1\141\1\157\1\163\1\145\1\143\1\141"+
        "\1\163\1\141\1\uffff\1\60\1\154\1\141\1\162\3\60\1\162\1\157\1\141"+
        "\1\143\1\151\1\143\1\60\1\162\1\164\1\151\1\141\1\60\2\157\1\uffff"+
        "\1\150\1\156\1\141\3\uffff\1\156\1\60\1\144\1\157\1\141\1\164\1"+
        "\uffff\1\141\1\60\1\162\1\157\1\uffff\2\60\1\141\1\164\1\155\1\145"+
        "\1\uffff\1\145\2\60\1\145\1\162\1\uffff\1\157\1\60\2\uffff\1\60"+
        "\1\157\1\141\1\60\1\151\2\uffff\1\162\1\151\1\60\2\uffff\2\60\1"+
        "\uffff\1\162\1\60\1\157\3\uffff\1\157\1\uffff\2\60\1\uffff";
    static final String DFA14_maxS =
        "\1\u00fc\5\uffff\1\75\5\uffff\5\75\1\172\1\165\1\uffff\2\75\1\162"+
        "\2\145\2\157\1\156\1\165\1\145\1\uffff\1\141\1\uffff\1\71\1\uffff"+
        "\1\uffff\22\uffff\1\143\1\161\1\uffff\1\172\4\uffff\1\157\1\162"+
        "\1\164\1\172\1\162\1\147\1\163\1\156\1\164\1\156\1\154\1\172\1\uffff"+
        "\1\157\2\uffff\1\157\1\165\1\uffff\1\147\1\145\1\154\1\157\1\151"+
        "\1\144\1\151\1\145\1\141\1\157\1\164\1\145\1\143\1\141\1\163\1\141"+
        "\1\uffff\1\172\1\154\1\141\1\162\3\172\1\162\1\157\1\141\1\143\1"+
        "\151\1\143\1\172\1\162\1\164\1\151\1\141\1\172\2\157\1\uffff\1\150"+
        "\1\156\1\141\3\uffff\1\156\1\172\1\144\1\157\1\141\1\164\1\uffff"+
        "\1\141\1\172\1\162\1\157\1\uffff\2\172\1\141\1\164\1\155\1\145\1"+
        "\uffff\1\145\2\172\1\145\1\162\1\uffff\1\157\1\172\2\uffff\1\172"+
        "\1\157\1\141\1\172\1\151\2\uffff\1\162\1\151\1\172\2\uffff\2\172"+
        "\1\uffff\1\162\1\172\1\157\3\uffff\1\157\1\uffff\2\172\1\uffff";
    static final String DFA14_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\7\1\10\1\11\1\12\1\13\7\uffff"+
        "\1\24\14\uffff\1\66\1\uffff\1\67\1\uffff\1\63\1\73\1\23\1\6\1\11"+
        "\1\14\1\36\1\31\1\15\1\37\1\32\1\16\1\74\1\34\1\17\1\33\1\20\1\35"+
        "\2\uffff\1\21\1\uffff\1\25\1\30\1\26\1\27\14\uffff\1\71\1\uffff"+
        "\1\70\1\72\2\uffff\1\22\20\uffff\1\61\25\uffff\1\64\3\uffff\1\55"+
        "\1\56\1\41\6\uffff\1\50\4\uffff\1\57\6\uffff\1\42\5\uffff\1\52\2"+
        "\uffff\1\65\1\62\5\uffff\1\43\1\44\3\uffff\1\53\1\47\2\uffff\1\54"+
        "\3\uffff\1\45\1\60\1\40\1\uffff\1\46\2\uffff\1\51";
    static final String DFA14_specialS =
        "\36\uffff\1\1\4\uffff\1\0\u0091\uffff}>";
    static final String[] DFA14_transitionS = {
            "\2\45\2\uffff\1\45\22\uffff\1\45\1\23\1\36\2\44\1\20\1\11\1"+
            "\43\1\7\1\10\1\17\1\14\1\3\1\15\1\44\1\16\12\41\1\13\1\12\1"+
            "\25\1\6\1\24\2\44\32\40\1\4\1\44\1\5\1\44\1\40\1\44\2\40\1\32"+
            "\1\40\1\21\1\34\2\40\1\33\2\40\1\31\1\40\1\37\1\22\1\26\1\40"+
            "\1\27\1\35\2\40\1\30\4\40\1\1\1\44\1\2\1\44\43\uffff\2\44\3"+
            "\uffff\1\44\2\uffff\1\44\1\uffff\1\44\5\uffff\2\44\5\uffff\2"+
            "\44\5\uffff\4\44\3\uffff\1\44\1\uffff\2\44\2\uffff\1\44\5\uffff"+
            "\3\44\4\uffff\1\44\1\uffff\1\44\3\uffff\4\44\3\uffff\1\44\1"+
            "\uffff\2\44\2\uffff\1\44\5\uffff\3\44\4\uffff\1\44\1\uffff\1"+
            "\44",
            "",
            "",
            "",
            "",
            "",
            "\1\46",
            "",
            "",
            "",
            "",
            "",
            "\1\52\21\uffff\1\51",
            "\1\55\17\uffff\1\54",
            "\1\60\4\uffff\1\60\15\uffff\1\57",
            "\1\62",
            "\1\64",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\15\40\1\67\4\40\1"+
            "\66\7\40",
            "\1\71",
            "",
            "\1\72",
            "\1\74",
            "\1\77\20\uffff\1\76",
            "\1\100",
            "\1\101\3\uffff\1\102",
            "\1\103",
            "\1\104\15\uffff\1\105",
            "\1\106",
            "\1\110\23\uffff\1\107",
            "\1\111",
            "\0\112",
            "\1\113",
            "",
            "\1\114\1\uffff\12\41",
            "",
            "\47\115\1\uffff\uffd8\115",
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
            "",
            "",
            "",
            "\1\116",
            "\1\117",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "",
            "",
            "",
            "",
            "\1\121",
            "\1\122",
            "\1\123\22\uffff\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130\15\uffff\1\131\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136\10\uffff\1\137",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\15\40\1\140\14\40",
            "",
            "\1\142",
            "",
            "",
            "\1\143",
            "\1\144",
            "",
            "\1\145",
            "\1\146\3\uffff\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\161\1\160",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\170",
            "\1\171",
            "\1\172",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\u008a",
            "\1\u008b",
            "",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "",
            "",
            "",
            "\1\u008f",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "",
            "\1\u0095",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\u0097",
            "\1\u0098",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "",
            "\1\u009f",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\u00a2",
            "\1\u00a3",
            "",
            "\1\u00a4",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\u00a7",
            "\1\u00a8",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\u00aa",
            "",
            "",
            "\1\u00ab",
            "\1\u00ac",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "",
            "\1\u00b0",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\1\u00b2",
            "",
            "",
            "",
            "\1\u00b3",
            "",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
            "\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
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
            return "1:1: Tokens : ( T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | PR_PROGRAMA | PR_REAL | PR_VAZIO | PR_LOGICO | PR_CADEIA | PR_INTEIRO | PR_CARACTER | PR_ESCOLHA | PR_CASO | PR_CONTRARIO | PR_CONST | PR_FUNCAO | PR_RETORNE | PR_PARA | PR_PARE | PR_FACA | PR_ENQUANTO | PR_SE | PR_SENAO | GAMBIARRA | OPERADOR_NAO | LOGICO | ID | INTEIRO | REAL | CADEIA | CARACTER | ESPACO | COMENTARIO );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_35 = input.LA(1);

                        s = -1;
                        if ( ((LA14_35>='\u0000' && LA14_35<='&')||(LA14_35>='(' && LA14_35<='\uFFFF')) ) {s = 77;}

                        else s = 36;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA14_30 = input.LA(1);

                        s = -1;
                        if ( ((LA14_30>='\u0000' && LA14_30<='\uFFFF')) ) {s = 74;}

                        else s = 36;

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