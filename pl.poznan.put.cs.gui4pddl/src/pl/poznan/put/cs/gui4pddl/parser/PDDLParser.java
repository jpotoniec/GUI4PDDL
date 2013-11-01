// $ANTLR 3.5 /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g 2013-10-28 00:41:26

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
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:154:1: effect : ( '(' 'and' ( effect )* ')' | '(' 'not' atomic_formula_of_term ')' | atomic_formula_of_term | '(' 'forall' '(' typed_list_of_variable ')' effect ')' | '(' 'when' gd effect ')' | '(' 'change' fluent expression ')' );
	public final void effect() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:155:5: ( '(' 'and' ( effect )* ')' | '(' 'not' atomic_formula_of_term ')' | atomic_formula_of_term | '(' 'forall' '(' typed_list_of_variable ')' effect ')' | '(' 'when' gd effect ')' | '(' 'change' fluent expression ')' )
			int alt13=6;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==12) ) {
				switch ( input.LA(2) ) {
				case 43:
					{
					alt13=1;
					}
					break;
				case 52:
					{
					alt13=2;
					}
					break;
				case 50:
					{
					alt13=4;
					}
					break;
				case 56:
					{
					alt13=5;
					}
					break;
				case 44:
					{
					alt13=6;
					}
					break;
				case NAME:
					{
					alt13=3;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 13, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}

			switch (alt13) {
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
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:158:10: '(' 'forall' '(' typed_list_of_variable ')' effect ')'
					{
					match(input,12,FOLLOW_12_in_effect585); 
					match(input,50,FOLLOW_50_in_effect587); 
					match(input,12,FOLLOW_12_in_effect589); 
					pushFollow(FOLLOW_typed_list_of_variable_in_effect591);
					typed_list_of_variable();
					state._fsp--;

					match(input,13,FOLLOW_13_in_effect593); 
					pushFollow(FOLLOW_effect_in_effect595);
					effect();
					state._fsp--;

					match(input,13,FOLLOW_13_in_effect597); 
					}
					break;
				case 5 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:159:10: '(' 'when' gd effect ')'
					{
					match(input,12,FOLLOW_12_in_effect609); 
					match(input,56,FOLLOW_56_in_effect611); 
					pushFollow(FOLLOW_gd_in_effect613);
					gd();
					state._fsp--;

					pushFollow(FOLLOW_effect_in_effect615);
					effect();
					state._fsp--;

					match(input,13,FOLLOW_13_in_effect617); 
					}
					break;
				case 6 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:160:10: '(' 'change' fluent expression ')'
					{
					match(input,12,FOLLOW_12_in_effect629); 
					match(input,44,FOLLOW_44_in_effect631); 
					pushFollow(FOLLOW_fluent_in_effect633);
					fluent();
					state._fsp--;

					pushFollow(FOLLOW_expression_in_effect635);
					expression();
					state._fsp--;

					match(input,13,FOLLOW_13_in_effect637); 
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
			pushFollow(FOLLOW_general_tree_item_in_fluent659);
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
			pushFollow(FOLLOW_general_tree_item_in_expression683);
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
			pushFollow(FOLLOW_general_tree_in_action_spec706);
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
			pushFollow(FOLLOW_general_tree_in_action_spec_od_action_term721);
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
			match(input,12,FOLLOW_12_in_axiom_def737); 
			match(input,16,FOLLOW_16_in_axiom_def739); 
			match(input,42,FOLLOW_42_in_axiom_def751); 
			match(input,12,FOLLOW_12_in_axiom_def753); 
			pushFollow(FOLLOW_typed_list_of_variable_in_axiom_def755);
			typed_list_of_variable();
			state._fsp--;

			match(input,13,FOLLOW_13_in_axiom_def757); 
			match(input,18,FOLLOW_18_in_axiom_def768); 
			pushFollow(FOLLOW_gd_in_axiom_def770);
			gd();
			state._fsp--;

			match(input,25,FOLLOW_25_in_axiom_def781); 
			pushFollow(FOLLOW_literal_of_term_in_axiom_def783);
			literal_of_term();
			state._fsp--;

			match(input,13,FOLLOW_13_in_axiom_def785); 
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
			match(input,12,FOLLOW_12_in_problem_header804); 
			match(input,54,FOLLOW_54_in_problem_header806); 
			match(input,NAME,FOLLOW_NAME_in_problem_header808); 
			match(input,13,FOLLOW_13_in_problem_header810); 
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
			int alt14=7;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==12) ) {
				switch ( input.LA(2) ) {
				case 19:
					{
					alt14=1;
					}
					break;
				case 36:
					{
					alt14=2;
					}
					break;
				case 39:
					{
					alt14=3;
					}
					break;
				case 30:
					{
					alt14=4;
					}
					break;
				case 26:
					{
					alt14=5;
					}
					break;
				case 22:
				case 24:
					{
					alt14=6;
					}
					break;
				case 27:
					{
					alt14=7;
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
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:206:4: domain_reference
					{
					pushFollow(FOLLOW_domain_reference_in_problem_item824);
					domain_reference();
					state._fsp--;

					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:207:4: require_def
					{
					pushFollow(FOLLOW_require_def_in_problem_item829);
					require_def();
					state._fsp--;

					}
					break;
				case 3 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:208:4: situation
					{
					pushFollow(FOLLOW_situation_in_problem_item834);
					situation();
					state._fsp--;

					}
					break;
				case 4 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:209:4: object_declaration
					{
					pushFollow(FOLLOW_object_declaration_in_problem_item839);
					object_declaration();
					state._fsp--;

					}
					break;
				case 5 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:210:4: init
					{
					pushFollow(FOLLOW_init_in_problem_item844);
					init();
					state._fsp--;

					}
					break;
				case 6 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:211:4: goal
					{
					pushFollow(FOLLOW_goal_in_problem_item849);
					goal();
					state._fsp--;

					}
					break;
				case 7 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:212:4: length_spec
					{
					pushFollow(FOLLOW_length_spec_in_problem_item854);
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
			match(input,12,FOLLOW_12_in_domain_reference866); 
			match(input,19,FOLLOW_19_in_domain_reference868); 
			match(input,NAME,FOLLOW_NAME_in_domain_reference870); 
			match(input,13,FOLLOW_13_in_domain_reference872); 
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
			match(input,12,FOLLOW_12_in_require_def884); 
			match(input,36,FOLLOW_36_in_require_def886); 
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:220:24: ( REQUIRE_KEY )+
			int cnt15=0;
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==REQUIRE_KEY) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:220:24: REQUIRE_KEY
					{
					match(input,REQUIRE_KEY,FOLLOW_REQUIRE_KEY_in_require_def888); 
					}
					break;

				default :
					if ( cnt15 >= 1 ) break loop15;
					EarlyExitException eee = new EarlyExitException(15, input);
					throw eee;
				}
				cnt15++;
			}

			match(input,13,FOLLOW_13_in_require_def891); 
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
			match(input,12,FOLLOW_12_in_situation904); 
			match(input,39,FOLLOW_39_in_situation906); 
			match(input,NAME,FOLLOW_NAME_in_situation908); 
			match(input,13,FOLLOW_13_in_situation910); 
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
			match(input,12,FOLLOW_12_in_object_declaration923); 
			match(input,30,FOLLOW_30_in_object_declaration925); 
			pushFollow(FOLLOW_typed_list_of_name_in_object_declaration927);
			typed_list_of_name();
			state._fsp--;

			match(input,13,FOLLOW_13_in_object_declaration929); 
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
			match(input,12,FOLLOW_12_in_init940); 
			match(input,26,FOLLOW_26_in_init942); 
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:231:21: ( literal_of_name )+
			int cnt16=0;
			loop16:
			while (true) {
				int alt16=2;
				int LA16_0 = input.LA(1);
				if ( (LA16_0==12) ) {
					alt16=1;
				}

				switch (alt16) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:231:21: literal_of_name
					{
					pushFollow(FOLLOW_literal_of_name_in_init944);
					literal_of_name();
					state._fsp--;

					}
					break;

				default :
					if ( cnt16 >= 1 ) break loop16;
					EarlyExitException eee = new EarlyExitException(16, input);
					throw eee;
				}
				cnt16++;
			}

			match(input,13,FOLLOW_13_in_init947); 
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
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==12) ) {
				int LA17_1 = input.LA(2);
				if ( (LA17_1==24) ) {
					alt17=1;
				}
				else if ( (LA17_1==22) ) {
					alt17=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 17, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}

			switch (alt17) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:234:8: '(' ':goal' gd ')'
					{
					match(input,12,FOLLOW_12_in_goal957); 
					match(input,24,FOLLOW_24_in_goal959); 
					pushFollow(FOLLOW_gd_in_goal961);
					gd();
					state._fsp--;

					match(input,13,FOLLOW_13_in_goal963); 
					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:235:4: '(' ':expansion' action_spec_od_action_term ')'
					{
					match(input,12,FOLLOW_12_in_goal968); 
					match(input,22,FOLLOW_22_in_goal970); 
					pushFollow(FOLLOW_action_spec_od_action_term_in_goal972);
					action_spec_od_action_term();
					state._fsp--;

					match(input,13,FOLLOW_13_in_goal974); 
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
			match(input,12,FOLLOW_12_in_length_spec988); 
			match(input,27,FOLLOW_27_in_length_spec990); 
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:239:18: ( '(' ':serial' INTEGER ')' )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==12) ) {
				int LA18_1 = input.LA(2);
				if ( (LA18_1==38) ) {
					alt18=1;
				}
			}
			switch (alt18) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:239:19: '(' ':serial' INTEGER ')'
					{
					match(input,12,FOLLOW_12_in_length_spec993); 
					match(input,38,FOLLOW_38_in_length_spec995); 
					match(input,INTEGER,FOLLOW_INTEGER_in_length_spec997); 
					match(input,13,FOLLOW_13_in_length_spec999); 
					}
					break;

			}

			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:239:47: ( '(' ':parallel' INTEGER ')' )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==12) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:239:48: '(' ':parallel' INTEGER ')'
					{
					match(input,12,FOLLOW_12_in_length_spec1004); 
					match(input,32,FOLLOW_32_in_length_spec1006); 
					match(input,INTEGER,FOLLOW_INTEGER_in_length_spec1008); 
					match(input,13,FOLLOW_13_in_length_spec1010); 
					}
					break;

			}

			match(input,13,FOLLOW_13_in_length_spec1014); 
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
			match(input,12,FOLLOW_12_in_initsit_header1033); 
			match(input,55,FOLLOW_55_in_initsit_header1035); 
			match(input,NAME,FOLLOW_NAME_in_initsit_header1037); 
			match(input,13,FOLLOW_13_in_initsit_header1039); 
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
			match(input,12,FOLLOW_12_in_initsit_body1057); 
			match(input,19,FOLLOW_19_in_initsit_body1059); 
			match(input,NAME,FOLLOW_NAME_in_initsit_body1061); 
			match(input,13,FOLLOW_13_in_initsit_body1063); 
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:249:13: ( initsit_body_item )*
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==12) ) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:249:13: initsit_body_item
					{
					pushFollow(FOLLOW_initsit_body_item_in_initsit_body1077);
					initsit_body_item();
					state._fsp--;

					}
					break;

				default :
					break loop20;
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
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==12) ) {
				int LA21_1 = input.LA(2);
				if ( (LA21_1==30) ) {
					alt21=1;
				}
				else if ( (LA21_1==26) ) {
					alt21=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 21, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}

			switch (alt21) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:253:9: object_declaration
					{
					pushFollow(FOLLOW_object_declaration_in_initsit_body_item1101);
					object_declaration();
					state._fsp--;

					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:254:9: init
					{
					pushFollow(FOLLOW_init_in_initsit_body_item1111);
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
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==12) ) {
				int LA22_1 = input.LA(2);
				if ( (LA22_1==43||LA22_1==48||(LA22_1 >= 50 && LA22_1 <= 53)) ) {
					alt22=2;
				}
				else if ( (LA22_1==NAME) ) {
					alt22=1;
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
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:261:9: atomic_formula_of_term
					{
					pushFollow(FOLLOW_atomic_formula_of_term_in_gd1130);
					atomic_formula_of_term();
					state._fsp--;

					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:262:9: complicated_gd
					{
					pushFollow(FOLLOW_complicated_gd_in_gd1140);
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
			int alt25=7;
			int LA25_0 = input.LA(1);
			if ( (LA25_0==12) ) {
				switch ( input.LA(2) ) {
				case 43:
					{
					alt25=1;
					}
					break;
				case 53:
					{
					alt25=2;
					}
					break;
				case 52:
					{
					int LA25_4 = input.LA(3);
					if ( (LA25_4==12) ) {
						int LA25_8 = input.LA(4);
						if ( (LA25_8==43||LA25_8==48||(LA25_8 >= 50 && LA25_8 <= 53)) ) {
							alt25=4;
						}
						else if ( (LA25_8==NAME) ) {
							alt25=3;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 25, 8, input);
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
								new NoViableAltException("", 25, 4, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case 51:
					{
					alt25=5;
					}
					break;
				case 48:
					{
					alt25=6;
					}
					break;
				case 50:
					{
					alt25=7;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 25, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 25, 0, input);
				throw nvae;
			}

			switch (alt25) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:265:20: '(' 'and' ( gd )* ')'
					{
					match(input,12,FOLLOW_12_in_complicated_gd1155); 
					match(input,43,FOLLOW_43_in_complicated_gd1157); 
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:265:30: ( gd )*
					loop23:
					while (true) {
						int alt23=2;
						int LA23_0 = input.LA(1);
						if ( (LA23_0==12) ) {
							alt23=1;
						}

						switch (alt23) {
						case 1 :
							// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:265:30: gd
							{
							pushFollow(FOLLOW_gd_in_complicated_gd1159);
							gd();
							state._fsp--;

							}
							break;

						default :
							break loop23;
						}
					}

					match(input,13,FOLLOW_13_in_complicated_gd1162); 
					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:266:4: '(' 'or' ( gd )* ')'
					{
					match(input,12,FOLLOW_12_in_complicated_gd1167); 
					match(input,53,FOLLOW_53_in_complicated_gd1169); 
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:266:13: ( gd )*
					loop24:
					while (true) {
						int alt24=2;
						int LA24_0 = input.LA(1);
						if ( (LA24_0==12) ) {
							alt24=1;
						}

						switch (alt24) {
						case 1 :
							// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:266:13: gd
							{
							pushFollow(FOLLOW_gd_in_complicated_gd1171);
							gd();
							state._fsp--;

							}
							break;

						default :
							break loop24;
						}
					}

					match(input,13,FOLLOW_13_in_complicated_gd1174); 
					}
					break;
				case 3 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:267:7: '(' 'not' atomic_formula_of_term ')'
					{
					match(input,12,FOLLOW_12_in_complicated_gd1183); 
					match(input,52,FOLLOW_52_in_complicated_gd1185); 
					pushFollow(FOLLOW_atomic_formula_of_term_in_complicated_gd1187);
					atomic_formula_of_term();
					state._fsp--;

					match(input,13,FOLLOW_13_in_complicated_gd1189); 
					}
					break;
				case 4 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:268:7: '(' 'not' complicated_gd ')'
					{
					match(input,12,FOLLOW_12_in_complicated_gd1198); 
					match(input,52,FOLLOW_52_in_complicated_gd1200); 
					pushFollow(FOLLOW_complicated_gd_in_complicated_gd1202);
					complicated_gd();
					state._fsp--;

					match(input,13,FOLLOW_13_in_complicated_gd1204); 
					}
					break;
				case 5 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:269:4: '(' 'imply' gd gd ')'
					{
					match(input,12,FOLLOW_12_in_complicated_gd1210); 
					match(input,51,FOLLOW_51_in_complicated_gd1212); 
					pushFollow(FOLLOW_gd_in_complicated_gd1214);
					gd();
					state._fsp--;

					pushFollow(FOLLOW_gd_in_complicated_gd1216);
					gd();
					state._fsp--;

					match(input,13,FOLLOW_13_in_complicated_gd1218); 
					}
					break;
				case 6 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:270:4: '(' 'exists' '(' typed_list_of_variable ')' gd ')'
					{
					match(input,12,FOLLOW_12_in_complicated_gd1224); 
					match(input,48,FOLLOW_48_in_complicated_gd1226); 
					match(input,12,FOLLOW_12_in_complicated_gd1228); 
					pushFollow(FOLLOW_typed_list_of_variable_in_complicated_gd1230);
					typed_list_of_variable();
					state._fsp--;

					match(input,13,FOLLOW_13_in_complicated_gd1232); 
					pushFollow(FOLLOW_gd_in_complicated_gd1234);
					gd();
					state._fsp--;

					match(input,13,FOLLOW_13_in_complicated_gd1236); 
					}
					break;
				case 7 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:271:4: '(' 'forall' '(' typed_list_of_variable ')' gd ')'
					{
					match(input,12,FOLLOW_12_in_complicated_gd1242); 
					match(input,50,FOLLOW_50_in_complicated_gd1244); 
					match(input,12,FOLLOW_12_in_complicated_gd1246); 
					pushFollow(FOLLOW_typed_list_of_variable_in_complicated_gd1248);
					typed_list_of_variable();
					state._fsp--;

					match(input,13,FOLLOW_13_in_complicated_gd1250); 
					pushFollow(FOLLOW_gd_in_complicated_gd1252);
					gd();
					state._fsp--;

					match(input,13,FOLLOW_13_in_complicated_gd1254); 
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
			match(input,NAME,FOLLOW_NAME_in_predicate1268); 
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
			int alt26=2;
			int LA26_0 = input.LA(1);
			if ( (LA26_0==12) ) {
				int LA26_1 = input.LA(2);
				if ( (LA26_1==52) ) {
					alt26=2;
				}
				else if ( (LA26_1==NAME) ) {
					alt26=1;
				}

				else {
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
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:286:4: atomic_formula_of_name
					{
					pushFollow(FOLLOW_atomic_formula_of_name_in_literal_of_name1298);
					atomic_formula_of_name();
					state._fsp--;

					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:287:4: '(' 'not' atomic_formula_of_name ')'
					{
					match(input,12,FOLLOW_12_in_literal_of_name1303); 
					match(input,52,FOLLOW_52_in_literal_of_name1305); 
					pushFollow(FOLLOW_atomic_formula_of_name_in_literal_of_name1307);
					atomic_formula_of_name();
					state._fsp--;

					match(input,13,FOLLOW_13_in_literal_of_name1309); 
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
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:291:4: atomic_formula_of_term
					{
					pushFollow(FOLLOW_atomic_formula_of_term_in_literal_of_term1320);
					atomic_formula_of_term();
					state._fsp--;

					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:292:4: '(' 'not' atomic_formula_of_term ')'
					{
					match(input,12,FOLLOW_12_in_literal_of_term1325); 
					match(input,52,FOLLOW_52_in_literal_of_term1327); 
					pushFollow(FOLLOW_atomic_formula_of_term_in_literal_of_term1329);
					atomic_formula_of_term();
					state._fsp--;

					match(input,13,FOLLOW_13_in_literal_of_term1331); 
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
			match(input,12,FOLLOW_12_in_atomic_formula_of_term1342); 
			pushFollow(FOLLOW_predicate_in_atomic_formula_of_term1344);
			predicate();
			state._fsp--;

			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:296:18: ( term )*
			loop28:
			while (true) {
				int alt28=2;
				int LA28_0 = input.LA(1);
				if ( (LA28_0==NAME||LA28_0==VARIABLE) ) {
					alt28=1;
				}

				switch (alt28) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:296:18: term
					{
					pushFollow(FOLLOW_term_in_atomic_formula_of_term1346);
					term();
					state._fsp--;

					}
					break;

				default :
					break loop28;
				}
			}

			match(input,13,FOLLOW_13_in_atomic_formula_of_term1349); 
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
			match(input,12,FOLLOW_12_in_atomic_formula_of_name1361); 
			pushFollow(FOLLOW_predicate_in_atomic_formula_of_name1363);
			predicate();
			state._fsp--;

			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:300:18: ( NAME )*
			loop29:
			while (true) {
				int alt29=2;
				int LA29_0 = input.LA(1);
				if ( (LA29_0==NAME) ) {
					alt29=1;
				}

				switch (alt29) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:300:18: NAME
					{
					match(input,NAME,FOLLOW_NAME_in_atomic_formula_of_name1365); 
					}
					break;

				default :
					break loop29;
				}
			}

			match(input,13,FOLLOW_13_in_atomic_formula_of_name1368); 
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
			int alt32=2;
			int LA32_0 = input.LA(1);
			if ( (LA32_0==13) ) {
				alt32=1;
			}
			else if ( (LA32_0==NAME) ) {
				alt32=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 32, 0, input);
				throw nvae;
			}

			switch (alt32) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:305:2: 
					{
					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:305:4: ( NAME )+ ( '-' type typed_list_of_name )?
					{
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:305:4: ( NAME )+
					int cnt30=0;
					loop30:
					while (true) {
						int alt30=2;
						int LA30_0 = input.LA(1);
						if ( (LA30_0==NAME) ) {
							alt30=1;
						}

						switch (alt30) {
						case 1 :
							// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:305:4: NAME
							{
							match(input,NAME,FOLLOW_NAME_in_typed_list_of_name1384); 
							}
							break;

						default :
							if ( cnt30 >= 1 ) break loop30;
							EarlyExitException eee = new EarlyExitException(30, input);
							throw eee;
						}
						cnt30++;
					}

					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:305:10: ( '-' type typed_list_of_name )?
					int alt31=2;
					int LA31_0 = input.LA(1);
					if ( (LA31_0==14) ) {
						alt31=1;
					}
					switch (alt31) {
						case 1 :
							// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:305:11: '-' type typed_list_of_name
							{
							match(input,14,FOLLOW_14_in_typed_list_of_name1388); 
							pushFollow(FOLLOW_type_in_typed_list_of_name1390);
							type();
							state._fsp--;

							pushFollow(FOLLOW_typed_list_of_name_in_typed_list_of_name1392);
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
			int alt35=2;
			int LA35_0 = input.LA(1);
			if ( (LA35_0==13) ) {
				alt35=1;
			}
			else if ( (LA35_0==VARIABLE) ) {
				alt35=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 35, 0, input);
				throw nvae;
			}

			switch (alt35) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:310:2: 
					{
					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:310:4: ( VARIABLE )+ ( '-' type typed_list_of_variable )?
					{
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:310:4: ( VARIABLE )+
					int cnt33=0;
					loop33:
					while (true) {
						int alt33=2;
						int LA33_0 = input.LA(1);
						if ( (LA33_0==VARIABLE) ) {
							alt33=1;
						}

						switch (alt33) {
						case 1 :
							// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:310:4: VARIABLE
							{
							match(input,VARIABLE,FOLLOW_VARIABLE_in_typed_list_of_variable1410); 
							}
							break;

						default :
							if ( cnt33 >= 1 ) break loop33;
							EarlyExitException eee = new EarlyExitException(33, input);
							throw eee;
						}
						cnt33++;
					}

					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:310:14: ( '-' type typed_list_of_variable )?
					int alt34=2;
					int LA34_0 = input.LA(1);
					if ( (LA34_0==14) ) {
						alt34=1;
					}
					switch (alt34) {
						case 1 :
							// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:310:15: '-' type typed_list_of_variable
							{
							match(input,14,FOLLOW_14_in_typed_list_of_variable1414); 
							pushFollow(FOLLOW_type_in_typed_list_of_variable1416);
							type();
							state._fsp--;

							pushFollow(FOLLOW_typed_list_of_variable_in_typed_list_of_variable1418);
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
			int alt37=3;
			int LA37_0 = input.LA(1);
			if ( (LA37_0==NAME) ) {
				alt37=1;
			}
			else if ( (LA37_0==12) ) {
				int LA37_2 = input.LA(2);
				if ( (LA37_2==47) ) {
					alt37=2;
				}
				else if ( (LA37_2==49) ) {
					alt37=3;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 37, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 37, 0, input);
				throw nvae;
			}

			switch (alt37) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:313:9: NAME
					{
					match(input,NAME,FOLLOW_NAME_in_type1432); 
					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:314:4: '(' 'either' ( type )+ ')'
					{
					match(input,12,FOLLOW_12_in_type1437); 
					match(input,47,FOLLOW_47_in_type1439); 
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:314:17: ( type )+
					int cnt36=0;
					loop36:
					while (true) {
						int alt36=2;
						int LA36_0 = input.LA(1);
						if ( (LA36_0==NAME||LA36_0==12) ) {
							alt36=1;
						}

						switch (alt36) {
						case 1 :
							// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:314:17: type
							{
							pushFollow(FOLLOW_type_in_type1441);
							type();
							state._fsp--;

							}
							break;

						default :
							if ( cnt36 >= 1 ) break loop36;
							EarlyExitException eee = new EarlyExitException(36, input);
							throw eee;
						}
						cnt36++;
					}

					match(input,13,FOLLOW_13_in_type1444); 
					}
					break;
				case 3 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:315:4: '(' 'fluent' type ')'
					{
					match(input,12,FOLLOW_12_in_type1449); 
					match(input,49,FOLLOW_49_in_type1451); 
					pushFollow(FOLLOW_type_in_type1453);
					type();
					state._fsp--;

					match(input,13,FOLLOW_13_in_type1455); 
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
			match(input,12,FOLLOW_12_in_method_def1469); 
			match(input,29,FOLLOW_29_in_method_def1471); 
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:322:18: ( general_tree_item )*
			loop38:
			while (true) {
				int alt38=2;
				int LA38_0 = input.LA(1);
				if ( ((LA38_0 >= INTEGER && LA38_0 <= REQUIRE_KEY)||LA38_0==VARIABLE||LA38_0==12||LA38_0==43||LA38_0==52) ) {
					alt38=1;
				}

				switch (alt38) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:322:18: general_tree_item
					{
					pushFollow(FOLLOW_general_tree_item_in_method_def1473);
					general_tree_item();
					state._fsp--;

					}
					break;

				default :
					break loop38;
				}
			}

			match(input,13,FOLLOW_13_in_method_def1476); 
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
			match(input,12,FOLLOW_12_in_atomic_formula_skeleton1491); 
			pushFollow(FOLLOW_predicate_in_atomic_formula_skeleton1493);
			predicate();
			state._fsp--;

			pushFollow(FOLLOW_typed_list_of_variable_in_atomic_formula_skeleton1495);
			typed_list_of_variable();
			state._fsp--;

			match(input,13,FOLLOW_13_in_atomic_formula_skeleton1497); 
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
			int alt39=2;
			int LA39_0 = input.LA(1);
			if ( (LA39_0==NAME) ) {
				alt39=1;
			}
			else if ( (LA39_0==12) ) {
				alt39=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 39, 0, input);
				throw nvae;
			}

			switch (alt39) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:337:4: NAME
					{
					match(input,NAME,FOLLOW_NAME_in_domain_var_declaration1515); 
					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:338:4: '(' NAME NAME ')'
					{
					match(input,12,FOLLOW_12_in_domain_var_declaration1520); 
					match(input,NAME,FOLLOW_NAME_in_domain_var_declaration1522); 
					match(input,NAME,FOLLOW_NAME_in_domain_var_declaration1524); 
					match(input,13,FOLLOW_13_in_domain_var_declaration1526); 
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
			int alt42=2;
			int LA42_0 = input.LA(1);
			if ( (LA42_0==13) ) {
				alt42=1;
			}
			else if ( (LA42_0==NAME||LA42_0==12) ) {
				alt42=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 42, 0, input);
				throw nvae;
			}

			switch (alt42) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:343:2: 
					{
					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:343:4: ( domain_var_declaration )+ ( '-' type typed_list_of_domain_var_declaration )?
					{
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:343:4: ( domain_var_declaration )+
					int cnt40=0;
					loop40:
					while (true) {
						int alt40=2;
						int LA40_0 = input.LA(1);
						if ( (LA40_0==NAME||LA40_0==12) ) {
							alt40=1;
						}

						switch (alt40) {
						case 1 :
							// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:343:4: domain_var_declaration
							{
							pushFollow(FOLLOW_domain_var_declaration_in_typed_list_of_domain_var_declaration1542);
							domain_var_declaration();
							state._fsp--;

							}
							break;

						default :
							if ( cnt40 >= 1 ) break loop40;
							EarlyExitException eee = new EarlyExitException(40, input);
							throw eee;
						}
						cnt40++;
					}

					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:343:28: ( '-' type typed_list_of_domain_var_declaration )?
					int alt41=2;
					int LA41_0 = input.LA(1);
					if ( (LA41_0==14) ) {
						alt41=1;
					}
					switch (alt41) {
						case 1 :
							// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:343:29: '-' type typed_list_of_domain_var_declaration
							{
							match(input,14,FOLLOW_14_in_typed_list_of_domain_var_declaration1546); 
							pushFollow(FOLLOW_type_in_typed_list_of_domain_var_declaration1548);
							type();
							state._fsp--;

							pushFollow(FOLLOW_typed_list_of_domain_var_declaration_in_typed_list_of_domain_var_declaration1550);
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
			match(input,12,FOLLOW_12_in_general_tree1567); 
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:351:8: ( general_tree_item )*
			loop43:
			while (true) {
				int alt43=2;
				int LA43_0 = input.LA(1);
				if ( ((LA43_0 >= INTEGER && LA43_0 <= REQUIRE_KEY)||LA43_0==VARIABLE||LA43_0==12||LA43_0==43||LA43_0==52) ) {
					alt43=1;
				}

				switch (alt43) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:351:8: general_tree_item
					{
					pushFollow(FOLLOW_general_tree_item_in_general_tree1569);
					general_tree_item();
					state._fsp--;

					}
					break;

				default :
					break loop43;
				}
			}

			match(input,13,FOLLOW_13_in_general_tree1572); 
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
			int alt44=7;
			switch ( input.LA(1) ) {
			case NAME:
				{
				alt44=1;
				}
				break;
			case INTEGER:
				{
				alt44=2;
				}
				break;
			case VARIABLE:
				{
				alt44=3;
				}
				break;
			case REQUIRE_KEY:
				{
				alt44=4;
				}
				break;
			case 43:
				{
				alt44=5;
				}
				break;
			case 52:
				{
				alt44=6;
				}
				break;
			case 12:
				{
				alt44=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 44, 0, input);
				throw nvae;
			}
			switch (alt44) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:355:4: NAME
					{
					match(input,NAME,FOLLOW_NAME_in_general_tree_item1584); 
					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:356:4: INTEGER
					{
					match(input,INTEGER,FOLLOW_INTEGER_in_general_tree_item1589); 
					}
					break;
				case 3 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:357:4: VARIABLE
					{
					match(input,VARIABLE,FOLLOW_VARIABLE_in_general_tree_item1594); 
					}
					break;
				case 4 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:358:4: REQUIRE_KEY
					{
					match(input,REQUIRE_KEY,FOLLOW_REQUIRE_KEY_in_general_tree_item1599); 
					}
					break;
				case 5 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:359:4: 'and'
					{
					match(input,43,FOLLOW_43_in_general_tree_item1605); 
					}
					break;
				case 6 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:360:4: 'not'
					{
					match(input,52,FOLLOW_52_in_general_tree_item1610); 
					}
					break;
				case 7 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:361:4: general_tree
					{
					pushFollow(FOLLOW_general_tree_in_general_tree_item1615);
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
	public static final BitSet FOLLOW_typed_list_of_variable_in_effect591 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_effect593 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_effect_in_effect595 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_effect597 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_effect609 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_effect611 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_gd_in_effect613 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_effect_in_effect615 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_effect617 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_effect629 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_44_in_effect631 = new BitSet(new long[]{0x00100800000015C0L});
	public static final BitSet FOLLOW_fluent_in_effect633 = new BitSet(new long[]{0x00100800000015C0L});
	public static final BitSet FOLLOW_expression_in_effect635 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_effect637 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_general_tree_item_in_fluent659 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_general_tree_item_in_expression683 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_general_tree_in_action_spec706 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_general_tree_in_action_spec_od_action_term721 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_axiom_def737 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_axiom_def739 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_42_in_axiom_def751 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_axiom_def753 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_typed_list_of_variable_in_axiom_def755 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_axiom_def757 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_axiom_def768 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_gd_in_axiom_def770 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_25_in_axiom_def781 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_literal_of_term_in_axiom_def783 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_axiom_def785 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_problem_header804 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_54_in_problem_header806 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_NAME_in_problem_header808 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_problem_header810 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_domain_reference_in_problem_item824 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_require_def_in_problem_item829 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_situation_in_problem_item834 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_object_declaration_in_problem_item839 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_init_in_problem_item844 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_goal_in_problem_item849 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_length_spec_in_problem_item854 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_domain_reference866 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_domain_reference868 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_NAME_in_domain_reference870 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_domain_reference872 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_require_def884 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_require_def886 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_REQUIRE_KEY_in_require_def888 = new BitSet(new long[]{0x0000000000002100L});
	public static final BitSet FOLLOW_13_in_require_def891 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_situation904 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_39_in_situation906 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_NAME_in_situation908 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_situation910 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_object_declaration923 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_object_declaration925 = new BitSet(new long[]{0x0000000000002080L});
	public static final BitSet FOLLOW_typed_list_of_name_in_object_declaration927 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_object_declaration929 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_init940 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_26_in_init942 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_literal_of_name_in_init944 = new BitSet(new long[]{0x0000000000003000L});
	public static final BitSet FOLLOW_13_in_init947 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_goal957 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_goal959 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_gd_in_goal961 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_goal963 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_goal968 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_goal970 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_action_spec_od_action_term_in_goal972 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_goal974 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_length_spec988 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_length_spec990 = new BitSet(new long[]{0x0000000000003000L});
	public static final BitSet FOLLOW_12_in_length_spec993 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_length_spec995 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_INTEGER_in_length_spec997 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_length_spec999 = new BitSet(new long[]{0x0000000000003000L});
	public static final BitSet FOLLOW_12_in_length_spec1004 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_length_spec1006 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_INTEGER_in_length_spec1008 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_length_spec1010 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_length_spec1014 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_initsit_header1033 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_55_in_initsit_header1035 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_NAME_in_initsit_header1037 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_initsit_header1039 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_initsit_body1057 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_initsit_body1059 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_NAME_in_initsit_body1061 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_initsit_body1063 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_initsit_body_item_in_initsit_body1077 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_object_declaration_in_initsit_body_item1101 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_init_in_initsit_body_item1111 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomic_formula_of_term_in_gd1130 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_complicated_gd_in_gd1140 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_complicated_gd1155 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_complicated_gd1157 = new BitSet(new long[]{0x0000000000003000L});
	public static final BitSet FOLLOW_gd_in_complicated_gd1159 = new BitSet(new long[]{0x0000000000003000L});
	public static final BitSet FOLLOW_13_in_complicated_gd1162 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_complicated_gd1167 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_53_in_complicated_gd1169 = new BitSet(new long[]{0x0000000000003000L});
	public static final BitSet FOLLOW_gd_in_complicated_gd1171 = new BitSet(new long[]{0x0000000000003000L});
	public static final BitSet FOLLOW_13_in_complicated_gd1174 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_complicated_gd1183 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_52_in_complicated_gd1185 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_atomic_formula_of_term_in_complicated_gd1187 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_complicated_gd1189 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_complicated_gd1198 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_52_in_complicated_gd1200 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_complicated_gd_in_complicated_gd1202 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_complicated_gd1204 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_complicated_gd1210 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_51_in_complicated_gd1212 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_gd_in_complicated_gd1214 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_gd_in_complicated_gd1216 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_complicated_gd1218 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_complicated_gd1224 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_48_in_complicated_gd1226 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_complicated_gd1228 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_typed_list_of_variable_in_complicated_gd1230 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_complicated_gd1232 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_gd_in_complicated_gd1234 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_complicated_gd1236 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_complicated_gd1242 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_50_in_complicated_gd1244 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_complicated_gd1246 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_typed_list_of_variable_in_complicated_gd1248 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_complicated_gd1250 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_gd_in_complicated_gd1252 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_complicated_gd1254 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_predicate1268 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomic_formula_of_name_in_literal_of_name1298 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_literal_of_name1303 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_52_in_literal_of_name1305 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_atomic_formula_of_name_in_literal_of_name1307 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_literal_of_name1309 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomic_formula_of_term_in_literal_of_term1320 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_literal_of_term1325 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_52_in_literal_of_term1327 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_atomic_formula_of_term_in_literal_of_term1329 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_literal_of_term1331 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_atomic_formula_of_term1342 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_predicate_in_atomic_formula_of_term1344 = new BitSet(new long[]{0x0000000000002480L});
	public static final BitSet FOLLOW_term_in_atomic_formula_of_term1346 = new BitSet(new long[]{0x0000000000002480L});
	public static final BitSet FOLLOW_13_in_atomic_formula_of_term1349 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_atomic_formula_of_name1361 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_predicate_in_atomic_formula_of_name1363 = new BitSet(new long[]{0x0000000000002080L});
	public static final BitSet FOLLOW_NAME_in_atomic_formula_of_name1365 = new BitSet(new long[]{0x0000000000002080L});
	public static final BitSet FOLLOW_13_in_atomic_formula_of_name1368 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_typed_list_of_name1384 = new BitSet(new long[]{0x0000000000004082L});
	public static final BitSet FOLLOW_14_in_typed_list_of_name1388 = new BitSet(new long[]{0x0000000000001080L});
	public static final BitSet FOLLOW_type_in_typed_list_of_name1390 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_typed_list_of_name_in_typed_list_of_name1392 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VARIABLE_in_typed_list_of_variable1410 = new BitSet(new long[]{0x0000000000004402L});
	public static final BitSet FOLLOW_14_in_typed_list_of_variable1414 = new BitSet(new long[]{0x0000000000001080L});
	public static final BitSet FOLLOW_type_in_typed_list_of_variable1416 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_typed_list_of_variable_in_typed_list_of_variable1418 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_type1432 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_type1437 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_type1439 = new BitSet(new long[]{0x0000000000001080L});
	public static final BitSet FOLLOW_type_in_type1441 = new BitSet(new long[]{0x0000000000003080L});
	public static final BitSet FOLLOW_13_in_type1444 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_type1449 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_49_in_type1451 = new BitSet(new long[]{0x0000000000001080L});
	public static final BitSet FOLLOW_type_in_type1453 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_type1455 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_method_def1469 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_29_in_method_def1471 = new BitSet(new long[]{0x00100800000035C0L});
	public static final BitSet FOLLOW_general_tree_item_in_method_def1473 = new BitSet(new long[]{0x00100800000035C0L});
	public static final BitSet FOLLOW_13_in_method_def1476 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_atomic_formula_skeleton1491 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_predicate_in_atomic_formula_skeleton1493 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_typed_list_of_variable_in_atomic_formula_skeleton1495 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_atomic_formula_skeleton1497 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_domain_var_declaration1515 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_domain_var_declaration1520 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_NAME_in_domain_var_declaration1522 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_NAME_in_domain_var_declaration1524 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_domain_var_declaration1526 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_domain_var_declaration_in_typed_list_of_domain_var_declaration1542 = new BitSet(new long[]{0x0000000000005082L});
	public static final BitSet FOLLOW_14_in_typed_list_of_domain_var_declaration1546 = new BitSet(new long[]{0x0000000000001080L});
	public static final BitSet FOLLOW_type_in_typed_list_of_domain_var_declaration1548 = new BitSet(new long[]{0x0000000000001080L});
	public static final BitSet FOLLOW_typed_list_of_domain_var_declaration_in_typed_list_of_domain_var_declaration1550 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_general_tree1567 = new BitSet(new long[]{0x00100800000035C0L});
	public static final BitSet FOLLOW_general_tree_item_in_general_tree1569 = new BitSet(new long[]{0x00100800000035C0L});
	public static final BitSet FOLLOW_13_in_general_tree1572 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_general_tree_item1584 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_general_tree_item1589 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VARIABLE_in_general_tree_item1594 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_REQUIRE_KEY_in_general_tree_item1599 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_43_in_general_tree_item1605 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_52_in_general_tree_item1610 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_general_tree_in_general_tree_item1615 = new BitSet(new long[]{0x0000000000000002L});
}
