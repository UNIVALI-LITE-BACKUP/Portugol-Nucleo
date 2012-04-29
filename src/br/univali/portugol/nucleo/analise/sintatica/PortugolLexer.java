// $ANTLR 3.4 D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g 2012-04-29 17:54:46
 
	package br.univali.portugol.nucleo.analise.sintatica;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class PortugolLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__38=38;
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
    public static final int CADEIA=4;
    public static final int CARACTER=5;
    public static final int COMENTARIO=6;
    public static final int DIGIT_HEX=7;
    public static final int ESC_OCTAL=8;
    public static final int ESC_UNICODE=9;
    public static final int ESPACO=10;
    public static final int ID=11;
    public static final int INTEIRO=12;
    public static final int LOGICO=13;
    public static final int OPERADOR_NAO=14;
    public static final int PR_CADEIA=15;
    public static final int PR_CARACTER=16;
    public static final int PR_CASO=17;
    public static final int PR_CASO_CONTRARIO=18;
    public static final int PR_CONST=19;
    public static final int PR_ENQUANTO=20;
    public static final int PR_ESCOLHA=21;
    public static final int PR_FACA=22;
    public static final int PR_FALSO=23;
    public static final int PR_FUNCAO=24;
    public static final int PR_INTEIRO=25;
    public static final int PR_LOGICO=26;
    public static final int PR_PARA=27;
    public static final int PR_PARE=28;
    public static final int PR_PROGRAMA=29;
    public static final int PR_REAL=30;
    public static final int PR_RETORNE=31;
    public static final int PR_SE=32;
    public static final int PR_SENAO=33;
    public static final int PR_VAZIO=34;
    public static final int PR_VERDADEIRO=35;
    public static final int REAL=36;
    public static final int SEQ_ESC=37;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public PortugolLexer() {} 
    public PortugolLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public PortugolLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g"; }

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:6:7: ( '!=' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:6:9: '!='
            {
            match("!="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:7:7: ( '%' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:7:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:8:7: ( '%=' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:8:9: '%='
            {
            match("%="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:9:7: ( '&' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:9:9: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:10:7: ( '(' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:10:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:11:7: ( ')' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:11:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:12:7: ( '*' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:12:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:13:7: ( '*=' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:13:9: '*='
            {
            match("*="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:14:7: ( '+' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:14:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:15:7: ( '++' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:15:9: '++'
            {
            match("++"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:16:7: ( '+=' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:16:9: '+='
            {
            match("+="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:17:7: ( ',' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:17:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:18:7: ( '-' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:18:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:19:7: ( '--' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:19:9: '--'
            {
            match("--"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:20:7: ( '-=' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:20:9: '-='
            {
            match("-="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:21:7: ( '/' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:21:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:22:7: ( '/=' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:22:9: '/='
            {
            match("/="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:23:7: ( ':' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:23:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:24:7: ( ';' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:24:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:25:7: ( '<' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:25:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:26:7: ( '<=' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:26:9: '<='
            {
            match("<="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:27:7: ( '=' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:27:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:28:7: ( '==' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:28:9: '=='
            {
            match("=="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:29:7: ( '>' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:29:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:30:7: ( '>=' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:30:9: '>='
            {
            match(">="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:31:7: ( '[' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:31:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:32:7: ( ']' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:32:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:33:7: ( 'e' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:33:9: 'e'
            {
            match('e'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:34:7: ( 'ou' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:34:9: 'ou'
            {
            match("ou"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:35:7: ( '{' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:35:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:36:7: ( '}' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:36:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "PR_PROGRAMA"
    public final void mPR_PROGRAMA() throws RecognitionException {
        try {
            int _type = PR_PROGRAMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:114:15: ( 'programa' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:114:17: 'programa'
            {
            match("programa"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PR_PROGRAMA"

    // $ANTLR start "PR_REAL"
    public final void mPR_REAL() throws RecognitionException {
        try {
            int _type = PR_REAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:115:12: ( 'real' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:115:14: 'real'
            {
            match("real"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PR_REAL"

    // $ANTLR start "PR_VAZIO"
    public final void mPR_VAZIO() throws RecognitionException {
        try {
            int _type = PR_VAZIO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:116:13: ( 'vazio' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:116:15: 'vazio'
            {
            match("vazio"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PR_VAZIO"

    // $ANTLR start "PR_LOGICO"
    public final void mPR_LOGICO() throws RecognitionException {
        try {
            int _type = PR_LOGICO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:117:14: ( 'logico' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:117:16: 'logico'
            {
            match("logico"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PR_LOGICO"

    // $ANTLR start "PR_CADEIA"
    public final void mPR_CADEIA() throws RecognitionException {
        try {
            int _type = PR_CADEIA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:118:14: ( 'cadeia' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:118:16: 'cadeia'
            {
            match("cadeia"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PR_CADEIA"

    // $ANTLR start "PR_INTEIRO"
    public final void mPR_INTEIRO() throws RecognitionException {
        try {
            int _type = PR_INTEIRO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:119:15: ( 'inteiro' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:119:17: 'inteiro'
            {
            match("inteiro"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PR_INTEIRO"

    // $ANTLR start "PR_CARACTER"
    public final void mPR_CARACTER() throws RecognitionException {
        try {
            int _type = PR_CARACTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:120:15: ( 'caracter' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:120:17: 'caracter'
            {
            match("caracter"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PR_CARACTER"

    // $ANTLR start "PR_ESCOLHA"
    public final void mPR_ESCOLHA() throws RecognitionException {
        try {
            int _type = PR_ESCOLHA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:121:14: ( 'escolha' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:121:16: 'escolha'
            {
            match("escolha"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PR_ESCOLHA"

    // $ANTLR start "PR_CASO_CONTRARIO"
    public final void mPR_CASO_CONTRARIO() throws RecognitionException {
        try {
            int _type = PR_CASO_CONTRARIO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:122:20: ( 'caso contrario' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:122:22: 'caso contrario'
            {
            match("caso contrario"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PR_CASO_CONTRARIO"

    // $ANTLR start "PR_CASO"
    public final void mPR_CASO() throws RecognitionException {
        try {
            int _type = PR_CASO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:123:12: ( 'caso' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:123:14: 'caso'
            {
            match("caso"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PR_CASO"

    // $ANTLR start "PR_CONST"
    public final void mPR_CONST() throws RecognitionException {
        try {
            int _type = PR_CONST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:124:13: ( 'const' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:124:15: 'const'
            {
            match("const"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PR_CONST"

    // $ANTLR start "PR_FUNCAO"
    public final void mPR_FUNCAO() throws RecognitionException {
        try {
            int _type = PR_FUNCAO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:125:14: ( 'funcao' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:125:16: 'funcao'
            {
            match("funcao"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PR_FUNCAO"

    // $ANTLR start "PR_RETORNE"
    public final void mPR_RETORNE() throws RecognitionException {
        try {
            int _type = PR_RETORNE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:126:14: ( 'retorne' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:126:16: 'retorne'
            {
            match("retorne"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PR_RETORNE"

    // $ANTLR start "PR_PARA"
    public final void mPR_PARA() throws RecognitionException {
        try {
            int _type = PR_PARA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:127:12: ( 'para' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:127:14: 'para'
            {
            match("para"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PR_PARA"

    // $ANTLR start "PR_PARE"
    public final void mPR_PARE() throws RecognitionException {
        try {
            int _type = PR_PARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:128:12: ( 'pare' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:128:14: 'pare'
            {
            match("pare"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PR_PARE"

    // $ANTLR start "PR_FACA"
    public final void mPR_FACA() throws RecognitionException {
        try {
            int _type = PR_FACA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:129:12: ( 'faca' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:129:14: 'faca'
            {
            match("faca"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PR_FACA"

    // $ANTLR start "PR_ENQUANTO"
    public final void mPR_ENQUANTO() throws RecognitionException {
        try {
            int _type = PR_ENQUANTO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:130:15: ( 'enquanto' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:130:17: 'enquanto'
            {
            match("enquanto"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PR_ENQUANTO"

    // $ANTLR start "PR_SE"
    public final void mPR_SE() throws RecognitionException {
        try {
            int _type = PR_SE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:131:11: ( 'se' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:131:13: 'se'
            {
            match("se"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PR_SE"

    // $ANTLR start "PR_SENAO"
    public final void mPR_SENAO() throws RecognitionException {
        try {
            int _type = PR_SENAO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:132:13: ( 'senao' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:132:15: 'senao'
            {
            match("senao"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PR_SENAO"

    // $ANTLR start "PR_FALSO"
    public final void mPR_FALSO() throws RecognitionException {
        try {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:134:21: ( 'falso' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:134:23: 'falso'
            {
            match("falso"); 



            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PR_FALSO"

    // $ANTLR start "PR_VERDADEIRO"
    public final void mPR_VERDADEIRO() throws RecognitionException {
        try {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:135:25: ( 'verdadeiro' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:135:27: 'verdadeiro'
            {
            match("verdadeiro"); 



            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PR_VERDADEIRO"

    // $ANTLR start "OPERADOR_NAO"
    public final void mOPERADOR_NAO() throws RecognitionException {
        try {
            int _type = OPERADOR_NAO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:137:16: ( 'nao' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:137:18: 'nao'
            {
            match("nao"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OPERADOR_NAO"

    // $ANTLR start "LOGICO"
    public final void mLOGICO() throws RecognitionException {
        try {
            int _type = LOGICO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:139:11: ( PR_VERDADEIRO | PR_FALSO )
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
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:139:14: PR_VERDADEIRO
                    {
                    mPR_VERDADEIRO(); 


                    }
                    break;
                case 2 :
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:139:30: PR_FALSO
                    {
                    mPR_FALSO(); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LOGICO"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:141:9: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:141:11: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:141:35: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


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
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "INTEIRO"
    public final void mINTEIRO() throws RecognitionException {
        try {
            int _type = INTEIRO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:143:13: ( ( '0' .. '9' )* )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:143:15: ( '0' .. '9' )*
            {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:143:15: ( '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


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
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INTEIRO"

    // $ANTLR start "REAL"
    public final void mREAL() throws RecognitionException {
        try {
            int _type = REAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:145:10: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )+ )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:145:13: ( '0' .. '9' )+ '.' ( '0' .. '9' )+
            {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:145:13: ( '0' .. '9' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


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

            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:145:29: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


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
        	// do for sure before leaving
        }
    }
    // $ANTLR end "REAL"

    // $ANTLR start "CADEIA"
    public final void mCADEIA() throws RecognitionException {
        try {
            int _type = CADEIA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:147:11: ( '\"' ( SEQ_ESC |~ ( '\\\\' | '\"' ) )* '\"' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:147:13: '\"' ( SEQ_ESC |~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 

            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:147:17: ( SEQ_ESC |~ ( '\\\\' | '\"' ) )*
            loop6:
            do {
                int alt6=3;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='\\') ) {
                    alt6=1;
                }
                else if ( ((LA6_0 >= '\u0000' && LA6_0 <= '!')||(LA6_0 >= '#' && LA6_0 <= '[')||(LA6_0 >= ']' && LA6_0 <= '\uFFFF')) ) {
                    alt6=2;
                }


                switch (alt6) {
            	case 1 :
            	    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:147:19: SEQ_ESC
            	    {
            	    mSEQ_ESC(); 


            	    }
            	    break;
            	case 2 :
            	    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:147:29: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


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
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CADEIA"

    // $ANTLR start "CARACTER"
    public final void mCARACTER() throws RecognitionException {
        try {
            int _type = CARACTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:149:13: ( '\\'' ( SEQ_ESC |~ ( '\\'' | '\\\\' ) ) '\\'' )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:149:17: '\\'' ( SEQ_ESC |~ ( '\\'' | '\\\\' ) ) '\\''
            {
            match('\''); 

            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:149:22: ( SEQ_ESC |~ ( '\\'' | '\\\\' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\\') ) {
                alt7=1;
            }
            else if ( ((LA7_0 >= '\u0000' && LA7_0 <= '&')||(LA7_0 >= '(' && LA7_0 <= '[')||(LA7_0 >= ']' && LA7_0 <= '\uFFFF')) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }
            switch (alt7) {
                case 1 :
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:149:24: SEQ_ESC
                    {
                    mSEQ_ESC(); 


                    }
                    break;
                case 2 :
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:149:34: ~ ( '\\'' | '\\\\' )
                    {
                    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CARACTER"

    // $ANTLR start "ESPACO"
    public final void mESPACO() throws RecognitionException {
        try {
            int _type = ESPACO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:151:11: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:151:13: ( ' ' | '\\t' | '\\r' | '\\n' )
            {
            if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ESPACO"

    // $ANTLR start "DIGIT_HEX"
    public final void mDIGIT_HEX() throws RecognitionException {
        try {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:154:22: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIGIT_HEX"

    // $ANTLR start "SEQ_ESC"
    public final void mSEQ_ESC() throws RecognitionException {
        try {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:156:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ESC_UNICODE | ESC_OCTAL )
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
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:156:23: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    {
                    match('\\'); 

                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:156:70: ESC_UNICODE
                    {
                    mESC_UNICODE(); 


                    }
                    break;
                case 3 :
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:156:87: ESC_OCTAL
                    {
                    mESC_OCTAL(); 


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SEQ_ESC"

    // $ANTLR start "ESC_OCTAL"
    public final void mESC_OCTAL() throws RecognitionException {
        try {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:158:21: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt9=3;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\\') ) {
                int LA9_1 = input.LA(2);

                if ( ((LA9_1 >= '0' && LA9_1 <= '3')) ) {
                    int LA9_2 = input.LA(3);

                    if ( ((LA9_2 >= '0' && LA9_2 <= '7')) ) {
                        int LA9_4 = input.LA(4);

                        if ( ((LA9_4 >= '0' && LA9_4 <= '7')) ) {
                            alt9=1;
                        }
                        else {
                            alt9=2;
                        }
                    }
                    else {
                        alt9=3;
                    }
                }
                else if ( ((LA9_1 >= '4' && LA9_1 <= '7')) ) {
                    int LA9_3 = input.LA(3);

                    if ( ((LA9_3 >= '0' && LA9_3 <= '7')) ) {
                        alt9=2;
                    }
                    else {
                        alt9=3;
                    }
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
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:158:23: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '3') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:158:66: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 3 :
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:158:100: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 

                    if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ESC_OCTAL"

    // $ANTLR start "ESC_UNICODE"
    public final void mESC_UNICODE() throws RecognitionException {
        try {
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:160:23: ( '\\\\' 'u' DIGIT_HEX DIGIT_HEX DIGIT_HEX DIGIT_HEX )
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:160:25: '\\\\' 'u' DIGIT_HEX DIGIT_HEX DIGIT_HEX DIGIT_HEX
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
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ESC_UNICODE"

    // $ANTLR start "COMENTARIO"
    public final void mCOMENTARIO() throws RecognitionException {
        try {
            int _type = COMENTARIO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:162:14: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
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
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:164:2: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
                    {
                    match("//"); 



                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:164:7: (~ ( '\\n' | '\\r' ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0 >= '\u0000' && LA10_0 <= '\t')||(LA10_0 >= '\u000B' && LA10_0 <= '\f')||(LA10_0 >= '\u000E' && LA10_0 <= '\uFFFF')) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:
                    	    {
                    	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:164:21: ( '\\r' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='\r') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:164:21: '\\r'
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
                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:166:3: '/*' ( options {greedy=false; } : . )* '*/'
                    {
                    match("/*"); 



                    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:166:8: ( options {greedy=false; } : . )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0=='*') ) {
                            int LA12_1 = input.LA(2);

                            if ( (LA12_1=='/') ) {
                                alt12=2;
                            }
                            else if ( ((LA12_1 >= '\u0000' && LA12_1 <= '.')||(LA12_1 >= '0' && LA12_1 <= '\uFFFF')) ) {
                                alt12=1;
                            }


                        }
                        else if ( ((LA12_0 >= '\u0000' && LA12_0 <= ')')||(LA12_0 >= '+' && LA12_0 <= '\uFFFF')) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:166:36: .
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
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMENTARIO"

    public void mTokens() throws RecognitionException {
        // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:8: ( T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | PR_PROGRAMA | PR_REAL | PR_VAZIO | PR_LOGICO | PR_CADEIA | PR_INTEIRO | PR_CARACTER | PR_ESCOLHA | PR_CASO_CONTRARIO | PR_CASO | PR_CONST | PR_FUNCAO | PR_RETORNE | PR_PARA | PR_PARE | PR_FACA | PR_ENQUANTO | PR_SE | PR_SENAO | OPERADOR_NAO | LOGICO | ID | INTEIRO | REAL | CADEIA | CARACTER | ESPACO | COMENTARIO )
        int alt14=59;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:10: T__38
                {
                mT__38(); 


                }
                break;
            case 2 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:16: T__39
                {
                mT__39(); 


                }
                break;
            case 3 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:22: T__40
                {
                mT__40(); 


                }
                break;
            case 4 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:28: T__41
                {
                mT__41(); 


                }
                break;
            case 5 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:34: T__42
                {
                mT__42(); 


                }
                break;
            case 6 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:40: T__43
                {
                mT__43(); 


                }
                break;
            case 7 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:46: T__44
                {
                mT__44(); 


                }
                break;
            case 8 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:52: T__45
                {
                mT__45(); 


                }
                break;
            case 9 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:58: T__46
                {
                mT__46(); 


                }
                break;
            case 10 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:64: T__47
                {
                mT__47(); 


                }
                break;
            case 11 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:70: T__48
                {
                mT__48(); 


                }
                break;
            case 12 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:76: T__49
                {
                mT__49(); 


                }
                break;
            case 13 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:82: T__50
                {
                mT__50(); 


                }
                break;
            case 14 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:88: T__51
                {
                mT__51(); 


                }
                break;
            case 15 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:94: T__52
                {
                mT__52(); 


                }
                break;
            case 16 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:100: T__53
                {
                mT__53(); 


                }
                break;
            case 17 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:106: T__54
                {
                mT__54(); 


                }
                break;
            case 18 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:112: T__55
                {
                mT__55(); 


                }
                break;
            case 19 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:118: T__56
                {
                mT__56(); 


                }
                break;
            case 20 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:124: T__57
                {
                mT__57(); 


                }
                break;
            case 21 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:130: T__58
                {
                mT__58(); 


                }
                break;
            case 22 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:136: T__59
                {
                mT__59(); 


                }
                break;
            case 23 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:142: T__60
                {
                mT__60(); 


                }
                break;
            case 24 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:148: T__61
                {
                mT__61(); 


                }
                break;
            case 25 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:154: T__62
                {
                mT__62(); 


                }
                break;
            case 26 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:160: T__63
                {
                mT__63(); 


                }
                break;
            case 27 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:166: T__64
                {
                mT__64(); 


                }
                break;
            case 28 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:172: T__65
                {
                mT__65(); 


                }
                break;
            case 29 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:178: T__66
                {
                mT__66(); 


                }
                break;
            case 30 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:184: T__67
                {
                mT__67(); 


                }
                break;
            case 31 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:190: T__68
                {
                mT__68(); 


                }
                break;
            case 32 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:196: PR_PROGRAMA
                {
                mPR_PROGRAMA(); 


                }
                break;
            case 33 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:208: PR_REAL
                {
                mPR_REAL(); 


                }
                break;
            case 34 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:216: PR_VAZIO
                {
                mPR_VAZIO(); 


                }
                break;
            case 35 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:225: PR_LOGICO
                {
                mPR_LOGICO(); 


                }
                break;
            case 36 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:235: PR_CADEIA
                {
                mPR_CADEIA(); 


                }
                break;
            case 37 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:245: PR_INTEIRO
                {
                mPR_INTEIRO(); 


                }
                break;
            case 38 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:256: PR_CARACTER
                {
                mPR_CARACTER(); 


                }
                break;
            case 39 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:268: PR_ESCOLHA
                {
                mPR_ESCOLHA(); 


                }
                break;
            case 40 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:279: PR_CASO_CONTRARIO
                {
                mPR_CASO_CONTRARIO(); 


                }
                break;
            case 41 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:297: PR_CASO
                {
                mPR_CASO(); 


                }
                break;
            case 42 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:305: PR_CONST
                {
                mPR_CONST(); 


                }
                break;
            case 43 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:314: PR_FUNCAO
                {
                mPR_FUNCAO(); 


                }
                break;
            case 44 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:324: PR_RETORNE
                {
                mPR_RETORNE(); 


                }
                break;
            case 45 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:335: PR_PARA
                {
                mPR_PARA(); 


                }
                break;
            case 46 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:343: PR_PARE
                {
                mPR_PARE(); 


                }
                break;
            case 47 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:351: PR_FACA
                {
                mPR_FACA(); 


                }
                break;
            case 48 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:359: PR_ENQUANTO
                {
                mPR_ENQUANTO(); 


                }
                break;
            case 49 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:371: PR_SE
                {
                mPR_SE(); 


                }
                break;
            case 50 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:377: PR_SENAO
                {
                mPR_SENAO(); 


                }
                break;
            case 51 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:386: OPERADOR_NAO
                {
                mOPERADOR_NAO(); 


                }
                break;
            case 52 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:399: LOGICO
                {
                mLOGICO(); 


                }
                break;
            case 53 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:406: ID
                {
                mID(); 


                }
                break;
            case 54 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:409: INTEIRO
                {
                mINTEIRO(); 


                }
                break;
            case 55 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:417: REAL
                {
                mREAL(); 


                }
                break;
            case 56 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:422: CADEIA
                {
                mCADEIA(); 


                }
                break;
            case 57 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:429: CARACTER
                {
                mCARACTER(); 


                }
                break;
            case 58 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:438: ESPACO
                {
                mESPACO(); 


                }
                break;
            case 59 :
                // D:\\Luiz Fernando\\Documentos\\Projetos\\Portugol\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:1:445: COMENTARIO
                {
                mCOMENTARIO(); 


                }
                break;

        }

    }


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\1\41\1\uffff\1\46\3\uffff\1\50\1\53\1\uffff\1\56\1\61\2\uffff\1"+
        "\63\1\65\1\67\2\uffff\1\72\1\37\2\uffff\11\37\1\uffff\1\41\27\uffff"+
        "\2\37\1\uffff\1\114\13\37\1\135\1\37\1\uffff\2\37\1\uffff\20\37"+
        "\1\uffff\1\162\3\37\1\166\1\167\1\170\6\37\1\u0080\3\37\1\u0084"+
        "\2\37\1\uffff\3\37\3\uffff\1\37\1\u008b\4\37\2\uffff\1\u0090\2\37"+
        "\1\uffff\1\u0093\1\u0094\4\37\1\uffff\1\37\1\u009a\1\u009b\1\37"+
        "\1\uffff\1\37\1\u009e\2\uffff\1\u009f\2\37\1\u00a2\1\37\2\uffff"+
        "\1\37\1\u00a5\2\uffff\1\u00a6\1\u00a7\1\uffff\1\37\1\u00a9\3\uffff"+
        "\1\37\1\uffff\1\u0093";
    static final String DFA14_eofS =
        "\u00ab\uffff";
    static final String DFA14_minS =
        "\1\11\1\uffff\1\75\3\uffff\1\75\1\53\1\uffff\1\55\1\52\2\uffff\3"+
        "\75\2\uffff\1\60\1\165\2\uffff\1\141\1\145\1\141\1\157\1\141\1\156"+
        "\1\141\1\145\1\141\1\uffff\1\56\27\uffff\1\143\1\161\1\uffff\1\60"+
        "\1\157\1\162\1\141\1\172\1\162\1\147\1\144\1\156\1\164\1\156\1\143"+
        "\1\60\1\157\1\uffff\1\157\1\165\1\uffff\1\147\1\141\1\154\1\157"+
        "\1\151\1\144\1\151\1\145\1\141\1\157\1\163\1\145\1\143\1\141\1\163"+
        "\1\141\1\uffff\1\60\1\154\1\141\1\162\3\60\1\162\1\157\1\141\1\143"+
        "\1\151\1\143\1\40\1\164\1\151\1\141\1\60\2\157\1\uffff\1\150\1\156"+
        "\1\141\3\uffff\1\156\1\60\1\144\1\157\1\141\1\164\2\uffff\1\60\1"+
        "\162\1\157\1\uffff\2\60\1\141\1\164\1\155\1\145\1\uffff\1\145\2"+
        "\60\1\145\1\uffff\1\157\1\60\2\uffff\1\60\1\157\1\141\1\60\1\151"+
        "\2\uffff\1\162\1\60\2\uffff\2\60\1\uffff\1\162\1\60\3\uffff\1\157"+
        "\1\uffff\1\60";
    static final String DFA14_maxS =
        "\1\175\1\uffff\1\75\3\uffff\2\75\1\uffff\2\75\2\uffff\3\75\2\uffff"+
        "\1\172\1\165\2\uffff\1\162\2\145\2\157\1\156\1\165\1\145\1\141\1"+
        "\uffff\1\71\27\uffff\1\143\1\161\1\uffff\1\172\1\157\1\162\1\164"+
        "\1\172\1\162\1\147\1\163\1\156\1\164\1\156\1\154\1\172\1\157\1\uffff"+
        "\1\157\1\165\1\uffff\1\147\1\145\1\154\1\157\1\151\1\144\1\151\1"+
        "\145\1\141\1\157\1\163\1\145\1\143\1\141\1\163\1\141\1\uffff\1\172"+
        "\1\154\1\141\1\162\3\172\1\162\1\157\1\141\1\143\1\151\1\143\1\172"+
        "\1\164\1\151\1\141\1\172\2\157\1\uffff\1\150\1\156\1\141\3\uffff"+
        "\1\156\1\172\1\144\1\157\1\141\1\164\2\uffff\1\172\1\162\1\157\1"+
        "\uffff\2\172\1\141\1\164\1\155\1\145\1\uffff\1\145\2\172\1\145\1"+
        "\uffff\1\157\1\172\2\uffff\1\172\1\157\1\141\1\172\1\151\2\uffff"+
        "\1\162\1\172\2\uffff\2\172\1\uffff\1\162\1\172\3\uffff\1\157\1\uffff"+
        "\1\172";
    static final String DFA14_acceptS =
        "\1\uffff\1\1\1\uffff\1\4\1\5\1\6\2\uffff\1\14\2\uffff\1\22\1\23"+
        "\3\uffff\1\32\1\33\2\uffff\1\36\1\37\11\uffff\1\65\1\uffff\1\66"+
        "\1\70\1\71\1\72\1\3\1\2\1\10\1\7\1\12\1\13\1\11\1\16\1\17\1\15\1"+
        "\21\1\73\1\20\1\25\1\24\1\27\1\26\1\31\1\30\2\uffff\1\34\16\uffff"+
        "\1\67\2\uffff\1\35\20\uffff\1\61\24\uffff\1\63\3\uffff\1\55\1\56"+
        "\1\41\6\uffff\1\50\1\51\3\uffff\1\57\6\uffff\1\42\4\uffff\1\52\2"+
        "\uffff\1\64\1\62\5\uffff\1\43\1\44\2\uffff\1\53\1\47\2\uffff\1\54"+
        "\2\uffff\1\45\1\60\1\40\1\uffff\1\46\1\uffff";
    static final String DFA14_specialS =
        "\u00ab\uffff}>";
    static final String[] DFA14_transitionS = {
            "\2\44\2\uffff\1\44\22\uffff\1\44\1\1\1\42\2\uffff\1\2\1\3\1"+
            "\43\1\4\1\5\1\6\1\7\1\10\1\11\1\uffff\1\12\12\40\1\13\1\14\1"+
            "\15\1\16\1\17\2\uffff\32\37\1\20\1\uffff\1\21\1\uffff\1\37\1"+
            "\uffff\2\37\1\32\1\37\1\22\1\34\2\37\1\33\2\37\1\31\1\37\1\36"+
            "\1\23\1\26\1\37\1\27\1\35\2\37\1\30\4\37\1\24\1\uffff\1\25",
            "",
            "\1\45",
            "",
            "",
            "",
            "\1\47",
            "\1\51\21\uffff\1\52",
            "",
            "\1\54\17\uffff\1\55",
            "\1\60\4\uffff\1\60\15\uffff\1\57",
            "",
            "",
            "\1\62",
            "\1\64",
            "\1\66",
            "",
            "",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\15\37\1\71\4\37\1"+
            "\70\7\37",
            "\1\73",
            "",
            "",
            "\1\75\20\uffff\1\74",
            "\1\76",
            "\1\77\3\uffff\1\100",
            "\1\101",
            "\1\102\15\uffff\1\103",
            "\1\104",
            "\1\106\23\uffff\1\105",
            "\1\107",
            "\1\110",
            "",
            "\1\111\1\uffff\12\40",
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
            "",
            "",
            "",
            "",
            "",
            "\1\112",
            "\1\113",
            "",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\115",
            "\1\116",
            "\1\117\22\uffff\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124\15\uffff\1\125\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132\10\uffff\1\133",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\15\37\1\134\14\37",
            "\1\136",
            "",
            "\1\137",
            "\1\140",
            "",
            "\1\141",
            "\1\142\3\uffff\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\163",
            "\1\164",
            "\1\165",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "\1\176",
            "\1\177\17\uffff\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32"+
            "\37",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\u0085",
            "\1\u0086",
            "",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "",
            "",
            "",
            "\1\u008a",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "",
            "",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\u0091",
            "\1\u0092",
            "",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "",
            "\1\u0099",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\u009c",
            "",
            "\1\u009d",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "",
            "",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\u00a0",
            "\1\u00a1",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\u00a3",
            "",
            "",
            "\1\u00a4",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "",
            "",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "",
            "\1\u00a8",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "",
            "",
            "",
            "\1\u00aa",
            "",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37"
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
            return "1:1: Tokens : ( T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | PR_PROGRAMA | PR_REAL | PR_VAZIO | PR_LOGICO | PR_CADEIA | PR_INTEIRO | PR_CARACTER | PR_ESCOLHA | PR_CASO_CONTRARIO | PR_CASO | PR_CONST | PR_FUNCAO | PR_RETORNE | PR_PARA | PR_PARE | PR_FACA | PR_ENQUANTO | PR_SE | PR_SENAO | OPERADOR_NAO | LOGICO | ID | INTEIRO | REAL | CADEIA | CARACTER | ESPACO | COMENTARIO );";
        }
    }
 

}