package aeroportjpa.model;

public enum Titre {
	TP("titre physique"), TM("titre moral");

	private String label;

	private Titre (String label) {
		this.label=label;
	}

	public String getLabel() {
		return label;
	}
}
