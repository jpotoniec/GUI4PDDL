package pl.poznan.put.cs.gui4pddl.codemodel;

public class PDDLProblem {
	private String name;
	private String domain;
	private PDDLRequirementSet requirements = new PDDLRequirementSet();
	private String situation;
	private PDDLTypedList objects = new PDDLTypedList();
	
	public PDDLProblem(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void addDomain(String name) {
		domain = name;
	}
	
	public String getDomain(String name) {
		return domain;
	}
	
	public void addRequirement(String name) {
		requirements.add(name);
	}
	
	public PDDLRequirementSet getRequirementSet() {
		return requirements;
	}
	
	public void addSituation(String name) {
		situation = name;
	}
	
	public String getSituation() {
		return situation;
	}
	
	public void addObjects(PDDLTypedList list) {
		objects.append(list);
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
		result = prime * result
				+ ((requirements == null) ? 0 : requirements.hashCode());
		result = prime * result
				+ ((situation == null) ? 0 : situation.hashCode());
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
		PDDLProblem other = (PDDLProblem) obj;
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
		if (requirements == null) {
			if (other.requirements != null)
				return false;
		} else if (!requirements.equals(other.requirements))
			return false;
		if (situation == null) {
			if (other.situation != null)
				return false;
		} else if (!situation.equals(other.situation))
			return false;
		return true;
	}
}
