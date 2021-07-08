package fr.eni.bo;

import java.util.Date;

public class Stagiaire {

	private int id;
	private String nom;
	private String prenom;
	
	private Date dateDeNaissance;
	private String motDepasse;
	
	public Stagiaire() {
	}

	public Stagiaire(String nom, String prenom, Date dateDeNaissance, String motDepasse) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.motDepasse = motDepasse;
	}


	public Stagiaire(int id, String nom, String prenom, Date dateDeNaissance, String motDepasse) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.motDepasse = motDepasse;
	}





	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	public String getMotDepasse() {
		return motDepasse;
	}
	public void setMotDepasse(String motDepasse) {
		this.motDepasse = motDepasse;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Stagiaire [id=");
		builder.append(id);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", dateDeNaissance=");
		builder.append(dateDeNaissance);
		builder.append(", motDepasse=");
		builder.append(motDepasse);
		builder.append("]");
		return builder.toString();
	}
	
	
}
