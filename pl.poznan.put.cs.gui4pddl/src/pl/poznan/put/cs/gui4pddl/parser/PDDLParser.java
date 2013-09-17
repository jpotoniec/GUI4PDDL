// $ANTLR 3.5 /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g 2013-09-17 14:49:46

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
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "INTEGER", "NAME", 
		"REQUIRE_KEY", "VARIABLE", "WS", "'('", "')'", "'-'", "':action'", "':axiom'", 
		"':constants'", "':domain'", "':domain-variables'", "':expansion'", "':extends'", 
		"':goal'", "':init'", "':length'", "':method'", "':objects'", "':parallel'", 
		"':predicates'", "':requirements'", "':safety'", "':serial'", "':situation'", 
		"':timeless'", "':types'", "'and'", "'define'", "'domain'", "'either'", 
		"'exists'", "'fluent'", "'forall'", "'imply'", "'not'", "'or'", "'problem'"
	};
	public static final int EOF=-1;
	public static final int T__10=10;
	public static final int T__11=11;
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
	public static final int COMMENT=4;
	public static final int INTEGER=5;
	public static final int NAME=6;
	public static final int REQUIRE_KEY=7;
	public static final int VARIABLE=8;
	public static final int WS=9;

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


	    private List<String> errors = new LinkedList<String>();
	    public void displayRecognitionError(String[] tokenNames,
	                                        RecognitionException e) {
	        String hdr = getErrorHeader(e);
	        String msg = getErrorMessage(e, tokenNames);
	        errors.add(hdr + " " + msg);
	    }
	    public List<String> getErrors() {
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



	// $ANTLR start "definition"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:57:1: definition : ( '(' 'define' problem_header ( problem_item )* ')' | '(' 'define' domain_header ( domain_item )* ')' );
	public final void definition() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:58:2: ( '(' 'define' problem_header ( problem_item )* ')' | '(' 'define' domain_header ( domain_item )* ')' )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==10) ) {
				int LA3_1 = input.LA(2);
				if ( (LA3_1==34) ) {
					int LA3_2 = input.LA(3);
					if ( (LA3_2==10) ) {
						int LA3_3 = input.LA(4);
						if ( (LA3_3==43) ) {
							alt3=1;
						}
						else if ( (LA3_3==35) ) {
							alt3=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 3, 3, input);
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
								new NoViableAltException("", 3, 2, input);
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
							new NoViableAltException("", 3, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:58:4: '(' 'define' problem_header ( problem_item )* ')'
					{
					match(input,10,FOLLOW_10_in_definition33); 
					match(input,34,FOLLOW_34_in_definition35); 
					pushFollow(FOLLOW_problem_header_in_definition37);
					problem_header();
					state._fsp--;

					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:58:32: ( problem_item )*
					loop1:
					while (true) {
						int alt1=2;
						int LA1_0 = input.LA(1);
						if ( (LA1_0==10) ) {
							alt1=1;
						}

						switch (alt1) {
						case 1 :
							// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:58:32: problem_item
							{
							pushFollow(FOLLOW_problem_item_in_definition39);
							problem_item();
							state._fsp--;

							}
							break;

						default :
							break loop1;
						}
					}

					match(input,11,FOLLOW_11_in_definition42); 
					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:59:4: '(' 'define' domain_header ( domain_item )* ')'
					{
					match(input,10,FOLLOW_10_in_definition47); 
					match(input,34,FOLLOW_34_in_definition49); 
					pushFollow(FOLLOW_domain_header_in_definition51);
					domain_header();
					state._fsp--;

					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:59:31: ( domain_item )*
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( (LA2_0==10) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:59:31: domain_item
							{
							pushFollow(FOLLOW_domain_item_in_definition53);
							domain_item();
							state._fsp--;

							}
							break;

						default :
							break loop2;
						}
					}

					match(input,11,FOLLOW_11_in_definition56); 
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
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:66:1: domain_header : '(' 'domain' NAME ')' ;
	public final void domain_header() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:67:2: ( '(' 'domain' NAME ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:67:4: '(' 'domain' NAME ')'
			{
			match(input,10,FOLLOW_10_in_domain_header71); 
			match(input,35,FOLLOW_35_in_domain_header73); 
			match(input,NAME,FOLLOW_NAME_in_domain_header75); 
			match(input,11,FOLLOW_11_in_domain_header77); 
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
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:70:1: domain_item : ( extension_def | require_def | types_def | constants_def | domain_vars_def | predicates_def | timeless_def | safety_def | structure_def );
	public final void domain_item() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:71:2: ( extension_def | require_def | types_def | constants_def | domain_vars_def | predicates_def | timeless_def | safety_def | structure_def )
			int alt4=9;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==10) ) {
				switch ( input.LA(2) ) {
				case 19:
					{
					alt4=1;
					}
					break;
				case 27:
					{
					alt4=2;
					}
					break;
				case 32:
					{
					alt4=3;
					}
					break;
				case 15:
					{
					alt4=4;
					}
					break;
				case 17:
					{
					alt4=5;
					}
					break;
				case 26:
					{
					alt4=6;
					}
					break;
				case 31:
					{
					alt4=7;
					}
					break;
				case 28:
					{
					alt4=8;
					}
					break;
				case 13:
				case 14:
				case 23:
					{
					alt4=9;
					}
					break;
				default:
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
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:71:4: extension_def
					{
					pushFollow(FOLLOW_extension_def_in_domain_item88);
					extension_def();
					state._fsp--;

					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:72:4: require_def
					{
					pushFollow(FOLLOW_require_def_in_domain_item93);
					require_def();
					state._fsp--;

					}
					break;
				case 3 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:73:4: types_def
					{
					pushFollow(FOLLOW_types_def_in_domain_item98);
					types_def();
					state._fsp--;

					}
					break;
				case 4 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:74:4: constants_def
					{
					pushFollow(FOLLOW_constants_def_in_domain_item105);
					constants_def();
					state._fsp--;

					}
					break;
				case 5 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:75:4: domain_vars_def
					{
					pushFollow(FOLLOW_domain_vars_def_in_domain_item110);
					domain_vars_def();
					state._fsp--;

					}
					break;
				case 6 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:76:4: predicates_def
					{
					pushFollow(FOLLOW_predicates_def_in_domain_item116);
					predicates_def();
					state._fsp--;

					}
					break;
				case 7 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:77:4: timeless_def
					{
					pushFollow(FOLLOW_timeless_def_in_domain_item121);
					timeless_def();
					state._fsp--;

					}
					break;
				case 8 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:78:4: safety_def
					{
					pushFollow(FOLLOW_safety_def_in_domain_item126);
					safety_def();
					state._fsp--;

					}
					break;
				case 9 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:79:4: structure_def
					{
					pushFollow(FOLLOW_structure_def_in_domain_item132);
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
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:82:1: extension_def : '(' ':extends' ( NAME )+ ')' ;
	public final void extension_def() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:83:2: ( '(' ':extends' ( NAME )+ ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:83:4: '(' ':extends' ( NAME )+ ')'
			{
			match(input,10,FOLLOW_10_in_extension_def145); 
			match(input,19,FOLLOW_19_in_extension_def147); 
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:83:19: ( NAME )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==NAME) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:83:19: NAME
					{
					match(input,NAME,FOLLOW_NAME_in_extension_def149); 
					}
					break;

				default :
					if ( cnt5 >= 1 ) break loop5;
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
			}

			match(input,11,FOLLOW_11_in_extension_def152); 
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
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:86:1: types_def : '(' ':types' typed_list_of_name ')' ;
	public final void types_def() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:87:2: ( '(' ':types' typed_list_of_name ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:87:4: '(' ':types' typed_list_of_name ')'
			{
			match(input,10,FOLLOW_10_in_types_def165); 
			match(input,32,FOLLOW_32_in_types_def167); 
			pushFollow(FOLLOW_typed_list_of_name_in_types_def169);
			typed_list_of_name();
			state._fsp--;

			match(input,11,FOLLOW_11_in_types_def171); 
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
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:90:1: constants_def : '(' ':constants' typed_list_of_name ')' ;
	public final void constants_def() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:91:2: ( '(' ':constants' typed_list_of_name ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:91:4: '(' ':constants' typed_list_of_name ')'
			{
			match(input,10,FOLLOW_10_in_constants_def183); 
			match(input,15,FOLLOW_15_in_constants_def185); 
			pushFollow(FOLLOW_typed_list_of_name_in_constants_def187);
			typed_list_of_name();
			state._fsp--;

			match(input,11,FOLLOW_11_in_constants_def189); 
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
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:94:1: domain_vars_def : '(' ':domain-variables' typed_list_of_domain_var_declaration ')' ;
	public final void domain_vars_def() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:95:2: ( '(' ':domain-variables' typed_list_of_domain_var_declaration ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:95:4: '(' ':domain-variables' typed_list_of_domain_var_declaration ')'
			{
			match(input,10,FOLLOW_10_in_domain_vars_def200); 
			match(input,17,FOLLOW_17_in_domain_vars_def202); 
			pushFollow(FOLLOW_typed_list_of_domain_var_declaration_in_domain_vars_def204);
			typed_list_of_domain_var_declaration();
			state._fsp--;

			match(input,11,FOLLOW_11_in_domain_vars_def206); 
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
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:98:1: predicates_def : '(' ':predicates' ( atomic_formula_skeleton )+ ')' ;
	public final void predicates_def() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:99:2: ( '(' ':predicates' ( atomic_formula_skeleton )+ ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:99:4: '(' ':predicates' ( atomic_formula_skeleton )+ ')'
			{
			match(input,10,FOLLOW_10_in_predicates_def218); 
			match(input,26,FOLLOW_26_in_predicates_def220); 
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:99:22: ( atomic_formula_skeleton )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==10) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:99:22: atomic_formula_skeleton
					{
					pushFollow(FOLLOW_atomic_formula_skeleton_in_predicates_def222);
					atomic_formula_skeleton();
					state._fsp--;

					}
					break;

				default :
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
			}

			match(input,11,FOLLOW_11_in_predicates_def225); 
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
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:102:1: timeless_def : '(' ':timeless' ( literal_of_name )+ ')' ;
	public final void timeless_def() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:103:2: ( '(' ':timeless' ( literal_of_name )+ ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:103:4: '(' ':timeless' ( literal_of_name )+ ')'
			{
			match(input,10,FOLLOW_10_in_timeless_def236); 
			match(input,31,FOLLOW_31_in_timeless_def238); 
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:103:20: ( literal_of_name )+
			int cnt7=0;
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==10) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:103:20: literal_of_name
					{
					pushFollow(FOLLOW_literal_of_name_in_timeless_def240);
					literal_of_name();
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

			match(input,11,FOLLOW_11_in_timeless_def243); 
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
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:106:1: safety_def : '(' ':safety' gd ')' ;
	public final void safety_def() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:107:2: ( '(' ':safety' gd ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:107:4: '(' ':safety' gd ')'
			{
			match(input,10,FOLLOW_10_in_safety_def256); 
			match(input,28,FOLLOW_28_in_safety_def258); 
			pushFollow(FOLLOW_gd_in_safety_def260);
			gd();
			state._fsp--;

			match(input,11,FOLLOW_11_in_safety_def262); 
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
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:110:1: structure_def : ( action_def | axiom_def | method_def );
	public final void structure_def() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:111:2: ( action_def | axiom_def | method_def )
			int alt8=3;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==10) ) {
				switch ( input.LA(2) ) {
				case 13:
					{
					alt8=1;
					}
					break;
				case 14:
					{
					alt8=2;
					}
					break;
				case 23:
					{
					alt8=3;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 8, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:111:4: action_def
					{
					pushFollow(FOLLOW_action_def_in_structure_def275);
					action_def();
					state._fsp--;

					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:112:4: axiom_def
					{
					pushFollow(FOLLOW_axiom_def_in_structure_def280);
					axiom_def();
					state._fsp--;

					}
					break;
				case 3 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:113:4: method_def
					{
					pushFollow(FOLLOW_method_def_in_structure_def286);
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
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:119:1: action_def : '(' ':action' ( general_tree_item )* ')' ;
	public final void action_def() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:120:2: ( '(' ':action' ( general_tree_item )* ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:120:4: '(' ':action' ( general_tree_item )* ')'
			{
			match(input,10,FOLLOW_10_in_action_def302); 
			match(input,13,FOLLOW_13_in_action_def304); 
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:120:18: ( general_tree_item )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= INTEGER && LA9_0 <= VARIABLE)||LA9_0==10||LA9_0==33||LA9_0==41) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:120:18: general_tree_item
					{
					pushFollow(FOLLOW_general_tree_item_in_action_def306);
					general_tree_item();
					state._fsp--;

					}
					break;

				default :
					break loop9;
				}
			}

			match(input,11,FOLLOW_11_in_action_def309); 
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



	// $ANTLR start "axiom_def"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:126:1: axiom_def : '(' ':axiom' ( general_tree_item )* ')' ;
	public final void axiom_def() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:127:2: ( '(' ':axiom' ( general_tree_item )* ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:127:4: '(' ':axiom' ( general_tree_item )* ')'
			{
			match(input,10,FOLLOW_10_in_axiom_def325); 
			match(input,14,FOLLOW_14_in_axiom_def327); 
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:127:17: ( general_tree_item )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( ((LA10_0 >= INTEGER && LA10_0 <= VARIABLE)||LA10_0==10||LA10_0==33||LA10_0==41) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:127:17: general_tree_item
					{
					pushFollow(FOLLOW_general_tree_item_in_axiom_def329);
					general_tree_item();
					state._fsp--;

					}
					break;

				default :
					break loop10;
				}
			}

			match(input,11,FOLLOW_11_in_axiom_def332); 
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



	// $ANTLR start "method_def"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:133:1: method_def : '(' ':method' ( general_tree_item )* ')' ;
	public final void method_def() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:134:2: ( '(' ':method' ( general_tree_item )* ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:134:4: '(' ':method' ( general_tree_item )* ')'
			{
			match(input,10,FOLLOW_10_in_method_def346); 
			match(input,23,FOLLOW_23_in_method_def348); 
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:134:18: ( general_tree_item )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( ((LA11_0 >= INTEGER && LA11_0 <= VARIABLE)||LA11_0==10||LA11_0==33||LA11_0==41) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:134:18: general_tree_item
					{
					pushFollow(FOLLOW_general_tree_item_in_method_def350);
					general_tree_item();
					state._fsp--;

					}
					break;

				default :
					break loop11;
				}
			}

			match(input,11,FOLLOW_11_in_method_def353); 
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
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:139:1: atomic_formula_skeleton : '(' predicate typed_list_of_variable ')' ;
	public final void atomic_formula_skeleton() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:140:2: ( '(' predicate typed_list_of_variable ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:140:4: '(' predicate typed_list_of_variable ')'
			{
			match(input,10,FOLLOW_10_in_atomic_formula_skeleton368); 
			pushFollow(FOLLOW_predicate_in_atomic_formula_skeleton370);
			predicate();
			state._fsp--;

			pushFollow(FOLLOW_typed_list_of_variable_in_atomic_formula_skeleton372);
			typed_list_of_variable();
			state._fsp--;

			match(input,11,FOLLOW_11_in_atomic_formula_skeleton374); 
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



	// $ANTLR start "problem_header"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:150:1: problem_header : '(' 'problem' NAME ')' ;
	public final void problem_header() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:150:16: ( '(' 'problem' NAME ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:150:18: '(' 'problem' NAME ')'
			{
			match(input,10,FOLLOW_10_in_problem_header392); 
			match(input,43,FOLLOW_43_in_problem_header394); 
			match(input,NAME,FOLLOW_NAME_in_problem_header396); 
			match(input,11,FOLLOW_11_in_problem_header398); 
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
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:153:1: problem_item : ( domain_reference | require_def | situation | object_declaration | init | goal | length_spec );
	public final void problem_item() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:154:2: ( domain_reference | require_def | situation | object_declaration | init | goal | length_spec )
			int alt12=7;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==10) ) {
				switch ( input.LA(2) ) {
				case 16:
					{
					alt12=1;
					}
					break;
				case 27:
					{
					alt12=2;
					}
					break;
				case 30:
					{
					alt12=3;
					}
					break;
				case 24:
					{
					alt12=4;
					}
					break;
				case 21:
					{
					alt12=5;
					}
					break;
				case 18:
				case 20:
					{
					alt12=6;
					}
					break;
				case 22:
					{
					alt12=7;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 12, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}

			switch (alt12) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:154:4: domain_reference
					{
					pushFollow(FOLLOW_domain_reference_in_problem_item412);
					domain_reference();
					state._fsp--;

					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:155:4: require_def
					{
					pushFollow(FOLLOW_require_def_in_problem_item417);
					require_def();
					state._fsp--;

					}
					break;
				case 3 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:156:4: situation
					{
					pushFollow(FOLLOW_situation_in_problem_item422);
					situation();
					state._fsp--;

					}
					break;
				case 4 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:157:4: object_declaration
					{
					pushFollow(FOLLOW_object_declaration_in_problem_item427);
					object_declaration();
					state._fsp--;

					}
					break;
				case 5 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:158:4: init
					{
					pushFollow(FOLLOW_init_in_problem_item432);
					init();
					state._fsp--;

					}
					break;
				case 6 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:159:4: goal
					{
					pushFollow(FOLLOW_goal_in_problem_item437);
					goal();
					state._fsp--;

					}
					break;
				case 7 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:160:4: length_spec
					{
					pushFollow(FOLLOW_length_spec_in_problem_item442);
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
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:163:1: domain_reference : '(' ':domain' NAME ')' ;
	public final void domain_reference() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:164:2: ( '(' ':domain' NAME ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:164:4: '(' ':domain' NAME ')'
			{
			match(input,10,FOLLOW_10_in_domain_reference454); 
			match(input,16,FOLLOW_16_in_domain_reference456); 
			match(input,NAME,FOLLOW_NAME_in_domain_reference458); 
			match(input,11,FOLLOW_11_in_domain_reference460); 
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
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:167:1: require_def : '(' ':requirements' ( REQUIRE_KEY )+ ')' ;
	public final void require_def() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:168:2: ( '(' ':requirements' ( REQUIRE_KEY )+ ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:168:4: '(' ':requirements' ( REQUIRE_KEY )+ ')'
			{
			match(input,10,FOLLOW_10_in_require_def472); 
			match(input,27,FOLLOW_27_in_require_def474); 
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:168:24: ( REQUIRE_KEY )+
			int cnt13=0;
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==REQUIRE_KEY) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:168:24: REQUIRE_KEY
					{
					match(input,REQUIRE_KEY,FOLLOW_REQUIRE_KEY_in_require_def476); 
					}
					break;

				default :
					if ( cnt13 >= 1 ) break loop13;
					EarlyExitException eee = new EarlyExitException(13, input);
					throw eee;
				}
				cnt13++;
			}

			match(input,11,FOLLOW_11_in_require_def479); 
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
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:171:1: situation : '(' ':situation' NAME ')' ;
	public final void situation() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:172:2: ( '(' ':situation' NAME ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:172:4: '(' ':situation' NAME ')'
			{
			match(input,10,FOLLOW_10_in_situation492); 
			match(input,30,FOLLOW_30_in_situation494); 
			match(input,NAME,FOLLOW_NAME_in_situation496); 
			match(input,11,FOLLOW_11_in_situation498); 
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
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:175:1: object_declaration : '(' ':objects' typed_list_of_name ')' ;
	public final void object_declaration() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:176:2: ( '(' ':objects' typed_list_of_name ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:176:4: '(' ':objects' typed_list_of_name ')'
			{
			match(input,10,FOLLOW_10_in_object_declaration511); 
			match(input,24,FOLLOW_24_in_object_declaration513); 
			pushFollow(FOLLOW_typed_list_of_name_in_object_declaration515);
			typed_list_of_name();
			state._fsp--;

			match(input,11,FOLLOW_11_in_object_declaration517); 
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
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:179:1: init : '(' ':init' ( literal_of_name )+ ')' ;
	public final void init() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:179:7: ( '(' ':init' ( literal_of_name )+ ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:179:9: '(' ':init' ( literal_of_name )+ ')'
			{
			match(input,10,FOLLOW_10_in_init528); 
			match(input,21,FOLLOW_21_in_init530); 
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:179:21: ( literal_of_name )+
			int cnt14=0;
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==10) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:179:21: literal_of_name
					{
					pushFollow(FOLLOW_literal_of_name_in_init532);
					literal_of_name();
					state._fsp--;

					}
					break;

				default :
					if ( cnt14 >= 1 ) break loop14;
					EarlyExitException eee = new EarlyExitException(14, input);
					throw eee;
				}
				cnt14++;
			}

			match(input,11,FOLLOW_11_in_init535); 
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
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:182:1: goal : ( '(' ':goal' gd ')' | '(' ':expansion' action_spec_od_action_term ')' );
	public final void goal() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:182:6: ( '(' ':goal' gd ')' | '(' ':expansion' action_spec_od_action_term ')' )
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==10) ) {
				int LA15_1 = input.LA(2);
				if ( (LA15_1==20) ) {
					alt15=1;
				}
				else if ( (LA15_1==18) ) {
					alt15=2;
				}

				else {
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
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:182:8: '(' ':goal' gd ')'
					{
					match(input,10,FOLLOW_10_in_goal545); 
					match(input,20,FOLLOW_20_in_goal547); 
					pushFollow(FOLLOW_gd_in_goal549);
					gd();
					state._fsp--;

					match(input,11,FOLLOW_11_in_goal551); 
					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:183:4: '(' ':expansion' action_spec_od_action_term ')'
					{
					match(input,10,FOLLOW_10_in_goal556); 
					match(input,18,FOLLOW_18_in_goal558); 
					pushFollow(FOLLOW_action_spec_od_action_term_in_goal560);
					action_spec_od_action_term();
					state._fsp--;

					match(input,11,FOLLOW_11_in_goal562); 
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
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:186:1: length_spec : '(' ':length' ( '(' ':serial' INTEGER ')' )? ( '(' ':parallel' INTEGER ')' )? ')' ;
	public final void length_spec() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:187:2: ( '(' ':length' ( '(' ':serial' INTEGER ')' )? ( '(' ':parallel' INTEGER ')' )? ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:187:4: '(' ':length' ( '(' ':serial' INTEGER ')' )? ( '(' ':parallel' INTEGER ')' )? ')'
			{
			match(input,10,FOLLOW_10_in_length_spec576); 
			match(input,22,FOLLOW_22_in_length_spec578); 
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:187:18: ( '(' ':serial' INTEGER ')' )?
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==10) ) {
				int LA16_1 = input.LA(2);
				if ( (LA16_1==29) ) {
					alt16=1;
				}
			}
			switch (alt16) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:187:19: '(' ':serial' INTEGER ')'
					{
					match(input,10,FOLLOW_10_in_length_spec581); 
					match(input,29,FOLLOW_29_in_length_spec583); 
					match(input,INTEGER,FOLLOW_INTEGER_in_length_spec585); 
					match(input,11,FOLLOW_11_in_length_spec587); 
					}
					break;

			}

			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:187:47: ( '(' ':parallel' INTEGER ')' )?
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==10) ) {
				alt17=1;
			}
			switch (alt17) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:187:48: '(' ':parallel' INTEGER ')'
					{
					match(input,10,FOLLOW_10_in_length_spec592); 
					match(input,25,FOLLOW_25_in_length_spec594); 
					match(input,INTEGER,FOLLOW_INTEGER_in_length_spec596); 
					match(input,11,FOLLOW_11_in_length_spec598); 
					}
					break;

			}

			match(input,11,FOLLOW_11_in_length_spec602); 
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



	// $ANTLR start "gd"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:194:1: gd : ( '(' 'and' ( gd )* ')' | literal_of_term | '(' 'or' ( gd )* ')' | '(' 'imply' gd gd ')' | '(' 'exists' '(' typed_list_of_variable ')' gd ')' | '(' 'forall' '(' typed_list_of_variable ')' gd ')' );
	public final void gd() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:194:5: ( '(' 'and' ( gd )* ')' | literal_of_term | '(' 'or' ( gd )* ')' | '(' 'imply' gd gd ')' | '(' 'exists' '(' typed_list_of_variable ')' gd ')' | '(' 'forall' '(' typed_list_of_variable ')' gd ')' )
			int alt20=6;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==10) ) {
				switch ( input.LA(2) ) {
				case 33:
					{
					alt20=1;
					}
					break;
				case NAME:
				case 41:
					{
					alt20=2;
					}
					break;
				case 42:
					{
					alt20=3;
					}
					break;
				case 40:
					{
					alt20=4;
					}
					break;
				case 37:
					{
					alt20=5;
					}
					break;
				case 39:
					{
					alt20=6;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 20, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 20, 0, input);
				throw nvae;
			}

			switch (alt20) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:194:8: '(' 'and' ( gd )* ')'
					{
					match(input,10,FOLLOW_10_in_gd617); 
					match(input,33,FOLLOW_33_in_gd619); 
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:194:18: ( gd )*
					loop18:
					while (true) {
						int alt18=2;
						int LA18_0 = input.LA(1);
						if ( (LA18_0==10) ) {
							alt18=1;
						}

						switch (alt18) {
						case 1 :
							// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:194:18: gd
							{
							pushFollow(FOLLOW_gd_in_gd621);
							gd();
							state._fsp--;

							}
							break;

						default :
							break loop18;
						}
					}

					match(input,11,FOLLOW_11_in_gd624); 
					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:195:7: literal_of_term
					{
					pushFollow(FOLLOW_literal_of_term_in_gd632);
					literal_of_term();
					state._fsp--;

					}
					break;
				case 3 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:196:4: '(' 'or' ( gd )* ')'
					{
					match(input,10,FOLLOW_10_in_gd637); 
					match(input,42,FOLLOW_42_in_gd639); 
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:196:13: ( gd )*
					loop19:
					while (true) {
						int alt19=2;
						int LA19_0 = input.LA(1);
						if ( (LA19_0==10) ) {
							alt19=1;
						}

						switch (alt19) {
						case 1 :
							// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:196:13: gd
							{
							pushFollow(FOLLOW_gd_in_gd641);
							gd();
							state._fsp--;

							}
							break;

						default :
							break loop19;
						}
					}

					match(input,11,FOLLOW_11_in_gd644); 
					}
					break;
				case 4 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:198:4: '(' 'imply' gd gd ')'
					{
					match(input,10,FOLLOW_10_in_gd659); 
					match(input,40,FOLLOW_40_in_gd661); 
					pushFollow(FOLLOW_gd_in_gd663);
					gd();
					state._fsp--;

					pushFollow(FOLLOW_gd_in_gd665);
					gd();
					state._fsp--;

					match(input,11,FOLLOW_11_in_gd667); 
					}
					break;
				case 5 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:199:4: '(' 'exists' '(' typed_list_of_variable ')' gd ')'
					{
					match(input,10,FOLLOW_10_in_gd673); 
					match(input,37,FOLLOW_37_in_gd675); 
					match(input,10,FOLLOW_10_in_gd677); 
					pushFollow(FOLLOW_typed_list_of_variable_in_gd679);
					typed_list_of_variable();
					state._fsp--;

					match(input,11,FOLLOW_11_in_gd681); 
					pushFollow(FOLLOW_gd_in_gd683);
					gd();
					state._fsp--;

					match(input,11,FOLLOW_11_in_gd685); 
					}
					break;
				case 6 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:200:4: '(' 'forall' '(' typed_list_of_variable ')' gd ')'
					{
					match(input,10,FOLLOW_10_in_gd691); 
					match(input,39,FOLLOW_39_in_gd693); 
					match(input,10,FOLLOW_10_in_gd695); 
					pushFollow(FOLLOW_typed_list_of_variable_in_gd697);
					typed_list_of_variable();
					state._fsp--;

					match(input,11,FOLLOW_11_in_gd699); 
					pushFollow(FOLLOW_gd_in_gd701);
					gd();
					state._fsp--;

					match(input,11,FOLLOW_11_in_gd703); 
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



	// $ANTLR start "predicate"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:204:1: predicate : NAME ;
	public final void predicate() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:205:2: ( NAME )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:205:4: NAME
			{
			match(input,NAME,FOLLOW_NAME_in_predicate717); 
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
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:209:1: term : ( NAME | VARIABLE );
	public final void term() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:209:7: ( NAME | VARIABLE )
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
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:214:1: literal_of_name : ( atomic_formula_of_name | '(' 'not' atomic_formula_of_name ')' );
	public final void literal_of_name() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:215:2: ( atomic_formula_of_name | '(' 'not' atomic_formula_of_name ')' )
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==10) ) {
				int LA21_1 = input.LA(2);
				if ( (LA21_1==41) ) {
					alt21=2;
				}
				else if ( (LA21_1==NAME) ) {
					alt21=1;
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
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:215:4: atomic_formula_of_name
					{
					pushFollow(FOLLOW_atomic_formula_of_name_in_literal_of_name747);
					atomic_formula_of_name();
					state._fsp--;

					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:216:4: '(' 'not' atomic_formula_of_name ')'
					{
					match(input,10,FOLLOW_10_in_literal_of_name752); 
					match(input,41,FOLLOW_41_in_literal_of_name754); 
					pushFollow(FOLLOW_atomic_formula_of_name_in_literal_of_name756);
					atomic_formula_of_name();
					state._fsp--;

					match(input,11,FOLLOW_11_in_literal_of_name758); 
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
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:219:1: literal_of_term : ( atomic_formula_of_term | '(' 'not' atomic_formula_of_term ')' );
	public final void literal_of_term() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:220:2: ( atomic_formula_of_term | '(' 'not' atomic_formula_of_term ')' )
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==10) ) {
				int LA22_1 = input.LA(2);
				if ( (LA22_1==41) ) {
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
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:220:4: atomic_formula_of_term
					{
					pushFollow(FOLLOW_atomic_formula_of_term_in_literal_of_term769);
					atomic_formula_of_term();
					state._fsp--;

					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:221:4: '(' 'not' atomic_formula_of_term ')'
					{
					match(input,10,FOLLOW_10_in_literal_of_term774); 
					match(input,41,FOLLOW_41_in_literal_of_term776); 
					pushFollow(FOLLOW_atomic_formula_of_term_in_literal_of_term778);
					atomic_formula_of_term();
					state._fsp--;

					match(input,11,FOLLOW_11_in_literal_of_term780); 
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
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:224:1: atomic_formula_of_term : '(' predicate ( term )* ')' ;
	public final void atomic_formula_of_term() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:225:2: ( '(' predicate ( term )* ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:225:4: '(' predicate ( term )* ')'
			{
			match(input,10,FOLLOW_10_in_atomic_formula_of_term791); 
			pushFollow(FOLLOW_predicate_in_atomic_formula_of_term793);
			predicate();
			state._fsp--;

			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:225:18: ( term )*
			loop23:
			while (true) {
				int alt23=2;
				int LA23_0 = input.LA(1);
				if ( (LA23_0==NAME||LA23_0==VARIABLE) ) {
					alt23=1;
				}

				switch (alt23) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:225:18: term
					{
					pushFollow(FOLLOW_term_in_atomic_formula_of_term795);
					term();
					state._fsp--;

					}
					break;

				default :
					break loop23;
				}
			}

			match(input,11,FOLLOW_11_in_atomic_formula_of_term798); 
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
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:228:1: atomic_formula_of_name : '(' predicate ( NAME )* ')' ;
	public final void atomic_formula_of_name() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:229:2: ( '(' predicate ( NAME )* ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:229:4: '(' predicate ( NAME )* ')'
			{
			match(input,10,FOLLOW_10_in_atomic_formula_of_name810); 
			pushFollow(FOLLOW_predicate_in_atomic_formula_of_name812);
			predicate();
			state._fsp--;

			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:229:18: ( NAME )*
			loop24:
			while (true) {
				int alt24=2;
				int LA24_0 = input.LA(1);
				if ( (LA24_0==NAME) ) {
					alt24=1;
				}

				switch (alt24) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:229:18: NAME
					{
					match(input,NAME,FOLLOW_NAME_in_atomic_formula_of_name814); 
					}
					break;

				default :
					break loop24;
				}
			}

			match(input,11,FOLLOW_11_in_atomic_formula_of_name817); 
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
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:232:1: typed_list_of_name : (| ( NAME )+ ( '-' type typed_list_of_name )? );
	public final void typed_list_of_name() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:233:2: (| ( NAME )+ ( '-' type typed_list_of_name )? )
			int alt27=2;
			int LA27_0 = input.LA(1);
			if ( (LA27_0==11) ) {
				alt27=1;
			}
			else if ( (LA27_0==NAME) ) {
				alt27=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 27, 0, input);
				throw nvae;
			}

			switch (alt27) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:234:2: 
					{
					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:234:4: ( NAME )+ ( '-' type typed_list_of_name )?
					{
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:234:4: ( NAME )+
					int cnt25=0;
					loop25:
					while (true) {
						int alt25=2;
						int LA25_0 = input.LA(1);
						if ( (LA25_0==NAME) ) {
							alt25=1;
						}

						switch (alt25) {
						case 1 :
							// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:234:4: NAME
							{
							match(input,NAME,FOLLOW_NAME_in_typed_list_of_name833); 
							}
							break;

						default :
							if ( cnt25 >= 1 ) break loop25;
							EarlyExitException eee = new EarlyExitException(25, input);
							throw eee;
						}
						cnt25++;
					}

					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:234:10: ( '-' type typed_list_of_name )?
					int alt26=2;
					int LA26_0 = input.LA(1);
					if ( (LA26_0==12) ) {
						alt26=1;
					}
					switch (alt26) {
						case 1 :
							// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:234:11: '-' type typed_list_of_name
							{
							match(input,12,FOLLOW_12_in_typed_list_of_name837); 
							pushFollow(FOLLOW_type_in_typed_list_of_name839);
							type();
							state._fsp--;

							pushFollow(FOLLOW_typed_list_of_name_in_typed_list_of_name841);
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
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:237:1: typed_list_of_variable : (| ( VARIABLE )+ ( '-' type typed_list_of_variable )? );
	public final void typed_list_of_variable() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:238:2: (| ( VARIABLE )+ ( '-' type typed_list_of_variable )? )
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( (LA30_0==11) ) {
				alt30=1;
			}
			else if ( (LA30_0==VARIABLE) ) {
				alt30=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 30, 0, input);
				throw nvae;
			}

			switch (alt30) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:239:2: 
					{
					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:239:4: ( VARIABLE )+ ( '-' type typed_list_of_variable )?
					{
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:239:4: ( VARIABLE )+
					int cnt28=0;
					loop28:
					while (true) {
						int alt28=2;
						int LA28_0 = input.LA(1);
						if ( (LA28_0==VARIABLE) ) {
							alt28=1;
						}

						switch (alt28) {
						case 1 :
							// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:239:4: VARIABLE
							{
							match(input,VARIABLE,FOLLOW_VARIABLE_in_typed_list_of_variable859); 
							}
							break;

						default :
							if ( cnt28 >= 1 ) break loop28;
							EarlyExitException eee = new EarlyExitException(28, input);
							throw eee;
						}
						cnt28++;
					}

					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:239:14: ( '-' type typed_list_of_variable )?
					int alt29=2;
					int LA29_0 = input.LA(1);
					if ( (LA29_0==12) ) {
						alt29=1;
					}
					switch (alt29) {
						case 1 :
							// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:239:15: '-' type typed_list_of_variable
							{
							match(input,12,FOLLOW_12_in_typed_list_of_variable863); 
							pushFollow(FOLLOW_type_in_typed_list_of_variable865);
							type();
							state._fsp--;

							pushFollow(FOLLOW_typed_list_of_variable_in_typed_list_of_variable867);
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
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:244:1: type : ( NAME | '(' 'either' ( type )+ ')' | '(' 'fluent' type ')' );
	public final void type() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:244:7: ( NAME | '(' 'either' ( type )+ ')' | '(' 'fluent' type ')' )
			int alt32=3;
			int LA32_0 = input.LA(1);
			if ( (LA32_0==NAME) ) {
				alt32=1;
			}
			else if ( (LA32_0==10) ) {
				int LA32_2 = input.LA(2);
				if ( (LA32_2==36) ) {
					alt32=2;
				}
				else if ( (LA32_2==38) ) {
					alt32=3;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 32, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 32, 0, input);
				throw nvae;
			}

			switch (alt32) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:244:9: NAME
					{
					match(input,NAME,FOLLOW_NAME_in_type883); 
					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:245:4: '(' 'either' ( type )+ ')'
					{
					match(input,10,FOLLOW_10_in_type888); 
					match(input,36,FOLLOW_36_in_type890); 
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:245:17: ( type )+
					int cnt31=0;
					loop31:
					while (true) {
						int alt31=2;
						int LA31_0 = input.LA(1);
						if ( (LA31_0==NAME||LA31_0==10) ) {
							alt31=1;
						}

						switch (alt31) {
						case 1 :
							// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:245:17: type
							{
							pushFollow(FOLLOW_type_in_type892);
							type();
							state._fsp--;

							}
							break;

						default :
							if ( cnt31 >= 1 ) break loop31;
							EarlyExitException eee = new EarlyExitException(31, input);
							throw eee;
						}
						cnt31++;
					}

					match(input,11,FOLLOW_11_in_type895); 
					}
					break;
				case 3 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:246:4: '(' 'fluent' type ')'
					{
					match(input,10,FOLLOW_10_in_type900); 
					match(input,38,FOLLOW_38_in_type902); 
					pushFollow(FOLLOW_type_in_type904);
					type();
					state._fsp--;

					match(input,11,FOLLOW_11_in_type906); 
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



	// $ANTLR start "action_spec_od_action_term"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:252:1: action_spec_od_action_term : general_tree ;
	public final void action_spec_od_action_term() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:253:2: ( general_tree )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:253:4: general_tree
			{
			pushFollow(FOLLOW_general_tree_in_action_spec_od_action_term921);
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



	// $ANTLR start "domain_var_declaration"
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:260:1: domain_var_declaration : ( NAME | '(' NAME NAME ')' );
	public final void domain_var_declaration() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:261:2: ( NAME | '(' NAME NAME ')' )
			int alt33=2;
			int LA33_0 = input.LA(1);
			if ( (LA33_0==NAME) ) {
				alt33=1;
			}
			else if ( (LA33_0==10) ) {
				alt33=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 33, 0, input);
				throw nvae;
			}

			switch (alt33) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:261:4: NAME
					{
					match(input,NAME,FOLLOW_NAME_in_domain_var_declaration938); 
					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:262:4: '(' NAME NAME ')'
					{
					match(input,10,FOLLOW_10_in_domain_var_declaration943); 
					match(input,NAME,FOLLOW_NAME_in_domain_var_declaration945); 
					match(input,NAME,FOLLOW_NAME_in_domain_var_declaration947); 
					match(input,11,FOLLOW_11_in_domain_var_declaration949); 
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
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:265:1: typed_list_of_domain_var_declaration : (| ( domain_var_declaration )+ ( '-' type typed_list_of_domain_var_declaration )? );
	public final void typed_list_of_domain_var_declaration() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:266:2: (| ( domain_var_declaration )+ ( '-' type typed_list_of_domain_var_declaration )? )
			int alt36=2;
			int LA36_0 = input.LA(1);
			if ( (LA36_0==11) ) {
				alt36=1;
			}
			else if ( (LA36_0==NAME||LA36_0==10) ) {
				alt36=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 36, 0, input);
				throw nvae;
			}

			switch (alt36) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:267:2: 
					{
					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:267:4: ( domain_var_declaration )+ ( '-' type typed_list_of_domain_var_declaration )?
					{
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:267:4: ( domain_var_declaration )+
					int cnt34=0;
					loop34:
					while (true) {
						int alt34=2;
						int LA34_0 = input.LA(1);
						if ( (LA34_0==NAME||LA34_0==10) ) {
							alt34=1;
						}

						switch (alt34) {
						case 1 :
							// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:267:4: domain_var_declaration
							{
							pushFollow(FOLLOW_domain_var_declaration_in_typed_list_of_domain_var_declaration965);
							domain_var_declaration();
							state._fsp--;

							}
							break;

						default :
							if ( cnt34 >= 1 ) break loop34;
							EarlyExitException eee = new EarlyExitException(34, input);
							throw eee;
						}
						cnt34++;
					}

					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:267:28: ( '-' type typed_list_of_domain_var_declaration )?
					int alt35=2;
					int LA35_0 = input.LA(1);
					if ( (LA35_0==12) ) {
						alt35=1;
					}
					switch (alt35) {
						case 1 :
							// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:267:29: '-' type typed_list_of_domain_var_declaration
							{
							match(input,12,FOLLOW_12_in_typed_list_of_domain_var_declaration969); 
							pushFollow(FOLLOW_type_in_typed_list_of_domain_var_declaration971);
							type();
							state._fsp--;

							pushFollow(FOLLOW_typed_list_of_domain_var_declaration_in_typed_list_of_domain_var_declaration973);
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
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:274:1: general_tree : '(' ( general_tree_item )* ')' ;
	public final void general_tree() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:275:2: ( '(' ( general_tree_item )* ')' )
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:275:4: '(' ( general_tree_item )* ')'
			{
			match(input,10,FOLLOW_10_in_general_tree990); 
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:275:8: ( general_tree_item )*
			loop37:
			while (true) {
				int alt37=2;
				int LA37_0 = input.LA(1);
				if ( ((LA37_0 >= INTEGER && LA37_0 <= VARIABLE)||LA37_0==10||LA37_0==33||LA37_0==41) ) {
					alt37=1;
				}

				switch (alt37) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:275:8: general_tree_item
					{
					pushFollow(FOLLOW_general_tree_item_in_general_tree992);
					general_tree_item();
					state._fsp--;

					}
					break;

				default :
					break loop37;
				}
			}

			match(input,11,FOLLOW_11_in_general_tree995); 
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
	// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:278:1: general_tree_item : ( NAME | INTEGER | VARIABLE | REQUIRE_KEY | 'and' | 'not' | general_tree );
	public final void general_tree_item() throws RecognitionException {
		try {
			// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:279:2: ( NAME | INTEGER | VARIABLE | REQUIRE_KEY | 'and' | 'not' | general_tree )
			int alt38=7;
			switch ( input.LA(1) ) {
			case NAME:
				{
				alt38=1;
				}
				break;
			case INTEGER:
				{
				alt38=2;
				}
				break;
			case VARIABLE:
				{
				alt38=3;
				}
				break;
			case REQUIRE_KEY:
				{
				alt38=4;
				}
				break;
			case 33:
				{
				alt38=5;
				}
				break;
			case 41:
				{
				alt38=6;
				}
				break;
			case 10:
				{
				alt38=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 38, 0, input);
				throw nvae;
			}
			switch (alt38) {
				case 1 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:279:4: NAME
					{
					match(input,NAME,FOLLOW_NAME_in_general_tree_item1007); 
					}
					break;
				case 2 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:280:4: INTEGER
					{
					match(input,INTEGER,FOLLOW_INTEGER_in_general_tree_item1012); 
					}
					break;
				case 3 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:281:4: VARIABLE
					{
					match(input,VARIABLE,FOLLOW_VARIABLE_in_general_tree_item1017); 
					}
					break;
				case 4 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:282:4: REQUIRE_KEY
					{
					match(input,REQUIRE_KEY,FOLLOW_REQUIRE_KEY_in_general_tree_item1022); 
					}
					break;
				case 5 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:283:4: 'and'
					{
					match(input,33,FOLLOW_33_in_general_tree_item1028); 
					}
					break;
				case 6 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:284:4: 'not'
					{
					match(input,41,FOLLOW_41_in_general_tree_item1033); 
					}
					break;
				case 7 :
					// /home/tomek/Projekty/PUT/GUI4PDDL/pl.poznan.put.cs.gui4pddl/src/pl/poznan/put/cs/gui4pddl/parser/PDDL.g:285:4: general_tree
					{
					pushFollow(FOLLOW_general_tree_in_general_tree_item1038);
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

	// Delegated rules



	public static final BitSet FOLLOW_10_in_definition33 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_definition35 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_problem_header_in_definition37 = new BitSet(new long[]{0x0000000000000C00L});
	public static final BitSet FOLLOW_problem_item_in_definition39 = new BitSet(new long[]{0x0000000000000C00L});
	public static final BitSet FOLLOW_11_in_definition42 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_definition47 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_definition49 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_domain_header_in_definition51 = new BitSet(new long[]{0x0000000000000C00L});
	public static final BitSet FOLLOW_domain_item_in_definition53 = new BitSet(new long[]{0x0000000000000C00L});
	public static final BitSet FOLLOW_11_in_definition56 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_domain_header71 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_domain_header73 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_NAME_in_domain_header75 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_domain_header77 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_extension_def_in_domain_item88 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_require_def_in_domain_item93 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_types_def_in_domain_item98 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constants_def_in_domain_item105 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_domain_vars_def_in_domain_item110 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_predicates_def_in_domain_item116 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_timeless_def_in_domain_item121 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_safety_def_in_domain_item126 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_structure_def_in_domain_item132 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_extension_def145 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_extension_def147 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_NAME_in_extension_def149 = new BitSet(new long[]{0x0000000000000840L});
	public static final BitSet FOLLOW_11_in_extension_def152 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_types_def165 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_types_def167 = new BitSet(new long[]{0x0000000000000840L});
	public static final BitSet FOLLOW_typed_list_of_name_in_types_def169 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_types_def171 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_constants_def183 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_constants_def185 = new BitSet(new long[]{0x0000000000000840L});
	public static final BitSet FOLLOW_typed_list_of_name_in_constants_def187 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_constants_def189 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_domain_vars_def200 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_domain_vars_def202 = new BitSet(new long[]{0x0000000000000C40L});
	public static final BitSet FOLLOW_typed_list_of_domain_var_declaration_in_domain_vars_def204 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_domain_vars_def206 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_predicates_def218 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_26_in_predicates_def220 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_atomic_formula_skeleton_in_predicates_def222 = new BitSet(new long[]{0x0000000000000C00L});
	public static final BitSet FOLLOW_11_in_predicates_def225 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_timeless_def236 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_timeless_def238 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_literal_of_name_in_timeless_def240 = new BitSet(new long[]{0x0000000000000C00L});
	public static final BitSet FOLLOW_11_in_timeless_def243 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_safety_def256 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_safety_def258 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_gd_in_safety_def260 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_safety_def262 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_action_def_in_structure_def275 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_axiom_def_in_structure_def280 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_method_def_in_structure_def286 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_action_def302 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_action_def304 = new BitSet(new long[]{0x0000020200000DE0L});
	public static final BitSet FOLLOW_general_tree_item_in_action_def306 = new BitSet(new long[]{0x0000020200000DE0L});
	public static final BitSet FOLLOW_11_in_action_def309 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_axiom_def325 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_axiom_def327 = new BitSet(new long[]{0x0000020200000DE0L});
	public static final BitSet FOLLOW_general_tree_item_in_axiom_def329 = new BitSet(new long[]{0x0000020200000DE0L});
	public static final BitSet FOLLOW_11_in_axiom_def332 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_method_def346 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_method_def348 = new BitSet(new long[]{0x0000020200000DE0L});
	public static final BitSet FOLLOW_general_tree_item_in_method_def350 = new BitSet(new long[]{0x0000020200000DE0L});
	public static final BitSet FOLLOW_11_in_method_def353 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_atomic_formula_skeleton368 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_predicate_in_atomic_formula_skeleton370 = new BitSet(new long[]{0x0000000000000900L});
	public static final BitSet FOLLOW_typed_list_of_variable_in_atomic_formula_skeleton372 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_atomic_formula_skeleton374 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_problem_header392 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_problem_header394 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_NAME_in_problem_header396 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_problem_header398 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_domain_reference_in_problem_item412 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_require_def_in_problem_item417 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_situation_in_problem_item422 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_object_declaration_in_problem_item427 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_init_in_problem_item432 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_goal_in_problem_item437 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_length_spec_in_problem_item442 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_domain_reference454 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_domain_reference456 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_NAME_in_domain_reference458 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_domain_reference460 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_require_def472 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_require_def474 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_REQUIRE_KEY_in_require_def476 = new BitSet(new long[]{0x0000000000000880L});
	public static final BitSet FOLLOW_11_in_require_def479 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_situation492 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_situation494 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_NAME_in_situation496 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_situation498 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_object_declaration511 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_object_declaration513 = new BitSet(new long[]{0x0000000000000840L});
	public static final BitSet FOLLOW_typed_list_of_name_in_object_declaration515 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_object_declaration517 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_init528 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_init530 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_literal_of_name_in_init532 = new BitSet(new long[]{0x0000000000000C00L});
	public static final BitSet FOLLOW_11_in_init535 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_goal545 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_20_in_goal547 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_gd_in_goal549 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_goal551 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_goal556 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_goal558 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_action_spec_od_action_term_in_goal560 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_goal562 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_length_spec576 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_length_spec578 = new BitSet(new long[]{0x0000000000000C00L});
	public static final BitSet FOLLOW_10_in_length_spec581 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_29_in_length_spec583 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_INTEGER_in_length_spec585 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_length_spec587 = new BitSet(new long[]{0x0000000000000C00L});
	public static final BitSet FOLLOW_10_in_length_spec592 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_25_in_length_spec594 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_INTEGER_in_length_spec596 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_length_spec598 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_length_spec602 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_gd617 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_gd619 = new BitSet(new long[]{0x0000000000000C00L});
	public static final BitSet FOLLOW_gd_in_gd621 = new BitSet(new long[]{0x0000000000000C00L});
	public static final BitSet FOLLOW_11_in_gd624 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_literal_of_term_in_gd632 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_gd637 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_42_in_gd639 = new BitSet(new long[]{0x0000000000000C00L});
	public static final BitSet FOLLOW_gd_in_gd641 = new BitSet(new long[]{0x0000000000000C00L});
	public static final BitSet FOLLOW_11_in_gd644 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_gd659 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_gd661 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_gd_in_gd663 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_gd_in_gd665 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_gd667 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_gd673 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_gd675 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_gd677 = new BitSet(new long[]{0x0000000000000900L});
	public static final BitSet FOLLOW_typed_list_of_variable_in_gd679 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_gd681 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_gd_in_gd683 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_gd685 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_gd691 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_39_in_gd693 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_gd695 = new BitSet(new long[]{0x0000000000000900L});
	public static final BitSet FOLLOW_typed_list_of_variable_in_gd697 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_gd699 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_gd_in_gd701 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_gd703 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_predicate717 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomic_formula_of_name_in_literal_of_name747 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_literal_of_name752 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_41_in_literal_of_name754 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_atomic_formula_of_name_in_literal_of_name756 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_literal_of_name758 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomic_formula_of_term_in_literal_of_term769 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_literal_of_term774 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_41_in_literal_of_term776 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_atomic_formula_of_term_in_literal_of_term778 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_literal_of_term780 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_atomic_formula_of_term791 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_predicate_in_atomic_formula_of_term793 = new BitSet(new long[]{0x0000000000000940L});
	public static final BitSet FOLLOW_term_in_atomic_formula_of_term795 = new BitSet(new long[]{0x0000000000000940L});
	public static final BitSet FOLLOW_11_in_atomic_formula_of_term798 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_atomic_formula_of_name810 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_predicate_in_atomic_formula_of_name812 = new BitSet(new long[]{0x0000000000000840L});
	public static final BitSet FOLLOW_NAME_in_atomic_formula_of_name814 = new BitSet(new long[]{0x0000000000000840L});
	public static final BitSet FOLLOW_11_in_atomic_formula_of_name817 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_typed_list_of_name833 = new BitSet(new long[]{0x0000000000001042L});
	public static final BitSet FOLLOW_12_in_typed_list_of_name837 = new BitSet(new long[]{0x0000000000000440L});
	public static final BitSet FOLLOW_type_in_typed_list_of_name839 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_typed_list_of_name_in_typed_list_of_name841 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VARIABLE_in_typed_list_of_variable859 = new BitSet(new long[]{0x0000000000001102L});
	public static final BitSet FOLLOW_12_in_typed_list_of_variable863 = new BitSet(new long[]{0x0000000000000440L});
	public static final BitSet FOLLOW_type_in_typed_list_of_variable865 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_typed_list_of_variable_in_typed_list_of_variable867 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_type883 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_type888 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_type890 = new BitSet(new long[]{0x0000000000000440L});
	public static final BitSet FOLLOW_type_in_type892 = new BitSet(new long[]{0x0000000000000C40L});
	public static final BitSet FOLLOW_11_in_type895 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_type900 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_type902 = new BitSet(new long[]{0x0000000000000440L});
	public static final BitSet FOLLOW_type_in_type904 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_type906 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_general_tree_in_action_spec_od_action_term921 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_domain_var_declaration938 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_domain_var_declaration943 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_NAME_in_domain_var_declaration945 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_NAME_in_domain_var_declaration947 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_domain_var_declaration949 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_domain_var_declaration_in_typed_list_of_domain_var_declaration965 = new BitSet(new long[]{0x0000000000001442L});
	public static final BitSet FOLLOW_12_in_typed_list_of_domain_var_declaration969 = new BitSet(new long[]{0x0000000000000440L});
	public static final BitSet FOLLOW_type_in_typed_list_of_domain_var_declaration971 = new BitSet(new long[]{0x0000000000000440L});
	public static final BitSet FOLLOW_typed_list_of_domain_var_declaration_in_typed_list_of_domain_var_declaration973 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_general_tree990 = new BitSet(new long[]{0x0000020200000DE0L});
	public static final BitSet FOLLOW_general_tree_item_in_general_tree992 = new BitSet(new long[]{0x0000020200000DE0L});
	public static final BitSet FOLLOW_11_in_general_tree995 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_general_tree_item1007 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_general_tree_item1012 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VARIABLE_in_general_tree_item1017 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_REQUIRE_KEY_in_general_tree_item1022 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_33_in_general_tree_item1028 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_41_in_general_tree_item1033 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_general_tree_in_general_tree_item1038 = new BitSet(new long[]{0x0000000000000002L});
}
