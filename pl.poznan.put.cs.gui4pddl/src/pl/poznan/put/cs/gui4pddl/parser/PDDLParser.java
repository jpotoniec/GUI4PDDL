// $ANTLR 3.5 /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g 2013-10-26 21:34:31

	package pl.poznan.put.cs.gui4pddl.parser;
	
	import java.util.LinkedList;
	import java.util.List;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PDDLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "FALSE", "INTEGER", 
		"NAME", "REQUIRE_KEY", "TRUE", "VARIABLE", "WS", "'('", "')'", "'-'", 
		"':action'", "':axiom'", "':constants'", "':context'", "':domain'", "':domain-variables'", 
		"':effect'", "':expansion'", "':extends'", "':goal'", "':implies'", "':init'", 
		"':length'", "':maintain'", "':method'", "':objects'", "':only-in-expansions'", 
		"':parallel'", "':parameters'", "':precondition'", "':predicates'", "':requirements'", 
		"':safety'", "':serial'", "':situation'", "':timeless'", "':types'", "':vars'", 
		"'and'", "'change'", "'define'", "'domain'", "'either'", "'exists'", "'fluent'", 
		"'forall'", "'imply'", "'not'", "'or'", "'problem'", "'situation'", "'when'"
	};
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
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public PDDLParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public PDDLParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return PDDLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g"; }


	    private List<PDDLError> errors = new LinkedList<PDDLError>();
	    public void displayRecognitionError(String[] tokenNames,
	                                        RecognitionException e) {
	        String hdr = getErrorHeader(e);
	        String msg = getErrorMessage(e, tokenNames);
	        PDDLError error = new PDDLError();
	        error.message = hdr + " " + msg;
	        error.line = e.line;
	        error.charPositionInLine = e.charPositionInLine;
	        errors.add(error);
	    }
	    public List<PDDLError> getErrors() {
	        return errors;
	    }
	    protected void exitSubtree(IntStream input) {
	    	int level = 0;
	    	int ttype = input.LA(1);
	    	while (ttype != Token.EOF) {
	    		if (ttype == 10) { // '('
	    		    level++;
	    		} else if (ttype == 11) { // ')'
	    			level--;
	    			if (level == 0) {
	    			    input.consume();
	    			    break;
	    			}
	    		}
	    		
	    		input.consume();
	    		ttype = input.LA(1);
	    	}
	    }
	    public void recover(IntStream input,
	           RecognitionException re) {
	           
	           if (re instanceof NoViableAltException ) {
			       exitSubtree(input);
			       
			       //consumeUntil(input, 11)
			       //input.consume();
		       } else {
			       super.recover(input,re);
		       }
	    }



	// $ANTLR start "pddl_file"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:61:1: pddl_file : ( definition )* ;
	public final void pddl_file() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:62:5: ( ( definition )* )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:62:10: ( definition )*
			{
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:62:10: ( definition )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==12) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:62:10: definition
					{
					pushFollow(FOLLOW_definition_in_pddl_file38);
					definition();
					state._fsp--;

					}
					break;

				default :
					break loop1;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "pddl_file"



	// $ANTLR start "definition"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:65:1: definition : ( '(' 'define' problem_header ( problem_item )* ')' | '(' 'define' domain_header ( domain_item )* ')' | '(' 'define' initsit_header initsit_body ')' );
	public final void definition() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:66:2: ( '(' 'define' problem_header ( problem_item )* ')' | '(' 'define' domain_header ( domain_item )* ')' | '(' 'define' initsit_header initsit_body ')' )
			int alt4=3;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==12) ) {
				int LA4_1 = input.LA(2);
				if ( (LA4_1==45) ) {
					int LA4_2 = input.LA(3);
					if ( (LA4_2==12) ) {
						switch ( input.LA(4) ) {
						case 54:
							{
							alt4=1;
							}
							break;
						case 46:
							{
							alt4=2;
							}
							break;
						case 55:
							{
							alt4=3;
							}
							break;
						default:
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 4, 3, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 4, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 4, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:66:4: '(' 'define' problem_header ( problem_item )* ')'
					{
					match(input,12,FOLLOW_12_in_definition54); 
					match(input,45,FOLLOW_45_in_definition56); 
					pushFollow(FOLLOW_problem_header_in_definition58);
					problem_header();
					state._fsp--;

					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:66:32: ( problem_item )*
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( (LA2_0==12) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:66:32: problem_item
							{
							pushFollow(FOLLOW_problem_item_in_definition60);
							problem_item();
							state._fsp--;

							}
							break;

						default :
							break loop2;
						}
					}

					match(input,13,FOLLOW_13_in_definition63); 
					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:67:4: '(' 'define' domain_header ( domain_item )* ')'
					{
					match(input,12,FOLLOW_12_in_definition68); 
					match(input,45,FOLLOW_45_in_definition70); 
					pushFollow(FOLLOW_domain_header_in_definition72);
					domain_header();
					state._fsp--;

					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:67:31: ( domain_item )*
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( (LA3_0==12) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:67:31: domain_item
							{
							pushFollow(FOLLOW_domain_item_in_definition74);
							domain_item();
							state._fsp--;

							}
							break;

						default :
							break loop3;
						}
					}

					match(input,13,FOLLOW_13_in_definition77); 
					}
					break;
				case 3 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:68:6: '(' 'define' initsit_header initsit_body ')'
					{
					match(input,12,FOLLOW_12_in_definition84); 
					match(input,45,FOLLOW_45_in_definition86); 
					pushFollow(FOLLOW_initsit_header_in_definition88);
					initsit_header();
					state._fsp--;

					pushFollow(FOLLOW_initsit_body_in_definition90);
					initsit_body();
					state._fsp--;

					match(input,13,FOLLOW_13_in_definition92); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "definition"



	// $ANTLR start "domain_header"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:75:1: domain_header : '(' 'domain' NAME ')' ;
	public final void domain_header() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:76:2: ( '(' 'domain' NAME ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:76:4: '(' 'domain' NAME ')'
			{
			match(input,12,FOLLOW_12_in_domain_header107); 
			match(input,46,FOLLOW_46_in_domain_header109); 
			match(input,NAME,FOLLOW_NAME_in_domain_header111); 
			match(input,13,FOLLOW_13_in_domain_header113); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "domain_header"



	// $ANTLR start "domain_item"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:79:1: domain_item : ( extension_def | require_def | types_def | constants_def | domain_vars_def | predicates_def | timeless_def | safety_def | structure_def );
	public final void domain_item() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:80:2: ( extension_def | require_def | types_def | constants_def | domain_vars_def | predicates_def | timeless_def | safety_def | structure_def )
			int alt5=9;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==12) ) {
				switch ( input.LA(2) ) {
				case 23:
					{
					alt5=1;
					}
					break;
				case 36:
					{
					alt5=2;
					}
					break;
				case 41:
					{
					alt5=3;
					}
					break;
				case 17:
					{
					alt5=4;
					}
					break;
				case 20:
					{
					alt5=5;
					}
					break;
				case 35:
					{
					alt5=6;
					}
					break;
				case 40:
					{
					alt5=7;
					}
					break;
				case 37:
					{
					alt5=8;
					}
					break;
				case 15:
				case 16:
				case 29:
					{
					alt5=9;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 5, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:80:4: extension_def
					{
					pushFollow(FOLLOW_extension_def_in_domain_item124);
					extension_def();
					state._fsp--;

					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:81:4: require_def
					{
					pushFollow(FOLLOW_require_def_in_domain_item129);
					require_def();
					state._fsp--;

					}
					break;
				case 3 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:82:4: types_def
					{
					pushFollow(FOLLOW_types_def_in_domain_item134);
					types_def();
					state._fsp--;

					}
					break;
				case 4 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:83:4: constants_def
					{
					pushFollow(FOLLOW_constants_def_in_domain_item141);
					constants_def();
					state._fsp--;

					}
					break;
				case 5 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:84:4: domain_vars_def
					{
					pushFollow(FOLLOW_domain_vars_def_in_domain_item146);
					domain_vars_def();
					state._fsp--;

					}
					break;
				case 6 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:85:4: predicates_def
					{
					pushFollow(FOLLOW_predicates_def_in_domain_item152);
					predicates_def();
					state._fsp--;

					}
					break;
				case 7 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:86:4: timeless_def
					{
					pushFollow(FOLLOW_timeless_def_in_domain_item157);
					timeless_def();
					state._fsp--;

					}
					break;
				case 8 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:87:4: safety_def
					{
					pushFollow(FOLLOW_safety_def_in_domain_item162);
					safety_def();
					state._fsp--;

					}
					break;
				case 9 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:88:4: structure_def
					{
					pushFollow(FOLLOW_structure_def_in_domain_item168);
					structure_def();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "domain_item"



	// $ANTLR start "extension_def"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:91:1: extension_def : '(' ':extends' ( NAME )+ ')' ;
	public final void extension_def() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:92:2: ( '(' ':extends' ( NAME )+ ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:92:4: '(' ':extends' ( NAME )+ ')'
			{
			match(input,12,FOLLOW_12_in_extension_def181); 
			match(input,23,FOLLOW_23_in_extension_def183); 
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:92:19: ( NAME )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==NAME) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:92:19: NAME
					{
					match(input,NAME,FOLLOW_NAME_in_extension_def185); 
					}
					break;

				default :
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
			}

			match(input,13,FOLLOW_13_in_extension_def188); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "extension_def"



	// $ANTLR start "types_def"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:95:1: types_def : '(' ':types' typed_list_of_name ')' ;
	public final void types_def() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:96:2: ( '(' ':types' typed_list_of_name ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:96:4: '(' ':types' typed_list_of_name ')'
			{
			match(input,12,FOLLOW_12_in_types_def201); 
			match(input,41,FOLLOW_41_in_types_def203); 
			pushFollow(FOLLOW_typed_list_of_name_in_types_def205);
			typed_list_of_name();
			state._fsp--;

			match(input,13,FOLLOW_13_in_types_def207); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "types_def"



	// $ANTLR start "constants_def"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:99:1: constants_def : '(' ':constants' typed_list_of_name ')' ;
	public final void constants_def() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:100:2: ( '(' ':constants' typed_list_of_name ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:100:4: '(' ':constants' typed_list_of_name ')'
			{
			match(input,12,FOLLOW_12_in_constants_def219); 
			match(input,17,FOLLOW_17_in_constants_def221); 
			pushFollow(FOLLOW_typed_list_of_name_in_constants_def223);
			typed_list_of_name();
			state._fsp--;

			match(input,13,FOLLOW_13_in_constants_def225); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "constants_def"



	// $ANTLR start "domain_vars_def"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:103:1: domain_vars_def : '(' ':domain-variables' typed_list_of_domain_var_declaration ')' ;
	public final void domain_vars_def() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:104:2: ( '(' ':domain-variables' typed_list_of_domain_var_declaration ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:104:4: '(' ':domain-variables' typed_list_of_domain_var_declaration ')'
			{
			match(input,12,FOLLOW_12_in_domain_vars_def236); 
			match(input,20,FOLLOW_20_in_domain_vars_def238); 
			pushFollow(FOLLOW_typed_list_of_domain_var_declaration_in_domain_vars_def240);
			typed_list_of_domain_var_declaration();
			state._fsp--;

			match(input,13,FOLLOW_13_in_domain_vars_def242); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "domain_vars_def"



	// $ANTLR start "predicates_def"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:107:1: predicates_def : '(' ':predicates' ( atomic_formula_skeleton )+ ')' ;
	public final void predicates_def() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:108:2: ( '(' ':predicates' ( atomic_formula_skeleton )+ ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:108:4: '(' ':predicates' ( atomic_formula_skeleton )+ ')'
			{
			match(input,12,FOLLOW_12_in_predicates_def254); 
			match(input,35,FOLLOW_35_in_predicates_def256); 
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:108:22: ( atomic_formula_skeleton )+
			int cnt7=0;
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==12) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:108:22: atomic_formula_skeleton
					{
					pushFollow(FOLLOW_atomic_formula_skeleton_in_predicates_def258);
					atomic_formula_skeleton();
					state._fsp--;

					}
					break;

				default :
					if ( cnt7 >= 1 ) break loop7;
					EarlyExitException eee = new EarlyExitException(7, input);
					throw eee;
				}
				cnt7++;
			}

			match(input,13,FOLLOW_13_in_predicates_def261); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "predicates_def"



	// $ANTLR start "timeless_def"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:111:1: timeless_def : '(' ':timeless' ( literal_of_name )+ ')' ;
	public final void timeless_def() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:112:2: ( '(' ':timeless' ( literal_of_name )+ ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:112:4: '(' ':timeless' ( literal_of_name )+ ')'
			{
			match(input,12,FOLLOW_12_in_timeless_def272); 
			match(input,40,FOLLOW_40_in_timeless_def274); 
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:112:20: ( literal_of_name )+
			int cnt8=0;
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==12) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:112:20: literal_of_name
					{
					pushFollow(FOLLOW_literal_of_name_in_timeless_def276);
					literal_of_name();
					state._fsp--;

					}
					break;

				default :
					if ( cnt8 >= 1 ) break loop8;
					EarlyExitException eee = new EarlyExitException(8, input);
					throw eee;
				}
				cnt8++;
			}

			match(input,13,FOLLOW_13_in_timeless_def279); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "timeless_def"



	// $ANTLR start "safety_def"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:115:1: safety_def : '(' ':safety' gd ')' ;
	public final void safety_def() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:116:2: ( '(' ':safety' gd ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:116:4: '(' ':safety' gd ')'
			{
			match(input,12,FOLLOW_12_in_safety_def292); 
			match(input,37,FOLLOW_37_in_safety_def294); 
			pushFollow(FOLLOW_gd_in_safety_def296);
			gd();
			state._fsp--;

			match(input,13,FOLLOW_13_in_safety_def298); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "safety_def"



	// $ANTLR start "structure_def"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:119:1: structure_def : ( action_def | axiom_def | method_def );
	public final void structure_def() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:120:2: ( action_def | axiom_def | method_def )
			int alt9=3;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==12) ) {
				switch ( input.LA(2) ) {
				case 15:
					{
					alt9=1;
					}
					break;
				case 16:
					{
					alt9=2;
					}
					break;
				case 29:
					{
					alt9=3;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 9, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:120:4: action_def
					{
					pushFollow(FOLLOW_action_def_in_structure_def311);
					action_def();
					state._fsp--;

					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:121:4: axiom_def
					{
					pushFollow(FOLLOW_axiom_def_in_structure_def316);
					axiom_def();
					state._fsp--;

					}
					break;
				case 3 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:122:4: method_def
					{
					pushFollow(FOLLOW_method_def_in_structure_def322);
					method_def();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "structure_def"



	// $ANTLR start "action_def"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:128:1: action_def : '(' ':action' action_functor ':parameters' '(' typed_list_of_variable ')' action_def_body ')' ;
	public final void action_def() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:129:2: ( '(' ':action' action_functor ':parameters' '(' typed_list_of_variable ')' action_def_body ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:129:4: '(' ':action' action_functor ':parameters' '(' typed_list_of_variable ')' action_def_body ')'
			{
			match(input,12,FOLLOW_12_in_action_def338); 
			match(input,15,FOLLOW_15_in_action_def340); 
			pushFollow(FOLLOW_action_functor_in_action_def342);
			action_functor();
			state._fsp--;

			match(input,33,FOLLOW_33_in_action_def347); 
			match(input,12,FOLLOW_12_in_action_def349); 
			pushFollow(FOLLOW_typed_list_of_variable_in_action_def351);
			typed_list_of_variable();
			state._fsp--;

			match(input,13,FOLLOW_13_in_action_def353); 
			pushFollow(FOLLOW_action_def_body_in_action_def358);
			action_def_body();
			state._fsp--;

			match(input,13,FOLLOW_13_in_action_def360); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "action_def"



	// $ANTLR start "action_functor"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:134:1: action_functor : NAME ;
	public final void action_functor() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:135:2: ( NAME )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:135:7: NAME
			{
			match(input,NAME,FOLLOW_NAME_in_action_functor375); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "action_functor"



	// $ANTLR start "action_def_body"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:138:1: action_def_body : ( action_def_body_item )* ;
	public final void action_def_body() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:139:5: ( ( action_def_body_item )* )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:139:10: ( action_def_body_item )*
			{
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:139:10: ( action_def_body_item )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( ((LA10_0 >= 21 && LA10_0 <= 22)||LA10_0==28||LA10_0==31||LA10_0==34||LA10_0==42) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:139:10: action_def_body_item
					{
					pushFollow(FOLLOW_action_def_body_item_in_action_def_body393);
					action_def_body_item();
					state._fsp--;

					}
					break;

				default :
					break loop10;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "action_def_body"



	// $ANTLR start "action_def_body_item"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:142:1: action_def_body_item : ( ':vars' '(' typed_list_of_variable ')' | ':precondition' gd | ':expansion' action_spec | ':maintain' gd | ':effect' effect | ':only-in-expansions' boolean_type );
	public final void action_def_body_item() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:143:5: ( ':vars' '(' typed_list_of_variable ')' | ':precondition' gd | ':expansion' action_spec | ':maintain' gd | ':effect' effect | ':only-in-expansions' boolean_type )
			int alt11=6;
			switch ( input.LA(1) ) {
			case 42:
				{
				alt11=1;
				}
				break;
			case 34:
				{
				alt11=2;
				}
				break;
			case 22:
				{
				alt11=3;
				}
				break;
			case 28:
				{
				alt11=4;
				}
				break;
			case 21:
				{
				alt11=5;
				}
				break;
			case 31:
				{
				alt11=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}
			switch (alt11) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:143:10: ':vars' '(' typed_list_of_variable ')'
					{
					match(input,42,FOLLOW_42_in_action_def_body_item418); 
					match(input,12,FOLLOW_12_in_action_def_body_item420); 
					pushFollow(FOLLOW_typed_list_of_variable_in_action_def_body_item422);
					typed_list_of_variable();
					state._fsp--;

					match(input,13,FOLLOW_13_in_action_def_body_item424); 
					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:144:10: ':precondition' gd
					{
					match(input,34,FOLLOW_34_in_action_def_body_item436); 
					pushFollow(FOLLOW_gd_in_action_def_body_item438);
					gd();
					state._fsp--;

					}
					break;
				case 3 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:145:10: ':expansion' action_spec
					{
					match(input,22,FOLLOW_22_in_action_def_body_item449); 
					pushFollow(FOLLOW_action_spec_in_action_def_body_item451);
					action_spec();
					state._fsp--;

					}
					break;
				case 4 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:146:10: ':maintain' gd
					{
					match(input,28,FOLLOW_28_in_action_def_body_item469); 
					pushFollow(FOLLOW_gd_in_action_def_body_item471);
					gd();
					state._fsp--;

					}
					break;
				case 5 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:147:10: ':effect' effect
					{
					match(input,21,FOLLOW_21_in_action_def_body_item500); 
					pushFollow(FOLLOW_effect_in_action_def_body_item502);
					effect();
					state._fsp--;

					}
					break;
				case 6 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:148:10: ':only-in-expansions' boolean_type
					{
					match(input,31,FOLLOW_31_in_action_def_body_item513); 
					pushFollow(FOLLOW_boolean_type_in_action_def_body_item515);
					boolean_type();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "action_def_body_item"



	// $ANTLR start "effect"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:154:1: effect : ( '(' 'and' ( effect )* ')' | '(' 'not' atomic_formula_of_term ')' | atomic_formula_of_term | '(' 'forall' '(' ( VARIABLE )* ')' effect ')' | '(' 'when' gd effect ')' | '(' 'change' fluent expression ')' );
	public final void effect() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:155:5: ( '(' 'and' ( effect )* ')' | '(' 'not' atomic_formula_of_term ')' | atomic_formula_of_term | '(' 'forall' '(' ( VARIABLE )* ')' effect ')' | '(' 'when' gd effect ')' | '(' 'change' fluent expression ')' )
			int alt14=6;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==12) ) {
				switch ( input.LA(2) ) {
				case 43:
					{
					alt14=1;
					}
					break;
				case 52:
					{
					alt14=2;
					}
					break;
				case 50:
					{
					alt14=4;
					}
					break;
				case 56:
					{
					alt14=5;
					}
					break;
				case 44:
					{
					alt14=6;
					}
					break;
				case NAME:
					{
					alt14=3;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 14, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}

			switch (alt14) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:155:10: '(' 'and' ( effect )* ')'
					{
					match(input,12,FOLLOW_12_in_effect539); 
					match(input,43,FOLLOW_43_in_effect541); 
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:155:20: ( effect )*
					loop12:
					while (true) {
						int alt12=2;
						int LA12_0 = input.LA(1);
						if ( (LA12_0==12) ) {
							alt12=1;
						}

						switch (alt12) {
						case 1 :
							// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:155:20: effect
							{
							pushFollow(FOLLOW_effect_in_effect543);
							effect();
							state._fsp--;

							}
							break;

						default :
							break loop12;
						}
					}

					match(input,13,FOLLOW_13_in_effect546); 
					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:156:10: '(' 'not' atomic_formula_of_term ')'
					{
					match(input,12,FOLLOW_12_in_effect557); 
					match(input,52,FOLLOW_52_in_effect559); 
					pushFollow(FOLLOW_atomic_formula_of_term_in_effect561);
					atomic_formula_of_term();
					state._fsp--;

					match(input,13,FOLLOW_13_in_effect563); 
					}
					break;
				case 3 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:157:10: atomic_formula_of_term
					{
					pushFollow(FOLLOW_atomic_formula_of_term_in_effect574);
					atomic_formula_of_term();
					state._fsp--;

					}
					break;
				case 4 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:158:10: '(' 'forall' '(' ( VARIABLE )* ')' effect ')'
					{
					match(input,12,FOLLOW_12_in_effect585); 
					match(input,50,FOLLOW_50_in_effect587); 
					match(input,12,FOLLOW_12_in_effect589); 
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:158:27: ( VARIABLE )*
					loop13:
					while (true) {
						int alt13=2;
						int LA13_0 = input.LA(1);
						if ( (LA13_0==VARIABLE) ) {
							alt13=1;
						}

						switch (alt13) {
						case 1 :
							// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:158:27: VARIABLE
							{
							match(input,VARIABLE,FOLLOW_VARIABLE_in_effect591); 
							}
							break;

						default :
							break loop13;
						}
					}

					match(input,13,FOLLOW_13_in_effect594); 
					pushFollow(FOLLOW_effect_in_effect596);
					effect();
					state._fsp--;

					match(input,13,FOLLOW_13_in_effect598); 
					}
					break;
				case 5 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:159:10: '(' 'when' gd effect ')'
					{
					match(input,12,FOLLOW_12_in_effect610); 
					match(input,56,FOLLOW_56_in_effect612); 
					pushFollow(FOLLOW_gd_in_effect614);
					gd();
					state._fsp--;

					pushFollow(FOLLOW_effect_in_effect616);
					effect();
					state._fsp--;

					match(input,13,FOLLOW_13_in_effect618); 
					}
					break;
				case 6 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:160:10: '(' 'change' fluent expression ')'
					{
					match(input,12,FOLLOW_12_in_effect630); 
					match(input,44,FOLLOW_44_in_effect632); 
					pushFollow(FOLLOW_fluent_in_effect634);
					fluent();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_effect636);
					expression();
					state._fsp--;

					match(input,13,FOLLOW_13_in_effect638); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "effect"



	// $ANTLR start "fluent"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:163:1: fluent : general_tree_item ;
	public final void fluent() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:164:5: ( general_tree_item )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:164:10: general_tree_item
			{
			pushFollow(FOLLOW_general_tree_item_in_fluent660);
			general_tree_item();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "fluent"



	// $ANTLR start "expression"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:167:1: expression : general_tree_item ;
	public final void expression() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:168:5: ( general_tree_item )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:168:10: general_tree_item
			{
			pushFollow(FOLLOW_general_tree_item_in_expression684);
			general_tree_item();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "expression"



	// $ANTLR start "action_spec"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:175:1: action_spec : general_tree ;
	public final void action_spec() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:176:5: ( general_tree )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:176:10: general_tree
			{
			pushFollow(FOLLOW_general_tree_in_action_spec707);
			general_tree();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "action_spec"



	// $ANTLR start "action_spec_od_action_term"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:179:1: action_spec_od_action_term : general_tree ;
	public final void action_spec_od_action_term() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:180:2: ( general_tree )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:180:4: general_tree
			{
			pushFollow(FOLLOW_general_tree_in_action_spec_od_action_term722);
			general_tree();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "action_spec_od_action_term"



	// $ANTLR start "axiom_def"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:187:1: axiom_def : '(' ':axiom' ':vars' '(' typed_list_of_variable ')' ':context' gd ':implies' literal_of_term ')' ;
	public final void axiom_def() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:188:2: ( '(' ':axiom' ':vars' '(' typed_list_of_variable ')' ':context' gd ':implies' literal_of_term ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:188:4: '(' ':axiom' ':vars' '(' typed_list_of_variable ')' ':context' gd ':implies' literal_of_term ')'
			{
			match(input,12,FOLLOW_12_in_axiom_def738); 
			match(input,16,FOLLOW_16_in_axiom_def740); 
			match(input,42,FOLLOW_42_in_axiom_def752); 
			match(input,12,FOLLOW_12_in_axiom_def754); 
			pushFollow(FOLLOW_typed_list_of_variable_in_axiom_def756);
			typed_list_of_variable();
			state._fsp--;

			match(input,13,FOLLOW_13_in_axiom_def758); 
			match(input,18,FOLLOW_18_in_axiom_def769); 
			pushFollow(FOLLOW_gd_in_axiom_def771);
			gd();
			state._fsp--;

			match(input,25,FOLLOW_25_in_axiom_def782); 
			pushFollow(FOLLOW_literal_of_term_in_axiom_def784);
			literal_of_term();
			state._fsp--;

			match(input,13,FOLLOW_13_in_axiom_def786); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "axiom_def"



	// $ANTLR start "problem_header"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:202:1: problem_header : '(' 'problem' NAME ')' ;
	public final void problem_header() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:202:16: ( '(' 'problem' NAME ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:202:18: '(' 'problem' NAME ')'
			{
			match(input,12,FOLLOW_12_in_problem_header805); 
			match(input,54,FOLLOW_54_in_problem_header807); 
			match(input,NAME,FOLLOW_NAME_in_problem_header809); 
			match(input,13,FOLLOW_13_in_problem_header811); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "problem_header"



	// $ANTLR start "problem_item"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:205:1: problem_item : ( domain_reference | require_def | situation | object_declaration | init | goal | length_spec );
	public final void problem_item() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:206:2: ( domain_reference | require_def | situation | object_declaration | init | goal | length_spec )
			int alt15=7;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==12) ) {
				switch ( input.LA(2) ) {
				case 19:
					{
					alt15=1;
					}
					break;
				case 36:
					{
					alt15=2;
					}
					break;
				case 39:
					{
					alt15=3;
					}
					break;
				case 30:
					{
					alt15=4;
					}
					break;
				case 26:
					{
					alt15=5;
					}
					break;
				case 22:
				case 24:
					{
					alt15=6;
					}
					break;
				case 27:
					{
					alt15=7;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 15, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}

			switch (alt15) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:206:4: domain_reference
					{
					pushFollow(FOLLOW_domain_reference_in_problem_item825);
					domain_reference();
					state._fsp--;

					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:207:4: require_def
					{
					pushFollow(FOLLOW_require_def_in_problem_item830);
					require_def();
					state._fsp--;

					}
					break;
				case 3 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:208:4: situation
					{
					pushFollow(FOLLOW_situation_in_problem_item835);
					situation();
					state._fsp--;

					}
					break;
				case 4 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:209:4: object_declaration
					{
					pushFollow(FOLLOW_object_declaration_in_problem_item840);
					object_declaration();
					state._fsp--;

					}
					break;
				case 5 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:210:4: init
					{
					pushFollow(FOLLOW_init_in_problem_item845);
					init();
					state._fsp--;

					}
					break;
				case 6 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:211:4: goal
					{
					pushFollow(FOLLOW_goal_in_problem_item850);
					goal();
					state._fsp--;

					}
					break;
				case 7 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:212:4: length_spec
					{
					pushFollow(FOLLOW_length_spec_in_problem_item855);
					length_spec();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "problem_item"



	// $ANTLR start "domain_reference"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:215:1: domain_reference : '(' ':domain' NAME ')' ;
	public final void domain_reference() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:216:2: ( '(' ':domain' NAME ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:216:4: '(' ':domain' NAME ')'
			{
			match(input,12,FOLLOW_12_in_domain_reference867); 
			match(input,19,FOLLOW_19_in_domain_reference869); 
			match(input,NAME,FOLLOW_NAME_in_domain_reference871); 
			match(input,13,FOLLOW_13_in_domain_reference873); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "domain_reference"



	// $ANTLR start "require_def"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:219:1: require_def : '(' ':requirements' ( REQUIRE_KEY )+ ')' ;
	public final void require_def() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:220:2: ( '(' ':requirements' ( REQUIRE_KEY )+ ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:220:4: '(' ':requirements' ( REQUIRE_KEY )+ ')'
			{
			match(input,12,FOLLOW_12_in_require_def885); 
			match(input,36,FOLLOW_36_in_require_def887); 
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:220:24: ( REQUIRE_KEY )+
			int cnt16=0;
			loop16:
			while (true) {
				int alt16=2;
				int LA16_0 = input.LA(1);
				if ( (LA16_0==REQUIRE_KEY) ) {
					alt16=1;
				}

				switch (alt16) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:220:24: REQUIRE_KEY
					{
					match(input,REQUIRE_KEY,FOLLOW_REQUIRE_KEY_in_require_def889); 
					}
					break;

				default :
					if ( cnt16 >= 1 ) break loop16;
					EarlyExitException eee = new EarlyExitException(16, input);
					throw eee;
				}
				cnt16++;
			}

			match(input,13,FOLLOW_13_in_require_def892); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "require_def"



	// $ANTLR start "situation"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:223:1: situation : '(' ':situation' NAME ')' ;
	public final void situation() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:224:2: ( '(' ':situation' NAME ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:224:4: '(' ':situation' NAME ')'
			{
			match(input,12,FOLLOW_12_in_situation905); 
			match(input,39,FOLLOW_39_in_situation907); 
			match(input,NAME,FOLLOW_NAME_in_situation909); 
			match(input,13,FOLLOW_13_in_situation911); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "situation"



	// $ANTLR start "object_declaration"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:227:1: object_declaration : '(' ':objects' typed_list_of_name ')' ;
	public final void object_declaration() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:228:2: ( '(' ':objects' typed_list_of_name ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:228:4: '(' ':objects' typed_list_of_name ')'
			{
			match(input,12,FOLLOW_12_in_object_declaration924); 
			match(input,30,FOLLOW_30_in_object_declaration926); 
			pushFollow(FOLLOW_typed_list_of_name_in_object_declaration928);
			typed_list_of_name();
			state._fsp--;

			match(input,13,FOLLOW_13_in_object_declaration930); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "object_declaration"



	// $ANTLR start "init"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:231:1: init : '(' ':init' ( literal_of_name )+ ')' ;
	public final void init() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:231:7: ( '(' ':init' ( literal_of_name )+ ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:231:9: '(' ':init' ( literal_of_name )+ ')'
			{
			match(input,12,FOLLOW_12_in_init941); 
			match(input,26,FOLLOW_26_in_init943); 
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:231:21: ( literal_of_name )+
			int cnt17=0;
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==12) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:231:21: literal_of_name
					{
					pushFollow(FOLLOW_literal_of_name_in_init945);
					literal_of_name();
					state._fsp--;

					}
					break;

				default :
					if ( cnt17 >= 1 ) break loop17;
					EarlyExitException eee = new EarlyExitException(17, input);
					throw eee;
				}
				cnt17++;
			}

			match(input,13,FOLLOW_13_in_init948); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "init"



	// $ANTLR start "goal"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:234:1: goal : ( '(' ':goal' gd ')' | '(' ':expansion' action_spec_od_action_term ')' );
	public final void goal() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:234:6: ( '(' ':goal' gd ')' | '(' ':expansion' action_spec_od_action_term ')' )
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==12) ) {
				int LA18_1 = input.LA(2);
				if ( (LA18_1==24) ) {
					alt18=1;
				}
				else if ( (LA18_1==22) ) {
					alt18=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 18, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				throw nvae;
			}

			switch (alt18) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:234:8: '(' ':goal' gd ')'
					{
					match(input,12,FOLLOW_12_in_goal958); 
					match(input,24,FOLLOW_24_in_goal960); 
					pushFollow(FOLLOW_gd_in_goal962);
					gd();
					state._fsp--;

					match(input,13,FOLLOW_13_in_goal964); 
					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:235:4: '(' ':expansion' action_spec_od_action_term ')'
					{
					match(input,12,FOLLOW_12_in_goal969); 
					match(input,22,FOLLOW_22_in_goal971); 
					pushFollow(FOLLOW_action_spec_od_action_term_in_goal973);
					action_spec_od_action_term();
					state._fsp--;

					match(input,13,FOLLOW_13_in_goal975); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "goal"



	// $ANTLR start "length_spec"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:238:1: length_spec : '(' ':length' ( '(' ':serial' INTEGER ')' )? ( '(' ':parallel' INTEGER ')' )? ')' ;
	public final void length_spec() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:239:2: ( '(' ':length' ( '(' ':serial' INTEGER ')' )? ( '(' ':parallel' INTEGER ')' )? ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:239:4: '(' ':length' ( '(' ':serial' INTEGER ')' )? ( '(' ':parallel' INTEGER ')' )? ')'
			{
			match(input,12,FOLLOW_12_in_length_spec989); 
			match(input,27,FOLLOW_27_in_length_spec991); 
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:239:18: ( '(' ':serial' INTEGER ')' )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==12) ) {
				int LA19_1 = input.LA(2);
				if ( (LA19_1==38) ) {
					alt19=1;
				}
			}
			switch (alt19) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:239:19: '(' ':serial' INTEGER ')'
					{
					match(input,12,FOLLOW_12_in_length_spec994); 
					match(input,38,FOLLOW_38_in_length_spec996); 
					match(input,INTEGER,FOLLOW_INTEGER_in_length_spec998); 
					match(input,13,FOLLOW_13_in_length_spec1000); 
					}
					break;

			}

			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:239:47: ( '(' ':parallel' INTEGER ')' )?
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==12) ) {
				alt20=1;
			}
			switch (alt20) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:239:48: '(' ':parallel' INTEGER ')'
					{
					match(input,12,FOLLOW_12_in_length_spec1005); 
					match(input,32,FOLLOW_32_in_length_spec1007); 
					match(input,INTEGER,FOLLOW_INTEGER_in_length_spec1009); 
					match(input,13,FOLLOW_13_in_length_spec1011); 
					}
					break;

			}

			match(input,13,FOLLOW_13_in_length_spec1015); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "length_spec"



	// $ANTLR start "initsit_header"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:243:1: initsit_header : '(' 'situation' NAME ')' ;
	public final void initsit_header() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:244:5: ( '(' 'situation' NAME ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:244:9: '(' 'situation' NAME ')'
			{
			match(input,12,FOLLOW_12_in_initsit_header1034); 
			match(input,55,FOLLOW_55_in_initsit_header1036); 
			match(input,NAME,FOLLOW_NAME_in_initsit_header1038); 
			match(input,13,FOLLOW_13_in_initsit_header1040); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "initsit_header"



	// $ANTLR start "initsit_body"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:247:1: initsit_body : '(' ':domain' NAME ')' ( initsit_body_item )* ;
	public final void initsit_body() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:248:5: ( '(' ':domain' NAME ')' ( initsit_body_item )* )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:248:8: '(' ':domain' NAME ')' ( initsit_body_item )*
			{
			match(input,12,FOLLOW_12_in_initsit_body1058); 
			match(input,19,FOLLOW_19_in_initsit_body1060); 
			match(input,NAME,FOLLOW_NAME_in_initsit_body1062); 
			match(input,13,FOLLOW_13_in_initsit_body1064); 
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:249:13: ( initsit_body_item )*
			loop21:
			while (true) {
				int alt21=2;
				int LA21_0 = input.LA(1);
				if ( (LA21_0==12) ) {
					alt21=1;
				}

				switch (alt21) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:249:13: initsit_body_item
					{
					pushFollow(FOLLOW_initsit_body_item_in_initsit_body1078);
					initsit_body_item();
					state._fsp--;

					}
					break;

				default :
					break loop21;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "initsit_body"



	// $ANTLR start "initsit_body_item"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:252:1: initsit_body_item : ( object_declaration | init );
	public final void initsit_body_item() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:253:5: ( object_declaration | init )
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==12) ) {
				int LA22_1 = input.LA(2);
				if ( (LA22_1==30) ) {
					alt22=1;
				}
				else if ( (LA22_1==26) ) {
					alt22=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 22, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}

			switch (alt22) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:253:9: object_declaration
					{
					pushFollow(FOLLOW_object_declaration_in_initsit_body_item1102);
					object_declaration();
					state._fsp--;

					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:254:9: init
					{
					pushFollow(FOLLOW_init_in_initsit_body_item1112);
					init();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "initsit_body_item"



	// $ANTLR start "gd"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:261:1: gd : ( atomic_formula_of_term | complicated_gd );
	public final void gd() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:261:5: ( atomic_formula_of_term | complicated_gd )
			int alt23=2;
			int LA23_0 = input.LA(1);
			if ( (LA23_0==12) ) {
				int LA23_1 = input.LA(2);
				if ( (LA23_1==43||LA23_1==48||(LA23_1 >= 50 && LA23_1 <= 53)) ) {
					alt23=2;
				}
				else if ( (LA23_1==NAME) ) {
					alt23=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 23, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 23, 0, input);
				throw nvae;
			}

			switch (alt23) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:261:9: atomic_formula_of_term
					{
					pushFollow(FOLLOW_atomic_formula_of_term_in_gd1131);
					atomic_formula_of_term();
					state._fsp--;

					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:262:9: complicated_gd
					{
					pushFollow(FOLLOW_complicated_gd_in_gd1141);
					complicated_gd();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "gd"



	// $ANTLR start "complicated_gd"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:265:1: complicated_gd : ( '(' 'and' ( gd )* ')' | '(' 'or' ( gd )* ')' | '(' 'not' atomic_formula_of_term ')' | '(' 'not' complicated_gd ')' | '(' 'imply' gd gd ')' | '(' 'exists' '(' typed_list_of_variable ')' gd ')' | '(' 'forall' '(' typed_list_of_variable ')' gd ')' );
	public final void complicated_gd() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:265:17: ( '(' 'and' ( gd )* ')' | '(' 'or' ( gd )* ')' | '(' 'not' atomic_formula_of_term ')' | '(' 'not' complicated_gd ')' | '(' 'imply' gd gd ')' | '(' 'exists' '(' typed_list_of_variable ')' gd ')' | '(' 'forall' '(' typed_list_of_variable ')' gd ')' )
			int alt26=7;
			int LA26_0 = input.LA(1);
			if ( (LA26_0==12) ) {
				switch ( input.LA(2) ) {
				case 43:
					{
					alt26=1;
					}
					break;
				case 53:
					{
					alt26=2;
					}
					break;
				case 52:
					{
					int LA26_4 = input.LA(3);
					if ( (LA26_4==12) ) {
						int LA26_8 = input.LA(4);
						if ( (LA26_8==43||LA26_8==48||(LA26_8 >= 50 && LA26_8 <= 53)) ) {
							alt26=4;
						}
						else if ( (LA26_8==NAME) ) {
							alt26=3;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 26, 8, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 26, 4, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case 51:
					{
					alt26=5;
					}
					break;
				case 48:
					{
					alt26=6;
					}
					break;
				case 50:
					{
					alt26=7;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 26, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 26, 0, input);
				throw nvae;
			}

			switch (alt26) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:265:20: '(' 'and' ( gd )* ')'
					{
					match(input,12,FOLLOW_12_in_complicated_gd1156); 
					match(input,43,FOLLOW_43_in_complicated_gd1158); 
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:265:30: ( gd )*
					loop24:
					while (true) {
						int alt24=2;
						int LA24_0 = input.LA(1);
						if ( (LA24_0==12) ) {
							alt24=1;
						}

						switch (alt24) {
						case 1 :
							// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:265:30: gd
							{
							pushFollow(FOLLOW_gd_in_complicated_gd1160);
							gd();
							state._fsp--;

							}
							break;

						default :
							break loop24;
						}
					}

					match(input,13,FOLLOW_13_in_complicated_gd1163); 
					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:266:4: '(' 'or' ( gd )* ')'
					{
					match(input,12,FOLLOW_12_in_complicated_gd1168); 
					match(input,53,FOLLOW_53_in_complicated_gd1170); 
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:266:13: ( gd )*
					loop25:
					while (true) {
						int alt25=2;
						int LA25_0 = input.LA(1);
						if ( (LA25_0==12) ) {
							alt25=1;
						}

						switch (alt25) {
						case 1 :
							// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:266:13: gd
							{
							pushFollow(FOLLOW_gd_in_complicated_gd1172);
							gd();
							state._fsp--;

							}
							break;

						default :
							break loop25;
						}
					}

					match(input,13,FOLLOW_13_in_complicated_gd1175); 
					}
					break;
				case 3 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:267:7: '(' 'not' atomic_formula_of_term ')'
					{
					match(input,12,FOLLOW_12_in_complicated_gd1184); 
					match(input,52,FOLLOW_52_in_complicated_gd1186); 
					pushFollow(FOLLOW_atomic_formula_of_term_in_complicated_gd1188);
					atomic_formula_of_term();
					state._fsp--;

					match(input,13,FOLLOW_13_in_complicated_gd1190); 
					}
					break;
				case 4 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:268:7: '(' 'not' complicated_gd ')'
					{
					match(input,12,FOLLOW_12_in_complicated_gd1199); 
					match(input,52,FOLLOW_52_in_complicated_gd1201); 
					pushFollow(FOLLOW_complicated_gd_in_complicated_gd1203);
					complicated_gd();
					state._fsp--;

					match(input,13,FOLLOW_13_in_complicated_gd1205); 
					}
					break;
				case 5 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:269:4: '(' 'imply' gd gd ')'
					{
					match(input,12,FOLLOW_12_in_complicated_gd1211); 
					match(input,51,FOLLOW_51_in_complicated_gd1213); 
					pushFollow(FOLLOW_gd_in_complicated_gd1215);
					gd();
					state._fsp--;

					pushFollow(FOLLOW_gd_in_complicated_gd1217);
					gd();
					state._fsp--;

					match(input,13,FOLLOW_13_in_complicated_gd1219); 
					}
					break;
				case 6 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:270:4: '(' 'exists' '(' typed_list_of_variable ')' gd ')'
					{
					match(input,12,FOLLOW_12_in_complicated_gd1225); 
					match(input,48,FOLLOW_48_in_complicated_gd1227); 
					match(input,12,FOLLOW_12_in_complicated_gd1229); 
					pushFollow(FOLLOW_typed_list_of_variable_in_complicated_gd1231);
					typed_list_of_variable();
					state._fsp--;

					match(input,13,FOLLOW_13_in_complicated_gd1233); 
					pushFollow(FOLLOW_gd_in_complicated_gd1235);
					gd();
					state._fsp--;

					match(input,13,FOLLOW_13_in_complicated_gd1237); 
					}
					break;
				case 7 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:271:4: '(' 'forall' '(' typed_list_of_variable ')' gd ')'
					{
					match(input,12,FOLLOW_12_in_complicated_gd1243); 
					match(input,50,FOLLOW_50_in_complicated_gd1245); 
					match(input,12,FOLLOW_12_in_complicated_gd1247); 
					pushFollow(FOLLOW_typed_list_of_variable_in_complicated_gd1249);
					typed_list_of_variable();
					state._fsp--;

					match(input,13,FOLLOW_13_in_complicated_gd1251); 
					pushFollow(FOLLOW_gd_in_complicated_gd1253);
					gd();
					state._fsp--;

					match(input,13,FOLLOW_13_in_complicated_gd1255); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "complicated_gd"



	// $ANTLR start "predicate"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:275:1: predicate : NAME ;
	public final void predicate() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:276:2: ( NAME )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:276:4: NAME
			{
			match(input,NAME,FOLLOW_NAME_in_predicate1269); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "predicate"



	// $ANTLR start "term"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:280:1: term : ( NAME | VARIABLE );
	public final void term() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:280:7: ( NAME | VARIABLE )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:
			{
			if ( input.LA(1)==NAME||input.LA(1)==VARIABLE ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "term"



	// $ANTLR start "literal_of_name"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:285:1: literal_of_name : ( atomic_formula_of_name | '(' 'not' atomic_formula_of_name ')' );
	public final void literal_of_name() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:286:2: ( atomic_formula_of_name | '(' 'not' atomic_formula_of_name ')' )
			int alt27=2;
			int LA27_0 = input.LA(1);
			if ( (LA27_0==12) ) {
				int LA27_1 = input.LA(2);
				if ( (LA27_1==52) ) {
					alt27=2;
				}
				else if ( (LA27_1==NAME) ) {
					alt27=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 27, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 27, 0, input);
				throw nvae;
			}

			switch (alt27) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:286:4: atomic_formula_of_name
					{
					pushFollow(FOLLOW_atomic_formula_of_name_in_literal_of_name1299);
					atomic_formula_of_name();
					state._fsp--;

					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:287:4: '(' 'not' atomic_formula_of_name ')'
					{
					match(input,12,FOLLOW_12_in_literal_of_name1304); 
					match(input,52,FOLLOW_52_in_literal_of_name1306); 
					pushFollow(FOLLOW_atomic_formula_of_name_in_literal_of_name1308);
					atomic_formula_of_name();
					state._fsp--;

					match(input,13,FOLLOW_13_in_literal_of_name1310); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "literal_of_name"



	// $ANTLR start "literal_of_term"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:290:1: literal_of_term : ( atomic_formula_of_term | '(' 'not' atomic_formula_of_term ')' );
	public final void literal_of_term() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:291:2: ( atomic_formula_of_term | '(' 'not' atomic_formula_of_term ')' )
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( (LA28_0==12) ) {
				int LA28_1 = input.LA(2);
				if ( (LA28_1==52) ) {
					alt28=2;
				}
				else if ( (LA28_1==NAME) ) {
					alt28=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 28, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 28, 0, input);
				throw nvae;
			}

			switch (alt28) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:291:4: atomic_formula_of_term
					{
					pushFollow(FOLLOW_atomic_formula_of_term_in_literal_of_term1321);
					atomic_formula_of_term();
					state._fsp--;

					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:292:4: '(' 'not' atomic_formula_of_term ')'
					{
					match(input,12,FOLLOW_12_in_literal_of_term1326); 
					match(input,52,FOLLOW_52_in_literal_of_term1328); 
					pushFollow(FOLLOW_atomic_formula_of_term_in_literal_of_term1330);
					atomic_formula_of_term();
					state._fsp--;

					match(input,13,FOLLOW_13_in_literal_of_term1332); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "literal_of_term"



	// $ANTLR start "atomic_formula_of_term"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:295:1: atomic_formula_of_term : '(' predicate ( term )* ')' ;
	public final void atomic_formula_of_term() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:296:2: ( '(' predicate ( term )* ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:296:4: '(' predicate ( term )* ')'
			{
			match(input,12,FOLLOW_12_in_atomic_formula_of_term1343); 
			pushFollow(FOLLOW_predicate_in_atomic_formula_of_term1345);
			predicate();
			state._fsp--;

			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:296:18: ( term )*
			loop29:
			while (true) {
				int alt29=2;
				int LA29_0 = input.LA(1);
				if ( (LA29_0==NAME||LA29_0==VARIABLE) ) {
					alt29=1;
				}

				switch (alt29) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:296:18: term
					{
					pushFollow(FOLLOW_term_in_atomic_formula_of_term1347);
					term();
					state._fsp--;

					}
					break;

				default :
					break loop29;
				}
			}

			match(input,13,FOLLOW_13_in_atomic_formula_of_term1350); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "atomic_formula_of_term"



	// $ANTLR start "atomic_formula_of_name"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:299:1: atomic_formula_of_name : '(' predicate ( NAME )* ')' ;
	public final void atomic_formula_of_name() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:300:2: ( '(' predicate ( NAME )* ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:300:4: '(' predicate ( NAME )* ')'
			{
			match(input,12,FOLLOW_12_in_atomic_formula_of_name1362); 
			pushFollow(FOLLOW_predicate_in_atomic_formula_of_name1364);
			predicate();
			state._fsp--;

			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:300:18: ( NAME )*
			loop30:
			while (true) {
				int alt30=2;
				int LA30_0 = input.LA(1);
				if ( (LA30_0==NAME) ) {
					alt30=1;
				}

				switch (alt30) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:300:18: NAME
					{
					match(input,NAME,FOLLOW_NAME_in_atomic_formula_of_name1366); 
					}
					break;

				default :
					break loop30;
				}
			}

			match(input,13,FOLLOW_13_in_atomic_formula_of_name1369); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "atomic_formula_of_name"



	// $ANTLR start "typed_list_of_name"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:303:1: typed_list_of_name : (| ( NAME )+ ( '-' type typed_list_of_name )? );
	public final void typed_list_of_name() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:304:2: (| ( NAME )+ ( '-' type typed_list_of_name )? )
			int alt33=2;
			int LA33_0 = input.LA(1);
			if ( (LA33_0==13) ) {
				alt33=1;
			}
			else if ( (LA33_0==NAME) ) {
				alt33=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 33, 0, input);
				throw nvae;
			}

			switch (alt33) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:305:2: 
					{
					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:305:4: ( NAME )+ ( '-' type typed_list_of_name )?
					{
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:305:4: ( NAME )+
					int cnt31=0;
					loop31:
					while (true) {
						int alt31=2;
						int LA31_0 = input.LA(1);
						if ( (LA31_0==NAME) ) {
							alt31=1;
						}

						switch (alt31) {
						case 1 :
							// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:305:4: NAME
							{
							match(input,NAME,FOLLOW_NAME_in_typed_list_of_name1385); 
							}
							break;

						default :
							if ( cnt31 >= 1 ) break loop31;
							EarlyExitException eee = new EarlyExitException(31, input);
							throw eee;
						}
						cnt31++;
					}

					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:305:10: ( '-' type typed_list_of_name )?
					int alt32=2;
					int LA32_0 = input.LA(1);
					if ( (LA32_0==14) ) {
						alt32=1;
					}
					switch (alt32) {
						case 1 :
							// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:305:11: '-' type typed_list_of_name
							{
							match(input,14,FOLLOW_14_in_typed_list_of_name1389); 
							pushFollow(FOLLOW_type_in_typed_list_of_name1391);
							type();
							state._fsp--;

							pushFollow(FOLLOW_typed_list_of_name_in_typed_list_of_name1393);
							typed_list_of_name();
							state._fsp--;

							}
							break;

					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "typed_list_of_name"



	// $ANTLR start "typed_list_of_variable"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:308:1: typed_list_of_variable : (| ( VARIABLE )+ ( '-' type typed_list_of_variable )? );
	public final void typed_list_of_variable() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:309:2: (| ( VARIABLE )+ ( '-' type typed_list_of_variable )? )
			int alt36=2;
			int LA36_0 = input.LA(1);
			if ( (LA36_0==13) ) {
				alt36=1;
			}
			else if ( (LA36_0==VARIABLE) ) {
				alt36=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 36, 0, input);
				throw nvae;
			}

			switch (alt36) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:310:2: 
					{
					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:310:4: ( VARIABLE )+ ( '-' type typed_list_of_variable )?
					{
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:310:4: ( VARIABLE )+
					int cnt34=0;
					loop34:
					while (true) {
						int alt34=2;
						int LA34_0 = input.LA(1);
						if ( (LA34_0==VARIABLE) ) {
							alt34=1;
						}

						switch (alt34) {
						case 1 :
							// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:310:4: VARIABLE
							{
							match(input,VARIABLE,FOLLOW_VARIABLE_in_typed_list_of_variable1411); 
							}
							break;

						default :
							if ( cnt34 >= 1 ) break loop34;
							EarlyExitException eee = new EarlyExitException(34, input);
							throw eee;
						}
						cnt34++;
					}

					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:310:14: ( '-' type typed_list_of_variable )?
					int alt35=2;
					int LA35_0 = input.LA(1);
					if ( (LA35_0==14) ) {
						alt35=1;
					}
					switch (alt35) {
						case 1 :
							// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:310:15: '-' type typed_list_of_variable
							{
							match(input,14,FOLLOW_14_in_typed_list_of_variable1415); 
							pushFollow(FOLLOW_type_in_typed_list_of_variable1417);
							type();
							state._fsp--;

							pushFollow(FOLLOW_typed_list_of_variable_in_typed_list_of_variable1419);
							typed_list_of_variable();
							state._fsp--;

							}
							break;

					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "typed_list_of_variable"



	// $ANTLR start "type"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:313:1: type : ( NAME | '(' 'either' ( type )+ ')' | '(' 'fluent' type ')' );
	public final void type() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:313:7: ( NAME | '(' 'either' ( type )+ ')' | '(' 'fluent' type ')' )
			int alt38=3;
			int LA38_0 = input.LA(1);
			if ( (LA38_0==NAME) ) {
				alt38=1;
			}
			else if ( (LA38_0==12) ) {
				int LA38_2 = input.LA(2);
				if ( (LA38_2==47) ) {
					alt38=2;
				}
				else if ( (LA38_2==49) ) {
					alt38=3;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 38, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 38, 0, input);
				throw nvae;
			}

			switch (alt38) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:313:9: NAME
					{
					match(input,NAME,FOLLOW_NAME_in_type1433); 
					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:314:4: '(' 'either' ( type )+ ')'
					{
					match(input,12,FOLLOW_12_in_type1438); 
					match(input,47,FOLLOW_47_in_type1440); 
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:314:17: ( type )+
					int cnt37=0;
					loop37:
					while (true) {
						int alt37=2;
						int LA37_0 = input.LA(1);
						if ( (LA37_0==NAME||LA37_0==12) ) {
							alt37=1;
						}

						switch (alt37) {
						case 1 :
							// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:314:17: type
							{
							pushFollow(FOLLOW_type_in_type1442);
							type();
							state._fsp--;

							}
							break;

						default :
							if ( cnt37 >= 1 ) break loop37;
							EarlyExitException eee = new EarlyExitException(37, input);
							throw eee;
						}
						cnt37++;
					}

					match(input,13,FOLLOW_13_in_type1445); 
					}
					break;
				case 3 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:315:4: '(' 'fluent' type ')'
					{
					match(input,12,FOLLOW_12_in_type1450); 
					match(input,49,FOLLOW_49_in_type1452); 
					pushFollow(FOLLOW_type_in_type1454);
					type();
					state._fsp--;

					match(input,13,FOLLOW_13_in_type1456); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "type"



	// $ANTLR start "method_def"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:321:1: method_def : '(' ':method' ( general_tree_item )* ')' ;
	public final void method_def() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:322:2: ( '(' ':method' ( general_tree_item )* ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:322:4: '(' ':method' ( general_tree_item )* ')'
			{
			match(input,12,FOLLOW_12_in_method_def1470); 
			match(input,29,FOLLOW_29_in_method_def1472); 
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:322:18: ( general_tree_item )*
			loop39:
			while (true) {
				int alt39=2;
				int LA39_0 = input.LA(1);
				if ( ((LA39_0 >= INTEGER && LA39_0 <= REQUIRE_KEY)||LA39_0==VARIABLE||LA39_0==12||LA39_0==43||LA39_0==52) ) {
					alt39=1;
				}

				switch (alt39) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:322:18: general_tree_item
					{
					pushFollow(FOLLOW_general_tree_item_in_method_def1474);
					general_tree_item();
					state._fsp--;

					}
					break;

				default :
					break loop39;
				}
			}

			match(input,13,FOLLOW_13_in_method_def1477); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "method_def"



	// $ANTLR start "atomic_formula_skeleton"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:327:1: atomic_formula_skeleton : '(' predicate typed_list_of_variable ')' ;
	public final void atomic_formula_skeleton() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:328:2: ( '(' predicate typed_list_of_variable ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:328:4: '(' predicate typed_list_of_variable ')'
			{
			match(input,12,FOLLOW_12_in_atomic_formula_skeleton1492); 
			pushFollow(FOLLOW_predicate_in_atomic_formula_skeleton1494);
			predicate();
			state._fsp--;

			pushFollow(FOLLOW_typed_list_of_variable_in_atomic_formula_skeleton1496);
			typed_list_of_variable();
			state._fsp--;

			match(input,13,FOLLOW_13_in_atomic_formula_skeleton1498); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "atomic_formula_skeleton"



	// $ANTLR start "domain_var_declaration"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:336:1: domain_var_declaration : ( NAME | '(' NAME NAME ')' );
	public final void domain_var_declaration() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:337:2: ( NAME | '(' NAME NAME ')' )
			int alt40=2;
			int LA40_0 = input.LA(1);
			if ( (LA40_0==NAME) ) {
				alt40=1;
			}
			else if ( (LA40_0==12) ) {
				alt40=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 40, 0, input);
				throw nvae;
			}

			switch (alt40) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:337:4: NAME
					{
					match(input,NAME,FOLLOW_NAME_in_domain_var_declaration1516); 
					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:338:4: '(' NAME NAME ')'
					{
					match(input,12,FOLLOW_12_in_domain_var_declaration1521); 
					match(input,NAME,FOLLOW_NAME_in_domain_var_declaration1523); 
					match(input,NAME,FOLLOW_NAME_in_domain_var_declaration1525); 
					match(input,13,FOLLOW_13_in_domain_var_declaration1527); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "domain_var_declaration"



	// $ANTLR start "typed_list_of_domain_var_declaration"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:341:1: typed_list_of_domain_var_declaration : (| ( domain_var_declaration )+ ( '-' type typed_list_of_domain_var_declaration )? );
	public final void typed_list_of_domain_var_declaration() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:342:2: (| ( domain_var_declaration )+ ( '-' type typed_list_of_domain_var_declaration )? )
			int alt43=2;
			int LA43_0 = input.LA(1);
			if ( (LA43_0==13) ) {
				alt43=1;
			}
			else if ( (LA43_0==NAME||LA43_0==12) ) {
				alt43=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 43, 0, input);
				throw nvae;
			}

			switch (alt43) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:343:2: 
					{
					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:343:4: ( domain_var_declaration )+ ( '-' type typed_list_of_domain_var_declaration )?
					{
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:343:4: ( domain_var_declaration )+
					int cnt41=0;
					loop41:
					while (true) {
						int alt41=2;
						int LA41_0 = input.LA(1);
						if ( (LA41_0==NAME||LA41_0==12) ) {
							alt41=1;
						}

						switch (alt41) {
						case 1 :
							// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:343:4: domain_var_declaration
							{
							pushFollow(FOLLOW_domain_var_declaration_in_typed_list_of_domain_var_declaration1543);
							domain_var_declaration();
							state._fsp--;

							}
							break;

						default :
							if ( cnt41 >= 1 ) break loop41;
							EarlyExitException eee = new EarlyExitException(41, input);
							throw eee;
						}
						cnt41++;
					}

					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:343:28: ( '-' type typed_list_of_domain_var_declaration )?
					int alt42=2;
					int LA42_0 = input.LA(1);
					if ( (LA42_0==14) ) {
						alt42=1;
					}
					switch (alt42) {
						case 1 :
							// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:343:29: '-' type typed_list_of_domain_var_declaration
							{
							match(input,14,FOLLOW_14_in_typed_list_of_domain_var_declaration1547); 
							pushFollow(FOLLOW_type_in_typed_list_of_domain_var_declaration1549);
							type();
							state._fsp--;

							pushFollow(FOLLOW_typed_list_of_domain_var_declaration_in_typed_list_of_domain_var_declaration1551);
							typed_list_of_domain_var_declaration();
							state._fsp--;

							}
							break;

					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "typed_list_of_domain_var_declaration"



	// $ANTLR start "general_tree"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:350:1: general_tree : '(' ( general_tree_item )* ')' ;
	public final void general_tree() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:351:2: ( '(' ( general_tree_item )* ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:351:4: '(' ( general_tree_item )* ')'
			{
			match(input,12,FOLLOW_12_in_general_tree1568); 
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:351:8: ( general_tree_item )*
			loop44:
			while (true) {
				int alt44=2;
				int LA44_0 = input.LA(1);
				if ( ((LA44_0 >= INTEGER && LA44_0 <= REQUIRE_KEY)||LA44_0==VARIABLE||LA44_0==12||LA44_0==43||LA44_0==52) ) {
					alt44=1;
				}

				switch (alt44) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:351:8: general_tree_item
					{
					pushFollow(FOLLOW_general_tree_item_in_general_tree1570);
					general_tree_item();
					state._fsp--;

					}
					break;

				default :
					break loop44;
				}
			}

			match(input,13,FOLLOW_13_in_general_tree1573); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "general_tree"



	// $ANTLR start "general_tree_item"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:354:1: general_tree_item : ( NAME | INTEGER | VARIABLE | REQUIRE_KEY | 'and' | 'not' | general_tree );
	public final void general_tree_item() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:355:2: ( NAME | INTEGER | VARIABLE | REQUIRE_KEY | 'and' | 'not' | general_tree )
			int alt45=7;
			switch ( input.LA(1) ) {
			case NAME:
				{
				alt45=1;
				}
				break;
			case INTEGER:
				{
				alt45=2;
				}
				break;
			case VARIABLE:
				{
				alt45=3;
				}
				break;
			case REQUIRE_KEY:
				{
				alt45=4;
				}
				break;
			case 43:
				{
				alt45=5;
				}
				break;
			case 52:
				{
				alt45=6;
				}
				break;
			case 12:
				{
				alt45=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 45, 0, input);
				throw nvae;
			}
			switch (alt45) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:355:4: NAME
					{
					match(input,NAME,FOLLOW_NAME_in_general_tree_item1585); 
					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:356:4: INTEGER
					{
					match(input,INTEGER,FOLLOW_INTEGER_in_general_tree_item1590); 
					}
					break;
				case 3 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:357:4: VARIABLE
					{
					match(input,VARIABLE,FOLLOW_VARIABLE_in_general_tree_item1595); 
					}
					break;
				case 4 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:358:4: REQUIRE_KEY
					{
					match(input,REQUIRE_KEY,FOLLOW_REQUIRE_KEY_in_general_tree_item1600); 
					}
					break;
				case 5 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:359:4: 'and'
					{
					match(input,43,FOLLOW_43_in_general_tree_item1606); 
					}
					break;
				case 6 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:360:4: 'not'
					{
					match(input,52,FOLLOW_52_in_general_tree_item1611); 
					}
					break;
				case 7 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:361:4: general_tree
					{
					pushFollow(FOLLOW_general_tree_in_general_tree_item1616);
					general_tree();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "general_tree_item"



	// $ANTLR start "boolean_type"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:364:1: boolean_type : ( TRUE | FALSE );
	public final void boolean_type() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:365:5: ( TRUE | FALSE )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:
			{
			if ( input.LA(1)==FALSE||input.LA(1)==TRUE ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "boolean_type"

	// Delegated rules



	public static final BitSet FOLLOW_definition_in_pddl_file38 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_12_in_definition54 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_45_in_definition56 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_problem_header_in_definition58 = new BitSet(new long[]{0x0000000000003000L});
	public static final BitSet FOLLOW_problem_item_in_definition60 = new BitSet(new long[]{0x0000000000003000L});
	public static final BitSet FOLLOW_13_in_definition63 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_definition68 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_45_in_definition70 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_domain_header_in_definition72 = new BitSet(new long[]{0x0000000000003000L});
	public static final BitSet FOLLOW_domain_item_in_definition74 = new BitSet(new long[]{0x0000000000003000L});
	public static final BitSet FOLLOW_13_in_definition77 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_definition84 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_45_in_definition86 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_initsit_header_in_definition88 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_initsit_body_in_definition90 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_definition92 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_domain_header107 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_46_in_domain_header109 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_NAME_in_domain_header111 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_domain_header113 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_extension_def_in_domain_item124 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_require_def_in_domain_item129 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_types_def_in_domain_item134 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constants_def_in_domain_item141 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_domain_vars_def_in_domain_item146 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_predicates_def_in_domain_item152 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_timeless_def_in_domain_item157 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_safety_def_in_domain_item162 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_structure_def_in_domain_item168 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_extension_def181 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_extension_def183 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_NAME_in_extension_def185 = new BitSet(new long[]{0x0000000000002080L});
	public static final BitSet FOLLOW_13_in_extension_def188 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_types_def201 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_41_in_types_def203 = new BitSet(new long[]{0x0000000000002080L});
	public static final BitSet FOLLOW_typed_list_of_name_in_types_def205 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_types_def207 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_constants_def219 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_constants_def221 = new BitSet(new long[]{0x0000000000002080L});
	public static final BitSet FOLLOW_typed_list_of_name_in_constants_def223 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_constants_def225 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_domain_vars_def236 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_domain_vars_def238 = new BitSet(new long[]{0x0000000000003080L});
	public static final BitSet FOLLOW_typed_list_of_domain_var_declaration_in_domain_vars_def240 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_domain_vars_def242 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_predicates_def254 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_predicates_def256 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_atomic_formula_skeleton_in_predicates_def258 = new BitSet(new long[]{0x0000000000003000L});
	public static final BitSet FOLLOW_13_in_predicates_def261 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_timeless_def272 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_timeless_def274 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_literal_of_name_in_timeless_def276 = new BitSet(new long[]{0x0000000000003000L});
	public static final BitSet FOLLOW_13_in_timeless_def279 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_safety_def292 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_safety_def294 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_gd_in_safety_def296 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_safety_def298 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_action_def_in_structure_def311 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_axiom_def_in_structure_def316 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_method_def_in_structure_def322 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_action_def338 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_action_def340 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_action_functor_in_action_def342 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_action_def347 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_action_def349 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_typed_list_of_variable_in_action_def351 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_action_def353 = new BitSet(new long[]{0x0000040490602000L});
	public static final BitSet FOLLOW_action_def_body_in_action_def358 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_action_def360 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_action_functor375 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_action_def_body_item_in_action_def_body393 = new BitSet(new long[]{0x0000040490600002L});
	public static final BitSet FOLLOW_42_in_action_def_body_item418 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_action_def_body_item420 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_typed_list_of_variable_in_action_def_body_item422 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_action_def_body_item424 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_34_in_action_def_body_item436 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_gd_in_action_def_body_item438 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_22_in_action_def_body_item449 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_action_spec_in_action_def_body_item451 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_action_def_body_item469 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_gd_in_action_def_body_item471 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_action_def_body_item500 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_effect_in_action_def_body_item502 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_action_def_body_item513 = new BitSet(new long[]{0x0000000000000220L});
	public static final BitSet FOLLOW_boolean_type_in_action_def_body_item515 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_effect539 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_effect541 = new BitSet(new long[]{0x0000000000003000L});
	public static final BitSet FOLLOW_effect_in_effect543 = new BitSet(new long[]{0x0000000000003000L});
	public static final BitSet FOLLOW_13_in_effect546 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_effect557 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_52_in_effect559 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_atomic_formula_of_term_in_effect561 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_effect563 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomic_formula_of_term_in_effect574 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_effect585 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_50_in_effect587 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_effect589 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_VARIABLE_in_effect591 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_13_in_effect594 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_effect_in_effect596 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_effect598 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_effect610 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_effect612 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_gd_in_effect614 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_effect_in_effect616 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_effect618 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_effect630 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_44_in_effect632 = new BitSet(new long[]{0x00100800000015C0L});
	public static final BitSet FOLLOW_fluent_in_effect634 = new BitSet(new long[]{0x00100800000015C0L});
	public static final BitSet FOLLOW_expression_in_effect636 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_effect638 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_general_tree_item_in_fluent660 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_general_tree_item_in_expression684 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_general_tree_in_action_spec707 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_general_tree_in_action_spec_od_action_term722 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_axiom_def738 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_axiom_def740 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_42_in_axiom_def752 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_axiom_def754 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_typed_list_of_variable_in_axiom_def756 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_axiom_def758 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_axiom_def769 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_gd_in_axiom_def771 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_25_in_axiom_def782 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_literal_of_term_in_axiom_def784 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_axiom_def786 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_problem_header805 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_54_in_problem_header807 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_NAME_in_problem_header809 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_problem_header811 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_domain_reference_in_problem_item825 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_require_def_in_problem_item830 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_situation_in_problem_item835 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_object_declaration_in_problem_item840 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_init_in_problem_item845 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_goal_in_problem_item850 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_length_spec_in_problem_item855 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_domain_reference867 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_domain_reference869 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_NAME_in_domain_reference871 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_domain_reference873 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_require_def885 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_require_def887 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_REQUIRE_KEY_in_require_def889 = new BitSet(new long[]{0x0000000000002100L});
	public static final BitSet FOLLOW_13_in_require_def892 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_situation905 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_39_in_situation907 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_NAME_in_situation909 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_situation911 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_object_declaration924 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_object_declaration926 = new BitSet(new long[]{0x0000000000002080L});
	public static final BitSet FOLLOW_typed_list_of_name_in_object_declaration928 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_object_declaration930 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_init941 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_26_in_init943 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_literal_of_name_in_init945 = new BitSet(new long[]{0x0000000000003000L});
	public static final BitSet FOLLOW_13_in_init948 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_goal958 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_goal960 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_gd_in_goal962 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_goal964 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_goal969 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_goal971 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_action_spec_od_action_term_in_goal973 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_goal975 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_length_spec989 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_length_spec991 = new BitSet(new long[]{0x0000000000003000L});
	public static final BitSet FOLLOW_12_in_length_spec994 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_length_spec996 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_INTEGER_in_length_spec998 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_length_spec1000 = new BitSet(new long[]{0x0000000000003000L});
	public static final BitSet FOLLOW_12_in_length_spec1005 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_length_spec1007 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_INTEGER_in_length_spec1009 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_length_spec1011 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_length_spec1015 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_initsit_header1034 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_55_in_initsit_header1036 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_NAME_in_initsit_header1038 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_initsit_header1040 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_initsit_body1058 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_initsit_body1060 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_NAME_in_initsit_body1062 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_initsit_body1064 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_initsit_body_item_in_initsit_body1078 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_object_declaration_in_initsit_body_item1102 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_init_in_initsit_body_item1112 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomic_formula_of_term_in_gd1131 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_complicated_gd_in_gd1141 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_complicated_gd1156 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_complicated_gd1158 = new BitSet(new long[]{0x0000000000003000L});
	public static final BitSet FOLLOW_gd_in_complicated_gd1160 = new BitSet(new long[]{0x0000000000003000L});
	public static final BitSet FOLLOW_13_in_complicated_gd1163 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_complicated_gd1168 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_53_in_complicated_gd1170 = new BitSet(new long[]{0x0000000000003000L});
	public static final BitSet FOLLOW_gd_in_complicated_gd1172 = new BitSet(new long[]{0x0000000000003000L});
	public static final BitSet FOLLOW_13_in_complicated_gd1175 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_complicated_gd1184 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_52_in_complicated_gd1186 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_atomic_formula_of_term_in_complicated_gd1188 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_complicated_gd1190 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_complicated_gd1199 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_52_in_complicated_gd1201 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_complicated_gd_in_complicated_gd1203 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_complicated_gd1205 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_complicated_gd1211 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_51_in_complicated_gd1213 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_gd_in_complicated_gd1215 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_gd_in_complicated_gd1217 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_complicated_gd1219 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_complicated_gd1225 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_48_in_complicated_gd1227 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_complicated_gd1229 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_typed_list_of_variable_in_complicated_gd1231 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_complicated_gd1233 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_gd_in_complicated_gd1235 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_complicated_gd1237 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_complicated_gd1243 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_50_in_complicated_gd1245 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_complicated_gd1247 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_typed_list_of_variable_in_complicated_gd1249 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_complicated_gd1251 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_gd_in_complicated_gd1253 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_complicated_gd1255 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_predicate1269 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomic_formula_of_name_in_literal_of_name1299 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_literal_of_name1304 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_52_in_literal_of_name1306 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_atomic_formula_of_name_in_literal_of_name1308 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_literal_of_name1310 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomic_formula_of_term_in_literal_of_term1321 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_literal_of_term1326 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_52_in_literal_of_term1328 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_atomic_formula_of_term_in_literal_of_term1330 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_literal_of_term1332 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_atomic_formula_of_term1343 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_predicate_in_atomic_formula_of_term1345 = new BitSet(new long[]{0x0000000000002480L});
	public static final BitSet FOLLOW_term_in_atomic_formula_of_term1347 = new BitSet(new long[]{0x0000000000002480L});
	public static final BitSet FOLLOW_13_in_atomic_formula_of_term1350 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_atomic_formula_of_name1362 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_predicate_in_atomic_formula_of_name1364 = new BitSet(new long[]{0x0000000000002080L});
	public static final BitSet FOLLOW_NAME_in_atomic_formula_of_name1366 = new BitSet(new long[]{0x0000000000002080L});
	public static final BitSet FOLLOW_13_in_atomic_formula_of_name1369 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_typed_list_of_name1385 = new BitSet(new long[]{0x0000000000004082L});
	public static final BitSet FOLLOW_14_in_typed_list_of_name1389 = new BitSet(new long[]{0x0000000000001080L});
	public static final BitSet FOLLOW_type_in_typed_list_of_name1391 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_typed_list_of_name_in_typed_list_of_name1393 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VARIABLE_in_typed_list_of_variable1411 = new BitSet(new long[]{0x0000000000004402L});
	public static final BitSet FOLLOW_14_in_typed_list_of_variable1415 = new BitSet(new long[]{0x0000000000001080L});
	public static final BitSet FOLLOW_type_in_typed_list_of_variable1417 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_typed_list_of_variable_in_typed_list_of_variable1419 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_type1433 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_type1438 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_type1440 = new BitSet(new long[]{0x0000000000001080L});
	public static final BitSet FOLLOW_type_in_type1442 = new BitSet(new long[]{0x0000000000003080L});
	public static final BitSet FOLLOW_13_in_type1445 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_type1450 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_49_in_type1452 = new BitSet(new long[]{0x0000000000001080L});
	public static final BitSet FOLLOW_type_in_type1454 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_type1456 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_method_def1470 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_29_in_method_def1472 = new BitSet(new long[]{0x00100800000035C0L});
	public static final BitSet FOLLOW_general_tree_item_in_method_def1474 = new BitSet(new long[]{0x00100800000035C0L});
	public static final BitSet FOLLOW_13_in_method_def1477 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_atomic_formula_skeleton1492 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_predicate_in_atomic_formula_skeleton1494 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_typed_list_of_variable_in_atomic_formula_skeleton1496 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_atomic_formula_skeleton1498 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_domain_var_declaration1516 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_domain_var_declaration1521 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_NAME_in_domain_var_declaration1523 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_NAME_in_domain_var_declaration1525 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_domain_var_declaration1527 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_domain_var_declaration_in_typed_list_of_domain_var_declaration1543 = new BitSet(new long[]{0x0000000000005082L});
	public static final BitSet FOLLOW_14_in_typed_list_of_domain_var_declaration1547 = new BitSet(new long[]{0x0000000000001080L});
	public static final BitSet FOLLOW_type_in_typed_list_of_domain_var_declaration1549 = new BitSet(new long[]{0x0000000000001080L});
	public static final BitSet FOLLOW_typed_list_of_domain_var_declaration_in_typed_list_of_domain_var_declaration1551 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_general_tree1568 = new BitSet(new long[]{0x00100800000035C0L});
	public static final BitSet FOLLOW_general_tree_item_in_general_tree1570 = new BitSet(new long[]{0x00100800000035C0L});
	public static final BitSet FOLLOW_13_in_general_tree1573 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_general_tree_item1585 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_general_tree_item1590 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VARIABLE_in_general_tree_item1595 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_REQUIRE_KEY_in_general_tree_item1600 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_43_in_general_tree_item1606 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_52_in_general_tree_item1611 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_general_tree_in_general_tree_item1616 = new BitSet(new long[]{0x0000000000000002L});
}
