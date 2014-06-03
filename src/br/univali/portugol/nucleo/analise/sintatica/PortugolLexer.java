// $ANTLR 3.5 C:\\Users\\Paula\\Desktop\\Portugol.g 2013-10-18 19:38:46
package br.univali.portugol.nucleo.analise.sintatica;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PortugolLexer extends Lexer
{
    public static final int EOF = -1;
    public static final int T__42 = 42;
    public static final int T__43 = 43;
    public static final int T__44 = 44;
    public static final int T__45 = 45;
    public static final int T__46 = 46;
    public static final int T__47 = 47;
    public static final int T__48 = 48;
    public static final int T__49 = 49;
    public static final int T__50 = 50;
    public static final int T__51 = 51;
    public static final int T__52 = 52;
    public static final int T__53 = 53;
    public static final int T__54 = 54;
    public static final int T__55 = 55;
    public static final int T__56 = 56;
    public static final int T__57 = 57;
    public static final int T__58 = 58;
    public static final int T__59 = 59;
    public static final int T__60 = 60;
    public static final int T__61 = 61;
    public static final int T__62 = 62;
    public static final int T__63 = 63;
    public static final int T__64 = 64;
    public static final int T__65 = 65;
    public static final int T__66 = 66;
    public static final int T__67 = 67;
    public static final int T__68 = 68;
    public static final int T__69 = 69;
    public static final int T__70 = 70;
    public static final int T__71 = 71;
    public static final int T__72 = 72;
    public static final int T__73 = 73;
    public static final int T__74 = 74;
    public static final int T__75 = 75;
    public static final int T__76 = 76;
    public static final int T__77 = 77;
    public static final int T__78 = 78;
    public static final int T__79 = 79;
    public static final int T__80 = 80;
    public static final int T__81 = 81;
    public static final int T__82 = 82;
    public static final int T__83 = 83;
    public static final int CADEIA = 4;
    public static final int CARACTER = 5;
    public static final int COMENTARIO = 6;
    public static final int DIGIT_HEX = 7;
    public static final int ESC_OCTAL = 8;
    public static final int ESC_UNICODE = 9;
    public static final int ESPACO = 10;
    public static final int GAMBIARRA = 11;
    public static final int ID = 12;
    public static final int ID_BIBLIOTECA = 13;
    public static final int INTEIRO = 14;
    public static final int LOGICO = 15;
    public static final int OPERADOR_NAO = 16;
    public static final int PR_BIBLIOTECA = 17;
    public static final int PR_CADEIA = 18;
    public static final int PR_CARACTER = 19;
    public static final int PR_CASO = 20;
    public static final int PR_CONST = 21;
    public static final int PR_CONTRARIO = 22;
    public static final int PR_ENQUANTO = 23;
    public static final int PR_ESCOLHA = 24;
    public static final int PR_FACA = 25;
    public static final int PR_FALSO = 26;
    public static final int PR_FUNCAO = 27;
    public static final int PR_INCLUA = 28;
    public static final int PR_INTEIRO = 29;
    public static final int PR_LOGICO = 30;
    public static final int PR_PARA = 31;
    public static final int PR_PARE = 32;
    public static final int PR_PROGRAMA = 33;
    public static final int PR_REAL = 34;
    public static final int PR_RETORNE = 35;
    public static final int PR_SE = 36;
    public static final int PR_SENAO = 37;
    public static final int PR_VAZIO = 38;
    public static final int PR_VERDADEIRO = 39;
    public static final int REAL = 40;
    public static final int SEQ_ESC = 41;

    // delegates
    // delegators
    public Lexer[] getDelegates()
    {
        return new Lexer[]
        {
        };
    }

    public PortugolLexer()
    {
    }

    public PortugolLexer(CharStream input)
    {
        this(input, new RecognizerSharedState());
    }

    public PortugolLexer(CharStream input, RecognizerSharedState state)
    {
        super(input, state);
    }

    @Override
    public String getGrammarFileName()
    {
        return "C:\\Users\\Paula\\Desktop\\Portugol.g";
    }

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException
    {
        try
        {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:6:7: ( '!=' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:6:9: '!='
            {
                match("!=");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException
    {
        try
        {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:7:7: ( '%' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:7:9: '%'
            {
                match('%');
            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException
    {
        try
        {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:8:7: ( '%=' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:8:9: '%='
            {
                match("%=");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException
    {
        try
        {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:9:7: ( '&' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:9:9: '&'
            {
                match('&');
            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException
    {
        try
        {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:10:7: ( '&=' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:10:9: '&='
            {
                match("&=");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException
    {
        try
        {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:11:7: ( '(' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:11:9: '('
            {
                match('(');
            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException
    {
        try
        {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:12:7: ( ')' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:12:9: ')'
            {
                match(')');
            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException
    {
        try
        {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:13:7: ( '*' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:13:9: '*'
            {
                match('*');
            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException
    {
        try
        {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:14:7: ( '*=' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:14:9: '*='
            {
                match("*=");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException
    {
        try
        {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:15:7: ( '+' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:15:9: '+'
            {
                match('+');
            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException
    {
        try
        {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:16:7: ( '++' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:16:9: '++'
            {
                match("++");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException
    {
        try
        {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:17:7: ( '+=' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:17:9: '+='
            {
                match("+=");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException
    {
        try
        {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:18:7: ( ',' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:18:9: ','
            {
                match(',');
            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException
    {
        try
        {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:19:7: ( '-' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:19:9: '-'
            {
                match('-');
            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException
    {
        try
        {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:20:7: ( '--' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:20:9: '--'
            {
                match("--");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException
    {
        try
        {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:21:7: ( '-->' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:21:9: '-->'
            {
                match("-->");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException
    {
        try
        {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:22:7: ( '-=' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:22:9: '-='
            {
                match("-=");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException
    {
        try
        {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:23:7: ( '/' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:23:9: '/'
            {
                match('/');
            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException
    {
        try
        {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:24:7: ( '/=' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:24:9: '/='
            {
                match("/=");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException
    {
        try
        {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:25:7: ( ':' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:25:9: ':'
            {
                match(':');
            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException
    {
        try
        {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:26:7: ( ';' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:26:9: ';'
            {
                match(';');
            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException
    {
        try
        {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:27:7: ( '<' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:27:9: '<'
            {
                match('<');
            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException
    {
        try
        {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:28:7: ( '<<' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:28:9: '<<'
            {
                match("<<");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException
    {
        try
        {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:29:7: ( '<<=' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:29:9: '<<='
            {
                match("<<=");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException
    {
        try
        {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:30:7: ( '<=' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:30:9: '<='
            {
                match("<=");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException
    {
        try
        {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:31:7: ( '=' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:31:9: '='
            {
                match('=');
            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException
    {
        try
        {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:32:7: ( '==' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:32:9: '=='
            {
                match("==");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException
    {
        try
        {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:33:7: ( '>' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:33:9: '>'
            {
                match('>');
            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException
    {
        try
        {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:34:7: ( '>=' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:34:9: '>='
            {
                match(">=");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException
    {
        try
        {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:35:7: ( '>>' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:35:9: '>>'
            {
                match(">>");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException
    {
        try
        {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:36:7: ( '>>=' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:36:9: '>>='
            {
                match(">>=");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException
    {
        try
        {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:37:7: ( '[' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:37:9: '['
            {
                match('[');
            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException
    {
        try
        {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:38:7: ( ']' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:38:9: ']'
            {
                match(']');
            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException
    {
        try
        {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:39:7: ( '^' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:39:9: '^'
            {
                match('^');
            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException
    {
        try
        {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:40:7: ( '^=' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:40:9: '^='
            {
                match("^=");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException
    {
        try
        {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:41:7: ( 'e' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:41:9: 'e'
            {
                match('e');
            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException
    {
        try
        {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:42:7: ( 'ou' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:42:9: 'ou'
            {
                match("ou");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException
    {
        try
        {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:43:7: ( '{' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:43:9: '{'
            {
                match('{');
            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException
    {
        try
        {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:44:7: ( '|' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:44:9: '|'
            {
                match('|');
            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException
    {
        try
        {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:45:7: ( '|=' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:45:9: '|='
            {
                match("|=");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException
    {
        try
        {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:46:7: ( '}' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:46:9: '}'
            {
                match('}');
            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException
    {
        try
        {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:47:7: ( '~' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:47:9: '~'
            {
                match('~');
            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "PR_PROGRAMA"
    public final void mPR_PROGRAMA() throws RecognitionException
    {
        try
        {
            int _type = PR_PROGRAMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:168:15: ( 'programa' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:168:17: 'programa'
            {
                match("programa");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "PR_PROGRAMA"

    // $ANTLR start "PR_REAL"
    public final void mPR_REAL() throws RecognitionException
    {
        try
        {
            int _type = PR_REAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:169:12: ( 'real' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:169:14: 'real'
            {
                match("real");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "PR_REAL"

    // $ANTLR start "PR_VAZIO"
    public final void mPR_VAZIO() throws RecognitionException
    {
        try
        {
            int _type = PR_VAZIO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:170:13: ( 'vazio' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:170:15: 'vazio'
            {
                match("vazio");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "PR_VAZIO"

    // $ANTLR start "PR_LOGICO"
    public final void mPR_LOGICO() throws RecognitionException
    {
        try
        {
            int _type = PR_LOGICO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:171:14: ( 'logico' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:171:16: 'logico'
            {
                match("logico");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "PR_LOGICO"

    // $ANTLR start "PR_CADEIA"
    public final void mPR_CADEIA() throws RecognitionException
    {
        try
        {
            int _type = PR_CADEIA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:172:14: ( 'cadeia' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:172:16: 'cadeia'
            {
                match("cadeia");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "PR_CADEIA"

    // $ANTLR start "PR_INTEIRO"
    public final void mPR_INTEIRO() throws RecognitionException
    {
        try
        {
            int _type = PR_INTEIRO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:173:15: ( 'inteiro' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:173:17: 'inteiro'
            {
                match("inteiro");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "PR_INTEIRO"

    // $ANTLR start "PR_CARACTER"
    public final void mPR_CARACTER() throws RecognitionException
    {
        try
        {
            int _type = PR_CARACTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:174:15: ( 'caracter' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:174:17: 'caracter'
            {
                match("caracter");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "PR_CARACTER"

    // $ANTLR start "PR_ESCOLHA"
    public final void mPR_ESCOLHA() throws RecognitionException
    {
        try
        {
            int _type = PR_ESCOLHA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:175:15: ( 'escolha' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:175:17: 'escolha'
            {
                match("escolha");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "PR_ESCOLHA"

    // $ANTLR start "PR_CASO"
    public final void mPR_CASO() throws RecognitionException
    {
        try
        {
            int _type = PR_CASO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:176:12: ( 'caso' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:176:14: 'caso'
            {
                match("caso");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "PR_CASO"

    // $ANTLR start "PR_CONTRARIO"
    public final void mPR_CONTRARIO() throws RecognitionException
    {
        try
        {
            int _type = PR_CONTRARIO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:177:16: ( 'contrario' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:177:18: 'contrario'
            {
                match("contrario");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "PR_CONTRARIO"

    // $ANTLR start "PR_CONST"
    public final void mPR_CONST() throws RecognitionException
    {
        try
        {
            int _type = PR_CONST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:178:13: ( 'const' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:178:15: 'const'
            {
                match("const");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "PR_CONST"

    // $ANTLR start "PR_FUNCAO"
    public final void mPR_FUNCAO() throws RecognitionException
    {
        try
        {
            int _type = PR_FUNCAO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:179:14: ( 'funcao' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:179:16: 'funcao'
            {
                match("funcao");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "PR_FUNCAO"

    // $ANTLR start "PR_RETORNE"
    public final void mPR_RETORNE() throws RecognitionException
    {
        try
        {
            int _type = PR_RETORNE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:180:15: ( 'retorne' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:180:17: 'retorne'
            {
                match("retorne");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "PR_RETORNE"

    // $ANTLR start "PR_PARA"
    public final void mPR_PARA() throws RecognitionException
    {
        try
        {
            int _type = PR_PARA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:181:12: ( 'para' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:181:14: 'para'
            {
                match("para");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "PR_PARA"

    // $ANTLR start "PR_PARE"
    public final void mPR_PARE() throws RecognitionException
    {
        try
        {
            int _type = PR_PARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:182:12: ( 'pare' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:182:14: 'pare'
            {
                match("pare");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "PR_PARE"

    // $ANTLR start "PR_FACA"
    public final void mPR_FACA() throws RecognitionException
    {
        try
        {
            int _type = PR_FACA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:183:12: ( 'faca' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:183:14: 'faca'
            {
                match("faca");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "PR_FACA"

    // $ANTLR start "PR_ENQUANTO"
    public final void mPR_ENQUANTO() throws RecognitionException
    {
        try
        {
            int _type = PR_ENQUANTO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:184:15: ( 'enquanto' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:184:17: 'enquanto'
            {
                match("enquanto");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "PR_ENQUANTO"

    // $ANTLR start "PR_SE"
    public final void mPR_SE() throws RecognitionException
    {
        try
        {
            int _type = PR_SE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:185:10: ( 'se' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:185:12: 'se'
            {
                match("se");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "PR_SE"

    // $ANTLR start "PR_SENAO"
    public final void mPR_SENAO() throws RecognitionException
    {
        try
        {
            int _type = PR_SENAO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:186:13: ( 'senao' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:186:15: 'senao'
            {
                match("senao");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "PR_SENAO"

    // $ANTLR start "PR_INCLUA"
    public final void mPR_INCLUA() throws RecognitionException
    {
        try
        {
            int _type = PR_INCLUA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:187:14: ( 'inclua' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:187:16: 'inclua'
            {
                match("inclua");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "PR_INCLUA"

    // $ANTLR start "PR_BIBLIOTECA"
    public final void mPR_BIBLIOTECA() throws RecognitionException
    {
        try
        {
            int _type = PR_BIBLIOTECA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:188:17: ( 'biblioteca' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:188:19: 'biblioteca'
            {
                match("biblioteca");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "PR_BIBLIOTECA"

    // $ANTLR start "GAMBIARRA"
    public final void mGAMBIARRA() throws RecognitionException
    {
        try
        {
            int _type = GAMBIARRA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:191:12: ( '.' | 'á' | 'à' | 'ã' | 'â' | 'é' | 'ê' | 'í' | 'ó' | 'ô' | 'õ' | 'ú' | 'ü' | 'ç' | 'Á' | 'À' | 'Ã' | 'Â' | 'É' | 'Ê' | 'Í' | 'Ó' | 'Ô' | 'Õ' | 'Ú' | 'Ü' | 'Ç' | '#' | '$' | '\"' | '§' | '?' | '¹' | '²' | '³' | '£' | '¢' | '¬' | 'ª' | 'º' | '~' | '\\'' | '`' | '\\\\' | '@' )
            // D:\\Usuarios\\Luiz Fernando\\Documents\\Projetos\\Java\\Portugol\\Projetos\\Portugol-Nucleo\\src\\br\\univali\\portugol\\nucleo\\analise\\sintatica\\Portugol.g:
            {
                if ((input.LA(1) >= '\"' && input.LA(1) <= '$') || input.LA(1) == '\'' || input.LA(1) == '.' || (input.LA(1) >= '?' && input.LA(1) <= '@') || input.LA(1) == '\\' || input.LA(1) == '`' || input.LA(1) == '~' || (input.LA(1) >= '\u00A2' && input.LA(1) <= '\u00A3') || input.LA(1) == '\u00A7' || input.LA(1) == '\u00AA' || input.LA(1) == '\u00AC' || (input.LA(1) >= '\u00B2' && input.LA(1) <= '\u00B3') || (input.LA(1) >= '\u00B9' && input.LA(1) <= '\u00BA') || (input.LA(1) >= '\u00C0' && input.LA(1) <= '\u00C3') || input.LA(1) == '\u00C7' || (input.LA(1) >= '\u00C9' && input.LA(1) <= '\u00CA') || input.LA(1) == '\u00CD' || (input.LA(1) >= '\u00D3' && input.LA(1) <= '\u00D5') || input.LA(1) == '\u00DA' || input.LA(1) == '\u00DC' || (input.LA(1) >= '\u00E0' && input.LA(1) <= '\u00E3') || input.LA(1) == '\u00E7' || (input.LA(1) >= '\u00E9' && input.LA(1) <= '\u00EA') || input.LA(1) == '\u00ED' || (input.LA(1) >= '\u00F3' && input.LA(1) <= '\u00F5') || input.LA(1) == '\u00FA' || input.LA(1) == '\u00FC')
                {
                    input.consume();

                }
                else
                {
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    recover(mse);
                    throw mse;
                }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
        }
    }
    // $ANTLR end "GAMBIARRA"

    // $ANTLR start "PR_FALSO"
    public final void mPR_FALSO() throws RecognitionException
    {
        try
        {
            // C:\\Users\\Paula\\Desktop\\Portugol.g:193:21: ( 'falso' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:193:23: 'falso'
            {
                match("falso");

            }

        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "PR_FALSO"

    // $ANTLR start "PR_VERDADEIRO"
    public final void mPR_VERDADEIRO() throws RecognitionException
    {
        try
        {
            // C:\\Users\\Paula\\Desktop\\Portugol.g:194:25: ( 'verdadeiro' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:194:27: 'verdadeiro'
            {
                match("verdadeiro");

            }

        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "PR_VERDADEIRO"

    // $ANTLR start "OPERADOR_NAO"
    public final void mOPERADOR_NAO() throws RecognitionException
    {
        try
        {
            int _type = OPERADOR_NAO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:196:16: ( 'nao' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:196:18: 'nao'
            {
                match("nao");

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "OPERADOR_NAO"

    // $ANTLR start "LOGICO"
    public final void mLOGICO() throws RecognitionException
    {
        try
        {
            int _type = LOGICO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:198:11: ( PR_VERDADEIRO | PR_FALSO )
            int alt2 = 2;
            int LA2_0 = input.LA(1);
            if ((LA2_0 == 'v'))
            {
                alt2 = 1;
            }
            else
            {
                if ((LA2_0 == 'f'))
                {
                    alt2 = 2;
                }
                else
                {
                    NoViableAltException nvae =
                            new NoViableAltException("", 2, 0, input);
                    throw nvae;
                }
            }

            switch (alt2)
            {
                case 1:
                // C:\\Users\\Paula\\Desktop\\Portugol.g:198:14: PR_VERDADEIRO
                {
                    mPR_VERDADEIRO();

                }
                break;
                case 2:
                // C:\\Users\\Paula\\Desktop\\Portugol.g:198:30: PR_FALSO
                {
                    mPR_FALSO();

                }
                break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "LOGICO"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException
    {
        try
        {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:200:8: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:200:10: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
                if ((input.LA(1) >= 'A' && input.LA(1) <= 'Z') || input.LA(1) == '_' || (input.LA(1) >= 'a' && input.LA(1) <= 'z'))
                {
                    input.consume();
                }
                else
                {
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    recover(mse);
                    throw mse;
                }
                // C:\\Users\\Paula\\Desktop\\Portugol.g:200:34: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
                loop3:
                while (true)
                {
                    int alt3 = 2;
                    int LA3_0 = input.LA(1);
                    if (((LA3_0 >= '0' && LA3_0 <= '9') || (LA3_0 >= 'A' && LA3_0 <= 'Z') || LA3_0 == '_' || (LA3_0 >= 'a' && LA3_0 <= 'z')))
                    {
                        alt3 = 1;
                    }

                    switch (alt3)
                    {
                        case 1:
                        // C:\\Users\\Paula\\Desktop\\Portugol.g:
                        {
                            if ((input.LA(1) >= '0' && input.LA(1) <= '9') || (input.LA(1) >= 'A' && input.LA(1) <= 'Z') || input.LA(1) == '_' || (input.LA(1) >= 'a' && input.LA(1) <= 'z'))
                            {
                                input.consume();
                            }
                            else
                            {
                                MismatchedSetException mse = new MismatchedSetException(null, input);
                                recover(mse);
                                throw mse;
                            }
                        }
                        break;

                        default:
                            break loop3;
                    }
                }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "ID_BIBLIOTECA"
    public final void mID_BIBLIOTECA() throws RecognitionException
    {
        try
        {
            int _type = ID_BIBLIOTECA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:202:17: ( ID '.' ID )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:202:19: ID '.' ID
            {
                mID();

                match('.');
                mID();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "ID_BIBLIOTECA"

    // $ANTLR start "INTEIRO"
    public final void mINTEIRO() throws RecognitionException
    {
        try
        {
            int _type = INTEIRO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:204:13: ( ( '0' .. '9' )+ | ( '0x' | '0X' ) ( DIGIT_HEX )+ | ( '0b' | '0B' ) ( '0' | '1' )+ )
            int alt9 = 3;
            int LA9_0 = input.LA(1);
            if ((LA9_0 == '0'))
            {
                switch (input.LA(2))
                {
                    case 'X':
                    case 'x':
                    {
                        alt9 = 2;
                    }
                    break;
                    case 'B':
                    case 'b':
                    {
                        alt9 = 3;
                    }
                    break;
                    default:
                        alt9 = 1;
                }
            }
            else
            {
                if (((LA9_0 >= '1' && LA9_0 <= '9')))
                {
                    alt9 = 1;
                }
                else
                {
                    NoViableAltException nvae =
                            new NoViableAltException("", 9, 0, input);
                    throw nvae;
                }
            }

            switch (alt9)
            {
                case 1:
                // C:\\Users\\Paula\\Desktop\\Portugol.g:204:15: ( '0' .. '9' )+
                {
                    // C:\\Users\\Paula\\Desktop\\Portugol.g:204:15: ( '0' .. '9' )+
                    int cnt4 = 0;
                    loop4:
                    while (true)
                    {
                        int alt4 = 2;
                        int LA4_0 = input.LA(1);
                        if (((LA4_0 >= '0' && LA4_0 <= '9')))
                        {
                            alt4 = 1;
                        }

                        switch (alt4)
                        {
                            case 1:
                            // C:\\Users\\Paula\\Desktop\\Portugol.g:
                            {
                                if ((input.LA(1) >= '0' && input.LA(1) <= '9'))
                                {
                                    input.consume();
                                }
                                else
                                {
                                    MismatchedSetException mse = new MismatchedSetException(null, input);
                                    recover(mse);
                                    throw mse;
                                }
                            }
                            break;

                            default:
                                if (cnt4 >= 1)
                                {
                                    break loop4;
                                }
                                EarlyExitException eee = new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    }

                }
                break;
                case 2:
                // C:\\Users\\Paula\\Desktop\\Portugol.g:204:27: ( '0x' | '0X' ) ( DIGIT_HEX )+
                {
                    // C:\\Users\\Paula\\Desktop\\Portugol.g:204:27: ( '0x' | '0X' )
                    int alt5 = 2;
                    int LA5_0 = input.LA(1);
                    if ((LA5_0 == '0'))
                    {
                        int LA5_1 = input.LA(2);
                        if ((LA5_1 == 'x'))
                        {
                            alt5 = 1;
                        }
                        else
                        {
                            if ((LA5_1 == 'X'))
                            {
                                alt5 = 2;
                            }
                            else
                            {
                                int nvaeMark = input.mark();
                                try
                                {
                                    input.consume();
                                    NoViableAltException nvae =
                                            new NoViableAltException("", 5, 1, input);
                                    throw nvae;
                                }
                                finally
                                {
                                    input.rewind(nvaeMark);
                                }
                            }
                        }

                    }
                    else
                    {
                        NoViableAltException nvae =
                                new NoViableAltException("", 5, 0, input);
                        throw nvae;
                    }

                    switch (alt5)
                    {
                        case 1:
                        // C:\\Users\\Paula\\Desktop\\Portugol.g:204:28: '0x'
                        {
                            match("0x");

                        }
                        break;
                        case 2:
                        // C:\\Users\\Paula\\Desktop\\Portugol.g:204:33: '0X'
                        {
                            match("0X");

                        }
                        break;

                    }

                    // C:\\Users\\Paula\\Desktop\\Portugol.g:204:38: ( DIGIT_HEX )+
                    int cnt6 = 0;
                    loop6:
                    while (true)
                    {
                        int alt6 = 2;
                        int LA6_0 = input.LA(1);
                        if (((LA6_0 >= '0' && LA6_0 <= '9') || (LA6_0 >= 'A' && LA6_0 <= 'F') || (LA6_0 >= 'a' && LA6_0 <= 'f')))
                        {
                            alt6 = 1;
                        }

                        switch (alt6)
                        {
                            case 1:
                            // C:\\Users\\Paula\\Desktop\\Portugol.g:
                            {
                                if ((input.LA(1) >= '0' && input.LA(1) <= '9') || (input.LA(1) >= 'A' && input.LA(1) <= 'F') || (input.LA(1) >= 'a' && input.LA(1) <= 'f'))
                                {
                                    input.consume();
                                }
                                else
                                {
                                    MismatchedSetException mse = new MismatchedSetException(null, input);
                                    recover(mse);
                                    throw mse;
                                }
                            }
                            break;

                            default:
                                if (cnt6 >= 1)
                                {
                                    break loop6;
                                }
                                EarlyExitException eee = new EarlyExitException(6, input);
                                throw eee;
                        }
                        cnt6++;
                    }

                }
                break;
                case 3:
                // C:\\Users\\Paula\\Desktop\\Portugol.g:204:53: ( '0b' | '0B' ) ( '0' | '1' )+
                {
                    // C:\\Users\\Paula\\Desktop\\Portugol.g:204:53: ( '0b' | '0B' )
                    int alt7 = 2;
                    int LA7_0 = input.LA(1);
                    if ((LA7_0 == '0'))
                    {
                        int LA7_1 = input.LA(2);
                        if ((LA7_1 == 'b'))
                        {
                            alt7 = 1;
                        }
                        else
                        {
                            if ((LA7_1 == 'B'))
                            {
                                alt7 = 2;
                            }
                            else
                            {
                                int nvaeMark = input.mark();
                                try
                                {
                                    input.consume();
                                    NoViableAltException nvae =
                                            new NoViableAltException("", 7, 1, input);
                                    throw nvae;
                                }
                                finally
                                {
                                    input.rewind(nvaeMark);
                                }
                            }
                        }

                    }
                    else
                    {
                        NoViableAltException nvae =
                                new NoViableAltException("", 7, 0, input);
                        throw nvae;
                    }

                    switch (alt7)
                    {
                        case 1:
                        // C:\\Users\\Paula\\Desktop\\Portugol.g:204:54: '0b'
                        {
                            match("0b");

                        }
                        break;
                        case 2:
                        // C:\\Users\\Paula\\Desktop\\Portugol.g:204:59: '0B'
                        {
                            match("0B");

                        }
                        break;

                    }

                    // C:\\Users\\Paula\\Desktop\\Portugol.g:204:64: ( '0' | '1' )+
                    int cnt8 = 0;
                    loop8:
                    while (true)
                    {
                        int alt8 = 2;
                        int LA8_0 = input.LA(1);
                        if (((LA8_0 >= '0' && LA8_0 <= '1')))
                        {
                            alt8 = 1;
                        }

                        switch (alt8)
                        {
                            case 1:
                            // C:\\Users\\Paula\\Desktop\\Portugol.g:
                            {
                                if ((input.LA(1) >= '0' && input.LA(1) <= '1'))
                                {
                                    input.consume();
                                }
                                else
                                {
                                    MismatchedSetException mse = new MismatchedSetException(null, input);
                                    recover(mse);
                                    throw mse;
                                }
                            }
                            break;

                            default:
                                if (cnt8 >= 1)
                                {
                                    break loop8;
                                }
                                EarlyExitException eee = new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    }

                }
                break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "INTEIRO"

    // $ANTLR start "REAL"
    public final void mREAL() throws RecognitionException
    {
        try
        {
            int _type = REAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:206:10: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )+ )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:206:13: ( '0' .. '9' )+ '.' ( '0' .. '9' )+
            {
                // C:\\Users\\Paula\\Desktop\\Portugol.g:206:13: ( '0' .. '9' )+
                int cnt10 = 0;
                loop10:
                while (true)
                {
                    int alt10 = 2;
                    int LA10_0 = input.LA(1);
                    if (((LA10_0 >= '0' && LA10_0 <= '9')))
                    {
                        alt10 = 1;
                    }

                    switch (alt10)
                    {
                        case 1:
                        // C:\\Users\\Paula\\Desktop\\Portugol.g:
                        {
                            if ((input.LA(1) >= '0' && input.LA(1) <= '9'))
                            {
                                input.consume();
                            }
                            else
                            {
                                MismatchedSetException mse = new MismatchedSetException(null, input);
                                recover(mse);
                                throw mse;
                            }
                        }
                        break;

                        default:
                            if (cnt10 >= 1)
                            {
                                break loop10;
                            }
                            EarlyExitException eee = new EarlyExitException(10, input);
                            throw eee;
                    }
                    cnt10++;
                }

                match('.');
                // C:\\Users\\Paula\\Desktop\\Portugol.g:206:29: ( '0' .. '9' )+
                int cnt11 = 0;
                loop11:
                while (true)
                {
                    int alt11 = 2;
                    int LA11_0 = input.LA(1);
                    if (((LA11_0 >= '0' && LA11_0 <= '9')))
                    {
                        alt11 = 1;
                    }

                    switch (alt11)
                    {
                        case 1:
                        // C:\\Users\\Paula\\Desktop\\Portugol.g:
                        {
                            if ((input.LA(1) >= '0' && input.LA(1) <= '9'))
                            {
                                input.consume();
                            }
                            else
                            {
                                MismatchedSetException mse = new MismatchedSetException(null, input);
                                recover(mse);
                                throw mse;
                            }
                        }
                        break;

                        default:
                            if (cnt11 >= 1)
                            {
                                break loop11;
                            }
                            EarlyExitException eee = new EarlyExitException(11, input);
                            throw eee;
                    }
                    cnt11++;
                }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "REAL"

    // $ANTLR start "CADEIA"
    public final void mCADEIA() throws RecognitionException
    {
        try
        {
            int _type = CADEIA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:208:11: ( '\"' ( SEQ_ESC |~ ( '\\\\' | '\"' ) )* '\"' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:208:13: '\"' ( SEQ_ESC |~ ( '\\\\' | '\"' ) )* '\"'
            {
                match('\"');
                // C:\\Users\\Paula\\Desktop\\Portugol.g:208:17: ( SEQ_ESC |~ ( '\\\\' | '\"' ) )*
                loop12:
                while (true)
                {
                    int alt12 = 3;
                    int LA12_0 = input.LA(1);
                    if ((LA12_0 == '\\'))
                    {
                        alt12 = 1;
                    }
                    else
                    {
                        if (((LA12_0 >= '\u0000' && LA12_0 <= '!') || (LA12_0 >= '#' && LA12_0 <= '[') || (LA12_0 >= ']' && LA12_0 <= '\uFFFF')))
                        {
                            alt12 = 2;
                        }
                    }

                    switch (alt12)
                    {
                        case 1:
                        // C:\\Users\\Paula\\Desktop\\Portugol.g:208:19: SEQ_ESC
                        {
                            mSEQ_ESC();

                        }
                        break;
                        case 2:
                        // C:\\Users\\Paula\\Desktop\\Portugol.g:208:29: ~ ( '\\\\' | '\"' )
                        {
                            if ((input.LA(1) >= '\u0000' && input.LA(1) <= '!') || (input.LA(1) >= '#' && input.LA(1) <= '[') || (input.LA(1) >= ']' && input.LA(1) <= '\uFFFF'))
                            {
                                input.consume();
                            }
                            else
                            {
                                MismatchedSetException mse = new MismatchedSetException(null, input);
                                recover(mse);
                                throw mse;
                            }
                        }
                        break;

                        default:
                            break loop12;
                    }
                }

                match('\"');
            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "CADEIA"

    // $ANTLR start "CARACTER"
    public final void mCARACTER() throws RecognitionException
    {
        try
        {
            int _type = CARACTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:210:13: ( '\\'' ( SEQ_ESC |~ ( '\\'' | '\\\\' ) ) '\\'' )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:210:17: '\\'' ( SEQ_ESC |~ ( '\\'' | '\\\\' ) ) '\\''
            {
                match('\'');
                // C:\\Users\\Paula\\Desktop\\Portugol.g:210:22: ( SEQ_ESC |~ ( '\\'' | '\\\\' ) )
                int alt13 = 2;
                int LA13_0 = input.LA(1);
                if ((LA13_0 == '\\'))
                {
                    alt13 = 1;
                }
                else
                {
                    if (((LA13_0 >= '\u0000' && LA13_0 <= '&') || (LA13_0 >= '(' && LA13_0 <= '[') || (LA13_0 >= ']' && LA13_0 <= '\uFFFF')))
                    {
                        alt13 = 2;
                    }
                    else
                    {
                        NoViableAltException nvae =
                                new NoViableAltException("", 13, 0, input);
                        throw nvae;
                    }
                }

                switch (alt13)
                {
                    case 1:
                    // C:\\Users\\Paula\\Desktop\\Portugol.g:210:24: SEQ_ESC
                    {
                        mSEQ_ESC();

                    }
                    break;
                    case 2:
                    // C:\\Users\\Paula\\Desktop\\Portugol.g:210:34: ~ ( '\\'' | '\\\\' )
                    {
                        if ((input.LA(1) >= '\u0000' && input.LA(1) <= '&') || (input.LA(1) >= '(' && input.LA(1) <= '[') || (input.LA(1) >= ']' && input.LA(1) <= '\uFFFF'))
                        {
                            input.consume();
                        }
                        else
                        {
                            MismatchedSetException mse = new MismatchedSetException(null, input);
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
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "CARACTER"

    // $ANTLR start "ESPACO"
    public final void mESPACO() throws RecognitionException
    {
        try
        {
            int _type = ESPACO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:212:11: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:212:13: ( ' ' | '\\t' | '\\r' | '\\n' )
            {
                if ((input.LA(1) >= '\t' && input.LA(1) <= '\n') || input.LA(1) == '\r' || input.LA(1) == ' ')
                {
                    input.consume();
                }
                else
                {
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    recover(mse);
                    throw mse;
                }
                _channel = HIDDEN;
            }

            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "ESPACO"

    // $ANTLR start "DIGIT_HEX"
    public final void mDIGIT_HEX() throws RecognitionException
    {
        try
        {
            // C:\\Users\\Paula\\Desktop\\Portugol.g:215:22: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:
            {
                if ((input.LA(1) >= '0' && input.LA(1) <= '9') || (input.LA(1) >= 'A' && input.LA(1) <= 'F') || (input.LA(1) >= 'a' && input.LA(1) <= 'f'))
                {
                    input.consume();
                }
                else
                {
                    MismatchedSetException mse = new MismatchedSetException(null, input);
                    recover(mse);
                    throw mse;
                }
            }

        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "DIGIT_HEX"

    // $ANTLR start "SEQ_ESC"
    public final void mSEQ_ESC() throws RecognitionException
    {
        try
        {
            // C:\\Users\\Paula\\Desktop\\Portugol.g:217:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ESC_UNICODE | ESC_OCTAL )
            int alt14 = 3;
            int LA14_0 = input.LA(1);
            if ((LA14_0 == '\\'))
            {
                switch (input.LA(2))
                {
                    case '\"':
                    case '\'':
                    case '\\':
                    case 'b':
                    case 'f':
                    case 'n':
                    case 'r':
                    case 't':
                    {
                        alt14 = 1;
                    }
                    break;
                    case 'u':
                    {
                        alt14 = 2;
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
                        alt14 = 3;
                    }
                    break;
                    default:
                        int nvaeMark = input.mark();
                        try
                        {
                            input.consume();
                            NoViableAltException nvae =
                                    new NoViableAltException("", 14, 1, input);
                            throw nvae;
                        }
                        finally
                        {
                            input.rewind(nvaeMark);
                        }
                }
            }
            else
            {
                NoViableAltException nvae =
                        new NoViableAltException("", 14, 0, input);
                throw nvae;
            }

            switch (alt14)
            {
                case 1:
                // C:\\Users\\Paula\\Desktop\\Portugol.g:217:23: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                {
                    match('\\');
                    if (input.LA(1) == '\"' || input.LA(1) == '\'' || input.LA(1) == '\\' || input.LA(1) == 'b' || input.LA(1) == 'f' || input.LA(1) == 'n' || input.LA(1) == 'r' || input.LA(1) == 't')
                    {
                        input.consume();
                    }
                    else
                    {
                        MismatchedSetException mse = new MismatchedSetException(null, input);
                        recover(mse);
                        throw mse;
                    }
                }
                break;
                case 2:
                // C:\\Users\\Paula\\Desktop\\Portugol.g:217:70: ESC_UNICODE
                {
                    mESC_UNICODE();

                }
                break;
                case 3:
                // C:\\Users\\Paula\\Desktop\\Portugol.g:217:87: ESC_OCTAL
                {
                    mESC_OCTAL();

                }
                break;

            }
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "SEQ_ESC"

    // $ANTLR start "ESC_OCTAL"
    public final void mESC_OCTAL() throws RecognitionException
    {
        try
        {
            // C:\\Users\\Paula\\Desktop\\Portugol.g:219:21: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt15 = 3;
            int LA15_0 = input.LA(1);
            if ((LA15_0 == '\\'))
            {
                int LA15_1 = input.LA(2);
                if (((LA15_1 >= '0' && LA15_1 <= '3')))
                {
                    int LA15_2 = input.LA(3);
                    if (((LA15_2 >= '0' && LA15_2 <= '7')))
                    {
                        int LA15_4 = input.LA(4);
                        if (((LA15_4 >= '0' && LA15_4 <= '7')))
                        {
                            alt15 = 1;
                        }
                        else
                        {
                            alt15 = 2;
                        }

                    }
                    else
                    {
                        alt15 = 3;
                    }

                }
                else
                {
                    if (((LA15_1 >= '4' && LA15_1 <= '7')))
                    {
                        int LA15_3 = input.LA(3);
                        if (((LA15_3 >= '0' && LA15_3 <= '7')))
                        {
                            alt15 = 2;
                        }
                        else
                        {
                            alt15 = 3;
                        }

                    }
                    else
                    {
                        int nvaeMark = input.mark();
                        try
                        {
                            input.consume();
                            NoViableAltException nvae =
                                    new NoViableAltException("", 15, 1, input);
                            throw nvae;
                        }
                        finally
                        {
                            input.rewind(nvaeMark);
                        }
                    }
                }

            }
            else
            {
                NoViableAltException nvae =
                        new NoViableAltException("", 15, 0, input);
                throw nvae;
            }

            switch (alt15)
            {
                case 1:
                // C:\\Users\\Paula\\Desktop\\Portugol.g:219:23: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                {
                    match('\\');
                    if ((input.LA(1) >= '0' && input.LA(1) <= '3'))
                    {
                        input.consume();
                    }
                    else
                    {
                        MismatchedSetException mse = new MismatchedSetException(null, input);
                        recover(mse);
                        throw mse;
                    }
                    if ((input.LA(1) >= '0' && input.LA(1) <= '7'))
                    {
                        input.consume();
                    }
                    else
                    {
                        MismatchedSetException mse = new MismatchedSetException(null, input);
                        recover(mse);
                        throw mse;
                    }
                    if ((input.LA(1) >= '0' && input.LA(1) <= '7'))
                    {
                        input.consume();
                    }
                    else
                    {
                        MismatchedSetException mse = new MismatchedSetException(null, input);
                        recover(mse);
                        throw mse;
                    }
                }
                break;
                case 2:
                // C:\\Users\\Paula\\Desktop\\Portugol.g:219:66: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                {
                    match('\\');
                    if ((input.LA(1) >= '0' && input.LA(1) <= '7'))
                    {
                        input.consume();
                    }
                    else
                    {
                        MismatchedSetException mse = new MismatchedSetException(null, input);
                        recover(mse);
                        throw mse;
                    }
                    if ((input.LA(1) >= '0' && input.LA(1) <= '7'))
                    {
                        input.consume();
                    }
                    else
                    {
                        MismatchedSetException mse = new MismatchedSetException(null, input);
                        recover(mse);
                        throw mse;
                    }
                }
                break;
                case 3:
                // C:\\Users\\Paula\\Desktop\\Portugol.g:219:100: '\\\\' ( '0' .. '7' )
                {
                    match('\\');
                    if ((input.LA(1) >= '0' && input.LA(1) <= '7'))
                    {
                        input.consume();
                    }
                    else
                    {
                        MismatchedSetException mse = new MismatchedSetException(null, input);
                        recover(mse);
                        throw mse;
                    }
                }
                break;

            }
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "ESC_OCTAL"

    // $ANTLR start "ESC_UNICODE"
    public final void mESC_UNICODE() throws RecognitionException
    {
        try
        {
            // C:\\Users\\Paula\\Desktop\\Portugol.g:221:23: ( '\\\\' 'u' DIGIT_HEX DIGIT_HEX DIGIT_HEX DIGIT_HEX )
            // C:\\Users\\Paula\\Desktop\\Portugol.g:221:25: '\\\\' 'u' DIGIT_HEX DIGIT_HEX DIGIT_HEX DIGIT_HEX
            {
                match('\\');
                match('u');
                mDIGIT_HEX();

                mDIGIT_HEX();

                mDIGIT_HEX();

                mDIGIT_HEX();

            }

        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "ESC_UNICODE"

    // $ANTLR start "COMENTARIO"
    public final void mCOMENTARIO() throws RecognitionException
    {
        try
        {
            int _type = COMENTARIO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Paula\\Desktop\\Portugol.g:223:14: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
            int alt19 = 2;
            int LA19_0 = input.LA(1);
            if ((LA19_0 == '/'))
            {
                int LA19_1 = input.LA(2);
                if ((LA19_1 == '/'))
                {
                    alt19 = 1;
                }
                else
                {
                    if ((LA19_1 == '*'))
                    {
                        alt19 = 2;
                    }
                    else
                    {
                        int nvaeMark = input.mark();
                        try
                        {
                            input.consume();
                            NoViableAltException nvae =
                                    new NoViableAltException("", 19, 1, input);
                            throw nvae;
                        }
                        finally
                        {
                            input.rewind(nvaeMark);
                        }
                    }
                }

            }
            else
            {
                NoViableAltException nvae =
                        new NoViableAltException("", 19, 0, input);
                throw nvae;
            }

            switch (alt19)
            {
                case 1:
                // C:\\Users\\Paula\\Desktop\\Portugol.g:225:2: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
                {
                    match("//");

                    // C:\\Users\\Paula\\Desktop\\Portugol.g:225:7: (~ ( '\\n' | '\\r' ) )*
                    loop16:
                    while (true)
                    {
                        int alt16 = 2;
                        int LA16_0 = input.LA(1);
                        if (((LA16_0 >= '\u0000' && LA16_0 <= '\t') || (LA16_0 >= '\u000B' && LA16_0 <= '\f') || (LA16_0 >= '\u000E' && LA16_0 <= '\uFFFF')))
                        {
                            alt16 = 1;
                        }

                        switch (alt16)
                        {
                            case 1:
                            // C:\\Users\\Paula\\Desktop\\Portugol.g:
                            {
                                if ((input.LA(1) >= '\u0000' && input.LA(1) <= '\t') || (input.LA(1) >= '\u000B' && input.LA(1) <= '\f') || (input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF'))
                                {
                                    input.consume();
                                }
                                else
                                {
                                    MismatchedSetException mse = new MismatchedSetException(null, input);
                                    recover(mse);
                                    throw mse;
                                }
                            }
                            break;

                            default:
                                break loop16;
                        }
                    }

                    // C:\\Users\\Paula\\Desktop\\Portugol.g:225:21: ( '\\r' )?
                    int alt17 = 2;
                    int LA17_0 = input.LA(1);
                    if ((LA17_0 == '\r'))
                    {
                        alt17 = 1;
                    }
                    switch (alt17)
                    {
                        case 1:
                        // C:\\Users\\Paula\\Desktop\\Portugol.g:225:21: '\\r'
                        {
                            match('\r');
                        }
                        break;

                    }

                    match('\n');
                    _channel = HIDDEN;
                }
                break;
                case 2:
                // C:\\Users\\Paula\\Desktop\\Portugol.g:227:3: '/*' ( options {greedy=false; } : . )* '*/'
                {
                    match("/*");

                    // C:\\Users\\Paula\\Desktop\\Portugol.g:227:8: ( options {greedy=false; } : . )*
                    loop18:
                    while (true)
                    {
                        int alt18 = 2;
                        int LA18_0 = input.LA(1);
                        if ((LA18_0 == '*'))
                        {
                            int LA18_1 = input.LA(2);
                            if ((LA18_1 == '/'))
                            {
                                alt18 = 2;
                            }
                            else
                            {
                                if (((LA18_1 >= '\u0000' && LA18_1 <= '.') || (LA18_1 >= '0' && LA18_1 <= '\uFFFF')))
                                {
                                    alt18 = 1;
                                }
                            }

                        }
                        else
                        {
                            if (((LA18_0 >= '\u0000' && LA18_0 <= ')') || (LA18_0 >= '+' && LA18_0 <= '\uFFFF')))
                            {
                                alt18 = 1;
                            }
                        }

                        switch (alt18)
                        {
                            case 1:
                            // C:\\Users\\Paula\\Desktop\\Portugol.g:227:36: .
                            {
                                matchAny();
                            }
                            break;

                            default:
                                break loop18;
                        }
                    }

                    match("*/");

                    _channel = HIDDEN;
                }
                break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally
        {
            // do for sure before leaving
        }
    }
    // $ANTLR end "COMENTARIO"

    @Override
    public void mTokens() throws RecognitionException
    {
        // C:\\Users\\Paula\\Desktop\\Portugol.g:1:8: ( T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | PR_PROGRAMA | PR_REAL | PR_VAZIO | PR_LOGICO | PR_CADEIA | PR_INTEIRO | PR_CARACTER | PR_ESCOLHA | PR_CASO | PR_CONTRARIO | PR_CONST | PR_FUNCAO | PR_RETORNE | PR_PARA | PR_PARE | PR_FACA | PR_ENQUANTO | PR_SE | PR_SENAO | PR_INCLUA | PR_BIBLIOTECA | GAMBIARRA | OPERADOR_NAO | LOGICO | ID | ID_BIBLIOTECA | INTEIRO | REAL | CADEIA | CARACTER | ESPACO | COMENTARIO )
        int alt20 = 74;
        alt20 = dfa20.predict(input);
        switch (alt20)
        {
            case 1:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:10: T__42
            {
                mT__42();

            }
            break;
            case 2:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:16: T__43
            {
                mT__43();

            }
            break;
            case 3:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:22: T__44
            {
                mT__44();

            }
            break;
            case 4:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:28: T__45
            {
                mT__45();

            }
            break;
            case 5:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:34: T__46
            {
                mT__46();

            }
            break;
            case 6:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:40: T__47
            {
                mT__47();

            }
            break;
            case 7:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:46: T__48
            {
                mT__48();

            }
            break;
            case 8:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:52: T__49
            {
                mT__49();

            }
            break;
            case 9:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:58: T__50
            {
                mT__50();

            }
            break;
            case 10:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:64: T__51
            {
                mT__51();

            }
            break;
            case 11:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:70: T__52
            {
                mT__52();

            }
            break;
            case 12:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:76: T__53
            {
                mT__53();

            }
            break;
            case 13:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:82: T__54
            {
                mT__54();

            }
            break;
            case 14:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:88: T__55
            {
                mT__55();

            }
            break;
            case 15:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:94: T__56
            {
                mT__56();

            }
            break;
            case 16:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:100: T__57
            {
                mT__57();

            }
            break;
            case 17:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:106: T__58
            {
                mT__58();

            }
            break;
            case 18:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:112: T__59
            {
                mT__59();

            }
            break;
            case 19:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:118: T__60
            {
                mT__60();

            }
            break;
            case 20:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:124: T__61
            {
                mT__61();

            }
            break;
            case 21:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:130: T__62
            {
                mT__62();

            }
            break;
            case 22:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:136: T__63
            {
                mT__63();

            }
            break;
            case 23:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:142: T__64
            {
                mT__64();

            }
            break;
            case 24:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:148: T__65
            {
                mT__65();

            }
            break;
            case 25:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:154: T__66
            {
                mT__66();

            }
            break;
            case 26:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:160: T__67
            {
                mT__67();

            }
            break;
            case 27:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:166: T__68
            {
                mT__68();

            }
            break;
            case 28:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:172: T__69
            {
                mT__69();

            }
            break;
            case 29:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:178: T__70
            {
                mT__70();

            }
            break;
            case 30:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:184: T__71
            {
                mT__71();

            }
            break;
            case 31:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:190: T__72
            {
                mT__72();

            }
            break;
            case 32:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:196: T__73
            {
                mT__73();

            }
            break;
            case 33:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:202: T__74
            {
                mT__74();

            }
            break;
            case 34:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:208: T__75
            {
                mT__75();

            }
            break;
            case 35:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:214: T__76
            {
                mT__76();

            }
            break;
            case 36:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:220: T__77
            {
                mT__77();

            }
            break;
            case 37:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:226: T__78
            {
                mT__78();

            }
            break;
            case 38:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:232: T__79
            {
                mT__79();

            }
            break;
            case 39:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:238: T__80
            {
                mT__80();

            }
            break;
            case 40:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:244: T__81
            {
                mT__81();

            }
            break;
            case 41:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:250: T__82
            {
                mT__82();

            }
            break;
            case 42:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:256: T__83
            {
                mT__83();

            }
            break;
            case 43:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:262: PR_PROGRAMA
            {
                mPR_PROGRAMA();

            }
            break;
            case 44:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:274: PR_REAL
            {
                mPR_REAL();

            }
            break;
            case 45:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:282: PR_VAZIO
            {
                mPR_VAZIO();

            }
            break;
            case 46:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:291: PR_LOGICO
            {
                mPR_LOGICO();

            }
            break;
            case 47:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:301: PR_CADEIA
            {
                mPR_CADEIA();

            }
            break;
            case 48:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:311: PR_INTEIRO
            {
                mPR_INTEIRO();

            }
            break;
            case 49:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:322: PR_CARACTER
            {
                mPR_CARACTER();

            }
            break;
            case 50:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:334: PR_ESCOLHA
            {
                mPR_ESCOLHA();

            }
            break;
            case 51:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:345: PR_CASO
            {
                mPR_CASO();

            }
            break;
            case 52:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:353: PR_CONTRARIO
            {
                mPR_CONTRARIO();

            }
            break;
            case 53:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:366: PR_CONST
            {
                mPR_CONST();

            }
            break;
            case 54:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:375: PR_FUNCAO
            {
                mPR_FUNCAO();

            }
            break;
            case 55:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:385: PR_RETORNE
            {
                mPR_RETORNE();

            }
            break;
            case 56:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:396: PR_PARA
            {
                mPR_PARA();

            }
            break;
            case 57:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:404: PR_PARE
            {
                mPR_PARE();

            }
            break;
            case 58:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:412: PR_FACA
            {
                mPR_FACA();

            }
            break;
            case 59:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:420: PR_ENQUANTO
            {
                mPR_ENQUANTO();

            }
            break;
            case 60:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:432: PR_SE
            {
                mPR_SE();

            }
            break;
            case 61:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:438: PR_SENAO
            {
                mPR_SENAO();

            }
            break;
            case 62:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:447: PR_INCLUA
            {
                mPR_INCLUA();

            }
            break;
            case 63:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:457: PR_BIBLIOTECA
            {
                mPR_BIBLIOTECA();

            }
            break;
            case 64:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:471: GAMBIARRA
            {
                mGAMBIARRA();

            }
            break;
            case 65:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:481: OPERADOR_NAO
            {
                mOPERADOR_NAO();

            }
            break;
            case 66:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:494: LOGICO
            {
                mLOGICO();

            }
            break;
            case 67:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:501: ID
            {
                mID();

            }
            break;
            case 68:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:504: ID_BIBLIOTECA
            {
                mID_BIBLIOTECA();

            }
            break;
            case 69:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:518: INTEIRO
            {
                mINTEIRO();

            }
            break;
            case 70:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:526: REAL
            {
                mREAL();

            }
            break;
            case 71:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:531: CADEIA
            {
                mCADEIA();

            }
            break;
            case 72:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:538: CARACTER
            {
                mCARACTER();

            }
            break;
            case 73:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:547: ESPACO
            {
                mESPACO();

            }
            break;
            case 74:
            // C:\\Users\\Paula\\Desktop\\Portugol.g:1:554: COMENTARIO
            {
                mCOMENTARIO();

            }
            break;

        }
    }
    protected DFA20 dfa20 = new DFA20(this);
    static final String DFA20_eotS =
            "\2\uffff\1\53\1\55\2\uffff\1\57\1\62\1\uffff\1\65\1\70\2\uffff\1\73\1"
            + "\75\1\100\2\uffff\1\102\1\105\1\111\1\uffff\1\113\2\uffff\11\111\1\uffff"
            + "\2\42\2\111\2\135\12\uffff\1\140\5\uffff\1\142\5\uffff\1\144\3\uffff\2"
            + "\111\1\uffff\1\111\1\uffff\1\147\4\uffff\13\111\1\171\1\111\2\uffff\1"
            + "\111\10\uffff\2\111\1\uffff\21\111\1\uffff\1\111\1\u0092\3\111\1\u0096"
            + "\1\u0097\1\u0098\6\111\1\u009f\5\111\1\u00a5\3\111\1\uffff\3\111\3\uffff"
            + "\1\111\1\u00ad\4\111\1\uffff\1\111\1\u00b3\3\111\1\uffff\1\u00b7\1\u00b8"
            + "\5\111\1\uffff\1\111\1\u00bf\1\u00c0\2\111\1\uffff\1\111\1\u00c4\1\u00c5"
            + "\2\uffff\1\111\1\u00c7\2\111\1\u00ca\1\111\2\uffff\2\111\1\u00ce\2\uffff"
            + "\1\111\1\uffff\1\u00d0\1\u00d1\1\uffff\1\111\1\u00d3\1\111\1\uffff\1\111"
            + "\2\uffff\1\111\1\uffff\1\u00d7\1\111\1\u00b7\1\uffff\1\u00d9\1\uffff";
    static final String DFA20_eofS =
            "\u00da\uffff";
    static final String DFA20_minS =
            "\1\11\1\uffff\2\75\2\uffff\1\75\1\53\1\uffff\1\55\1\52\2\uffff\1\74\2"
            + "\75\2\uffff\1\75\2\56\1\uffff\1\75\2\uffff\11\56\1\uffff\2\0\4\56\12\uffff"
            + "\1\76\5\uffff\1\75\5\uffff\1\75\3\uffff\2\56\1\uffff\1\56\1\uffff\1\56"
            + "\4\uffff\15\56\2\uffff\1\56\10\uffff\2\56\1\uffff\21\56\1\uffff\30\56"
            + "\1\uffff\3\56\3\uffff\6\56\1\uffff\5\56\1\uffff\7\56\1\uffff\5\56\1\uffff"
            + "\3\56\2\uffff\6\56\2\uffff\3\56\2\uffff\1\56\1\uffff\2\56\1\uffff\3\56"
            + "\1\uffff\1\56\2\uffff\1\56\1\uffff\3\56\1\uffff\1\56\1\uffff";
    static final String DFA20_maxS =
            "\1\u00c3\1\uffff\2\75\2\uffff\2\75\1\uffff\2\75\2\uffff\2\75\1\76\2\uffff"
            + "\1\75\2\172\1\uffff\1\75\2\uffff\11\172\1\uffff\2\uffff\2\172\2\71\12"
            + "\uffff\1\76\5\uffff\1\75\5\uffff\1\75\3\uffff\2\172\1\uffff\1\172\1\uffff"
            + "\1\172\4\uffff\15\172\2\uffff\1\172\10\uffff\2\172\1\uffff\21\172\1\uffff"
            + "\30\172\1\uffff\3\172\3\uffff\6\172\1\uffff\5\172\1\uffff\7\172\1\uffff"
            + "\5\172\1\uffff\3\172\2\uffff\6\172\2\uffff\3\172\2\uffff\1\172\1\uffff"
            + "\2\172\1\uffff\3\172\1\uffff\1\172\2\uffff\1\172\1\uffff\3\172\1\uffff"
            + "\1\172\1\uffff";
    static final String DFA20_acceptS =
            "\1\uffff\1\1\2\uffff\1\6\1\7\2\uffff\1\15\2\uffff\1\24\1\25\3\uffff\1"
            + "\40\1\41\3\uffff\1\46\1\uffff\1\51\1\52\11\uffff\1\100\6\uffff\1\111\1"
            + "\3\1\2\1\5\1\4\1\11\1\10\1\13\1\14\1\12\1\uffff\1\21\1\16\1\23\1\112\1"
            + "\22\1\uffff\1\31\1\26\1\33\1\32\1\35\1\uffff\1\34\1\43\1\42\2\uffff\1"
            + "\44\1\uffff\1\104\1\uffff\1\103\1\50\1\47\1\52\15\uffff\1\107\1\110\1"
            + "\uffff\1\105\1\106\1\20\1\17\1\30\1\27\1\37\1\36\2\uffff\1\45\21\uffff"
            + "\1\74\30\uffff\1\101\3\uffff\1\70\1\71\1\54\6\uffff\1\63\5\uffff\1\72"
            + "\7\uffff\1\55\5\uffff\1\65\3\uffff\1\102\1\75\6\uffff\1\56\1\57\3\uffff"
            + "\1\76\1\66\1\uffff\1\62\2\uffff\1\67\3\uffff\1\60\1\uffff\1\73\1\53\1"
            + "\uffff\1\61\3\uffff\1\64\1\uffff\1\77";
    static final String DFA20_specialS =
            "\43\uffff\1\0\1\1\u00b5\uffff}>";
    static final String[] DFA20_transitionS =
    {
        "\2\51\2\uffff\1\51\22\uffff\1\51\1\1\1\43\2\42\1\2\1\3\1\44\1\4\1\5\1"
        + "\6\1\7\1\10\1\11\1\42\1\12\1\47\11\50\1\13\1\14\1\15\1\16\1\17\2\42\32"
        + "\46\1\20\1\42\1\21\1\22\1\46\1\42\1\46\1\41\1\35\1\46\1\23\1\37\2\46"
        + "\1\36\2\46\1\34\1\46\1\45\1\24\1\31\1\46\1\32\1\40\2\46\1\33\4\46\1\25"
        + "\1\26\1\27\1\30\103\uffff\2\42",
        "",
        "\1\52",
        "\1\54",
        "",
        "",
        "\1\56",
        "\1\60\21\uffff\1\61",
        "",
        "\1\63\17\uffff\1\64",
        "\1\67\4\uffff\1\67\15\uffff\1\66",
        "",
        "",
        "\1\71\1\72",
        "\1\74",
        "\1\76\1\77",
        "",
        "",
        "\1\101",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\15\106\1"
        + "\104\4\106\1\103\7\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\24\106\1"
        + "\110\5\106",
        "",
        "\1\112",
        "",
        "",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\1\116\20"
        + "\106\1\115\10\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\4\106\1\117"
        + "\25\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\1\120\3\106"
        + "\1\121\25\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\16\106\1"
        + "\122\13\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\1\123\15"
        + "\106\1\124\13\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\15\106\1"
        + "\125\14\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\1\127\23"
        + "\106\1\126\5\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\4\106\1\130"
        + "\25\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\10\106\1"
        + "\131\21\106",
        "",
        "\0\132",
        "\47\133\1\uffff\uffd8\133",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\1\134\31"
        + "\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\32\106",
        "\1\136\1\uffff\12\50",
        "\1\136\1\uffff\12\50",
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
        "\1\137",
        "",
        "",
        "",
        "",
        "",
        "\1\141",
        "",
        "",
        "",
        "",
        "",
        "\1\143",
        "",
        "",
        "",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\2\106\1\145"
        + "\27\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\20\106\1"
        + "\146\11\106",
        "",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\32\106",
        "",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\32\106",
        "",
        "",
        "",
        "",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\16\106\1"
        + "\150\13\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\21\106\1"
        + "\151\10\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\1\152\22"
        + "\106\1\153\6\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\31\106\1"
        + "\154",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\21\106\1"
        + "\155\10\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\6\106\1\156"
        + "\23\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\3\106\1\157"
        + "\15\106\1\160\1\161\7\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\15\106\1"
        + "\162\14\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\2\106\1\164"
        + "\20\106\1\163\6\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\15\106\1"
        + "\165\14\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\2\106\1\166"
        + "\10\106\1\167\16\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\15\106\1"
        + "\170\14\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\1\106\1\172"
        + "\30\106",
        "",
        "",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\16\106\1"
        + "\173\13\106",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\16\106\1"
        + "\174\13\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\24\106\1"
        + "\175\5\106",
        "",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\6\106\1\176"
        + "\23\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\1\177\3\106"
        + "\1\u0080\25\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\13\106\1"
        + "\u0081\16\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\16\106\1"
        + "\u0082\13\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\10\106\1"
        + "\u0083\21\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\3\106\1\u0084"
        + "\26\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\10\106\1"
        + "\u0085\21\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\4\106\1\u0086"
        + "\25\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\1\u0087\31"
        + "\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\16\106\1"
        + "\u0088\13\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\22\106\1"
        + "\u008a\1\u0089\6\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\4\106\1\u008b"
        + "\25\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\13\106\1"
        + "\u008c\16\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\2\106\1\u008d"
        + "\27\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\1\u008e\31"
        + "\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\22\106\1"
        + "\u008f\7\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\1\u0090\31"
        + "\106",
        "",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\13\106\1"
        + "\u0091\16\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\32\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\13\106\1"
        + "\u0093\16\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\1\u0094\31"
        + "\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\21\106\1"
        + "\u0095\10\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\32\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\32\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\32\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\21\106\1"
        + "\u0099\10\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\16\106\1"
        + "\u009a\13\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\1\u009b\31"
        + "\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\2\106\1\u009c"
        + "\27\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\10\106\1"
        + "\u009d\21\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\2\106\1\u009e"
        + "\27\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\32\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\21\106\1"
        + "\u00a0\10\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\23\106\1"
        + "\u00a1\6\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\10\106\1"
        + "\u00a2\21\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\24\106\1"
        + "\u00a3\5\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\1\u00a4\31"
        + "\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\32\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\16\106\1"
        + "\u00a6\13\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\16\106\1"
        + "\u00a7\13\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\10\106\1"
        + "\u00a8\21\106",
        "",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\7\106\1\u00a9"
        + "\22\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\15\106\1"
        + "\u00aa\14\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\1\u00ab\31"
        + "\106",
        "",
        "",
        "",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\15\106\1"
        + "\u00ac\14\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\32\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\3\106\1\u00ae"
        + "\26\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\16\106\1"
        + "\u00af\13\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\1\u00b0\31"
        + "\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\23\106\1"
        + "\u00b1\6\106",
        "",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\1\u00b2\31"
        + "\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\32\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\21\106\1"
        + "\u00b4\10\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\1\u00b5\31"
        + "\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\16\106\1"
        + "\u00b6\13\106",
        "",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\32\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\32\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\16\106\1"
        + "\u00b9\13\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\1\u00ba\31"
        + "\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\23\106\1"
        + "\u00bb\6\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\14\106\1"
        + "\u00bc\15\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\4\106\1\u00bd"
        + "\25\106",
        "",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\4\106\1\u00be"
        + "\25\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\32\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\32\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\4\106\1\u00c1"
        + "\25\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\21\106\1"
        + "\u00c2\10\106",
        "",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\16\106\1"
        + "\u00c3\13\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\32\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\32\106",
        "",
        "",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\23\106\1"
        + "\u00c6\6\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\32\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\16\106\1"
        + "\u00c8\13\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\1\u00c9\31"
        + "\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\32\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\10\106\1"
        + "\u00cb\21\106",
        "",
        "",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\21\106\1"
        + "\u00cc\10\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\10\106\1"
        + "\u00cd\21\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\32\106",
        "",
        "",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\4\106\1\u00cf"
        + "\25\106",
        "",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\32\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\32\106",
        "",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\21\106\1"
        + "\u00d2\10\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\32\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\16\106\1"
        + "\u00d4\13\106",
        "",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\2\106\1\u00d5"
        + "\27\106",
        "",
        "",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\16\106\1"
        + "\u00d6\13\106",
        "",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\32\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\1\u00d8\31"
        + "\106",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\32\106",
        "",
        "\1\107\1\uffff\12\106\7\uffff\32\106\4\uffff\1\106\1\uffff\32\106",
        ""
    };
    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static
    {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i = 0; i < numStates; i++)
        {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    protected class DFA20 extends DFA
    {
        public DFA20(BaseRecognizer recognizer)
        {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }

        @Override
        public String getDescription()
        {
            return "1:1: Tokens : ( T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | PR_PROGRAMA | PR_REAL | PR_VAZIO | PR_LOGICO | PR_CADEIA | PR_INTEIRO | PR_CARACTER | PR_ESCOLHA | PR_CASO | PR_CONTRARIO | PR_CONST | PR_FUNCAO | PR_RETORNE | PR_PARA | PR_PARE | PR_FACA | PR_ENQUANTO | PR_SE | PR_SENAO | PR_INCLUA | PR_BIBLIOTECA | GAMBIARRA | OPERADOR_NAO | LOGICO | ID | ID_BIBLIOTECA | INTEIRO | REAL | CADEIA | CARACTER | ESPACO | COMENTARIO );";
        }

        @Override
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException
        {
            IntStream input = _input;
            int _s = s;
            switch (s)
            {
                case 0:
                    int LA20_35 = input.LA(1);
                    s = -1;
                    if (((LA20_35 >= '\u0000' && LA20_35 <= '\uFFFF')))
                    {
                        s = 90;
                    }
                    else
                    {
                        s = 34;
                    }
                    if (s >= 0)
                    {
                        return s;
                    }
                    break;

                case 1:
                    int LA20_36 = input.LA(1);
                    s = -1;
                    if (((LA20_36 >= '\u0000' && LA20_36 <= '&') || (LA20_36 >= '(' && LA20_36 <= '\uFFFF')))
                    {
                        s = 91;
                    }
                    else
                    {
                        s = 34;
                    }
                    if (s >= 0)
                    {
                        return s;
                    }
                    break;
            }
            NoViableAltException nvae =
                    new NoViableAltException(getDescription(), 20, _s, input);
            error(nvae);
            throw nvae;
        }
    }
}
