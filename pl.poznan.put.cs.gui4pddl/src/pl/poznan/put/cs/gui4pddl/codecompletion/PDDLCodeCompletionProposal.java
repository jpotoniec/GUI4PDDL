package pl.poznan.put.cs.gui4pddl.codecompletion;

public class PDDLCodeCompletionProposal implements Comparable<PDDLCodeCompletionProposal>{
	
	private String text;
	private String description;
	
	public PDDLCodeCompletionProposal(String text) {
		this.text = text;
	}
	
	public PDDLCodeCompletionProposal(String text, String description) {
		this.text = text;
		this.description = description;
	}
	
	public String getText() {
		return text;
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean getInvalid() {
		return false;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public int compareTo(PDDLCodeCompletionProposal o) {
		return text.compareTo(o.text);
	}
}
