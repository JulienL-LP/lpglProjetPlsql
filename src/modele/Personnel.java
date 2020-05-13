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

}
