package pl.poznan.put.cs.gui4pddl.codemodel;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class PDDLFile {
	
	private String path;
	private Map<String, PDDLDomain> domains = new TreeMap<String, PDDLDomain>();
	
	public PDDLFile(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}

	public PDDLDomain getOrCreateDomain(String name) {
		PDDLDomain domain = domains.get(name);
		if (domain == null) {
			domain = new PDDLDomain(name);
			domains.put(name, domain);
		}
		return domain;
	}
	
	public void clear() {
		domains.clear();
	}
	
	public Iterable<PDDLDomain> getDomains() {
		return new LinkedList<PDDLDomain>(domains.values());
	}
}
