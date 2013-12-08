package pl.poznan.put.cs.gui4pddl.codemodel;

public class PDDLInitialSituation {
	private String name;
	private String domain;
	private PDDLTypedList objects = new PDDLTypedList();
	
	public PDDLInitialSituation(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void addDomain(String name) {
		domain = name;
	}
	
	public String getDomainName() {
		return domain;
	}
	
	public PDDLTypedList getObjects() {
		return objects;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domain == null) ? 0 : domain.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((objects == null) ? 0 : objects.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PDDLInitialSituation other = (PDDLInitialSituation) obj;
		if (domain == null) {
			if (other.domain != null)
				return false;
		} else if (!domain.equals(other.domain))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (objects == null) {
			if (other.objects != null)
				return false;
		} else if (!objects.equals(other.objects))
			return false;
		return true;
	}
}
