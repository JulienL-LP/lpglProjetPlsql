package modele;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = {"noVol"})
public class Vol {

	private String noVol;
	private String depart;
	private String arrivee;
	
	public Vol(String noVol, String depart, String arrivee) {
		super();
		this.noVol = noVol;
		this.depart = depart;
		this.arrivee = arrivee;
	}

	public String getNoVol() {
		return noVol;
	}

	public void setNoVol(String noVol) {
		this.noVol = noVol;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getArrivee() {
		return arrivee;
	}

	public void setArrivee(String arrivee) {
		this.arrivee = arrivee;
	}
	
	
	
	
}
