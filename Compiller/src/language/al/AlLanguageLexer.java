// $ANTLR 3.3 Nov 30, 2010 12:50:56 G:\\Compiller\\src\\language\\al\\AlLanguage.g 2012-05-27 13:15:45

    package language.al;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class AlLanguageLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
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
    public static final int IDENT=4;
    public static final int STRING=5;
    public static final int INT=6;
    public static final int FLOAT=7;
    public static final int LETTER=8;
    public static final int DIGIT=9;
    public static final int FLOAT_G=10;
    public static final int EXPONENT=11;
    public static final int COMMENT=12;
    public static final int WS=13;
    public static final int ESC_SEQ=14;
    public static final int HEX_DIGIT=15;
    public static final int UNICODE_ESC=16;
    public static final int OCTAL_ESC=17;

    // delegates
    // delegators

    public AlLanguageLexer() {;} 
    public AlLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public AlLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "G:\\Compiller\\src\\language\\al\\AlLanguage.g"; }

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:7:7: ( 'program' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:7:9: 'program'
            {
            match("program"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:8:7: ( 'global' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:8:9: 'global'
            {
            match("global"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:9:7: ( '{' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:9:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:10:7: ( ';' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:10:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:11:7: ( '}' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:11:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:12:7: ( ':' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:12:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:13:7: ( 'procedure' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:13:9: 'procedure'
            {
            match("procedure"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:14:7: ( '(' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:14:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:15:7: ( ')' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:15:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:16:7: ( ',' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:16:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:17:7: ( '=' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:17:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:18:7: ( 'write' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:18:9: 'write'
            {
            match("write"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:19:7: ( 'read' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:19:9: 'read'
            {
            match("read"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:20:7: ( 'if' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:20:9: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:21:7: ( 'else' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:21:9: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:22:7: ( 'for' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:22:9: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:23:7: ( 'while' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:23:9: 'while'
            {
            match("while"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:24:7: ( 'do' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:24:9: 'do'
            {
            match("do"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:25:7: ( 'return' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:25:9: 'return'
            {
            match("return"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:26:7: ( 'call' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:26:9: 'call'
            {
            match("call"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:27:7: ( '|' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:27:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:28:7: ( '&' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:28:9: '&'
            {
            match('&'); 

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
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:29:7: ( '!' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:29:9: '!'
            {
            match('!'); 

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
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:30:7: ( '<' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:30:9: '<'
            {
            match('<'); 

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
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:31:7: ( '>' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:31:9: '>'
            {
            match('>'); 

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
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:32:7: ( '==' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:32:9: '=='
            {
            match("=="); 


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
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:33:7: ( '!=' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:33:9: '!='
            {
            match("!="); 


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
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:34:7: ( '+' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:34:9: '+'
            {
            match('+'); 

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
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:35:7: ( '-' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:35:9: '-'
            {
            match('-'); 

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
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:36:7: ( '*' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:36:9: '*'
            {
            match('*'); 

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
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:37:7: ( '/' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:37:9: '/'
            {
            match('/'); 

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
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:38:7: ( '%' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:38:9: '%'
            {
            match('%'); 

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
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:39:7: ( '^' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:39:9: '^'
            {
            match('^'); 

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
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:40:7: ( 'convertF2I' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:40:9: 'convertF2I'
            {
            match("convertF2I"); 


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
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:41:7: ( 'convertI2F' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:41:9: 'convertI2F'
            {
            match("convertI2F"); 


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
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:42:7: ( 'int' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:42:9: 'int'
            {
            match("int"); 


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
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:43:7: ( 'float' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:43:9: 'float'
            {
            match("float"); 


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
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:44:7: ( 'boolean' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:44:9: 'boolean'
            {
            match("boolean"); 


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
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:45:7: ( 'true' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:45:9: 'true'
            {
            match("true"); 


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
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:46:7: ( 'false' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:46:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:723:2: ( ( LETTER | '_' ) ( LETTER | '_' | DIGIT )* )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:723:4: ( LETTER | '_' ) ( LETTER | '_' | DIGIT )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:723:20: ( LETTER | '_' | DIGIT )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:
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
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENT"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:727:2: ( ( '-' )? ( '1' .. '9' ) ( DIGIT )* | '0' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='-'||(LA4_0>='1' && LA4_0<='9')) ) {
                alt4=1;
            }
            else if ( (LA4_0=='0') ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:727:4: ( '-' )? ( '1' .. '9' ) ( DIGIT )*
                    {
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:727:4: ( '-' )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0=='-') ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:727:5: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }

                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:727:11: ( '1' .. '9' )
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:727:13: '1' .. '9'
                    {
                    matchRange('1','9'); 

                    }

                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:727:24: ( DIGIT )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:727:26: DIGIT
                    	    {
                    	    mDIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:728:4: '0'
                    {
                    match('0'); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:732:5: ( ( '-' )? FLOAT_G )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:732:7: ( '-' )? FLOAT_G
            {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:732:7: ( '-' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='-') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:732:8: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            mFLOAT_G(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "FLOAT_G"
    public final void mFLOAT_G() throws RecognitionException {
        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:737:2: ( ( DIGIT )+ '.' EXPONENT | ( DIGIT )+ ( '.' ( ( DIGIT )+ ( EXPONENT )? )? | EXPONENT ) )
            int alt12=2;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:737:4: ( DIGIT )+ '.' EXPONENT
                    {
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:737:4: ( DIGIT )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:737:4: DIGIT
                    	    {
                    	    mDIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt6 >= 1 ) break loop6;
                                EarlyExitException eee =
                                    new EarlyExitException(6, input);
                                throw eee;
                        }
                        cnt6++;
                    } while (true);

                    match('.'); 
                    mEXPONENT(); 

                    }
                    break;
                case 2 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:738:4: ( DIGIT )+ ( '.' ( ( DIGIT )+ ( EXPONENT )? )? | EXPONENT )
                    {
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:738:4: ( DIGIT )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:738:4: DIGIT
                    	    {
                    	    mDIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);

                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:738:11: ( '.' ( ( DIGIT )+ ( EXPONENT )? )? | EXPONENT )
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='.') ) {
                        alt11=1;
                    }
                    else if ( (LA11_0=='E'||LA11_0=='e') ) {
                        alt11=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 0, input);

                        throw nvae;
                    }
                    switch (alt11) {
                        case 1 :
                            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:738:13: '.' ( ( DIGIT )+ ( EXPONENT )? )?
                            {
                            match('.'); 
                            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:738:17: ( ( DIGIT )+ ( EXPONENT )? )?
                            int alt10=2;
                            int LA10_0 = input.LA(1);

                            if ( ((LA10_0>='0' && LA10_0<='9')) ) {
                                alt10=1;
                            }
                            switch (alt10) {
                                case 1 :
                                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:738:19: ( DIGIT )+ ( EXPONENT )?
                                    {
                                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:738:19: ( DIGIT )+
                                    int cnt8=0;
                                    loop8:
                                    do {
                                        int alt8=2;
                                        int LA8_0 = input.LA(1);

                                        if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                                            alt8=1;
                                        }


                                        switch (alt8) {
                                    	case 1 :
                                    	    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:738:19: DIGIT
                                    	    {
                                    	    mDIGIT(); 

                                    	    }
                                    	    break;

                                    	default :
                                    	    if ( cnt8 >= 1 ) break loop8;
                                                EarlyExitException eee =
                                                    new EarlyExitException(8, input);
                                                throw eee;
                                        }
                                        cnt8++;
                                    } while (true);

                                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:738:27: ( EXPONENT )?
                                    int alt9=2;
                                    int LA9_0 = input.LA(1);

                                    if ( (LA9_0=='E'||LA9_0=='e') ) {
                                        alt9=1;
                                    }
                                    switch (alt9) {
                                        case 1 :
                                            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:738:29: EXPONENT
                                            {
                                            mEXPONENT(); 

                                            }
                                            break;

                                    }


                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:738:48: EXPONENT
                            {
                            mEXPONENT(); 

                            }
                            break;

                    }


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "FLOAT_G"

    // $ANTLR start "EXPONENT"
    public final void mEXPONENT() throws RecognitionException {
        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:743:2: ( ( 'e' | 'E' ) ( '+' | '-' )? ( DIGIT )+ )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:743:4: ( 'e' | 'E' ) ( '+' | '-' )? ( DIGIT )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:743:18: ( '+' | '-' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='+'||LA13_0=='-') ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:743:33: ( DIGIT )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='0' && LA14_0<='9')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:743:33: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "EXPONENT"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:748:2: ( 'A' .. 'Z' | 'a' .. 'z' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
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
    // $ANTLR end "LETTER"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:753:2: ( '0' .. '9' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:753:4: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:757:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:757:9: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:757:14: (~ ( '\\n' | '\\r' ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>='\u0000' && LA15_0<='\t')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<='\uFFFF')) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:757:14: ~ ( '\\n' | '\\r' )
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
            	    break loop15;
                }
            } while (true);

            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:757:28: ( '\\r' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='\r') ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:757:28: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 
            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:761:3: ( ( '\\t' | ( '\\r' )? '\\n' | ' ' )+ )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:761:5: ( '\\t' | ( '\\r' )? '\\n' | ' ' )+
            {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:761:5: ( '\\t' | ( '\\r' )? '\\n' | ' ' )+
            int cnt18=0;
            loop18:
            do {
                int alt18=4;
                switch ( input.LA(1) ) {
                case '\t':
                    {
                    alt18=1;
                    }
                    break;
                case '\n':
                case '\r':
                    {
                    alt18=2;
                    }
                    break;
                case ' ':
                    {
                    alt18=3;
                    }
                    break;

                }

                switch (alt18) {
            	case 1 :
            	    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:761:6: '\\t'
            	    {
            	    match('\t'); 

            	    }
            	    break;
            	case 2 :
            	    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:761:13: ( '\\r' )? '\\n'
            	    {
            	    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:761:13: ( '\\r' )?
            	    int alt17=2;
            	    int LA17_0 = input.LA(1);

            	    if ( (LA17_0=='\r') ) {
            	        alt17=1;
            	    }
            	    switch (alt17) {
            	        case 1 :
            	            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:761:13: '\\r'
            	            {
            	            match('\r'); 

            	            }
            	            break;

            	    }

            	    match('\n'); 

            	    }
            	    break;
            	case 3 :
            	    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:761:26: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:766:5: ( '\"' ( ESC_SEQ | ~ ( '\\\\' | '\"' ) )* '\"' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:766:8: '\"' ( ESC_SEQ | ~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:766:12: ( ESC_SEQ | ~ ( '\\\\' | '\"' ) )*
            loop19:
            do {
                int alt19=3;
                int LA19_0 = input.LA(1);

                if ( (LA19_0=='\\') ) {
                    alt19=1;
                }
                else if ( ((LA19_0>='\u0000' && LA19_0<='!')||(LA19_0>='#' && LA19_0<='[')||(LA19_0>=']' && LA19_0<='\uFFFF')) ) {
                    alt19=2;
                }


                switch (alt19) {
            	case 1 :
            	    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:766:14: ESC_SEQ
            	    {
            	    mESC_SEQ(); 

            	    }
            	    break;
            	case 2 :
            	    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:766:24: ~ ( '\\\\' | '\"' )
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
            	    break loop19;
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
    // $ANTLR end "STRING"

    // $ANTLR start "HEX_DIGIT"
    public final void mHEX_DIGIT() throws RecognitionException {
        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:770:11: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:770:13: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
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
    // $ANTLR end "HEX_DIGIT"

    // $ANTLR start "ESC_SEQ"
    public final void mESC_SEQ() throws RecognitionException {
        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:774:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | OCTAL_ESC )
            int alt20=3;
            int LA20_0 = input.LA(1);

            if ( (LA20_0=='\\') ) {
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
                    alt20=1;
                    }
                    break;
                case 'u':
                    {
                    alt20=2;
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
                    alt20=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:774:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:775:9: UNICODE_ESC
                    {
                    mUNICODE_ESC(); 

                    }
                    break;
                case 3 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:776:9: OCTAL_ESC
                    {
                    mOCTAL_ESC(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "ESC_SEQ"

    // $ANTLR start "OCTAL_ESC"
    public final void mOCTAL_ESC() throws RecognitionException {
        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:781:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt21=3;
            int LA21_0 = input.LA(1);

            if ( (LA21_0=='\\') ) {
                int LA21_1 = input.LA(2);

                if ( ((LA21_1>='0' && LA21_1<='3')) ) {
                    int LA21_2 = input.LA(3);

                    if ( ((LA21_2>='0' && LA21_2<='7')) ) {
                        int LA21_4 = input.LA(4);

                        if ( ((LA21_4>='0' && LA21_4<='7')) ) {
                            alt21=1;
                        }
                        else {
                            alt21=2;}
                    }
                    else {
                        alt21=3;}
                }
                else if ( ((LA21_1>='4' && LA21_1<='7')) ) {
                    int LA21_3 = input.LA(3);

                    if ( ((LA21_3>='0' && LA21_3<='7')) ) {
                        alt21=2;
                    }
                    else {
                        alt21=3;}
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:781:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:781:14: ( '0' .. '3' )
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:781:15: '0' .. '3'
                    {
                    matchRange('0','3'); 

                    }

                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:781:25: ( '0' .. '7' )
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:781:26: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:781:36: ( '0' .. '7' )
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:781:37: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 2 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:782:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:782:14: ( '0' .. '7' )
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:782:15: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:782:25: ( '0' .. '7' )
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:782:26: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 3 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:783:9: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:783:14: ( '0' .. '7' )
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:783:15: '0' .. '7'
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
    // $ANTLR end "OCTAL_ESC"

    // $ANTLR start "UNICODE_ESC"
    public final void mUNICODE_ESC() throws RecognitionException {
        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:788:5: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:788:9: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
            {
            match('\\'); 
            match('u'); 
            mHEX_DIGIT(); 
            mHEX_DIGIT(); 
            mHEX_DIGIT(); 
            mHEX_DIGIT(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "UNICODE_ESC"

    public void mTokens() throws RecognitionException {
        // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:8: ( T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | IDENT | INT | FLOAT | COMMENT | WS | STRING )
        int alt22=46;
        alt22 = dfa22.predict(input);
        switch (alt22) {
            case 1 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:10: T__18
                {
                mT__18(); 

                }
                break;
            case 2 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:16: T__19
                {
                mT__19(); 

                }
                break;
            case 3 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:22: T__20
                {
                mT__20(); 

                }
                break;
            case 4 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:28: T__21
                {
                mT__21(); 

                }
                break;
            case 5 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:34: T__22
                {
                mT__22(); 

                }
                break;
            case 6 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:40: T__23
                {
                mT__23(); 

                }
                break;
            case 7 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:46: T__24
                {
                mT__24(); 

                }
                break;
            case 8 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:52: T__25
                {
                mT__25(); 

                }
                break;
            case 9 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:58: T__26
                {
                mT__26(); 

                }
                break;
            case 10 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:64: T__27
                {
                mT__27(); 

                }
                break;
            case 11 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:70: T__28
                {
                mT__28(); 

                }
                break;
            case 12 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:76: T__29
                {
                mT__29(); 

                }
                break;
            case 13 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:82: T__30
                {
                mT__30(); 

                }
                break;
            case 14 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:88: T__31
                {
                mT__31(); 

                }
                break;
            case 15 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:94: T__32
                {
                mT__32(); 

                }
                break;
            case 16 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:100: T__33
                {
                mT__33(); 

                }
                break;
            case 17 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:106: T__34
                {
                mT__34(); 

                }
                break;
            case 18 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:112: T__35
                {
                mT__35(); 

                }
                break;
            case 19 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:118: T__36
                {
                mT__36(); 

                }
                break;
            case 20 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:124: T__37
                {
                mT__37(); 

                }
                break;
            case 21 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:130: T__38
                {
                mT__38(); 

                }
                break;
            case 22 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:136: T__39
                {
                mT__39(); 

                }
                break;
            case 23 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:142: T__40
                {
                mT__40(); 

                }
                break;
            case 24 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:148: T__41
                {
                mT__41(); 

                }
                break;
            case 25 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:154: T__42
                {
                mT__42(); 

                }
                break;
            case 26 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:160: T__43
                {
                mT__43(); 

                }
                break;
            case 27 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:166: T__44
                {
                mT__44(); 

                }
                break;
            case 28 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:172: T__45
                {
                mT__45(); 

                }
                break;
            case 29 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:178: T__46
                {
                mT__46(); 

                }
                break;
            case 30 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:184: T__47
                {
                mT__47(); 

                }
                break;
            case 31 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:190: T__48
                {
                mT__48(); 

                }
                break;
            case 32 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:196: T__49
                {
                mT__49(); 

                }
                break;
            case 33 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:202: T__50
                {
                mT__50(); 

                }
                break;
            case 34 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:208: T__51
                {
                mT__51(); 

                }
                break;
            case 35 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:214: T__52
                {
                mT__52(); 

                }
                break;
            case 36 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:220: T__53
                {
                mT__53(); 

                }
                break;
            case 37 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:226: T__54
                {
                mT__54(); 

                }
                break;
            case 38 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:232: T__55
                {
                mT__55(); 

                }
                break;
            case 39 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:238: T__56
                {
                mT__56(); 

                }
                break;
            case 40 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:244: T__57
                {
                mT__57(); 

                }
                break;
            case 41 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:250: IDENT
                {
                mIDENT(); 

                }
                break;
            case 42 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:256: INT
                {
                mINT(); 

                }
                break;
            case 43 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:260: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 44 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:266: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 45 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:274: WS
                {
                mWS(); 

                }
                break;
            case 46 :
                // G:\\Compiller\\src\\language\\al\\AlLanguage.g:1:277: STRING
                {
                mSTRING(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    protected DFA22 dfa22 = new DFA22(this);
    static final String DFA12_eotS =
        "\2\uffff\1\3\2\uffff";
    static final String DFA12_eofS =
        "\5\uffff";
    static final String DFA12_minS =
        "\1\60\1\56\1\105\2\uffff";
    static final String DFA12_maxS =
        "\1\71\2\145\2\uffff";
    static final String DFA12_acceptS =
        "\3\uffff\1\2\1\1";
    static final String DFA12_specialS =
        "\5\uffff}>";
    static final String[] DFA12_transitionS = {
            "\12\1",
            "\1\2\1\uffff\12\1\13\uffff\1\3\37\uffff\1\3",
            "\1\4\37\uffff\1\4",
            "",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "735:1: fragment FLOAT_G : ( ( DIGIT )+ '.' EXPONENT | ( DIGIT )+ ( '.' ( ( DIGIT )+ ( EXPONENT )? )? | EXPONENT ) );";
        }
    }
    static final String DFA22_eotS =
        "\1\uffff\2\37\7\uffff\1\47\7\37\2\uffff\1\65\3\uffff\1\66\1\uffff"+
        "\1\71\2\uffff\2\37\1\uffff\2\75\2\uffff\2\37\2\uffff\3\37\1\104"+
        "\5\37\1\112\2\37\6\uffff\2\37\1\75\1\uffff\6\37\1\uffff\1\126\1"+
        "\37\1\130\2\37\1\uffff\11\37\1\144\1\37\1\uffff\1\146\1\uffff\2"+
        "\37\1\151\2\37\1\154\3\37\1\160\1\161\1\uffff\1\37\1\uffff\1\163"+
        "\1\164\1\uffff\2\37\1\uffff\2\37\1\171\2\uffff\1\172\2\uffff\2\37"+
        "\1\175\1\37\2\uffff\1\37\1\u0081\1\uffff\3\37\1\uffff\1\u0085\2"+
        "\37\1\uffff\1\u0088\1\u0089\2\uffff";
    static final String DFA22_eofS =
        "\u008a\uffff";
    static final String DFA22_minS =
        "\1\11\1\162\1\154\7\uffff\1\75\1\150\1\145\1\146\1\154\1\141\1"+
        "\157\1\141\2\uffff\1\75\3\uffff\1\60\1\uffff\1\57\2\uffff\1\157"+
        "\1\162\1\uffff\2\56\2\uffff\2\157\2\uffff\2\151\1\141\1\60\1\164"+
        "\1\163\1\162\1\157\1\154\1\60\1\154\1\156\6\uffff\1\157\1\165\1"+
        "\56\1\uffff\1\143\1\142\1\164\1\154\1\144\1\165\1\uffff\1\60\1\145"+
        "\1\60\1\141\1\163\1\uffff\1\154\1\166\1\154\1\145\1\162\1\145\1"+
        "\141\2\145\1\60\1\162\1\uffff\1\60\1\uffff\1\164\1\145\1\60\2\145"+
        "\1\60\1\141\1\144\1\154\2\60\1\uffff\1\156\1\uffff\2\60\1\uffff"+
        "\1\162\1\141\1\uffff\1\155\1\165\1\60\2\uffff\1\60\2\uffff\1\164"+
        "\1\156\1\60\1\162\2\uffff\1\106\1\60\1\uffff\1\145\2\62\1\uffff"+
        "\1\60\1\111\1\106\1\uffff\2\60\2\uffff";
    static final String DFA22_maxS =
        "\1\175\1\162\1\154\7\uffff\1\75\1\162\1\145\1\156\1\154\3\157\2"+
        "\uffff\1\75\3\uffff\1\71\1\uffff\1\57\2\uffff\1\157\1\162\1\uffff"+
        "\2\145\2\uffff\2\157\2\uffff\2\151\1\164\1\172\1\164\1\163\1\162"+
        "\1\157\1\154\1\172\1\154\1\156\6\uffff\1\157\1\165\1\145\1\uffff"+
        "\1\147\1\142\1\164\1\154\1\144\1\165\1\uffff\1\172\1\145\1\172\1"+
        "\141\1\163\1\uffff\1\154\1\166\1\154\1\145\1\162\1\145\1\141\2\145"+
        "\1\172\1\162\1\uffff\1\172\1\uffff\1\164\1\145\1\172\2\145\1\172"+
        "\1\141\1\144\1\154\2\172\1\uffff\1\156\1\uffff\2\172\1\uffff\1\162"+
        "\1\141\1\uffff\1\155\1\165\1\172\2\uffff\1\172\2\uffff\1\164\1\156"+
        "\1\172\1\162\2\uffff\1\111\1\172\1\uffff\1\145\2\62\1\uffff\1\172"+
        "\1\111\1\106\1\uffff\2\172\2\uffff";
    static final String DFA22_acceptS =
        "\3\uffff\1\3\1\4\1\5\1\6\1\10\1\11\1\12\10\uffff\1\25\1\26\1\uffff"+
        "\1\30\1\31\1\34\1\uffff\1\36\1\uffff\1\40\1\41\2\uffff\1\51\2\uffff"+
        "\1\55\1\56\2\uffff\1\32\1\13\14\uffff\1\33\1\27\1\35\1\53\1\54\1"+
        "\37\3\uffff\1\52\6\uffff\1\16\5\uffff\1\22\13\uffff\1\44\1\uffff"+
        "\1\20\13\uffff\1\15\1\uffff\1\17\2\uffff\1\24\2\uffff\1\47\3\uffff"+
        "\1\14\1\21\1\uffff\1\45\1\50\4\uffff\1\2\1\23\2\uffff\1\1\3\uffff"+
        "\1\46\3\uffff\1\7\2\uffff\1\42\1\43";
    static final String DFA22_specialS =
        "\u008a\uffff}>";
    static final String[] DFA22_transitionS = {
            "\2\42\2\uffff\1\42\22\uffff\1\42\1\24\1\43\2\uffff\1\33\1\23"+
            "\1\uffff\1\7\1\10\1\31\1\27\1\11\1\30\1\uffff\1\32\1\41\11\40"+
            "\1\6\1\4\1\25\1\12\1\26\2\uffff\32\37\3\uffff\1\34\1\37\1\uffff"+
            "\1\37\1\35\1\21\1\20\1\16\1\17\1\2\1\37\1\15\6\37\1\1\1\37\1"+
            "\14\1\37\1\36\2\37\1\13\3\37\1\3\1\22\1\5",
            "\1\44",
            "\1\45",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\46",
            "\1\51\11\uffff\1\50",
            "\1\52",
            "\1\53\7\uffff\1\54",
            "\1\55",
            "\1\60\12\uffff\1\57\2\uffff\1\56",
            "\1\61",
            "\1\62\15\uffff\1\63",
            "",
            "",
            "\1\64",
            "",
            "",
            "",
            "\1\67\11\40",
            "",
            "\1\70",
            "",
            "",
            "\1\72",
            "\1\73",
            "",
            "\1\67\1\uffff\12\74\13\uffff\1\67\37\uffff\1\67",
            "\1\67\1\uffff\12\67\13\uffff\1\67\37\uffff\1\67",
            "",
            "",
            "\1\76",
            "\1\77",
            "",
            "",
            "\1\100",
            "\1\101",
            "\1\102\22\uffff\1\103",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\113",
            "\1\114",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\115",
            "\1\116",
            "\1\67\1\uffff\12\74\13\uffff\1\67\37\uffff\1\67",
            "",
            "\1\120\3\uffff\1\117",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\127",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\131",
            "\1\132",
            "",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\145",
            "",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "",
            "\1\147",
            "\1\150",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\152",
            "\1\153",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\155",
            "\1\156",
            "\1\157",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "",
            "\1\162",
            "",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "",
            "\1\165",
            "\1\166",
            "",
            "\1\167",
            "\1\170",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "",
            "",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "",
            "",
            "\1\173",
            "\1\174",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\176",
            "",
            "",
            "\1\177\2\uffff\1\u0080",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\u0086",
            "\1\u0087",
            "",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "",
            ""
    };

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | IDENT | INT | FLOAT | COMMENT | WS | STRING );";
        }
    }
 

}