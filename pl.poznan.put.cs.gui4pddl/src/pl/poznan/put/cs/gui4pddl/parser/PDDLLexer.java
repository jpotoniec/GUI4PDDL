// $ANTLR 3.5 /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g 2013-09-18 15:45:44

	package pl.poznan.put.cs.gui4pddl.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PDDLLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
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
	public static final int COMMENT=4;
	public static final int FALSE=5;
	public static final int INTEGER=6;
	public static final int NAME=7;
	public static final int REQUIRE_KEY=8;
	public static final int TRUE=9;
	public static final int VARIABLE=10;
	public static final int WS=11;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public PDDLLexer() {} 
	public PDDLLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public PDDLLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "/home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g"; }

	// $ANTLR start "T__12"
	public final void mT__12() throws RecognitionException {
		try {
			int _type = T__12;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:6:7: ( '(' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:6:9: '('
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
	// $ANTLR end "T__12"

	// $ANTLR start "T__13"
	public final void mT__13() throws RecognitionException {
		try {
			int _type = T__13;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:7:7: ( ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:7:9: ')'
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
	// $ANTLR end "T__13"

	// $ANTLR start "T__14"
	public final void mT__14() throws RecognitionException {
		try {
			int _type = T__14;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:8:7: ( '-' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:8:9: '-'
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
	// $ANTLR end "T__14"

	// $ANTLR start "T__15"
	public final void mT__15() throws RecognitionException {
		try {
			int _type = T__15;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:9:7: ( ':action' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:9:9: ':action'
			{
			match(":action"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__15"

	// $ANTLR start "T__16"
	public final void mT__16() throws RecognitionException {
		try {
			int _type = T__16;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:10:7: ( ':axiom' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:10:9: ':axiom'
			{
			match(":axiom"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__16"

	// $ANTLR start "T__17"
	public final void mT__17() throws RecognitionException {
		try {
			int _type = T__17;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:11:7: ( ':constants' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:11:9: ':constants'
			{
			match(":constants"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__17"

	// $ANTLR start "T__18"
	public final void mT__18() throws RecognitionException {
		try {
			int _type = T__18;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:12:7: ( ':context' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:12:9: ':context'
			{
			match(":context"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__18"

	// $ANTLR start "T__19"
	public final void mT__19() throws RecognitionException {
		try {
			int _type = T__19;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:13:7: ( ':domain' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:13:9: ':domain'
			{
			match(":domain"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__19"

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:14:7: ( ':domain-variables' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:14:9: ':domain-variables'
			{
			match(":domain-variables"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:15:7: ( ':effect' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:15:9: ':effect'
			{
			match(":effect"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:16:7: ( ':expansion' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:16:9: ':expansion'
			{
			match(":expansion"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:17:7: ( ':extends' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:17:9: ':extends'
			{
			match(":extends"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__23"

	// $ANTLR start "T__24"
	public final void mT__24() throws RecognitionException {
		try {
			int _type = T__24;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:18:7: ( ':goal' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:18:9: ':goal'
			{
			match(":goal"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__24"

	// $ANTLR start "T__25"
	public final void mT__25() throws RecognitionException {
		try {
			int _type = T__25;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:19:7: ( ':implies' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:19:9: ':implies'
			{
			match(":implies"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__25"

	// $ANTLR start "T__26"
	public final void mT__26() throws RecognitionException {
		try {
			int _type = T__26;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:20:7: ( ':init' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:20:9: ':init'
			{
			match(":init"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__26"

	// $ANTLR start "T__27"
	public final void mT__27() throws RecognitionException {
		try {
			int _type = T__27;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:21:7: ( ':length' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:21:9: ':length'
			{
			match(":length"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__27"

	// $ANTLR start "T__28"
	public final void mT__28() throws RecognitionException {
		try {
			int _type = T__28;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:22:7: ( ':maintain' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:22:9: ':maintain'
			{
			match(":maintain"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__28"

	// $ANTLR start "T__29"
	public final void mT__29() throws RecognitionException {
		try {
			int _type = T__29;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:23:7: ( ':method' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:23:9: ':method'
			{
			match(":method"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__29"

	// $ANTLR start "T__30"
	public final void mT__30() throws RecognitionException {
		try {
			int _type = T__30;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:24:7: ( ':objects' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:24:9: ':objects'
			{
			match(":objects"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__30"

	// $ANTLR start "T__31"
	public final void mT__31() throws RecognitionException {
		try {
			int _type = T__31;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:25:7: ( ':only-in-expansions' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:25:9: ':only-in-expansions'
			{
			match(":only-in-expansions"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__31"

	// $ANTLR start "T__32"
	public final void mT__32() throws RecognitionException {
		try {
			int _type = T__32;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:26:7: ( ':parallel' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:26:9: ':parallel'
			{
			match(":parallel"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__32"

	// $ANTLR start "T__33"
	public final void mT__33() throws RecognitionException {
		try {
			int _type = T__33;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:27:7: ( ':parameters' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:27:9: ':parameters'
			{
			match(":parameters"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__33"

	// $ANTLR start "T__34"
	public final void mT__34() throws RecognitionException {
		try {
			int _type = T__34;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:28:7: ( ':precondition' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:28:9: ':precondition'
			{
			match(":precondition"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__34"

	// $ANTLR start "T__35"
	public final void mT__35() throws RecognitionException {
		try {
			int _type = T__35;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:29:7: ( ':predicates' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:29:9: ':predicates'
			{
			match(":predicates"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__35"

	// $ANTLR start "T__36"
	public final void mT__36() throws RecognitionException {
		try {
			int _type = T__36;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:30:7: ( ':requirements' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:30:9: ':requirements'
			{
			match(":requirements"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__36"

	// $ANTLR start "T__37"
	public final void mT__37() throws RecognitionException {
		try {
			int _type = T__37;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:31:7: ( ':safety' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:31:9: ':safety'
			{
			match(":safety"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__37"

	// $ANTLR start "T__38"
	public final void mT__38() throws RecognitionException {
		try {
			int _type = T__38;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:32:7: ( ':serial' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:32:9: ':serial'
			{
			match(":serial"); 

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
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:33:7: ( ':situation' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:33:9: ':situation'
			{
			match(":situation"); 

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
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:34:7: ( ':timeless' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:34:9: ':timeless'
			{
			match(":timeless"); 

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
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:35:7: ( ':types' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:35:9: ':types'
			{
			match(":types"); 

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
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:36:7: ( ':vars' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:36:9: ':vars'
			{
			match(":vars"); 

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
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:37:7: ( 'and' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:37:9: 'and'
			{
			match("and"); 

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
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:38:7: ( 'change' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:38:9: 'change'
			{
			match("change"); 

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
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:39:7: ( 'define' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:39:9: 'define'
			{
			match("define"); 

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
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:40:7: ( 'domain' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:40:9: 'domain'
			{
			match("domain"); 

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
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:41:7: ( 'either' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:41:9: 'either'
			{
			match("either"); 

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
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:42:7: ( 'exists' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:42:9: 'exists'
			{
			match("exists"); 

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
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:43:7: ( 'fluent' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:43:9: 'fluent'
			{
			match("fluent"); 

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
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:44:7: ( 'forall' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:44:9: 'forall'
			{
			match("forall"); 

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
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:45:7: ( 'imply' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:45:9: 'imply'
			{
			match("imply"); 

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
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:46:7: ( 'not' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:46:9: 'not'
			{
			match("not"); 

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
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:47:7: ( 'or' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:47:9: 'or'
			{
			match("or"); 

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
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:48:7: ( 'problem' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:48:9: 'problem'
			{
			match("problem"); 

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
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:49:7: ( 'situation' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:49:9: 'situation'
			{
			match("situation"); 

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
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:50:7: ( 'when' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:50:9: 'when'
			{
			match("when"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__56"

	// $ANTLR start "TRUE"
	public final void mTRUE() throws RecognitionException {
		try {
			int _type = TRUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:370:5: ( 'true' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:370:10: 'true'
			{
			match("true"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TRUE"

	// $ANTLR start "FALSE"
	public final void mFALSE() throws RecognitionException {
		try {
			int _type = FALSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:374:5: ( 'false' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:374:10: 'false'
			{
			match("false"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FALSE"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:377:4: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:377:7: ( ' ' | '\\t' | '\\n' | '\\r' )+
			{
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:377:7: ( ' ' | '\\t' | '\\n' | '\\r' )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '\t' && LA1_0 <= '\n')||LA1_0=='\r'||LA1_0==' ') ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
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
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			skip();
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:381:5: ( ';' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:381:9: ';' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
			{
			match(';'); 
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:381:13: (~ ( '\\n' | '\\r' ) )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\f')||(LA2_0 >= '\u000E' && LA2_0 <= '\uFFFF')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:
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
					break loop2;
				}
			}

			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:381:27: ( '\\r' )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0=='\r') ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:381:27: '\\r'
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
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "NAME"
	public final void mNAME() throws RecognitionException {
		try {
			int _type = NAME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:384:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '0' .. '9' )* )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:384:8: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '0' .. '9' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:384:27: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '0' .. '9' )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0=='-'||(LA4_0 >= '0' && LA4_0 <= '9')||(LA4_0 >= 'A' && LA4_0 <= 'Z')||LA4_0=='_'||(LA4_0 >= 'a' && LA4_0 <= 'z')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:
					{
					if ( input.LA(1)=='-'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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
					break loop4;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NAME"

	// $ANTLR start "INTEGER"
	public final void mINTEGER() throws RecognitionException {
		try {
			int _type = INTEGER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:387:9: ( ( '0' .. '9' )+ )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:387:11: ( '0' .. '9' )+
			{
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:387:11: ( '0' .. '9' )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:
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
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INTEGER"

	// $ANTLR start "REQUIRE_KEY"
	public final void mREQUIRE_KEY() throws RecognitionException {
		try {
			int _type = REQUIRE_KEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:391:2: ( ':' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '0' .. '9' )+ )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:391:4: ':' ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '0' .. '9' )+
			{
			match(':'); 
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:391:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '0' .. '9' )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0=='-'||(LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'Z')||LA6_0=='_'||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:
					{
					if ( input.LA(1)=='-'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "REQUIRE_KEY"

	// $ANTLR start "VARIABLE"
	public final void mVARIABLE() throws RecognitionException {
		try {
			int _type = VARIABLE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:395:2: ( '?' ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '0' .. '9' )* )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:395:4: '?' ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '0' .. '9' )*
			{
			match('?'); 
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:395:26: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' | '0' .. '9' )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0=='-'||(LA7_0 >= '0' && LA7_0 <= '9')||(LA7_0 >= 'A' && LA7_0 <= 'Z')||LA7_0=='_'||(LA7_0 >= 'a' && LA7_0 <= 'z')) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:
					{
					if ( input.LA(1)=='-'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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
					break loop7;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VARIABLE"

	@Override
	public void mTokens() throws RecognitionException {
		// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:8: ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | TRUE | FALSE | WS | COMMENT | NAME | INTEGER | REQUIRE_KEY | VARIABLE )
		int alt8=53;
		alt8 = dfa8.predict(input);
		switch (alt8) {
			case 1 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:10: T__12
				{
				mT__12(); 

				}
				break;
			case 2 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:16: T__13
				{
				mT__13(); 

				}
				break;
			case 3 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:22: T__14
				{
				mT__14(); 

				}
				break;
			case 4 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:28: T__15
				{
				mT__15(); 

				}
				break;
			case 5 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:34: T__16
				{
				mT__16(); 

				}
				break;
			case 6 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:40: T__17
				{
				mT__17(); 

				}
				break;
			case 7 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:46: T__18
				{
				mT__18(); 

				}
				break;
			case 8 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:52: T__19
				{
				mT__19(); 

				}
				break;
			case 9 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:58: T__20
				{
				mT__20(); 

				}
				break;
			case 10 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:64: T__21
				{
				mT__21(); 

				}
				break;
			case 11 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:70: T__22
				{
				mT__22(); 

				}
				break;
			case 12 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:76: T__23
				{
				mT__23(); 

				}
				break;
			case 13 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:82: T__24
				{
				mT__24(); 

				}
				break;
			case 14 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:88: T__25
				{
				mT__25(); 

				}
				break;
			case 15 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:94: T__26
				{
				mT__26(); 

				}
				break;
			case 16 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:100: T__27
				{
				mT__27(); 

				}
				break;
			case 17 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:106: T__28
				{
				mT__28(); 

				}
				break;
			case 18 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:112: T__29
				{
				mT__29(); 

				}
				break;
			case 19 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:118: T__30
				{
				mT__30(); 

				}
				break;
			case 20 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:124: T__31
				{
				mT__31(); 

				}
				break;
			case 21 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:130: T__32
				{
				mT__32(); 

				}
				break;
			case 22 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:136: T__33
				{
				mT__33(); 

				}
				break;
			case 23 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:142: T__34
				{
				mT__34(); 

				}
				break;
			case 24 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:148: T__35
				{
				mT__35(); 

				}
				break;
			case 25 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:154: T__36
				{
				mT__36(); 

				}
				break;
			case 26 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:160: T__37
				{
				mT__37(); 

				}
				break;
			case 27 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:166: T__38
				{
				mT__38(); 

				}
				break;
			case 28 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:172: T__39
				{
				mT__39(); 

				}
				break;
			case 29 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:178: T__40
				{
				mT__40(); 

				}
				break;
			case 30 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:184: T__41
				{
				mT__41(); 

				}
				break;
			case 31 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:190: T__42
				{
				mT__42(); 

				}
				break;
			case 32 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:196: T__43
				{
				mT__43(); 

				}
				break;
			case 33 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:202: T__44
				{
				mT__44(); 

				}
				break;
			case 34 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:208: T__45
				{
				mT__45(); 

				}
				break;
			case 35 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:214: T__46
				{
				mT__46(); 

				}
				break;
			case 36 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:220: T__47
				{
				mT__47(); 

				}
				break;
			case 37 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:226: T__48
				{
				mT__48(); 

				}
				break;
			case 38 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:232: T__49
				{
				mT__49(); 

				}
				break;
			case 39 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:238: T__50
				{
				mT__50(); 

				}
				break;
			case 40 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:244: T__51
				{
				mT__51(); 

				}
				break;
			case 41 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:250: T__52
				{
				mT__52(); 

				}
				break;
			case 42 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:256: T__53
				{
				mT__53(); 

				}
				break;
			case 43 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:262: T__54
				{
				mT__54(); 

				}
				break;
			case 44 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:268: T__55
				{
				mT__55(); 

				}
				break;
			case 45 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:274: T__56
				{
				mT__56(); 

				}
				break;
			case 46 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:280: TRUE
				{
				mTRUE(); 

				}
				break;
			case 47 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:285: FALSE
				{
				mFALSE(); 

				}
				break;
			case 48 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:291: WS
				{
				mWS(); 

				}
				break;
			case 49 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:294: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 50 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:302: NAME
				{
				mNAME(); 

				}
				break;
			case 51 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:307: INTEGER
				{
				mINTEGER(); 

				}
				break;
			case 52 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:315: REQUIRE_KEY
				{
				mREQUIRE_KEY(); 

				}
				break;
			case 53 :
				// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:1:327: VARIABLE
				{
				mVARIABLE(); 

				}
				break;

		}
	}


	protected DFA8 dfa8 = new DFA8(this);
	static final String DFA8_eotS =
		"\5\uffff\14\23\5\uffff\16\44\1\uffff\13\23\1\127\4\23\27\44\1\164\11\23"+
		"\1\176\1\uffff\4\23\30\44\1\uffff\11\23\1\uffff\2\23\1\u00a8\1\u00a9\10"+
		"\44\1\u00b2\1\44\1\u00b4\16\44\1\u00c4\7\23\1\u00cc\1\u00cd\2\23\2\uffff"+
		"\1\44\1\u00d1\6\44\1\uffff\1\44\1\uffff\16\44\1\u00e7\1\uffff\1\u00e8"+
		"\1\u00e9\1\u00ea\1\u00eb\1\u00ec\1\u00ed\1\u00ee\2\uffff\2\23\1\u00f1"+
		"\1\uffff\2\44\1\u00f5\1\u00f6\3\44\1\u00fa\1\44\1\u00fc\7\44\1\u0104\1"+
		"\u0105\2\44\10\uffff\1\u0108\1\23\1\uffff\1\44\1\u010b\1\44\2\uffff\1"+
		"\44\1\u010e\1\u010f\1\uffff\1\44\1\uffff\1\u0111\6\44\2\uffff\2\44\1\uffff"+
		"\1\23\1\44\1\uffff\2\44\2\uffff\1\u011e\1\uffff\1\44\1\u0120\5\44\1\u0126"+
		"\1\u0127\1\u0128\1\44\1\u012a\1\uffff\1\44\1\uffff\4\44\1\u0130\3\uffff"+
		"\1\44\1\uffff\1\44\1\u0133\1\44\1\u0135\1\44\1\uffff\2\44\1\uffff\1\44"+
		"\1\uffff\3\44\1\u013d\1\u013e\2\44\2\uffff\4\44\1\u0145\1\44\1\uffff\1"+
		"\44\1\u0148\1\uffff";
	static final String DFA8_eofS =
		"\u0149\uffff";
	static final String DFA8_minS =
		"\1\11\3\uffff\1\55\1\156\1\150\1\145\1\151\1\141\1\155\1\157\2\162\1\151"+
		"\1\150\1\162\5\uffff\1\143\2\157\1\146\1\157\1\155\1\145\1\141\1\142\1"+
		"\141\1\145\1\141\1\151\1\141\1\uffff\1\144\1\141\1\146\1\155\1\164\1\151"+
		"\1\165\1\162\1\154\1\160\1\164\1\55\1\157\1\164\1\145\1\165\1\164\1\151"+
		"\1\156\1\155\1\146\1\160\1\141\1\160\1\151\1\156\1\151\1\164\1\152\1\154"+
		"\1\162\1\145\1\161\1\146\1\162\1\164\1\155\1\160\1\162\1\55\1\156\1\151"+
		"\1\141\1\150\1\163\1\145\1\141\1\163\1\154\1\55\1\uffff\1\142\1\165\1"+
		"\156\1\145\1\151\1\157\1\163\1\141\1\145\1\141\1\145\2\154\1\164\1\147"+
		"\1\156\1\150\1\145\1\171\1\141\1\143\1\165\1\145\1\151\1\165\2\145\1\163"+
		"\1\uffff\1\147\1\156\1\151\1\145\1\164\1\156\1\154\1\145\1\171\1\uffff"+
		"\1\154\1\141\2\55\1\157\1\155\1\164\1\145\1\151\1\143\2\156\1\55\1\151"+
		"\1\55\2\164\1\157\1\143\1\55\1\154\1\157\2\151\1\164\2\141\1\154\1\163"+
		"\1\55\2\145\1\156\1\162\1\163\1\164\1\154\2\55\1\145\1\164\2\uffff\1\156"+
		"\1\55\1\141\1\170\1\156\1\164\1\163\1\144\1\uffff\1\145\1\uffff\1\150"+
		"\1\141\1\144\1\164\1\151\1\154\1\145\1\156\1\143\1\162\1\171\1\154\1\164"+
		"\1\145\1\55\1\uffff\7\55\2\uffff\1\155\1\151\1\55\1\uffff\1\156\1\164"+
		"\2\55\1\151\2\163\1\55\1\151\1\55\1\163\1\156\1\145\1\164\1\144\1\141"+
		"\1\145\2\55\1\151\1\163\10\uffff\1\55\1\157\1\uffff\1\164\1\55\1\166\2"+
		"\uffff\1\157\2\55\1\uffff\1\156\1\uffff\2\55\1\154\1\145\1\151\1\164\1"+
		"\155\2\uffff\1\157\1\163\1\uffff\1\156\1\163\1\uffff\1\141\1\156\2\uffff"+
		"\1\55\1\uffff\1\145\1\55\1\162\1\164\2\145\1\156\3\55\1\162\1\55\1\uffff"+
		"\1\170\1\uffff\1\163\1\151\1\163\1\156\1\55\3\uffff\1\151\1\uffff\1\160"+
		"\1\55\1\157\1\55\1\164\1\uffff\2\141\1\uffff\1\156\1\uffff\1\163\1\142"+
		"\1\156\2\55\1\154\1\163\2\uffff\1\145\1\151\1\163\1\157\1\55\1\156\1\uffff"+
		"\1\163\1\55\1\uffff";
	static final String DFA8_maxS =
		"\1\172\3\uffff\1\172\1\156\1\150\1\157\1\170\1\157\1\155\1\157\2\162\1"+
		"\151\1\150\1\162\5\uffff\1\170\2\157\1\170\1\157\1\156\2\145\1\156\1\162"+
		"\1\145\1\151\1\171\1\141\1\uffff\1\144\1\141\1\146\1\155\1\164\1\151\1"+
		"\165\1\162\1\154\1\160\1\164\1\172\1\157\1\164\1\145\1\165\1\164\1\151"+
		"\1\156\1\155\1\146\1\164\1\141\1\160\1\151\1\156\1\151\1\164\1\152\1\154"+
		"\1\162\1\145\1\161\1\146\1\162\1\164\1\155\1\160\1\162\1\172\1\156\1\151"+
		"\1\141\1\150\1\163\1\145\1\141\1\163\1\154\1\172\1\uffff\1\142\1\165\1"+
		"\156\1\145\1\151\1\157\1\164\1\141\1\145\1\141\1\145\2\154\1\164\1\147"+
		"\1\156\1\150\1\145\1\171\1\141\1\144\1\165\1\145\1\151\1\165\2\145\1\163"+
		"\1\uffff\1\147\1\156\1\151\1\145\1\164\1\156\1\154\1\145\1\171\1\uffff"+
		"\1\154\1\141\2\172\1\157\1\155\1\164\1\145\1\151\1\143\2\156\1\172\1\151"+
		"\1\172\2\164\1\157\1\143\1\55\1\155\1\157\2\151\1\164\2\141\1\154\1\163"+
		"\1\172\2\145\1\156\1\162\1\163\1\164\1\154\2\172\1\145\1\164\2\uffff\1"+
		"\156\1\172\1\141\1\170\1\156\1\164\1\163\1\144\1\uffff\1\145\1\uffff\1"+
		"\150\1\141\1\144\1\164\1\151\1\154\1\145\1\156\1\143\1\162\1\171\1\154"+
		"\1\164\1\145\1\172\1\uffff\7\172\2\uffff\1\155\1\151\1\172\1\uffff\1\156"+
		"\1\164\2\172\1\151\2\163\1\172\1\151\1\172\1\163\1\156\1\145\1\164\1\144"+
		"\1\141\1\145\2\172\1\151\1\163\10\uffff\1\172\1\157\1\uffff\1\164\1\172"+
		"\1\166\2\uffff\1\157\2\172\1\uffff\1\156\1\uffff\1\172\1\55\1\154\1\145"+
		"\1\151\1\164\1\155\2\uffff\1\157\1\163\1\uffff\1\156\1\163\1\uffff\1\141"+
		"\1\156\2\uffff\1\172\1\uffff\1\145\1\172\1\162\1\164\2\145\1\156\3\172"+
		"\1\162\1\172\1\uffff\1\170\1\uffff\1\163\1\151\1\163\1\156\1\172\3\uffff"+
		"\1\151\1\uffff\1\160\1\172\1\157\1\172\1\164\1\uffff\2\141\1\uffff\1\156"+
		"\1\uffff\1\163\1\142\1\156\2\172\1\154\1\163\2\uffff\1\145\1\151\1\163"+
		"\1\157\1\172\1\156\1\uffff\1\163\1\172\1\uffff";
	static final String DFA8_acceptS =
		"\1\uffff\1\1\1\2\1\3\15\uffff\1\60\1\61\1\62\1\63\1\65\16\uffff\1\64\62"+
		"\uffff\1\52\34\uffff\1\40\11\uffff\1\51\51\uffff\1\55\1\56\10\uffff\1"+
		"\15\1\uffff\1\17\17\uffff\1\37\7\uffff\1\57\1\50\3\uffff\1\5\25\uffff"+
		"\1\36\1\41\1\42\1\43\1\44\1\45\1\46\1\47\2\uffff\1\4\3\uffff\1\10\1\12"+
		"\3\uffff\1\20\1\uffff\1\22\7\uffff\1\32\1\33\2\uffff\1\53\2\uffff\1\7"+
		"\2\uffff\1\14\1\16\1\uffff\1\23\14\uffff\1\21\1\uffff\1\25\5\uffff\1\35"+
		"\1\54\1\6\1\uffff\1\13\5\uffff\1\34\2\uffff\1\26\1\uffff\1\30\7\uffff"+
		"\1\27\1\31\6\uffff\1\11\2\uffff\1\24";
	static final String DFA8_specialS =
		"\u0149\uffff}>";
	static final String[] DFA8_transitionS = {
			"\2\21\2\uffff\1\21\22\uffff\1\21\7\uffff\1\1\1\2\3\uffff\1\3\2\uffff"+
			"\12\24\1\4\1\22\3\uffff\1\25\1\uffff\32\23\6\uffff\1\5\1\23\1\6\1\7\1"+
			"\10\1\11\2\23\1\12\4\23\1\13\1\14\1\15\2\23\1\16\1\20\2\23\1\17\3\23",
			"",
			"",
			"",
			"\1\44\2\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\1\26\1\44\1\27"+
			"\1\30\1\31\1\44\1\32\1\44\1\33\2\44\1\34\1\35\1\44\1\36\1\37\1\44\1\40"+
			"\1\41\1\42\1\44\1\43\4\44",
			"\1\45",
			"\1\46",
			"\1\47\11\uffff\1\50",
			"\1\51\16\uffff\1\52",
			"\1\55\12\uffff\1\53\2\uffff\1\54",
			"\1\56",
			"\1\57",
			"\1\60",
			"\1\61",
			"\1\62",
			"\1\63",
			"\1\64",
			"",
			"",
			"",
			"",
			"",
			"\1\65\24\uffff\1\66",
			"\1\67",
			"\1\70",
			"\1\71\21\uffff\1\72",
			"\1\73",
			"\1\74\1\75",
			"\1\76",
			"\1\77\3\uffff\1\100",
			"\1\101\13\uffff\1\102",
			"\1\103\20\uffff\1\104",
			"\1\105",
			"\1\106\3\uffff\1\107\3\uffff\1\110",
			"\1\111\17\uffff\1\112",
			"\1\113",
			"",
			"\1\114",
			"\1\115",
			"\1\116",
			"\1\117",
			"\1\120",
			"\1\121",
			"\1\122",
			"\1\123",
			"\1\124",
			"\1\125",
			"\1\126",
			"\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"\1\130",
			"\1\131",
			"\1\132",
			"\1\133",
			"\1\134",
			"\1\135",
			"\1\136",
			"\1\137",
			"\1\140",
			"\1\141\3\uffff\1\142",
			"\1\143",
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
			"\1\162",
			"\1\163",
			"\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"\1\165",
			"\1\166",
			"\1\167",
			"\1\170",
			"\1\171",
			"\1\172",
			"\1\173",
			"\1\174",
			"\1\175",
			"\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"",
			"\1\177",
			"\1\u0080",
			"\1\u0081",
			"\1\u0082",
			"\1\u0083",
			"\1\u0084",
			"\1\u0085\1\u0086",
			"\1\u0087",
			"\1\u0088",
			"\1\u0089",
			"\1\u008a",
			"\1\u008b",
			"\1\u008c",
			"\1\u008d",
			"\1\u008e",
			"\1\u008f",
			"\1\u0090",
			"\1\u0091",
			"\1\u0092",
			"\1\u0093",
			"\1\u0094\1\u0095",
			"\1\u0096",
			"\1\u0097",
			"\1\u0098",
			"\1\u0099",
			"\1\u009a",
			"\1\u009b",
			"\1\u009c",
			"",
			"\1\u009d",
			"\1\u009e",
			"\1\u009f",
			"\1\u00a0",
			"\1\u00a1",
			"\1\u00a2",
			"\1\u00a3",
			"\1\u00a4",
			"\1\u00a5",
			"",
			"\1\u00a6",
			"\1\u00a7",
			"\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"\1\u00aa",
			"\1\u00ab",
			"\1\u00ac",
			"\1\u00ad",
			"\1\u00ae",
			"\1\u00af",
			"\1\u00b0",
			"\1\u00b1",
			"\1\44\2\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\u00b3",
			"\1\44\2\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\u00b5",
			"\1\u00b6",
			"\1\u00b7",
			"\1\u00b8",
			"\1\u00b9",
			"\1\u00ba\1\u00bb",
			"\1\u00bc",
			"\1\u00bd",
			"\1\u00be",
			"\1\u00bf",
			"\1\u00c0",
			"\1\u00c1",
			"\1\u00c2",
			"\1\u00c3",
			"\1\44\2\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\u00c5",
			"\1\u00c6",
			"\1\u00c7",
			"\1\u00c8",
			"\1\u00c9",
			"\1\u00ca",
			"\1\u00cb",
			"\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"\1\u00ce",
			"\1\u00cf",
			"",
			"",
			"\1\u00d0",
			"\1\44\2\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\u00d2",
			"\1\u00d3",
			"\1\u00d4",
			"\1\u00d5",
			"\1\u00d6",
			"\1\u00d7",
			"",
			"\1\u00d8",
			"",
			"\1\u00d9",
			"\1\u00da",
			"\1\u00db",
			"\1\u00dc",
			"\1\u00dd",
			"\1\u00de",
			"\1\u00df",
			"\1\u00e0",
			"\1\u00e1",
			"\1\u00e2",
			"\1\u00e3",
			"\1\u00e4",
			"\1\u00e5",
			"\1\u00e6",
			"\1\44\2\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"",
			"\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"",
			"",
			"\1\u00ef",
			"\1\u00f0",
			"\1\44\2\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"",
			"\1\u00f2",
			"\1\u00f3",
			"\1\u00f4\2\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\44\2\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\u00f7",
			"\1\u00f8",
			"\1\u00f9",
			"\1\44\2\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\u00fb",
			"\1\44\2\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\u00fd",
			"\1\u00fe",
			"\1\u00ff",
			"\1\u0100",
			"\1\u0101",
			"\1\u0102",
			"\1\u0103",
			"\1\44\2\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\44\2\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\u0106",
			"\1\u0107",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"\1\u0109",
			"",
			"\1\u010a",
			"\1\44\2\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\u010c",
			"",
			"",
			"\1\u010d",
			"\1\44\2\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\44\2\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"",
			"\1\u0110",
			"",
			"\1\44\2\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\u0112",
			"\1\u0113",
			"\1\u0114",
			"\1\u0115",
			"\1\u0116",
			"\1\u0117",
			"",
			"",
			"\1\u0118",
			"\1\u0119",
			"",
			"\1\u011a",
			"\1\u011b",
			"",
			"\1\u011c",
			"\1\u011d",
			"",
			"",
			"\1\44\2\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"",
			"\1\u011f",
			"\1\44\2\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\u0121",
			"\1\u0122",
			"\1\u0123",
			"\1\u0124",
			"\1\u0125",
			"\1\44\2\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
			"\1\44\2\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\u0129",
			"\1\44\2\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"",
			"\1\u012b",
			"",
			"\1\u012c",
			"\1\u012d",
			"\1\u012e",
			"\1\u012f",
			"\1\44\2\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"",
			"",
			"",
			"\1\u0131",
			"",
			"\1\u0132",
			"\1\44\2\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\u0134",
			"\1\44\2\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\u0136",
			"",
			"\1\u0137",
			"\1\u0138",
			"",
			"\1\u0139",
			"",
			"\1\u013a",
			"\1\u013b",
			"\1\u013c",
			"\1\44\2\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\44\2\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\u013f",
			"\1\u0140",
			"",
			"",
			"\1\u0141",
			"\1\u0142",
			"\1\u0143",
			"\1\u0144",
			"\1\44\2\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			"\1\u0146",
			"",
			"\1\u0147",
			"\1\44\2\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
			""
	};

	static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
	static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
	static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
	static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
	static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
	static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
	static final short[][] DFA8_transition;

	static {
		int numStates = DFA8_transitionS.length;
		DFA8_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
		}
	}

	protected class DFA8 extends DFA {

		public DFA8(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 8;
			this.eot = DFA8_eot;
			this.eof = DFA8_eof;
			this.min = DFA8_min;
			this.max = DFA8_max;
			this.accept = DFA8_accept;
			this.special = DFA8_special;
			this.transition = DFA8_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | TRUE | FALSE | WS | COMMENT | NAME | INTEGER | REQUIRE_KEY | VARIABLE );";
		}
	}

}
