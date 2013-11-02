package pl.poznan.put.cs.gui4pddl.codemodel;

public class PDDLCodeOutline {
	public String getOutline(PDDLCodeModel model) {
		String files = "";
		for(PDDLFile file : model.getFiles()) {
			files += getOutline(file);
		}
		return String.format("(:model %s)", files);
	}
	
	public String getOutline(PDDLFile file) {
		String domains = "";
		for(PDDLDomain domain: file.getDomains()) {
			domains += getOutline(domain);
		}
		domains = String.format("(:domains %s)", domains);
		return String.format("(:file %s %s)", file.getPath(), domains);
	}
	
	public String getOutline(PDDLDomain domain) {
		return String.format("(:domain %s)", domain.getName());
	}
}
