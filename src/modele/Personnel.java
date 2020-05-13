package modele;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = {"matricule"})
public class Personnel {

	private int matricule;
	private String nom;
	private String categorie;
	private String fonction;
	
	public Personnel(int matricule, String nom, String categorie, String fonction) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.categorie = categorie;
		this.fonction = fonction;
	}

	public int getMatricule() {
		return matricule;
	}

	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	
	
	
	
}
