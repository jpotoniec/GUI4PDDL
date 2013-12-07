package pl.poznan.put.cs.gui4pddl.codecompletion;

public class PDDLCodeCompletionProposal {
	
	private String text;
	
	public PDDLCodeCompletionProposal(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
}
